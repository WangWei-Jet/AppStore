package com.whty.zd.appstore.mvp.view.view;

import com.whty.zd.appstore.base.mvpbase.BaseView;
import com.whty.zd.appstore.bean.RecommendBean;

/**
 * @author: wangwei
 * @date: 2017/7/30 17:02
 * @desciption:
 */

public interface RecommendFragmentView extends BaseView {

    void onRecomendDataSuccess(RecommendBean recommendBean);

    void onRecomendDataMoreSuccess(RecommendBean recommendBean);

    void onRecomendDataError(String msg);
}
