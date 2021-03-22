package com.whty.zd.appstore.mvp.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.whty.zd.appstore.R;
import com.whty.zd.appstore.adapter.section.CategoryContactsSection;
import com.whty.zd.appstore.adapter.top.CategoryTopWrapper;
import com.whty.zd.appstore.base.BaseMvpFragment;
import com.whty.zd.appstore.bean.CategoryBean;
import com.whty.zd.appstore.mvp.presenter.CategoryFragmentPresenter;
import com.whty.zd.appstore.mvp.presenter.impl.CategoryPresenterImpl;
import com.whty.zd.appstore.mvp.view.activity.CategoryNecessaryActivity;
import com.whty.zd.appstore.mvp.view.activity.CategoryNewActivity;
import com.whty.zd.appstore.mvp.view.activity.CategorySubjectActivity;
import com.whty.zd.appstore.mvp.view.activity.CategorySubscribeActivity;
import com.whty.zd.appstore.mvp.view.activity.CategoryToolActivity;
import com.whty.zd.appstore.mvp.view.activity.HomeActivity;
import com.whty.zd.appstore.mvp.view.view.CategoryFragmentView;
import com.whty.zd.appstore.utils.UIUtils;
import com.whty.zd.appstore.view.LoadingPager;
import com.whty.zd.appstore.view.widget.ViewUpSearch;
import com.whty.zd.smartpos.library.recyclerview.section.SectionRVAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 分类
 */
public class CategoryFragment extends BaseMvpFragment<CategoryFragmentPresenter> implements CategoryFragmentView {

    private final static String TAG = "CategoryFragment";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.search)
    ViewUpSearch mSearch;

    private CategoryBean mCategoryBean;
    private boolean isExpand = true;

    @Inject
    public CategoryPresenterImpl mCategoryPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    protected void load() {
        //发起网络请求
        mPresenter.getCategoryData(getHoldingActivity());
    }

    @Override
    protected View createSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_category);
        ButterKnife.bind(this, view);
        SectionRVAdapter adapter = new SectionRVAdapter(getHoldingActivity());
        CategoryContactsSection categoryContactsSection = new CategoryContactsSection(getHoldingActivity(),
                mCategoryBean.getTitle(), mCategoryBean.getCategoryDataBeanList());
        adapter.addSection(categoryContactsSection);

        CategoryTopWrapper categoryTopWrapper = new CategoryTopWrapper(getContext(), adapter);
        categoryTopWrapper.addDataAll(mCategoryBean.getCategoryTopBeanList());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getHoldingActivity()));
        mRecyclerView.setAdapter(categoryTopWrapper);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItemPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                //悬浮框的展开和收起都是在第一个item时有效
                //dy>0(上拉，悬浮框收起，只有之前是打开状态才收起)
                if (firstVisibleItemPosition == 0 && dy > 0 && isExpand) {
                    mSearch.updateShow(!isExpand);
                    isExpand = false;
                } else if (firstVisibleItemPosition == 0 && dy < 0 && !isExpand) {
                    //dy<0(下拉，悬浮框展开，只有之前是收起状态才收起)
                    mSearch.updateShow(!isExpand);
                    isExpand = true;
                }
            }
        });

        categoryContactsSection.setOnItemClickListener(new CategoryContactsSection.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(),CategoryToolActivity.class) ;
                intent.putExtra("name",mCategoryBean.getCategoryDataBeanList().get(position).getName());
                ((HomeActivity)getActivity()).startActivity(intent);

            }
        });

        categoryTopWrapper.setOnItemClickListener(new CategoryTopWrapper.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position == 0){
                    mActivity.startActivity(new Intent(mActivity, CategorySubscribeActivity.class));
                }else if(position == 1){
                    mActivity.startActivity(new Intent(mActivity,CategoryNecessaryActivity.class));
                }else if(position == 2){
                    mActivity.startActivity(new Intent(mActivity,CategoryNewActivity.class));
                }else {
                    mActivity.startActivity(new Intent(mActivity,CategorySubjectActivity.class));
                }
            }
        });
        return view;
    }

    @Override
    public void onCategoryDataSuccess(CategoryBean categoryBean) {
        mCategoryBean = categoryBean;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onCategoryDataError(String msg) {
        setState(LoadingPager.LoadResult.error);
    }

    @Override
    protected CategoryFragmentPresenter initInjector() {
        mFragmentComponent.inject(this);
        return mCategoryPresenter;
    }

}
