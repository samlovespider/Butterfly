package com.proproject.butterfly.baseclasses;

import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;

import com.caizhenliang.mylibrary.MyBaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by caizhenliang on 2017/8/18.
 */
@EActivity
public abstract class BaseActivity extends MyBaseActivity {


    @AfterViews
    @Override
    abstract public void initData();

    @AfterViews
    @Override
    abstract public void initView();

    @Override
    public void initMenuItem(MenuItem menuItem) {

    }

    @Override
    public void initClick(View view) {

    }

    @Subscribe
    @Override
    public void initEvent(Object object) {

    }

    @Override
    public void initItemClick(int position) {

    }

    @Override
    public void initItemClick(Object object) {

    }

    @Override
    public void initItemLongClick(int position) {

    }

    @Override
    public void initItemLongClick(Object object) {

    }

    @Override
    public void initCheckedChange(CompoundButton button, boolean isChecked) {

    }
}
