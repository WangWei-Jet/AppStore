package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.AppRecommendApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.AppRecommendBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/9/29 10:56
 * @desciption:
 */

public class AppRecommendInteractor {

    private IGetDataDelegate<AppRecommendBean> mDelegate;

    @Inject
    public AppRecommendInteractor() {
    }

    public void loadAppRecommend(BaseActivity activity, String packageName, IGetDataDelegate<AppRecommendBean> delegate) {
        this.mDelegate = delegate;
        AppRecommendApi api = new AppRecommendApi(httpListener, activity, packageName);
        HttpManager httpListener = HttpManager.getInstance();
        httpListener.doHttpDeal(api);
    }

    private HttpOnNextListener<AppRecommendBean> httpListener = new HttpOnNextListener<AppRecommendBean>() {
        @Override
        public void onNext(AppRecommendBean appRecommendBean) {
            mDelegate.getDataSuccess(appRecommendBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppRecommendBean appRecommendBean = JsonParseUtils.parseAppRecommendBean(string);
            mDelegate.getDataSuccess(appRecommendBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
