package com.daveboy.frame.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.daveboy.frame.baseframe.base.BaseActivity;
import com.daveboy.frame.baseframe.base.DefaultAdapter;
import com.daveboy.frame.baseframe.di.component.AppComponent;
import com.daveboy.frame.mvp.constract.UserContract;
import com.daveboy.frame.mvp.module.UserModel;
import com.daveboy.frame.mvp.presenter.UserPresenter;

public class UserActivity extends BaseActivity<UserPresenter> implements UserContract.UserView,SwipeRefreshLayout.OnRefreshListener {
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerUserComponent
                .builder()
                .appComponent(appComponent)
                .userModule(new UserModel(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return 0;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void setAdapter(DefaultAdapter adapter) {

    }

    @Override
    public void startLoadMore() {

    }

    @Override
    public void endLoadMore() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    @Override
    public void onRefresh() {

    }
}
