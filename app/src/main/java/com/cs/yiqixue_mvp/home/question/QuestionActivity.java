package com.cs.yiqixue_mvp.home.question;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cs.yiqixue_mvp.R;
import com.cs.yiqixue_mvp.base.BaseActivity;
import com.cs.yiqixue_mvp.game.GameFragment;
import com.cs.yiqixue_mvp.user.UserFragment;

import java.util.ArrayList;

import javax.inject.Inject;

public class QuestionActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @Inject QuestionPresenter mQuestionPresenter;

    private ArrayList<Fragment> fragments;

    @Override
    public void initData(Bundle parms) {
        DaggerQuestionComponent.builder()
                .questionPresenterModule(new QuestionPresenterModule(QuestionFragment.newInstance("学习广场"))).build()
                .inject(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.question_act;
    }

    @Override
    public void initView(View view) {
        Toolbar toolbar = $(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        BottomNavigationBar bottomNavigationBar;
        bottomNavigationBar = $(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_book_black_18dp, "学习广场").setActiveColorResource(R.color.navigationBarColor))
                .addItem(new BottomNavigationItem(R.drawable.ic_game_white_24dp, "线下互动").setActiveColorResource(R.color.navigationBarColor))
                .addItem(new BottomNavigationItem(R.drawable.ic_user_black_24dp, "个人中心").setActiveColorResource(R.color.navigationBarColor))
                .setFirstSelectedPosition(0)
                .initialise();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);

        fragments = getFragments();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void widgetClick(View v) {

    }

    public ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(QuestionFragment.newInstance("学习广场"));
        fragments.add(GameFragment.newInstance("线下互动"));
        fragments.add(UserFragment.newInstance("个人中心"));
        return fragments;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu.findItem(R.id.ab_save).setVisible(false);
        menu.findItem(R.id.ab_search).setVisible(true);
        menu.findItem(R.id.ab_edit).setVisible(false);
        menu.findItem(R.id.ab_share).setVisible(false);
        menu.findItem(R.id.ab_more).setVisible(false);
        return true;
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFrame, QuestionFragment.newInstance("学习广场"));
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ab_search) {
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.contentFrame, fragment);
                } else {
                    ft.add(R.id.contentFrame, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }
}
