package com.whty.zd.appstore.mvp.presenter;


import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.CategoryNecessaryView;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public interface CategoryNecessaryPresenter extends BasePresenter<CategoryNecessaryView> {
    void getCategoryNecessaryData(BaseActivity activity) ;
}
