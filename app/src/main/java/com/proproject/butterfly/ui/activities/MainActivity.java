package com.proproject.butterfly.ui.activities;

import android.content.Intent;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
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

    private CallbackManager mCallbackManager;

    @Override
    public void initData() {
        initFacebook();

        low(getApplicationSignature(this));
    }


    /**
     *
     */
    private void initFacebook() {

        // TODO: 2017/8/26 need make cache frame to store token and profile
//        low(AccessToken.getCurrentAccessToken().getToken());
//        low(Profile.getCurrentProfile().getId());
//        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        low(loginResult);
                        low(AccessToken.getCurrentAccessToken().getToken());
                    }

                    @Override
                    public void onCancel() {
                        // App code
                        low("onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        low(exception);
                    }
                });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
