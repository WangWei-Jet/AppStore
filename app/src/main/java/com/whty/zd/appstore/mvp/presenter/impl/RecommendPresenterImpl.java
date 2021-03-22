package com.whty.zd.appstore.mvp.presenter.impl;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.RecommendBean;
import com.whty.zd.appstore.mvp.interactor.RecommendInterator;
import com.whty.zd.appstore.mvp.presenter.RecommendFragmentPresenter;
import com.whty.zd.appstore.mvp.view.view.RecommendFragmentView;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/7/30 17:06
 * @desciption:
 */

public class RecommendPresenterImpl extends BasePresenterImpl<RecommendFragmentView> implements RecommendFragmentPresenter {

    @Inject
    RecommendInterator mRecommendInterator;

    @Inject
    public RecommendPresenterImpl() {
    }

    @Override
    public void getRecommendData(BaseActivity activity) {
        //网络请求获取数据
        mRecommendInterator.loadRecommendData(activity, new IGetDataDelegate<RecommendBean>() {
            @Override
            public void getDataSuccess(RecommendBean recommendBean) {
                mPresenterView.onRecomendDataSuccess(recommendBean);
            }

            @Override
            public void getDataError(String msg) {
                mPresenterView.onRecomendDataError(msg);
            }
        });
    }

    @Override
    public void getRecommendDataMore(BaseActivity activity) {
        //网络请求获取数据
        mRecommendInterator.loadRecommendData(activity, new IGetDataDelegate<RecommendBean>() {
            @Override
            public void getDataSuccess(RecommendBean recommendBean) {
                mPresenterView.onRecomendDataMoreSuccess(recommendBean);
            }

            @Override
            public void getDataError(String msg) {
                mPresenterView.onRecomendDataError(msg);
            }
        });
    }
}
