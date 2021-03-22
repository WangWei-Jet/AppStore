package com.whty.zd.appstore.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.Toast;

import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.base.mvpbase.BaseView;

import com.whty.zd.appstore.di.component.ActivityComponent;
import com.whty.zd.appstore.di.component.DaggerActivityComponent;
import com.whty.zd.appstore.di.module.ActivityModule;

/**
 * @author: wangwei
 * @date: 2017/7/30 16:41
 * @desciption: Activity实现MVP的基类
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    protected ActivityComponent mActivityComponent;
    protected T mPresenter;
    //通过Dagger2注入的是 presenter

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent();
        mPresenter = initInjector();
        //绑定view
        mPresenter.attachView(this);
        initData();
    }

    public void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((StoreApplication) getApplication()).getAppComponent())
                .build();

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 完成注入并返回注入的Presenter对象
     *
     * @return
     */
    protected abstract T initInjector();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            //解除绑定
            mPresenter.detachView();
        }
    }
}
