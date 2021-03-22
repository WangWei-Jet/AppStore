package com.whty.zd.appstore.mvp.presenter.impl;


import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.CategoryNecessaryBean;
import com.whty.zd.appstore.mvp.interactor.CategoryNecessaryInteractor;
import com.whty.zd.appstore.mvp.presenter.CategoryNecessaryPresenter;
import com.whty.zd.appstore.mvp.view.view.CategoryNecessaryView;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategoryNecessaryPresenterImpl extends BasePresenterImpl<CategoryNecessaryView> implements CategoryNecessaryPresenter {


    @Inject
    public CategoryNecessaryInteractor categoryNecessaryInteractor ;

    @Inject
    public CategoryNecessaryPresenterImpl(){

    }

    @Override
    public void getCategoryNecessaryData(BaseActivity activity) {
        categoryNecessaryInteractor.loadCategoryNecessaryData(activity, new IGetDataDelegate<CategoryNecessaryBean>() {
            @Override
            public void getDataSuccess(CategoryNecessaryBean categoryNecessaryBean) {
                mPresenterView.onCategoryNecessaryDataSuccess(categoryNecessaryBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategoryNecessaryDataError(errmsg);
            }
        });
    }
}
