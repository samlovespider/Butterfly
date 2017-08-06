package com.caizhenliang.mylibrary;

import android.view.MenuItem;
import android.view.View;

/**
 * Created by caizhenliang on 2017/7/26.
 */

public interface MyClickMethodImp {

    /**
     * @param menuItem
     */
    public abstract void initMenuItem(MenuItem menuItem);

    /**
     * @param view
     */
    public abstract void initClick(View view);

    /**
     * @param object
     */
    public abstract void initEvent(Object object);

    /**
     * @param position
     */
    public abstract void initItemClick(int position);

    /**
     * @param object
     */
    public abstract void initItemClick(Object object);

    /**
     * @param position
     */
    public abstract void initItemLongClick(int position);

    /**
     * @param object
     */
    public abstract void initItemLongClick(Object object);
}
