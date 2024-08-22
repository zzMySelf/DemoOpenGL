package com.baidu.searchbox.player.plugin.decoder;

import com.baidu.searchbox.player.model.ClarityRedirect;
import com.baidu.searchbox.player.plugin.model.MPDModel;
import com.baidu.searchbox.player.plugin.model.Video;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tH\u0002¢\u0006\u0002\u0010\n\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002\u001a&\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0003¨\u0006\u0014"}, d2 = {"convertVideo", "", "mpdModel", "Lcom/baidu/searchbox/player/plugin/model/MPDModel;", "clarityUrlList", "Lorg/json/JSONArray;", "getStrByNotEmptyPriority", "", "array", "", "([Ljava/lang/String;)Ljava/lang/String;", "parseClarityRedirect", "Lcom/baidu/searchbox/player/model/ClarityRedirect;", "data", "Lorg/json/JSONObject;", "parseClarityRedirectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getVideoModel", "Lcom/baidu/searchbox/player/plugin/model/Video;", "mpd-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoDecoder.kt */
public final class VideoDecoderKt {
    public static final Video getVideoModel(MPDModel $this$getVideoModel) {
        Intrinsics.checkNotNullParameter($this$getVideoModel, "<this>");
        Object extra = $this$getVideoModel.getExtData().getExtra(MPDNode.Video.toString());
        if (!(extra instanceof Video)) {
            extra = null;
        }
        return (Video) extra;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        r7 = r7.getAdaptationSetList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void convertVideo(com.baidu.searchbox.player.plugin.model.MPDModel r18, org.json.JSONArray r19) {
        /*
            r0 = r19
            java.lang.String r1 = "mpdModel"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "clarityUrlList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r18
            r3 = 0
            com.baidu.searchbox.player.plugin.model.Video r4 = r1.getVideo()
            if (r4 == 0) goto L_0x016f
            java.util.ArrayList r4 = r4.getAdaptationSetList()
            if (r4 == 0) goto L_0x016f
            r5 = r4
            r6 = 0
            com.baidu.searchbox.player.plugin.model.Video r7 = r1.getVideo()
            r8 = 0
            if (r7 == 0) goto L_0x0032
            java.util.ArrayList r7 = r7.getAdaptationSetList()
            if (r7 == 0) goto L_0x0032
            int r7 = r7.size()
            goto L_0x0033
        L_0x0032:
            r7 = r8
        L_0x0033:
            if (r7 <= 0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x0037:
            r5 = r8
        L_0x0038:
            if (r5 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r4 = 0
        L_0x003c:
            if (r4 == 0) goto L_0x016f
            java.lang.Object r4 = r4.get(r8)
            com.baidu.searchbox.player.plugin.model.AdaptationSet r4 = (com.baidu.searchbox.player.plugin.model.AdaptationSet) r4
            if (r4 == 0) goto L_0x016f
            r5 = 0
            java.util.ArrayList r7 = r4.getRepresentationList()
            if (r7 == 0) goto L_0x016e
            r10 = 0
            r11 = 0
            int r12 = r7.size()
        L_0x0053:
            if (r11 >= r12) goto L_0x016c
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.Object r14 = r7.get(r11)
            boolean r15 = r14 instanceof com.baidu.searchbox.player.plugin.model.VideoRepresentation
            if (r15 == 0) goto L_0x0065
            com.baidu.searchbox.player.plugin.model.VideoRepresentation r14 = (com.baidu.searchbox.player.plugin.model.VideoRepresentation) r14
            goto L_0x0066
        L_0x0065:
            r14 = 0
        L_0x0066:
            if (r14 == 0) goto L_0x0164
            r15 = 0
            java.lang.String r6 = r14.getKey()
            java.lang.String r9 = "key"
            r13.put(r9, r6)
            int r6 = r14.getRank()
            java.lang.String r9 = "rank"
            r13.put(r9, r6)
            java.lang.String r6 = r14.getTitle()
            java.lang.String r9 = "title"
            r13.put(r9, r6)
            java.lang.String r6 = r14.getUrl()
            java.lang.String r9 = "url"
            r13.put(r9, r6)
            int r6 = r14.getWidth()
            java.lang.String r9 = "width"
            r13.put(r9, r6)
            int r6 = r14.getHeight()
            java.lang.String r9 = "height"
            r13.put(r9, r6)
            java.lang.String r6 = r14.getDownloadUrl()
            java.lang.String r9 = "download_url"
            r13.put(r9, r6)
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.String r9 = r14.getAirPlayUrl()
            r6[r8] = r9
            java.lang.String r9 = r14.getDownloadUrl()
            r16 = 1
            r6[r16] = r9
            r9 = 2
            java.lang.String r17 = r14.getUrl()
            r6[r9] = r17
            java.lang.String r6 = getStrByNotEmptyPriority(r6)
            java.lang.String r9 = "airPlay_url"
            r13.put(r9, r6)
            int r6 = r14.getSegmentCnt()
            java.lang.String r9 = "segment_cnt"
            r13.put(r9, r6)
            double r8 = r14.getSegmentDur()
            java.lang.String r6 = "segment_dur"
            r13.put(r6, r8)
            int r6 = r14.getBps()
            java.lang.String r8 = "videoBps"
            r13.put(r8, r6)
            double r8 = r14.getSize()
            boolean r6 = java.lang.Double.isNaN(r8)
            if (r6 == 0) goto L_0x00fb
            r6 = -1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0103
        L_0x00fb:
            double r8 = r14.getSize()
            java.lang.Double r6 = java.lang.Double.valueOf(r8)
        L_0x0103:
            java.lang.String r8 = "videoSize"
            r13.put(r8, r6)
            int r6 = r14.getMoovSize()
            java.lang.String r8 = "vodMoovSize"
            r13.put(r8, r6)
            double r8 = r14.getClarityScore()
            java.lang.String r6 = "video_clarity_score"
            r13.put(r6, r8)
            int r6 = r14.getPrefetchSize()
            java.lang.String r8 = "prefetch_size"
            r13.put(r8, r6)
            long r8 = r14.getExpireDate()
            java.lang.String r6 = "expire_date"
            r13.put(r6, r8)
            java.lang.String r6 = r14.getAuth()
            java.lang.String r8 = "auth"
            r13.put(r8, r6)
            java.lang.Boolean r6 = r4.getFrmAlign()
            if (r6 == 0) goto L_0x0144
            boolean r6 = r6.booleanValue()
            goto L_0x0148
        L_0x0144:
            boolean r6 = r14.getFrmAlignRepresentation()
        L_0x0148:
            java.lang.String r8 = "gopAlign"
            r13.put(r8, r6)
            int r6 = r14.getHdr()
            java.lang.String r8 = "hdr"
            r13.put(r8, r6)
            boolean r6 = r14.getAiEnhance()
            java.lang.String r8 = "ai_enhance"
            r13.put(r8, r6)
            r0.put(r13)
            goto L_0x0166
        L_0x0164:
            r16 = 1
        L_0x0166:
            int r11 = r11 + 1
            r8 = 0
            goto L_0x0053
        L_0x016c:
        L_0x016e:
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.plugin.decoder.VideoDecoderKt.convertVideo(com.baidu.searchbox.player.plugin.model.MPDModel, org.json.JSONArray):void");
    }

    private static final String getStrByNotEmptyPriority(String[] array) {
        for (String str : array) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                return str;
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    public static final ArrayList<ClarityRedirect> parseClarityRedirectList(JSONObject data) {
        JSONArray optJSONArray;
        if (data == null || (optJSONArray = data.optJSONArray("clarity_redirect")) == null) {
            return null;
        }
        JSONArray clarityRedirectJsonArray = optJSONArray;
        ArrayList clarityRedirectList = new ArrayList();
        int length = clarityRedirectJsonArray.length();
        for (int representationIndex = 0; representationIndex < length; representationIndex++) {
            ClarityRedirect $this$parseClarityRedirectList_u24lambda_u2d6_u24lambda_u2d5 = parseClarityRedirect(clarityRedirectJsonArray.optJSONObject(representationIndex));
            if ($this$parseClarityRedirectList_u24lambda_u2d6_u24lambda_u2d5 != null) {
                clarityRedirectList.add($this$parseClarityRedirectList_u24lambda_u2d6_u24lambda_u2d5);
            }
        }
        return clarityRedirectList;
    }

    private static final ClarityRedirect parseClarityRedirect(JSONObject data) {
        if (data == null) {
            return null;
        }
        return new ClarityRedirect(data.optInt("from_rank", -1), data.optInt("to_rank", -1), data.optString("tag", ""));
    }
}
