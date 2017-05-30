package com.cs.yiqixue_mvp.home.question;

import dagger.Component;

/**
 * Created by CS on 2017/5/30.
 */

@Component(modules = QuestionPresenterModule.class)
public interface QuestionComponent {

    void inject(QuestionActivity activity);
}
