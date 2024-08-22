package com.baidu.searchbox.search.tab.utils;

import android.util.Log;
import android.view.View;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.search.video.SearchVideoAudioManager;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.videoplayer.util.VideoInfoProtocolKt;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a+\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\r\u001a\u0010\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u001a&\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u001aC\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0017\u001aO\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"TAG", "", "appendLocation", "", "jsonObject", "Lorg/json/JSONObject;", "view", "Landroid/view/View;", "appendMuteStatus", "appendSummaryInfo", "seek", "", "expandStatus", "(Lorg/json/JSONObject;Ljava/lang/Integer;Ljava/lang/Integer;)V", "beginPlaySpeedTrack", "params", "updateCmd", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "clickView", "playerHolder", "seekSecond", "summaryStatus", "(Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;Landroid/view/View;Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "keyFrameStatus", "(Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;Landroid/view/View;Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "search_video_business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CmdOptUtils.kt */
public final class VideoLoftCmdUtils {
    private static final String TAG = "CmdOptUtils";

    public static /* synthetic */ String updateCmd$default(UnitedSchemeEntity unitedSchemeEntity, View view2, View view3, Integer num, Integer num2, String str, int i2, Object obj) {
        Integer num3;
        Integer num4;
        String str2;
        if ((i2 & 8) != 0) {
            num3 = null;
        } else {
            num3 = num;
        }
        if ((i2 & 16) != 0) {
            num4 = null;
        } else {
            num4 = num2;
        }
        if ((i2 & 32) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        return updateCmd(unitedSchemeEntity, view2, view3, num3, num4, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[Catch:{ JSONException -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x017f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String updateCmd(com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r18, android.view.View r19, android.view.View r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.String r23) {
        /*
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r0 = "extRequest"
            java.lang.String r4 = "CmdOptUtils"
            java.lang.String r5 = "params"
            r6 = 0
            if (r1 != 0) goto L_0x0011
            return r6
        L_0x0011:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.util.HashMap r8 = r18.getParams()     // Catch:{ JSONException -> 0x0175 }
            java.lang.Object r8 = r8.get(r5)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x0175 }
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ JSONException -> 0x0175 }
            if (r9 == 0) goto L_0x002f
            int r9 = r9.length()     // Catch:{ JSONException -> 0x0175 }
            if (r9 != 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r9 = 0
            goto L_0x0030
        L_0x002f:
            r9 = 1
        L_0x0030:
            if (r9 != 0) goto L_0x0179
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0175 }
            r9.<init>(r8)     // Catch:{ JSONException -> 0x0175 }
            org.json.JSONArray r12 = r9.names()     // Catch:{ JSONException -> 0x0175 }
            if (r12 == 0) goto L_0x0173
            org.json.JSONArray r12 = r9.names()     // Catch:{ JSONException -> 0x0175 }
            if (r12 == 0) goto L_0x0048
            int r12 = r12.length()     // Catch:{ JSONException -> 0x0175 }
            goto L_0x0049
        L_0x0048:
            r12 = 0
        L_0x0049:
            if (r12 > 0) goto L_0x004d
            goto L_0x0173
        L_0x004d:
            java.lang.String r12 = "videoPlayerReuseID"
            java.lang.String r13 = "vid"
            java.lang.String r13 = r9.optString(r13)     // Catch:{ JSONException -> 0x0175 }
            r9.put(r12, r13)     // Catch:{ JSONException -> 0x0175 }
            r12 = r21
            r13 = r22
            appendSummaryInfo(r9, r12, r13)     // Catch:{ JSONException -> 0x0175 }
            if (r23 == 0) goto L_0x007c
            r14 = r23
            r15 = 0
            org.json.JSONObject r16 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0175 }
            r16.<init>()     // Catch:{ JSONException -> 0x0175 }
            r17 = r16
            java.lang.String r6 = "show"
            r10 = r17
            r10.put(r6, r14)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r6 = "videoKeyFrame"
            r9.put(r6, r10)     // Catch:{ JSONException -> 0x0175 }
        L_0x007c:
            if (r2 == 0) goto L_0x0085
            r6 = r19
            r10 = 0
            appendLocation(r9, r2)     // Catch:{ JSONException -> 0x0175 }
        L_0x0085:
            beginPlaySpeedTrack(r9)     // Catch:{ JSONException -> 0x0175 }
            appendMuteStatus(r9)     // Catch:{ JSONException -> 0x0175 }
            org.json.JSONObject r6 = r9.optJSONObject(r0)     // Catch:{ JSONException -> 0x0175 }
            if (r6 == 0) goto L_0x00b1
            r10 = r6
            r14 = 0
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0175 }
            r15.<init>()     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r11 = "lid"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ JSONException -> 0x0175 }
            java.lang.StringBuilder r11 = r15.append(r11)     // Catch:{ JSONException -> 0x0175 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0175 }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r11 = r11.toString()     // Catch:{ JSONException -> 0x0175 }
            goto L_0x00b2
        L_0x00b1:
            r11 = 0
        L_0x00b2:
            r10 = r11
            if (r10 == 0) goto L_0x00f6
            r11 = r10
            r12 = 0
            java.nio.charset.Charset r13 = kotlin.text.Charsets.UTF_8     // Catch:{ JSONException -> 0x0175 }
            byte[] r13 = r11.getBytes(r13)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r14 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ JSONException -> 0x0175 }
            r14 = 0
            java.lang.String r13 = org.apache.commons.codec.digest4util.MD5Utils.toMd5((byte[]) r13, (boolean) r14)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r14 = "seClickID"
            r6.put(r14, r13)     // Catch:{ JSONException -> 0x0175 }
            r9.put(r0, r6)     // Catch:{ JSONException -> 0x0175 }
            if (r3 == 0) goto L_0x00d8
            int r0 = com.baidu.searchbox.search.video.business.R.id.seclickid     // Catch:{ JSONException -> 0x0175 }
            r3.setTag(r0, r13)     // Catch:{ JSONException -> 0x0175 }
        L_0x00d8:
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ JSONException -> 0x0175 }
            if (r0 == 0) goto L_0x00f5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0175 }
            r0.<init>()     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r14 = "updateCmd seClickID = "
            java.lang.StringBuilder r0 = r0.append(r14)     // Catch:{ JSONException -> 0x0175 }
            java.lang.StringBuilder r0 = r0.append(r13)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0175 }
            android.util.Log.d(r4, r0)     // Catch:{ JSONException -> 0x0175 }
        L_0x00f5:
        L_0x00f6:
            java.lang.String r0 = r9.toString()     // Catch:{ JSONException -> 0x0175 }
            r1.putParams(r5, r0)     // Catch:{ JSONException -> 0x0175 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0175 }
            r0.<init>()     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r5 = "baiduboxapp://"
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r5 = r18.getAllPath()     // Catch:{ JSONException -> 0x0175 }
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ JSONException -> 0x0175 }
            r5 = 63
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0175 }
            r7.append(r0)     // Catch:{ JSONException -> 0x0175 }
            java.util.HashMap r0 = r18.getParams()     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r5 = "entity.params"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ JSONException -> 0x0175 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ JSONException -> 0x0175 }
            java.util.Set r5 = r0.entrySet()     // Catch:{ JSONException -> 0x0175 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ JSONException -> 0x0175 }
        L_0x0131:
            boolean r11 = r5.hasNext()     // Catch:{ JSONException -> 0x0175 }
            if (r11 == 0) goto L_0x0161
            java.lang.Object r11 = r5.next()     // Catch:{ JSONException -> 0x0175 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ JSONException -> 0x0175 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ JSONException -> 0x0175 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x0175 }
            java.lang.StringBuilder r13 = r7.append(r12)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r14 = "="
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r14 = java.net.URLEncoder.encode(r11)     // Catch:{ JSONException -> 0x0175 }
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r14 = "&"
            r13.append(r14)     // Catch:{ JSONException -> 0x0175 }
            goto L_0x0131
        L_0x0161:
            int r5 = r7.length()     // Catch:{ JSONException -> 0x0175 }
            r11 = 1
            int r5 = r5 - r11
            java.lang.StringBuilder r5 = r7.deleteCharAt(r5)     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r11 = "newCmd.deleteCharAt(newCmd.length - 1)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r11)     // Catch:{ JSONException -> 0x0175 }
            r7 = r5
            goto L_0x0179
        L_0x0173:
            r0 = 0
            return r0
        L_0x0175:
            r0 = move-exception
            com.baidu.searchbox.config.AppConfig.isDebug()
        L_0x0179:
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto L_0x0196
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "updateCmd newCmd = "
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r4, r0)
        L_0x0196:
            java.lang.String r0 = r7.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.utils.VideoLoftCmdUtils.updateCmd(com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, android.view.View, android.view.View, java.lang.Integer, java.lang.Integer, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[Catch:{ JSONException -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void beginPlaySpeedTrack(org.json.JSONObject r3) {
        /*
            if (r3 == 0) goto L_0x0028
            java.lang.String r0 = "nid"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0026 }
            r1.<init>()     // Catch:{ JSONException -> 0x0026 }
            java.lang.String r2 = "sv_"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ JSONException -> 0x0026 }
            java.lang.String r2 = "vid"
            java.lang.String r2 = r3.optString(r2)     // Catch:{ JSONException -> 0x0026 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ JSONException -> 0x0026 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0026 }
            java.lang.String r0 = r3.optString(r0, r1)     // Catch:{ JSONException -> 0x0026 }
            goto L_0x0029
        L_0x0026:
            r0 = move-exception
            goto L_0x0041
        L_0x0028:
            r0 = 0
        L_0x0029:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ JSONException -> 0x0026 }
            if (r1 == 0) goto L_0x0037
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ JSONException -> 0x0026 }
            if (r1 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r1 = 0
            goto L_0x0038
        L_0x0037:
            r1 = 1
        L_0x0038:
            if (r1 != 0) goto L_0x0044
            com.baidu.searchbox.player.ubc.PlayerSpeedTracker.beginTrack(r0)     // Catch:{ JSONException -> 0x0026 }
            com.baidu.searchbox.player.ubc.PlayerSpeedTracker.startClickVideoTemplate(r0)     // Catch:{ JSONException -> 0x0026 }
            goto L_0x0044
        L_0x0041:
            com.baidu.searchbox.config.AppConfig.isDebug()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.utils.VideoLoftCmdUtils.beginPlaySpeedTrack(org.json.JSONObject):void");
    }

    public static /* synthetic */ String updateCmd$default(UnitedSchemeEntity unitedSchemeEntity, View view2, View view3, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num = null;
        }
        if ((i2 & 16) != 0) {
            num2 = null;
        }
        return updateCmd(unitedSchemeEntity, view2, view3, num, num2);
    }

    public static final String updateCmd(UnitedSchemeEntity entity, View playerHolder, View clickView, Integer seekSecond, Integer summaryStatus) {
        return updateCmd(entity, playerHolder, clickView, seekSecond, summaryStatus, (String) null);
    }

    public static final String updateCmd(UnitedSchemeEntity entity, View view2, View clickView) {
        return updateCmd(entity, view2, clickView, (Integer) null, (Integer) null);
    }

    private static final void appendLocation(JSONObject jsonObject, View view2) {
        if (jsonObject != null && view2 != null) {
            int width = view2.getWidth();
            int height = view2.getHeight();
            int[] position = new int[2];
            int top = 0;
            int left = 0;
            try {
                view2.getLocationOnScreen(position);
                top = position[1];
                left = position[0];
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
            JSONObject locationObj = new JSONObject();
            locationObj.put("left", left);
            locationObj.put("top", top);
            locationObj.put("width", width);
            locationObj.put("height", height);
            jsonObject.put("video_location", locationObj);
            if (AppConfig.isDebug()) {
                Log.d("appendLocation", "locationObj=" + locationObj);
            }
        }
    }

    private static final void appendSummaryInfo(JSONObject jsonObject, Integer seek, Integer expandStatus) {
        if (jsonObject != null && seek != null) {
            JSONObject videoInfoObject = jsonObject.optJSONObject("videoInfo");
            if (videoInfoObject != null) {
                videoInfoObject.put(VideoInfoProtocolKt.SEEK_SECONDS, seek.intValue());
            }
            if (expandStatus != null) {
                JSONObject summaryObject = new JSONObject();
                summaryObject.put("show", expandStatus.intValue());
                jsonObject.put(IntentData.Protocol.KEY_VIDEO_SUMMARY, summaryObject);
            }
            jsonObject.put("videoInfo", videoInfoObject);
        }
    }

    private static final void appendMuteStatus(JSONObject jsonObject) {
        JSONObject extObject;
        if (jsonObject != null && (extObject = jsonObject.optJSONObject("ext")) != null) {
            JSONObject ext = extObject;
            String mute = "1";
            if (SearchVideoAudioManager.Companion.getInstance().isHeadsetConnect()) {
                if (!SearchVideoAudioManager.Companion.getInstance().getHeadMuteStatus()) {
                    mute = "0";
                }
            } else if (!SearchVideoAudioManager.Companion.getInstance().getMute("B")) {
                mute = "0";
            }
            ext.put("pageMute", mute);
        }
    }
}
