package com.baidu.android.lbspay.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.view.TitleBar;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.SDKBaseActivity;

public abstract class LBSBaseActivity extends DxmPayBaseActivity implements IBeanResponseCallback, NoProguard {
    public BroadcastReceiver mExitReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (LBSPayResult.ACTION_EXIT.equals(intent.getAction())) {
                LBSBaseActivity.this.finish();
            }
        }
    };
    public Handler mHandler = null;
    public TitleBar titleBar;

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(getMainLooper());
        }
        return this.mHandler;
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public abstract void handleFailure(int i2, int i3, String str);

    public abstract void handleResponse(int i2, Object obj, String str);

    public boolean isSlidingEnable() {
        return false;
    }

    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        getHandler().post(new Runnable() {
            public void run() {
                LBSBaseActivity.this.handleFailure(i2, i3, str);
            }
        });
    }

    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        getHandler().post(new Runnable() {
            public void run() {
                LBSBaseActivity.this.handleResponse(i2, obj, str);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.mExitReceiver, new IntentFilter(LBSPayResult.ACTION_EXIT));
    }

    public void onDestroy() {
        if (this.mExitReceiver != null) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.mExitReceiver);
        }
        super.onDestroy();
    }

    public void setBackButton() {
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 != null) {
            titleBar2.setLeftButton(new View.OnClickListener() {
                public void onClick(View view) {
                    LBSBaseActivity.this.onBackPressed();
                }
            });
        }
    }
}
