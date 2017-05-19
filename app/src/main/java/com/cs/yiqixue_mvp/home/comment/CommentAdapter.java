package com.cs.yiqixue_mvp.home.comment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cs.yiqixue_mvp.R;
import com.cs.yiqixue_mvp.bean.Comment;
import com.cs.yiqixue_mvp.utils.MyApplication;

import java.util.List;

/**
 * Created by CSLaker on 2017/3/25.
 */

public class CommentAdapter extends BaseAdapter {

    private List<Comment> mDatas = null;

    public CommentAdapter(List<Comment> datas) {
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(MyApplication.getContext(), R.layout.comment_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mUserTV.setText(mDatas.get(i).getUser());
        viewHolder.mContentsTV.setText(mDatas.get(i).getContens());
        viewHolder.mTimeTV.setText(mDatas.get(i).getTime());
        viewHolder.mLikeTV.setText(mDatas.get(i).getLikeNumbers() + "");
        return view;
    }

    class ViewHolder {

        public TextView mUserTV;
        public TextView mContentsTV;
        public TextView mTimeTV;
        public TextView mLikeTV;

        public ViewHolder(View view) {
            mUserTV = (TextView) view.findViewById(R.id.tv_replay_user);
            mContentsTV = (TextView) view.findViewById(R.id.tv_replay_contents);
            mTimeTV = (TextView) view.findViewById(R.id.tv_replay_time);
            mLikeTV = (TextView) view.findViewById(R.id.tv_replay_like);
        }

    }

}
