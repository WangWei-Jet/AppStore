package com.whty.zd.appstore.mvp.presenter;


import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.CategoryNewView;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public interface CategoryNewPresenter extends BasePresenter<CategoryNewView> {
    void getCategoryNewData(BaseActivity activity);
}
