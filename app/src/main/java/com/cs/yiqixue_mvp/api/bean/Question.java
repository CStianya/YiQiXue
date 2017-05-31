package com.cs.yiqixue_mvp.api.bean;

/**
 * Created by CSLaker on 2017/3/25.
 */

public class Question {

    private String mSubject;
    private String mTitle;
    private String mContens;
    private int mAnswerNumbers;
    private int mLikeNumbers;

    public Question() {}

    public String getContens() {
        return mContens;
    }

    public void setContens(String contens) {
        mContens = contens;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getAnswerNumbers() {
        return mAnswerNumbers;
    }

    public void setAnswerNumbers(int answerNumbers) {
        mAnswerNumbers = answerNumbers;
    }

    public int getLikeNumbers() {
        return mLikeNumbers;
    }

    public void setLikeNumbers(int likeNumbers) {
        mLikeNumbers = likeNumbers;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

}
