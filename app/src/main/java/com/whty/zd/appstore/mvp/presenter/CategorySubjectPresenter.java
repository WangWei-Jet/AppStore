package com.whty.zd.appstore.mvp.presenter;


import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.CategorySubjectView;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public interface CategorySubjectPresenter extends BasePresenter<CategorySubjectView> {
    void getCategorySubjectData(BaseActivity activity) ;
}
