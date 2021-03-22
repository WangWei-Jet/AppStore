package com.whty.zd.appstore.mvp.presenter.impl;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.CategoryBean;
import com.whty.zd.appstore.mvp.interactor.CategoryInterator;
import com.whty.zd.appstore.mvp.presenter.CategoryFragmentPresenter;
import com.whty.zd.appstore.mvp.view.view.CategoryFragmentView;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/8/16 15:13
 * @desciption:
 */

public class CategoryPresenterImpl extends BasePresenterImpl<CategoryFragmentView> implements CategoryFragmentPresenter {

    @Inject
    CategoryInterator mCategoryInterator;

    @Inject
    public CategoryPresenterImpl() {
    }

    @Override
    public void getCategoryData(BaseActivity activity) {
        mCategoryInterator.loadCategoryData(activity, new IGetDataDelegate<CategoryBean>() {
            @Override
            public void getDataSuccess(CategoryBean categoryBean) {
                mPresenterView.onCategoryDataSuccess(categoryBean);
            }

            @Override
            public void getDataError(String msg) {
                mPresenterView.onCategoryDataError(msg);
            }
        });
    }
}
