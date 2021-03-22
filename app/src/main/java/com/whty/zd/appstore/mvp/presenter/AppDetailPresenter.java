package com.whty.zd.appstore.mvp.presenter;

import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.AppDetailView;

/**
 * @author: wangwei
 * @date: 2017/9/21 10:27
 * @desciption:
 */

public interface AppDetailPresenter extends BasePresenter<AppDetailView> {
    void getAppDetailData(BaseActivity activity, String packageName);
}
