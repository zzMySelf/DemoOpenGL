package com.baidu.searchbox.video.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B)\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/video/utils/VideoFollowReceiver;", "Landroid/content/BroadcastReceiver;", "followId", "", "followType", "followListener", "Lcom/baidu/searchbox/video/utils/VideoFollowReceiver$FollowStatusListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/video/utils/VideoFollowReceiver$FollowStatusListener;)V", "getFollowId", "()Ljava/lang/String;", "setFollowId", "(Ljava/lang/String;)V", "getFollowType", "setFollowType", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "FollowStatusListener", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFollowReceiver.kt */
public final class VideoFollowReceiver extends BroadcastReceiver {
    private String followId;
    private final FollowStatusListener followListener;
    private String followType;
    private final IntentFilter intentFilter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/utils/VideoFollowReceiver$FollowStatusListener;", "", "onFollowStatus", "", "isFollow", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoFollowReceiver.kt */
    public interface FollowStatusListener {
        void onFollowStatus(boolean z);
    }

    public VideoFollowReceiver(FollowStatusListener followStatusListener) {
        this((String) null, (String) null, followStatusListener, 3, (DefaultConstructorMarker) null);
    }

    public VideoFollowReceiver(String str, FollowStatusListener followStatusListener) {
        this(str, (String) null, followStatusListener, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoFollowReceiver(String str, String str2, FollowStatusListener followStatusListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, followStatusListener);
    }

    public final String getFollowId() {
        return this.followId;
    }

    public final void setFollowId(String str) {
        this.followId = str;
    }

    public final String getFollowType() {
        return this.followType;
    }

    public final void setFollowType(String str) {
        this.followType = str;
    }

    public VideoFollowReceiver(String followId2, String followType2, FollowStatusListener followListener2) {
        this.followId = followId2;
        this.followType = followType2;
        this.followListener = followListener2;
        this.intentFilter = new IntentFilter("com.baidu.channel.foundation.followchanged");
    }

    public final IntentFilter getIntentFilter() {
        return this.intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        String data;
        Intent intent2 = intent;
        if (Intrinsics.areEqual((Object) intent2 != null ? intent.getAction() : null, (Object) "com.baidu.channel.foundation.followchanged") && (data = intent2.getStringExtra("data")) != null) {
            try {
                JSONArray followJsonArray = new JSONObject(data).optJSONArray("data");
                if (followJsonArray != null) {
                    Intrinsics.checkNotNullExpressionValue(followJsonArray, "followJsonArray");
                    JSONArray $this$onReceive_u24lambda_u2d2_u24lambda_u2d1 = followJsonArray;
                    int index = 0;
                    int length = $this$onReceive_u24lambda_u2d2_u24lambda_u2d1.length();
                    while (true) {
                        if (index >= length) {
                            break;
                        }
                        JSONObject $this$onReceive_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = $this$onReceive_u24lambda_u2d2_u24lambda_u2d1.optJSONObject(index);
                        if ($this$onReceive_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 != null) {
                            Intrinsics.checkNotNullExpressionValue($this$onReceive_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0, "optJSONObject(index)");
                            String thirdIdNew = $this$onReceive_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.optString("third_id");
                            String type = $this$onReceive_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.optString("type");
                            if (Intrinsics.areEqual((Object) this.followId, (Object) thirdIdNew) && Intrinsics.areEqual((Object) this.followType, (Object) type)) {
                                String followStatus = $this$onReceive_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.optString("is_follow");
                                FollowStatusListener followStatusListener = this.followListener;
                                if (followStatusListener != null) {
                                    followStatusListener.onFollowStatus(Intrinsics.areEqual((Object) followStatus, (Object) "1"));
                                }
                            }
                        }
                        index++;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }
}
