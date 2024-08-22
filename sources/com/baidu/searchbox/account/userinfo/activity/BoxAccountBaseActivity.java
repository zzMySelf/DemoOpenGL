package com.baidu.searchbox.account.userinfo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.baidu.android.ext.widget.LoadingView;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.appframework.ext.ToolBarExtKt;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;

public abstract class BoxAccountBaseActivity extends ActionToolBarActivity {
    private LoadingView mLoadingView;

    /* access modifiers changed from: protected */
    public abstract RelativeLayout getRootView();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToolBarExtKt.dismissToolBar(this);
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ActionBarExtKt.showActionBarWithoutLeft(this);
    }

    /* access modifiers changed from: protected */
    public void showLoadingView(int msgRes) {
        if (!isFinishing()) {
            if (this.mLoadingView == null) {
                if (getRootView() != null) {
                    this.mLoadingView = new LoadingView(this);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-2, -2);
                    params.addRule(13);
                    ViewGroup parent = (ViewGroup) this.mLoadingView.getParent();
                    if (parent != null) {
                        parent.removeView(this.mLoadingView);
                    }
                    getRootView().addView(this.mLoadingView, params);
                } else {
                    return;
                }
            }
            this.mLoadingView.setMsg(msgRes);
            this.mLoadingView.show();
        }
    }

    public void hideLoadingView() {
        LoadingView loadingView;
        if (!isFinishing() && (loadingView = this.mLoadingView) != null) {
            loadingView.dismiss();
        }
    }

    public BdActionBar getBdActionBar() {
        return ActionBarExtKt.getBdActionBar(this);
    }

    public static void showInputMethod(Context aContext, View aView) {
        InputMethodManager imm;
        if (aContext != null && aView != null && (imm = (InputMethodManager) aContext.getSystemService(InputMethodController.BUTTON_INPUT_METHOD)) != null) {
            imm.showSoftInput(aView, 0);
        }
    }

    public static void hideInputMethod(Context aContext, View aView) {
        InputMethodManager imm;
        if (aContext != null && aView != null && (imm = (InputMethodManager) aContext.getSystemService(InputMethodController.BUTTON_INPUT_METHOD)) != null && imm.isActive()) {
            imm.hideSoftInputFromWindow(aView.getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: protected */
    public void updateToolBarAndActionBar() {
        BdActionBar actionBar = getBdActionBar();
        Intent intent = getIntent();
        if (intent.getBooleanExtra("extra_is_show_tool_bar_key", true)) {
            ToolBarExtKt.showToolBar(this);
        }
        int intExtra = intent.getIntExtra("extra_left_image_src_key", 0);
        if (actionBar != null) {
            if (intExtra == 0) {
                actionBar.setLeftFirstViewVisibility(8);
                return;
            }
            actionBar.setLeftFirstViewVisibility(0);
            actionBar.setLeftZoneImageSrc(intExtra);
        }
    }

    public void onToolBarBackPressed() {
        super.onToolBarBackPressed();
        HashMap<String, String> statData = new HashMap<>();
        statData.put("from", "light_na");
        statData.put("type", "toolbar");
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("206", (Map<String, String>) statData);
    }

    public void showToolBar() {
        ToolBarExtKt.showToolBar(this);
    }

    /* access modifiers changed from: protected */
    public void setActionBarTitle(int title) {
        BdActionBar actionBar = getBdActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
}
