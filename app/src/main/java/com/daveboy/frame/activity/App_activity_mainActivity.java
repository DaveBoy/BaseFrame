package com.daveboy.frame.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.daveboy.frame.R;

public class App_activity_mainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);

    }

}
