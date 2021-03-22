package com.whty.zd.appstore.api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.whty.zd.appstore.bean.CategoryToolBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.api.BaseApi;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategoryToolApi extends BaseApi<CategoryToolBean> {
    public CategoryToolApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);

        setMothed("AppStore/categorydata/tool");

    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpGetService httpGetService = retrofit.create(HttpGetService.class);
        return httpGetService.getCategoryToolData();
    }

    @Override
    public CategoryToolBean call(ResponseBody responseBody) {
        String string = "";
        try {
            string = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JsonParseUtils.parseCategoryToolBean(string);
    }
}
