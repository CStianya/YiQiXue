package com.cs.yiqixue_mvp.home.questiondetail;

import android.content.Context;
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
import com.cs.yiqixue_mvp.home.question.QuestionContract;
import com.cs.yiqixue_mvp.utils.LogUtil;
import com.cs.yiqixue_mvp.utils.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class AnswerActivity extends BaseActivity implements AnswerContract.View {

    private AnswerContract.Presenter mPresenter;
    private AnswerAdapter mAnswerAdapter;
    private List<Answer> mAnswerList;

    private TextView mAnswerTV;

    @Override
    public void initData(Bundle parms) {
        if (mAnswerList == null) {
            initDatas();
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

        mAnswerTV = $(R.id.tv_new_answer);
    }

    @Override
    public void setListener() {
        mAnswerTV.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.tv_new_answer:
                //startActivity(NewAnswerActivity.class);
                break;
        }
    }

    private void initDatas() {
        mAnswerList = new ArrayList<>();
        Answer answer1 = new Answer();
        answer1.setUser("华仔");
        answer1.setContens("可导一定连续,连续不一定可导  证明：（1）可导一定连续  设y=f(x)在x0处可导,f'(x0)=A  由可导的充分必要条件有  f(x)=f(x0)+A(x-x0)+o（│...");
        answer1.setTime("2017-01-01");
        answer1.setReplayNumbers(66);
        answer1.setLikeNumbers(999);
        mAnswerList.add(answer1);

/*        Answer answer2 = new Answer();
        answer2.setUser("隔壁老王");
        answer2.setContens("因为函数可导,根据可导的定义有\n" +
                "limΔy/Δx=A (Δx趋向于0)\n" +
                "所以\n" +
                "Δy/Δx=A+α (α是Δx趋向于0时的无穷小)\n" +
                "从而\n" +
                "Δy=AΔx+αΔx\n" +
                "当Δx趋向于0时,显然limΔy=0\n" +
                "由连续定义有\n" +
                "函数连续.\n" +
                "连续未必可导,比如y=|x|在x=0处连续,但左导数=-1,右导数=1,不可导.");
        answer2.setTime("2017-05-02");
        answer2.setReplayNumbers(30);
        answer2.setLikeNumbers(454);
        mAnswerList.add(answer2);

        Answer answer3 = new Answer();
        answer3.setUser("李紧");
        answer3.setContens("因为函数可导,根据可导的定义有\n" +
                "limΔy/Δx=A (Δx趋向于0)。所以\n" +
                "Δy/Δx=A+α (α是Δx趋向于0时的无穷小)。从而\n" +
                "Δy=AΔx+αΔx\n" +
                "当Δx趋向于0时,显然limΔy=0\n" +
                "由连续定义有：函数连续.\n" +
                "连续未必可导,比如y=|x|在x=0处连续,但左导数=-1,右导数=1,不可导.");
        answer3.setTime("2017-05-02");
        answer3.setReplayNumbers(30);
        answer3.setLikeNumbers(454);
        mAnswerList.add(answer3);*/
        for (int i = 0; i < 10; i ++) {
            mAnswerList.add(answer1);
        }
    }

    private void refreshDatasOnRxJava() {
        Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        LogUtil.d("" + integer);
                    }
                });
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
                refreshDatasOnRxJava();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(AnswerContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setAnswerList(List<Answer> questionList) {

    }

    @Override
    public void showShare() {
        /*        OnekeyShare oks = new OnekeyShare();
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
        oks.show(this);*/
    }
}
