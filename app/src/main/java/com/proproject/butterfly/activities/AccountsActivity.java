package com.proproject.butterfly.activities;

import android.support.v4.content.ContextCompat;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.proproject.butterfly.R;
import com.proproject.butterfly.baseclasses.BaseActivity;

import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_accounts)
public class AccountsActivity extends BaseActivity {

    @ViewById(R.id.tvFacebook)
    TextView tvFacebook;
    @ViewById(R.id.swFacebook)
    Switch swFacebook;
    @ViewById(R.id.imgbtnLoginFacebook)
    ImageButton imgbtnLoginFacebook;

    @ViewById(R.id.tvSnap)
    TextView tvSnap;
    @ViewById(R.id.swSnap)
    Switch swSnap;
    @ViewById(R.id.imgbtnLoginSnap)
    ImageButton imgbtnLoginSnap;

    @ViewById(R.id.tvInstagram)
    TextView tvInstagram;
    @ViewById(R.id.swInstagram)
    Switch swInstagram;
    @ViewById(R.id.imgbtnLoginInstagram)
    ImageButton imgbtnLoginInstagram;

    // IDs
    private int mFacebookID = -1;
    private int mSnapID = -1;
    private int mInstagramID = -1;


    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        //
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(R.string.activity_accounts_accounts);

        //
        initTextState(tvFacebook, swFacebook.isChecked());
        initTextState(tvSnap, swSnap.isChecked());
        initTextState(tvInstagram, swInstagram.isChecked());

        // must login first
        if (mFacebookID == -1) {
            swFacebook.setEnabled(false);
        }
        if (mSnapID == -1) {
            swSnap.setEnabled(false);
        }
        if (mInstagramID == -1) {
            swInstagram.setEnabled(false);
        }
    }


    /**
     * @param button
     * @param isChecked
     */
    @CheckedChange({R.id.swFacebook, R.id.swSnap, R.id.swInstagram})
    @Override
    public void initCheckedChange(CompoundButton button, boolean isChecked) {
        switch (button.getId()) {
            case R.id.swFacebook:
                changeTextColor(tvFacebook, isChecked);
                break;
            case R.id.swSnap:
                changeTextColor(tvSnap, isChecked);
                break;
            case R.id.swInstagram:
                changeTextColor(tvInstagram, isChecked);
                break;
        }
    }

    /**
     * if checked turn black, otherwise turn grey
     *
     * @param view
     * @param isChecked
     */
    private void changeTextColor(TextView view, boolean isChecked) {
        if (view == null) {
            // TODO: 2017/8/21 should throw a custom exception
            return;
        }
        if (isChecked) {
            view.setTextColor(ContextCompat.getColor(this, R.color.activity_main_text_normal));
        } else {
            view.setTextColor(ContextCompat.getColor(this, R.color.activity_main_text_selected));
        }
    }

    /**
     * @param view
     * @param isChecked
     */
    private void initTextState(TextView view, boolean isChecked) {
        if (isChecked) {
            view.setTextColor(ContextCompat.getColor(this, R.color.activity_main_text_normal));
        } else {
            view.setTextColor(ContextCompat.getColor(this, R.color.activity_main_text_selected));
        }
    }

}
