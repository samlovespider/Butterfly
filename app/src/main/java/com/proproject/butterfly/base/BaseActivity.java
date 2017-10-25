package com.proproject.butterfly.base;

import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import com.caizhenliang.mylibrary.ui.activity.MyBaseActivity;
import com.proproject.butterfly.BuildConfig;
import com.proproject.butterfly.R;
import com.proproject.butterfly.ui.views.CustomFrontTextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by caizhenliang on 2017/8/18.
 */
@EActivity
public abstract class BaseActivity extends MyBaseActivity {

    @ViewById(R.id.ftActionBar)
    protected CustomFrontTextView ftActionBar;
    @ViewById(R.id.ibBack)
    protected ImageButton ibBack;

    @AfterViews
    @Override
    abstract public void initView();

    @Click(R.id.ibBack)
    protected void onBack(View v) {
        onBackPressed();
    }

    @Override
    public void logW(Object o) {
        if (BuildConfig.DEBUG) {
            super.logW(o);
        }
    }

    @Override
    public void logW(String title, Object o) {
        if (BuildConfig.DEBUG) {
            super.logW(title, o);
        }
    }

    @Override
    public void initMenuItem(MenuItem menuItem) {

    }

    @Override
    public void initClick(View view) {

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
