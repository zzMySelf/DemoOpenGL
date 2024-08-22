package com.baidu.wallet.remotepay;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.realtimeevent.RealTimeEventHelper;
import java.util.ArrayList;
import java.util.Map;

public class RemotePayEnterActivity extends PayBaseBeanActivity {
    public static final String TAG = "RemotePayEnterActivity";
    public IRemoteServiceCallback a;
    public Map<String, String> b;
    public Map<String, String> c;
    public String d;

    public void getBundleData(Intent intent) {
        Bundle bundle;
        ArrayList arrayList;
        if (intent != null) {
            IBinder iBinder = null;
            try {
                bundle = intent.getBundleExtra("caller");
            } catch (Exception unused) {
                bundle = null;
            }
            if (bundle != null) {
                this.d = bundle.getString("order_info");
                String str = "";
                if (Build.VERSION.SDK_INT < 18) {
                    try {
                        iBinder = (IBinder) bundle.getClass().getDeclaredMethod("getIBinder", new Class[]{String.class}).invoke(bundle, new Object[]{"callback"});
                    } catch (Exception e) {
                        String str2 = this.d;
                        String[] strArr = new String[2];
                        Map<String, String> map = this.c;
                        strArr[0] = (map == null || map.isEmpty()) ? str : this.c.get("key_remote_pkg_name");
                        strArr[1] = e.getMessage();
                        StatisticManager.onEventWithValues("remoteEnterActivityBinderCatch", RealTimeEventHelper.genEventValue(str2, strArr));
                        LogUtil.e(TAG, e.getMessage(), e);
                        finish();
                    }
                } else {
                    iBinder = bundle.getBinder("callback");
                }
                try {
                    this.a = IRemoteServiceCallback.Stub.asInterface(iBinder);
                } catch (Exception e2) {
                    String str3 = this.d;
                    String[] strArr2 = new String[2];
                    Map<String, String> map2 = this.c;
                    if (map2 != null && !map2.isEmpty()) {
                        str = this.c.get("key_remote_pkg_name");
                    }
                    strArr2[0] = str;
                    strArr2[1] = e2.getMessage();
                    StatisticManager.onEventWithValues("remoteEnterActivityInitcallbackCatch", RealTimeEventHelper.genEventValue(str3, strArr2));
                    LogUtil.e(TAG, e2.getMessage(), e2);
                    finish();
                }
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("map_params");
                if (parcelableArrayList != null && parcelableArrayList.size() > 0 && (arrayList = (ArrayList) parcelableArrayList.get(0)) != null && arrayList.size() > 0) {
                    this.b = (Map) arrayList.get(0);
                    this.c = (Map) arrayList.get(1);
                }
            }
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getBundleData(getIntent());
        String str = this.d;
        String[] strArr = new String[2];
        Map<String, String> map = this.c;
        strArr[0] = (map == null || map.isEmpty()) ? "" : this.c.get("key_remote_pkg_name");
        strArr[1] = ActivityChooserModel.ATTRIBUTE_ACTIVITY;
        StatisticManager.onEventWithValues("remoteEnterActivity", RealTimeEventHelper.genEventValue(str, strArr));
        if (BeanConstants.CHANNEL_ID.equals(DxmPayBeanConstants.CHANNEL_ID_CHE_LIAN_WANG)) {
            WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(getActivity(), new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    RemotePayEnterActivity.this.a();
                }

                public void onSuccess(int i2, String str) {
                    RemotePayEnterActivity.this.a();
                }
            }));
        } else {
            a();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getBundleData(intent);
        String str = this.d;
        String[] strArr = new String[2];
        Map<String, String> map = this.c;
        strArr[0] = (map == null || map.isEmpty()) ? "" : this.c.get("key_remote_pkg_name");
        strArr[1] = ActivityChooserModel.ATTRIBUTE_ACTIVITY;
        StatisticManager.onEventWithValues("remoteEnterActivity", RealTimeEventHelper.genEventValue(str, strArr));
        BaiduPayDelegate.getInstance().doRemotePay(this, this.d, new PayCallBack() {
            public boolean isHideLoadingDialog() {
                if (RemotePayEnterActivity.this.a != null) {
                    try {
                        RemotePayEnterActivity.this.a.isHideLoadingDialog();
                    } catch (RemoteException e) {
                        String c = RemotePayEnterActivity.this.d;
                        String[] strArr = new String[2];
                        strArr[0] = (RemotePayEnterActivity.this.c == null || RemotePayEnterActivity.this.c.isEmpty()) ? "" : (String) RemotePayEnterActivity.this.c.get("key_remote_pkg_name");
                        strArr[1] = e.getMessage();
                        StatisticManager.onEventWithValues("remoteEnterActivityCatch", RealTimeEventHelper.genEventValue(c, strArr));
                        LogUtil.e(RemotePayEnterActivity.TAG, e.getMessage(), e);
                    } catch (Throwable th2) {
                        RemotePayEnterActivity.this.finish();
                        throw th2;
                    }
                    RemotePayEnterActivity.this.finish();
                }
                return false;
            }

            public void onPayResult(int i2, String str) {
                if (1000 == i2) {
                    RemotePayEnterActivity.this.finish();
                }
                if (RemotePayEnterActivity.this.a != null) {
                    try {
                        RemotePayEnterActivity.this.a.onPayEnd(i2, str);
                    } catch (Exception e) {
                        String c = RemotePayEnterActivity.this.d;
                        String[] strArr = new String[2];
                        strArr[0] = (RemotePayEnterActivity.this.c == null || RemotePayEnterActivity.this.c.isEmpty()) ? "" : (String) RemotePayEnterActivity.this.c.get("key_remote_pkg_name");
                        strArr[1] = e.getMessage();
                        StatisticManager.onEventWithValues("remoteEnterActivityCatch", RealTimeEventHelper.genEventValue(c, strArr));
                        PayCallBackManager.isClientDead = true;
                    } catch (Throwable th2) {
                        RemotePayEnterActivity.this.finish();
                        throw th2;
                    }
                    RemotePayEnterActivity.this.finish();
                }
            }
        }, this.c);
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    public void a() {
        BaiduPayDelegate.getInstance().doRemotePay(this, this.d, new PayCallBack() {
            public boolean isHideLoadingDialog() {
                if (RemotePayEnterActivity.this.a != null) {
                    try {
                        RemotePayEnterActivity.this.a.isHideLoadingDialog();
                    } catch (RemoteException e) {
                        String c = RemotePayEnterActivity.this.d;
                        String[] strArr = new String[2];
                        strArr[0] = (RemotePayEnterActivity.this.c == null || RemotePayEnterActivity.this.c.isEmpty()) ? "" : (String) RemotePayEnterActivity.this.c.get("key_remote_pkg_name");
                        strArr[1] = e.getMessage();
                        StatisticManager.onEventWithValues("remoteEnterActivityCatch", RealTimeEventHelper.genEventValue(c, strArr));
                        LogUtil.e(RemotePayEnterActivity.TAG, e.getMessage(), e);
                    } catch (Throwable th2) {
                        RemotePayEnterActivity.this.finish();
                        throw th2;
                    }
                    RemotePayEnterActivity.this.finish();
                }
                return false;
            }

            public void onPayResult(int i2, String str) {
                if (1000 == i2) {
                    RemotePayEnterActivity.this.finish();
                }
                if (RemotePayEnterActivity.this.a != null) {
                    try {
                        RemotePayEnterActivity.this.a.onPayEnd(i2, str);
                    } catch (RemoteException e) {
                        String c = RemotePayEnterActivity.this.d;
                        String[] strArr = new String[2];
                        strArr[0] = (RemotePayEnterActivity.this.c == null || RemotePayEnterActivity.this.c.isEmpty()) ? "" : (String) RemotePayEnterActivity.this.c.get("key_remote_pkg_name");
                        strArr[1] = e.getMessage();
                        StatisticManager.onEventWithValues("remoteEnterActivityCatch", RealTimeEventHelper.genEventValue(c, strArr));
                        PayCallBackManager.isClientDead = true;
                        LogUtil.e(RemotePayEnterActivity.TAG, e.getMessage(), e);
                    } catch (Throwable th2) {
                        RemotePayEnterActivity.this.finish();
                        throw th2;
                    }
                    RemotePayEnterActivity.this.finish();
                }
            }
        }, this.c);
    }
}
