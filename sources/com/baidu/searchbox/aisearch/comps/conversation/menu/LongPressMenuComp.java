package com.baidu.searchbox.aisearch.comps.conversation.menu;

import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.WrappedClipboardManager;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.browser.sailor.BdSailorWebChromeClientExt;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.ISailorWebViewExt;
import com.baidu.searchbox.aisearch.comps.common.IOnBackInterceptor;
import com.baidu.searchbox.aisearch.comps.common.SimpleComponent;
import com.baidu.searchbox.aisearch.event.OnLongPressMenuEvent;
import com.baidu.searchbox.aisearch.scheme.UnitedSchemeAISearchDispatcherKt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.ng.browser.R;
import com.baidu.searchbox.ng.browser.explore.BdExplorePopView;
import com.baidu.webkit.sdk.WebView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001:B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010'\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\u001c\u0010)\u001a\u00020\u00192\b\b\u0002\u0010*\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020\u0019H\u0007J\u0012\u0010,\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J(\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020/2\u0006\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020/H\u0016J\u0012\u00107\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010 H\u0016J\b\u00109\u001a\u00020\"H\u0002R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/menu/LongPressMenuComp;", "Lcom/baidu/searchbox/aisearch/comps/common/SimpleComponent;", "Lcom/baidu/searchbox/ng/browser/NgWebView$OnCommonEventHandler;", "Lcom/baidu/searchbox/ng/browser/explore/BdExplorePopView$BdExplorePopViewListener;", "Lcom/baidu/searchbox/aisearch/comps/common/IOnBackInterceptor;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "webView", "Lcom/baidu/searchbox/ng/browser/NgWebView;", "(Landroidx/lifecycle/LifecycleOwner;Lcom/baidu/searchbox/ng/browser/NgWebView;)V", "clipboard", "Lcom/baidu/android/util/android/WrappedClipboardManager;", "getClipboard", "()Lcom/baidu/android/util/android/WrappedClipboardManager;", "clipboard$delegate", "Lkotlin/Lazy;", "gestureDetector", "Landroid/view/GestureDetector;", "pageToken", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getPageToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setPageToken", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "switch", "", "getSwitch", "()Z", "setSwitch", "(Z)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "doSelectionCancel", "", "doSelectionCopy", "aSelection", "", "doSelectionSearch", "doSelectionWrongWordReport", "handleBackPressed", "hideMenu", "onlyHideMenu", "forceSyncState", "onInterceptTouchEvent", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onScrollChanged", "l", "t", "oldl", "oldt", "onTouchEvent", "motionEvent", "setupWebView", "LongPressWebChromeClientExt", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressMenuComp.kt */
public final class LongPressMenuComp extends SimpleComponent implements NgWebView.OnCommonEventHandler, BdExplorePopView.BdExplorePopViewListener, IOnBackInterceptor {
    private final Lazy clipboard$delegate = LazyKt.lazy(new LongPressMenuComp$clipboard$2(this));
    private final GestureDetector gestureDetector = new GestureDetector(getContext(), new LongPressMenuComp$gestureDetector$1(this));
    private UniqueId pageToken;

