package com.cs.yiqixue_mvp.home.answer;

import com.cs.yiqixue_mvp.home.comment.CommentActivity;
import com.cs.yiqixue_mvp.home.comment.CommentPresenterModule;

import dagger.Component;

/**
 * Created by CS on 2017/5/30.
 */

@Component(modules = AnswerPresenterModule.class)
public interface AnswerComponent {

    void inject(AnswerActivity activity);
}
