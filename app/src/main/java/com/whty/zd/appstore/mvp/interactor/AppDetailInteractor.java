package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.AppDetailApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.AppDetailBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/9/21 15:22
 * @desciption:
 */

public class AppDetailInteractor {

    private IGetDataDelegate<AppDetailBean> mDelegate;

    @Inject
    public AppDetailInteractor() {
    }

    public void loadAppDetailData(BaseActivity activity, String packageName, IGetDataDelegate<AppDetailBean> delegate) {
        this.mDelegate = delegate;
        AppDetailApi api = new AppDetailApi(listener, activity, packageName);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(api);
    }

    private HttpOnNextListener<AppDetailBean> listener = new HttpOnNextListener<AppDetailBean>() {
        @Override
        public void onNext(AppDetailBean appDetailBean) {
            mDelegate.getDataSuccess(appDetailBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppDetailBean appDetailBean = JsonParseUtils.parseAppDetailBean(string);
            mDelegate.getDataSuccess(appDetailBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
