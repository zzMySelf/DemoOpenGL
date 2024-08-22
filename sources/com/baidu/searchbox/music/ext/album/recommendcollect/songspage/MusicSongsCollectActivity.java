package com.baidu.searchbox.music.ext.album.recommendcollect.songspage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.music.ext.BaseMusicExtActivity;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import com.baidu.searchbox.music.ext.album.recommendcollect.common.SongsCollectComp;
import com.baidu.searchbox.music.ext.album.recommendcollect.common.SongsCollectParams;
import com.baidu.searchbox.music.ext.album.recommendcollect.status.DataReqStatusComp;
import com.baidu.searchbox.music.ext.utils.BottomBarUtils;
import com.baidu.searchbox.music.ext.utils.MusicUiUtil;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.widget.ptr.PullToRefreshRecyclerView;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0015J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/recommendcollect/songspage/MusicSongsCollectActivity;", "Lcom/baidu/searchbox/music/ext/BaseMusicExtActivity;", "()V", "dataReqStatusComp", "Lcom/baidu/searchbox/music/ext/album/recommendcollect/status/DataReqStatusComp;", "dstAlbum", "Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "invokeFrom", "", "songsPageComp", "Lcom/baidu/searchbox/music/ext/album/recommendcollect/common/SongsCollectComp;", "getStatPage", "initBottomBar", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNightModeChanged", "isNightMode", "", "Companion", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicSongsCollectActivity.kt */
public final class MusicSongsCollectActivity extends BaseMusicExtActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DST_ALBUM = "dst_album";
    private static final String INVOKE_FROM = "from";
    private static final String SRC_ALBUM = "src_album";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public DataReqStatusComp dataReqStatusComp;
    private MusicAlbum dstAlbum;
    private String invokeFrom = "";
    /* access modifiers changed from: private */
    public SongsCollectComp songsPageComp;

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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String str = null;
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(SRC_ALBUM) : null;
        MusicAlbum src = serializableExtra instanceof MusicAlbum ? (MusicAlbum) serializableExtra : null;
        Intent intent2 = getIntent();
        Serializable serializableExtra2 = intent2 != null ? intent2.getSerializableExtra(DST_ALBUM) : null;
        MusicAlbum dst = serializableExtra2 instanceof MusicAlbum ? (MusicAlbum) serializableExtra2 : null;
        Intent intent3 = getIntent();
        if (intent3 != null) {
            str = intent3.getStringExtra("from");
        }
        if (str == null) {
            str = "";
        }
        this.invokeFrom = str;
        if (dst == null || src == null) {
            finish();
            return;
        }
        this.dstAlbum = dst;
        setContentView(R.layout.collect_songs_page);
        if (MusicUiUtil.isSupportImmersion()) {
            ((ConstraintLayout) _$_findCachedViewById(R.id.rootLayout)).setPadding(0, DeviceUtils.ScreenInfo.getStatusBarHeight(), 0, 0);
        }
        ((TextView) _$_findCachedViewById(R.id.tvTitle)).setText(src.getName());
        SongsCollectParams songsCollectParams = new SongsCollectParams(this.invokeFrom, src, dst, (String) null, 0, 24, (DefaultConstructorMarker) null);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.layoutStatus);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "layoutStatus");
        DataReqStatusComp $this$onCreate_u24lambda_u2d0 = new DataReqStatusComp(this, _$_findCachedViewById);
        $this$onCreate_u24lambda_u2d0.setOnReloadClick(new MusicSongsCollectActivity$onCreate$1$1(this, songsCollectParams));
        this.dataReqStatusComp = $this$onCreate_u24lambda_u2d0;
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) _$_findCachedViewById(R.id.rcySongList);
        Intrinsics.checkNotNullExpressionValue(pullToRefreshRecyclerView, "rcySongList");
        SongsCollectComp $this$onCreate_u24lambda_u2d1 = new SongsCollectComp(this, pullToRefreshRecyclerView, songsCollectParams, getToken());
        $this$onCreate_u24lambda_u2d1.setOnReqStatusChange(new MusicSongsCollectActivity$onCreate$2$1(this));
        this.songsPageComp = $this$onCreate_u24lambda_u2d1;
        initBottomBar();
        onNightModeChanged(NightModeHelper.getNightModeSwitcherState());
    }

    private final void initBottomBar() {
        UnifiedBottomBar bottomBar = BottomBarUtils.INSTANCE.createBottomBar(this);
        BottomBarUtils.INSTANCE.setOnBottomBarClickListener$lib_music_ext_release(bottomBar, new MusicSongsCollectActivity$initBottomBar$1(this));
        ((FrameLayout) _$_findCachedViewById(R.id.bottomBarFl)).addView(bottomBar);
    }

    public String getStatPage() {
        return this.invokeFrom;
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        SongsCollectComp songsCollectComp = this.songsPageComp;
        if (songsCollectComp != null) {
            songsCollectComp.onNightModeChange(isNightMode);
        }
        DataReqStatusComp dataReqStatusComp2 = this.dataReqStatusComp;
        if (dataReqStatusComp2 != null) {
            dataReqStatusComp2.onNightModeChange(isNightMode);
        }
        ResWrapper.setTextColor((TextView) _$_findCachedViewById(R.id.tvTitle), com.baidu.android.common.ui.style.R.color.GC1);
        ResWrapper.setBackgroundColor((ConstraintLayout) _$_findCachedViewById(R.id.rootLayout), R.color.search_music_bg_a);
        ResWrapper.setBackgroundColor(_$_findCachedViewById(R.id.topDivider), R.color.search_music_bg_c);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/recommendcollect/songspage/MusicSongsCollectActivity$Companion;", "", "()V", "DST_ALBUM", "", "INVOKE_FROM", "SRC_ALBUM", "safeToInvoke", "", "context", "Landroid/content/Context;", "src", "Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "dst", "from", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MusicSongsCollectActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void safeToInvoke(Context context, MusicAlbum src, MusicAlbum dst, String from) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(dst, "dst");
            Intrinsics.checkNotNullParameter(from, "from");
            Intent intent = new Intent(context, MusicSongsCollectActivity.class);
            Intent $this$safeToInvoke_u24lambda_u2d0 = intent;
            $this$safeToInvoke_u24lambda_u2d0.putExtra(MusicSongsCollectActivity.SRC_ALBUM, src);
            $this$safeToInvoke_u24lambda_u2d0.putExtra(MusicSongsCollectActivity.DST_ALBUM, dst);
            $this$safeToInvoke_u24lambda_u2d0.putExtra("from", from);
            ActivityUtils.startActivitySafely(context, intent);
        }
    }
}
