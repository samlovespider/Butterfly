package com.proproject.butterfly.ui.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;
import com.samcai.sc_qrcode.Qrcode;
import com.samcai.sc_qrcode.QrcodeFactory;
import com.samcai.sc_qrcode.callback.PermissionResultCallback;
import com.samcai.sc_qrcode.callback.QrcodeCallback;
import com.samcai.sc_qrcode.qrcode.QrcodeInfo;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_scaner)
public class ScanerActivity extends BaseActivity {

    @ViewById(R.id.tvCodeInfor)
    TextView tvCodeInfor;

    private Qrcode mQrcode;

    @Override
    public void initView() {

        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(R.string.activity_scaner_title);

        mQrcode = QrcodeFactory.newQrcode(this);
        mQrcode.start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        mQrcode.onActivityResult(requestCode, resultCode, data, new QrcodeCallback() {
            @Override
            public void onSuccess(@NonNull QrcodeInfo info) {
                String textInfo = "二维码信息" + info.getResult() + "图片高度" + info.getHeight() + "图片宽度" + info.getWidth();
                logW(textInfo);
                tvCodeInfor.setText(textInfo);
            }

            @Override
            public void onFailed(@NonNull String errMsg) {
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        mQrcode.onRequestPermissionsResult(requestCode, permissions, grantResults, new PermissionResultCallback() {
            @Override
            public void denyPermission() {
            }
        });
    }
}