    /* renamed from: switch  reason: not valid java name */
    private boolean f1148switch;
    /* access modifiers changed from: private */
    public final NgWebView webView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPressMenuComp(LifecycleOwner owner, NgWebView webView2) {
        super(owner, webView2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(webView2, "webView");
        this.webView = webView2;
        setupWebView();
    }

    public final UniqueId getPageToken() {
        return this.pageToken;
    }

    public final void setPageToken(UniqueId uniqueId) {
        this.pageToken = uniqueId;
    }

    public final boolean getSwitch() {
        return this.f1148switch;
    }

    public final void setSwitch(boolean z) {
        this.f1148switch = z;
    }

    private final WrappedClipboardManager getClipboard() {
        Object value = this.clipboard$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-clipboard>(...)");
        return (WrappedClipboardManager) value;
    }

    private final void setupWebView() {
        this.webView.setOnCommonEventHandler(this);
        this.webView.setBdExploreFloatMenuListener(this);
        this.webView.setWebChromeClientExt(new LongPressWebChromeClientExt());
    }

    public static /* synthetic */ boolean hideMenu$default(LongPressMenuComp longPressMenuComp, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return longPressMenuComp.hideMenu(z, z2);
    }

    public final boolean hideMenu(boolean onlyHideMenu, boolean forceSyncState) {
        UniqueId $this$hideMenu_u24lambda_u2d0;
        if ((forceSyncState || this.webView.checkPopMenuStatus()) && ($this$hideMenu_u24lambda_u2d0 = this.pageToken) != null) {
            BdEventBus.Companion.getDefault().post(new OnLongPressMenuEvent($this$hideMenu_u24lambda_u2d0, false));
        }
        if (!this.webView.checkPopMenuStatus()) {
            return false;
        }
        NgWebView ngWebView = this.webView;
        if (onlyHideMenu) {
            ngWebView.hidePopWindow();
        } else {
            ngWebView.doSelectionCancel();
        }
        if (!LongPressMenuCompKt.DEBUG) {
            return true;
        }
        Log.d("LongPressMenuComp", "hide long press menu");
        return true;
    }

    public boolean handleBackPressed() {
        return hideMenu$default(this, false, false, 3, (Object) null);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return this.gestureDetector.onTouchEvent(motionEvent);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public void onScrollChanged(int l, int t, int oldl, int oldt) {
    }

    public void doSelectionCopy(String aSelection) {
        CharSequence charSequence = aSelection;
        if (!(charSequence == null || charSequence.length() == 0)) {
            getClipboard().setText(aSelection);
            if (!DeviceUtils.OSInfo.hasTiramisu() || !DeviceUtils.isSupportPreviewWhenClipCopy()) {
                UniversalToast.makeText(getContext(), R.string.ng_text_selection_ok_tip).show();
            }
            hideMenu$default(this, false, true, 1, (Object) null);
            LongPressStat.INSTANCE.onClickStat(this.pageToken, "copy");
        }
    }

    public void doSelectionSearch(String aSelection) {
    }

    public void doSelectionCancel() {
    }

    public void doSelectionWrongWordReport(String aSelection) {
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J<\u0010\u0011\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/menu/LongPressMenuComp$LongPressWebChromeClientExt;", "Lcom/baidu/browser/sailor/BdSailorWebChromeClientExt;", "(Lcom/baidu/searchbox/aisearch/comps/conversation/menu/LongPressMenuComp;)V", "handleLongPressMenu", "", "hitTestResult", "Lcom/baidu/webkit/sdk/WebView$HitTestResult;", "webView", "Lcom/baidu/searchbox/ng/browser/NgWebView;", "hideSelectionActionDialogExt", "view", "Lcom/baidu/browser/sailor/BdSailorWebView;", "performLongClickExt", "result", "x", "", "y", "showSelectionActionDialogExt", "top", "bottom", "left", "right", "text", "", "showTextFloatMenu", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LongPressMenuComp.kt */
    private final class LongPressWebChromeClientExt extends BdSailorWebChromeClientExt {
        public LongPressWebChromeClientExt() {
        }

        public void showSelectionActionDialogExt(BdSailorWebView view2, int top, int bottom, int left, int right, String text) {
            super.showSelectionActionDialogExt(view2, top, bottom, left, right, text);
            if (LongPressMenuCompKt.DEBUG) {
                Log.d("LongPressMenuComp", "showSelectionActionDialogExt: top: " + top + ", bottom: " + bottom + ", left: " + left + ", right: " + right + ", text: " + text);
            }
            LongPressMenuComp.this.webView.updateAndShowPopupWindow(left, right, top, bottom, text, UnitedSchemeAISearchDispatcherKt.MODULE_NAME, false);
            UniqueId $this$showSelectionActionDialogExt_u24lambda_u2d0 = LongPressMenuComp.this.getPageToken();
            if ($this$showSelectionActionDialogExt_u24lambda_u2d0 != null) {
                BdEventBus.Companion.getDefault().post(new OnLongPressMenuEvent($this$showSelectionActionDialogExt_u24lambda_u2d0, true));
            }
        }

        public void hideSelectionActionDialogExt(BdSailorWebView view2) {
            super.hideSelectionActionDialogExt(view2);
            LongPressMenuComp.hideMenu$default(LongPressMenuComp.this, true, false, 2, (Object) null);
        }

        public void performLongClickExt(BdSailorWebView view2, WebView.HitTestResult result, int x, int y) {
            super.performLongClickExt(view2, result, x, y);
            handleLongPressMenu(result, LongPressMenuComp.this.webView);
        }

        private final void handleLongPressMenu(WebView.HitTestResult hitTestResult, NgWebView webView) {
            if (hitTestResult != null && LongPressMenuComp.this.getSwitch()) {
                if (hitTestResult.getType() == 10) {
                    if (LongPressMenuCompKt.DEBUG) {
                        Log.d("LongPressMenuComp", "hitTestResult type: NORMAL_TEXT_TYPE");
                    }
                    showTextFloatMenu(webView);
                } else if (LongPressMenuCompKt.DEBUG) {
                    Log.d("LongPressMenuComp", "hitTestResult type: other type");
                }
            }
        }

        private final void showTextFloatMenu(NgWebView webView) {
            LongPressMenuComp longPressMenuComp = LongPressMenuComp.this;
            NgWebView $this$showTextFloatMenu_u24lambda_u2d1 = webView;
            $this$showTextFloatMenu_u24lambda_u2d1.setOrUpdateFloatMenuList(5);
            ISailorWebViewExt webViewExt = $this$showTextFloatMenu_u24lambda_u2d1.getWebViewExt();
            if (webViewExt != null) {
                webViewExt.emulateShiftHeldOnNormalTextExt();
            }
            LongPressStat.INSTANCE.onShowStat(longPressMenuComp.getPageToken());
        }
    }
}
