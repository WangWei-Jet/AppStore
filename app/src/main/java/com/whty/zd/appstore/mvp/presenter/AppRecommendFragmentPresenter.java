package com.whty.zd.appstore.mvp.presenter;

import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.AppRecommendFragmentView;

/**
 * @author: wangwei
 * @date: 2017/9/29 10:52
 * @desciption:
 */

public interface AppRecommendFragmentPresenter extends BasePresenter<AppRecommendFragmentView> {
    void getAppRecommendData(BaseActivity activity, String packageName);
}
