package com.baidu.searchbox.dynamicpublisher.aitxtgenimg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.dynamicpublisher.DynamicPublishRuntimeKt;
import com.baidu.searchbox.dynamicpublisher.aitxtgenimg.AiTxtGenImgAction;
import com.baidu.searchbox.dynamicpublisher.aitxtgenimg.creating.AiTxtGenImgCreatingDialogFragment;
import com.baidu.searchbox.dynamicpublisher.aitxtgenimg.creating.AiTxtGenImgCreatingEvent;
import com.baidu.searchbox.dynamicpublisher.aitxtgenimg.creating.AiTxtGenImgWebImageEvent;
import com.baidu.searchbox.dynamicpublisher.aitxtgenimg.creating.data.AiTxtGenImgSearchData;
import com.baidu.searchbox.dynamicpublisher.aitxtgenimg.creating.network.AiTxtGenImgCreatingHttpManager;
import com.baidu.searchbox.dynamicpublisher.aitxtgenimg.creating.web.AiTxtGenImgBdWebView;
import com.baidu.searchbox.dynamicpublisher.panel.util.StringUtil;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.mvp.txtgenimg.AiPublisherTxtGenImgUbcModel;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.utils.LogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/aitxtgenimg/AiTxtGenImgPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "aiTxtGenImgCreatingListener", "Lcom/baidu/searchbox/dynamicpublisher/aitxtgenimg/creating/AiTxtGenImgCreatingDialogFragment$DialogActionListener;", "imageCreateWebView", "Lcom/baidu/searchbox/dynamicpublisher/aitxtgenimg/creating/web/AiTxtGenImgBdWebView;", "lastTextContent", "", "mainHandler", "Landroid/os/Handler;", "showAiTxtGenImgDialogStartTime", "", "showAiTxtGenImgDialogThrottleTime", "textContent", "triggerGenImage", "", "triggerRunnable", "Ljava/lang/Runnable;", "triggerSwitch", "triggerTextLength", "", "webViewRenderImgListener", "Lcom/baidu/searchbox/dynamicpublisher/aitxtgenimg/creating/web/AiTxtGenImgBdWebView$RenderImgResultListener;", "genImage", "", "content", "hideInputMethod", "onAttachToManager", "onDestroy", "onRelease", "showAiTxtGenImgDetailPage", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiTxtGenImgPlugin.kt */
public final class AiTxtGenImgPlugin extends LiveDataPlugin {
    private AiTxtGenImgCreatingDialogFragment.DialogActionListener aiTxtGenImgCreatingListener;
    private AiTxtGenImgBdWebView imageCreateWebView;
    private String lastTextContent;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public long showAiTxtGenImgDialogStartTime;
    private long showAiTxtGenImgDialogThrottleTime;
    private String textContent;
    private boolean triggerGenImage;
    private final Runnable triggerRunnable = new AiTxtGenImgPlugin$$ExternalSyntheticLambda7(this);
    private boolean triggerSwitch;
    private int triggerTextLength = 2;
    private AiTxtGenImgBdWebView.RenderImgResultListener webViewRenderImgListener;

