package com.cs.yiqixue_mvp.mvp.home.answerdetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cs.yiqixue_mvp.R;
import com.cs.yiqixue_mvp.base.BaseActivity;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class AnswerDetailActivity extends BaseActivity {

    @Override
    public void initData(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.answer_detail_act;
    }

    @Override
    public void initView(View view) {
        Toolbar toolbar = $(R.id.toolbar);
        toolbar.setTitle("答案");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void widgetClick(View v) {

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

    @Override
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
        }
        return super.onOptionsItemSelected(item);
    }
}
