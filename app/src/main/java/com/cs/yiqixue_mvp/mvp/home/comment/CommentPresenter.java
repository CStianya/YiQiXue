package com.cs.yiqixue_mvp.mvp.home.comment;

import com.cs.yiqixue_mvp.api.bean.Comment;
import com.cs.yiqixue_mvp.model.CommentModel;
import com.cs.yiqixue_mvp.model.ICommentModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CS on 2017/5/19.
 */

public class CommentPresenter implements CommentContract.Presenter {

    CommentContract.View mCommentView;

    ICommentModel mCommentModel;

    @Inject
    public CommentPresenter(CommentContract.View commentView) {
        mCommentView = commentView;
        mCommentView.setPresenter(this);

        mCommentModel = new CommentModel();
    }

    @Override
    public List<Comment> initCommentData() {
        return mCommentModel.initData();
    }

    @Override
    public void refreshCommentData() {
        Observable.just(mCommentModel.getRefreshedData())
                .subscribeOn(Schedulers.io())
                .delay(1200, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Comment>>() {
                    @Override
                    public void accept(@NonNull List<Comment> comments) throws Exception {
                        mCommentView.setCommentList(comments);
                        mCommentView.showRefreshedData();
                    }
                });
    }

    @Override
    public void start() {

    }
}
