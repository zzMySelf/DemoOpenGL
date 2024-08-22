package com.baidu.searchbox.flowvideo.authentication.repos;

import com.baidu.searchbox.feed.detail.ext.common.RequestParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/flowvideo/authentication/repos/AuthenticationParam;", "Lcom/baidu/searchbox/feed/detail/ext/common/RequestParam;", "vid", "", "albumId", "(Ljava/lang/String;Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthenticationParam.kt */
public final class AuthenticationParam extends RequestParam {
    private final String albumId;
    private final String vid;

    public AuthenticationParam(String vid2, String albumId2) {
        Intrinsics.checkNotNullParameter(vid2, "vid");
        Intrinsics.checkNotNullParameter(albumId2, "albumId");
        this.vid = vid2;
        this.albumId = albumId2;
    }

    public JSONObject toJson() {
        new JSONObject();
        addExtParams("audioId", this.vid);
        addExtParams("albumId", this.albumId);
        JSONObject extObject = new JSONObject();
        extObject.put("from", "columnvideo");
        extObject.put("id", this.vid);
        addExtParams("audioExt", extObject);
        return super.toJson();
    }
}
