package com.whty.zd.appstore.mvp.view.activity;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whty.zd.appstore.R;
import com.whty.zd.appstore.adapter.CategoryToolMultiAdapter;
import com.whty.zd.appstore.adapter.top.RecommendTopWrapper;
import com.whty.zd.appstore.base.BaseMvpActivity;
import com.whty.zd.appstore.bean.CategoryToolBean;
import com.whty.zd.appstore.mvp.presenter.impl.CategoryToolActivityPresenterImpl;
import com.whty.zd.appstore.mvp.view.view.CategoryToolActivityView;

import javax.inject.Inject;

import butterknife.BindView;

public class CategoryToolActivity extends BaseMvpActivity<CategoryToolActivityPresenterImpl> implements CategoryToolActivityView{

    @BindView(R.id.title_text)
    TextView title_text ;
    @BindView(R.id.iv_search)
    ImageView iv_search ;
    @BindView(R.id.rv)
    RecyclerView rv ;

    @Inject
    public CategoryToolActivityPresenterImpl categoryToolActivityPresenter ;

    private CategoryToolBean mCategoryToolBean ;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_category_tool);
    }

    @Override
    protected void initView() {
        String name = getIntent().getStringExtra("name");
        //设置沉浸式状态栏
        setStatusBar();
        iv_search.setVisibility(View.VISIBLE);
        //设置沉浸式状态栏背景
        title_bar.setBackgroundResource(R.color.black_alpha_5);
        title_text.setText(name);
    }

    @Override
    protected void initData() {
        super.initData();
        categoryToolActivityPresenter.getCategoryToolData(this);
    }

    @Override
    public void onCategoryToolDataSuccess(CategoryToolBean categoryToolBean) {
        this.mCategoryToolBean = categoryToolBean ;
        rv.setLayoutManager(new LinearLayoutManager(this));

        //主体adapter
        CategoryToolMultiAdapter adapter = new CategoryToolMultiAdapter(this);
        adapter.addDataAll(categoryToolBean.getCategoryToolAppBeanList());
        //头部轮播图
        RecommendTopWrapper topWrapper = new RecommendTopWrapper(this,adapter) ;
        topWrapper.addDataAll(categoryToolBean.getBannerList());
        adapter.setAppItemListener(new CategoryToolMultiAdapter.AppItemListener() {
            @Override
            public void goAppDetail(String packageName) {
                Intent intent = new Intent(CategoryToolActivity.this, AppDetailActivity.class);
                intent.putExtra("packageName",packageName) ;
                startActivity(intent);
            }
        });
        rv.setAdapter(topWrapper);
    }

    @Override
    public void onCategoryToolError(String msg) {

    }

    @Override
    protected CategoryToolActivityPresenterImpl initInjector() {
        mActivityComponent.inject(this);
        return categoryToolActivityPresenter;
    }
}
