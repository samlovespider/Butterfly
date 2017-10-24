package com.proproject.butterfly.ui.activities;

import android.view.View;

import com.caizhenliang.mylibrary.util.SCApp;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.ui.views.CustomFrontTextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 *
 */
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
                gotoActivity(AccountsActivity_.class);
//                Bundle bundle = new Bundle();
//                bundle.putString(QRCodeActivity_.M_QRCODE_CONTENT_EXTRA, "suibianla");
//                gotoActivity(QRCodeActivity_.class, bundle);
                break;
            case R.id.linBusiness:
                gotoActivity(AccountsActivity_.class);
                break;
            case R.id.linProject:
                gotoActivity(AccountsActivity_.class);
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
