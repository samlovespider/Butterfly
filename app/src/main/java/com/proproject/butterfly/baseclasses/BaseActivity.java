package com.proproject.butterfly.baseclasses;

import android.view.MenuItem;
import android.view.View;

import com.caizhenliang.mylibrary.MyBaseActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by caizhenliang on 2017/8/18.
 */

public abstract class BaseActivity extends MyBaseActivity {

    @Override
    @Subscribe
    public void handleEvent(Object event) {

    }

    @Override
    public void initMenuItem(MenuItem menuItem) {

    }

    @Override
    public void initClick(View view) {

    }

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
}
