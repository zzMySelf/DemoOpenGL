package com.baidu.browser.components.toolbar.impl.newItem;

import android.content.Context;
import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.Browser;
import com.baidu.browser.R;
import com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext;
import com.baidu.searchbox.bookmark.BookmarkUtil;
import com.baidu.searchbox.favor.callback.FavorDataCallback;
import com.baidu.searchbox.sync.FavorUIOperator;
import com.baidu.searchbox.userassetsaggr.container.FavorHisAbTestManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/baidu/browser/components/toolbar/impl/newItem/StarFavorDataCallback;", "Lcom/baidu/searchbox/favor/callback/FavorDataCallback;", "", "item", "Lcom/baidu/browser/components/toolbar/impl/newItem/StartBtnClickManager;", "(Lcom/baidu/browser/components/toolbar/impl/newItem/StartBtnClickManager;)V", "itemReference", "Ljava/lang/ref/WeakReference;", "showAnim", "getShowAnim", "()Z", "setShowAnim", "(Z)V", "onResult", "", "result", "(Ljava/lang/Boolean;)V", "release", "showNewFavorToast", "isAdd", "context", "Landroid/content/Context;", "showToast", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StartBtnClickManager.kt */
public final class StarFavorDataCallback extends FavorDataCallback<Boolean> {
    private WeakReference<StartBtnClickManager> itemReference;
    private boolean showAnim;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StartBtnClickManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FavorUIOperator.OperatorStatus.values().length];
            iArr[FavorUIOperator.OperatorStatus.ADD_SUCCESS.ordinal()] = 1;
            iArr[FavorUIOperator.OperatorStatus.REMOVE_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StarFavorDataCallback(StartBtnClickManager item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.itemReference = new WeakReference<>(item);
    }

    public final boolean getShowAnim() {
        return this.showAnim;
    }

    public final void setShowAnim(boolean z) {
        this.showAnim = z;
    }

    public void onResult(Boolean result) {
        UiThreadUtils.runOnUiThread(new StarFavorDataCallback$$ExternalSyntheticLambda1(this, result != null ? result.booleanValue() : false));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResult$lambda-0  reason: not valid java name */
    public static final void m12754onResult$lambda0(StarFavorDataCallback this$0, boolean $favored) {
        StartBtnClickManager startBtnClickManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<StartBtnClickManager> weakReference = this$0.itemReference;
        if (weakReference != null && (startBtnClickManager = (StartBtnClickManager) weakReference.get()) != null) {
            startBtnClickManager.updateToolbarStar(this$0.showAnim, $favored);
        }
    }

    public final void showToast(boolean isAdd) {
        StartBtnClickManager startBtnClickManager;
        ISearchBoxToolbarContext toolbarContext;
        Context context;
        WeakReference<StartBtnClickManager> weakReference = this.itemReference;
        if (weakReference != null && (startBtnClickManager = (StartBtnClickManager) weakReference.get()) != null && (toolbarContext = startBtnClickManager.getToolbarContext()) != null && (context = toolbarContext.getContext()) != null) {
            if (FavorHisAbTestManager.INSTANCE.isHitWebVideoExperimental()) {
                showNewFavorToast(isAdd, context);
            } else if (isAdd) {
                UniversalToast.makeText(context, context.getText(R.string.toolbar_collect)).setRightText(context.getText(R.string.toolbar_collect_check)).setTemplate(ToastTemplate.T2).setToastCallback(new StarFavorDataCallback$$ExternalSyntheticLambda0(context)).show();
            } else {
                UniversalToast.makeText(context, context.getText(R.string.toolbar_collect_cancel)).setLocation(ToastLocation.BOTTOM).show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showToast$lambda-1  reason: not valid java name */
    public static final void m12755showToast$lambda1(Context $context) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Browser.onAddAsBookmark($context, (String) null, (String) null);
    }

    private final void showNewFavorToast(boolean isAdd, Context context) {
        FavorUIOperator.OperatorStatus status;
        String tabId;
        if (isAdd) {
            status = FavorUIOperator.OperatorStatus.ADD_SUCCESS;
        } else {
            status = FavorUIOperator.OperatorStatus.REMOVE_SUCCESS;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
                if (Intrinsics.areEqual((Object) FavorHisAbTestManager.INSTANCE.getWebVideoType(), (Object) "2")) {
                    tabId = "browser";
                } else {
                    String str = null;
                    tabId = null;
                }
                BookmarkUtil.showAddBookMarkSuccessToast(context, tabId, (UniversalToast.ToastCallback) null, "bar");
                return;
            case 2:
                BookmarkUtil.showAddBookMarkFailedToast(context, status);
                return;
            default:
                return;
        }
    }

    public final void release() {
        this.itemReference = null;
    }
}
