package com.proproject.butterfly.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.event.FacebookLoginEvent;
import com.proproject.butterfly.event.FacebookLogoutEvent;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import static com.proproject.butterfly.constant.Constants.CACHE_DISPLAY_NAME;
import static com.proproject.butterfly.constant.Constants.CACHE_FACEBOOK_LINK;
import static com.proproject.butterfly.constant.Constants.CACHE_FACEBOOK_USER_ID;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_login_facebook)
public class LoginActivity extends BaseActivity {

    @ViewById(R.id.login_button)
    LoginButton login_button;

    private CallbackManager mCallbackManager;
    private ProfileTracker mProfileTracker;
    private String mDisplayName;

    @Override
    public void initView() {
        //
        ftActionBar.setTextSize(40);
        //
        mDisplayName = mCache.getAsString(CACHE_DISPLAY_NAME);
        if (mDisplayName == null || mDisplayName.isEmpty()) {
            mDisplayName = "";
        }
        //
        setActionBarText();

        mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        post(new FacebookLoginEvent());
                    }

                    @Override
                    public void onCancel() {
                        logW("onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        logW(exception);
                    }
                });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AccessToken.getCurrentAccessToken() != null) {
                    post(new FacebookLogoutEvent());
                }
            }
        });

        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(
                    Profile oldProfile,
                    Profile currentProfile) {
                // App code
                if (currentProfile != null) {
                    logW("onCurrentProfileChanged: name ", currentProfile.getLinkUri());
                    logW("onCurrentProfileChanged: id ", currentProfile.getId());
                    mCache.put(CACHE_FACEBOOK_USER_ID, currentProfile.getId());
                    mCache.put(CACHE_FACEBOOK_LINK, currentProfile.getLinkUri().toString());
                }
            }
        };
    }


    @Click(R.id.tvPickUpName)
    @Override
    public void initClick(View view) {
        final EditText inputServer = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Display Name: ").setView(inputServer)
                .setNegativeButton("Cancel", null);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                mDisplayName = inputServer.getText().toString();
                setActionBarText();
            }
        });
        builder.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCache.put(CACHE_DISPLAY_NAME, mDisplayName);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mProfileTracker.stopTracking();
    }

    private void setActionBarText() {
        String title = getString(R.string.activity_login_title) + "\nWelcome, " + mDisplayName;
        ftActionBar.setText(title);
    }
}
