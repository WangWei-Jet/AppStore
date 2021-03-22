package com.whty.zd.appstore.mvp.view.view;

import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.AppRecommendBean;

/**
 * @author: wangwei
 * @date: 2017/9/29 10:50
 * @desciption:
 */

public interface AppRecommendFragmentView extends BaseView {
    void onAppRecommendDataSuccess(AppRecommendBean appRecommendBean);

    void onAppRecommendDataError(String msg);
}
