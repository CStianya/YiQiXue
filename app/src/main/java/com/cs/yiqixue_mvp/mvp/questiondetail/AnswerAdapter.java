package com.cs.yiqixue_mvp.mvp.questiondetail;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cs.yiqixue_mvp.R;
import com.cs.yiqixue_mvp.bean.Answer;
import com.cs.yiqixue_mvp.utils.MyApplication;

import java.util.List;

/**
 * Created by CSLaker on 2017/3/25.
 */

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

    private List<Answer> mDatas = null;

    public AnswerAdapter(List<Answer> datas) {
        this.mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.answer_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mUserTV.setText(mDatas.get(position).getUser());
        viewHolder.mContentsTV.setText(mDatas.get(position).getContens());
        viewHolder.mTimeTV.setText(mDatas.get(position).getTime());
        viewHolder.mLikeTV.setText(mDatas.get(position).getLikeNumbers() + "");
        viewHolder.mReplayTV.setText(mDatas.get(position).getReplayNumbers() + "");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mUserTV;
        public TextView mContentsTV;
        public TextView mTimeTV;
        public TextView mReplayTV;
        public TextView mLikeTV;

        public ViewHolder(View view) {
            super(view);
            mUserTV = (TextView) view.findViewById(R.id.tv_answer_user);
            mContentsTV = (TextView) view.findViewById(R.id.tv_answer_contents);
            mTimeTV = (TextView) view.findViewById(R.id.tv_answer_time);
            mReplayTV = (TextView) view.findViewById(R.id.tv_answer_replay);
            mLikeTV = (TextView) view.findViewById(R.id.tv_answer_like);

            mUserTV.setOnClickListener(this);
            mContentsTV.setOnClickListener(this);
            mReplayTV.setOnClickListener(this);
            mLikeTV.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.tv_answer_replay:
                    intent = new Intent(MyApplication.getContext(), ReplayActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyApplication.getContext().startActivity(intent);
                    break;
                case R.id.tv_answer_contents:
                    intent = new Intent(MyApplication.getContext(), AnswerInfoActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyApplication.getContext().startActivity(intent);
                    break;
            }
        }
    }

}
