package com.daveboy.frame.di.component;

import com.daveboy.frame.baseframe.di.component.AppComponent;
import com.daveboy.frame.baseframe.di.scope.ActivityScope;
import com.daveboy.frame.di.module.UserModule;
import com.daveboy.frame.mvp.ui.activity.UserActivity;

import dagger.Component;

@ActivityScope
@Component(modules = UserModule.class,dependencies =  AppComponent.class)
public interface UserComponent {
    void inject(UserActivity userActivity);
}
