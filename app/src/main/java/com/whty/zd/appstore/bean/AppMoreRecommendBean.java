package com.whty.zd.appstore.bean;

import java.util.List;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class AppMoreRecommendBean {

    private List<AppBean> moreAppBean ;

    public AppMoreRecommendBean(List<AppBean> moreAppBean) {
        this.moreAppBean = moreAppBean;
    }

    public List<AppBean> getMoreAppBean() {
        return moreAppBean;
    }
}
