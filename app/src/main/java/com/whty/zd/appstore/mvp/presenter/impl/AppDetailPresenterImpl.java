package com.whty.zd.appstore.mvp.presenter.impl;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.AppDetailBean;
import com.whty.zd.appstore.mvp.interactor.AppDetailInteractor;
import com.whty.zd.appstore.mvp.presenter.AppDetailPresenter;
import com.whty.zd.appstore.mvp.view.view.AppDetailView;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/9/21 15:19
 * @desciption:
 */

public class AppDetailPresenterImpl extends BasePresenterImpl<AppDetailView> implements AppDetailPresenter {

    @Inject
    AppDetailInteractor mAppDetailInteractor;

    @Inject
    public AppDetailPresenterImpl() {
    }

    @Override
    public void getAppDetailData(BaseActivity activity, String packageName) {
        mAppDetailInteractor.loadAppDetailData(activity, packageName, new IGetDataDelegate<AppDetailBean>() {
            @Override
            public void getDataSuccess(AppDetailBean appDetailBean) {
                mPresenterView.onAppDetailDataSuccess(appDetailBean);
            }

            @Override
            public void getDataError(String msg) {
                mPresenterView.onAppDetailDataError(msg);
            }
        });
    }
}
