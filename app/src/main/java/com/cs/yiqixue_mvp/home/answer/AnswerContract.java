package com.cs.yiqixue_mvp.home.answer;

import com.cs.yiqixue_mvp.base.BasePresenter;
import com.cs.yiqixue_mvp.base.BaseView;
import com.cs.yiqixue_mvp.bean.Answer;

import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public interface AnswerContract {

    interface View extends BaseView<AnswerContract.Presenter> {

        void setAnswerList(List<Answer> questionList);

        void showRefreshedData();
    }

    interface Presenter extends BasePresenter {

        List<Answer> initAnswerData();

        void refreshAnswerData();
    }

}
