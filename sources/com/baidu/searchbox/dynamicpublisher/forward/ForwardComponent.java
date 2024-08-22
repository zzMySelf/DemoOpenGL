package com.baidu.searchbox.dynamicpublisher.forward;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.dynamicpublisher.forward.ForwardAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.publishercomponent.R;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.model.ReferenceDt;
import com.baidu.searchbox.ugc.utils.UgcRichTextProcessor;
import com.baidu.searchbox.ugc.view.ForwardPreview;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010+\u001a\u00020\"H\u0016J\b\u0010,\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u001bH\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0002J\b\u00100\u001a\u00020\"H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001d\u0010\u000e¨\u00061"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/forward/ForwardComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "fetchWebPicCancelable", "Lcom/baidu/searchbox/http/Cancelable;", "forwardCommentCheckBox", "Landroid/widget/CheckBox;", "getForwardCommentCheckBox", "()Landroid/widget/CheckBox;", "forwardCommentCheckBox$delegate", "Lkotlin/Lazy;", "forwardCommentContainer", "Landroid/widget/LinearLayout;", "getForwardCommentContainer", "()Landroid/widget/LinearLayout;", "forwardCommentContainer$delegate", "forwardCommentText", "Landroid/widget/TextView;", "getForwardCommentText", "()Landroid/widget/TextView;", "forwardCommentText$delegate", "forwardPreview", "Lcom/baidu/searchbox/ugc/view/ForwardPreview;", "getForwardPreview", "()Lcom/baidu/searchbox/ugc/view/ForwardPreview;", "forwardPreview$delegate", "isFetchingWebPic", "", "rootView", "getRootView", "rootView$delegate", "createView", "Landroid/view/View;", "getHtmlFromUrl", "", "htmlUrl", "", "referenceDt", "Lcom/baidu/searchbox/ugc/model/ReferenceDt;", "initForwardCommentView", "info", "Lcom/baidu/searchbox/dynamicpublisher/forward/ForwardInfo;", "initView", "onAttachToManager", "onDestroy", "setForwardCommentTextColor", "isChecked", "updateForwardPreView", "updateUI", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ForwardComponent.kt */
public final class ForwardComponent extends LiveDataComponent {
    private Cancelable fetchWebPicCancelable;
    private final Lazy forwardCommentCheckBox$delegate = LazyKt.lazy(new ForwardComponent$forwardCommentCheckBox$2(this));
    private final Lazy forwardCommentContainer$delegate = LazyKt.lazy(new ForwardComponent$forwardCommentContainer$2(this));
    private final Lazy forwardCommentText$delegate = LazyKt.lazy(new ForwardComponent$forwardCommentText$2(this));
    private final Lazy forwardPreview$delegate = LazyKt.lazy(new ForwardComponent$forwardPreview$2(this));
    /* access modifiers changed from: private */
    public boolean isFetchingWebPic;
    private final Lazy rootView$delegate = LazyKt.lazy(new ForwardComponent$rootView$2(this));

    /* access modifiers changed from: private */
    public final LinearLayout getRootView() {
        return (LinearLayout) this.rootView$delegate.getValue();
    }

    private final ForwardPreview getForwardPreview() {
        Object value = this.forwardPreview$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-forwardPreview>(...)");
        return (ForwardPreview) value;
    }

    private final LinearLayout getForwardCommentContainer() {
        Object value = this.forwardCommentContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-forwardCommentContainer>(...)");
        return (LinearLayout) value;
    }

    private final CheckBox getForwardCommentCheckBox() {
        Object value = this.forwardCommentCheckBox$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-forwardCommentCheckBox>(...)");
        return (CheckBox) value;
    }

    private final TextView getForwardCommentText() {
        Object value = this.forwardCommentText$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-forwardCommentText>(...)");
        return (TextView) value;
    }

    public View createView() {
        return getRootView();
    }

    public void onDestroy() {
        super.onDestroy();
        Cancelable cancelable = this.fetchWebPicCancelable;
        if (cancelable != null) {
            cancelable.cancel();
        }
    }

