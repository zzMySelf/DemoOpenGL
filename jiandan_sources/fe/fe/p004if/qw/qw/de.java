package fe.fe.p004if.qw.qw;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.CommonUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
import fe.fe.p004if.qw.yj.fe;
import fe.fe.p004if.qw.yj.rg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: fe.fe.if.qw.qw.de  reason: invalid package */
public final class de {
    public static IMPushPb.Action ad(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build();
    }

    public static IMPushPb.Action fe(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(j).setStopTime(j2).setReason(str).setRetryTime(j3).setRetryCount(j4).setExt(str2).setAliasId(j5).build()).build();
    }

    public static void rg(Context context, Connection connection) {
        try {
            HashSet hashSet = new HashSet(fe.de(context));
            hashSet.add(Base64.encodeToString(fe(connection.startTime, connection.stopTime, connection.reason, connection.retryTime, connection.retryCount, connection.ext, connection.aliasId).toByteArray(), 0));
            fe.nn(context, hashSet);
        } catch (Exception e) {
            fe.de("TrackPbGenerator", "putIMConnectionToActions :", e);
        }
    }

    public static void th(Context context, Request request) {
        try {
            HashSet hashSet = new HashSet(fe.yj(context));
            hashSet.add(Base64.encodeToString(ad(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId).toByteArray(), 0));
            fe.a(context, hashSet);
        } catch (Exception e) {
            fe.de("TrackPbGenerator", "putIMRequestToActions :", e);
        }
    }

    public byte[] de(Context context) {
        try {
            Set<String> yj2 = fe.yj(context);
            HashSet<String> hashSet = new HashSet<>(yj2);
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (yj2.size() <= 4000 && yj2.size() >= 1) {
                for (String decode : hashSet) {
                    copyOnWriteArrayList.add(IMPushPb.Action.parseFrom(Base64.decode(decode, 0)));
                }
            }
            Set<String> de2 = fe.de(context);
            HashSet<String> hashSet2 = new HashSet<>(de2);
            if (de2.size() <= 4000 - yj2.size() && de2.size() >= 1) {
                for (String decode2 : hashSet2) {
                    copyOnWriteArrayList.add(IMPushPb.Action.parseFrom(Base64.decode(decode2, 0)));
                }
            }
            return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, rg.rg(context))).setSdkName("lcp").setSdkVersion(2260016).addAllActions(copyOnWriteArrayList).build().toByteArray();
        } catch (Exception e) {
            fe.de("TrackPbGenerator", "generateTrackClient :", e);
            return null;
        }
    }

    public byte[] qw(Context context, @NonNull IMPushPb.Action action) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(action);
            return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, rg.rg(context))).setSdkName("lcp").setSdkVersion(2260016).addAllActions(arrayList).build().toByteArray();
        } catch (Exception unused) {
            return null;
        }
    }
}
