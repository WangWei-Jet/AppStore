package com.whty.zd.appstore.mvp.presenter;

import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.AppIntroductionFragmentView;

/**
 * @author: wangwei
 * @date: 2017/9/22 18:42
 * @desciption:
 */

public interface AppIntroductionFragmentPresenter extends BasePresenter<AppIntroductionFragmentView> {
    void getAppIntroductionData(BaseActivity activity, String packageName);
}
