package com.proproject.butterfly.ui.activities;

import android.view.Window;
import android.widget.TextView;

import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_scaner)
public class ScanerActivity extends BaseActivity {

    @ViewById(R.id.tvCodeInfor)
    TextView tvCodeInfor;

    @Extra
    String mQrcodeResult;

    @Override
    public void initView() {
        //
        ftActionBar.setText(R.string.activity_scaner_title);

        if (mQrcodeResult != null) {
            tvCodeInfor.setText(mQrcodeResult);
        }
    }


}
