package com.whty.zd.appstore.mvp.presenter.impl;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.AppIntroductionBean;
import com.whty.zd.appstore.mvp.interactor.AppIntroductionInteractor;
import com.whty.zd.appstore.mvp.presenter.AppIntroductionFragmentPresenter;
import com.whty.zd.appstore.mvp.view.view.AppIntroductionFragmentView;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/9/22 18:43
 * @desciption:
 */

public class AppIntroductionFragmentPresenterImpl extends BasePresenterImpl<AppIntroductionFragmentView> implements AppIntroductionFragmentPresenter {

    @Inject
    AppIntroductionInteractor mInteractor;

    @Inject
    public AppIntroductionFragmentPresenterImpl() {
    }

    @Override
    public void getAppIntroductionData(BaseActivity activity, String packageName) {
        mInteractor.loadAppIntroduction(activity, packageName, new IGetDataDelegate<AppIntroductionBean>() {
            @Override
            public void getDataSuccess(AppIntroductionBean appIntroductionBean) {
                mPresenterView.onAppIntroductionDataSuccess(appIntroductionBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onAppIntroductionDataError(errmsg);
            }
        });
    }
}
