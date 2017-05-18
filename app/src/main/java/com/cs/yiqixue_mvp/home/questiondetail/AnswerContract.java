package com.cs.yiqixue_mvp.home.questiondetail;

import com.cs.yiqixue_mvp.base.BasePresenter;
import com.cs.yiqixue_mvp.base.BaseView;
import com.cs.yiqixue_mvp.bean.Answer;
import com.cs.yiqixue_mvp.bean.Question;
import com.cs.yiqixue_mvp.home.question.QuestionContract;

import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public interface AnswerContract {

    interface View extends BaseView<AnswerContract.Presenter> {

        void setAnswerList(List<Answer> questionList);

        void showShare();
    }

    interface Presenter extends BasePresenter {

        List<Answer> initAnswerData();

        void refreshAnswerData();
    }

}
