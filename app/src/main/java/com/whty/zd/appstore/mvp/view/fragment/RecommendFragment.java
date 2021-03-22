package com.whty.zd.appstore.mvp.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.whty.zd.appstore.R;
import com.whty.zd.appstore.adapter.RecommendAdapter;
import com.whty.zd.appstore.adapter.top.RecommendTopWrapper;
import com.whty.zd.appstore.base.BaseMvpFragment;
import com.whty.zd.appstore.bean.RecommendBean;
import com.whty.zd.appstore.mvp.presenter.impl.RecommendPresenterImpl;
import com.whty.zd.appstore.mvp.view.activity.AppDetailActivity;
import com.whty.zd.appstore.mvp.view.view.RecommendFragmentView;
import com.whty.zd.appstore.utils.UIUtils;
import com.whty.zd.appstore.view.LoadingPager;
import com.whty.zd.smartpos.library.recyclerview.pullrefresh.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 推荐页
 */
public class RecommendFragment extends BaseMvpFragment<RecommendPresenterImpl> implements RecommendFragmentView {

    private final static String TAG = "RecommendFragment";

    @Inject
    public RecommendPresenterImpl mRecommendPresenter;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.ptr)
    PullToRefreshView mPtr;

    private RecommendBean mRecommendBean;
    private List<RecommendBean.RecommendAppBean> mRecommendAppBeanList = new ArrayList<>();
    private RecommendAdapter mAdapter;
    private RecommendTopWrapper topWrapper;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    protected void load() {
        //发起网络请求
        mRecommendPresenter.getRecommendData(getHoldingActivity());
    }

    @Override
    protected View createSuccessView() {
        View inflate = UIUtils.inflate(R.layout.fragment_recommend);
        ButterKnife.bind(this, inflate);
        mAdapter = new RecommendAdapter(getHoldingActivity());
        mAdapter.addDataAll(mRecommendBean.getRecommendAppBeanList());
        topWrapper = new RecommendTopWrapper(getHoldingActivity(), mAdapter);
        topWrapper.addDataAll(mRecommendBean.getBannerList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getHoldingActivity()));
        mRecyclerView.setAdapter(topWrapper);

        mAdapter.setAppItemListener(new RecommendAdapter.AppItemListener() {
            @Override
            public void goAppDetail(String packageName) {
                Intent intent = new Intent(mActivity, AppDetailActivity.class);
                intent.putExtra("packageName", packageName);
                mActivity.startActivity(intent);
            }
        });

        //不让其下拉刷新
        mPtr.setPullDownEnable(false);
        mPtr.setListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                mRecommendPresenter.getRecommendDataMore(mActivity);
            }
        });
        return inflate;
    }

    @Override
    public void onRecomendDataSuccess(RecommendBean recommendBean) {
        mRecommendBean = recommendBean;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onRecomendDataMoreSuccess(RecommendBean recommendBean) {
        mRecommendAppBeanList.addAll(recommendBean.getRecommendAppBeanList());
        mAdapter.clearData();
        mAdapter.addDataAll(mRecommendAppBeanList);
        topWrapper.notifyDataSetChanged();
        mPtr.onFinishLoading();
    }

    @Override
    public void onRecomendDataError(String msg) {
        setState(LoadingPager.LoadResult.error);
    }

    @Override
    protected RecommendPresenterImpl initInjector() {
        //完成依赖注入
        mFragmentComponent.inject(this);
        //返回注入的Presenter
        return mRecommendPresenter;
    }

}
