package com.whty.zd.appstore.di.component;

import android.content.Context;

import dagger.Component;
import com.whty.zd.appstore.di.module.AppModule;
import com.whty.zd.appstore.di.scope.ContextLife;
import com.whty.zd.appstore.di.scope.PerApp;

/**
 * @author: wangwei
 * @date: 2017/7/30 16:02
 * @desciption: 提供全局单例的Context对象
 */
@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    Context getApplicationContext();
}
