package com.whty.zd.appstore.mvp.presenter.impl;


import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenterImpl;
import com.whty.zd.appstore.mvp.interactor.CategorySubjectInteractor;
import com.whty.zd.appstore.mvp.presenter.CategorySubjectPresenter;
import com.whty.zd.appstore.mvp.view.view.CategorySubjectView;

import java.util.List;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategorySubjectPresenterImpl extends BasePresenterImpl<CategorySubjectView> implements CategorySubjectPresenter {


    @Inject
    CategorySubjectInteractor categorySubjectInteractor ;

    @Inject
    public CategorySubjectPresenterImpl(){

    }

    @Override
    public void getCategorySubjectData(BaseActivity activity) {
        categorySubjectInteractor.loadCategorySubjectData(activity, new IGetDataDelegate<List<String>>() {
            @Override
            public void getDataSuccess(List<String> list) {
                mPresenterView.onCategorySubjectDataSuccess(list);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategorySubjectDataError(errmsg);
            }
        });
    }
}
