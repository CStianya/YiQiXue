package com.cs.yiqixue_mvp.mvp.model;

import com.cs.yiqixue_mvp.bean.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by CS on 2017/5/18.
 */

public class QuestionModel implements IQuestionModel {

    private List<Question> questionList;
    private Question[] questions = new Question[3];

    @Override
    public List<Question> initData() {
        questionList = new ArrayList<>();

        questions[0] = new Question();
        questions[0].setSubject("公共基础：高等数学");
        questions[0].setTitle("如何证明：可导一定连续,连续不一定可导？");
        questions[0].setContens("(1）可导一定连续  设y=f(x)在x0处可导,f'(x0)=A由可导的充分必要条件有f(x)=f(x0)"
                + "+A(x-x0)+o（│x-x0│）,当x→x0时,f(x)=f(x0)+o（│x-x0│）(2）再...");
        questions[0].setAnswerNumbers(66);
        questions[0].setLikeNumbers(999);

        questions[1] = new Question();
        questions[1].setSubject("专业选修：计算机网络");
        questions[1].setTitle(" TCP/IP的核心思想(理念)是什么？");
        questions[1].setContens("TCP/IP的核心思想就是“网络互联”，将使用不同低层协议的异构网络，" +
                "在传输层、网络层建立一个统一的虚拟逻辑网络，以此来屏蔽所有物理网络的硬件差异，从而实现网络的互联.");
        questions[1].setAnswerNumbers(15);
        questions[1].setLikeNumbers(156);

        questions[2] = new Question();
        questions[2].setSubject("专业必修：Java程序设计");
        questions[2].setTitle("面向对象和面向过程的区别？");
        questions[2].setContens("面向过程就是分析出解决问题所需要的步骤，然后用函数把这些步骤一步一步实现，使用的时候一个一个依次调用就可以了。 \n" +
                "面向对象是把构成问题事务分解成各个对象，建立对象的目的不是为了完成一个步骤，而是为了描叙某个事物在整个解决问题的步骤中的行为。");
        questions[2].setAnswerNumbers(9);
        questions[2].setLikeNumbers(40);

        for (int i = 0; i < 10; i ++) {
            questionList.add(questions[new Random().nextInt(3)]);
        }
        return questionList;
    }

    @Override
    public List<Question> getRefreshedData() {
        questionList.clear();
        for (int i = 0; i < 10; i ++) {
            questionList.add(questions[new Random().nextInt(3)]);
        }
        return questionList;
    }

}
