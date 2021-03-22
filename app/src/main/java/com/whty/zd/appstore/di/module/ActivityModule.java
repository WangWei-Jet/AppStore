package com.whty.zd.appstore.di.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import com.whty.zd.appstore.di.scope.ContextLife;
import com.whty.zd.appstore.di.scope.PerActivity;

/**
 * @author: wangwei
 * @date: 2017/7/30 15:38
 * @desciption:
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mActivity;
    }
}
