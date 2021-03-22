package com.whty.zd.appstore.mvp.presenter.impl;


import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.CategorySubscribeBean;
import com.whty.zd.appstore.mvp.interactor.CategorySubscribeInteractor;
import com.whty.zd.appstore.mvp.presenter.CategorySubscribePresenter;
import com.whty.zd.appstore.mvp.view.view.CategorySubscribeView;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategorySubscribePresenterImpl extends BasePresenterImpl<CategorySubscribeView> implements CategorySubscribePresenter {

    @Inject
    public CategorySubscribeInteractor categorySubscribeInteractor ;

    @Inject
    public CategorySubscribePresenterImpl(){

    }

    @Override
    public void getCategorySubscribeData(BaseActivity activity) {
        categorySubscribeInteractor.loadCategorySubscribeData(activity, new IGetDataDelegate<CategorySubscribeBean>() {
            @Override
            public void getDataSuccess(CategorySubscribeBean categorySubscribeBean) {
                mPresenterView.onCategorySubscribeDataSuccess(categorySubscribeBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategorySubscribeDataError(errmsg);
            }
        });
    }
}
