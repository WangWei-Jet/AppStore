package com.whty.zd.appstore.mvp.presenter;

import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.base.mvpbase.BasePresenter;
import com.whty.zd.appstore.mvp.view.view.RecommendFragmentView;

/**
 * @author: wangwei
 * @date: 2017/7/30 17:05
 * @desciption:
 */

public interface RecommendFragmentPresenter extends BasePresenter<RecommendFragmentView> {
    /**
     * 获取推荐数据
     */
    void getRecommendData(BaseActivity activity);

    /**
     * 获取更多推荐数据
     */
    void getRecommendDataMore(BaseActivity activity);
}

