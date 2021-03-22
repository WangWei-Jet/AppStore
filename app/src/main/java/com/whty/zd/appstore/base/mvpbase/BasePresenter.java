package com.whty.zd.appstore.base.mvpbase;

/**
 * @author: wangwei
 * @date: 2017/7/30 16:32
 * @desciption: 该类是所有presenter接口的基类
 */

public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
