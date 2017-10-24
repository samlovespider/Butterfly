package com.proproject.butterfly.ui.activities;

import android.view.View;

import com.caizhenliang.mylibrary.util.SCApp;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.proproject.butterfly.ui.views.CustomFrontTextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import cz.msebera.android.httpclient.Header;

import static com.facebook.FacebookSdk.getApplicationSignature;

/**
 *
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.cftvTitle)
    CustomFrontTextView cftvTitle;

    @Override
    public void initData() {
        logW("ApplicationSignature- " + getApplicationSignature(this));
    }

    private void try1() {

        String url = "https://www.facebook.com/ajax/add_friend/action.php";
        RequestParams requestParams = new RequestParams();

        requestParams.put("dpr", "2");
        requestParams.put("to_friend", "100007036908515");
        requestParams.put("action", "add_friend");
        requestParams.put("how_found", "profile_button");
        requestParams.put("ref_param", "pymk");
        requestParams.put("link_data[gt][profile_owner]", "100007036908515");
        requestParams.put("link_data[gt][ref]", "timeline:timeline");
        requestParams.put("outgoing_id", "js_1ml");
        requestParams.put("no_flyout_on_click", "true");
        requestParams.put("floc", "profile_box");
        requestParams.put("__user", "100014980367096");
        requestParams.put("__a", "1");
        requestParams.put("__dyn", "7AgNe-4amaxx2u6aJG4A5EWq2W8GECi8x2AjFwxx-bzES2N6wAxu13y8627WQ8y8ixuAUvDK7HwTxmta3_DBxe6ohx3ypUlxrxOcxu5od8txi4E9ohwCwYxyrXwVx-EuAx22S3OeDBxu3Cq1wKHxx1ybyUrwFwgE-367Uy5UGdwRxW6oW4p8cE4e");
        requestParams.put("__af", "h0");
        requestParams.put("__req", "3n");
        requestParams.put("__be", "1");
        requestParams.put("__pc", "PHASED:DEFAULT");
        requestParams.put("__rev", "3304167");
        requestParams.put("fb_dtsg", "AQGSD_FkpPmQ:AQHVsXGDxO6w");
        requestParams.put("jazoest", "265817183689570107112801098158658172861158871681207954119");
        requestParams.put("__spin_r", "3304167");
        requestParams.put("__spin_b", "trunk");
        requestParams.put("__spin_t", "1505558388");
        requestParams.put("confirmed", "1");
//        requestParams.put("action", "add_friend");
//        requestParams.put("action", "add_friend");
//        requestParams.put("action", "add_friend");
//        requestParams.put("action", "add_friend");

//        https://www.facebook.com/profile.php?id=100006418036286
//        https://www.facebook.com/profile.php?id=100014980367096
//        https://www.facebook.com/profile.php?token=EAAbh5xtf9bEBAMZAQj3XFf1d7UzB8GgQQmYxjGZAAQORKdv0NbGM5uttm2tUVdmFfSp6jZAHLUG3tYo5EyhLjZANQYVRyp6Bk8aAZA9E43PZCJ58tXkmT9EoZAsvs4wOXGZCZApARiiK1bvl8EsMCDiw73B4jZBW1ZAnO0P25PcDnl0Y4aqzIHSDqQA5ZCak1OZBNZAQiyd8aBKKngQRxziwsQymKk

        post(url, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                logW("onSuccess-statusCode: ", statusCode);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                logW("onFailure-statusCode: ", statusCode);
            }
        });
    }

    private void try2() {

        String url = "graph.facebook.com";

    }

    @Override
    public void initView() {
    }

    @Click({R.id.linSocial, R.id.linBusiness, R.id.linProject, R.id.cftvTitle, R.id.ibScan, R.id.ibMenu, R.id.ibFacebook, R.id.ibSnapchat, R.id.ibInstagram})
    @Override
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.linSocial:
                gotoActivity(AccountsActivity_.class);
//                Bundle bundle = new Bundle();
//                bundle.putString(QRCodeActivity_.M_QRCODE_CONTENT_EXTRA, "suibianla");
//                gotoActivity(QRCodeActivity_.class, bundle);
                break;
            case R.id.linBusiness:
                gotoActivity(AccountsActivity_.class);
                break;
            case R.id.linProject:
                gotoActivity(AccountsActivity_.class);
                break;
            case R.id.cftvTitle:
            case R.id.ibScan:
                gotoActivity(ScanerActivity_.class);
                break;
            case R.id.ibMenu:
                break;
            case R.id.ibFacebook:
                SCApp.openApp(this,"com.facebook.katana","");
                break;
            case R.id.ibSnapchat:
                SCApp.openApp(this,"com.snapchat.android","");
                break;
            case R.id.ibInstagram:
                SCApp.openApp(this,"com.instagram.android","");
                break;
        }
    }


}
