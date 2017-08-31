package com.proproject.butterfly.ui.activities;

import android.os.Bundle;
import android.view.View;

import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.ui.views.CustomFrontTextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import static com.facebook.FacebookSdk.getApplicationSignature;

/**
 *
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.cftvTitle)
    CustomFrontTextView cftvTitle;


    @Override
    public void initData() {
        low("ApplicationSignature- " + getApplicationSignature(this));
    }

    @Override
    public void initView() {
    }

    @Click({R.id.btnQRcode, R.id.btnScaner, R.id.btnAccounts})
    @Override
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.btnQRcode:
                Bundle bundle = new Bundle();
                bundle.putString(QRCodeActivity_.M_QRCODE_CONTENT_EXTRA, "suibianla");
                gotoActivity(QRCodeActivity_.class, bundle);
                break;
            case R.id.btnScaner:
                gotoActivity(ScanerActivity_.class);
                break;
            case R.id.btnAccounts:
                gotoActivity(AccountsActivity_.class);
                break;
        }
    }


}
