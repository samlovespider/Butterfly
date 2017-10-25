package com.proproject.butterfly.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;

import com.facebook.AccessToken;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.constant.Constants;
import com.proproject.butterfly.event.FacebookLoginEvent;
import com.proproject.butterfly.event.FacebookLogoutEvent;

import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.greenrobot.eventbus.Subscribe;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_social)
public class SocialActivity extends BaseActivity {

    // LOG STATE
    public static final int LOGSTATE_LOGINED = 1;
    public static final int LOGSTATE_LOGOUT = -1;
    //
    @ViewById(R.id.btnFacebook)
    Button btnFacebook;
    @ViewById(R.id.btnSnap)
    Button btnSnap;
    @ViewById(R.id.btnInstagram)
    Button btnInstagram;
    @ViewById(R.id.swFacebook)
    SwitchCompat swFacebook;
    @ViewById(R.id.swSnap)
    SwitchCompat swSnap;
    @ViewById(R.id.swInstagram)
    SwitchCompat swInstagram;
    // IDs
    private int mFacebookState = LOGSTATE_LOGOUT;

    @Override
    public void initView() {
        //
        ftActionBar.setText(R.string.activity_accounts_accounts);
        //
        initFacebook();
        //
        swInstagram.setEnabled(false);
        swSnap.setEnabled(false);
    }

    /**
     *
     */
    private void initFacebook() {
        // get account cache
        if (AccessToken.getCurrentAccessToken() != null) {
            mFacebookState = LOGSTATE_LOGINED;

            logW("initFacebook: getToken", AccessToken.getCurrentAccessToken().getToken());
            logW("initFacebook: getApplicationId", AccessToken.getCurrentAccessToken().getApplicationId());
            logW("initFacebook: userid", AccessToken.getCurrentAccessToken().getUserId());
            logW("mFacebookState-" + (mFacebookState == LOGSTATE_LOGINED ? "LOGSTATE_LOGINED" : "LOGSTATE_LOGOUT"));

        } else {
            mFacebookState = LOGSTATE_LOGOUT;
        }
        // get switch state which been saved when activity stopped
        boolean isFacebook = Boolean.parseBoolean(mCache.getAsString(Constants.CACHE_FACEBOOK_SWITCH_STATE));
        if (mFacebookState == LOGSTATE_LOGOUT) {
            isFacebook = false;
        }
        logW("isFacebook-" + isFacebook);

        setSwitchState(swFacebook, isFacebook, mFacebookState);
    }

    @Subscribe
    public void onFacebookLoginEvent(FacebookLoginEvent event) {
        mFacebookState = LOGSTATE_LOGINED;
        setSwitchState(swFacebook, true, mFacebookState);
    }

    @Subscribe
    public void onFacebookLogoutEvent(FacebookLogoutEvent event) {
        mFacebookState = LOGSTATE_LOGOUT;
        setSwitchState(swFacebook, false, mFacebookState);
    }

    @Click({R.id.btnQR})
    @Override
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.btnQR:
                Bundle bundle = new Bundle();
                bundle.putString(QRCodeActivity_.M_QRCODE_CONTENT_EXTRA, "https://www.facebook.com/zhenliang.cai.9");
                gotoActivity(QRCodeActivity_.class,bundle);
                break;
        }
    }

    @CheckedChange({R.id.swFacebook, R.id.swSnap, R.id.swInstagram})
    @Override
    public void initCheckedChange(CompoundButton button, boolean isChecked) {
        switch (button.getId()) {
            case R.id.swFacebook:
                break;
            case R.id.swSnap:
                break;
            case R.id.swInstagram:
                break;
        }
    }

    /**
     * @param sw
     * @param isChecked
     * @param state
     */
    private void setSwitchState(SwitchCompat sw, boolean isChecked, int state) {
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

    @Override
    protected void onStop() {
        super.onStop();
        mCache.put(Constants.CACHE_FACEBOOK_SWITCH_STATE, swFacebook.isChecked() + "");
        logW("swFacebook.isChecked()-" + swFacebook.isChecked());
    }

}
