package com.cs.yiqixue_mvp.mvp.home.answer;

import dagger.Component;

/**
 * Created by CS on 2017/5/30.
 */

@Component(modules = AnswerPresenterModule.class)
public interface AnswerComponent {

    void inject(AnswerActivity activity);
}
