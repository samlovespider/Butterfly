package com.proproject.butterfly.ui.activities;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.constant.Constants;
import com.proproject.butterfly.event.FacebookLoginEvent;
import com.proproject.butterfly.event.FacebookLogoutEvent;
import com.proproject.butterfly.ui.activities.login.LoginFacebookActivity_;
import com.proproject.butterfly.ui.activities.login.LoginInstagramActivity;
import com.proproject.butterfly.ui.activities.login.LoginSnapActivity;

import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

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
    private int mFacebookState = LOGSTATE_LOGOUT;
    private int mSnapState = LOGSTATE_LOGOUT;
    private int mInstagramState = LOGSTATE_LOGOUT;


    @Override
    protected void onStop() {
        super.onStop();
        mACache.put(Constants.CACHE_FACEBOOK_SWITCH_STATE, swFacebook.isChecked() + "");
        low("swFacebook.isChecked()-" + swFacebook.isChecked());
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {
        //
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(R.string.activity_accounts_accounts);

        initFacebook();

        if (mSnapState == LOGSTATE_LOGOUT) {
            swSnap.setEnabled(false);
        }
        if (mInstagramState == LOGSTATE_LOGOUT) {
            swInstagram.setEnabled(false);
        }
    }

    /**
     *
     */
    private void initFacebook() {
        // get account cache
        if (AccessToken.getCurrentAccessToken() != null) {
            mFacebookState = LOGSTATE_LOGINED;
        } else {
            mFacebookState = LOGSTATE_LOGOUT;
        }
        low("mFacebookState-" + mFacebookState);

        // get switch state which been saved when activity stopped
        boolean isFacebook = Boolean.parseBoolean(mACache.getAsString(Constants.CACHE_FACEBOOK_SWITCH_STATE));
        if (mFacebookState == LOGSTATE_LOGOUT) {
            isFacebook = false;
        }
        low("isFacebook-" + isFacebook);

        // init views' state
        setImageButtonBackground(imgbtnLoginFacebook, mFacebookState);
        setTextColor(tvFacebook, isFacebook);
        setSwitchState(swFacebook, isFacebook, mFacebookState);
    }

    @Subscribe
    public void onFacebookLoginEvent(FacebookLoginEvent event) {
        mFacebookState = LOGSTATE_LOGINED;
        setImageButtonBackground(imgbtnLoginFacebook, mFacebookState);
        setTextColor(tvFacebook, true);
        setSwitchState(swFacebook, true, mFacebookState);
    }

    @Subscribe
    public void onFacebookLogoutEvent(FacebookLogoutEvent event) {
        mFacebookState = LOGSTATE_LOGOUT;
        setImageButtonBackground(imgbtnLoginFacebook, mFacebookState);
        setTextColor(tvFacebook, false);
        setSwitchState(swFacebook, false, mFacebookState);
    }

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

    @CheckedChange({R.id.swFacebook, R.id.swSnap, R.id.swInstagram})
    @Override
    public void initCheckedChange(CompoundButton button, boolean isChecked) {
        switch (button.getId()) {
            case R.id.swFacebook:
                setTextColor(tvFacebook, isChecked);
                break;
            case R.id.swSnap:
                setTextColor(tvSnap, isChecked);
                break;
            case R.id.swInstagram:
                setTextColor(tvInstagram, isChecked);
                break;
        }
    }

    /**
     * if checked turn black, otherwise turn grey
     *
     * @param view
     * @param isChecked
     */
    private void setTextColor(TextView view, boolean isChecked) {
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
    private void setImageButtonBackground(ImageButton imageButton, int state) {
        switch (state) {
            case LOGSTATE_LOGINED:
                imageButton.setBackgroundResource(R.drawable.ic_accounts_loged);
                break;
            case LOGSTATE_LOGOUT:
                imageButton.setBackgroundResource(R.drawable.ic_accounts_logout);
                break;
        }
    }

    /**
     * @param sw
     * @param isChecked
     * @param state
     */
    private void setSwitchState(Switch sw, boolean isChecked, int state) {
        switch (state) {
            case LOGSTATE_LOGINED:
                sw.setEnabled(true);
                break;
            case LOGSTATE_LOGOUT:
                sw.setEnabled(false);
                break;
        }
        sw.setChecked(isChecked);
    }


}
