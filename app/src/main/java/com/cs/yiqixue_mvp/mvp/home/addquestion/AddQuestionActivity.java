package com.cs.yiqixue_mvp.mvp.home.addquestion;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cs.yiqixue_mvp.R;
import com.cs.yiqixue_mvp.base.BaseActivity;


/**
 * Created by CSLaker on 2017/4/26.
 */

public class AddQuestionActivity extends BaseActivity {

    @Override
    public void initData(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.add_question_act;
    }

    @Override
    public void initView(View view) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("提问");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu .findItem(R.id.ab_save).setVisible(true);
        menu .findItem(R.id.ab_search).setVisible(false);
        menu .findItem(R.id.ab_edit).setVisible(false);
        menu .findItem(R.id.ab_share).setVisible(false);
        menu .findItem(R.id.ab_more).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
