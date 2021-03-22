package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.CategoryToolApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.bean.CategoryToolBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategoryToolActivityInteractor {

    private IGetDataDelegate<CategoryToolBean> mDelegate ;

    @Inject
    public CategoryToolActivityInteractor(){

    }

    public void loadCategoryToolData(BaseActivity activity, IGetDataDelegate<CategoryToolBean> delegate){
        this.mDelegate = delegate ;

        CategoryToolApi categoryToolApi = new CategoryToolApi(httpListener,activity);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(categoryToolApi);
    }

    private HttpOnNextListener httpListener = new HttpOnNextListener<CategoryToolBean>() {
        @Override
        public void onNext(CategoryToolBean categoryToolBean) {
            mDelegate.getDataSuccess(categoryToolBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            CategoryToolBean categoryToolBean = JsonParseUtils.parseCategoryToolBean(string);
            mDelegate.getDataSuccess(categoryToolBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };

}
