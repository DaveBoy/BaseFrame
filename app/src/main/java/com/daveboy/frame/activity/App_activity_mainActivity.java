package com.daveboy.frame.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.daveboy.frame.R;
import com.daveboy.frame.baseframe.base.BaseActivity;
import com.daveboy.frame.baseframe.di.component.AppComponent;
import com.daveboy.frame.baseframe.utils.ArmsUtils;
import com.daveboy.frame.mvp.ui.activity.UserActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class App_activity_mainActivity extends BaseActivity {

    @BindView(R.id.app_main_txt)
    TextView app_main_txt;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.app_activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.app_main_txt_top, R.id.app_main_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_main_txt_top:
                break;
            case R.id.app_main_txt:
                ArmsUtils.startActivity(UserActivity.class);
                break;
        }
    }
}
