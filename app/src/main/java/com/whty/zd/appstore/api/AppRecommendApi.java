package com.whty.zd.appstore.api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.whty.zd.appstore.bean.AppRecommendBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.api.BaseApi;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * @author: wangwei
 * @date: 2017/9/29 10:53
 * @desciption:
 */

public class AppRecommendApi extends BaseApi<AppRecommendBean> {

    private String packageName;

    public AppRecommendApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity, String packageName) {
        super(listener, rxAppCompatActivity);
        setMothed("AppStore/app/recommend/" + packageName);
        this.packageName = packageName;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpGetService httpGetService = retrofit.create(HttpGetService.class);
        return httpGetService.getAppRecommendData(packageName);
    }

    @Override
    public AppRecommendBean call(ResponseBody responseBody) {
        String string = "";
        try {
            string = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JsonParseUtils.parseAppRecommendBean(string);
    }
}
