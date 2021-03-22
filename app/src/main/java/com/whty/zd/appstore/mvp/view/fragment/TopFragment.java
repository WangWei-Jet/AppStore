package com.whty.zd.appstore.mvp.view.fragment;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.whty.zd.appstore.R;
import com.whty.zd.appstore.adapter.section.TopContactsSection;
import com.whty.zd.appstore.adapter.top.TopTopWrapper;
import com.whty.zd.appstore.base.BaseMvpFragment;
import com.whty.zd.appstore.bean.AppBean;
import com.whty.zd.appstore.bean.TopBean;
import com.whty.zd.appstore.mvp.presenter.TopFragmentPresenter;
import com.whty.zd.appstore.mvp.presenter.impl.TopFragmentPresenterImpl;
import com.whty.zd.appstore.mvp.view.view.TopFragmentView;
import com.whty.zd.appstore.utils.UIUtils;
import com.whty.zd.appstore.view.LoadingPager;
import com.whty.zd.appstore.view.widget.ViewUpSearch;
import com.whty.zd.smartpos.library.recyclerview.section.SectionRVAdapter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends BaseMvpFragment<TopFragmentPresenter> implements TopFragmentView {

    private final static String TAG = "TopFragment";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.search)
    ViewUpSearch mSearch;
    private TopBean mTopBean;
    private boolean isExpand = true;
    @Inject
    public TopFragmentPresenterImpl mTopFragmentPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    protected void load() {
        mTopFragmentPresenter.getTopData(getHoldingActivity());
    }

    @Override
    protected View createSuccessView() {
        View inflate = UIUtils.inflate(R.layout.fragment_top);
        ButterKnife.bind(this, inflate);
        SectionRVAdapter sectionAdapter = new SectionRVAdapter(getContext());
        Map<String, List<AppBean>> appBeanMap = mTopBean.getAppBeanMap();
        Set<String> strings = appBeanMap.keySet();
        for (String name : strings) {
            List<AppBean> appBeanList = appBeanMap.get(name);
            TopContactsSection section = new TopContactsSection(getContext(), name, appBeanList);

            sectionAdapter.addSection(section);
        }
        TopTopWrapper topTopWrapper = new TopTopWrapper(getContext(), sectionAdapter);
        topTopWrapper.addDataAll(mTopBean.getTopTopBeanList());
        mRecyclerView.setAdapter(topTopWrapper);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getHoldingActivity()));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                final int firstVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (firstVisiblePosition == 0 && isExpand && dy > 0) {
                    mSearch.updateShow(!isExpand);
                    isExpand = false;
                } else if (firstVisiblePosition == 0 && !isExpand && dy < 0) {
                    mSearch.updateShow(!isExpand);
                    isExpand = true;
                }
            }
        });

        topTopWrapper.setOnItemClickListener(new TopTopWrapper.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        return inflate;
    }

    @Override
    public void onTopDataSuccess(TopBean topBean) {
        mTopBean = topBean;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onTopDataError(String msg) {
        setState(LoadingPager.LoadResult.error);
    }

    @Override
    protected TopFragmentPresenter initInjector() {
        mFragmentComponent.inject(this);
        return mTopFragmentPresenter;
    }

}
