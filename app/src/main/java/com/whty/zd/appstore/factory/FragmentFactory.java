package com.whty.zd.appstore.factory;

import com.whty.zd.appstore.base.BaseFragment;
import com.whty.zd.appstore.mvp.view.fragment.AppManagerFragment;
import com.whty.zd.appstore.mvp.view.fragment.RecommendFragment;
import com.whty.zd.appstore.mvp.view.fragment.CategoryFragment;
import com.whty.zd.appstore.mvp.view.fragment.MyFragment;
import com.whty.zd.appstore.mvp.view.fragment.TopFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangwei
 * @date: 2017/7/20 22:35
 * @desciption:
 */

public class FragmentFactory {
    /**
     * 推荐
     */
    public static final int TAB_RECOMMEND = 0;
    /**
     * 分类
     */
    public static final int TAB_CATEGORY = 1;
    /**
     * 排行
     */
    public static final int TAB_TOP = 2;
    /**
     * 管理
     */
    public static final int TAB_APPMANAGER = 3;
    /**
     * 我的
     */
    public static final int TAB_MY = 4;

    private static Map<Integer, BaseFragment> mFragments = new HashMap<>();

    public static BaseFragment createFragment(int index) {
        BaseFragment fragment = mFragments.get(index);
        //如果之前没有创建，创建新的fragment
        if (fragment == null) {
            switch (index) {
                case TAB_RECOMMEND:
                    fragment = new RecommendFragment();
                    break;
                case TAB_CATEGORY:
                    fragment = new CategoryFragment();
                    break;
                case TAB_TOP:
                    fragment = new TopFragment();
                    break;
                case TAB_APPMANAGER:
                    fragment = new AppManagerFragment();
                    break;
                case TAB_MY:
                    fragment = new MyFragment();
                    break;
            }
            //把创建的fragment存起来
            mFragments.put(index, fragment);
        }
        return fragment;
    }
}
