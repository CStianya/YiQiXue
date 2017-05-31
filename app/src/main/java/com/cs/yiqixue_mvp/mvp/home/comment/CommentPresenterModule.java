package com.cs.yiqixue_mvp.mvp.home.comment;

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
