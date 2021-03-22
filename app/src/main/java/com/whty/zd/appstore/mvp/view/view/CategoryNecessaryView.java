package com.whty.zd.appstore.mvp.view.view;


import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.CategoryNecessaryBean;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public interface CategoryNecessaryView extends BaseView {
    void onCategoryNecessaryDataSuccess(CategoryNecessaryBean categoryNecessaryBean);
    void onCategoryNecessaryDataError(String msg) ;
}
