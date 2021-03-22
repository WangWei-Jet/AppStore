package com.whty.zd.appstore.adapter.top;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import com.whty.zd.appstore.banner.RecommendController;
import com.whty.zd.smartpos.library.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.List;

/**
 * @author: wangwei
 * @date: 2017/8/23 22:12
 * @desciption:
 */

public class RecommendTopWrapper extends HeaderAndFooterWrapper {

    private Context mContext;
    private RecommendController mController;

    public RecommendTopWrapper(Context context, RecyclerView.Adapter adapter) {
        super(adapter);
        mContext = context;
        mController = new RecommendController(mContext);
        addHeaderView(mController.getContentView());
    }

    public void addDataAll(List<String> list) {
        if (mController != null) {
            mController.setData(list);
        }
    }
}
