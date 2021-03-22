package com.whty.zd.appstore.mvp.view.view;

import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.AppIntroductionBean;

/**
 * @author: wangwei
 * @date: 2017/9/22 18:41
 * @desciption:
 */

public interface AppIntroductionFragmentView extends BaseView {
    void onAppIntroductionDataSuccess(AppIntroductionBean appIntroductionBean);

    void onAppIntroductionDataError(String msg);
}
