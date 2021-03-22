package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.AppCommentApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.AppCommentBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/9/26 16:15
 * @desciption:
 */

public class AppCommentFragmentInteractor {

    private IGetDataDelegate<AppCommentBean> mDelegate;

    @Inject
    public AppCommentFragmentInteractor() {

    }

    public void loadAppCommentData(BaseActivity activity, String packageName, IGetDataDelegate<AppCommentBean> delegate) {
        this.mDelegate = delegate;
        AppCommentApi api = new AppCommentApi(httpListener, activity, packageName);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(api);
    }

    private HttpOnNextListener<AppCommentBean> httpListener = new HttpOnNextListener<AppCommentBean>() {
        @Override
        public void onNext(AppCommentBean appCommentBean) {
            mDelegate.getDataSuccess(appCommentBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppCommentBean appCommentBean = JsonParseUtils.parseAppCommentBean(string);
            mDelegate.getDataSuccess(appCommentBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
