package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.CategoryApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.CategoryBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * @author: wangwei
 * @date: 2017/8/16 15:22
 * @desciption:
 */

public class CategoryInterator {

    private IGetDataDelegate<CategoryBean> delegate;

    @Inject
    public CategoryInterator() {
    }

    /**
     * 执行网络请求
     * 获取网络数据
     */
    public void loadCategoryData(BaseActivity activity, IGetDataDelegate<CategoryBean> delegate) {
        this.delegate = delegate;
        CategoryApi categoryApi = new CategoryApi(listener, activity);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(categoryApi);
    }

    private HttpOnNextListener<CategoryBean> listener = new HttpOnNextListener<CategoryBean>() {
        @Override
        public void onNext(CategoryBean categoryBean) {
            delegate.getDataSuccess(categoryBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            CategoryBean categoryBean = JsonParseUtils.parseCategoryBean(string);
            delegate.getDataSuccess(categoryBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            delegate.getDataError(e.getMessage());
        }
    };

}
