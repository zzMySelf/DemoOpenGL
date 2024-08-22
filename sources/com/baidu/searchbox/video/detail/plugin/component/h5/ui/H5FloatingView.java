package com.baidu.searchbox.video.detail.plugin.component.h5.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.lightbrowser.view.LightBrowserView;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.plugin.component.h5.webjs.VideoH5FloatingInterface;
import com.baidu.searchbox.video.detail.utils.VideoDetailUbcExtUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0003J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006J(\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\fJ\b\u0010 \u001a\u00020\u0014H\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/h5/ui/H5FloatingView;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "autoCloseListener", "Lcom/baidu/searchbox/video/detail/plugin/component/h5/ui/H5FloatingView$IH5FloatingAutoCloseListener;", "closeImg", "Landroid/widget/ImageView;", "getContext", "()Landroid/content/Context;", "isLoadSuccess", "", "rootView", "Landroid/widget/RelativeLayout;", "videoInterface", "Lcom/baidu/searchbox/video/detail/plugin/component/h5/webjs/VideoH5FloatingInterface;", "webview", "Lcom/baidu/searchbox/lightbrowser/view/LightBrowserView;", "destroyWebView", "", "initView", "setAutoCloseListener", "listener", "show", "parent", "Landroid/view/View;", "url", "", "offsetY", "", "isShowFirstPage", "updateNightMode", "IH5FloatingAutoCloseListener", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: H5FloatingView.kt */
public final class H5FloatingView extends PopupWindow {
    private IH5FloatingAutoCloseListener autoCloseListener;
    private final ImageView closeImg;
    private final Context context;
    /* access modifiers changed from: private */
    public boolean isLoadSuccess;
    private final RelativeLayout rootView;
    private final VideoH5FloatingInterface videoInterface;
    private final LightBrowserView webview;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/h5/ui/H5FloatingView$IH5FloatingAutoCloseListener;", "", "onAutoClose", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: H5FloatingView.kt */
    public interface IH5FloatingAutoCloseListener {
        void onAutoClose();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public H5FloatingView(Context context2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.rootView = new RelativeLayout(context2);
        this.closeImg = new ImageView(context2);
        this.webview = new LightBrowserView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.videoInterface = new VideoH5FloatingInterface(context2, this);
        setWidth(-1);
        setHeight(-1);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(48);
        setAnimationStyle(R.style.video_comment_popupwindow_anim);
        initView();
    }

    public final Context getContext() {
        return this.context;
    }

    private final void initView() {
        this.webview.addJavascriptInterface(this.videoInterface, VideoH5FloatingInterface.JAVASCRIPT_INTERFACE_NAME);
        this.webview.setCloseWindowListener(new H5FloatingView$$ExternalSyntheticLambda0(this));
        this.webview.setStateChangeCallback(new H5FloatingView$initView$2(this));
        this.webview.setPadding(0, this.context.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.core.R.dimen.dimens_44dp), 0, 0);
        this.rootView.addView(this.webview);
        this.closeImg.setImageResource(R.drawable.video_bdcomment_detail_close_selector);
        RelativeLayout.LayoutParams closeParams = new RelativeLayout.LayoutParams(this.context.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.core.R.dimen.dimens_44dp), this.context.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.core.R.dimen.dimens_44dp));
        closeParams.addRule(11);
        int padding = this.context.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.core.R.dimen.dimens_15dp);
        this.closeImg.setPadding(padding, 0, padding, 0);
        this.closeImg.setOnClickListener(new H5FloatingView$$ExternalSyntheticLambda1(this));
        this.rootView.addView(this.closeImg, closeParams);
        setContentView(this.rootView);
        updateNightMode();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m5374initView$lambda0(H5FloatingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IH5FloatingAutoCloseListener iH5FloatingAutoCloseListener = this$0.autoCloseListener;
        if (iH5FloatingAutoCloseListener != null) {
            iH5FloatingAutoCloseListener.onAutoClose();
        }
        VideoDetailUbcExtUtils.uploadBannerH5FloatingUbc("half_windows_autoshut_clk");
        this$0.videoInterface.closeVideoBannerWindow();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m5375initView$lambda1(H5FloatingView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoDetailUbcExtUtils.uploadBannerH5FloatingUbc("half_windows_shut_clk");
        this$0.dismiss();
    }

    public final void updateNightMode() {
        this.rootView.setBackgroundColor(ContextCompat.getColor(this.context, com.baidu.android.common.ui.style.R.color.GC21));
    }

    public static /* synthetic */ void show$default(H5FloatingView h5FloatingView, View view2, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = false;
        }
        h5FloatingView.show(view2, str, i2, z);
    }

    public final void show(View parent, String url, int offsetY, boolean isShowFirstPage) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(url, "url");
        VideoDetailUbcExtUtils.uploadBannerH5FloatingUbc("half_windows_show");
        if (!this.isLoadSuccess || isShowFirstPage) {
            LightBrowserView.loadUrl$default(this.webview, url, (Map) null, false, 6, (Object) null);
        }
        showAtLocation(parent, 49, 0, offsetY);
    }

    public final void destroyWebView() {
        this.webview.onDestroy();
    }

    public final void setAutoCloseListener(IH5FloatingAutoCloseListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.autoCloseListener = listener;
    }
}
