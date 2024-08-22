package com.baidu.searchbox.feed.topicdetail.view.banner;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.feed.topicdetail.R;
import com.baidu.searchbox.feed.topicdetail.bean.TopicBannerInfo;
import com.baidu.searchbox.feed.topicdetail.ubc.TopicUbcUtilsKt;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010,\u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/searchbox/feed/topicdetail/view/banner/TopicBannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bannerData", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/topicdetail/bean/TopicBannerInfo$TopicBannerItemInfo;", "Lkotlin/collections/ArrayList;", "bannerHasShownList", "", "", "curPage", "mAdapter", "Lcom/baidu/searchbox/feed/topicdetail/view/banner/BannerVpAdapter;", "mHandler", "Landroid/os/Handler;", "mIndicatorView", "Lcom/baidu/searchbox/feed/topicdetail/view/banner/BannerIndicatorView;", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "topicId", "", "vpWidth", "getStartItem", "size", "initHandler", "", "initPageChangeListener", "reportShowUbcIfNeeded", "position", "setBannerVpScroller", "setCorner", "view", "Landroid/view/View;", "radius", "", "update", "data", "Lcom/baidu/searchbox/feed/topicdetail/bean/TopicBannerInfo;", "updateVpHeight", "Companion", "lib-feed-topic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopicBannerView.kt */
public final class TopicBannerView extends FrameLayout {
    private static final long ANIM_DELAY = 5000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MSG_TRANSFER = 0;
    private static final int SCROLL_DURATION = 300;
    private static final String SCROLL_FIELD = "mScroller";
    private static final String TAG = "TopicBannerView";
    private static final float VP_RATIO = 0.206f;
    private final AttributeSet attrs;
    /* access modifiers changed from: private */
    public ArrayList<TopicBannerInfo.TopicBannerItemInfo> bannerData;
    private List<Boolean> bannerHasShownList;
    /* access modifiers changed from: private */
    public int curPage;
    private BannerVpAdapter mAdapter;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private BannerIndicatorView mIndicatorView;
    /* access modifiers changed from: private */
    public ViewPager mViewPager;
    private String topicId;
    private int vpWidth;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicBannerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopicBannerView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicBannerView(Context context, AttributeSet attrs2, int defStyle) {
        super(context, attrs2, defStyle);
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(context, "context");
        this.attrs = attrs2;
        this.topicId = "";
        this.curPage = -1;
        LayoutInflater.from(context).inflate(R.layout.topic_detail_banner_view, this, true);
        this.mViewPager = (ViewPager) findViewById(R.id.banner_viewpager);
        this.mIndicatorView = (BannerIndicatorView) findViewById(R.id.banner_indicator);
        ViewPager viewPager = this.mViewPager;
        Intrinsics.checkNotNull(viewPager);
        setCorner(viewPager, (float) context.getResources().getDimensionPixelSize(R.dimen.banner_item_border_radius));
        setBannerVpScroller();
        initHandler();
        this.vpWidth = DeviceUtils.ScreenInfo.getDisplayWidth(context) - (getResources().getDimensionPixelOffset(R.dimen.banner_viewpager_margin) * 2);
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null && (viewTreeObserver = viewPager2.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new TopicBannerView$$ExternalSyntheticLambda0(this));
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/topicdetail/view/banner/TopicBannerView$Companion;", "", "()V", "ANIM_DELAY", "", "MSG_TRANSFER", "", "SCROLL_DURATION", "SCROLL_FIELD", "", "TAG", "VP_RATIO", "", "lib-feed-topic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TopicBannerView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m19613_init_$lambda0(TopicBannerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reportShowUbcIfNeeded(this$0.curPage);
    }

    private final void setBannerVpScroller() {
        Field scrollField = ViewPager.class.getDeclaredField(SCROLL_FIELD);
        scrollField.setAccessible(true);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        BannerScroller scroller = new BannerScroller(context, new DecelerateInterpolator());
        scroller.setDuration(300);
        scrollField.set(this.mViewPager, scroller);
    }

    private final void initHandler() {
        this.mHandler = new TopicBannerView$initHandler$1(this, Looper.getMainLooper());
    }

    public final void update(TopicBannerInfo data, String topicId2) {
        Handler handler = null;
        if (Intrinsics.areEqual((Object) data != null ? data.getBannerType() : null, (Object) "0")) {
            ArrayList<TopicBannerInfo.TopicBannerItemInfo> bannerInfo = data.getBannerInfo();
            if ((bannerInfo != null ? bannerInfo.size() : -1) > 0) {
                setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC9));
                ViewPager viewPager = this.mViewPager;
                if (viewPager != null) {
                    viewPager.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC12));
                }
                BannerIndicatorView bannerIndicatorView = this.mIndicatorView;
                if (bannerIndicatorView != null) {
                    bannerIndicatorView.updateColor();
                }
                BannerVpAdapter bannerVpAdapter = this.mAdapter;
                if (bannerVpAdapter != null) {
                    bannerVpAdapter.notifyDataSetChanged();
                }
                if (this.mAdapter == null) {
                    this.bannerData = data.getBannerInfo();
                    this.topicId = topicId2 == null ? "" : topicId2;
                    updateVpHeight();
                    setVisibility(0);
                    ArrayList<TopicBannerInfo.TopicBannerItemInfo> arrayList = this.bannerData;
                    Intrinsics.checkNotNull(arrayList);
                    int size = arrayList.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        int i3 = i2;
                        arrayList2.add(false);
                    }
                    this.bannerHasShownList = arrayList2;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ArrayList<TopicBannerInfo.TopicBannerItemInfo> arrayList3 = this.bannerData;
                    Intrinsics.checkNotNull(arrayList3);
                    BannerVpAdapter bannerVpAdapter2 = new BannerVpAdapter(context, arrayList3, this.topicId);
                    BannerVpAdapter $this$update_u24lambda_u2d2 = bannerVpAdapter2;
                    ViewPager viewPager2 = this.mViewPager;
                    if (viewPager2 != null) {
                        viewPager2.setAdapter($this$update_u24lambda_u2d2);
                    }
                    this.mAdapter = bannerVpAdapter2;
                    initPageChangeListener();
                    ViewPager viewPager3 = this.mViewPager;
                    if (viewPager3 != null) {
                        ArrayList<TopicBannerInfo.TopicBannerItemInfo> arrayList4 = this.bannerData;
                        Intrinsics.checkNotNull(arrayList4);
                        viewPager3.setCurrentItem(getStartItem(arrayList4.size()));
                    }
                    this.curPage = 0;
                    BannerIndicatorView bannerIndicatorView2 = this.mIndicatorView;
                    if (bannerIndicatorView2 != null) {
                        ViewPager viewPager4 = this.mViewPager;
                        Intrinsics.checkNotNull(viewPager4);
                        bannerIndicatorView2.addViewPager(viewPager4);
                    }
                    Handler handler2 = this.mHandler;
                    if (handler2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHandler");
                    } else {
                        handler = handler2;
                    }
                    handler.sendEmptyMessageDelayed(0, 5000);
                }
            }
        }
    }

    private final void updateVpHeight() {
        ViewPager viewPager = this.mViewPager;
        ViewGroup.LayoutParams vpParams = viewPager != null ? viewPager.getLayoutParams() : null;
        if (vpParams != null) {
            vpParams.width = this.vpWidth;
        }
        if (vpParams != null) {
            vpParams.height = (int) (((float) this.vpWidth) * VP_RATIO);
        }
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            viewPager2.setLayoutParams(vpParams);
        }
    }

    private final void reportShowUbcIfNeeded(int position) {
        if (this.bannerHasShownList != null) {
            Rect rect = new Rect();
            List<Boolean> list = this.bannerHasShownList;
            Intrinsics.checkNotNull(list);
            if (!list.get(position).booleanValue() && getGlobalVisibleRect(rect)) {
                String str = this.topicId;
                ArrayList<TopicBannerInfo.TopicBannerItemInfo> arrayList = this.bannerData;
                Intrinsics.checkNotNull(arrayList);
                TopicUbcUtilsKt.topicBannerStatisticsUbc("show", str, arrayList.get(position).getBannerId());
                List<Boolean> list2 = this.bannerHasShownList;
                Intrinsics.checkNotNull(list2);
                list2.set(position, true);
            }
        }
    }

    private final void initPageChangeListener() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new TopicBannerView$initPageChangeListener$1(this));
        }
    }

    private final void setCorner(View view2, float radius) {
        view2.setOutlineProvider(new TopicBannerView$setCorner$1(radius));
        view2.setClipToOutline(true);
    }

    private final int getStartItem(int size) {
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        BannerVpAdapter bannerVpAdapter = this.mAdapter;
        if (bannerVpAdapter != null) {
            i2 = bannerVpAdapter.getCount();
        }
        int currentItem = i2 / 2;
        if (currentItem % size == 0) {
            return currentItem;
        }
        while (currentItem % size != 0) {
            currentItem++;
        }
        return currentItem;
    }
}
