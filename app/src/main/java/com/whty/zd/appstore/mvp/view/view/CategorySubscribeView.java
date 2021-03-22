package com.whty.zd.appstore.mvp.view.view;


import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.CategorySubscribeBean;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public interface CategorySubscribeView extends BaseView {
    void onCategorySubscribeDataSuccess(CategorySubscribeBean categorySubscribeBean) ;
    void onCategorySubscribeDataError(String msg);
}
