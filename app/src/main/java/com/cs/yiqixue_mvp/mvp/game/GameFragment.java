package com.cs.yiqixue_mvp.mvp.game;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cs.yiqixue_mvp.R;

/**
 * Created by CSLaker on 2017/3/24.
 */

public class GameFragment extends Fragment {

    private static GameFragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_frag, container, false);
    }

    public GameFragment(){}

    public static GameFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString("text", text);
        if (fragment == null) {
            fragment = new GameFragment();
        }
        fragment.setArguments(args);
        return fragment;
    }

}
