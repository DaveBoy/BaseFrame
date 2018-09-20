package com.daveboy.frame.di.module;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.daveboy.frame.R;
import com.daveboy.frame.baseframe.di.scope.ActivityScope;
import com.daveboy.frame.baseframe.http.imageloader.ImageConfig;
import com.daveboy.frame.baseframe.http.imageloader.ImageLoader;
import com.daveboy.frame.baseframe.http.imageloader.glide.ImageConfigImpl;
import com.daveboy.frame.baseframe.utils.ArmsUtils;
import com.daveboy.frame.mvp.constract.UserContract;
import com.daveboy.frame.mvp.module.UserModel;
import com.daveboy.frame.mvp.module.entity.User;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    private UserContract.UserView mUserView;

    public UserModule(UserContract.UserView mUserView) {
        this.mUserView = mUserView;
    }

    /**
     * 业务需要
     * @return
     */
    @ActivityScope
    @Provides
    RxPermissions getRxPermissions(){
        return  new RxPermissions(this.mUserView.getActivity());
    }
    @ActivityScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new GridLayoutManager(mUserView.getActivity(), 2);
    }
    @ActivityScope
    @Provides
    RecyclerView.Adapter provideAdapter(List<User> list) {
        return new BaseQuickAdapter<User,BaseViewHolder>(R.layout.app_recycle_item,list) {
            @Override
            protected void convert(BaseViewHolder helper, User item) {
                helper.setText(R.id.tv_name,item.getLogin());
                ArmsUtils.obtainAppComponentFromContext(helper.itemView.getContext()).imageLoader().loadImage(helper.itemView.getContext(),ImageConfigImpl.builder().url(item.getAvatarUrl()).imageView(helper.getView(R.id.iv_avatar)).build());
            }
        };
    }
    @ActivityScope
    @Provides
    List<User> provideUserList() {
        return new ArrayList<>();
    }

    /**
     * 架构需要
     * @param model
     * @return
     */
    @ActivityScope
    @Provides
    UserContract.UserModel provideUserModel(UserModel model) {
        return model;
    }
    @ActivityScope
    @Provides
    UserContract.UserView provideUserView() {
        return mUserView;
    }

}
