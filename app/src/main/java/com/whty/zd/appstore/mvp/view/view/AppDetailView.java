package com.whty.zd.appstore.mvp.view.view;

import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.AppDetailBean;

/**
 * @author: wangwei
 * @date: 2017/9/21 10:23
 * @desciption:
 */

public interface AppDetailView extends BaseView {
    void onAppDetailDataSuccess(AppDetailBean appDetailBean);

    void onAppDetailDataError(String msg);
}