    public void onAttachToManager() {
        ForwardState $this$onAttachToManager_u24lambda_u2d2;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d2 = (ForwardState) store.subscribe((Class<T>) ForwardState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d2.getForwardInfo().observe(this, new ForwardComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d2.getCollection().observe(this, new ForwardComponent$$ExternalSyntheticLambda1(this, $this$onAttachToManager_u24lambda_u2d2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-0  reason: not valid java name */
    public static final void m18005onAttachToManager$lambda2$lambda0(ForwardComponent this$0, ForwardInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initView(it);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-1  reason: not valid java name */
    public static final void m18006onAttachToManager$lambda2$lambda1(ForwardComponent this$0, ForwardState $this_run, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        Store<AbsState> store = this$0.getStore();
        if (store != null) {
            store.dispatch(new ForwardAction.SendData($this_run.getForwardInfo().getValue()));
        }
    }

    private final void initView(ForwardInfo info) {
        if (info == null) {
            getRootView().setVisibility(8);
            return;
        }
        ReferenceDt $this$initView_u24lambda_u2d3 = info.getReferenceDt();
        if ($this$initView_u24lambda_u2d3 != null) {
            getForwardPreview().setText($this$initView_u24lambda_u2d3.title);
            UgcRichTextProcessor.handleEmotionDispaly(getForwardPreview().getForwardPreViewText());
            if (Intrinsics.areEqual((Object) $this$initView_u24lambda_u2d3.useWebPic, (Object) "1")) {
                getForwardPreview().showLoading();
                String str = $this$initView_u24lambda_u2d3.url;
                Intrinsics.checkNotNullExpressionValue(str, "url");
                getHtmlFromUrl(str, $this$initView_u24lambda_u2d3);
            } else {
                getForwardPreview().loadImage($this$initView_u24lambda_u2d3.refType, $this$initView_u24lambda_u2d3.thumbpic, $this$initView_u24lambda_u2d3.thumbpicBinary, $this$initView_u24lambda_u2d3.avatar);
            }
            getForwardPreview().setAttachmentInfo($this$initView_u24lambda_u2d3.attachmentInfo);
        }
        initForwardCommentView(info);
        updateUI();
    }

    private final void initForwardCommentView(ForwardInfo info) {
        if (Intrinsics.areEqual((Object) info.getForwardIsComment(), (Object) "0")) {
            getForwardCommentContainer().setVisibility(8);
            return;
        }
        getForwardCommentContainer().setVisibility(0);
        getForwardCommentCheckBox().setButtonDrawable(ContextCompat.getDrawable(getContext(), R.drawable.dynamic_publish_forward_comment_checkbox_btn));
        getForwardCommentCheckBox().setChecked(Intrinsics.areEqual((Object) info.getForwardIsComment(), (Object) "1"));
        setForwardCommentTextColor(getForwardCommentCheckBox().isChecked());
        getForwardCommentCheckBox().setOnCheckedChangeListener(new ForwardComponent$$ExternalSyntheticLambda3(info, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initForwardCommentView$lambda-4  reason: not valid java name */
    public static final void m18004initForwardCommentView$lambda4(ForwardInfo $info, ForwardComponent this$0, CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter($info, "$info");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        $info.setForwardIsComment(isChecked ? "1" : "2");
        this$0.setForwardCommentTextColor(isChecked);
    }

    private final void setForwardCommentTextColor(boolean isChecked) {
        int color;
        if (isChecked) {
            color = R.color.dynamic_publisher_forward_preview_text_color;
        } else {
            color = R.color.dynamic_publisher_forward_comment_close_text_color;
        }
        getForwardCommentText().setTextColor(ContextCompat.getColor(getContext(), color));
    }

    private final void updateUI() {
        getForwardPreview().updateUI();
    }

    private final void getHtmlFromUrl(String htmlUrl, ReferenceDt referenceDt) {
        CharSequence charSequence = htmlUrl;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Object newCookieManagerInstance = UgcRuntime.getUgcInterface().newCookieManagerInstance(false, false);
            if (newCookieManagerInstance != null) {
                PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(htmlUrl);
                this.isFetchingWebPic = true;
                this.fetchWebPicCancelable = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) postFormRequestBuilder.cookieManager((CookieManager) newCookieManagerInstance)).requestFrom(20)).requestSubFrom(4)).enableStat(true)).build().executeAsync(new ForwardComponent$getHtmlFromUrl$1(this, htmlUrl, referenceDt));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.http.cookie.CookieManager");
        }
    }

    /* access modifiers changed from: private */
    public final void updateForwardPreView(ReferenceDt referenceDt) {
        UiThreadUtils.runOnUiThread(new ForwardComponent$$ExternalSyntheticLambda2(referenceDt, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateForwardPreView$lambda-7  reason: not valid java name */
    public static final void m18007updateForwardPreView$lambda7(ReferenceDt $referenceDt, ForwardComponent this$0) {
        Intrinsics.checkNotNullParameter($referenceDt, "$referenceDt");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReferenceDt $this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6 = $referenceDt;
        CharSequence charSequence = $this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6.thumbpic;
        if (!(charSequence == null || charSequence.length() == 0)) {
            ForwardPreview $this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d5 = this$0.getForwardPreview();
            $this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d5.dismissLoading();
            $this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d5.loadImage($this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6.refType, $this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6.thumbpic, $this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6.thumbpicBinary, $this$updateForwardPreView_u24lambda_u2d7_u24lambda_u2d6.avatar);
        }
    }
}
