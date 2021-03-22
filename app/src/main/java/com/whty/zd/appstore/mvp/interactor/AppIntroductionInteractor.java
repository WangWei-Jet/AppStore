package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.AppIntroductionApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.AppIntroductionBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/9/25 17:59
 * @desciption:
 */

public class AppIntroductionInteractor {

    private IGetDataDelegate<AppIntroductionBean> mDelegate;

    @Inject
    public AppIntroductionInteractor() {

    }

    public void loadAppIntroduction(BaseActivity activity, String packageName, IGetDataDelegate<AppIntroductionBean> delegate) {
        this.mDelegate = delegate ;
        AppIntroductionApi api = new AppIntroductionApi(httpListener,activity,packageName);
        HttpManager httpManager = HttpManager.getInstance() ;
        httpManager.doHttpDeal(api);
    }

    private HttpOnNextListener<AppIntroductionBean> httpListener = new HttpOnNextListener<AppIntroductionBean>() {
        @Override
        public void onNext(AppIntroductionBean appIntroductionBean) {
            mDelegate.getDataSuccess(appIntroductionBean);

        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppIntroductionBean appIntroductionBean = JsonParseUtils.parseAppIntroductionBean(string);
            mDelegate.getDataSuccess(appIntroductionBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
