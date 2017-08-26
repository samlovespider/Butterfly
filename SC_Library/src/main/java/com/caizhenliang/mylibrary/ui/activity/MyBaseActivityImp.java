package com.caizhenliang.mylibrary.ui.activity;

/**
 * Created by caizhenliang on 2017/7/19.
 */
public interface MyBaseActivityImp {

    /**
     * init Data, must go first
     */
    void initData();

    /**
     * init View
     */
    void initView();

    /**
     *
     */
    void onEvent(Object o);
}
