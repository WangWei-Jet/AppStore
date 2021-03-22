package com.whty.zd.appstore.mvp.presenter;

import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.AppCommentFragmentView;

/**
 * @author: wangwei
 * @date: 2017/9/26 16:12
 * @desciption:
 */

public interface AppCommentFragmentPresenter extends BasePresenter<AppCommentFragmentView> {
    void getAppCommentData(BaseActivity activity, String packageName);
}
