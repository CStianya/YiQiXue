package com.cs.yiqixue_mvp.home.comment;

import com.cs.yiqixue_mvp.bean.Comment;
import com.cs.yiqixue_mvp.home.question.QuestionActivity;
import com.cs.yiqixue_mvp.home.question.QuestionPresenterModule;

import dagger.Component;

/**
 * Created by CS on 2017/5/30.
 */

@Component(modules = CommentPresenterModule.class)
public interface CommentComponent {

    void inject(CommentActivity activity);
}
