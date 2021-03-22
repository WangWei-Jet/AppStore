package com.whty.zd.appstore.api;

/**
 * @author: wangwei
 * @date: 2017/8/14 23:09
 * @desciption: 网络请求回调
 */

public interface IGetDataDelegate<T> {

    void getDataSuccess(T t);

    void getDataError(String msg);
}
