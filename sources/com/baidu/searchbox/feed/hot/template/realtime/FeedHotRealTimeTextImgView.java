package com.baidu.searchbox.feed.hot.template.realtime;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.feed.base.IFeedRecyclerScroll;
import com.baidu.searchbox.feed.base.ITabHomeStatePerceive;
import com.baidu.searchbox.feed.hot.R;
import com.baidu.searchbox.feed.model.FeedUIConfigBean;
import com.baidu.searchbox.feed.template.FeedHotLabelLayout;
import com.baidu.searchbox.feed.template.FeedRelativeLayout;
import com.baidu.searchbox.feed.template.mutevideo.MuteVideoView;
import com.baidu.searchbox.feed.template.tplinterface.OnNetWorkChangeListener;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u001a\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\b\u0010,\u001a\u00020\u001aH\u0016J\b\u0010-\u001a\u00020\u001aH\u0016J(\u0010.\u001a\u00020\u001a2\b\u0010/\u001a\u0004\u0018\u0001002\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204\u0018\u000102H\u0016J\u0010\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u000207H\u0002R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/baidu/searchbox/feed/hot/template/realtime/FeedHotRealTimeTextImgView;", "Lcom/baidu/searchbox/feed/template/FeedRelativeLayout;", "Lcom/baidu/searchbox/feed/template/tplinterface/OnNetWorkChangeListener;", "Lcom/baidu/searchbox/feed/base/IFeedRecyclerScroll;", "Lcom/baidu/searchbox/feed/base/ITabHomeStatePerceive;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "abstractTV", "Landroid/widget/TextView;", "circleView", "Landroid/view/View;", "contentLayout", "formatTimeTV", "labelView", "Lcom/baidu/searchbox/feed/template/FeedHotLabelLayout;", "muteVideoView", "Lcom/baidu/searchbox/feed/template/mutevideo/MuteVideoView;", "realTimeData", "Lcom/baidu/searchbox/feed/hot/template/realtime/FeedHotRealTimeTextImgData;", "titleTV", "applyFontSize", "", "applyHotLabelSizeChange", "applyRoundUiPolicy", "initialize", "onBindQuery", "query", "Lcom/baidu/searchbox/feed/base/ITabHomeStatePerceive$Query;", "onFeedNightModeChanged", "isNightMode", "", "onNetWorkChange", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onStateChanged", "state", "onViewDestroy", "onViewPause", "onViewResume", "update", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "options", "", "", "", "updateLabel", "data", "Lcom/baidu/searchbox/feed/model/FeedUIConfigBean;", "lib-hotsearch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedHotRealTimeTextImgView.kt */
public final class FeedHotRealTimeTextImgView extends FeedRelativeLayout implements OnNetWorkChangeListener, IFeedRecyclerScroll, ITabHomeStatePerceive {
    public Map<Integer, View> _$_findViewCache;
    private TextView abstractTV;
    private View circleView;
    private View contentLayout;
    private TextView formatTimeTV;
    private FeedHotLabelLayout labelView;
    private MuteVideoView muteVideoView;
    private FeedHotRealTimeTextImgData realTimeData;
    private TextView titleTV;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedHotRealTimeTextImgView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedHotRealTimeTextImgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedHotRealTimeTextImgView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedHotRealTimeTextImgView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public void initialize(Context context) {
        super.initialize(context);
        LayoutInflater.from(context).inflate(R.layout.feed_hot_search_realtime_text_img_item, this);
        TextView textView = (TextView) _$_findCachedViewById(R.id.hot_realtime_title);
        Intrinsics.checkNotNullExpressionValue(textView, "hot_realtime_title");
        this.titleTV = textView;
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.hot_realtime_abstract);
        Intrinsics.checkNotNullExpressionValue(textView2, "hot_realtime_abstract");
        this.abstractTV = textView2;
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.hot_realtime_format_time);
        Intrinsics.checkNotNullExpressionValue(textView3, "hot_realtime_format_time");
        this.formatTimeTV = textView3;
        MuteVideoView muteVideoView2 = (MuteVideoView) _$_findCachedViewById(R.id.hot_realtime_video);
        Intrinsics.checkNotNullExpressionValue(muteVideoView2, "hot_realtime_video");
        this.muteVideoView = muteVideoView2;
        FeedHotLabelLayout feedHotLabelLayout = (FeedHotLabelLayout) _$_findCachedViewById(R.id.hot_realtime_label);
        Intrinsics.checkNotNullExpressionValue(feedHotLabelLayout, "hot_realtime_label");
        this.labelView = feedHotLabelLayout;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.hot_realtime_circle);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "hot_realtime_circle");
        this.circleView = _$_findCachedViewById;
        View findViewById = findViewById(com.baidu.searchbox.feed.core.R.id.feed_template_click_area);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.baidu.s…feed_template_click_area)");
        this.contentLayout = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            findViewById = null;
        }
        findViewById.setOnClickListener(new FeedHotRealTimeTextImgView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-0  reason: not valid java name */
    public static final void m18762initialize$lambda0(FeedHotRealTimeTextImgView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mFeedTemplateImplBase.mClickListener.onClick(it);
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(com.baidu.searchbox.feed.model.FeedBaseModel r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r9 = this;
            super.update(r10, r11)
            r0 = 0
            r9.setOnClickListener(r0)
            if (r10 == 0) goto L_0x000c
            com.baidu.searchbox.feed.model.FeedItemData r1 = r10.data
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            boolean r2 = r1 instanceof com.baidu.searchbox.feed.hot.template.realtime.FeedHotRealTimeTextImgData
            if (r2 == 0) goto L_0x0014
            com.baidu.searchbox.feed.hot.template.realtime.FeedHotRealTimeTextImgData r1 = (com.baidu.searchbox.feed.hot.template.realtime.FeedHotRealTimeTextImgData) r1
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            if (r1 == 0) goto L_0x0149
            r2 = 0
            r9.realTimeData = r1
            android.widget.TextView r3 = r9.titleTV
            if (r3 != 0) goto L_0x0025
            java.lang.String r3 = "titleTV"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r0
        L_0x0025:
            java.lang.String r4 = r1.title
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            android.widget.TextView r3 = r9.abstractTV
            java.lang.String r4 = "abstractTV"
            if (r3 != 0) goto L_0x0036
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r3 = r0
        L_0x0036:
            r5 = 0
            java.lang.String r6 = r1.getAbstract()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            boolean r7 = r6 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r7 == 0) goto L_0x004b
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            goto L_0x004c
        L_0x004b:
            r6 = r0
        L_0x004c:
            if (r6 != 0) goto L_0x004f
            goto L_0x005f
        L_0x004f:
            boolean r7 = r1.isVideoOrImg()
            if (r7 == 0) goto L_0x0057
            r7 = 6
            goto L_0x0059
        L_0x0057:
            r7 = 9
        L_0x0059:
            int r7 = com.baidu.searchbox.nacomp.extension.util.ViewExKt.getDp((int) r7)
            r6.topMargin = r7
        L_0x005f:
            r3.requestLayout()
            android.widget.TextView r3 = r9.formatTimeTV
            if (r3 != 0) goto L_0x006e
            java.lang.String r3 = "formatTimeTV"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r0
        L_0x006e:
            java.lang.String r5 = r1.getFormatTime()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
            boolean r3 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
            if (r3 == 0) goto L_0x0082
            com.baidu.searchbox.feed.model.FeedUIConfigBean r3 = r1.getLabelNightUIBean()
            goto L_0x0086
        L_0x0082:
            com.baidu.searchbox.feed.model.FeedUIConfigBean r3 = r1.getLabelDayUIBean()
        L_0x0086:
            r9.updateLabel(r3)
            java.lang.String r3 = r1.getAbstract()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            r5 = 1
            r6 = 0
            if (r3 != 0) goto L_0x0099
            r3 = r5
            goto L_0x009a
        L_0x0099:
            r3 = r6
        L_0x009a:
            r7 = 8
            if (r3 != 0) goto L_0x00c8
            boolean r3 = r1.isVideo()
            if (r3 == 0) goto L_0x00a5
            goto L_0x00c8
        L_0x00a5:
            android.widget.TextView r3 = r9.abstractTV
            if (r3 != 0) goto L_0x00ad
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r3 = r0
        L_0x00ad:
            r3.setVisibility(r6)
            int r3 = r1.getAbstractMaxLineNum()
            if (r3 <= 0) goto L_0x00bb
            int r3 = r1.getAbstractMaxLineNum()
            goto L_0x00bc
        L_0x00bb:
            r3 = 3
        L_0x00bc:
            android.widget.TextView r8 = r9.abstractTV
            if (r8 != 0) goto L_0x00c4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r8 = r0
        L_0x00c4:
            r8.setMaxLines(r3)
            goto L_0x00d3
        L_0x00c8:
            android.widget.TextView r3 = r9.abstractTV
            if (r3 != 0) goto L_0x00d0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r3 = r0
        L_0x00d0:
            r3.setVisibility(r7)
        L_0x00d3:
            boolean r3 = r1.isVideoOrImg()
            java.lang.String r4 = "muteVideoView"
            if (r3 == 0) goto L_0x0120
            java.lang.String r3 = r1.getImgUrl()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x00ea
            r3 = r5
            goto L_0x00eb
        L_0x00ea:
            r3 = r6
        L_0x00eb:
            if (r3 == 0) goto L_0x0120
            com.baidu.searchbox.feed.template.mutevideo.MuteVideoView r3 = r9.muteVideoView
            if (r3 != 0) goto L_0x00f5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r3 = r0
        L_0x00f5:
            r3.setVisibility(r6)
            com.baidu.searchbox.feed.template.mutevideo.MuteVideoView r3 = r9.muteVideoView
            if (r3 != 0) goto L_0x0100
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r3 = r0
        L_0x0100:
            boolean r7 = r1.isImg()
            r3.setIsImageTypeVideo(r7)
            com.baidu.searchbox.feed.template.mutevideo.MuteVideoView r3 = r9.muteVideoView
            if (r3 != 0) goto L_0x010f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0110
        L_0x010f:
            r0 = r3
        L_0x0110:
            com.baidu.searchbox.feed.template.FeedTemplateImpl r3 = r9.mFeedTemplateImplBase
            if (r3 == 0) goto L_0x0119
            boolean r3 = r3.mIsUpdateOnlySkin
            if (r3 != r5) goto L_0x0119
            goto L_0x011a
        L_0x0119:
            r5 = r6
        L_0x011a:
            com.baidu.searchbox.feed.model.FeedItemDataTabVideo$VideoInfoEntity r3 = r1.videoInfo
            r0.update(r10, r5, r3)
            goto L_0x012c
        L_0x0120:
            com.baidu.searchbox.feed.template.mutevideo.MuteVideoView r3 = r9.muteVideoView
            if (r3 != 0) goto L_0x0128
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0129
        L_0x0128:
            r0 = r3
        L_0x0129:
            r0.setVisibility(r7)
        L_0x012c:
            com.baidu.searchbox.feed.hot.config.HotSearchAbTest r0 = com.baidu.searchbox.feed.hot.config.HotSearchAbTest.INSTANCE
            boolean r0 = r0.getTopicOpen()
            if (r0 == 0) goto L_0x0147
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r0 = r10.runtimeStatus
            int r0 = r0.viewPosition
            if (r0 != 0) goto L_0x0144
            r0 = 1099431936(0x41880000, float:17.0)
            int r0 = com.baidu.searchbox.nacomp.extension.util.ViewExKt.getDp((float) r0)
            r9.setPadding(r6, r0, r6, r6)
            goto L_0x0147
        L_0x0144:
            r9.setPadding(r6, r6, r6, r6)
        L_0x0147:
        L_0x0149:
            r9.applyFontSize()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.hot.template.realtime.FeedHotRealTimeTextImgView.update(com.baidu.searchbox.feed.model.FeedBaseModel, java.util.Map):void");
    }

    private final void updateLabel(FeedUIConfigBean data) {
        FeedHotLabelLayout feedHotLabelLayout = this.labelView;
        FeedHotLabelLayout feedHotLabelLayout2 = null;
        if (feedHotLabelLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelView");
            feedHotLabelLayout = null;
        }
        feedHotLabelLayout.reset();
        FeedHotLabelLayout feedHotLabelLayout3 = this.labelView;
        if (feedHotLabelLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelView");
        } else {
            feedHotLabelLayout2 = feedHotLabelLayout3;
        }
        feedHotLabelLayout2.update(data.getLabelImage(), data.getLabelLottie(), data.getWidth(), data.getHeight());
    }

    public void applyRoundUiPolicy() {
        super.applyRoundUiPolicy();
        MuteVideoView muteVideoView2 = this.muteVideoView;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.applyRoundUiPolicy();
    }

    public void onViewResume() {
        super.onViewResume();
        MuteVideoView muteVideoView2 = this.muteVideoView;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.onViewResume();
    }

    public void onViewDestroy() {
        super.onViewDestroy();
        MuteVideoView muteVideoView2 = this.muteVideoView;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.onViewDestroy();
    }

    public void onViewPause() {
        super.onViewPause();
        MuteVideoView muteVideoView2 = this.muteVideoView;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.onViewPause();
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        super.onFeedNightModeChanged(isNightMode);
        MuteVideoView muteVideoView2 = this.muteVideoView;
        View view2 = null;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.onFeedNightModeChanged();
        TextView textView = this.abstractTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abstractTV");
            textView = null;
        }
        textView.setTextColor(getContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC105));
        TextView textView2 = this.formatTimeTV;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formatTimeTV");
            textView2 = null;
        }
        textView2.setTextColor(getContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC105));
        TextView textView3 = this.titleTV;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTV");
            textView3 = null;
        }
        textView3.setTextColor(getContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        View view3 = this.contentLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            view3 = null;
        }
        ViewExtensionsKt.setBackgroundRes(view3, R.drawable.feed_hot_realtime_content_bg);
        View view4 = this.circleView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("circleView");
        } else {
            view2 = view4;
        }
        ViewExtensionsKt.setBackgroundRes(view2, R.drawable.feed_hot_realtime_circle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void applyHotLabelSizeChange() {
        /*
            r3 = this;
            boolean r0 = com.baidu.searchbox.skin.NightModeHelper.getNightModeSwitcherState()
            r1 = 0
            if (r0 == 0) goto L_0x0010
            com.baidu.searchbox.feed.hot.template.realtime.FeedHotRealTimeTextImgData r0 = r3.realTimeData
            if (r0 == 0) goto L_0x0019
            com.baidu.searchbox.feed.model.FeedUIConfigBean r0 = r0.getLabelNightUIBean()
            goto L_0x001a
        L_0x0010:
            com.baidu.searchbox.feed.hot.template.realtime.FeedHotRealTimeTextImgData r0 = r3.realTimeData
            if (r0 == 0) goto L_0x0019
            com.baidu.searchbox.feed.model.FeedUIConfigBean r0 = r0.getLabelDayUIBean()
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            if (r0 == 0) goto L_0x002f
            r3.updateLabel(r0)
            com.baidu.searchbox.feed.template.FeedHotLabelLayout r2 = r3.labelView
            if (r2 != 0) goto L_0x002b
            java.lang.String r2 = "labelView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            r1.applyFontSizeChanged()
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.hot.template.realtime.FeedHotRealTimeTextImgView.applyHotLabelSizeChange():void");
    }

    public void applyFontSize() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        View view2;
        super.applyFontSize();
        applyHotLabelSizeChange();
        TextView textView4 = this.titleTV;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTV");
            textView = null;
        } else {
            textView = textView4;
        }
        FontSizeTextViewExtKt.setScaledSizeRes$default(textView, 1, com.baidu.searchbox.feed.styles.R.dimen.F_T_X051, 0, 4, (Object) null);
        TextView textView5 = this.abstractTV;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abstractTV");
            textView2 = null;
        } else {
            textView2 = textView5;
        }
        FontSizeTextViewExtKt.setScaledSizeRes$default(textView2, 1, com.baidu.searchbox.feed.styles.R.dimen.F_T_X055, 0, 4, (Object) null);
        TextView textView6 = this.formatTimeTV;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formatTimeTV");
            textView3 = null;
        } else {
            textView3 = textView6;
        }
        FontSizeTextViewExtKt.setScaledSizeRes$default(textView3, 1, com.baidu.searchbox.feed.styles.R.dimen.F_T_X058, 0, 4, (Object) null);
        View view3 = this.circleView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("circleView");
            view2 = null;
        } else {
            view2 = view3;
        }
        FontSizeViewExtKt.setScaledSizeRes$default(view2, 0, R.dimen.feed_realtime_circle_size, R.dimen.feed_realtime_circle_size, 0, 8, (Object) null);
    }

    public void onNetWorkChange() {
        MuteVideoView muteVideoView2 = this.muteVideoView;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.handNetWorkChange();
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        MuteVideoView muteVideoView2 = this.muteVideoView;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.onScrollStateChanged(recyclerView, newState);
    }

    public void onBindQuery(ITabHomeStatePerceive.Query query) {
        MuteVideoView muteVideoView2 = this.muteVideoView;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.setITabHomeState(query);
    }

    public void onStateChanged(int state) {
        MuteVideoView muteVideoView2 = this.muteVideoView;
        if (muteVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoView");
            muteVideoView2 = null;
        }
        muteVideoView2.onStateChanged(state);
    }
}
