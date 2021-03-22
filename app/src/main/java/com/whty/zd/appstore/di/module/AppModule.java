package com.whty.zd.appstore.di.module;

import android.content.Context;

import com.whty.zd.appstore.base.StoreApplication;

import dagger.Module;
import dagger.Provides;
import com.whty.zd.appstore.di.scope.ContextLife;
import com.whty.zd.appstore.di.scope.PerApp;

/**
 * @author: wangwei
 * @date: 2017/7/30 15:32
 * @desciption:
 */
@Module
public class AppModule {

    private StoreApplication mStoreApplication;

    public AppModule(StoreApplication storeApplication) {
        this.mStoreApplication = storeApplication;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideAppContext(){
        return mStoreApplication.getApplicationContext();
    }
}
