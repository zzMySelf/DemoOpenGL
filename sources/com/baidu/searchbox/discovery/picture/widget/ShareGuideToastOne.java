package com.baidu.searchbox.discovery.picture.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.common.atlas.R;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.discovery.picture.controller.IShareGuideToast;
import com.baidu.searchbox.discovery.picture.controller.IShareGuideToastListener;
import com.baidu.searchbox.discovery.picture.controller.ShareGuideData;
import com.baidu.searchbox.discovery.picture.listener.LightPictureConfigListener;
import com.baidu.searchbox.feed.styles.Font;
import com.baidu.searchbox.feed.styles.FontUtil;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010.\u001a\u00020(H\u0016J\u0012\u0010/\u001a\u00020(2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u00100\u001a\u00020(H\u0002J\b\u00101\u001a\u00020(H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b#\u0010\u0017R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/discovery/picture/widget/ShareGuideToastOne;", "Lcom/baidu/searchbox/discovery/picture/controller/IShareGuideToast;", "context", "Landroid/content/Context;", "parentView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "containerView$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "downLoadSuccessIcon", "Landroid/widget/ImageView;", "getDownLoadSuccessIcon", "()Landroid/widget/ImageView;", "downLoadSuccessIcon$delegate", "downLoadSuccessText", "Landroid/widget/TextView;", "getDownLoadSuccessText", "()Landroid/widget/TextView;", "downLoadSuccessText$delegate", "hideRunnable", "Ljava/lang/Runnable;", "shareGuideData", "Lcom/baidu/searchbox/discovery/picture/controller/ShareGuideData;", "shareGuideIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getShareGuideIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "shareGuideIcon$delegate", "shareGuideText", "getShareGuideText", "shareGuideText$delegate", "shareGuideToastListener", "Lcom/baidu/searchbox/discovery/picture/controller/IShareGuideToastListener;", "hide", "", "onConfigurationChanged", "onNightModeChanged", "isNightMode", "", "setShareGuideToastListener", "show", "updateData", "updateFontSizeUI", "updateUI", "lib-atlas_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareGuideToastOne.kt */
public final class ShareGuideToastOne implements IShareGuideToast {
    private final Lazy containerView$delegate;
    private final Context context;
    private final Lazy downLoadSuccessIcon$delegate = LazyKt.lazy(new ShareGuideToastOne$downLoadSuccessIcon$2(this));
    private final Lazy downLoadSuccessText$delegate = LazyKt.lazy(new ShareGuideToastOne$downLoadSuccessText$2(this));
    private final Runnable hideRunnable = new ShareGuideToastOne$$ExternalSyntheticLambda0(this);
    private ShareGuideData shareGuideData;
    private final Lazy shareGuideIcon$delegate = LazyKt.lazy(new ShareGuideToastOne$shareGuideIcon$2(this));
    private final Lazy shareGuideText$delegate = LazyKt.lazy(new ShareGuideToastOne$shareGuideText$2(this));
    private IShareGuideToastListener shareGuideToastListener;

    public ShareGuideToastOne(Context context2, ViewGroup parentView) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.context = context2;
        this.containerView$delegate = LazyKt.lazy(new ShareGuideToastOne$containerView$2(this, parentView));
        getContainerView().setOnClickListener(new ShareGuideToastOne$$ExternalSyntheticLambda1(this));
        FontUtil.setFont(getDownLoadSuccessText(), Font.F_F_X03);
        FontUtil.setFont(getShareGuideText(), Font.F_F_X03);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getShareGuideIcon().getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setUseGlobalColorFilter(false);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: private */
    public final View getContainerView() {
        Object value = this.containerView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-containerView>(...)");
        return (View) value;
    }

    private final ImageView getDownLoadSuccessIcon() {
        Object value = this.downLoadSuccessIcon$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-downLoadSuccessIcon>(...)");
        return (ImageView) value;
    }

    private final TextView getDownLoadSuccessText() {
        Object value = this.downLoadSuccessText$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-downLoadSuccessText>(...)");
        return (TextView) value;
    }

    private final SimpleDraweeView getShareGuideIcon() {
        Object value = this.shareGuideIcon$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shareGuideIcon>(...)");
        return (SimpleDraweeView) value;
    }

    private final TextView getShareGuideText() {
        Object value = this.shareGuideText$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shareGuideText>(...)");
        return (TextView) value;
    }

    /* access modifiers changed from: private */
    /* renamed from: hideRunnable$lambda-0  reason: not valid java name */
    public static final void m17019hideRunnable$lambda0(ShareGuideToastOne this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m17018_init_$lambda1(ShareGuideToastOne this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IShareGuideToastListener iShareGuideToastListener = this$0.shareGuideToastListener;
        if (iShareGuideToastListener != null) {
            iShareGuideToastListener.onClick(it, this$0.shareGuideData);
        }
    }

    public void show() {
        if (this.shareGuideData != null) {
            getContainerView().removeCallbacks(this.hideRunnable);
            getContainerView().setVisibility(0);
            IShareGuideToastListener iShareGuideToastListener = this.shareGuideToastListener;
            if (iShareGuideToastListener != null) {
                iShareGuideToastListener.onShow(this.shareGuideData);
            }
            getContainerView().postDelayed(this.hideRunnable, ((long) LightPictureConfigListener.Companion.getShareGuideShowDuration()) * 1000);
            updateFontSizeUI();
        }
    }

    public void hide() {
        getContainerView().removeCallbacks(this.hideRunnable);
        getContainerView().setVisibility(8);
    }

    public void updateData(ShareGuideData shareGuideData2) {
        this.shareGuideData = shareGuideData2;
        updateUI();
    }

    public void setShareGuideToastListener(IShareGuideToastListener shareGuideToastListener2) {
        this.shareGuideToastListener = shareGuideToastListener2;
    }

    public void onNightModeChanged(boolean isNightMode) {
        updateUI();
    }

    public void onConfigurationChanged() {
        updateFontSizeUI();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d A[Catch:{ all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059 A[Catch:{ all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093 A[Catch:{ all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[Catch:{ all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab A[Catch:{ all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7 A[Catch:{ all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateUI() {
        /*
            r10 = this;
            com.baidu.searchbox.discovery.picture.controller.ShareGuideData r0 = r10.shareGuideData
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.View r0 = r10.getContainerView()
            int r1 = com.baidu.searchbox.common.atlas.R.drawable.light_picture_share_guide_toast_bg
            r0.setBackgroundResource(r1)
            android.widget.ImageView r0 = r10.getDownLoadSuccessIcon()
            int r1 = com.baidu.searchbox.common.atlas.R.drawable.light_picture_ugc_share_guide_succ
            r0.setImageResource(r1)
            android.widget.TextView r0 = r10.getDownLoadSuccessText()
            android.content.Context r1 = r10.context
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC257
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.setTextColor(r1)
            boolean r0 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
            r1 = 0
            r2 = 1
            r3 = 0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x00c9 }
            r4 = r10
            com.baidu.searchbox.discovery.picture.widget.ShareGuideToastOne r4 = (com.baidu.searchbox.discovery.picture.widget.ShareGuideToastOne) r4     // Catch:{ all -> 0x00c9 }
            r5 = 0
            if (r0 == 0) goto L_0x003e
            com.baidu.searchbox.discovery.picture.controller.ShareGuideData r6 = r4.shareGuideData     // Catch:{ all -> 0x00c9 }
            if (r6 == 0) goto L_0x0047
            java.lang.String r6 = r6.getIconNight()     // Catch:{ all -> 0x00c9 }
            goto L_0x0048
        L_0x003e:
            com.baidu.searchbox.discovery.picture.controller.ShareGuideData r6 = r4.shareGuideData     // Catch:{ all -> 0x00c9 }
            if (r6 == 0) goto L_0x0047
            java.lang.String r6 = r6.getIcon()     // Catch:{ all -> 0x00c9 }
            goto L_0x0048
        L_0x0047:
            r6 = r3
        L_0x0048:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00c9 }
            if (r7 == 0) goto L_0x0056
            int r7 = r7.length()     // Catch:{ all -> 0x00c9 }
            if (r7 != 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r7 = r1
            goto L_0x0057
        L_0x0056:
            r7 = r2
        L_0x0057:
            if (r7 != 0) goto L_0x0091
            android.net.Uri r7 = android.net.Uri.parse(r6)     // Catch:{ all -> 0x00c9 }
            com.facebook.imagepipeline.request.ImageRequestBuilder r7 = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(r7)     // Catch:{ all -> 0x00c9 }
            com.facebook.imagepipeline.request.ImageRequest r7 = r7.build()     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r8 = com.facebook.drawee.backends.pipeline.Fresco.newDraweeControllerBuilder()     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r8 = r8.setImageRequest(r7)     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r8 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r8     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.view.SimpleDraweeView r9 = r4.getShareGuideIcon()     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.interfaces.DraweeController r9 = r9.getController()     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r8 = r8.setOldController((com.facebook.drawee.interfaces.DraweeController) r9)     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r8 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r8     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.controller.AbstractDraweeController r8 = r8.build()     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = "newDraweeControllerBuild…                 .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.interfaces.DraweeController r8 = (com.facebook.drawee.interfaces.DraweeController) r8     // Catch:{ all -> 0x00c9 }
            com.facebook.drawee.view.SimpleDraweeView r9 = r4.getShareGuideIcon()     // Catch:{ all -> 0x00c9 }
            r9.setController(r8)     // Catch:{ all -> 0x00c9 }
        L_0x0091:
            if (r0 == 0) goto L_0x009c
            com.baidu.searchbox.discovery.picture.controller.ShareGuideData r7 = r4.shareGuideData     // Catch:{ all -> 0x00c9 }
            if (r7 == 0) goto L_0x00a5
            java.lang.String r7 = r7.getColorNight()     // Catch:{ all -> 0x00c9 }
            goto L_0x00a6
        L_0x009c:
            com.baidu.searchbox.discovery.picture.controller.ShareGuideData r7 = r4.shareGuideData     // Catch:{ all -> 0x00c9 }
            if (r7 == 0) goto L_0x00a5
            java.lang.String r7 = r7.getColor()     // Catch:{ all -> 0x00c9 }
            goto L_0x00a6
        L_0x00a5:
            r7 = r3
        L_0x00a6:
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x00c9 }
            if (r8 == 0) goto L_0x00b4
            int r8 = r8.length()     // Catch:{ all -> 0x00c9 }
            if (r8 != 0) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            r8 = r1
            goto L_0x00b5
        L_0x00b4:
            r8 = r2
        L_0x00b5:
            if (r8 != 0) goto L_0x00c2
            android.widget.TextView r8 = r4.getShareGuideText()     // Catch:{ all -> 0x00c9 }
            int r9 = android.graphics.Color.parseColor(r7)     // Catch:{ all -> 0x00c9 }
            r8.setTextColor(r9)     // Catch:{ all -> 0x00c9 }
        L_0x00c2:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c9 }
            kotlin.Result.m8971constructorimpl(r4)     // Catch:{ all -> 0x00c9 }
            goto L_0x00d3
        L_0x00c9:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            kotlin.Result.m8971constructorimpl(r4)
        L_0x00d3:
            com.baidu.searchbox.discovery.picture.controller.ShareGuideData r4 = r10.shareGuideData
            if (r4 == 0) goto L_0x00db
            java.lang.String r3 = r4.getText()
        L_0x00db:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x00e6
            int r4 = r4.length()
            if (r4 != 0) goto L_0x00e7
        L_0x00e6:
            r1 = r2
        L_0x00e7:
            if (r1 != 0) goto L_0x00f3
            android.widget.TextView r1 = r10.getShareGuideText()
            r2 = r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.discovery.picture.widget.ShareGuideToastOne.updateUI():void");
    }

    private final void updateFontSizeUI() {
        FontSizeViewExtKt.setScaledHeightRes$default(getContainerView(), 0, R.dimen.light_picture_share_guide_one_height, 0, 4, (Object) null);
        FontSizeViewExtKt.setScaledSizeRes$default(getDownLoadSuccessIcon(), 0, R.dimen.light_picture_share_guide_success_icon, R.dimen.light_picture_share_guide_success_icon, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSizeRes$default(getDownLoadSuccessText(), 0, com.baidu.searchbox.feed.styles.R.dimen.F_T_X054, 0, 4, (Object) null);
        FontSizeViewExtKt.setScaledSizeRes$default(getShareGuideIcon(), 0, R.dimen.light_picture_share_guide_channel_icon, R.dimen.light_picture_share_guide_channel_icon, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSizeRes$default(getShareGuideText(), 0, com.baidu.searchbox.feed.styles.R.dimen.F_T_X054, 0, 4, (Object) null);
    }
}
