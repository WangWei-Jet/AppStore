package com.whty.zd.smartpos.library.recyclerview.base;

/**
 * Created by wangwei on 2017/5/21.
 */

public interface ItemViewDelegate<T> {

    int getItemViewLayoutId() ;

    boolean isForViewType(T item, int position) ;

    void convert(ViewHolder holder, T t, int position) ;
}
