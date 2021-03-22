package com.whty.zd.appstore.mvp.presenter;

import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.CategoryFragmentView;

/**
 * @author: wangwei
 * @date: 2017/8/16 15:05
 * @desciption:
 */

public interface CategoryFragmentPresenter extends BasePresenter<CategoryFragmentView> {
    /**
     * 获取分类数据
     */
    void getCategoryData(BaseActivity activity);
}
