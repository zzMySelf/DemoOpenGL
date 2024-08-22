package com.baidu.searchbox.player.barrage;

import android.util.Base64;
import com.baidu.searchbox.NativeBds;
import com.baidu.searchbox.danmakulib.ubc.BarrageUBCHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0017*\u0004\u0018\u00010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"BARRAGE_LOAD_INTERVAL", "", "BARRAGE_NONE", "BARRAGE_OFF", "BARRAGE_ON", "BARRAGE_PRE_LOAD", "BARRAGE_REQUEST_INTERVAL", "DANMAKU_EVENT_LONGIN_SEND", "DANMAKU_EVENT_PLAYING_STATE", "DANMAKU_EVENT_PRAISE", "DANMAKU_EVENT_SEND_SUCCESS", "DANMAKU_EVENT_SEND_TO_LOGIN", "FONT_SCALE_FACTOR", "", "FONT_STROKE_SIZE", "MAX_COLS_SPACE", "MAX_ROWS_SPACE", "MAX_SCROLL_LINE", "SCROLL_SPEED_FACTOR", "SCROLL_SPEED_LINE_FACTOR", "barrageUBC", "", "type", "", "barrageInfo", "Lcom/baidu/searchbox/player/barrage/VulcanBarrageInfo;", "toEncyptString", "business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanBarrageUtils.kt */
public final class VulcanBarrageUtilsKt {
    public static final int BARRAGE_LOAD_INTERVAL = 1000;
    public static final int BARRAGE_NONE = -1;
    public static final int BARRAGE_OFF = 0;
    public static final int BARRAGE_ON = 1;
    public static final int BARRAGE_PRE_LOAD = 10;
    public static final int BARRAGE_REQUEST_INTERVAL = 60;
    public static final int DANMAKU_EVENT_LONGIN_SEND = -5;
    public static final int DANMAKU_EVENT_PLAYING_STATE = -1;
    public static final int DANMAKU_EVENT_PRAISE = -4;
    public static final int DANMAKU_EVENT_SEND_SUCCESS = -3;
    public static final int DANMAKU_EVENT_SEND_TO_LOGIN = -2;
    public static final float FONT_SCALE_FACTOR = 1.0f;
    public static final int FONT_STROKE_SIZE = 2;
    public static final int MAX_COLS_SPACE = 2;
    public static final int MAX_ROWS_SPACE = 8;
    public static final int MAX_SCROLL_LINE = 3;
    public static final float SCROLL_SPEED_FACTOR = 1.1f;
    public static final float SCROLL_SPEED_LINE_FACTOR = 0.9f;

    public static final String toEncyptString(String $this$toEncyptString) {
        CharSequence charSequence = $this$toEncyptString;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return "";
        }
        try {
            byte[] aeResult = NativeBds.ae("comment_key", $this$toEncyptString);
            Intrinsics.checkNotNullExpressionValue(aeResult, "ae(key, this)");
            byte[] encode = Base64.encode(aeResult, 2);
            Intrinsics.checkNotNullExpressionValue(encode, "encode(aeResult, Base64.NO_WRAP)");
            return new String(encode, Charsets.UTF_8);
        } catch (Exception e2) {
            return "";
        }
    }

    public static final void barrageUBC(String type, VulcanBarrageInfo barrageInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (barrageInfo != null) {
            VulcanBarrageInfo $this$barrageUBC_u24lambda_u2d0 = barrageInfo;
            HashMap ubcParams = new HashMap();
            ubcParams.put("type", type);
            ubcParams.put("source", $this$barrageUBC_u24lambda_u2d0.getPage());
            ubcParams.put("topicID", $this$barrageUBC_u24lambda_u2d0.getTopicId());
            ubcParams.put("NID", $this$barrageUBC_u24lambda_u2d0.getNid());
            ubcParams.put("value", "1");
            BarrageUBCHelper.barrageVideoUBCEvent(ubcParams);
        }
    }
}
