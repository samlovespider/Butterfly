package com.proproject.butterfly.ui.activities;

import android.content.Intent;
import android.view.View;
import android.view.Window;

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

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_login_facebook)
public class LoginActivity extends BaseActivity {

    @ViewById(R.id.login_button)
    LoginButton login_button;

    private CallbackManager mCallbackManager;
    private ProfileTracker mProfileTracker;

    @Override
    public void initView() {
        //
        ftActionBar.setText(R.string.activity_login_title);

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
                logW("onCurrentProfileChanged: id ", currentProfile.getId());
            }
        };
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
}
