package com.whty.zd.appstore.base;

import android.os.Handler;

import com.whty.zd.appstore.BuildConfig;
import com.whty.zd.appstore.di.component.AppComponent;
import com.whty.zd.appstore.di.component.DaggerAppComponent;
import com.whty.zd.appstore.di.module.AppModule;
import com.whty.zd.smartpos.library.rxretrofit.RxRetrofitApp;
import com.whty.zd.smartpos.library.recyclerview.App;

/**
 * @author: wangwei
 * @date: 2017/7/20 22:59
 * @desciption:
 */

public class StoreApplication extends App {

    private static StoreApplication context;
    private static Handler mHandler;
    private static int mMainThreadId;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mHandler = new Handler();
        initApplicationComponent();
        RxRetrofitApp.init(this, BuildConfig.DEBUG);
    }

    public static StoreApplication getContext() {
        return context;
    }

    private void initApplicationComponent() {//Dagger2
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    /**
     * 返回主线程的tid
     *
     * @return
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 返回Handler
     *
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }
}
