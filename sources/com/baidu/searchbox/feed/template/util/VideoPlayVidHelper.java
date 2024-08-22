package com.baidu.searchbox.feed.template.util;

import java.util.HashSet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/template/util/VideoPlayVidHelper;", "", "()V", "collectionPlayingVid", "", "hasPlayedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayingVid", "release", "", "setPlayingVid", "vid", "setVideoHasPlayed", "videoHasPlayed", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayVidHelper.kt */
public final class VideoPlayVidHelper {
    public static final VideoPlayVidHelper INSTANCE = new VideoPlayVidHelper();
    private static String collectionPlayingVid = "";
    private static HashSet<String> hasPlayedSet = new HashSet<>();

    private VideoPlayVidHelper() {
    }

    public final void setPlayingVid(String vid) {
        if (vid != null) {
            collectionPlayingVid = vid;
        }
    }

    public final String getPlayingVid() {
        return collectionPlayingVid;
    }

    public final boolean videoHasPlayed(String vid) {
        if (vid == null) {
            return false;
        }
        return hasPlayedSet.contains(vid);
    }

    public final void setVideoHasPlayed(String vid) {
        if (vid != null) {
            hasPlayedSet.add(vid);
        }
    }

    public final void release() {
        setPlayingVid("");
        hasPlayedSet.clear();
    }
}
