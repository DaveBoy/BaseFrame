package com.daveboy.frame.mvp.constract;

import android.app.Activity;

import com.daveboy.frame.baseframe.base.DefaultAdapter;
import com.daveboy.frame.baseframe.mvp.BaseModel;
import com.daveboy.frame.baseframe.mvp.IModel;
import com.daveboy.frame.baseframe.mvp.IView;
import com.daveboy.frame.mvp.module.entity.User;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import io.reactivex.Observable;

/**
 * 此框架无需定义Presenter接口,所以Contract只定义Model和View的接口
 */
public interface UserContract {
    interface UserView extends IView{
        void startLoadMore();
        void endLoadMore();
        Activity getActivity();
        //申请权限
        RxPermissions getRxPermissions();
    }
    interface UserModel extends IModel{
        Observable<List<User>> getUsers(int lastIdQueried, boolean update);
    }
}
