package com.whty.zd.appstore.mvp.view.activity;

import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.whty.zd.appstore.R;
import com.whty.zd.appstore.base.BaseActivity;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.title_text)
    TextView title_text ;
    @BindView(R.id.iv_search)
    ImageView iv_search ;
    @BindView(R.id.wv)
    WebView wv ;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_web_view);
    }

    @Override
    protected void initView() {
        String name = getIntent().getStringExtra("name");
        String url = getIntent().getStringExtra("url");

        //设置沉浸式状态栏
        setStatusBar();
        iv_search.setVisibility(View.VISIBLE);
        //设置沉浸式状态栏背景
        title_bar.setBackgroundResource(R.color.black_alpha_5);

        title_text.setText(name);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }
        });
        wv.getSettings().setJavaScriptEnabled(true);

        wv.loadUrl(url);
    }
}
