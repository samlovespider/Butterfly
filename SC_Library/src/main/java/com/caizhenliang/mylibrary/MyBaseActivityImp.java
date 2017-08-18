package com.caizhenliang.mylibrary;

/**
 * Created by caizhenliang on 2017/7/19.
 */
public interface MyBaseActivityImp {

    /**
     * init Data
     */
    void initData();

    /**
     * init View
     */
    void initView();

    /**
     * handle EventBus event
     *
     * @param event
     */
    void handleEvent(Object event);
}
