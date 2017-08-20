package com.proproject.butterfly.activities;

import android.widget.TextView;

import com.proproject.butterfly.R;
import com.proproject.butterfly.baseclasses.BaseActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_accounts)
public class AccountsActivity extends BaseActivity {


    @ViewById(R.id.tvFacebook)
    TextView tvFacebook;


    @ViewById(R.id.tvSnap)
    TextView tvSnap;


    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(R.string.activity_accounts_accounts);
    }
}
