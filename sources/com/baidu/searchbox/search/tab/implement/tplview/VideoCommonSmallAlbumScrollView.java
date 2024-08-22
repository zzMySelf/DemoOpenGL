package com.baidu.searchbox.search.tab.implement.tplview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.search.tab.helper.AlbumSlideSnapHelper;
import com.baidu.searchbox.search.tab.helper.AlbumSmallSlideSnapHelper;
import com.baidu.searchbox.search.tab.implement.player.SearchTabPlayer;
import com.baidu.searchbox.search.tab.implement.player.helper.IListPlayerContext;
import com.baidu.searchbox.search.tab.implement.player.layer.SearchTabVideoLayer;
import com.baidu.searchbox.search.video.business.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0014J\b\u0010\u0011\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0014J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/tplview/VideoCommonSmallAlbumScrollView;", "Lcom/baidu/searchbox/search/tab/implement/tplview/VideoCommonAlbumScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "slideCardScrollOffset", "bindFullScreenClick", "", "getTplWidth", "", "getVisibleMaxCount", "getVisibleMinCount", "isEnableScroll", "", "onAttachedToWindow", "onBeginPlay", "onDetachedFromWindow", "setSnapHelper", "updateWidth", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonSmallAlbumScrollView.kt */
public final class VideoCommonSmallAlbumScrollView extends VideoCommonAlbumScrollView {
    public Map<Integer, View> _$_findViewCache;
    private int slideCardScrollOffset;

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
    public VideoCommonSmallAlbumScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoCommonSmallAlbumScrollView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public VideoCommonSmallAlbumScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoCommonSmallAlbumScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void updateWidth() {
        setSlideCardWidth((int) getTplWidth());
        setSlideCardHeight((int) (((float) getSlideCardWidth()) / 0.75f));
        this.slideCardScrollOffset = (((DeviceUtils.ScreenInfo.getDisplayWidth(getContext()) - getSlideCardWidth()) - (getOTHER_ITEM_MARGIN() * 2)) / 2) - getContext().getResources().getDimensionPixelOffset(R.dimen.album_small_slide_offset);
    }

    public void setSnapHelper() {
        setPagerSnapHelper(new AlbumSmallSlideSnapHelper());
        AlbumSlideSnapHelper pagerSnapHelper = getPagerSnapHelper();
        if (pagerSnapHelper != null) {
            pagerSnapHelper.attachToRecyclerView(getSlideView());
        }
    }

    public void onBeginPlay() {
        super.onBeginPlay();
        bindFullScreenClick();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    private final void bindFullScreenClick() {
        SearchTabVideoLayer layer;
        IListPlayerContext iListPlayerContext = this.playerHelper;
        SearchTabPlayer searchTabPlayer = null;
        BaseVulcanVideoPlayer player = iListPlayerContext != null ? iListPlayerContext.getPlayer(business()) : null;
        if (player instanceof SearchTabPlayer) {
            searchTabPlayer = (SearchTabPlayer) player;
        }
        if (searchTabPlayer != null && (layer = searchTabPlayer.getLayer()) != null) {
            layer.setFullScreenClickLister(this);
        }
    }

    private final float getTplWidth() {
        float p = ((float) (getSlideCardWidth() * 2)) / 95.0f;
        return (((float) 10) * ((((float) 73) * p) / 24.0f)) + (((float) 9) * p);
    }

    /* access modifiers changed from: protected */
    public boolean isEnableScroll() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getVisibleMinCount() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int getVisibleMaxCount() {
        return Integer.MAX_VALUE;
    }
}
