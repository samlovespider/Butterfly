package com.proproject.butterfly;

import android.view.View;

import com.proproject.butterfly.activities.AccountsActivity_;
import com.proproject.butterfly.baseclasses.BaseActivity;
import com.proproject.butterfly.views.CustomFrontTextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {


    @ViewById(R.id.cftvTitle)
    CustomFrontTextView cftvTitle;

    @Override
    public void initData() {
    }

    @Override
    public void initView() {

    }


    @Click({R.id.btnQRcode, R.id.btnScaner, R.id.btnAccounts})
    @Override
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.btnQRcode:
                //TODO implement
                break;
            case R.id.btnScaner:
                //TODO implement
                break;
            case R.id.btnAccounts:
                gotoActivity(AccountsActivity_.class);
                break;
        }
    }
}
