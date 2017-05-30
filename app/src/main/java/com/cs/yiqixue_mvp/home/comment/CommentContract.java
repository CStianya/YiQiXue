package com.cs.yiqixue_mvp.home.comment;

import com.cs.yiqixue_mvp.base.BasePresenter;
import com.cs.yiqixue_mvp.base.BaseView;
import com.cs.yiqixue_mvp.bean.Comment;

import java.util.List;

/**
 * Created by CS on 2017/5/19.
 */

public interface CommentContract {

    interface View extends BaseView<CommentPresenter> {

        void setCommentList(List<Comment> commentList);

        void showRefreshedData();
    }

    interface Presenter extends BasePresenter {

        List<Comment> initCommentData();

        void refreshCommentData();
    }

}
