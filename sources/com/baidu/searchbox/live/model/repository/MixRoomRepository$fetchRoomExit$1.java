package com.baidu.searchbox.live.model.repository;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.net.NetStatData;
import com.baidu.searchbox.live.model.net.MixNetCallback;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.MixResultStatData;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J!\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/live/model/repository/MixRoomRepository$fetchRoomExit$1", "Lcom/baidu/searchbox/live/model/net/MixNetCallback;", "", "onNetResponse", "", "res", "Lcom/baidu/searchbox/live/interfaces/net/NetResponse;", "resData", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;Ljava/lang/Integer;)V", "onParseResponseInBackground", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;)Ljava/lang/Integer;", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MixRoomRepository.kt */
public final class MixRoomRepository$fetchRoomExit$1 implements MixNetCallback<Integer> {
    final /* synthetic */ OnMixDataLoaded $callback;

    MixRoomRepository$fetchRoomExit$1(OnMixDataLoaded $captured_local_variable$0) {
        this.$callback = $captured_local_variable$0;
    }

    public Integer onParseResponseInBackground(NetResponse res) {
        if (res == null || !res.isSuccessful()) {
            return null;
        }
        try {
            return Integer.valueOf(new JSONObject(res.decodedResponseStr).optInt("errno"));
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    public void onNetResponse(NetResponse res, Integer resData) {
        NetStatData netStatData;
        NetStatData netStatData2;
        if (resData == null) {
            OnMixDataLoaded onMixDataLoaded = this.$callback;
            if (onMixDataLoaded != null) {
                onMixDataLoaded.onMixDataLoaded(new MixResult.MixError(new Exception("exitRoom Invalid, code = " + (res != null ? Integer.valueOf(res.responseCode) : null)), (Integer) null, (Object) null, 6, (DefaultConstructorMarker) null));
            }
        } else if (resData.intValue() == 0) {
            MixResultStatData statData = new MixResultStatData();
            long j2 = 0;
            statData.requestTime = (res == null || (netStatData2 = res.statData) == null) ? 0 : netStatData2.requestTimestamp;
            if (!(res == null || (netStatData = res.statData) == null)) {
                j2 = netStatData.responseTimestamp;
            }
            statData.responseTime = j2;
            OnMixDataLoaded onMixDataLoaded2 = this.$callback;
            if (onMixDataLoaded2 != null) {
                onMixDataLoaded2.onMixDataLoaded(new MixResult.MixSuccess(true, statData));
            }
        } else {
            OnMixDataLoaded onMixDataLoaded3 = this.$callback;
            if (onMixDataLoaded3 != null) {
                onMixDataLoaded3.onMixDataLoaded(new MixResult.MixError(new Exception("errno Invalid, errno = " + resData), (Integer) null, (Object) null, 6, (DefaultConstructorMarker) null));
            }
        }
    }
}
