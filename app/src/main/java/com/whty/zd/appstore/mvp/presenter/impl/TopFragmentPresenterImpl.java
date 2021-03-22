package com.whty.zd.appstore.mvp.presenter.impl;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.TopBean;
import com.whty.zd.appstore.mvp.interactor.TopInterator;
import com.whty.zd.appstore.mvp.presenter.TopFragmentPresenter;
import com.whty.zd.appstore.mvp.view.view.TopFragmentView;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/8/16 22:40
 * @desciption:
 */

public class TopFragmentPresenterImpl extends BasePresenterImpl<TopFragmentView> implements TopFragmentPresenter {

    @Inject
    TopInterator mTopInterator;

    @Inject
    public TopFragmentPresenterImpl() {
    }

    @Override
    public void getTopData(BaseActivity activity) {
        mTopInterator.loadTopData(activity, new IGetDataDelegate<TopBean>() {
            @Override
            public void getDataSuccess(TopBean topBean) {
                mPresenterView.onTopDataSuccess(topBean);
            }

            @Override
            public void getDataError(String msg) {
                mPresenterView.onTopDataError(msg);
            }
        });
    }
}
