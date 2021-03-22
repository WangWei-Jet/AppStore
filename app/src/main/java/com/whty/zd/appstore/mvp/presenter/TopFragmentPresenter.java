package com.whty.zd.appstore.mvp.presenter;

import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.TopFragmentView;

/**
 * @author: wangwei
 * @date: 2017/8/16 22:39
 * @desciption:
 */

public interface TopFragmentPresenter extends BasePresenter<TopFragmentView> {
    /**
     * 获取排行数据
     *
     * @param activity
     */
    void getTopData(BaseActivity activity);
}
