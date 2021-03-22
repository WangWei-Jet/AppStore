package com.whty.zd.appstore.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whty.zd.appstore.R;
import com.whty.zd.appstore.base.BaseMvpActivity;
import com.whty.zd.appstore.bean.AppBean;
import com.whty.zd.appstore.bean.CategorySubscribeBean;
import com.whty.zd.appstore.mvp.presenter.impl.CategorySubscribePresenterImpl;
import com.whty.zd.appstore.mvp.view.view.CategorySubscribeView;
import com.whty.zd.smartpos.library.recyclerview.adapter.CommonAdapter;
import com.whty.zd.smartpos.library.recyclerview.adapter.MultiItemTypeAdapter;
import com.whty.zd.smartpos.library.recyclerview.base.ViewHolder;

import javax.inject.Inject;

import butterknife.BindView;

public class CategorySubscribeActivity extends BaseMvpActivity<CategorySubscribePresenterImpl> implements CategorySubscribeView {

    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.rv)
    RecyclerView rv;

    @Inject
    public CategorySubscribePresenterImpl categorySubscribePresenter;
    private CategorySubscribeBean mCategorySubscribeBean;


    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_category_subscribe);
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏
        setStatusBar();
        iv_search.setVisibility(View.VISIBLE);
        //设置沉浸式状态栏背景
        title_bar.setBackgroundResource(R.color.black_alpha_5);

        title_text.setText("预约");
    }

    @Override
    protected void initData() {
        super.initData();
        categorySubscribePresenter.getCategorySubscribeData(this);
    }

    @Override
    protected CategorySubscribePresenterImpl initInjector() {
        mActivityComponent.inject(this);
        return categorySubscribePresenter;
    }

    @Override
    public void onCategorySubscribeDataSuccess(CategorySubscribeBean categorySubscribeBean) {
        this.mCategorySubscribeBean = categorySubscribeBean;
        rv.setLayoutManager(new LinearLayoutManager(this));
        CategorySubscribeAdapter adapter = new CategorySubscribeAdapter(this);
        adapter.addDataAll(categorySubscribeBean.getAppBeanList());
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                System.out.println("detailId:" + mCategorySubscribeBean.getAppBeanList().get(position).getDetailId());
                Intent intent = new Intent(CategorySubscribeActivity.this, WebViewActivity.class);
                intent.putExtra("name", mCategorySubscribeBean.getAppBeanList().get(position).getName());
                intent.putExtra("url", mCategorySubscribeBean.getAppBeanList().get(position).getDetailId());
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                return false;
            }
        });


    }

    @Override
    public void onCategorySubscribeDataError(String msg) {

    }

    public class CategorySubscribeAdapter extends CommonAdapter<AppBean> {

        public CategorySubscribeAdapter(Context context) {
            super(context, R.layout.applistitem_recommend);
        }

        @Override
        protected void convert(ViewHolder holder, AppBean appBean, int position) {
            holder.setText(R.id.appTitle, appBean.getName());
            holder.setText(R.id.app_size, appBean.getSizeDesc());
            holder.setText(R.id.app_des, appBean.getMemo());
            holder.setImageUrl(R.id.appicon, appBean.getIcon());
        }
    }
}
