package com.whty.zd.appstore.mvp.interactor;

import com.whty.zd.appstore.api.CategorySubjectApi;
import com.whty.zd.appstore.api.IGetDataDelegate;
import com.whty.zd.appstore.base.BaseActivity;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.http.HttpManager;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import java.util.List;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategorySubjectInteractor {

    private IGetDataDelegate<List<String>> mDelegate ;

    @Inject
    public CategorySubjectInteractor(){

    }

    public void loadCategorySubjectData(BaseActivity activity, IGetDataDelegate<List<String>> delegate){
        this.mDelegate = delegate ;
        CategorySubjectApi categorySubjectApi = new CategorySubjectApi(httpListener,activity);
        HttpManager httpListener = HttpManager.getInstance();
        httpListener.doHttpDeal(categorySubjectApi);
    }
    private HttpOnNextListener<List<String>> httpListener = new HttpOnNextListener<List<String>>() {
        @Override
        public void onNext(List<String> list) {
            mDelegate.getDataSuccess(list);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            List<String> strings = JsonParseUtils.parseCategorySubject(string);
            mDelegate.getDataSuccess(strings);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
