package com.whty.zd.appstore.api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.whty.zd.appstore.bean.TopBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.api.BaseApi;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * @author: wangwei
 * @date: 2017/8/16 22:41
 * @desciption:
 */

public class TopApi extends BaseApi<TopBean> {

    public TopApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
        setMothed("AppStore/top");
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpGetService httpGetService = retrofit.create(HttpGetService.class);
        return httpGetService.getTopData();
    }

    @Override
    public TopBean call(ResponseBody responseBody) {
        String result = "";
        try {
            result = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonParseUtils.parseTopBean(result);
    }
}
