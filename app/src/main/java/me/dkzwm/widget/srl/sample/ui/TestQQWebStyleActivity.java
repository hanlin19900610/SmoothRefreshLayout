package me.dkzwm.widget.srl.sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;

import me.dkzwm.widget.srl.SmoothRefreshLayout;
import me.dkzwm.widget.srl.sample.R;
import me.dkzwm.widget.srl.sample.header.CustomQQWebHeader;
import me.dkzwm.widget.srl.sample.widget.CompatXWalkView;

/**
 * Created by dkzwm on 2017/6/27.
 *
 * @author dkzwm
 */
public class TestQQWebStyleActivity extends AppCompatActivity {
    private SmoothRefreshLayout mRefreshLayout;
    private CompatXWalkView mWebView;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_qq_web_style_with_xwalkview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.test_qq_web_style);
        mRefreshLayout = findViewById(R.id.smoothRefreshLayout_with_webView_activity);
        mRefreshLayout.setHeaderView(new CustomQQWebHeader(this));
        mRefreshLayout.setDisablePerformRefresh(true);
        mRefreshLayout.setDisableLoadMore(false);
        mRefreshLayout.setDisablePerformLoadMore(true);
        mRefreshLayout.setEnableHideFooterView(true);
        mRefreshLayout.setEnableHeaderDrawerStyle(true);
        mRefreshLayout.setCanMoveTheMaxRatioOfHeaderHeight(1);
        mWebView = findViewById(R.id.xWalkView_text_qq_web_style_with_xWalkView_activity);
        mWebView.loadUrl("https://github.com/dkzwm");
        mWebView.addOnScrollChangeListeners(new CompatXWalkView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(int var2, int var3, int var4, int var5) {
                mRefreshLayout.onScrollChanged();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TestQQWebStyleActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }


}
