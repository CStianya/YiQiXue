package com.cs.yiqixue_mvp.api.bean;

/**
 * Created by CSLaker on 2017/3/25.
 */

public class Question {

    private String subject;
    private String title;
    private String contens;
    private int answerNumbers;
    private int likeNumbers;

    public Question() {}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContens() {
        return contens;
    }

    public void setContens(String contens) {
        this.contens = contens;
    }

    public int getAnswerNumbers() {
        return answerNumbers;
    }

    public void setAnswerNumbers(int answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public int getLikeNumbers() {
        return likeNumbers;
    }

    public void setLikeNumbers(int likeNumbers) {
        this.likeNumbers = likeNumbers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", contens='" + contens + '\'' +
                ", answerNumbers=" + answerNumbers +
                ", likeNumbers=" + likeNumbers +
                '}';
    }
}
