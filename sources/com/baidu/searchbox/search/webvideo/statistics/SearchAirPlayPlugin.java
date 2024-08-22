package com.baidu.searchbox.search.webvideo.statistics;

import android.content.Context;
import android.util.Log;
import com.baidu.browser.BrowserInfo;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.trigger.AirPlayStatEvent;
import com.baidu.searchbox.search.webvideo.cache.H5PlayerCache;
import com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer;
import com.baidu.searchbox.search.webvideo.player.SearchH5VideoPlayer;
import com.baidu.searchbox.search.webvideo.statistics.SearchAirPlayPlugin$lifeCycle$2;
import com.baidu.searchbox.statistics.AirPlayPlugin;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import com.baidu.ubc.bussiness.UBCDurationSearchSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u000e\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/statistics/SearchAirPlayPlugin;", "Lcom/baidu/searchbox/statistics/AirPlayPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentLid", "", "flow", "Lcom/baidu/ubc/Flow;", "isAirPlayingStatus", "", "isRegisterLifecycle", "isSSessionStarted", "lifeCycle", "com/baidu/searchbox/search/webvideo/statistics/SearchAirPlayPlugin$lifeCycle$2$1", "getLifeCycle", "()Lcom/baidu/searchbox/search/webvideo/statistics/SearchAirPlayPlugin$lifeCycle$2$1;", "lifeCycle$delegate", "Lkotlin/Lazy;", "proxyPlayer", "Lcom/baidu/searchbox/search/webvideo/player/SearchH5ProxyPlayer;", "searchSessionObserver", "com/baidu/searchbox/search/webvideo/statistics/SearchAirPlayPlugin$searchSessionObserver$1", "Lcom/baidu/searchbox/search/webvideo/statistics/SearchAirPlayPlugin$searchSessionObserver$1;", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "videoPlayer", "Lcom/baidu/searchbox/search/webvideo/player/SearchH5VideoPlayer;", "videoQuery", "attachMessenger", "", "courier", "Lcom/baidu/searchbox/player/message/IMessenger;", "getExtInfo", "Lorg/json/JSONObject;", "onAirPlayClick", "isPause", "onPluginRelease", "onVideoEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "registerLifecycle", "startFlow", "unregisterLifeCycle", "uploadFlow", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchAirPlayPlugin.kt */
public final class SearchAirPlayPlugin extends AirPlayPlugin {
    /* access modifiers changed from: private */
    public volatile String currentLid = "";
    private Flow flow;
    private boolean isAirPlayingStatus;
    private boolean isRegisterLifecycle;
    /* access modifiers changed from: private */
    public boolean isSSessionStarted;
    private final Lazy lifeCycle$delegate = LazyKt.lazy(new SearchAirPlayPlugin$lifeCycle$2(this));
    private SearchH5ProxyPlayer proxyPlayer;
    private final SearchAirPlayPlugin$searchSessionObserver$1 searchSessionObserver = new SearchAirPlayPlugin$searchSessionObserver$1(this);
    private final UBCManager ubcManager = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE));
    private SearchH5VideoPlayer videoPlayer;
    private String videoQuery = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchAirPlayPlugin(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final SearchAirPlayPlugin$lifeCycle$2.AnonymousClass1 getLifeCycle() {
        return (SearchAirPlayPlugin$lifeCycle$2.AnonymousClass1) this.lifeCycle$delegate.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        r2 = (r2 = r2.getVideoSeries()).getSelectedVideo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject getExtInfo() {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "query"
            java.lang.String r2 = r5.videoQuery     // Catch:{ JSONException -> 0x0083 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "content"
            com.baidu.searchbox.search.webvideo.player.SearchH5VideoPlayer r2 = r5.videoPlayer     // Catch:{ JSONException -> 0x0083 }
            r3 = 0
            if (r2 == 0) goto L_0x0026
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r2 = r2.getVideoSeries()     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x0026
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideo r2 = r2.getSelectedVideo()     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x0026
            java.lang.String r2 = r2.getTitle()     // Catch:{ JSONException -> 0x0083 }
            goto L_0x0027
        L_0x0026:
            r2 = r3
        L_0x0027:
            java.lang.String r2 = com.baidu.searchbox.search.webvideo.utils.SearchH5DownloadUtilsKt.formatTitle(r2)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = ""
            if (r2 != 0) goto L_0x0030
            r2 = r4
        L_0x0030:
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "url"
            com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer r2 = r5.proxyPlayer     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x003d
            java.lang.String r2 = r2.pageUrl     // Catch:{ JSONException -> 0x0083 }
            goto L_0x003e
        L_0x003d:
            r2 = r3
        L_0x003e:
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "prod_type"
            boolean r2 = com.baidu.searchbox.appframework.BdBoxActivityManager.isForeground()     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x004e
            java.lang.String r2 = "baidu"
            goto L_0x0050
        L_0x004e:
            java.lang.String r2 = "backstage"
        L_0x0050:
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0083 }
            boolean r1 = r5.isSSessionStarted     // Catch:{ JSONException -> 0x0083 }
            if (r1 == 0) goto L_0x008d
            java.lang.String r1 = "repeat"
            r2 = 1
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = r5.currentLid     // Catch:{ JSONException -> 0x0083 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x0083 }
            if (r1 == 0) goto L_0x007a
            com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer r1 = r5.proxyPlayer     // Catch:{ JSONException -> 0x0083 }
            if (r1 == 0) goto L_0x0074
            com.baidu.browser.BrowserInfo r1 = r1.getBrowserInfo()     // Catch:{ JSONException -> 0x0083 }
            if (r1 == 0) goto L_0x0074
            java.lang.String r3 = r1.getLid()     // Catch:{ JSONException -> 0x0083 }
        L_0x0074:
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0083 }
            r5.currentLid = r1     // Catch:{ JSONException -> 0x0083 }
        L_0x007a:
            java.lang.String r1 = "se_lid"
            java.lang.String r2 = r5.currentLid     // Catch:{ JSONException -> 0x0083 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0083 }
            goto L_0x008d
        L_0x0083:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.search.webvideo.statistics.SearchAirPlayPluginKt.DEBUG
            if (r2 == 0) goto L_0x008d
            r1.printStackTrace()
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.webvideo.statistics.SearchAirPlayPlugin.getExtInfo():org.json.JSONObject");
    }

    /* access modifiers changed from: private */
    public final void startFlow() {
        BrowserInfo browserInfo;
        SearchH5ProxyPlayer player = H5PlayerCache.getInstance().getPlayer();
        this.proxyPlayer = player;
        String str = null;
        this.videoPlayer = player != null ? player.mPlayer : null;
        if (this.isAirPlayingStatus && this.flow == null) {
            UBCManager uBCManager = this.ubcManager;
            this.flow = uBCManager != null ? uBCManager.beginFlow("6334") : null;
            SearchH5ProxyPlayer searchH5ProxyPlayer = this.proxyPlayer;
            if (!(searchH5ProxyPlayer == null || (browserInfo = searchH5ProxyPlayer.getBrowserInfo()) == null)) {
                str = browserInfo.getQuery();
            }
            this.videoQuery = String.valueOf(str);
            if (SearchAirPlayPluginKt.DEBUG) {
                Log.d("SearchAirPlayPlugin", "startFlow " + this.flow);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void uploadFlow() {
        if (this.flow != null) {
            JSONObject jsonObject = new JSONObject();
            try {
                JSONObject extJson = getExtInfo();
                jsonObject.put("from", "search");
                jsonObject.put("page", "Movie");
                jsonObject.put("type", "projection");
                jsonObject.put("ext", extJson);
            } catch (JSONException e2) {
                if (SearchAirPlayPluginKt.DEBUG) {
                    e2.printStackTrace();
                }
            }
            UBCManager $this$uploadFlow_u24lambda_u2d0 = this.ubcManager;
            if ($this$uploadFlow_u24lambda_u2d0 != null) {
                $this$uploadFlow_u24lambda_u2d0.flowSetValueWithDuration(this.flow, jsonObject.toString());
                $this$uploadFlow_u24lambda_u2d0.flowEnd(this.flow);
                if (SearchAirPlayPluginKt.DEBUG) {
                    Log.d("SearchAirPlayPlugin", "uploadFlow " + this.flow + ", " + jsonObject);
                }
            }
            this.flow = null;
        }
    }

    public void onVideoEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onVideoEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case -974978742:
                if (action.equals(AirPlayStatEvent.ACTION_AIRPLAY_END)) {
                    this.isAirPlayingStatus = false;
                    uploadFlow();
                    return;
                }
                return;
            case -641909083:
                if (action.equals(AirPlayStatEvent.ACTION_AIRPLAY_PAUSE)) {
                    onAirPlayClick(true);
                    return;
                }
                return;
            case -638591727:
                if (action.equals(AirPlayStatEvent.ACTION_AIRPLAY_START)) {
                    this.isAirPlayingStatus = true;
                    startFlow();
                    return;
                }
                return;
            case -159244123:
                if (action.equals(AirPlayStatEvent.ACTION_AIRPLAY_PLAY)) {
                    onAirPlayClick(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void onAirPlayClick(boolean isPause) {
        if (isPause && (!this.isSSessionStarted || !BdBoxActivityManager.isForeground())) {
            uploadFlow();
        } else if (!isPause) {
            startFlow();
        }
    }

    public void attachMessenger(IMessenger courier) {
        Intrinsics.checkNotNullParameter(courier, "courier");
        super.attachMessenger(courier);
        registerLifecycle();
        UBCDurationSearchSession.registerObserver(this.searchSessionObserver);
    }

    private final void registerLifecycle() {
        if (!this.isRegisterLifecycle) {
            this.isRegisterLifecycle = true;
            BdBoxActivityManager.registerLifeCycle(getLifeCycle());
        }
    }

    private final void unregisterLifeCycle() {
        if (this.isRegisterLifecycle) {
            this.isRegisterLifecycle = false;
            BdBoxActivityManager.unregisterLifeCycle(getLifeCycle());
        }
    }

    public void onPluginRelease() {
        super.onPluginRelease();
        unregisterLifeCycle();
        UBCDurationSearchSession.unregisterObserver(this.searchSessionObserver);
    }
}
