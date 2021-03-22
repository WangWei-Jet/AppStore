package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.api.RecommendApi;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.RecommendBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/8/14 23:05
 * @desciption:
 */

public class RecommendInterator {

    private IGetDataDelegate<RecommendBean> mDelegate;

    @Inject
    public RecommendInterator() {
    }

    /**
     * 执行网络请求
     * 获取网络数据
     */
    public void loadRecommendData(BaseActivity activity, IGetDataDelegate<RecommendBean> delegate) {
        this.mDelegate = delegate;
        RecommendApi recommendApi = new RecommendApi(listener, activity);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(recommendApi);
    }

    private HttpOnNextListener<RecommendBean> listener = new HttpOnNextListener<RecommendBean>() {
        @Override
        public void onNext(RecommendBean recommendBean) {
            mDelegate.getDataSuccess(recommendBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            RecommendBean recommendBean = JsonParseUtils.parseRecommendBean(string);
            mDelegate.getDataSuccess(recommendBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
