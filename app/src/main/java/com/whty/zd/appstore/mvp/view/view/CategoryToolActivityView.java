package com.whty.zd.appstore.mvp.view.view;

import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.CategoryToolBean;

/**
 * @author: wangwei
 * @date: 2017/10/16 18:42
 * @desciption:
 */

public interface CategoryToolActivityView extends BaseView {
    void onCategoryToolDataSuccess(CategoryToolBean categoryToolBean);

    void onCategoryToolError(String msg);
}
