package com.whty.zd.appstore.adapter.top;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.whty.zd.appstore.R;
import com.whty.zd.appstore.bean.CategoryNewBean;
import com.whty.zd.appstore.utils.UIUtils;
import com.whty.zd.smartpos.library.recyclerview.wrapper.HeaderAndFooterWrapper;

/**
 * <p>Description:
 *
 * @author wangwei
 */

public class CategoryNewTopWrapper extends HeaderAndFooterWrapper {

    private Context mContext ;
    private View headerView ;
    private CategoryNewBean.Head head ;

    public CategoryNewTopWrapper(Context context, RecyclerView.Adapter adapter, CategoryNewBean.Head head) {
        super(adapter);
        this.mContext = context ;
        this.head = head ;
        headerView = UIUtils.inflate(R.layout.head_category_necessary);
        addHeaderView(headerView);

        TextView intro = (TextView) headerView.findViewById(R.id.intro);
        ImageView iv = (ImageView) headerView.findViewById(R.id.iv);

        intro.setText(head.getIntro());
        System.out.println("icon:"+head.getIcon());
        Glide.with(UIUtils.getContext()).load(head.getIcon()).into(iv);


    }


}
