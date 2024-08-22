package com.baidu.searchbox.video.feedflow.detail.barrage.airole;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.pyramid.annotation.nps.PluginAccessible;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\u0000H\u0016J\u0010\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0019H\u0016J\u0010\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\"H\u0016J\u0010\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00103\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020\"H\u0016J\u0010\u00109\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\u0010\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\bH\u0016J\u0010\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/barrage/airole/BubbleAvatarBuilder;", "Lcom/baidu/searchbox/ui/bubble/builder/BubbleTextBuilder;", "()V", "mManager", "Lcom/baidu/searchbox/video/feedflow/detail/barrage/airole/BubbleAvatarManager;", "(Lcom/baidu/searchbox/video/feedflow/detail/barrage/airole/BubbleAvatarManager;)V", "build", "enableAnchorClk", "", "enableAnimation", "enableBgClk", "enableClkDismiss", "isAutoDetectShowPosition", "isAuto", "isMiniBubble", "setAnchorAndRootView", "anchor", "Landroid/view/View;", "rootView", "Landroid/view/ViewGroup;", "setAnchorView", "setAutoDismiss", "autoDismiss", "setAutoDismissInterval", "intervalInMs", "", "setAvatar", "avatarUrl", "", "setBackgroundColor", "dayColor", "nightColor", "setBubbleAlpha", "alpha", "", "setFontSize", "unit", "size", "setForceShowLeftEndPoint", "setForceShowPosition", "position", "Lcom/baidu/searchbox/ui/bubble/BubblePosition;", "setGravity", "gravity", "setIsBold", "isBold", "setMaxLines", "lines", "setOffsetOfArrow", "offsetOfArrow", "setOnAnchorClickListener", "listener", "Lcom/baidu/searchbox/ui/bubble/BubbleManager$OnAnchorClickListener;", "setOnBubbleEventListener", "Lcom/baidu/searchbox/ui/bubble/BubbleManager$OnBubbleEventListener;", "setPaddingBetweenAnchor", "paddingInDp", "setShadowDayColor", "setShadowIsDeviate", "isDeviate", "setSpan", "span", "Landroid/text/SpannableStringBuilder;", "setText", "str", "", "setTextColor", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BubbleAvatarBuilder.kt */
public final class BubbleAvatarBuilder extends BubbleTextBuilder {
    private final BubbleAvatarManager mManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected BubbleAvatarBuilder(BubbleAvatarManager mManager2) {
        super(mManager2);
        Intrinsics.checkNotNullParameter(mManager2, "mManager");
        this.mManager = mManager2;
    }

    public BubbleAvatarBuilder() {
        this(new BubbleAvatarManager((BubbleAvatarTextView) null, 1, (DefaultConstructorMarker) null));
    }

    public final BubbleAvatarBuilder setAvatar(String avatarUrl) {
        this.mManager.getViews().setAvatar(avatarUrl);
        return this;
    }

    public BubbleAvatarBuilder setText(CharSequence str) {
        Intrinsics.checkNotNullParameter(str, "str");
        super.setText(str);
        return this;
    }

    public BubbleAvatarBuilder setBubbleAlpha(float alpha) {
        super.setBubbleAlpha(alpha);
        return this;
    }

    public BubbleAvatarBuilder setTextColor(int dayColor, int nightColor) {
        super.setTextColor(dayColor, nightColor);
        return this;
    }

    public BubbleAvatarBuilder setTextColor(String dayColor, String nightColor) {
        Intrinsics.checkNotNullParameter(dayColor, "dayColor");
        Intrinsics.checkNotNullParameter(nightColor, "nightColor");
        super.setTextColor(dayColor, nightColor);
        return this;
    }

    public BubbleAvatarBuilder setFontSize(int unit, float size) {
        super.setFontSize(unit, size);
        return this;
    }

    public BubbleAvatarBuilder setIsBold(boolean isBold) {
        super.setIsBold(isBold);
        return this;
    }

