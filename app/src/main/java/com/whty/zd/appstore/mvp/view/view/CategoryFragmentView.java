package com.whty.zd.appstore.mvp.view.view;

import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.CategoryBean;

/**
 * @author: wangwei
 * @date: 2017/8/16 15:02
 * @desciption:
 */

public interface CategoryFragmentView extends BaseView {

    void onCategoryDataSuccess(CategoryBean categoryBean);

    void onCategoryDataError(String msg);
}
