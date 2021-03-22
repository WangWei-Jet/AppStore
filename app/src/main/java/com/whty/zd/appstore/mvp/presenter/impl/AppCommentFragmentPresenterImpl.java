package com.whty.zd.appstore.mvp.presenter.impl;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.AppCommentBean;
import com.whty.zd.appstore.mvp.interactor.AppCommentFragmentInteractor;
import com.whty.zd.appstore.mvp.presenter.AppCommentFragmentPresenter;
import com.whty.zd.appstore.mvp.view.view.AppCommentFragmentView;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/9/26 16:12
 * @desciption:
 */

public class AppCommentFragmentPresenterImpl extends BasePresenterImpl<AppCommentFragmentView> implements AppCommentFragmentPresenter {

    @Inject
    AppCommentFragmentInteractor appCommentFragmentInteractor;

    @Inject
    public AppCommentFragmentPresenterImpl() {

    }

    @Override
    public void getAppCommentData(BaseActivity activity, String packageName) {
        appCommentFragmentInteractor.loadAppCommentData(activity, packageName, new IGetDataDelegate<AppCommentBean>() {
            @Override
            public void getDataSuccess(AppCommentBean appCommentBean) {
                mPresenterView.onAppCommentDataSuccess(appCommentBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onAppCommentDataError(errmsg);
            }
        });
    }
}
