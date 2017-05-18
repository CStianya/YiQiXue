package com.cs.yiqixue_mvp.question;

import android.support.v4.app.Fragment;

import com.cs.yiqixue_mvp.bean.Question;
import com.cs.yiqixue_mvp.common.BasePresenter;
import com.cs.yiqixue_mvp.common.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public interface QuestionContrat {

    interface View extends BaseView<Presenter> {

        void setQuestionList(List<Question> questionList);

        void showRefreshedData();

    }

    interface Presenter extends BasePresenter {

        List<Question> initQuestionData();

        void refreshQuestionData();
    }

}