package com.whty.zd.appstore.mvp.view.view;

import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.TopBean;

/**
 * @author: wangwei
 * @date: 2017/8/16 22:38
 * @desciption:
 */

public interface TopFragmentView extends BaseView {

    void onTopDataSuccess(TopBean topBean);

    void onTopDataError(String msg);
}
