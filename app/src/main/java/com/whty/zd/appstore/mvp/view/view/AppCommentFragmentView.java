package com.whty.zd.appstore.mvp.view.view;

import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.AppCommentBean;

/**
 * @author: wangwei
 * @date: 2017/9/26 16:11
 * @desciption:
 */

public interface AppCommentFragmentView extends BaseView {
    void onAppCommentDataSuccess(AppCommentBean appCommentBean);

    void onAppCommentDataError(String msg);
}
