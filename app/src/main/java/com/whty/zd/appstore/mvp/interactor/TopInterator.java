package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.api.TopApi;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.TopBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/8/16 22:43
 * @desciption:
 */

public class TopInterator {

    private IGetDataDelegate<TopBean> delegate;

    @Inject
    public TopInterator() {
    }

    public void loadTopData(BaseActivity activity, IGetDataDelegate<TopBean> delegate) {
        this.delegate = delegate;
        TopApi topApi = new TopApi(listener, activity);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(topApi);
    }

    private HttpOnNextListener<TopBean> listener = new HttpOnNextListener<TopBean>() {
        @Override
        public void onNext(TopBean topBean) {
            delegate.getDataSuccess(topBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            TopBean topBean = JsonParseUtils.parseTopBean(string);
            delegate.getDataSuccess(topBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            delegate.getDataError(e.getMessage());
        }
    };
}
