package com.cs.yiqixue_mvp.model;

import com.cs.yiqixue_mvp.bean.Comment;

import java.util.List;

/**
 * Created by CS on 2017/5/19.
 */

public interface ICommentModel {

    List<Comment> initData();

    List<Comment> getRefreshedData();
}
