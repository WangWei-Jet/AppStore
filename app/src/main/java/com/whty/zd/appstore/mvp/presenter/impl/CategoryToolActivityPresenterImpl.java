package com.whty.zd.appstore.mvp.presenter.impl;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.bean.CategoryToolBean;
import com.whty.zd.appstore.mvp.interactor.CategoryToolActivityInteractor;
import com.whty.zd.appstore.mvp.presenter.CategoryToolActivityPresenter;
import com.whty.zd.appstore.mvp.view.view.CategoryToolActivityView;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/10/16 18:53
 * @desciption:
 */

public class CategoryToolActivityPresenterImpl extends BasePresenterImpl<CategoryToolActivityView> implements CategoryToolActivityPresenter {

    @Inject
    public CategoryToolActivityInteractor categoryToolActivityInteractor ;

    @Inject
    public CategoryToolActivityPresenterImpl(){

    }

    @Override
    public void getCategoryToolData(BaseActivity activity) {
        categoryToolActivityInteractor.loadCategoryToolData(activity, new IGetDataDelegate<CategoryToolBean>() {
            @Override
            public void getDataSuccess(CategoryToolBean categoryToolBean) {
                mPresenterView.onCategoryToolDataSuccess(categoryToolBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategoryToolError(errmsg);
            }
        });
    }
}
