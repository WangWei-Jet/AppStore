package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.CategorySubcribeApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.CategorySubscribeBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategorySubscribeInteractor {

    private IGetDataDelegate<CategorySubscribeBean> mDelegate ;

    @Inject
    public CategorySubscribeInteractor(){

    }

    public void loadCategorySubscribeData(BaseActivity activity, IGetDataDelegate<CategorySubscribeBean> delegate){
        this.mDelegate = delegate ;
        CategorySubcribeApi categorySubcribeApi = new CategorySubcribeApi(httpListener,activity);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(categorySubcribeApi);
    }

    private HttpOnNextListener httpListener = new HttpOnNextListener<CategorySubscribeBean>(){

        @Override
        public void onNext(CategorySubscribeBean categorySubscribeBean) {
            mDelegate.getDataSuccess(categorySubscribeBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            CategorySubscribeBean categorySubscribeBean = JsonParseUtils.parseCategorySubscribeBean(string);
            mDelegate.getDataSuccess(categorySubscribeBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
