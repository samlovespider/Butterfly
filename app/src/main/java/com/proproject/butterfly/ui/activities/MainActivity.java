package com.proproject.butterfly.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;

import com.caizhenliang.mylibrary.util.SCApp;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.ui.views.CustomFrontTextView;
import com.samcai.sc_qrcode.Qrcode;
import com.samcai.sc_qrcode.QrcodeFactory;
import com.samcai.sc_qrcode.callback.PermissionResultCallback;
import com.samcai.sc_qrcode.callback.QrcodeCallback;
import com.samcai.sc_qrcode.qrcode.QrcodeInfo;

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
    //
    private Qrcode mQrcode;

    @Override
    public void initView() {
    }

    @Click({R.id.linSocial, R.id.linBusiness, R.id.linProject, R.id.cftvTitle, R.id.ibScan, R.id.ibMenu, R.id.ibFacebook, R.id.ibSnapchat, R.id.ibInstagram})
    @Override
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.linSocial:
                gotoActivity(SocialActivity_.class);
                break;
            case R.id.linBusiness:
            case R.id.linProject:
                break;
            case R.id.cftvTitle:
            case R.id.ibScan:
                mQrcode = QrcodeFactory.newQrcode(this);
                mQrcode.start();
                break;
            case R.id.ibMenu:
                gotoActivity(LoginActivity_.class);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        mQrcode.onActivityResult(requestCode, resultCode, data, new QrcodeCallback() {
            @Override
            public void onSuccess(@NonNull QrcodeInfo info) {
                String textInfo = "Scan Result:\n  " + info.getResult() + "\nPicHeight:\n  " + info.getHeight() + "\nPicWidth:\n  " + info.getWidth();
                logW(textInfo);
                //
                Bundle bundle = new Bundle();
                bundle.putString(ScanerActivity_.M_QRCODE_RESULT_EXTRA, textInfo);
                gotoActivity(ScanerActivity_.class, bundle);
            }

            @Override
            public void onFailed(@NonNull String errMsg) {
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        mQrcode.onRequestPermissionsResult(requestCode, permissions, grantResults, new PermissionResultCallback() {
            @Override
            public void denyPermission() {
            }
        });
    }
}
