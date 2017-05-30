package com.cs.yiqixue_mvp.home.comment;

import com.cs.yiqixue_mvp.home.question.QuestionContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CS on 2017/5/30.
 */

@Module
public class CommentPresenterModule {

    private final CommentContract.View mView;

    public CommentPresenterModule(CommentContract.View view) {
        mView = view;
    }

    @Provides
    CommentContract.View provideCommentContractView() {
        return mView;
    }
}
