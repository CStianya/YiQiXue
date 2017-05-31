package com.cs.yiqixue_mvp.mvp.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.cs.yiqixue_mvp.R;
import com.cs.yiqixue_mvp.base.BaseFragment;

/**
 * Created by CSLaker on 2017/3/24.
 */

public class UserFragment extends BaseFragment {

    private static UserFragment fragment;


    public UserFragment(){}

    public static UserFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString("text", text);
        if (fragment == null) {
            fragment = new UserFragment();
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.user_frag;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

}
