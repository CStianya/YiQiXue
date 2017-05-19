package com.cs.yiqixue_mvp.home.comment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.cs.yiqixue_mvp.R;
import com.cs.yiqixue_mvp.base.BaseActivity;
import com.cs.yiqixue_mvp.base.BaseCallback;
import com.cs.yiqixue_mvp.bean.Comment;
import com.cs.yiqixue_mvp.utils.OkHttpUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class CommentActivity extends BaseActivity implements CommentContract.View {

    private CommentContract.Presenter mPresenter;
    private CommentAdapter mCommentAdapter;
    private List<Comment> mCommentList;

    private PullToRefreshListView mPullToRefreshLV;

    @Override
    public void initData(Bundle parms) {
        mPresenter = new CommentPresenter(this);
        if (mCommentList == null) {
            mCommentList = mPresenter.initCommentData();
        }
        if (mCommentAdapter == null) {
            mCommentAdapter = new CommentAdapter(mCommentList);
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.comment_act;
    }

    @Override
    public void initView(View view) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("评论");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPullToRefreshLV = $(R.id.pull_to_refresh_lv);
        initPullToRefreshLV();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    private void initPullToRefreshLV() {
        mPullToRefreshLV.setAdapter(mCommentAdapter);
        mPullToRefreshLV.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshLV.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                mPresenter.refreshCommentData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                mPullToRefreshLV.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshLV.onRefreshComplete();//上拉加载更多结束，上拉加载头复位
                    }
                }, 1200);
            }
        });
        // 设置PullRefreshListView上提加载时的加载提示
        mPullToRefreshLV.getLoadingLayoutProxy(false,true).setPullLabel("上拉加载更多.");
        mPullToRefreshLV.getLoadingLayoutProxy(false,true).setRefreshingLabel("正在加载数据...");
        mPullToRefreshLV.getLoadingLayoutProxy(false,true).setReleaseLabel("松开加载更多...");
        // 设置PullRefreshListView下拉加载时的加载提示
        mPullToRefreshLV.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        mPullToRefreshLV.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
        mPullToRefreshLV.getLoadingLayoutProxy(true,false).setReleaseLabel("松开刷新...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu .findItem(R.id.ab_save).setVisible(false);
        menu .findItem(R.id.ab_search).setVisible(false);
        menu .findItem(R.id.ab_edit).setVisible(true);
        menu .findItem(R.id.ab_share).setVisible(false);
        menu .findItem(R.id.ab_more).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setCommentList(List<Comment> commentList) {
        mCommentList = commentList;
    }

    @Override
    public void showRefreshedData() {
        mCommentAdapter.notifyDataSetChanged();
        //上拉加载更多结束，上拉加载头复位
        mPullToRefreshLV.onRefreshComplete();
        showToast("刷新成功");
    }

    @Override
    public void setPresenter(CommentContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
