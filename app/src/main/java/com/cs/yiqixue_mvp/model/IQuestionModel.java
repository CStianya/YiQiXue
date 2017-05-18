package com.cs.yiqixue_mvp.model;

import com.cs.yiqixue_mvp.bean.Question;

import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public interface IQuestionModel {

    List<Question> initData();

    List<Question> getRefreshedData();

}
