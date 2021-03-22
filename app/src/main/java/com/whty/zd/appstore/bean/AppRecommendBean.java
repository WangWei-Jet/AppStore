package com.whty.zd.appstore.bean;

import java.util.List;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class AppRecommendBean {

    private List<AppBean> popularAppBeanList ;
    private List<AppBean> tasteAppBeanList ;
    private List<AppBean> hotAppBeanList ;

    public AppRecommendBean(List<AppBean> popularAppBeanList, List<AppBean> tasteAppBeanList, List<AppBean> hotAppBeanList) {
        this.popularAppBeanList = popularAppBeanList;
        this.tasteAppBeanList = tasteAppBeanList;
        this.hotAppBeanList = hotAppBeanList;
    }

    public List<AppBean> getPopularAppBeanList() {
        return popularAppBeanList;
    }

    public List<AppBean> getTasteAppBeanList() {
        return tasteAppBeanList;
    }

    public List<AppBean> getHotAppBeanList() {
        return hotAppBeanList;
    }
}
