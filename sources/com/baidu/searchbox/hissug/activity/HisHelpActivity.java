package com.baidu.searchbox.hissug.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IWebModifyPwdCallback;
import com.baidu.searchbox.account.result.BoxSapiResult;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.hissug.R;
import com.baidu.searchbox.ui.BdActionBar;

public class HisHelpActivity extends ActionToolBarActivity {
    private RelativeLayout mChangePwd;
    private TextView mChangePwdDetail;
    private ImageView mChangePwdIcon;
    private TextView mChangePwdTitle;
    private ViewGroup mRoot;
    private TextView mTitle;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_his_help_layout);
        setPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left, com.baidu.android.common.ui.style.R.anim.slide_in_from_left, com.baidu.android.common.ui.style.R.anim.slide_out_to_right);
        setEnableSliding(true);
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        if (bdActionBar != null) {
            bdActionBar.setTitle(getResources().getString(R.string.search_sug_feedback_help_title));
            ActionBarExtKt.showActionBarWithoutLeft(this);
        }
        this.mRoot = (ViewGroup) findViewById(R.id.search_his_help_root);
        this.mTitle = (TextView) findViewById(R.id.search_his_help_detail);
        this.mChangePwd = (RelativeLayout) findViewById(R.id.search_his_help_change_password);
        this.mChangePwdTitle = (TextView) findViewById(R.id.search_his_help_change_password_title);
        this.mChangePwdDetail = (TextView) findViewById(R.id.search_his_help_change_password_detail);
        this.mChangePwdIcon = (ImageView) findViewById(R.id.search_his_help_change_password_icon);
        setColor();
        this.mChangePwd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
                if (boxAccountManager.isLogin(2)) {
                    boxAccountManager.loadModifyPwd(new IWebModifyPwdCallback() {
                        public void onFinish(BoxSapiResult var1) {
                        }
                    });
                }
            }
        });
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        setColor();
    }

    private void setColor() {
        this.mRoot.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC49));
        this.mTitle.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC2));
        this.mChangePwdTitle.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        this.mChangePwdDetail.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC2));
        this.mChangePwd.setBackground(getResources().getDrawable(R.drawable.search_sug_his_help_item_bg));
        this.mChangePwdIcon.setImageDrawable(getResources().getDrawable(R.drawable.search_sug_his_help_arrow));
    }
}
