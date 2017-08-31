package com.proproject.butterfly.ui.activities.login;

import android.content.Intent;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.event.FacebookLoginEvent;
import com.proproject.butterfly.event.FacebookLogoutEvent;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login_facebook)
public class LoginFacebookActivity extends BaseActivity {

    @ViewById(R.id.login_button)
    LoginButton loginButton;

    private CallbackManager mCallbackManager;

    @Override
    public void initData() {
        mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        mEventBus.post(new FacebookLoginEvent());
                    }

                    @Override
                    public void onCancel() {
                        low("onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        low(exception);
                    }
                });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AccessToken.getCurrentAccessToken() != null) {
                    mEventBus.post(new FacebookLogoutEvent());
                }
            }
        });
    }

    @Override
    public void initView() {
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(R.string.activity_login_title_facebook);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
