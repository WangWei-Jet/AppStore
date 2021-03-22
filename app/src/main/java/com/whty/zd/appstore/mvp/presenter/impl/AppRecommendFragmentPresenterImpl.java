package com.whty.zd.appstore.mvp.presenter.impl;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.AppRecommendBean;
import com.whty.zd.appstore.mvp.interactor.AppRecommendInteractor;
import com.whty.zd.appstore.mvp.presenter.AppRecommendFragmentPresenter;
import com.whty.zd.appstore.mvp.view.view.AppRecommendFragmentView;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/9/29 10:52
 * @desciption:
 */

public class AppRecommendFragmentPresenterImpl extends BasePresenterImpl<AppRecommendFragmentView> implements AppRecommendFragmentPresenter {

    @Inject
    AppRecommendInteractor mAppRecommendInteractor;

    @Inject
    public AppRecommendFragmentPresenterImpl() {
    }

    @Override
    public void getAppRecommendData(BaseActivity activity, String packageName) {
        mAppRecommendInteractor.loadAppRecommend(activity, packageName, new IGetDataDelegate<AppRecommendBean>() {
            @Override
            public void getDataSuccess(AppRecommendBean appRecommendBean) {
                mPresenterView.onAppRecommendDataSuccess(appRecommendBean);
            }

            @Override
            public void getDataError(String msg) {
                mPresenterView.onAppRecommendDataError(msg);
            }
        });
    }
}
