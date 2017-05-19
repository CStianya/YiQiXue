package com.cs.yiqixue_mvp.model;

import com.cs.yiqixue_mvp.bean.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by CS on 2017/5/18.
 */

public class AnswerModel implements IAnswerModel {

    private List<Answer> answerList;

    private Answer[] answers;

    @Override
    public List<Answer> initData() {
        answerList = new ArrayList<>();
        answers = new Answer[3];

        answers[0] = new Answer();
        answers[0].setUser("华仔");
        answers[0].setContens("可导一定连续,连续不一定可导  证明：（1）可导一定连续  设y=f(x)在x0处可导,f'(x0)=A  由可导的充分必要条件有  f(x)=f(x0)+A(x-x0)+o（│...");
        answers[0].setTime("2017-01-01");
        answers[0].setReplayNumbers(66);
        answers[0].setLikeNumbers(999);

        answers[1] = new Answer();
        answers[1].setUser("隔壁老王");
        answers[1].setContens("因为函数可导,根据可导的定义有\n" +
                "limΔy/Δx=A (Δx趋向于0)\n" +
                "所以\n" +
                "Δy/Δx=A+α (α是Δx趋向于0时的无穷小)\n" +
                "从而\n" +
                "Δy=AΔx+αΔx\n" +
                "当Δx趋向于0时,显然limΔy=0\n" +
                "由连续定义有\n" +
                "函数连续.\n" +
                "连续未必可导,比如y=|x|在x=0处连续,但左导数=-1,右导数=1,不可导.");
        answers[1].setTime("2017-05-02");
        answers[1].setReplayNumbers(30);
        answers[1].setLikeNumbers(454);

        answers[2] = new Answer();
        answers[2].setUser("李紧");
        answers[2].setContens("因为函数可导,根据可导的定义有\n" +
                "limΔy/Δx=A (Δx趋向于0)。所以\n" +
                "Δy/Δx=A+α (α是Δx趋向于0时的无穷小)。从而\n" +
                "Δy=AΔx+αΔx\n" +
                "当Δx趋向于0时,显然limΔy=0\n" +
                "由连续定义有：函数连续.\n" +
                "连续未必可导,比如y=|x|在x=0处连续,但左导数=-1,右导数=1,不可导.");
        answers[2].setTime("2017-05-02");
        answers[2].setReplayNumbers(30);
        answers[2].setLikeNumbers(454);

        for (int i = 0; i < 10; i ++) {
            answerList.add(answers[new Random().nextInt(3)]);
        }
        return answerList;
    }

    @Override
    public List<Answer> getRefreshedData() {
        answerList.clear();
        for (int i = 0; i < 10; i ++) {
            answerList.add(answers[new Random().nextInt(3)]);
        }
        return answerList;
    }
}
