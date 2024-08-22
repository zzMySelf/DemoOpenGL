package com.baidu.searchbox.feed.attention.view.multiauthors;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.datachannel.DataChannel;
import com.baidu.searchbox.feed.attention.R;
import com.baidu.searchbox.feed.controller.datachannel.FeedDataChannelConstants;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J0\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\b\u0010&\u001a\u00020\u001cH\u0002J\u0018\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00162\b\b\u0002\u0010)\u001a\u00020\u0016J\b\u0010*\u001a\u00020\u001cH\u0002J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010,\u001a\u00020\u001cR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/feed/attention/view/multiauthors/AvatarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarContainer", "Landroid/view/View;", "avatarImg", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "avatarImgContainer", "Landroid/view/ViewGroup;", "avatarModel", "Lcom/baidu/searchbox/feed/attention/view/multiauthors/AvatarModel;", "avatarVIcon", "centerX", "", "centerY", "isSelectedItem", "", "name", "Landroid/widget/TextView;", "newTipView", "outerRingWidth", "dismissNewTipIfNeed", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "l", "t", "r", "b", "sendNewTipGoneDataChannel", "setIsSelectedItem", "isCurrentItem", "isAnim", "showNewTipIfNeed", "updateData", "updateUi", "lib-feed-attention_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AvatarView.kt */
public final class AvatarView extends LinearLayout {
    private final View avatarContainer;
    private final FeedDraweeView avatarImg;
    private final ViewGroup avatarImgContainer;
    private AvatarModel avatarModel;
    private final FeedDraweeView avatarVIcon;
    private float centerX;
    private float centerY;
    private boolean isSelectedItem;
    private final TextView name;
    private View newTipView;
    private final float outerRingWidth;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvatarView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.outerRingWidth = (float) ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.feed_avatar_outer_ring_size);
        LayoutInflater.from(context).inflate(R.layout.feed_attention_avatar_view, this);
        View findViewById = findViewById(R.id.avatar_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar_container)");
        this.avatarContainer = findViewById;
        View findViewById2 = findViewById(R.id.avatar_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.avatar_img)");
        this.avatarImg = (FeedDraweeView) findViewById2;
        View findViewById3 = findViewById(R.id.avatar_img_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.avatar_img_container)");
        this.avatarImgContainer = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.avatar_v_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.avatar_v_icon)");
        this.avatarVIcon = (FeedDraweeView) findViewById4;
        View findViewById5 = findViewById(R.id.author_name);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.author_name)");
        this.name = (TextView) findViewById5;
        this.newTipView = findViewById(R.id.new_tip);
        setOrientation(1);
        setDividerDrawable(ViewExtensionsKt.getDrawable(this, com.baidu.searchbox.feed.R.drawable.feed_half_screen_no_data_normal_bg_trans));
        setWillNotDraw(false);
        ViewExtensionsKt.addPressedState$default(this, 0.0f, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        float f2 = (float) 2;
        this.centerX = this.avatarImgContainer.getX() + (((float) this.avatarImgContainer.getMeasuredWidth()) / f2);
        this.centerY = this.avatarImgContainer.getY() + (((float) this.avatarImgContainer.getMeasuredHeight()) / f2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
    }

    public final void updateData(AvatarModel avatarModel2) {
        Intrinsics.checkNotNullParameter(avatarModel2, "avatarModel");
        this.avatarModel = avatarModel2;
        this.avatarImg.asCircle().loadImage(avatarModel2.getAvatarUrl(), (FeedBaseModel) null);
        if (avatarModel2.getVUrl().length() > 0) {
            this.avatarVIcon.setVisibility(0);
            this.avatarVIcon.asCircle().loadImage(avatarModel2.getVUrl(), (FeedBaseModel) null);
        }
        this.name.setText(avatarModel2.getName());
        showNewTipIfNeed();
        updateUi();
    }

    public final void updateUi() {
        ViewExtensionsKt.setTextColorRes(this.name, com.baidu.android.common.ui.style.R.color.GC1);
        ViewExtensionsKt.setBackgroundRes(this.newTipView, R.drawable.feed_author_new_tip_bg);
        ViewExtensionsKt.setBackgroundRes(this.avatarImgContainer, R.drawable.feed_author_img_container_bg);
    }

    private final void showNewTipIfNeed() {
        AvatarModel avatarModel2 = this.avatarModel;
        if (avatarModel2 != null ? avatarModel2.isShowNewTip() : false) {
            View view2 = this.newTipView;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.newTipView;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    private final void dismissNewTipIfNeed() {
        AvatarModel avatarModel2 = this.avatarModel;
        if (avatarModel2 != null ? avatarModel2.isShowNewTip() : false) {
            View view2 = this.newTipView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.newTipView = null;
            AvatarModel avatarModel3 = this.avatarModel;
            if (avatarModel3 != null) {
                avatarModel3.setShowNewTip(false);
            }
            sendNewTipGoneDataChannel();
        }
    }

    public static /* synthetic */ void setIsSelectedItem$default(AvatarView avatarView, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        avatarView.setIsSelectedItem(z, z2);
    }

    public final void setIsSelectedItem(boolean isCurrentItem, boolean isAnim) {
        int targetSize;
        this.isSelectedItem = isCurrentItem;
        int currentSize = this.avatarImg.getMeasuredWidth();
        int i2 = currentSize;
        if (isCurrentItem) {
            this.name.setVisibility(8);
            View view2 = this.newTipView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            targetSize = ViewExtensionsKt.getDimensionPixelSize(this, com.baidu.searchbox.feed.styles.R.dimen.F_W_X20);
        } else {
            this.name.setVisibility(0);
            targetSize = ViewExtensionsKt.getDimensionPixelSize(this, com.baidu.searchbox.feed.styles.R.dimen.F_W_X19);
        }
        if (isAnim) {
            ValueAnimator $this$setIsSelectedItem_u24lambda_u2d1 = ValueAnimator.ofInt(new int[]{currentSize, targetSize}).setDuration(200);
            $this$setIsSelectedItem_u24lambda_u2d1.addUpdateListener(new AvatarView$$ExternalSyntheticLambda0(this));
            $this$setIsSelectedItem_u24lambda_u2d1.start();
        } else {
            ViewExtensionsKt.setSize(this.avatarImg, targetSize, targetSize);
        }
        if (isCurrentItem) {
            dismissNewTipIfNeed();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setIsSelectedItem$lambda-1$lambda-0  reason: not valid java name */
    public static final void m18422setIsSelectedItem$lambda1$lambda0(AvatarView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        if (animatedValue != null) {
            int size = ((Integer) animatedValue).intValue();
            ViewExtensionsKt.setSize(this$0.avatarImg, size, size);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void sendNewTipGoneDataChannel() {
        try {
            JSONObject paramJson = new JSONObject();
            JSONObject $this$sendNewTipGoneDataChannel_u24lambda_u2d2 = paramJson;
            AvatarModel avatarModel2 = this.avatarModel;
            String str = null;
            $this$sendNewTipGoneDataChannel_u24lambda_u2d2.put(AvatarModelKt.KEY_TAB_ID, avatarModel2 != null ? avatarModel2.getTabId() : null);
            $this$sendNewTipGoneDataChannel_u24lambda_u2d2.put("time_stamp", System.currentTimeMillis() / ((long) 1000));
            AvatarModel avatarModel3 = this.avatarModel;
            if (avatarModel3 != null) {
                str = avatarModel3.getMthid();
            }
            $this$sendNewTipGoneDataChannel_u24lambda_u2d2.put("id", str);
            DataChannel.Sender.sendBroadcast(getContext(), FeedDataChannelConstants.ACTION_FLOAT_AVATAR_RED_GONE, paramJson.toString());
        } catch (JSONException e2) {
        }
    }
}
