package com.whty.zd.appstore.api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.whty.zd.appstore.bean.AppDetailBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.api.BaseApi;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * @author: wangwei
 * @date: 2017/9/21 15:24
 * @desciption:
 */

public class AppDetailApi extends BaseApi<AppDetailBean> {

    private String packageName;

    public AppDetailApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity, String packageName) {
        super(listener, rxAppCompatActivity);
        setMothed("AppStore/app/introduce/" + packageName);
        this.packageName = packageName;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpGetService httpGetService = retrofit.create(HttpGetService.class);
        return httpGetService.getAppDetailData(packageName);
    }

    @Override
    public AppDetailBean call(ResponseBody responseBody) {
        String string = "";
        try {
            string = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonParseUtils.parseAppDetailBean(string);
    }
}
