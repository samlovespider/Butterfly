package com.proproject.butterfly.ui.activities;

import android.view.View;
import android.view.Window;

import com.caizhenliang.mylibrary.util.SCApp;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.ui.views.CustomFrontTextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

/**
 *
 */
@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.cftvTitle)
    CustomFrontTextView cftvTitle;

    @Override
    public void initView() {
    }

    @Click({R.id.linSocial, R.id.linBusiness, R.id.linProject, R.id.cftvTitle, R.id.ibScan, R.id.ibMenu, R.id.ibFacebook, R.id.ibSnapchat, R.id.ibInstagram})
    @Override
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.linSocial:
            case R.id.linBusiness:
            case R.id.linProject:
                gotoActivity(SocialActivity_.class);
                break;
            case R.id.cftvTitle:
            case R.id.ibScan:
                gotoActivity(ScanerActivity_.class);
                break;
            case R.id.ibMenu:
                break;
            case R.id.ibFacebook:
                SCApp.openApp(this, "com.facebook.katana", "");
                break;
            case R.id.ibSnapchat:
                SCApp.openApp(this, "com.snapchat.android", "");
                break;
            case R.id.ibInstagram:
                SCApp.openApp(this, "com.instagram.android", "");
                break;
        }
    }


}
