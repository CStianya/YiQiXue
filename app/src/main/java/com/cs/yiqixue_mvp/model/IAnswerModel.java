package com.cs.yiqixue_mvp.model;

import com.cs.yiqixue_mvp.api.bean.Answer;

import java.util.List;

/**
 * Created by CS on 2017/5/18.
 */

public interface IAnswerModel {

    List<Answer> initData();

    List<Answer> getRefreshedData();
}
