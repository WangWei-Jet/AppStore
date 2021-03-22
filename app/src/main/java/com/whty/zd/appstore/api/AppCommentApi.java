package com.whty.zd.appstore.api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.whty.zd.appstore.bean.AppCommentBean;
import com.whty.zd.appstore.utils.JsonParseUtils;
import com.whty.zd.smartpos.library.rxretrofit.api.BaseApi;
import com.whty.zd.smartpos.library.rxretrofit.listener.HttpOnNextListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * @author: wangwei
 * @date: 2017/9/26 16:13
 * @desciption:
 */

public class AppCommentApi extends BaseApi<AppCommentBean> {
    private String packageName;

    public AppCommentApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity, String packageName) {
        super(listener, rxAppCompatActivity);
        setMothed("AppStore/app/comment/" + packageName);
        this.packageName = packageName;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpGetService httpGetService = retrofit.create(HttpGetService.class);
        return httpGetService.getAppCommentData(packageName);
    }

    @Override
    public AppCommentBean call(ResponseBody responseBody) {
        String string = "";
        try {
            string = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("string:" + string);
        return JsonParseUtils.parseAppCommentBean(string);
    }
}
