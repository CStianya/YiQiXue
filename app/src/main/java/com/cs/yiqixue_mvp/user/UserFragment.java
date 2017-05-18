package com.cs.yiqixue_mvp.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cs.yiqixue_mvp.R;

/**
 * Created by CSLaker on 2017/3/24.
 */

public class UserFragment extends Fragment {

    private static UserFragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_frag, container, false);
    }

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

}
