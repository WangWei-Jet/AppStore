package com.whty.zd.appstore.mvp.view.fragment;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.whty.zd.appstore.R;
import com.whty.zd.appstore.adapter.section.AppRecommendHotSection;
import com.whty.zd.appstore.adapter.section.AppRecommendPopularSection;
import com.whty.zd.appstore.adapter.section.AppRecommendTasteSection;
import com.whty.zd.appstore.base.BaseMvpFragment;
import com.whty.zd.appstore.bean.AppRecommendBean;
import com.whty.zd.appstore.mvp.presenter.impl.AppRecommendFragmentPresenterImpl;
import com.whty.zd.appstore.mvp.view.activity.AppDetailActivity;
import com.whty.zd.appstore.mvp.view.view.AppRecommendFragmentView;
import com.whty.zd.appstore.utils.UIUtils;
import com.whty.zd.appstore.view.LoadingPager;
import com.whty.zd.smartpos.library.recyclerview.section.SectionRVAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppRecommendFragment extends BaseMvpFragment<AppRecommendFragmentPresenterImpl> implements AppRecommendFragmentView {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Inject
    AppRecommendFragmentPresenterImpl appRecommendFragmentPresenter;

    private String packageName;

    private AppRecommendBean appRecommendBean;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        packageName = ((AppDetailActivity) getActivity()).getAppPackageName();
        show();
    }

    @Override
    protected void load() {
        appRecommendFragmentPresenter.getAppRecommendData(getHoldingActivity(), packageName);
    }

    @Override
    protected View createSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_app_recommend);
        ButterKnife.bind(this,view);

        SectionRVAdapter adapter = new SectionRVAdapter(getContext());
        adapter.addSection(new AppRecommendPopularSection(getContext(),"流行应用",appRecommendBean.getPopularAppBeanList(),packageName));
        adapter.addSection(new AppRecommendTasteSection(getContext(),"兴趣相近的用户也安装了",appRecommendBean.getTasteAppBeanList(),packageName));
        adapter.addSection(new AppRecommendHotSection(getContext(),"本周热议的社区应用",appRecommendBean.getHotAppBeanList(),packageName));
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onAppRecommendDataSuccess(AppRecommendBean appRecommendBean) {
        this.appRecommendBean = appRecommendBean ;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onAppRecommendDataError(String msg) {
        setState(LoadingPager.LoadResult.error);
    }

    @Override
    protected AppRecommendFragmentPresenterImpl initInjector() {
        mFragmentComponent.inject(this);
        return appRecommendFragmentPresenter;
    }
}
