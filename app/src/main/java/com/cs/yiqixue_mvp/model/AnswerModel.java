package com.cs.yiqixue_mvp.model;

import com.cs.yiqixue_mvp.bean.Answer;

import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public class AnswerModel implements IAnswerModel {

    private List<Answer> questionList;
    private Answer[] answers = new Answer[3];

    @Override
    public List<Answer> initData() {
        return null;
    }

    @Override
    public List<Answer> getRefreshedData() {
        return null;
    }
}
