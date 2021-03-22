package com.whty.zd.appstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.whty.zd.appstore.di.module.ActivityModule;
import com.whty.zd.appstore.di.scope.ContextLife;
import com.whty.zd.appstore.di.scope.PerActivity;
import com.whty.zd.appstore.mvp.view.activity.AppDetailActivity;
import com.whty.zd.appstore.mvp.view.activity.CategoryNecessaryActivity;
import com.whty.zd.appstore.mvp.view.activity.CategoryNewActivity;
import com.whty.zd.appstore.mvp.view.activity.CategorySubjectActivity;
import com.whty.zd.appstore.mvp.view.activity.CategorySubscribeActivity;
import com.whty.zd.appstore.mvp.view.activity.CategoryToolActivity;
import com.whty.zd.appstore.mvp.view.activity.HomeActivity;

import dagger.Component;

/**
 * @author: wangwei
 * @date: 2017/7/30 16:11
 * @desciption:
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(HomeActivity activity);

    void inject(AppDetailActivity activity);

    void inject(CategoryToolActivity activity);

    void inject(CategorySubscribeActivity activity);

    void inject(CategoryNecessaryActivity activity);

    void inject(CategoryNewActivity activity);

    void inject(CategorySubjectActivity activity);
}
