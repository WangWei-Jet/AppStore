package com.whty.zd.appstore.bean;

import java.util.List;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class RecommendBean {

    private List<String> bannerList ;
    private List<RecommendAppBean> recommendAppBeanList ;

    public RecommendBean(List<String> bannerList, List<RecommendAppBean> recommendAppBeanList) {
        this.bannerList = bannerList;
        this.recommendAppBeanList = recommendAppBeanList;
    }

    public List<String> getBannerList() {
        return bannerList;
    }

    public List<RecommendAppBean> getRecommendAppBeanList() {
        return recommendAppBeanList;
    }

    public static class RecommendAppBean {
        /** 标题 */
        private String title ;
        /** 广告 */
        private List<String> iconList ;
        /** 应用集合 */
        private List<AppBean> appList ;
        private int type = 0 ;

        public RecommendAppBean(String title, List<String> iconList, List<AppBean> appList, int type) {
            this.title = title;
            this.iconList = iconList;
            this.appList = appList;
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public List<String> getIconList() {
            return iconList;
        }

        public List<AppBean> getAppList() {
            return appList;
        }

        public int getType() {
            return type;
        }
    }
}
