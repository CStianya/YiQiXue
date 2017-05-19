package com.cs.yiqixue_mvp.model;

import com.cs.yiqixue_mvp.bean.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS on 2017/5/19.
 */

public class CommentModel implements ICommentModel {

    private List<Comment> commentList;

    private Comment[] comments;

    @Override
    public List<Comment> initData() {
        commentList = new ArrayList<>();
        comments = new Comment[3];

        comments[0] = new Comment();
        comments[0].setUser("华仔");
        comments[0].setContens("这答案厉害了！谁写的这么棒！");
        comments[0].setTime("2017-01-01");
        comments[0].setLikeNumbers(666);

        for (int i = 0; i < 10; i ++) {
            commentList.add(comments[0]);
        }
        return commentList;
    }

    @Override
    public List<Comment> getRefreshedData() {
        return commentList;
    }
}
