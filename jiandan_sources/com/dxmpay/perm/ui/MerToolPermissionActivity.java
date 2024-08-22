package com.dxmpay.perm.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.aiscan.R;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.perm.bean.MerToolPermInfo;
import com.dxmpay.perm.listener.MerToolPermissionListener;
import com.dxmpay.perm.listener.MerToolSettingDialogListener;
import com.dxmpay.perm.ui.dialog.MerVerticalTwoActionDialog;
import com.dxmpay.wallet.core.BaseActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class MerToolPermissionActivity extends BaseActivity {
    public static final String KEY_PERM_INFO = "perm_info";
    public static MerToolPermissionListener mMerToolPermissionListener;
    public static MerToolSettingDialogListener mSettingDialogCallBack;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean mIsGotoSetting;
    public LinearLayout mLlPerm;
    public LinearLayout mLlRoot;
    public MerToolPermInfo[] mPermInfo;
    public int mRequestIndex;
    public MerVerticalTwoActionDialog mSettingDialog;
    public TextView mTvDesc;
    public TextView mTvTitle;
    public Map<String, Integer> map = new LinkedHashMap();

    public class ad implements MerVerticalTwoActionDialog.a {
        public final /* synthetic */ int qw;

        public ad(int i2) {
            this.qw = i2;
        }

        public void a() {
            if (MerToolPermissionActivity.mSettingDialogCallBack != null) {
                MerToolPermissionActivity.mSettingDialogCallBack.onGotoSetting();
            }
            MerToolPermissionActivity.this.mSettingDialog.dismiss();
            if (MerToolPermissionActivity.this.mPermInfo[this.qw].isGotoSettingPage()) {
                MerToolPermissionActivity.this.openAppDetailSetting();
                boolean unused = MerToolPermissionActivity.this.mIsGotoSetting = true;
                return;
            }
            MerToolPermissionActivity.this.finishPage();
        }
    }

    public class de implements Runnable {
        public de() {
        }

        public void run() {
            MerToolPermissionActivity.this.mLlRoot.setVisibility(0);
            MerToolPermissionActivity.this.mTvTitle.setText(MerToolPermissionActivity.this.mPermInfo[MerToolPermissionActivity.this.mRequestIndex].getAimTitle());
            MerToolPermissionActivity.this.mTvDesc.setText(MerToolPermissionActivity.this.mPermInfo[MerToolPermissionActivity.this.mRequestIndex].getAimDesc());
        }
    }

    public class qw implements MerVerticalTwoActionDialog.b {
        public qw() {
        }

        public void a() {
            if (MerToolPermissionActivity.mSettingDialogCallBack != null) {
                MerToolPermissionActivity.mSettingDialogCallBack.onCloseSettingDialog();
            }
            MerToolPermissionActivity.this.mSettingDialog.dismiss();
            MerToolPermissionActivity.this.finishPage();
        }
    }

    private void callBackOnRequestPermission(int i2) {
        Map<String, Integer> map2;
        if (mMerToolPermissionListener != null && (map2 = this.map) != null) {
            Collection<Integer> values = map2.values();
            int[] iArr = new int[values.size()];
            int i3 = 0;
            for (Integer intValue : values) {
                iArr[i3] = intValue.intValue();
                i3++;
            }
            mMerToolPermissionListener.onRequestPermissionsResult(i2, (String[]) this.map.keySet().toArray(new String[this.map.keySet().size()]), iArr);
        }
    }

    private GradientDrawable createRectangleDrawable(Context context, @ColorInt int i2, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((float) DisplayUtils.dip2px(context, f));
        return gradientDrawable;
    }

    /* access modifiers changed from: private */
    public void finishPage() {
        finish();
        overridePendingTransition(0, 0);
        release();
    }

    private void initView() {
        this.mPermInfo = (MerToolPermInfo[]) getIntent().getSerializableExtra(KEY_PERM_INFO);
        this.mLlRoot = (LinearLayout) findViewById(R.id.ll_root);
        this.mLlPerm = (LinearLayout) findViewById(R.id.ll_perm);
        this.mTvTitle = (TextView) findViewById(R.id.tv_title);
        this.mTvDesc = (TextView) findViewById(R.id.tv_desc);
        this.mLlPerm.setBackground(createRectangleDrawable(this, -1, 10.0f));
    }

    private boolean isShowSettingDialog(int i2) {
        MerToolPermInfo[] merToolPermInfoArr = this.mPermInfo;
        if (i2 < merToolPermInfoArr.length && merToolPermInfoArr[i2].isShowRejectGuide() && !TextUtils.isEmpty(this.mPermInfo[i2].getRejectTitle()) && !TextUtils.isEmpty(this.mPermInfo[i2].getRejectDesc())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void openAppDetailSetting() {
        try {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivity(intent);
        } catch (Exception e) {
            LogUtil.errord(e.getMessage());
        }
    }

    private void release() {
        mMerToolPermissionListener = null;
        mSettingDialogCallBack = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        Map<String, Integer> map2 = this.map;
        if (map2 != null) {
            map2.clear();
        }
        this.mRequestIndex = 0;
    }

    @RequiresApi(api = 23)
    private void requestPerm(int i2) {
        this.mRequestIndex = i2;
        requestPermissions(new String[]{this.mPermInfo[i2].getPermission()}, this.mPermInfo[i2].getRequestCode());
        showAimContent();
    }

    @RequiresApi(api = 23)
    private boolean requestPermAllAllow() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = -1;
        while (true) {
            MerToolPermInfo[] merToolPermInfoArr = this.mPermInfo;
            if (i2 >= merToolPermInfoArr.length) {
                break;
            }
            String permission = merToolPermInfoArr[i2].getPermission();
            if (!TextUtils.isEmpty(permission)) {
                int checkSelfPermission = checkSelfPermission(permission);
                this.map.put(permission, Integer.valueOf(checkSelfPermission));
                if (checkSelfPermission != 0) {
                    if (i3 == -1) {
                        i3 = i2;
                    }
                    arrayList.add(permission);
                }
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            callBackOnRequestPermission(this.mPermInfo[0].getRequestCode());
            finishPage();
            return true;
        }
        requestPerm(i3);
        return false;
    }

    private void showAimContent() {
        int i2 = this.mRequestIndex;
        MerToolPermInfo[] merToolPermInfoArr = this.mPermInfo;
        if (i2 < merToolPermInfoArr.length && merToolPermInfoArr[i2].isShowAimGuide() && !TextUtils.isEmpty(this.mPermInfo[this.mRequestIndex].getAimTitle()) && !TextUtils.isEmpty(this.mPermInfo[this.mRequestIndex].getAimDesc())) {
            this.mHandler.postDelayed(new de(), 500);
        }
    }

    private void showRejectDialog(int i2) {
        if (i2 >= this.mPermInfo.length) {
            finishPage();
            return;
        }
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mLlRoot.setVisibility(8);
        MerVerticalTwoActionDialog merVerticalTwoActionDialog = new MerVerticalTwoActionDialog(this);
        this.mSettingDialog = merVerticalTwoActionDialog;
        merVerticalTwoActionDialog.setTitle(this.mPermInfo[i2].getRejectTitle()).setContent(this.mPermInfo[i2].getRejectDesc()).setActionOne("去设置", new ad(i2)).setActionTwo("暂不设置", new qw()).show();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.dxmpay.perm.bean.MerToolPermInfo[], java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void start(android.content.Context r0, com.dxmpay.perm.bean.MerToolPermInfo[] r1, com.dxmpay.perm.listener.MerToolPermissionListener r2, com.dxmpay.perm.listener.MerToolSettingDialogListener r3) {
        /*
            mMerToolPermissionListener = r2
            mSettingDialogCallBack = r3
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.dxmpay.perm.ui.MerToolPermissionActivity> r3 = com.dxmpay.perm.ui.MerToolPermissionActivity.class
            r2.<init>(r0, r3)
            boolean r3 = r0 instanceof android.app.Activity
            if (r3 != 0) goto L_0x0014
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r2.addFlags(r3)
        L_0x0014:
            java.lang.String r3 = "perm_info"
            r2.putExtra(r3, r1)
            r0.startActivity(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.perm.ui.MerToolPermissionActivity.start(android.content.Context, com.dxmpay.perm.bean.MerToolPermInfo[], com.dxmpay.perm.listener.MerToolPermissionListener, com.dxmpay.perm.listener.MerToolSettingDialogListener):void");
    }

    @RequiresApi(api = 23)
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dxm_activity_mer_permission);
        overridePendingTransition(0, 0);
        initView();
        requestPermAllAllow();
    }

    public void onDestroy() {
        super.onDestroy();
        release();
    }

    @RequiresApi(api = 23)
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (iArr.length != 0 && strArr.length != 0) {
            if (i2 != this.mPermInfo[this.mRequestIndex].getRequestCode()) {
                finishPage();
                return;
            }
            boolean z = false;
            this.map.put(strArr[0], Integer.valueOf(iArr[0]));
            if (iArr[0] == 0) {
                z = requestPermAllAllow();
            } else if (isShowSettingDialog(this.mRequestIndex)) {
                showRejectDialog(this.mRequestIndex);
            } else {
                z = true;
            }
            if (z) {
                callBackOnRequestPermission(i2);
                finishPage();
            }
        }
    }

    @RequiresApi(api = 23)
    public void onResume() {
        super.onResume();
        if (this.mIsGotoSetting) {
            this.mIsGotoSetting = false;
            String permission = this.mPermInfo[this.mRequestIndex].getPermission();
            if (!TextUtils.isEmpty(permission)) {
                this.map.put(permission, Integer.valueOf(checkSelfPermission(permission)));
                callBackOnRequestPermission(this.mPermInfo[this.mRequestIndex].getRequestCode());
            }
            finishPage();
        }
    }
}
