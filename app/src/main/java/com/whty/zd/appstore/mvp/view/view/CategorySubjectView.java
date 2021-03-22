package com.whty.zd.appstore.mvp.view.view;


import com.whty.zd.appstore.base.mvpbase.BaseView;

import java.util.List;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public interface CategorySubjectView extends BaseView {
    void onCategorySubjectDataSuccess(List<String> list) ;
    void onCategorySubjectDataError(String msg);
}
