package com.proproject.butterfly.activities;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.proproject.butterfly.R;
import com.proproject.butterfly.baseclasses.BaseActivity;
import com.proproject.butterfly.views.CustomFrontTextView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {


    @ViewById(R.id.cftvTitle)
    CustomFrontTextView cftvTitle;

    @ViewById(R.id.linLayFacebook)
    LinearLayout linLayFacebook;

    @ViewById(R.id.tvFacebook)
    TextView tvFacebook;

    @ViewById(R.id.swFacebook)
    Switch swFacebook;

    @ViewById(R.id.linLaySnap)
    RelativeLayout linLaySnap;

    @ViewById(R.id.tvSnap)
    TextView tvSnap;

    @ViewById(R.id.swSnap)
    Switch swSnap;

    @ViewById(R.id.login_button)
    LoginButton loginButton;


    private CallbackManager callbackManager;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initData() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
    }

    @Override
    public void initView() {

    }
}
