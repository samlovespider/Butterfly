package com.proproject.butterfly.views;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by caizhenliang on 2017/8/18.
 */

public class CustomFrontTextView extends android.support.v7.widget.AppCompatTextView {


    public CustomFrontTextView(Context context) {
        super(context);
        AssetManager assetManager = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/VtksBelinha.ttf");
        setTypeface(typeface);
    }

    public CustomFrontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        AssetManager assetManager = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/VtksBelinha.ttf");
        setTypeface(typeface);
    }

    public CustomFrontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        AssetManager assetManager = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/VtksBelinha.ttf");
        setTypeface(typeface);
    }

}
