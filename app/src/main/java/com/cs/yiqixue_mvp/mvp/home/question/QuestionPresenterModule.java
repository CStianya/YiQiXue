package com.cs.yiqixue_mvp.mvp.home.question;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CS on 2017/5/30.
 */

@Module
public class QuestionPresenterModule {

    private final QuestionContract.View mView;

    public QuestionPresenterModule(QuestionContract.View view) {
        mView = view;
    }

    @Provides
    QuestionContract.View provideQuestionContractView() {
        return mView;
    }
}
