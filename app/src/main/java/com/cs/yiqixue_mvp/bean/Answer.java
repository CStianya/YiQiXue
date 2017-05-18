package com.cs.yiqixue_mvp.bean;

/**
 * Created by CSLaker on 2017/3/25.
 */

public class Answer {

    private String mUser;
    private String mContens;
    private String mTime;
    private int mReplayNumbers;
    private int mLikeNumbers;

    public Answer() {}

    public String getContens() {
        return mContens;
    }

    public void setContens(String contens) {
        mContens = contens;
    }

    public int getReplayNumbers() {
        return mReplayNumbers;
    }

    public void setReplayNumbers(int answerNumbers) {
        mReplayNumbers = answerNumbers;
    }

    public int getLikeNumbers() {
        return mLikeNumbers;
    }

    public void setLikeNumbers(int likeNumbers) {
        mLikeNumbers = likeNumbers;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String user) {
        mUser = user;
    }

}