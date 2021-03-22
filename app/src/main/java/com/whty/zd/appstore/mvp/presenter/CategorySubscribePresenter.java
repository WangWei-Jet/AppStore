package com.whty.zd.appstore.mvp.presenter;


import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.CategorySubscribeView;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public interface CategorySubscribePresenter extends BasePresenter<CategorySubscribeView> {
    void getCategorySubscribeData(BaseActivity activity);
}