    /* access modifiers changed from: private */
    /* renamed from: triggerRunnable$lambda-0  reason: not valid java name */
    public static final void m17891triggerRunnable$lambda0(AiTxtGenImgPlugin this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.triggerSwitch) {
            this$0.genImage(this$0.textContent);
        }
    }

    public void onAttachToManager() {
        AiTxtGenImgState $this$onAttachToManager_u24lambda_u2d6;
        super.onAttachToManager();
        if (AiTxtGenImgCreatingHttpManager.INSTANCE.getUseWebViewRenderSwitch()) {
            this.imageCreateWebView = new AiTxtGenImgBdWebView(getContext());
            AiTxtGenImgBdWebView.RenderImgResultListener aiTxtGenImgPlugin$onAttachToManager$1 = new AiTxtGenImgPlugin$onAttachToManager$1(this);
            this.webViewRenderImgListener = aiTxtGenImgPlugin$onAttachToManager$1;
            AiTxtGenImgBdWebView aiTxtGenImgBdWebView = this.imageCreateWebView;
            if (aiTxtGenImgBdWebView != null) {
                aiTxtGenImgBdWebView.setRenderImgResultListener(aiTxtGenImgPlugin$onAttachToManager$1);
            }
        }
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d6 = (AiTxtGenImgState) store.subscribe((Class<T>) AiTxtGenImgState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d6.getTextChanged().observe(this, new AiTxtGenImgPlugin$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d6.isTxtGenImgCanShow().observe(this, new AiTxtGenImgPlugin$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d6.getTxtGenImgContentLength().observe(this, new AiTxtGenImgPlugin$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d6.getStopSearchImg().observe(this, new AiTxtGenImgPlugin$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d6.getShowAiTxtGenImgDetailPage().observe(this, new AiTxtGenImgPlugin$$ExternalSyntheticLambda4(this));
        }
        BdEventBus.Companion.getDefault().register(this, AiTxtGenImgCreatingEvent.class, 1, new AiTxtGenImgPlugin$$ExternalSyntheticLambda5(this));
        BdEventBus.Companion.getDefault().register(this, AiTxtGenImgWebImageEvent.class, 1, new AiTxtGenImgPlugin$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-1  reason: not valid java name */
    public static final void m17886onAttachToManager$lambda6$lambda1(AiTxtGenImgPlugin this$0, String it) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.triggerSwitch) {
            this$0.mainHandler.removeCallbacks(this$0.triggerRunnable);
            String content = it;
            if (!TextUtils.isEmpty(content)) {
                str = StringUtil.INSTANCE.filterStr(StringUtil.INSTANCE.filterGroup(StringUtil.INSTANCE.filterAt(StringUtil.INSTANCE.filterEmoji(content))));
            } else {
                str = "";
            }
            String content2 = str;
            Intrinsics.checkNotNullExpressionValue(content2, "content");
            String obj = StringsKt.trim((CharSequence) content2).toString();
            this$0.textContent = obj;
            if ((obj != null ? obj.length() : 0) > this$0.triggerTextLength) {
                if (!this$0.triggerGenImage) {
                    this$0.triggerGenImage = true;
                    this$0.genImage(this$0.textContent);
                }
                this$0.mainHandler.postDelayed(this$0.triggerRunnable, 3000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-2  reason: not valid java name */
    public static final void m17887onAttachToManager$lambda6$lambda2(AiTxtGenImgPlugin this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.triggerSwitch = Intrinsics.areEqual((Object) it, (Object) true);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-3  reason: not valid java name */
    public static final void m17888onAttachToManager$lambda6$lambda3(AiTxtGenImgPlugin this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.triggerTextLength = it.intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-4  reason: not valid java name */
    public static final void m17889onAttachToManager$lambda6$lambda4(AiTxtGenImgPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainHandler.removeCallbacks(this$0.triggerRunnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-5  reason: not valid java name */
    public static final void m17890onAttachToManager$lambda6$lambda5(AiTxtGenImgPlugin this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.showAiTxtGenImgDetailPage();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-10  reason: not valid java name */
    public static final void m17884onAttachToManager$lambda10(AiTxtGenImgPlugin this$0, AiTxtGenImgCreatingEvent it) {
        List images;
        ImageStruct img;
        Store<AbsState> store;
        Store<AbsState> store2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!AiTxtGenImgCreatingHttpManager.INSTANCE.isAiPublisherCard()) {
            switch (it.getType()) {
                case 1:
                    AiTxtGenImgSearchData searchData = it.getSearchData();
                    if (searchData != null && (images = searchData.getImages()) != null && (!images.isEmpty()) && (img = images.get(0).convertToImageStruct()) != null && (store = this$0.getStore()) != null) {
                        store.dispatch(new AiTxtGenImgAction.TxtGenPlaceViewRefreshAction(img));
                        return;
                    }
                    return;
                case 2:
                    ImageStruct img2 = it.getImage();
                    if (img2 != null && (store2 = this$0.getStore()) != null) {
                        store2.dispatch(new AiTxtGenImgAction.TxtGenPlaceViewRefreshAction(img2));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11  reason: not valid java name */
    public static final void m17885onAttachToManager$lambda11(AiTxtGenImgPlugin this$0, AiTxtGenImgWebImageEvent it) {
        AiTxtGenImgBdWebView aiTxtGenImgBdWebView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!AiTxtGenImgCreatingHttpManager.INSTANCE.isAiPublisherCard() && Intrinsics.areEqual((Object) it.getType(), (Object) "request") && (aiTxtGenImgBdWebView = this$0.imageCreateWebView) != null) {
            aiTxtGenImgBdWebView.requestGenImage(it.getRequestData());
        }
    }

    private final void genImage(String content) {
        if (!DynamicPublishRuntimeKt.getHasImg2TxtUsed()) {
            LogUtil.d("gen image " + content);
            AiTxtGenImgCreatingHttpManager.INSTANCE.startSearch(content);
        }
    }

    private final void showAiTxtGenImgDetailPage() {
        boolean showRecreateBubble;
        String str;
        if (System.currentTimeMillis() - this.showAiTxtGenImgDialogThrottleTime < 500) {
            LogUtil.d("click showAiTxtGenImgDetailPage time invalid");
            return;
        }
        this.showAiTxtGenImgDialogThrottleTime = System.currentTimeMillis();
        hideInputMethod();
        AiTxtGenImgCreatingDialogFragment aiTxtGenImgCreatingDialog = new AiTxtGenImgCreatingDialogFragment();
        if (this.aiTxtGenImgCreatingListener == null) {
            this.aiTxtGenImgCreatingListener = new AiTxtGenImgPlugin$showAiTxtGenImgDetailPage$1(this);
        }
        Context context = getContext();
        FragmentActivity ac = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (ac != null) {
            String str2 = this.lastTextContent;
            if (str2 != null && !Intrinsics.areEqual((Object) str2, (Object) this.textContent)) {
                String str3 = this.textContent;
                if (str3 == null || (str = StringsKt.trim((CharSequence) str3).toString()) == null) {
                    str = "";
                }
                if (str.length() > 2 && this.showAiTxtGenImgDialogStartTime > 0) {
                    showRecreateBubble = true;
                    AiTxtGenImgCreatingDialogFragment.show$default(aiTxtGenImgCreatingDialog, ac, this.textContent, this.aiTxtGenImgCreatingListener, showRecreateBubble, 0, (AiPublisherTxtGenImgUbcModel) null, 48, (Object) null);
                    this.showAiTxtGenImgDialogStartTime = System.currentTimeMillis();
                    this.lastTextContent = this.textContent;
                }
            }
            showRecreateBubble = false;
            AiTxtGenImgCreatingDialogFragment.show$default(aiTxtGenImgCreatingDialog, ac, this.textContent, this.aiTxtGenImgCreatingListener, showRecreateBubble, 0, (AiPublisherTxtGenImgUbcModel) null, 48, (Object) null);
            this.showAiTxtGenImgDialogStartTime = System.currentTimeMillis();
            this.lastTextContent = this.textContent;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.view.inputmethod.InputMethodManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void hideInputMethod() {
        /*
            r7 = this;
            android.content.Context r0 = r7.getContext()
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            r2 = 0
            if (r1 == 0) goto L_0x000c
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 == 0) goto L_0x003c
            r1 = 0
            android.view.Window r3 = r0.getWindow()
            if (r3 == 0) goto L_0x003b
            android.view.View r3 = r3.getDecorView()
            if (r3 == 0) goto L_0x003b
            r4 = 0
            java.lang.String r5 = "input_method"
            java.lang.Object r5 = r0.getSystemService(r5)
            boolean r6 = r5 instanceof android.view.inputmethod.InputMethodManager
            if (r6 == 0) goto L_0x002a
            r2 = r5
            android.view.inputmethod.InputMethodManager r2 = (android.view.inputmethod.InputMethodManager) r2
        L_0x002a:
            if (r2 == 0) goto L_0x003a
            boolean r5 = r2.isActive()
            if (r5 == 0) goto L_0x003a
            android.os.IBinder r5 = r3.getWindowToken()
            r6 = 0
            r2.hideSoftInputFromWindow(r5, r6)
        L_0x003a:
        L_0x003b:
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.aitxtgenimg.AiTxtGenImgPlugin.hideInputMethod():void");
    }

    public void onRelease() {
        super.onRelease();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.aiTxtGenImgCreatingListener = null;
        AiTxtGenImgCreatingHttpManager.INSTANCE.stopSearch();
        this.mainHandler.removeCallbacksAndMessages((Object) null);
        this.showAiTxtGenImgDialogThrottleTime = 0;
        this.showAiTxtGenImgDialogStartTime = 0;
        this.lastTextContent = null;
        DynamicPublishRuntimeKt.reset();
        AiTxtGenImgBdWebView aiTxtGenImgBdWebView = this.imageCreateWebView;
        if (aiTxtGenImgBdWebView != null) {
            aiTxtGenImgBdWebView.release();
        }
        this.imageCreateWebView = null;
        this.webViewRenderImgListener = null;
    }
}
