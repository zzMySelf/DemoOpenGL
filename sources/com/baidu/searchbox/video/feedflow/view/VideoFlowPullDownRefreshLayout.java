package com.baidu.searchbox.video.feedflow.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.android.util.android.VibrateUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.view.VideoFlowRefreshHeaderView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001GB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010/\u001a\u0002002\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204\u0018\u000102J\b\u00105\u001a\u000200H\u0002J\b\u00106\u001a\u000200H\u0002J\u0010\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u000209H\u0016J0\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0014J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u000209H\u0017J\u0006\u0010B\u001a\u000200J\u0006\u0010C\u001a\u000200J\u0010\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020!H\u0002J\b\u0010F\u001a\u000200H\u0003R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/VideoFlowPullDownRefreshLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "headerView", "Lcom/baidu/searchbox/video/feedflow/view/VideoFlowRefreshHeaderView;", "headerViewTopMargin", "iOnInterceptTouchEventInterceptor", "Lcom/baidu/searchbox/video/feedflow/view/VideoFlowPullDownRefreshLayout$IonInterceptTouchEventInterceptor;", "getIOnInterceptTouchEventInterceptor", "()Lcom/baidu/searchbox/video/feedflow/view/VideoFlowPullDownRefreshLayout$IonInterceptTouchEventInterceptor;", "setIOnInterceptTouchEventInterceptor", "(Lcom/baidu/searchbox/video/feedflow/view/VideoFlowPullDownRefreshLayout$IonInterceptTouchEventInterceptor;)V", "iPullDownRefreshListener", "Lcom/baidu/searchbox/video/feedflow/view/IPullDownRefreshListener;", "getIPullDownRefreshListener", "()Lcom/baidu/searchbox/video/feedflow/view/IPullDownRefreshListener;", "setIPullDownRefreshListener", "(Lcom/baidu/searchbox/video/feedflow/view/IPullDownRefreshListener;)V", "isDragging", "", "isRefreshEnable", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setRefreshEnable", "(Lkotlin/jvm/functions/Function0;)V", "isRefreshStarted", "lastDownX", "", "lastDownY", "maxPullRange", "overMax", "refreshCircleColor", "refreshCircleRadius", "refreshHeaderViewHeight", "refreshText", "", "refreshTextColor", "refreshTextOffset", "refreshTextSize", "touchSlop", "vibratePlayed", "autoRefresh", "", "extend", "", "", "", "ensureTarget", "onDragStarted", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onTouchEvent", "e", "onViewDestroy", "refreshComplete", "updateIconTranslationYAndAlpha", "progress", "vibrateIfNecessary", "IonInterceptTouchEventInterceptor", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowPullDownRefreshLayout.kt */
public final class VideoFlowPullDownRefreshLayout extends FrameLayout {
    private VideoFlowRefreshHeaderView headerView;
    private int headerViewTopMargin;
    private IonInterceptTouchEventInterceptor iOnInterceptTouchEventInterceptor;
    private IPullDownRefreshListener iPullDownRefreshListener;
    private boolean isDragging;
    private Function0<Boolean> isRefreshEnable;
    /* access modifiers changed from: private */
    public boolean isRefreshStarted;
    private float lastDownX;
    private float lastDownY;
    private float maxPullRange;
    private boolean overMax;
    private int refreshCircleColor;
    private float refreshCircleRadius;
    private int refreshHeaderViewHeight;
    private CharSequence refreshText;
    private int refreshTextColor;
    private float refreshTextOffset;
    private float refreshTextSize;
    private int touchSlop;
    private boolean vibratePlayed;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/VideoFlowPullDownRefreshLayout$IonInterceptTouchEventInterceptor;", "", "disallowOnInterceptTouchEvent", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoFlowPullDownRefreshLayout.kt */
    public interface IonInterceptTouchEventInterceptor {
        boolean disallowOnInterceptTouchEvent();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoFlowPullDownRefreshLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoFlowPullDownRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoFlowPullDownRefreshLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoFlowPullDownRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.refreshHeaderViewHeight = DIFactory.INSTANCE.dp2px(38.0f);
        this.headerViewTopMargin = DIFactory.INSTANCE.getStatusBarHeight();
        this.maxPullRange = (float) DIFactory.INSTANCE.dp2px(100.0f);
        this.refreshTextColor = -1;
        this.refreshCircleColor = -1;
        this.refreshText = "";
        this.refreshTextSize = (float) DIFactory.INSTANCE.dp2px(15.0f);
        this.refreshCircleRadius = (float) DIFactory.INSTANCE.dp2px(7.5f);
        this.refreshTextOffset = (float) DIFactory.INSTANCE.dp2px(10.0f);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.VideoFlowPullDownRefreshLayout);
        Intrinsics.checkNotNullExpressionValue(typedArray, "context.obtainStyledAttr…lowPullDownRefreshLayout)");
        this.refreshHeaderViewHeight = typedArray.getDimensionPixelSize(R.styleable.VideoFlowPullDownRefreshLayout_video_flow_headerHeight, this.refreshHeaderViewHeight);
        this.maxPullRange = typedArray.getDimension(R.styleable.VideoFlowPullDownRefreshLayout_video_flow_refresh_pullRange, this.maxPullRange);
        this.headerViewTopMargin = typedArray.getDimensionPixelSize(R.styleable.VideoFlowPullDownRefreshLayout_video_flow_headerTopMargin, this.headerViewTopMargin);
        CharSequence text = typedArray.getText(R.styleable.VideoFlowPullDownRefreshLayout_video_flow_refreshText);
        if (text == null) {
            text = getResources().getText(R.string.video_flow_refresh_pull_down_hint);
            Intrinsics.checkNotNullExpressionValue(text, "resources.getText(R.stri…w_refresh_pull_down_hint)");
        }
        this.refreshText = text;
        this.refreshTextSize = typedArray.getDimension(R.styleable.VideoFlowPullDownRefreshLayout_video_flow_refreshTextSize, this.refreshTextSize);
        this.refreshTextColor = typedArray.getColor(R.styleable.VideoFlowPullDownRefreshLayout_video_flow_refreshTextColor, this.refreshTextColor);
        this.refreshCircleColor = typedArray.getColor(R.styleable.VideoFlowPullDownRefreshLayout_video_flow_refreshCircleColor, this.refreshCircleColor);
        this.refreshCircleRadius = typedArray.getDimension(R.styleable.VideoFlowPullDownRefreshLayout_video_flow_refreshCircleRadius, this.refreshCircleRadius);
        typedArray.recycle();
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView = new VideoFlowRefreshHeaderView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.headerView = videoFlowRefreshHeaderView;
        videoFlowRefreshHeaderView.setRefreshCircleColor(this.refreshCircleColor);
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView2 = this.headerView;
        if (videoFlowRefreshHeaderView2 != null) {
            videoFlowRefreshHeaderView2.setRefreshCircleRadius(this.refreshCircleRadius);
        }
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView3 = this.headerView;
        if (videoFlowRefreshHeaderView3 != null) {
            videoFlowRefreshHeaderView3.setRefreshText(this.refreshText);
        }
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView4 = this.headerView;
        if (videoFlowRefreshHeaderView4 != null) {
            videoFlowRefreshHeaderView4.setRefreshTextColor(this.refreshTextColor);
        }
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView5 = this.headerView;
        if (videoFlowRefreshHeaderView5 != null) {
            videoFlowRefreshHeaderView5.setRefreshTextSize(this.refreshTextSize);
        }
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView6 = this.headerView;
        if (videoFlowRefreshHeaderView6 != null) {
            videoFlowRefreshHeaderView6.setRefreshTextOffset(this.refreshTextOffset);
        }
        FrameLayout.LayoutParams $this$_init__u24lambda_u2d0 = new FrameLayout.LayoutParams(-1, this.refreshHeaderViewHeight);
        $this$_init__u24lambda_u2d0.topMargin = this.headerViewTopMargin;
        Unit unit = Unit.INSTANCE;
        addView(this.headerView, $this$_init__u24lambda_u2d0);
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView7 = this.headerView;
        if (videoFlowRefreshHeaderView7 != null) {
            videoFlowRefreshHeaderView7.setRefreshListener(new VideoFlowRefreshHeaderView.RefreshStateListener(this) {
                final /* synthetic */ VideoFlowPullDownRefreshLayout this$0;

                {
                    this.this$0 = $receiver;
                }

                public void onRefresh(boolean isPullDownRefresh, Map<String, ? extends Object> extend) {
                    this.this$0.isRefreshStarted = true;
                    IPullDownRefreshListener iPullDownRefreshListener = this.this$0.getIPullDownRefreshListener();
                    if (iPullDownRefreshListener != null) {
                        iPullDownRefreshListener.onRefreshStarted(isPullDownRefresh, extend);
                    }
                }

                public void onUpdate(float progress) {
                    this.this$0.updateIconTranslationYAndAlpha(progress);
                }
            });
        }
    }

    public final IonInterceptTouchEventInterceptor getIOnInterceptTouchEventInterceptor() {
        return this.iOnInterceptTouchEventInterceptor;
    }

    public final void setIOnInterceptTouchEventInterceptor(IonInterceptTouchEventInterceptor ionInterceptTouchEventInterceptor) {
        this.iOnInterceptTouchEventInterceptor = ionInterceptTouchEventInterceptor;
    }

    public final IPullDownRefreshListener getIPullDownRefreshListener() {
        return this.iPullDownRefreshListener;
    }

    public final void setIPullDownRefreshListener(IPullDownRefreshListener iPullDownRefreshListener2) {
        this.iPullDownRefreshListener = iPullDownRefreshListener2;
    }

    public final Function0<Boolean> isRefreshEnable() {
        return this.isRefreshEnable;
    }

    public final void setRefreshEnable(Function0<Boolean> function0) {
        this.isRefreshEnable = function0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ensureTarget();
        super.onLayout(changed, left, top, right, bottom);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        Function0<Boolean> function0 = this.isRefreshEnable;
        if (function0 != null && !function0.invoke().booleanValue()) {
            return false;
        }
        IonInterceptTouchEventInterceptor ionInterceptTouchEventInterceptor = this.iOnInterceptTouchEventInterceptor;
        if (ionInterceptTouchEventInterceptor != null && ionInterceptTouchEventInterceptor.disallowOnInterceptTouchEvent()) {
            return false;
        }
        switch (ev.getActionMasked()) {
            case 0:
                this.isDragging = false;
                this.lastDownY = ev.getY();
                this.lastDownX = ev.getX();
                break;
            case 2:
                float deltaY = ev.getY() - this.lastDownY;
                if (Math.abs(deltaY) > Math.abs(ev.getX() - this.lastDownX) && deltaY > ((float) this.touchSlop) && !this.isDragging) {
                    this.isDragging = true;
                    onDragStarted();
                    break;
                }
            default:
                this.isDragging = false;
                break;
        }
        return this.isDragging;
    }

    private final void onDragStarted() {
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView = this.headerView;
        if (videoFlowRefreshHeaderView != null) {
            videoFlowRefreshHeaderView.stopAnimator();
        }
    }

    public boolean onTouchEvent(MotionEvent e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        Function0<Boolean> function0 = this.isRefreshEnable;
        boolean z = false;
        if (function0 != null && !function0.invoke().booleanValue()) {
            return false;
        }
        float downX = e2.getX();
        float downY = e2.getY();
        switch (e2.getActionMasked()) {
            case 0:
                VideoFlowRefreshHeaderView videoFlowRefreshHeaderView = this.headerView;
                if (videoFlowRefreshHeaderView != null) {
                    videoFlowRefreshHeaderView.stopAnimator();
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.overMax) {
                    VideoFlowRefreshHeaderView videoFlowRefreshHeaderView2 = this.headerView;
                    if (videoFlowRefreshHeaderView2 != null) {
                        VideoFlowRefreshHeaderView.reverseWithLoading$default(videoFlowRefreshHeaderView2, false, (Map) null, 3, (Object) null);
                    }
                } else {
                    VideoFlowRefreshHeaderView videoFlowRefreshHeaderView3 = this.headerView;
                    if (videoFlowRefreshHeaderView3 != null) {
                        videoFlowRefreshHeaderView3.reverse();
                    }
                }
                this.overMax = false;
                this.vibratePlayed = false;
                this.lastDownX = downX;
                this.lastDownY = downY;
                break;
            case 2:
                float deltaY = downY - this.lastDownY;
                if (Math.abs(deltaY) > Math.abs(downX - this.lastDownX) && deltaY > ((float) this.touchSlop)) {
                    float deltaY2 = Math.min(deltaY, this.maxPullRange);
                    float progress = deltaY2 / this.maxPullRange;
                    VideoFlowRefreshHeaderView videoFlowRefreshHeaderView4 = this.headerView;
                    if (videoFlowRefreshHeaderView4 != null) {
                        videoFlowRefreshHeaderView4.updateTextShowFraction(progress);
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    updateIconTranslationYAndAlpha(progress);
                    if (deltaY2 == this.maxPullRange) {
                        z = true;
                    }
                    this.overMax = z;
                    if (z && !this.vibratePlayed) {
                        vibrateIfNecessary();
                        break;
                    }
                }
        }
        return true;
    }

    private final void ensureTarget() {
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView = this.headerView;
        if (videoFlowRefreshHeaderView != null) {
            videoFlowRefreshHeaderView.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    public final void updateIconTranslationYAndAlpha(float progress) {
        IPullDownRefreshListener iPullDownRefreshListener2 = this.iPullDownRefreshListener;
        if (iPullDownRefreshListener2 != null) {
            iPullDownRefreshListener2.onRefreshViewShowUpdate(progress);
        }
    }

    private final void vibrateIfNecessary() {
        this.vibratePlayed = true;
        Object systemService = getContext().getSystemService("vibrator");
        if (systemService != null) {
            VibrateUtils vibratorUtils = new VibrateUtils.Builder((Vibrator) systemService, new long[]{10}, getContext()).amplitudes(new int[]{-1}).build();
            Intrinsics.checkNotNullExpressionValue(vibratorUtils, "Builder(\n               …\n                .build()");
            vibratorUtils.vibrateStart();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }

    public static /* synthetic */ void autoRefresh$default(VideoFlowPullDownRefreshLayout videoFlowPullDownRefreshLayout, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = null;
        }
        videoFlowPullDownRefreshLayout.autoRefresh(map);
    }

    public final void autoRefresh(Map<String, ? extends Object> extend) {
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView = this.headerView;
        if (videoFlowRefreshHeaderView != null) {
            videoFlowRefreshHeaderView.play(extend);
        }
    }

    public final void refreshComplete() {
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView = this.headerView;
        if (videoFlowRefreshHeaderView != null) {
            VideoFlowRefreshHeaderView.finishRefresh$default(videoFlowRefreshHeaderView, 0, 1, (Object) null);
        }
        if (this.isRefreshStarted) {
            this.isRefreshStarted = false;
            IPullDownRefreshListener iPullDownRefreshListener2 = this.iPullDownRefreshListener;
            if (iPullDownRefreshListener2 != null) {
                iPullDownRefreshListener2.onRefreshCompleted();
            }
        }
    }

    public final void onViewDestroy() {
        VideoFlowRefreshHeaderView videoFlowRefreshHeaderView = this.headerView;
        if (videoFlowRefreshHeaderView != null) {
            videoFlowRefreshHeaderView.onViewDestroy();
        }
    }
}
