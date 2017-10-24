package com.proproject.butterfly.ui.activities;

import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity {

    @Override
    public void initView() {
        goMain();
    }

    @UiThread(delay = 2000)
    void goMain() {
        gotoActivity(MainActivity_.class);
        finish();
    }
}
