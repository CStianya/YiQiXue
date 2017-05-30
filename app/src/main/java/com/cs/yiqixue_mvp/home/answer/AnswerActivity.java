package com.cs.yiqixue_mvp.home.answer;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cs.yiqixue_mvp.R;
import com.cs.yiqixue_mvp.bean.Answer;
import com.cs.yiqixue_mvp.base.BaseActivity;
import com.cs.yiqixue_mvp.home.addanswer.AddAnswerActivity;
import com.cs.yiqixue_mvp.utils.RecyclerViewDivider;

import java.util.List;

import javax.inject.Inject;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class AnswerActivity extends BaseActivity implements AnswerContract.View {

    @Inject AnswerPresenter mPresenter;

    private AnswerAdapter mAnswerAdapter;
    private List<Answer> mAnswerList;

    private TextView mAddAnswerTV;

    @Override
    public void initData(Bundle parms) {
        DaggerAnswerComponent.builder()
                .answerPresenterModule(new AnswerPresenterModule(this)).build()
                .inject(this);
        if (mAnswerList == null) {
            mAnswerList = mPresenter.initAnswerData();
        }
        if (mAnswerAdapter == null) {
            mAnswerAdapter = new AnswerAdapter(mAnswerList);
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.answer_act;
    }

    @Override
    public void initView(View view) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("问题");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView mRecyclerView;
        mRecyclerView = $(R.id.recycle_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(RecyclerViewDivider.getInstance());
        mRecyclerView.setAdapter(mAnswerAdapter);

        mAddAnswerTV = $(R.id.tv_add_answer);
    }

    @Override
    public void setListener() {
        mAddAnswerTV.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add_answer:
                startActivity(AddAnswerActivity.class);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu .findItem(R.id.ab_save).setVisible(false);
        menu .findItem(R.id.ab_search).setVisible(false);
        menu .findItem(R.id.ab_edit).setVisible(false);
        menu .findItem(R.id.ab_share).setVisible(true);
        menu .findItem(R.id.ab_more).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
            case R.id.ab_share:
                showShare();
                break;
            case R.id.ab_more:
                mPresenter.refreshAnswerData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(AnswerPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setAnswerList(List<Answer> questionList) {

    }

    @Override
    public void showRefreshedData() {
        mAnswerAdapter.notifyDataSetChanged();
        showToast("刷新成功");
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }
}
