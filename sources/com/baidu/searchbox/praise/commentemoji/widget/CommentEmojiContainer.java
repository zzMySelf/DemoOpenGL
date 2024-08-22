package com.baidu.searchbox.praise.commentemoji.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GestureDetectorCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.parise.R;
import com.baidu.searchbox.praise.commentemoji.animation.CommentEmojiSendAnim;
import com.baidu.searchbox.praise.commentemoji.animation.CommentEmojiTouchScaleAnim;
import com.baidu.searchbox.praise.commentemoji.data.CommentEmojiRes;
import com.baidu.searchbox.praise.emoji.tools.EmojiWidgetUtilsKt;
import com.baidu.searchbox.praise.emojiinterface.CommentViewPosition;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001IB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010,\u001a\u00020-J\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0014\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u00010)H\u0002J\u0006\u00103\u001a\u00020!J\u001c\u00104\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u00010)H\u0002J\u0012\u00105\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010)H\u0016J\b\u00107\u001a\u00020!H\u0016J\u0012\u00108\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0006\u00109\u001a\u00020-J\u000e\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\fJ\u0010\u0010<\u001a\u00020-2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010=\u001a\u00020-2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u0019J\u0016\u0010@\u001a\u00020-2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007J\u0010\u0010A\u001a\u00020-2\b\b\u0002\u0010B\u001a\u00020CJ&\u0010D\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010?2\b\u0010F\u001a\u0004\u0018\u0001002\b\u0010G\u001a\u0004\u0018\u00010HH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/baidu/searchbox/praise/commentemoji/widget/CommentEmojiContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentViewPosition", "Lcom/baidu/searchbox/praise/emojiinterface/CommentViewPosition;", "emojiCallback", "Lcom/baidu/searchbox/praise/commentemoji/widget/CommentEmojiContainer$EmojiCallback;", "emojiScaleAnim", "Lcom/baidu/searchbox/praise/commentemoji/animation/CommentEmojiTouchScaleAnim;", "getEmojiScaleAnim", "()Lcom/baidu/searchbox/praise/commentemoji/animation/CommentEmojiTouchScaleAnim;", "emojiScaleAnim$delegate", "Lkotlin/Lazy;", "emojiSendAnim", "Lcom/baidu/searchbox/praise/commentemoji/animation/CommentEmojiSendAnim;", "getEmojiSendAnim", "()Lcom/baidu/searchbox/praise/commentemoji/animation/CommentEmojiSendAnim;", "emojiSendAnim$delegate", "emojiViewList", "", "Lcom/baidu/searchbox/praise/commentemoji/widget/CommentEmojiAnimView;", "gesture", "Landroidx/core/view/GestureDetectorCompat;", "getGesture", "()Landroidx/core/view/GestureDetectorCompat;", "gesture$delegate", "isLongPress", "", "()Z", "setLongPress", "(Z)V", "isSending", "isShowEmojiAnim", "setShowEmojiAnim", "upEvent", "Landroid/view/MotionEvent;", "windowLeftMargin", "windowTopMargin", "cancelSendAnim", "", "clickView", "view", "Landroid/view/View;", "findTouchPointView", "ev", "isSendAnimShowing", "isTouchPointInView", "onTouchEvent", "event", "performClick", "playScaleAnim", "release", "setCallback", "callback", "setCommentIconPos", "setData", "emojiResList", "Lcom/baidu/searchbox/praise/commentemoji/data/CommentEmojiRes;", "setWindowMargin", "showEmojiAnim", "totalTime", "", "startEmojiSendAnim", "emojiRes", "emojiView", "endPoint", "Landroid/graphics/PointF;", "EmojiCallback", "lib-praise-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentEmojiContainer.kt */
public final class CommentEmojiContainer extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private CommentViewPosition commentViewPosition;
    /* access modifiers changed from: private */
    public EmojiCallback emojiCallback;
    private final Lazy emojiScaleAnim$delegate;
    private final Lazy emojiSendAnim$delegate;
    /* access modifiers changed from: private */
    public List<CommentEmojiAnimView> emojiViewList;
    private final Lazy gesture$delegate;
    private boolean isLongPress;
    private boolean isSending;
    private boolean isShowEmojiAnim;
    private MotionEvent upEvent;
    private int windowLeftMargin;
    private int windowTopMargin;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/praise/commentemoji/widget/CommentEmojiContainer$EmojiCallback;", "", "getPageContainer", "Landroid/view/ViewGroup;", "getSendEmojiEndPoint", "Landroid/graphics/PointF;", "onDraggingEnd", "", "onDraggingStart", "onEmojiClick", "emojiRes", "Lcom/baidu/searchbox/praise/commentemoji/data/CommentEmojiRes;", "emojiView", "Landroid/view/View;", "onSendEmojiAnimEnd", "emojiName", "", "emojiUrl", "lib-praise-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentEmojiContainer.kt */
    public interface EmojiCallback {
        ViewGroup getPageContainer();

        PointF getSendEmojiEndPoint();

        void onDraggingEnd();

        void onDraggingStart();

        void onEmojiClick(CommentEmojiRes commentEmojiRes, View view2);

        void onSendEmojiAnimEnd(String str, String str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommentEmojiContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommentEmojiContainer(Context context, AttributeSet attributeSet) {
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
    public CommentEmojiContainer(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.emojiViewList = new ArrayList();
        this.gesture$delegate = LazyKt.lazy(new CommentEmojiContainer$gesture$2(context, this));
        this.emojiScaleAnim$delegate = LazyKt.lazy(new CommentEmojiContainer$emojiScaleAnim$2(this));
        this.emojiSendAnim$delegate = LazyKt.lazy(new CommentEmojiContainer$emojiSendAnim$2(context, this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentEmojiContainer(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final boolean isShowEmojiAnim() {
        return this.isShowEmojiAnim;
    }

    public final void setShowEmojiAnim(boolean z) {
        this.isShowEmojiAnim = z;
    }

    public final boolean isLongPress() {
        return this.isLongPress;
    }

    public final void setLongPress(boolean z) {
        this.isLongPress = z;
    }

    private final GestureDetectorCompat getGesture() {
        return (GestureDetectorCompat) this.gesture$delegate.getValue();
    }

    private final CommentEmojiTouchScaleAnim getEmojiScaleAnim() {
        return (CommentEmojiTouchScaleAnim) this.emojiScaleAnim$delegate.getValue();
    }

    private final CommentEmojiSendAnim getEmojiSendAnim() {
        return (CommentEmojiSendAnim) this.emojiSendAnim$delegate.getValue();
    }

    public final void setData(List<CommentEmojiRes> emojiResList) {
        int width;
        if ((emojiResList != null ? emojiResList.size() : 0) >= 4) {
            int width2 = getContext().getResources().getDimensionPixelSize(R.dimen.praise_comment_emoji_view_width);
            int height = getContext().getResources().getDimensionPixelSize(R.dimen.praise_comment_emoji_view_width);
            removeAllViews();
            if (emojiResList != null) {
                for (CommentEmojiRes emojiInfo : emojiResList) {
                    LinearLayout.LayoutParams itemLayoutParams = new LinearLayout.LayoutParams(width2, height);
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    CommentEmojiAnimView emojiView = new CommentEmojiAnimView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                    CommentEmojiAnimView $this$setData_u24lambda_u2d2_u24lambda_u2d1 = emojiView;
                    $this$setData_u24lambda_u2d2_u24lambda_u2d1.loadImage(emojiInfo);
                    $this$setData_u24lambda_u2d2_u24lambda_u2d1.setLayoutParams(itemLayoutParams);
                    ViewGroup.LayoutParams layoutParams = $this$setData_u24lambda_u2d2_u24lambda_u2d1.getLayoutParams();
                    LinearLayout.LayoutParams $this$setData_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                    if ($this$setData_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 != null) {
                        width = width2;
                        int marginSpace = $this$setData_u24lambda_u2d2_u24lambda_u2d1.getResources().getDimensionPixelSize(R.dimen.praise_comment_emoji_space);
                        $this$setData_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.leftMargin = marginSpace;
                        $this$setData_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.rightMargin = marginSpace;
                    } else {
                        width = width2;
                    }
                    if (this.isShowEmojiAnim) {
                        $this$setData_u24lambda_u2d2_u24lambda_u2d1.startSizeScale();
                    }
                    this.emojiViewList.add(emojiView);
                    addView(emojiView);
                    width2 = width;
                }
                return;
            }
        }
    }

    public final void setCallback(EmojiCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.emojiCallback = callback;
    }

    public final void setWindowMargin(int windowLeftMargin2, int windowTopMargin2) {
        this.windowTopMargin = windowTopMargin2;
        this.windowLeftMargin = windowLeftMargin2;
    }

    public final void setCommentIconPos(CommentViewPosition commentViewPosition2) {
        this.commentViewPosition = commentViewPosition2;
    }

    public static /* synthetic */ void showEmojiAnim$default(CommentEmojiContainer commentEmojiContainer, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 0;
        }
        commentEmojiContainer.showEmojiAnim(j2);
    }

    public final void showEmojiAnim(long totalTime) {
        if (!this.emojiViewList.isEmpty()) {
            for (int i2 = CollectionsKt.getLastIndex(this.emojiViewList); -1 < i2; i2--) {
                this.emojiViewList.get(i2).startAnimation((((long) ((this.emojiViewList.size() - i2) - 1)) * totalTime) / ((long) 3));
            }
        }
    }

    private final void startEmojiSendAnim(CommentEmojiRes emojiRes, View emojiView, PointF endPoint) {
        this.isSending = false;
        if (emojiView != null) {
            getEmojiSendAnim().start(new PointF((float) (this.windowLeftMargin + emojiView.getLeft()), (float) (this.windowTopMargin + emojiView.getTop())), endPoint, emojiRes, (!(emojiView instanceof CommentEmojiAnimView) || !((CommentEmojiAnimView) emojiView).isEmojiResUrl()) ? null : ((CommentEmojiAnimView) emojiView).getDrawable());
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event == null) {
            return super.onTouchEvent(event);
        }
        getGesture().onTouchEvent(event);
        switch (event.getAction()) {
            case 1:
                this.isLongPress = false;
                EmojiCallback emojiCallback2 = this.emojiCallback;
                if (emojiCallback2 != null) {
                    emojiCallback2.onDraggingEnd();
                }
                this.upEvent = MotionEvent.obtain(event);
                performClick();
                return true;
            case 2:
                if (!this.isLongPress) {
                    return true;
                }
                playScaleAnim(findTouchPointView(event));
                return true;
            case 3:
                this.isLongPress = false;
                EmojiCallback emojiCallback3 = this.emojiCallback;
                if (emojiCallback3 != null) {
                    emojiCallback3.onDraggingEnd();
                }
                this.upEvent = null;
                return true;
            default:
                return true;
        }
    }

    public boolean performClick() {
        clickView(findTouchPointView(this.upEvent));
        this.upEvent = null;
        return super.performClick();
    }

    private final void clickView(View view2) {
        View sendView;
        CommentViewPosition position;
        EmojiCallback emojiCallback2;
        if (view2 == null) {
            CommentEmojiTouchScaleAnim emojiScaleAnim = getEmojiScaleAnim();
            sendView = emojiScaleAnim != null ? emojiScaleAnim.getCurrentScaleView() : null;
        } else {
            sendView = view2;
        }
        CommentEmojiTouchScaleAnim emojiScaleAnim2 = getEmojiScaleAnim();
        if (emojiScaleAnim2 != null) {
            emojiScaleAnim2.resetAllScaleStatus(true);
        }
        if (sendView != null && this.commentViewPosition != null && !this.isSending) {
            this.isSending = true;
            if (sendView instanceof CommentEmojiAnimView) {
                CommentEmojiRes res = ((CommentEmojiAnimView) sendView).getEmojiRes();
                if (!(res == null || (emojiCallback2 = this.emojiCallback) == null)) {
                    emojiCallback2.onEmojiClick(res, sendView);
                }
                if (((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin(2) && (position = this.commentViewPosition) != null) {
                    startEmojiSendAnim(((CommentEmojiAnimView) sendView).getEmojiRes(), sendView, new PointF((float) position.getXInWindow(), (float) position.getYInWindow()));
                }
            }
        }
    }

    public final void release() {
        CommentEmojiTouchScaleAnim emojiScaleAnim = getEmojiScaleAnim();
        if (emojiScaleAnim != null) {
            emojiScaleAnim.resetAllScaleStatus(false);
        }
    }

    /* access modifiers changed from: private */
    public final void playScaleAnim(View view2) {
        CommentEmojiTouchScaleAnim emojiScaleAnim = getEmojiScaleAnim();
        if (emojiScaleAnim != null) {
            emojiScaleAnim.start(view2);
        }
    }

    /* access modifiers changed from: private */
    public final View findTouchPointView(MotionEvent ev) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view2 = getChildAt(i2);
            if (view2 != null && isTouchPointInView(view2, ev)) {
                return view2;
            }
        }
        return null;
    }

    private final boolean isTouchPointInView(View view2, MotionEvent ev) {
        if (ev == null || view2 == null) {
            return false;
        }
        return EmojiWidgetUtilsKt.isContainMotion(EmojiWidgetUtilsKt.getHotSpot(view2), ev);
    }

    public final boolean isSendAnimShowing() {
        return getEmojiSendAnim().isSendAnimShowing();
    }

    public final void cancelSendAnim() {
        getEmojiSendAnim().cancel();
    }
}
