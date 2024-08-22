package com.baidu.searchbox.download.center.clearcache.guide;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.android.common.PermissionManager;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.guide.controller.ClearCacheGuideController;
import com.baidu.searchbox.download.center.clearcache.guide.data.ClearCacheGuideModel;
import com.baidu.searchbox.download.center.clearcache.guide.model.ClearCacheGuideLocalData;
import com.baidu.searchbox.download.center.clearcache.guide.ubc.ClearCacheGuideUBC;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.home.container.lifecycle.IHomeEventListener;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.newhome.INewHomeEventListener;
import com.baidu.searchbox.newhome.extend.INewHomeApi;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002+,B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\fH\u0016J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\fH\u0016J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010'\u001a\u00020(H\u0007J\u0012\u0010&\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/guide/HomeClearCacheGuide;", "Lcom/baidu/searchbox/home/container/lifecycle/IHomeEventListener;", "Lcom/baidu/searchbox/newhome/INewHomeEventListener;", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(Ljava/lang/ref/WeakReference;)V", "mBdAlertDialog", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "mFreeLimit", "Lcom/baidu/searchbox/download/center/clearcache/guide/data/ClearCacheGuideModel$FreeLimit;", "mHasShowStrongGuide", "", "closeDialog", "", "onContentSelectedChange", "isRecommendTab", "onDestroy", "onFontSizeChanged", "onHomeHeaderVisible", "visible", "onHomePageVisible", "isVisible", "onHomeStateChanged", "oldState", "", "newState", "byTouch", "onLazyUiReady", "onLeftClick", "context", "freeLimit", "onNightModeChanged", "isNightMode", "onRightClick", "openSchema", "schema", "", "showDialog", "listener", "Lcom/baidu/searchbox/download/center/clearcache/guide/HomeClearCacheGuide$CacheGuideListener;", "showDialogIfNeed", "headerVisible", "CacheGuideListener", "Companion", "lib-clearcache-guide_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeClearCacheGuide.kt */
public final class HomeClearCacheGuide implements IHomeEventListener, INewHomeEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ClearCacheGuide";
    private final WeakReference<Context> contextRef;
    private BdAlertDialog mBdAlertDialog;
    /* access modifiers changed from: private */
    public ClearCacheGuideModel.FreeLimit mFreeLimit;
    /* access modifiers changed from: private */
    public boolean mHasShowStrongGuide;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/guide/HomeClearCacheGuide$CacheGuideListener;", "", "onCloseDialog", "", "lib-clearcache-guide_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HomeClearCacheGuide.kt */
    public interface CacheGuideListener {
        void onCloseDialog();
    }

    public HomeClearCacheGuide(WeakReference<Context> contextRef2) {
        this.contextRef = contextRef2;
        ClearCacheGuideController $this$_init__u24lambda_u2d0 = new ClearCacheGuideController();
        $this$_init__u24lambda_u2d0.setClearCacheStateListener(new HomeClearCacheGuide$1$1(this));
        $this$_init__u24lambda_u2d0.init();
    }

    public View getView() {
        return IHomeEventListener.DefaultImpls.getView(this);
    }

    public boolean onFragmentKeyDown(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyDown(this, keyCode, event);
    }

    public boolean onFragmentKeyUp(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyUp(this, keyCode, event);
    }

    public void onHomeScrollChange(int curX, int curY, int oldX, int oldY, float scrollYPct, float scrollYPctFromLogoTop, float scrollYPctFromSearchBoxTop) {
        IHomeEventListener.DefaultImpls.onHomeScrollChange(this, curX, curY, oldX, oldY, scrollYPct, scrollYPctFromLogoTop, scrollYPctFromSearchBoxTop);
    }

    public void onHomeScrollStateChange(int oldState, int newState) {
        IHomeEventListener.DefaultImpls.onHomeScrollStateChange(this, oldState, newState);
    }

    /* access modifiers changed from: private */
    public final void showDialogIfNeed(ClearCacheGuideModel.FreeLimit freeLimit) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "Show Home Cache Guide Dialog If Needed.");
        }
        if (!this.mHasShowStrongGuide) {
            this.mFreeLimit = freeLimit;
            Object service = ServiceManager.getService(IHomeFun.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(IHomeFun.SERVICE_REFERENCE)");
            if (((IHomeFun) service).isHeaderVisible()) {
                showDialog(freeLimit);
            }
        }
    }

    private final void showDialogIfNeed(boolean headerVisible) {
        if (headerVisible && !this.mHasShowStrongGuide) {
            showDialog(this.mFreeLimit);
        }
    }

    private final void showDialog(ClearCacheGuideModel.FreeLimit freeLimit) {
        if (freeLimit == null) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "Try to Show Dialog, But FreeLimit Is Null");
            }
        } else if (!PermissionManager.hasShowDialog()) {
            PopupExclusionManagerMap.getInstance().display("scene_home", new HomeClearCacheGuide$showDialog$1(this, freeLimit, ExclusionType.HOME_CLEAR_CACHE));
        }
    }

    public void onHomePageVisible(boolean isVisible) {
    }

    public void onHomeHeaderVisible(boolean visible) {
        showDialogIfNeed(visible);
    }

    public void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
    }

    public void onContentSelectedChange(boolean isRecommendTab) {
        INewHomeApi iNewHomeApi;
        if (isRecommendTab && (iNewHomeApi = (INewHomeApi) ServiceManager.getService(INewHomeApi.Companion.getSERVICE_REFERENCE())) != null) {
            showDialogIfNeed(iNewHomeApi.isHeaderVisible());
        }
    }

    public void onLazyUiReady() {
    }

    public void onDestroy() {
    }

    public void onFontSizeChanged() {
    }

    public void onNightModeChanged(boolean isNightMode) {
    }

    public final void showDialog(ClearCacheGuideModel.FreeLimit freeLimit, CacheGuideListener listener) {
        Context context;
        Intrinsics.checkNotNullParameter(freeLimit, "freeLimit");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            BdAlertDialog.Builder onDismissListener = new BdAlertDialog.Builder(context).setContext(context).setTitle(freeLimit.getMTitle()).setMessage(freeLimit.getMContent()).setonShowListener(new HomeClearCacheGuide$$ExternalSyntheticLambda0(freeLimit)).setOnDismissListener(new HomeClearCacheGuide$$ExternalSyntheticLambda1(listener));
            String mLeftButtonTitle = freeLimit.getMLeftButtonTitle();
            Intrinsics.checkNotNull(mLeftButtonTitle);
            BdAlertDialog.Builder button = onDismissListener.setButton(new BdAlertDialog.ButtonItem(mLeftButtonTitle, new HomeClearCacheGuide$showDialog$4(this, context, freeLimit)));
            String mRightButtonTitle = freeLimit.getMRightButtonTitle();
            Intrinsics.checkNotNull(mRightButtonTitle);
            this.mBdAlertDialog = button.setButton(new BdAlertDialog.ButtonItem((CharSequence) mRightButtonTitle, R.color.GC7, (BdAlertDialog.OnItemClickListener) new HomeClearCacheGuide$showDialog$5(this, context, freeLimit))).create();
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                this.mBdAlertDialog = null;
                listener.onCloseDialog();
                return;
            }
            BdAlertDialog bdAlertDialog = this.mBdAlertDialog;
            Intrinsics.checkNotNull(bdAlertDialog);
            bdAlertDialog.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-1  reason: not valid java name */
    public static final void m17107showDialog$lambda1(ClearCacheGuideModel.FreeLimit $freeLimit, DialogInterface it) {
        Intrinsics.checkNotNullParameter($freeLimit, "$freeLimit");
        ClearCacheGuideUBC.INSTANCE.showStrongGuideUBC((String) null, "huancun_popup", "home", (String) null, $freeLimit.getMContent());
        ClearCacheGuideLocalData.INSTANCE.recordShowStrongGuide();
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-2  reason: not valid java name */
    public static final void m17108showDialog$lambda2(CacheGuideListener $listener, DialogInterface it) {
        Intrinsics.checkNotNullParameter($listener, "$listener");
        $listener.onCloseDialog();
    }

    /* access modifiers changed from: private */
    public final void onLeftClick(Context context, ClearCacheGuideModel.FreeLimit freeLimit) {
        ClearCacheGuideUBC.INSTANCE.clickStrongGuideUBC((String) null, "huancun_popup", "home", "cancel", freeLimit.getMLeftButtonTitle(), freeLimit.getMLeftButtonSchema(), (String) null, (String) null);
        openSchema(context, freeLimit.getMLeftButtonSchema());
        closeDialog();
    }

    /* access modifiers changed from: private */
    public final void onRightClick(Context context, ClearCacheGuideModel.FreeLimit freeLimit) {
        ClearCacheGuideUBC.INSTANCE.clickStrongGuideUBC((String) null, "huancun_popup", "home", "clean", (String) null, (String) null, freeLimit.getMRightButtonTitle(), freeLimit.getMRightButtonSchema());
        openSchema(context, freeLimit.getMRightButtonSchema());
        closeDialog();
    }

    private final void openSchema(Context context, String schema) {
        CharSequence charSequence = schema;
        if (!(charSequence == null || charSequence.length() == 0)) {
            if (UnitedSchemeUtility.isUnitedScheme(schema)) {
                Router.invokeScheme(context, Uri.parse(schema), "inside");
            } else {
                CommandUtils.invokeCommand(context, schema);
            }
        }
    }

    public final void closeDialog() {
        BdAlertDialog bdAlertDialog = this.mBdAlertDialog;
        if (bdAlertDialog != null) {
            bdAlertDialog.dismiss();
        }
        this.mBdAlertDialog = null;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/guide/HomeClearCacheGuide$Companion;", "", "()V", "TAG", "", "lib-clearcache-guide_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HomeClearCacheGuide.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
