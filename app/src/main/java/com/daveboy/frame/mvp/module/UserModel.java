package com.daveboy.frame.mvp.module;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;

import com.daveboy.frame.baseframe.di.scope.ActivityScope;
import com.daveboy.frame.baseframe.integration.IRepositoryManager;
import com.daveboy.frame.baseframe.mvp.BaseModel;
import com.daveboy.frame.mvp.constract.UserContract;
import com.daveboy.frame.mvp.module.api.CommonCache;
import com.daveboy.frame.mvp.module.api.UserService;
import com.daveboy.frame.mvp.module.entity.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;
import timber.log.Timber;

@ActivityScope
public class UserModel extends BaseModel implements UserContract.UserModel {
    public static final int USERS_PER_PAGE = 10;
    @Inject
    public UserModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<User>> getUsers(final int lastIdQueried, final boolean update) {
        return Observable.just(mRepositoryManager
                .obtainRetrofitService(UserService.class)
                .getUsers(lastIdQueried,USERS_PER_PAGE))
                .flatMap(new Function<Observable<List<User>>,ObservableSource<List<User>>>(){

                    @Override
                    public ObservableSource<List<User>> apply(Observable<List<User>> listObservable) {
                        return mRepositoryManager.obtainCacheService(CommonCache.class).getUsers(listObservable,new DynamicKey(lastIdQueried),new EvictDynamicKey(update)).map(new Function<Reply<List<User>>, List<User>>(){
                            @Override
                            public List<User> apply(Reply<List<User>> listReply)  {
                                return listReply.getData();
                            }
                        });
                    }
                }
        );
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        Timber.d("ON_PAUSE:Release Resource");
    }
}
