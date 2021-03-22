package com.whty.zd.appstore.mvp.view.view;


import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.CategoryNewBean;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public interface CategoryNewView extends BaseView {
    void onCategoryNewDataSuccess(CategoryNewBean categoryNewBean);
    void onCategoryNewDataError(String msg);
}
