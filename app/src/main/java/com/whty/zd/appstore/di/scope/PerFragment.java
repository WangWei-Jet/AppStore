package com.whty.zd.appstore.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author: wangwei
 * @date: 2017/7/30 15:35
 * @desciption:
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