    public BubbleAvatarBuilder setMaxLines(int lines) {
        super.setMaxLines(lines);
        return this;
    }

    public BubbleAvatarBuilder setGravity(int gravity) {
        super.setGravity(gravity);
        return this;
    }

    public BubbleAvatarBuilder setShadowIsDeviate(boolean isDeviate) {
        super.setShadowIsDeviate(isDeviate);
        return this;
    }

    public BubbleAvatarBuilder setSpan(SpannableStringBuilder span) {
        Intrinsics.checkNotNullParameter(span, "span");
        super.setSpan(span);
        return this;
    }

    public BubbleAvatarBuilder isMiniBubble(boolean isMiniBubble) {
        super.isMiniBubble(isMiniBubble);
        return this;
    }

    public BubbleAvatarBuilder setBackgroundColor(int dayColor, int nightColor) {
        super.setBackgroundColor(dayColor, nightColor);
        return this;
    }

    public BubbleAvatarBuilder setBackgroundColor(String dayColor, String nightColor) {
        Intrinsics.checkNotNullParameter(dayColor, "dayColor");
        Intrinsics.checkNotNullParameter(nightColor, "nightColor");
        super.setBackgroundColor(dayColor, nightColor);
        return this;
    }

    public BubbleAvatarBuilder setShadowDayColor(int dayColor) {
        super.setShadowDayColor(dayColor);
        return this;
    }

    public BubbleAvatarBuilder setAnchorView(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        super.setAnchorView(anchor);
        return this;
    }

    public BubbleAvatarBuilder setAnchorAndRootView(View anchor, ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.setAnchorAndRootView(anchor, rootView);
        return this;
    }

    public BubbleAvatarBuilder setAutoDismiss(boolean autoDismiss) {
        super.setAutoDismiss(autoDismiss);
        return this;
    }

    public BubbleAvatarBuilder setAutoDismissInterval(int intervalInMs) {
        super.setAutoDismissInterval(intervalInMs);
        return this;
    }

    public BubbleAvatarBuilder setPaddingBetweenAnchor(float paddingInDp) {
        super.setPaddingBetweenAnchor(paddingInDp);
        return this;
    }

    public BubbleAvatarBuilder setOnBubbleEventListener(BubbleManager.OnBubbleEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        super.setOnBubbleEventListener(listener);
        return this;
    }

    public BubbleAvatarBuilder setOnAnchorClickListener(BubbleManager.OnAnchorClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        super.setOnAnchorClickListener(listener);
        return this;
    }

    public BubbleAvatarBuilder enableBgClk(boolean enableBgClk) {
        super.enableBgClk(enableBgClk);
        return this;
    }

    public BubbleAvatarBuilder enableAnchorClk(boolean enableAnchorClk) {
        super.enableAnchorClk(enableAnchorClk);
        return this;
    }

    public BubbleAvatarBuilder enableAnimation(boolean enableAnimation) {
        super.enableAnimation(enableAnimation);
        return this;
    }

    public BubbleAvatarBuilder setOffsetOfArrow(float offsetOfArrow) {
        super.setOffsetOfArrow(offsetOfArrow);
        return this;
    }

    public BubbleAvatarBuilder enableClkDismiss(boolean enableClkDismiss) {
        super.enableClkDismiss(enableClkDismiss);
        return this;
    }

    public BubbleAvatarBuilder isAutoDetectShowPosition(boolean isAuto) {
        super.isAutoDetectShowPosition(isAuto);
        return this;
    }

    public BubbleAvatarBuilder setForceShowPosition(BubblePosition position) {
        Intrinsics.checkNotNullParameter(position, "position");
        super.setForceShowPosition(position);
        return this;
    }

    public BubbleAvatarBuilder setForceShowLeftEndPoint() {
        super.setForceShowLeftEndPoint();
        return this;
    }

    @PluginAccessible
    public BubbleAvatarManager build() {
        return this.mManager;
    }
}
