package com.baidu.searchbox.video.feedflow.detail.vote;

import com.baidu.searchbox.video.detail.switcher.VideoSPData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/vote/VoteSpHelper;", "", "()V", "<set-?>", "", "clickVoteCloseId", "getClickVoteCloseId", "()Ljava/lang/String;", "setClickVoteCloseId", "(Ljava/lang/String;)V", "clickVoteCloseId$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoSPData;", "optionsMap", "Ljava/util/HashMap;", "Lorg/json/JSONArray;", "Lkotlin/collections/HashMap;", "getOptionsMap", "()Ljava/util/HashMap;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoteSpHelper.kt */
public final class VoteSpHelper {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(VoteSpHelper.class, "clickVoteCloseId", "getClickVoteCloseId()Ljava/lang/String;", 0))};
    public static final VoteSpHelper INSTANCE = new VoteSpHelper();
    private static final VideoSPData clickVoteCloseId$delegate = new VideoSPData(VoteSpHelperKt.KEY_VIDEO_CLICK_VOTE_CLOSE_ID, "", false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final HashMap<String, JSONArray> optionsMap = new HashMap<>();

    private VoteSpHelper() {
    }

    public final String getClickVoteCloseId() {
        return (String) clickVoteCloseId$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setClickVoteCloseId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clickVoteCloseId$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final HashMap<String, JSONArray> getOptionsMap() {
        return optionsMap;
    }
}
