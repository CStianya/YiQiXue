package com.cs.yiqixue_mvp.home.answer;

import com.cs.yiqixue_mvp.bean.Answer;
import com.cs.yiqixue_mvp.model.AnswerModel;
import com.cs.yiqixue_mvp.model.IAnswerModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CS on 2017/5/18.
 */

public class AnswerPresenter implements AnswerContract.Presenter {

    AnswerContract.View mAnswerView;

    IAnswerModel mAnswerModel;

    public AnswerPresenter(AnswerContract.View answerView) {
        mAnswerView = answerView;
        answerView.setPresenter(this);

        mAnswerModel = new AnswerModel();
    }

    @Override
    public void start() {

    }

    @Override
    public List<Answer> initAnswerData() {
        return mAnswerModel.initData();
    }

    @Override
    public void refreshAnswerData() {
        Observable.just(mAnswerModel.getRefreshedData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Answer>>() {
                    @Override
                    public void accept(@NonNull List<Answer> answers) throws Exception {
                        mAnswerView.setAnswerList(answers);
                        mAnswerView.showRefreshedData();
                    }
                });
    }
}
