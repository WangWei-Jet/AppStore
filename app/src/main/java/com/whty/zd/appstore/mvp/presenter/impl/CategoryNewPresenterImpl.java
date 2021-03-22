package com.whty.zd.appstore.mvp.presenter.impl;


import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.CategoryNewBean;
import com.whty.zd.appstore.mvp.interactor.CategoryNewInteractor;
import com.whty.zd.appstore.mvp.presenter.CategoryNewPresenter;
import com.whty.zd.appstore.mvp.view.view.CategoryNewView;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategoryNewPresenterImpl extends BasePresenterImpl<CategoryNewView> implements CategoryNewPresenter {

    @Inject
    public CategoryNewInteractor categoryNewInteractor ;

    @Inject
    public CategoryNewPresenterImpl(){

    }

    @Override
    public void getCategoryNewData(BaseActivity activity) {
        categoryNewInteractor.loadCategoryNewData(activity, new IGetDataDelegate<CategoryNewBean>() {
            @Override
            public void getDataSuccess(CategoryNewBean categoryNewBean) {
                mPresenterView.onCategoryNewDataSuccess(categoryNewBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategoryNewDataError(errmsg);
            }
        });
    }
}
