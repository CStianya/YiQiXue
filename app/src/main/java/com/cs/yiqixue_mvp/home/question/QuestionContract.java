package com.cs.yiqixue_mvp.home.question;

import com.cs.yiqixue_mvp.bean.Question;
import com.cs.yiqixue_mvp.base.BasePresenter;
import com.cs.yiqixue_mvp.base.BaseView;

import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public interface QuestionContract {

    interface View extends BaseView<Presenter> {

        void setQuestionList(List<Question> questionList);

        void showRefreshedData();
    }

    interface Presenter extends BasePresenter {

        List<Question> initQuestionData();

        void refreshQuestionData();
    }

}
