package com.whty.zd.appstore.mvp.presenter;

import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.CategoryToolActivityView;

/**
 * @author: wangwei
 * @date: 2017/10/16 18:52
 * @desciption:
 */

public interface CategoryToolActivityPresenter extends BasePresenter<CategoryToolActivityView> {
    void getCategoryToolData(BaseActivity activity);
}
