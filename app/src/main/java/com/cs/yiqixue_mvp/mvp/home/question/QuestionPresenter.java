package com.cs.yiqixue_mvp.mvp.home.question;

import android.os.Handler;

import com.cs.yiqixue_mvp.api.bean.Question;
import com.cs.yiqixue_mvp.model.IQuestionModel;
import com.cs.yiqixue_mvp.model.QuestionModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by CS on 2017/5/18.
 */

public class QuestionPresenter implements QuestionContract.Presenter {

    QuestionContract.View mQuestionView;

    IQuestionModel mQuestionModel;

    @Inject
    public QuestionPresenter(QuestionContract.View questionView) {
        mQuestionView = questionView;
        mQuestionView.setPresenter(this);

        mQuestionModel = new QuestionModel();
    }

    @Override
    public void start() {

    }

    @Override
    public List<Question> initQuestionData() {
        return mQuestionModel.initData();
    }

    @Override
    public void refreshQuestionData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mQuestionView.setQuestionList(mQuestionModel.getRefreshedData());
                mQuestionView.showRefreshedData();
            }
        }, 1200);
    }

}
