package com.cs.yiqixue_mvp.question;

import android.os.Handler;

import com.cs.yiqixue_mvp.bean.Question;
import com.cs.yiqixue_mvp.model.IQuestionModel;
import com.cs.yiqixue_mvp.model.QuestionModel;

import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public class QuestionPresenter implements QuestionContrat.Presenter {

    QuestionContrat.View mQuestionView;

    IQuestionModel mQuestionModel;

    public QuestionPresenter(QuestionContrat.View questionView) {
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
