package com.whty.zd.appstore.mvp.interactor;


import com.whty.zd.appstore.api.CategoryNewApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.CategoryNewBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategoryNewInteractor {

    private IGetDataDelegate<CategoryNewBean> mDelegate ;

    @Inject
    public CategoryNewInteractor(){

    }

    public void loadCategoryNewData(BaseActivity activity, IGetDataDelegate<CategoryNewBean> delegate){
        this.mDelegate = delegate ;
        CategoryNewApi categoryNewApi = new CategoryNewApi(httpListener,activity);
        HttpManager httpListener = HttpManager.getInstance() ;
        httpListener.doHttpDeal(categoryNewApi);
    }

    private HttpOnNextListener<CategoryNewBean> httpListener = new HttpOnNextListener<CategoryNewBean>() {
        @Override
        public void onNext(CategoryNewBean categoryNewBean) {
            mDelegate.getDataSuccess(categoryNewBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            CategoryNewBean categoryNewBean = JsonParseUtils.parseCategoryNewBean(string);
            mDelegate.getDataSuccess(categoryNewBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
