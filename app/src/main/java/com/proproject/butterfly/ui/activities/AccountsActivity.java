package com.proproject.butterfly.ui.activities;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.proproject.butterfly.R;
import com.proproject.butterfly.baseclasses.BaseActivity;
import com.proproject.butterfly.ui.activities.login.LoginFacebookActivity_;
import com.proproject.butterfly.ui.activities.login.LoginInstagramActivity;
import com.proproject.butterfly.ui.activities.login.LoginSnapActivity;

import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_accounts)
public class AccountsActivity extends BaseActivity {

    @ViewById(R.id.imgbtnLoginFacebook)
    ImageButton imgbtnLoginFacebook;
    @ViewById(R.id.tvFacebook)
    TextView tvFacebook;
    @ViewById(R.id.swFacebook)
    Switch swFacebook;

    @ViewById(R.id.imgbtnLoginSnap)
    ImageButton imgbtnLoginSnap;
    @ViewById(R.id.tvSnap)
    TextView tvSnap;
    @ViewById(R.id.swSnap)
    Switch swSnap;

    @ViewById(R.id.imgbtnLoginInstagram)
    ImageButton imgbtnLoginInstagram;
    @ViewById(R.id.tvInstagram)
    TextView tvInstagram;
    @ViewById(R.id.swInstagram)
    Switch swInstagram;

    // LOG STATE
    public static final int LOGSTATE_LOGINED = 1;
    public static final int LOGSTATE_LOGOUT = -1;
    // IDs
    private int mFacebookID = LOGSTATE_LOGOUT;
    private int mSnapID = LOGSTATE_LOGOUT;
    private int mInstagramID = LOGSTATE_LOGOUT;


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
        if (mFacebookID == LOGSTATE_LOGOUT) {
            swFacebook.setEnabled(false);
        }
        if (mSnapID == LOGSTATE_LOGOUT) {
            swSnap.setEnabled(false);
        }
        if (mInstagramID == LOGSTATE_LOGOUT) {
            swInstagram.setEnabled(false);
        }
    }


//    @Subscribe
//    public void onEvent(LoginedEvent event) {
//        switch (event.mLoginID) {
//            case LoginActivity.FACEBOOK:
//                swFacebook.setEnabled(true);
//                break;
//            case LoginActivity.SNAP:
//                swSnap.setEnabled(true);
//                break;
//            case LoginActivity.INSTRAGRAM:
//                swInstagram.setEnabled(true);
//                break;
//        }
//    }

    @Click({R.id.imgbtnLoginFacebook, R.id.imgbtnLoginSnap, R.id.imgbtnLoginInstagram})
    @Override
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtnLoginFacebook:
                gotoActivity(LoginFacebookActivity_.class);
                break;
            case R.id.imgbtnLoginSnap:
                gotoActivity(LoginSnapActivity.class);
                break;
            case R.id.imgbtnLoginInstagram:
                gotoActivity(LoginInstagramActivity.class);
                break;
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

    /**
     * @param imageButton
     * @param state
     */
    private void changeLoginState(ImageButton imageButton, int state) {
        switch (state) {
            case LOGSTATE_LOGINED:
                imageButton.setImageResource(R.drawable.ic_accounts_loged);
                break;
            case LOGSTATE_LOGOUT:
                imageButton.setImageResource(R.drawable.ic_accounts_logout);
                break;
        }
    }

}
