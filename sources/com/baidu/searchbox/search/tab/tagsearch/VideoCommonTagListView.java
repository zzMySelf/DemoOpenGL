package com.baidu.searchbox.search.tab.tagsearch;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.search.tab.core.manager.IComponentManager;
import com.baidu.searchbox.search.tab.implement.service.ISubTabCacheService;
import com.baidu.searchbox.search.tab.implement.utils.VideoFontUtilsKt;
import com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel;
import com.baidu.searchbox.search.tab.utils.ColorUtils;
import com.baidu.searchbox.search.video.business.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u0007H\u0002J3\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\f2\b\u0010N\u001a\u0004\u0018\u00010\u00122\b\u0010O\u001a\u0004\u0018\u00010\u00122\u0006\u0010P\u001a\u00020QH\u0002¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020LH\u0002J\b\u0010T\u001a\u00020LH\u0003J\u000e\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020WJ\u0016\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020L2\b\u0010\\\u001a\u0004\u0018\u00010\u0003H\u0016J\u0006\u0010]\u001a\u00020LJ\b\u0010^\u001a\u00020LH\u0007J\u0012\u0010_\u001a\u00020\f2\b\b\u0001\u0010`\u001a\u00020\fH\u0002J\b\u0010a\u001a\u00020LH\u0007J\u0018\u0010b\u001a\u00020L2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\fH\u0002J\u000e\u0010e\u001a\u00020L2\u0006\u0010f\u001a\u00020\nJ)\u0010g\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\f2\b\u0010N\u001a\u0004\u0018\u00010\u00122\b\u0010O\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020L2\u0006\u0010j\u001a\u00020\fJ\u0010\u0010k\u001a\u00020L2\u0006\u0010\\\u001a\u00020\u0003H\u0002J\u0010\u0010l\u001a\u00020L2\u0006\u0010d\u001a\u00020\fH\u0002J\u0006\u0010m\u001a\u00020LJ\u0010\u0010n\u001a\u00020L2\u0006\u0010d\u001a\u00020\fH\u0002J\u0012\u0010o\u001a\u00020L2\b\u0010\\\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010p\u001a\u00020LH\u0002J\b\u0010q\u001a\u00020LH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001b\u0010&\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b'\u0010\u000eR\u001b\u0010)\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b*\u0010\u000eR\u000e\u0010,\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X.¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u0002068BX\u0002¢\u0006\f\n\u0004\b9\u0010\u001c\u001a\u0004\b7\u00108R\u001c\u0010:\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001b\u0010?\u001a\u00020@8BX\u0002¢\u0006\f\n\u0004\bC\u0010\u001c\u001a\u0004\bA\u0010BR\u000e\u0010D\u001a\u00020.X.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX.¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020.X.¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagListView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/Observer;", "Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel;", "context", "Landroid/content/Context;", "isLoftMode", "", "(Landroid/content/Context;Z)V", "componentManager", "Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;", "mBgHeight", "", "getMBgHeight", "()I", "setMBgHeight", "(I)V", "mEndColor", "", "getMEndColor", "()Ljava/lang/String;", "setMEndColor", "(Ljava/lang/String;)V", "mGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "getMGlobalLayoutListener", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mGlobalLayoutListener$delegate", "Lkotlin/Lazy;", "mStartColor", "getMStartColor", "setMStartColor", "mTagShadowGlobalPosition", "getMTagShadowGlobalPosition", "setMTagShadowGlobalPosition", "mTagShadowTopColor", "getMTagShadowTopColor", "setMTagShadowTopColor", "paddingHorizontal", "getPaddingHorizontal", "paddingHorizontal$delegate", "paddingHorizontalSubTab", "getPaddingHorizontalSubTab", "paddingHorizontalSubTab$delegate", "recycleViewRoot", "rightShadowParent", "Landroid/view/View;", "tag", "Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel$Tag;", "getTag", "()Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel$Tag;", "setTag", "(Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel$Tag;)V", "tagAdapter", "Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagViewAdapter;", "getTagAdapter", "()Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagViewAdapter;", "tagAdapter$delegate", "tagData", "getTagData", "()Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel;", "setTagData", "(Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagModel;)V", "tagLayoutManager", "Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagLayoutManager;", "getTagLayoutManager", "()Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagLayoutManager;", "tagLayoutManager$delegate", "tagLeftShadow", "tagRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "tagRightShadow", "buildGuideMask", "Landroid/graphics/drawable/GradientDrawable;", "horizontalLeft", "getPercentColor", "", "bgHeight", "startColor", "endColor", "tagSearchViewRect", "Landroid/graphics/Rect;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Rect;)V", "initAdapter", "initView", "isSlidAble", "ev", "Landroid/view/MotionEvent;", "marginRightForSelectView", "hasSubTab", "hasSortData", "onChanged", "data", "onDestroy", "onNightModeChanged", "parseColor", "color", "registerFontSizeChange", "scrollTabToPosition", "isClick", "position", "setManager", "manager", "setShadowInfo", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "setTagVisibility", "visibility", "showTagList", "tagItemClick", "unRegisterFontSizeChange", "updateSelectedTab", "updateTagCache", "updateUI", "updateViewFont", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonTagListView.kt */
public final class VideoCommonTagListView extends FrameLayout implements Observer<VideoCommonTagModel> {
    public Map<Integer, View> _$_findViewCache;
    private IComponentManager componentManager;
    /* access modifiers changed from: private */
    public boolean isLoftMode;
    private int mBgHeight;
    private String mEndColor;
    private final Lazy mGlobalLayoutListener$delegate;
    private String mStartColor;
    private int mTagShadowGlobalPosition;
    private int mTagShadowTopColor;
    private final Lazy paddingHorizontal$delegate;
    private final Lazy paddingHorizontalSubTab$delegate;
    private FrameLayout recycleViewRoot;
    private View rightShadowParent;
    private VideoCommonTagModel.Tag tag;
    private final Lazy tagAdapter$delegate;
    private VideoCommonTagModel tagData;
    private final Lazy tagLayoutManager$delegate;
    private View tagLeftShadow;
    private RecyclerView tagRecycleView;
    /* access modifiers changed from: private */
    public View tagRightShadow;

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
    public VideoCommonTagListView(Context context, boolean isLoftMode2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.isLoftMode = isLoftMode2;
        this.tagAdapter$delegate = LazyKt.lazy(new VideoCommonTagListView$tagAdapter$2(context, this));
        this.tagLayoutManager$delegate = LazyKt.lazy(new VideoCommonTagListView$tagLayoutManager$2(context));
        this.paddingHorizontal$delegate = LazyKt.lazy(VideoCommonTagListView$paddingHorizontal$2.INSTANCE);
        this.paddingHorizontalSubTab$delegate = LazyKt.lazy(VideoCommonTagListView$paddingHorizontalSubTab$2.INSTANCE);
        this.mGlobalLayoutListener$delegate = LazyKt.lazy(new VideoCommonTagListView$mGlobalLayoutListener$2(this));
        initView();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoCommonTagListView(Context context, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? false : z);
    }

    private final VideoCommonTagViewAdapter getTagAdapter() {
        return (VideoCommonTagViewAdapter) this.tagAdapter$delegate.getValue();
    }

    private final VideoCommonTagLayoutManager getTagLayoutManager() {
        return (VideoCommonTagLayoutManager) this.tagLayoutManager$delegate.getValue();
    }

    private final int getPaddingHorizontal() {
        return ((Number) this.paddingHorizontal$delegate.getValue()).intValue();
    }

    private final int getPaddingHorizontalSubTab() {
        return ((Number) this.paddingHorizontalSubTab$delegate.getValue()).intValue();
    }

    public final VideoCommonTagModel getTagData() {
        return this.tagData;
    }

    public final void setTagData(VideoCommonTagModel videoCommonTagModel) {
        this.tagData = videoCommonTagModel;
    }

    public final VideoCommonTagModel.Tag getTag() {
        return this.tag;
    }

    public final void setTag(VideoCommonTagModel.Tag tag2) {
        this.tag = tag2;
    }

    public final int getMTagShadowTopColor() {
        return this.mTagShadowTopColor;
    }

    public final void setMTagShadowTopColor(int i2) {
        this.mTagShadowTopColor = i2;
    }

    public final int getMTagShadowGlobalPosition() {
        return this.mTagShadowGlobalPosition;
    }

    public final void setMTagShadowGlobalPosition(int i2) {
        this.mTagShadowGlobalPosition = i2;
    }

    public final int getMBgHeight() {
        return this.mBgHeight;
    }

    public final void setMBgHeight(int i2) {
        this.mBgHeight = i2;
    }

    public final String getMStartColor() {
        return this.mStartColor;
    }

    public final void setMStartColor(String str) {
        this.mStartColor = str;
    }

    public final String getMEndColor() {
        return this.mEndColor;
    }

    public final void setMEndColor(String str) {
        this.mEndColor = str;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener getMGlobalLayoutListener() {
        return (ViewTreeObserver.OnGlobalLayoutListener) this.mGlobalLayoutListener$delegate.getValue();
    }

    private final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.search_tag_list_view, this, true);
        View findViewById = findViewById(R.id.search_tag_list_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.search_tag_list_root)");
        this.recycleViewRoot = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.video_tab_tag_recyclerview);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.video_tab_tag_recyclerview)");
        this.tagRecycleView = (RecyclerView) findViewById2;
        View findViewById3 = findViewById(R.id.video_tab_tag_left_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.video_tab_tag_left_shadow)");
        this.tagLeftShadow = findViewById3;
        View findViewById4 = findViewById(R.id.video_tab_tag_right_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.video_tab_tag_right_shadow)");
        this.tagRightShadow = findViewById4;
        View findViewById5 = findViewById(R.id.video_tab_tag_sort_select_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.video_…ag_sort_select_container)");
        this.rightShadowParent = findViewById5;
        View view2 = this.tagRightShadow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRightShadow");
            view2 = null;
        }
        ViewTreeObserver vto = view2.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(vto, "tagRightShadow.viewTreeObserver");
        vto.addOnGlobalLayoutListener(getMGlobalLayoutListener());
        updateUI();
        initAdapter();
        updateViewFont();
    }

    private final void initAdapter() {
        RecyclerView recyclerView = this.tagRecycleView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
            recyclerView = null;
        }
        recyclerView.setAdapter(getTagAdapter());
        RecyclerView recyclerView3 = this.tagRecycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(getTagLayoutManager());
        getTagAdapter().setOnItemClickListener(new VideoCommonTagListView$initAdapter$1(this));
        RecyclerView recyclerView4 = this.tagRecycleView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.addItemDecoration(new VideoCommonTagListView$initAdapter$2(this));
    }

    public final void registerFontSizeChange() {
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, new VideoCommonTagListView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerFontSizeChange$lambda-0  reason: not valid java name */
    public static final void m2874registerFontSizeChange$lambda0(VideoCommonTagListView this$0, FontSizeChangeMessage it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.updateViewFont();
        this$0.updateUI();
        VideoCommonTagModel videoCommonTagModel = this$0.tagData;
        boolean z = true;
        boolean z2 = videoCommonTagModel != null && videoCommonTagModel.getHasSubTab();
        VideoCommonTagModel videoCommonTagModel2 = this$0.tagData;
        if (videoCommonTagModel2 == null || !videoCommonTagModel2.getHasSortData()) {
            z = false;
        }
        this$0.marginRightForSelectView(z2, z);
        this$0.getTagAdapter().notifyDataSetChanged();
    }

    public final void unRegisterFontSizeChange() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    private final void updateViewFont() {
        View view2 = this.rightShadowParent;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightShadowParent");
            view2 = null;
        }
        VideoFontUtilsKt.updateScaledHeight(view2, R.dimen.dimens_29dp);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getTagList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tagItemClick(int r7) {
        /*
            r6 = this;
            com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel r0 = r6.tagData
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = r0.getTagList()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r0.get(r7)
            com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel$Tag r0 = (com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel.Tag) r0
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            r6.tag = r0
            r6.updateSelectedTab(r7)
            r0 = 1
            r6.scrollTabToPosition(r0, r7)
            com.baidu.searchbox.search.tab.core.manager.IComponentManager r0 = r6.componentManager
            if (r0 == 0) goto L_0x002d
            java.lang.Class<com.baidu.searchbox.search.tab.implement.service.IVideoListViewService> r2 = com.baidu.searchbox.search.tab.implement.service.IVideoListViewService.class
            com.baidu.searchbox.search.tab.core.service.IService r0 = r0.getService(r2)
            com.baidu.searchbox.search.tab.implement.service.IVideoListViewService r0 = (com.baidu.searchbox.search.tab.implement.service.IVideoListViewService) r0
            if (r0 == 0) goto L_0x002d
            r0.showLoading()
        L_0x002d:
            com.baidu.searchbox.search.tab.core.manager.IComponentManager r0 = r6.componentManager
            if (r0 == 0) goto L_0x0047
            com.baidu.searchbox.search.tab.core.manager.IDataManager r0 = r0.getDataManager()
            if (r0 == 0) goto L_0x0047
            r2 = 15
            com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel$Tag r3 = r6.tag
            if (r3 == 0) goto L_0x0042
            java.lang.String r3 = r3.getHref()
            goto L_0x0043
        L_0x0042:
            r3 = r1
        L_0x0043:
            r4 = 0
            r0.requestUrl(r2, r3, r1, r4)
        L_0x0047:
            com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel r0 = r6.tagData
            if (r0 == 0) goto L_0x0075
            r1 = 0
            com.baidu.searchbox.search.tab.core.manager.IComponentManager r2 = r6.componentManager
            if (r2 == 0) goto L_0x0073
            java.lang.Class<com.baidu.searchbox.search.tab.implement.service.IStatisticsProcessor> r3 = com.baidu.searchbox.search.tab.implement.service.IStatisticsProcessor.class
            com.baidu.searchbox.search.tab.core.service.IService r2 = r2.getService(r3)
            com.baidu.searchbox.search.tab.implement.service.IStatisticsProcessor r2 = (com.baidu.searchbox.search.tab.implement.service.IStatisticsProcessor) r2
            if (r2 == 0) goto L_0x0073
            java.lang.String r3 = r0.getExtLog()
            java.util.List r4 = r0.getTagList()
            java.lang.Object r4 = r4.get(r7)
            com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel$Tag r4 = (com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagModel.Tag) r4
            java.lang.String r4 = r4.getTerm()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r2.tagClickTc(r3, r4, r5)
        L_0x0073:
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagListView.tagItemClick(int):void");
    }

    public final void onNightModeChanged() {
        updateUI();
        getTagAdapter().notifyDataSetChanged();
    }

    private final void scrollTabToPosition(boolean isClick, int position) {
        RecyclerView recyclerView = null;
        if (isClick) {
            RecyclerView recyclerView2 = this.tagRecycleView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.smoothScrollToPosition(position);
            return;
        }
        RecyclerView recyclerView3 = this.tagRecycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.scrollToPosition(position);
    }

    public void onChanged(VideoCommonTagModel data) {
        FrameLayout frameLayout = null;
        if (data == null || !(!data.getTagList().isEmpty())) {
            FrameLayout frameLayout2 = this.recycleViewRoot;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleViewRoot");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setVisibility(8);
        } else if (data.getTagList().size() > 3) {
            showTagList(data);
        } else {
            FrameLayout frameLayout3 = this.recycleViewRoot;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleViewRoot");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.setVisibility(8);
        }
    }

    public final void setTagVisibility(int visibility) {
        FrameLayout frameLayout = this.recycleViewRoot;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleViewRoot");
            frameLayout = null;
        }
        frameLayout.setVisibility(visibility);
    }

    private final void showTagList(VideoCommonTagModel data) {
        FrameLayout frameLayout = this.recycleViewRoot;
        RecyclerView recyclerView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleViewRoot");
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
        RecyclerView recyclerView2 = this.tagRecycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(0);
        if (data.getHasSubTab()) {
            RecyclerView recyclerView3 = this.tagRecycleView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setPadding(0, getPaddingHorizontalSubTab(), 0, getPaddingHorizontalSubTab());
        } else {
            RecyclerView recyclerView4 = this.tagRecycleView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
            } else {
                recyclerView = recyclerView4;
            }
            recyclerView.setPadding(0, getPaddingHorizontal(), 0, getPaddingHorizontal());
        }
        this.tagData = data;
        updateUI();
        getTagAdapter().saveData(data.getTagList(), data.getHasSubTab());
        UiThreadUtils.getMainHandler().post(new VideoCommonTagListView$$ExternalSyntheticLambda1(this, data));
        updateTagCache(data);
    }

    /* access modifiers changed from: private */
    /* renamed from: showTagList$lambda-2  reason: not valid java name */
    public static final void m2875showTagList$lambda2(VideoCommonTagListView this$0, VideoCommonTagModel $data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($data, "$data");
        this$0.scrollTabToPosition(false, $data.getIndex());
    }

    private final void updateTagCache(VideoCommonTagModel data) {
        ISubTabCacheService iSubTabCacheService;
        ISubTabCacheService iSubTabCacheService2;
        if (data != null) {
            VideoCommonTagModel videoCommonTagModel = data;
            List list = data.getTagList();
            for (VideoCommonTagModel.Tag tagData2 : list) {
                if (tagData2.isSelected()) {
                    IComponentManager iComponentManager = this.componentManager;
                    if (iComponentManager != null && (iSubTabCacheService2 = (ISubTabCacheService) iComponentManager.getService(ISubTabCacheService.class)) != null) {
                        iSubTabCacheService2.updateTag(tagData2.getTerm());
                        return;
                    }
                    return;
                }
            }
            IComponentManager iComponentManager2 = this.componentManager;
            if (iComponentManager2 != null && (iSubTabCacheService = (ISubTabCacheService) iComponentManager2.getService(ISubTabCacheService.class)) != null) {
                iSubTabCacheService.updateSubTab(list.get(0).getTerm());
            }
        }
    }

    private final void updateSelectedTab(int position) {
        VideoCommonTagModel $this$updateSelectedTab_u24lambda_u2d4 = this.tagData;
        if ($this$updateSelectedTab_u24lambda_u2d4 != null) {
            $this$updateSelectedTab_u24lambda_u2d4.setIndex(position);
            int index = 0;
            int size = $this$updateSelectedTab_u24lambda_u2d4.getTagList().size();
            while (index < size) {
                $this$updateSelectedTab_u24lambda_u2d4.getTagList().get(index).setSelected(index == position);
                index++;
            }
        }
        getTagAdapter().notifyDataSetChanged();
        updateTagCache(this.tagData);
    }

    /* access modifiers changed from: private */
    public final void updateUI() {
        View view2 = this.tagRightShadow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRightShadow");
            view2 = null;
        }
        view2.setVisibility(8);
    }

    private final GradientDrawable buildGuideMask(boolean horizontalLeft) {
        int color;
        if (this.isLoftMode) {
            color = this.mTagShadowTopColor;
            if (color == 0) {
                color = parseColor(R.color.loft_search_video_tag_shadow);
            }
        } else {
            color = parseColor(R.color.search_video_tab_shadow);
        }
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, horizontalLeft ? new int[]{color, 0} : new int[]{0, color});
    }

    private final int parseColor(int color) {
        return ContextCompat.getColor(getContext(), color);
    }

    public final void setManager(IComponentManager manager) {
        Intrinsics.checkNotNullParameter(manager, FeedStatisticConstants.UBC_TYPE_PLUS);
        this.componentManager = manager;
    }

    public final boolean isSlidAble(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        FrameLayout frameLayout = this.recycleViewRoot;
        RecyclerView recyclerView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleViewRoot");
            frameLayout = null;
        }
        if (frameLayout.getVisibility() == 8) {
            return true;
        }
        int eventY = (int) ev.getY();
        Rect itemRect = new Rect();
        if (ev.getAction() == 2) {
            RecyclerView recyclerView2 = this.tagRecycleView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.getGlobalVisibleRect(itemRect);
            if (eventY < itemRect.top || eventY >= itemRect.bottom) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void marginRightForSelectView(boolean hasSubTab, boolean hasSortData) {
        RecyclerView recyclerView = this.tagRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRecycleView");
            recyclerView = null;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (hasSubTab || !hasSortData) {
                layoutParams2.rightMargin = 0;
            } else {
                layoutParams2.rightMargin = (int) FontSizeHelper.getScaledSizeRes(3, R.dimen.dimens_70dp);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    public final void setShadowInfo(Integer bgHeight, String startColor, String endColor) {
        if (bgHeight != null) {
            int intValue = bgHeight.intValue();
            this.mBgHeight = bgHeight.intValue();
            this.mStartColor = startColor;
            this.mEndColor = endColor;
        }
    }

    /* access modifiers changed from: private */
    public final void getPercentColor(Integer bgHeight, String startColor, String endColor, Rect tagSearchViewRect) {
        float middlePosition = (float) (tagSearchViewRect.top + ((tagSearchViewRect.bottom - tagSearchViewRect.top) / 2));
        if (bgHeight != null) {
            int intValue = bgHeight.intValue();
            if (startColor != null && endColor != null && this.mTagShadowTopColor == 0) {
                this.mTagShadowTopColor = ColorUtils.getPercentColor(middlePosition / ((float) bgHeight.intValue()), Color.parseColor(startColor), Color.parseColor(endColor));
            }
        }
    }

    public final void onDestroy() {
        View view2 = this.tagRightShadow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagRightShadow");
            view2 = null;
        }
        view2.getViewTreeObserver().removeOnGlobalLayoutListener(getMGlobalLayoutListener());
    }
}
