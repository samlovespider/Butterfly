package com.proproject.butterfly.ui.activities;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.proproject.butterfly.R;
import com.proproject.butterfly.base.BaseActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.Hashtable;

@EActivity(R.layout.activity_qrcode)
public class QRCodeActivity extends BaseActivity {

    @ViewById(R.id.imgQrcode)
    ImageView imgQrcode;

    @Extra
    String mQrcodeContent;

    @Override
    public void initView() {
        //
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(R.string.activity_qrcode_title);

        if (mQrcodeContent != null && !mQrcodeContent.isEmpty()) {
            Bitmap bitmap = encodeAsBitmap(mQrcodeContent);
            imgQrcode.setImageBitmap(bitmap);
        }
    }

    /**
     * @param code
     * @return
     */
    private Bitmap encodeAsBitmap(String code) {
        if (code == null) {
            return null;
        }
        // set border width
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 1);
        //
        Bitmap bitmap = null;
        BitMatrix result;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            result = multiFormatWriter.encode(code, BarcodeFormat.QR_CODE, 200, 200, hints);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(result);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae) {
            return null;
        }
        return bitmap;
    }
}
