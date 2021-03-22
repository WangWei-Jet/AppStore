package com.whty.zd.appstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.whty.zd.appstore.di.module.FragmentModule;
import com.whty.zd.appstore.di.scope.ContextLife;
import com.whty.zd.appstore.di.scope.PerFragment;
import com.whty.zd.appstore.mvp.view.fragment.AppCommentFragment;
import com.whty.zd.appstore.mvp.view.fragment.AppIntroductionFragment;
import com.whty.zd.appstore.mvp.view.fragment.AppManagerFragment;
import com.whty.zd.appstore.mvp.view.fragment.AppRecommendFragment;
import com.whty.zd.appstore.mvp.view.fragment.CategoryFragment;
import com.whty.zd.appstore.mvp.view.fragment.MyFragment;
import com.whty.zd.appstore.mvp.view.fragment.RecommendFragment;
import com.whty.zd.appstore.mvp.view.fragment.TopFragment;

import dagger.Component;

/**
 * @author: wangwei
 * @date: 2017/7/30 16:18
 * @desciption:
 */
@PerFragment
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(RecommendFragment fragment);

    void inject(CategoryFragment fragment);

    void inject(TopFragment fragment);

    void inject(MyFragment fragment);

    void inject(AppManagerFragment fragment);

    void inject(AppIntroductionFragment fragment);

    void inject(AppCommentFragment fragment);

    void inject(AppRecommendFragment fragment);
}
