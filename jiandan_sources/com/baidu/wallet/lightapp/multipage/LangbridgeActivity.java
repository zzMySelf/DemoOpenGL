package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.f0.c;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.PromptDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.ActivityStackManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.lightapp.base.a;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.business.LangbridgeBarParams;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.wallet.utils.UUIDGenerator;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class LangbridgeActivity extends BaseActivity implements ComponentCallbacks2, d {
    public static final int ID_DLG_BANDOWNLOAD = 1000;
    public static final String IS_SHOW_NATIVE_ERROR_PAGE = "isShowDefaultErrorPage";
    public static final String IS_SHOW_TITLE_BAR = "isShowTitleBar";
    public static final String KEY_DISABLE_SCREENSHOT = "disableScreenshot";
    public static final String LANGBRIDGE_HASH = "LANGBRIDGE_HASH";
    public static final String LIGHT_SHOW_SHARE = "shwoshare";
    public static final String TAG = LangbridgeActivity.class.getSimpleName();
    public static final String TITLE = "title";
    public static int j = 0;
    public Stack<c> a = new Stack<>();
    public String b;
    public boolean c = false;
    public String d;
    public int e = 0;
    public long f = 0;
    public boolean g = true;
    public boolean h = true;

    /* renamed from: i  reason: collision with root package name */
    public View f3572i;
    public String k = "";
    public double l;
    public String m;
    public Bundle mParams;
    public Vector<Application.ActivityLifecycleCallbacks> n = new Vector<>();

    /* renamed from: com.baidu.wallet.lightapp.multipage.LangbridgeActivity$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baidu.wallet.lightapp.multipage.LangbridgeActivity$LifeCycleCbName[] r0 = com.baidu.wallet.lightapp.multipage.LangbridgeActivity.LifeCycleCbName.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.wallet.lightapp.multipage.LangbridgeActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.multipage.LangbridgeActivity.LifeCycleCbName.OnCreated     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.lightapp.multipage.LangbridgeActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.multipage.LangbridgeActivity.LifeCycleCbName.OnStarted     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.wallet.lightapp.multipage.LangbridgeActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.multipage.LangbridgeActivity.LifeCycleCbName.OnResumed     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.wallet.lightapp.multipage.LangbridgeActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.multipage.LangbridgeActivity.LifeCycleCbName.OnPaused     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baidu.wallet.lightapp.multipage.LangbridgeActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.multipage.LangbridgeActivity.LifeCycleCbName.OnStopped     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.baidu.wallet.lightapp.multipage.LangbridgeActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.multipage.LangbridgeActivity.LifeCycleCbName.OnSaveInstanceState     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.baidu.wallet.lightapp.multipage.LangbridgeActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.multipage.LangbridgeActivity.LifeCycleCbName.OnDestroyed     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.LangbridgeActivity.AnonymousClass2.<clinit>():void");
        }
    }

    public enum LifeCycleCbName {
        OnCreated,
        OnStarted,
        OnResumed,
        OnPaused,
        OnStopped,
        OnSaveInstanceState,
        OnDestroyed
    }

    private Bundle a(Bundle bundle) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                this.b = extras.getString("jump_url");
                this.c = extras.getBoolean("shwoshare", false);
                this.d = extras.getString("title");
                this.e = extras.getInt("baidu.wallet.lightapp.biztype", 0);
                this.f = extras.getLong("LANGBRIDGE_HASH", 0);
                this.l = extras.getDouble(Constants.HALF_LIGHTBRIDGE_HEIGHT, -0.0d);
                this.m = extras.getString(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR);
                String str = TAG;
                LogUtil.d(str, "接收mHalfHeight：" + this.l + " ,mHalfColor:" + this.m);
                if (extras.containsKey("lifecycleLsnr") && (activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) extras.get("lifecycleLsnr")) != null) {
                    a(activityLifecycleCallbacks);
                }
            } catch (Exception unused) {
            }
        }
        a((Application.ActivityLifecycleCallbacks) i.a());
        boolean z = true;
        if (bundle != null) {
            this.b = bundle.getString("jump_url");
            this.c = bundle.getBoolean("shwoshare", false);
            this.d = bundle.getString("title");
            this.g = bundle.getBoolean(IS_SHOW_NATIVE_ERROR_PAGE, true);
            this.h = bundle.getBoolean(IS_SHOW_TITLE_BAR, true);
            this.l = bundle.getDouble(Constants.HALF_LIGHTBRIDGE_HEIGHT, -0.0d);
            this.m = bundle.getString(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR);
        }
        if (!TextUtils.isEmpty(this.b)) {
            if (this.b.contains("showShare=1") || this.b.contains("showShare%3d1")) {
                this.c = true;
            }
            if (this.b.contains("hideShare=1") || this.b.contains("hideShare%3d1")) {
                this.c = false;
            }
            if (this.b.contains("hideNativeErrorPage=1") || this.b.contains("hideNativeErrorPage%3d1")) {
                this.g = false;
            }
            if (this.b.contains("hideTitleBar")) {
                this.h = false;
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("lang_showshare", this.c);
        bundle2.putBoolean("lang_showtitle", this.h);
        bundle2.putBoolean("lang_showerror", this.g);
        if (extras != null) {
            bundle2.putBoolean("lang_longtitle", extras.getBoolean("long_title", true));
            bundle2.putBoolean("lang_icontitle", extras.getBoolean("only_icons"));
        }
        bundle2.putString("lang_customtitle", this.d);
        double d2 = this.l;
        if (d2 != -0.0d) {
            bundle2.putDouble(Constants.HALF_LIGHTBRIDGE_HEIGHT, d2);
        }
        if (this.l == -0.0d) {
            z = false;
        }
        if (z) {
            getWindow().getDecorView().setBackgroundColor(0);
        } else {
            getWindow().getDecorView().setBackgroundColor(-1);
        }
        if (!TextUtils.isEmpty(this.m)) {
            bundle2.putString(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR, this.m);
        }
        return bundle2;
    }

    private void b() {
        while (this.a.size() > 0) {
            this.a.pop().i();
        }
        f.a().b(this.a);
    }

    public static Intent getStartIntent(Context context, String str, boolean z, boolean z2) {
        return a(context, str, (String) null, z, z2);
    }

    public static void startLangbridge(Context context, String str, String str2, boolean z, boolean z2, Double d2, String str3) {
        startLangbridge(context, str, str2, z, z2, d2, str3, (Bundle) null);
    }

    public void backPressed() {
        onBackPressed();
    }

    public void closeTopWebview() {
        DXMSdkSAUtils.onEvent("#closeTopWebview");
        c a2 = a();
        if (a2 != null) {
            DXMSdkSAUtils.onEventWithValues("#closeTopWebviewRet", Arrays.asList(new String[]{"CLS"}));
            setContentView(a2.a(), false);
            a2.d();
            return;
        }
        DXMSdkSAUtils.onEventWithValues("#closeTopWebviewRet", Arrays.asList(new String[]{"KEEP"}));
    }

    public void closeWindow() {
        finish();
    }

    public boolean controlCloseIcon(LightappBrowserWebView lightappBrowserWebView) {
        return showCloseIcon(lightappBrowserWebView);
    }

    public boolean createLangbridgeCell(String str, boolean z, boolean z2, String str2) {
        LightappBrowserWebView lightappWebViewFromPool;
        c currentCell = getCurrentCell();
        if (currentCell != null) {
            LangbridgeBarParams l2 = currentCell.l();
            Bundle bundle = this.mParams;
            if (bundle != null) {
                bundle.putSerializable("lang_prebarparams", l2);
            }
        }
        c cellFromPrePool = LangbridgePreloadCellCenter.getInstance(this).getCellFromPrePool(str, getOwnerTag(), z2);
        boolean z3 = true;
        if (cellFromPrePool != null) {
            cellFromPrePool.a((d) this, this.mParams, getOwnerTag());
            setContentView(cellFromPrePool.a(), true);
            a(cellFromPrePool);
            DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList(new String[]{"" + z, "0"}));
        } else {
            if ((z || (h.a().a((Context) this).MW_ON && f.a().a((Context) this))) && (lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool(getActivity(), z)) != null) {
                cellFromPrePool = new LangbridgeCell((d) this, this.mParams, lightappWebViewFromPool, getOwnerTag());
            }
            if (cellFromPrePool != null) {
                setContentView(cellFromPrePool.a(), true);
                a(cellFromPrePool);
                DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList(new String[]{"" + z, "1"}));
            } else {
                cellFromPrePool = getCurrentCell();
                DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList(new String[]{"" + z, "2"}));
                z3 = false;
            }
            if (cellFromPrePool != null) {
                if (!TextUtils.isEmpty(str2)) {
                    cellFromPrePool.a(str2, (b) null, false);
                } else {
                    cellFromPrePool.a(str, (b) null, false);
                }
            }
        }
        return z3;
    }

    public Activity getControllerActivity() {
        return getActivity();
    }

    public c getCurrentCell() {
        if (this.a.size() > 0) {
            return this.a.peek();
        }
        return null;
    }

    public long getLangbridgeHash() {
        return this.f;
    }

    public String getLangbridgeStamp() {
        return this.k;
    }

    public int getLangbridgeStatus() {
        return j;
    }

    public Activity getNextActivity() {
        return BaseActivity.getNextActivity(getActivity());
    }

    public String getOwnerTag() {
        return toString().hashCode() + "";
    }

    public void historyGo(int i2) {
        DXMSdkSAUtils.onEvent("#eventHistoryGo");
        c a2 = a(i2, false);
        if (a2 != null) {
            setContentView(a2.a(), false);
            a2.d();
        }
    }

    public int historyLength() {
        WebBackForwardList copyBackForwardList;
        Stack<c> stack = this.a;
        int i2 = 0;
        if (stack == null && stack.size() == 0) {
            return 0;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!(cVar == null || cVar.b() == null || (copyBackForwardList = cVar.b().copyBackForwardList()) == null)) {
                i2 += copyBackForwardList.getCurrentIndex() + 1;
            }
        }
        return i2;
    }

    public boolean isActiveCell(@NonNull c cVar) {
        if (this.a.size() <= 0) {
            return false;
        }
        c cVar2 = null;
        try {
            cVar2 = this.a.peek();
        } catch (EmptyStackException e2) {
            e2.printStackTrace();
        }
        return cVar2 != null && cVar2 == cVar;
    }

    public boolean isBottomCell(c cVar) {
        return this.a.lastIndexOf(cVar) == 0;
    }

    public boolean isWindowNightMode() {
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        c currentCell = getCurrentCell();
        if (currentCell != null) {
            currentCell.a(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        c a2;
        increaseIconCloseStatus();
        if (((this.a.size() <= 0 || this.a.peek() == null) ? false : !this.a.peek().c()) && (a2 = a(-1, true)) != null) {
            setContentView(a2.a(), false);
            a2.d();
        }
    }

    public void onCreate(Bundle bundle) {
        int i2 = j;
        if (i2 < 2) {
            j = i2 + 1;
        }
        if (getIntent() == null) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            requestWindowFeature(10);
        }
        super.onCreate(bundle);
        f.a().a((Collection<c>) this.a);
        this.mParams = a(bundle);
        if (TextUtils.isEmpty(this.b)) {
            finish();
            return;
        }
        LangbridgeCacheManager.getInstance().handleCreateLangbirdge(this.b, (WebView) null);
        a(this.b);
        setIsShowMultiWindowTips(true);
        setIsMultiWindowAvailable(false);
        a.a().a(getActivity());
        StringBuilder sb = new StringBuilder();
        sb.append((toString() + System.currentTimeMillis()).hashCode());
        sb.append("");
        this.k = sb.toString();
        createLangbridgeCell(this.b, true, true, "");
        LogUtil.i("LangbridgeActivity", "oncreate, mLangbridgeHashStamp = " + this.k);
        a(LifeCycleCbName.OnCreated, (Bundle) null);
    }

    @Nullable
    public Dialog onCreateDialog(int i2) {
        if (1000 == i2) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        UUIDGenerator.generateUUID();
        LangbridgeCacheManager.getInstance().handleFinishLangbirdge(this.f);
        WhiteScreenMonitor.a().b();
        if (this.e == 12) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this)).route(this, new RouterRequest().provider("dxmPay").action("enterClearRnAuthBack"), (RouterCallback) null);
        }
        a(LifeCycleCbName.OnDestroyed, (Bundle) null);
        b();
        g a2 = g.a();
        a2.a("clear_by_tab", new String[]{getOwnerTag() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
        LangbridgePreloadCellCenter.getInstance(this).clearPreloadPoolByGroup(getOwnerTag());
    }

    public void onPause() {
        super.onPause();
        c currentCell = getCurrentCell();
        WhiteScreenMonitor.a().b();
        if (currentCell != null) {
            currentCell.h();
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (1000 == i2) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(ResUtils.string(DxmApplicationContextImpl.getApplicationContext(this), "bd_wallet_download_prompt"));
            promptDialog.setCanceledOnTouchOutside(true);
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    Activity activity = LangbridgeActivity.this.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        activity.removeDialog(1000);
                    }
                }
            });
            promptDialog.hideNegativeButton();
            return;
        }
        super.onPrepareDialog(i2, dialog);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        c currentCell = getCurrentCell();
        if (currentCell != null) {
            currentCell.a(i2, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        c currentCell = getCurrentCell();
        if (currentCell != null) {
            currentCell.g();
        }
    }

    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        LogUtil.d("LangBridgeActivity", "onTrimMemory level = " + i2);
        if (i2 == 20) {
            Activity realTopActivity = ActivityStackManager.getInstance().getRealTopActivity();
            LogUtil.d("LangBridgeActivity", "onTrimMemory level HIDDEN TopActivity = " + realTopActivity);
            if (realTopActivity != null && realTopActivity.equals(this)) {
                LogUtil.d("LangBridgeActivity", "onTrimMemory level HIDDEN url = " + this.b);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_ENTER_BACKGROUND, Arrays.asList(new String[]{this.b, String.valueOf(1)}));
            }
        }
    }

    public void removeLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.n.removeElement(activityLifecycleCallbacks);
    }

    public void setContentView(View view, boolean z) {
        View view2;
        if (view != null && view != (view2 = this.f3572i)) {
            boolean z2 = view2 != null;
            if (z2) {
                this.f3572i.startAnimation(ResUtils.getAnimation(this, z ? "wallet_langbridge_slide_to_left" : "wallet_langbridge_slide_to_right"));
            }
            this.f3572i = view;
            super.setContentView(view);
            if (z2) {
                view.startAnimation(ResUtils.getAnimation(this, z ? "wallet_langbridge_slide_from_right" : "wallet_langbridge_slide_from_left"));
            }
        }
    }

    public void setLangbridgeStamp(String str) {
        this.k = str;
    }

    public void setRnAuthResult(int i2, String str) {
        if (this.e == 12) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this)).route(this, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2)).data("desc", str), (RouterCallback) null);
        }
    }

    public ArrayList<String> statExtraDatasForPause() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.b);
        return arrayList;
    }

    public static void startLangbridge(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        startLangbridge(context, str, str2, z, z2, (Double) null, "", bundle);
    }

    public static void startLangbridge(Context context, String str, String str2, boolean z, boolean z2, Double d2, String str3, Bundle bundle) {
        Intent a2 = a(context, str, str2, z, z2, d2, str3, bundle);
        if (a2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            a2.putExtra("LANGBRIDGE_HASH", currentTimeMillis);
            LangbridgeCacheManager.getInstance().handleStartLangbirdge(currentTimeMillis, str);
            context.startActivity(a2);
            boolean z3 = ((d2 == null || d2.doubleValue() == -0.0d) && (bundle == null || bundle.getDouble(Constants.HALF_LIGHTBRIDGE_HEIGHT) == -0.0d)) ? false : true;
            if (!(context instanceof Activity)) {
                return;
            }
            if (z3) {
                BaseActivity.startActivityDownUpAnim(context);
            } else if (z) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }
    }

    public static void startLangbridge(Context context, String str, boolean z) {
        startLangbridge(context, str, (String) null, true, z, (Double) null, (String) null);
    }

    private void a(c cVar) {
        if (cVar != null) {
            if (!this.a.isEmpty()) {
                this.a.peek().e();
            }
            this.a.add(cVar);
            cVar.d();
        }
    }

    private c a() {
        c pop;
        if (this.a.size() > 0 && (pop = this.a.pop()) != null) {
            pop.e();
            pop.j();
            if (this.a.size() != 0 && this.a.peek() != null) {
                return this.a.peek();
            }
            if (this.e == 12 && !pop.b().canGoBack()) {
                setRnAuthResult(2, "实名认证取消");
            }
            super.onBackPressed();
        }
        return null;
    }

    private c a(int i2, boolean z) {
        if (i2 == 0 || this.a.size() <= 0) {
            DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList(new String[]{"KEEP"}));
            return null;
        }
        c peek = this.a.peek();
        if (i2 > 0) {
            if (peek.b().canGoBackOrForward(i2)) {
                peek.b().goBackOrForward(i2);
                DXMSdkSAUtils.onEventWithValues("#historyGoPositiveRet", Arrays.asList(new String[]{c.p}));
            } else {
                DXMSdkSAUtils.onEventWithValues("#historyGoPositiveRet", Arrays.asList(new String[]{"FAILED"}));
            }
            DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList(new String[]{"KEEP"}));
            return null;
        }
        int abs = Math.abs(i2);
        Stack stack = new Stack();
        c cVar = peek;
        boolean z2 = true;
        while (true) {
            if (abs <= 0 || cVar == null) {
                break;
            }
            int currentIndex = cVar.b().copyBackForwardList().getCurrentIndex() + 1;
            if (currentIndex > abs) {
                int i3 = 0 - abs;
                if (cVar.b().canGoBackOrForward(i3)) {
                    cVar.b().goBackOrForward(i3);
                    cVar.f();
                    break;
                }
            }
            if (this.a.size() > 1) {
                stack.push(this.a.pop());
                abs = currentIndex <= abs ? abs - currentIndex : 0;
                cVar = this.a.peek();
                z2 = false;
            } else {
                if (this.a.size() == 1) {
                    boolean z3 = currentIndex > abs && !cVar.b().canGoBackOrForward(0 - abs);
                    if ((abs == currentIndex || z3) && z) {
                        if (this.e == 12 && !cVar.b().canGoBack()) {
                            setRnAuthResult(2, "实名认证取消");
                        }
                        super.onBackPressed();
                        cVar = null;
                    }
                }
                z2 = true;
            }
        }
        z2 = false;
        while (!stack.isEmpty()) {
            c cVar2 = (c) stack.peek();
            if (!z2) {
                if (stack.size() == 1) {
                    cVar2.e();
                }
                cVar2.j();
            } else if (z2) {
                this.a.push(cVar2);
            }
            stack.pop();
        }
        if (z2 || cVar == peek) {
            DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList(new String[]{"KEEP"}));
            return null;
        }
        if (cVar != null) {
            DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList(new String[]{cVar.b().getUrl()}));
        } else {
            DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList(new String[]{"CLS"}));
        }
        return cVar;
    }

    private void a(String str) {
        if (TextUtils.equals("1", new UrlQuerySanitizer(str).getValue(KEY_DISABLE_SCREENSHOT))) {
            BdWalletUtils.addFlagsSecure(getActivity());
        }
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2) {
        return a(context, str, str2, z, z2, (Double) null, (String) null, (Bundle) null);
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2, Double d2, String str3, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, LangbridgeActivity.class);
        intent.putExtra("jump_url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("with_anim", z);
        intent.putExtra("shwoshare", z2);
        if (!(d2 == null || d2.doubleValue() == -0.0d)) {
            intent.putExtra(Constants.HALF_LIGHTBRIDGE_HEIGHT, d2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR, str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        return intent;
    }

    private void a(LifeCycleCbName lifeCycleCbName, Bundle bundle) {
        Object[] array = this.n.toArray();
        Activity activity = getActivity();
        switch (AnonymousClass2.a[lifeCycleCbName.ordinal()]) {
            case 1:
                for (int length = array.length - 1; length >= 0; length--) {
                    ((Application.ActivityLifecycleCallbacks) array[length]).onActivityCreated(activity, bundle);
                }
                return;
            case 2:
                for (int length2 = array.length - 1; length2 >= 0; length2--) {
                    ((Application.ActivityLifecycleCallbacks) array[length2]).onActivityStarted(activity);
                }
                return;
            case 3:
                for (int length3 = array.length - 1; length3 >= 0; length3--) {
                    ((Application.ActivityLifecycleCallbacks) array[length3]).onActivityResumed(activity);
                }
                return;
            case 4:
                for (int length4 = array.length - 1; length4 >= 0; length4--) {
                    ((Application.ActivityLifecycleCallbacks) array[length4]).onActivityPaused(activity);
                }
                return;
            case 5:
                for (int length5 = array.length - 1; length5 >= 0; length5--) {
                    ((Application.ActivityLifecycleCallbacks) array[length5]).onActivityStopped(activity);
                }
                return;
            case 6:
                for (int length6 = array.length - 1; length6 >= 0; length6--) {
                    ((Application.ActivityLifecycleCallbacks) array[length6]).onActivitySaveInstanceState(activity, bundle);
                }
                return;
            case 7:
                for (int length7 = array.length - 1; length7 >= 0; length7--) {
                    ((Application.ActivityLifecycleCallbacks) array[length7]).onActivityDestroyed(activity);
                }
                return;
            default:
                return;
        }
    }

    private void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null && !this.n.contains(activityLifecycleCallbacks)) {
            this.n.addElement(activityLifecycleCallbacks);
        }
    }
}
