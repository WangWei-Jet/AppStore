package com.whty.zd.appstore.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whty.zd.appstore.view.LoadingPager;

/**
 * @author: wangwei
 * @date: 2017/7/20 22:36
 * @desciption:
 */

public abstract class BaseFragment extends Fragment {

    private LoadingPager mLoadingPager;

    protected BaseActivity mActivity;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
    }

    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mLoadingPager == null) {
            mLoadingPager = new LoadingPager(getContext()) {
                @Override
                protected void load() {
                    BaseFragment.this.load();
                }

                @Override
                protected View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }
            };
        }
        return mLoadingPager;
    }

    public void show() {
        if (mLoadingPager != null) {
            mLoadingPager.show();
        }
    }

    public void setState(LoadingPager.LoadResult result) {
        if (mLoadingPager != null) {
            mLoadingPager.setState(result);
        }
    }

    /**
     * 加载获取数据
     */
    protected abstract void load();

    /**
     * 加载成功页面
     *
     * @return
     */
    protected abstract View createSuccessView();
}
