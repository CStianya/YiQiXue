package com.cs.yiqixue_mvp.mvp.home.comment;

import dagger.Component;

/**
 * Created by CS on 2017/5/30.
 */

@Component(modules = CommentPresenterModule.class)
public interface CommentComponent {

    void inject(CommentActivity activity);
}
