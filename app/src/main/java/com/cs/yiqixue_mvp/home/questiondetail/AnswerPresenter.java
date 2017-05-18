package com.cs.yiqixue_mvp.home.questiondetail;

import com.cs.yiqixue_mvp.base.BasePresenter;
import com.cs.yiqixue_mvp.base.BaseView;
import com.cs.yiqixue_mvp.bean.Answer;
import com.cs.yiqixue_mvp.home.question.QuestionContract;
import com.cs.yiqixue_mvp.model.AnswerModel;
import com.cs.yiqixue_mvp.model.IAnswerModel;

import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public class AnswerPresenter implements AnswerContract.Presenter {

    AnswerContract.View mAnswerView;

    IAnswerModel mAnswerModel;

    public AnswerPresenter(AnswerContract.View answerView) {
        mAnswerView = answerView;
        answerView.setPresenter(this);

        mAnswerModel = new AnswerModel();
    }

    @Override
    public void start() {

    }

    @Override
    public List<Answer> initAnswerData() {
        return null;
    }

    @Override
    public void refreshAnswerData() {

    }
}
