package com.proproject.butterfly.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_scan_result)
public class ScanResultActivity extends BaseActivity {

    @ViewById(R.id.linSocial)
    LinearLayout linSocial;

    @ViewById(R.id.tvCodeInfor)
    TextView tvCodeInfor;

    @Extra
    String mQrcodeResult;

    private String[] mResults;

    @Override
    public void initView() {
        //
        ftActionBar.setText(R.string.activity_scaner_title);
        linSocial.setVisibility(View.INVISIBLE);
        //
        if (mQrcodeResult == null || mQrcodeResult.isEmpty()) {
            return;
        }
        //
        mResults = getResult(mQrcodeResult);
        //
        tvCodeInfor.setText(mResults[0]);
        linSocial.setVisibility(View.VISIBLE);
    }

    @Click(R.id.linSocial)
    @Override
    public void initClick(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse("https://www.facebook.com/" + mResults[1]);
        intent.setData(content_url);
        startActivity(intent);
    }

    private String[] getResult(String sQrcodeResult) {
        return sQrcodeResult.split(",");
    }

}
