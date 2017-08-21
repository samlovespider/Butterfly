package com.caizhenliang.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 *
 */
abstract public class MyBaseActivity extends AppCompatActivity implements MyBaseActivityImp, MyClickMethodImp {

    protected ActionBar mActionBar;
    protected MyAlertDialogTool myAlertDialogTool;//use to create alertdialog

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        myAlertDialogTool = new MyAlertDialogTool(this);
        mActionBar = getSupportActionBar();
    }

    /**
     * post EventBus event
     *
     * @param event
     */
    protected void postEvent(Object event) {
        EventBus.getDefault().post(event);
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    /**
     * 跳转Activity；
     *
     * @param paramClass Activity参数
     */
    protected void gotoActivity(Class<?> paramClass) {
        doGotoActivity(paramClass, null);
    }

    /**
     * 跳转Activity，带有Bundle参数；
     *
     * @param paramClass Activity参数
     * @param bundle     Bundle参数
     */
    protected void gotoActivity(Class<?> paramClass, Bundle bundle) {
        doGotoActivity(paramClass, bundle);
    }

    /**
     * 跳转Activity，带有Bundle参数，并且该Activity不会压入栈中，返回后自动关闭；
     *
     * @param paramClass Activity参数
     * @param bundle     Bundle参数
     */
    protected void gotoActivityNoHistory(Class<?> paramClass, Bundle bundle) {
        doGotoActivity(paramClass, bundle, Intent.FLAG_ACTIVITY_NO_HISTORY);
    }

    /**
     * @param paramClass
     * @param bundle
     * @param paramInt
     */
    protected void gotoActivityForResult(Class<?> paramClass, Bundle bundle, int paramInt) {
        Intent lIntent = new Intent(this.getBaseContext(), paramClass);
        if (bundle != null) {
            lIntent.putExtras(bundle);
            lIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        }
        startActivityForResult(lIntent, paramInt);
    }


    /**
     * 跳转Activity，带有Bundle参数，如果该Activity已启动过，则不启动新的；
     *
     * @param paramClass Activity参数
     * @param bundle     Bundle参数
     */
    private void doGotoActivity(Class<?> paramClass, Bundle bundle) {
        Intent lIntent = new Intent(this.getBaseContext(), paramClass);
        if (bundle != null) {
            lIntent.putExtras(bundle);
            lIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        }
        startActivity(lIntent);
    }

    /**
     * 跳转Activity，带有Bundle参数，可以设置启动模式；
     *
     * @param paramClass Activity参数
     * @param bundle     Bundle参数
     * @param intentFlag 　启动模式
     * @see Intent
     */
    private void doGotoActivity(Class<?> paramClass, Bundle bundle, int intentFlag) {
        Intent lIntent = new Intent(this.getBaseContext(), paramClass);
        if (bundle != null) {
            lIntent.putExtras(bundle);
            lIntent.addFlags(intentFlag);
        }
        startActivity(lIntent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


}
