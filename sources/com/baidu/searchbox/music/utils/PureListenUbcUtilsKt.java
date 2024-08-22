package com.baidu.searchbox.music.utils;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0001\u001a\u001a\u0010$\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0001\u001a$\u0010&\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010\u0001\u001aN\u0010&\u001a\u00020 2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u001a6\u0010&\u001a\u00020 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"FEED_TTS_FROM", "", "UBC_FEED_PAGE_TINGBA_PLAYER", "UBC_FEED_PAGE_TINGBA_PLAYER_JUMP_BTN", "UBC_FEED_PAGE_TINGBA_PLAYER_PLAY_BTN", "UBC_FEED_PAGE_TINGBA_PLAYER_TITLE", "UBC_FEED_PAGE_TINGBA_PLAYER_ZHUBO", "UBC_FEED_SOURCE_CLOSE", "UBC_FEED_SOURCE_OPEN", "UBC_FEED_SOURCE_PLAY", "UBC_FEED_SOURCE_STOP", "UBC_FEED_TTS_OPTION_ID", "UBC_FEED_TYPE_CLK", "UBC_FEED_TYPE_CURRENT_LIST_BROADCAST_SHOW", "UBC_FEED_TYPE_CURRENT_LIST_CLOSE_SHOW", "UBC_FEED_TYPE_CURRENT_TTS_LIST_CLK", "UBC_FEED_TYPE_KANTING_MODE_CLK", "UBC_FEED_TYPE_KANTING_MODE_CLOSE_SHOW", "UBC_FEED_TYPE_PURE_TTS_LIST_CLK", "UBC_FEED_TYPE_PURE_TTS_LIST_SHOW", "UBC_PURE_LISTEN_ID", "UBC_PURE_LISTEN_LISTEN_MORE_SOURCE", "UBC_PURE_LISTEN_LIST_ITEM_BUTTON", "UBC_PURE_LISTEN_MINIBAR_LIST_ENTRANCE_SOURCE", "UBC_PURE_LISTEN_MINIBAR_TITLE_SOURCE", "UBC_PURE_LISTEN_PAGE_CLOSE", "UBC_PURE_LISTEN_PAGE_TAB", "UBC_PURE_LISTEN_TTS_EAR_PHONE_SWITCH_SOURCE", "UBC_PURE_LISTEN_TTS_LIST_SOURCE", "UBC_TAB_SLIDE_TYPE", "UBC_TYPE_SHOW", "onPureListenPlayerUbc", "", "page", "type", "value", "onTTSOptionUbc", "source", "pureListenUBCEvent", "ubcId", "ext", "Lorg/json/JSONObject;", "lib-bdmedia-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PureListenUbcUtils.kt */
public final class PureListenUbcUtilsKt {
    private static final String FEED_TTS_FROM = "feed";
    public static final String UBC_FEED_PAGE_TINGBA_PLAYER = "tingba_player";
    public static final String UBC_FEED_PAGE_TINGBA_PLAYER_JUMP_BTN = "tingba_player_jump_btn";
    public static final String UBC_FEED_PAGE_TINGBA_PLAYER_PLAY_BTN = "tingba_player_play_btn";
    public static final String UBC_FEED_PAGE_TINGBA_PLAYER_TITLE = "tingba_player_title";
    public static final String UBC_FEED_PAGE_TINGBA_PLAYER_ZHUBO = "tingba_player_zhubo";
    public static final String UBC_FEED_SOURCE_CLOSE = "close";
    public static final String UBC_FEED_SOURCE_OPEN = "open";
    public static final String UBC_FEED_SOURCE_PLAY = "play";
    public static final String UBC_FEED_SOURCE_STOP = "stop";
    private static final String UBC_FEED_TTS_OPTION_ID = "656";
    public static final String UBC_FEED_TYPE_CLK = "clk";
    public static final String UBC_FEED_TYPE_CURRENT_LIST_BROADCAST_SHOW = "current_list_broadcast_show";
    public static final String UBC_FEED_TYPE_CURRENT_LIST_CLOSE_SHOW = "current_list_close_show";
    public static final String UBC_FEED_TYPE_CURRENT_TTS_LIST_CLK = "current_tts_list_clk";
    public static final String UBC_FEED_TYPE_KANTING_MODE_CLK = "kanting_mode_clk";
    public static final String UBC_FEED_TYPE_KANTING_MODE_CLOSE_SHOW = "kanting_mode_close_show";
    public static final String UBC_FEED_TYPE_PURE_TTS_LIST_CLK = "pure_tts_list_clk";
    public static final String UBC_FEED_TYPE_PURE_TTS_LIST_SHOW = "pure_tts_list_show";
    private static final String UBC_PURE_LISTEN_ID = "7528";
    public static final String UBC_PURE_LISTEN_LISTEN_MORE_SOURCE = "listen_more";
    public static final String UBC_PURE_LISTEN_LIST_ITEM_BUTTON = "tingba_list_button";
    public static final String UBC_PURE_LISTEN_MINIBAR_LIST_ENTRANCE_SOURCE = "minibar_list_entrance";
    public static final String UBC_PURE_LISTEN_MINIBAR_TITLE_SOURCE = "minibar_title";
    public static final String UBC_PURE_LISTEN_PAGE_CLOSE = "tingba_list_close";
    public static final String UBC_PURE_LISTEN_PAGE_TAB = "tingba_list_tab";
    public static final String UBC_PURE_LISTEN_TTS_EAR_PHONE_SWITCH_SOURCE = "tts_earphone_switch";
    public static final String UBC_PURE_LISTEN_TTS_LIST_SOURCE = "pure_tts_list";
    public static final String UBC_TAB_SLIDE_TYPE = "slide";
    public static final String UBC_TYPE_SHOW = "show";

    public static /* synthetic */ void onTTSOptionUbc$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        onTTSOptionUbc(str, str2);
    }

    public static final void onTTSOptionUbc(String type, String source) {
        Intrinsics.checkNotNullParameter(type, "type");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("from", "feed");
            jsonObject.put("type", type);
            jsonObject.put("source", source);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("656", jsonObject);
    }

    public static /* synthetic */ void onPureListenPlayerUbc$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        onPureListenPlayerUbc(str, str2, str3);
    }

    public static final void onPureListenPlayerUbc(String page, String type, String value) {
        Intrinsics.checkNotNullParameter(page, "page");
        pureListenUBCEvent(UBC_PURE_LISTEN_ID, type, (String) null, page, value, (JSONObject) null);
    }

    public static /* synthetic */ void pureListenUBCEvent$default(String str, String str2, String str3, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            jSONObject = null;
        }
        pureListenUBCEvent(str, str2, str3, jSONObject);
    }

    public static final void pureListenUBCEvent(String type, String source, String page, JSONObject ext) {
        pureListenUBCEvent(UBC_PURE_LISTEN_ID, type, source, page, (String) null, ext);
    }

    public static final void pureListenUBCEvent(String page, String type, String value) {
        pureListenUBCEvent(UBC_PURE_LISTEN_ID, type, (String) null, page, value, (JSONObject) null);
    }

    public static /* synthetic */ void pureListenUBCEvent$default(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            str4 = null;
        }
        if ((i2 & 16) != 0) {
            str5 = null;
        }
        if ((i2 & 32) != 0) {
            jSONObject = null;
        }
        pureListenUBCEvent(str, str2, str3, str4, str5, jSONObject);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[Catch:{ JSONException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[Catch:{ JSONException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ JSONException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[Catch:{ JSONException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004e A[Catch:{ JSONException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0062 A[Catch:{ JSONException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[Catch:{ JSONException -> 0x007b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void pureListenUBCEvent(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, org.json.JSONObject r9) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007b }
            r0.<init>()     // Catch:{ JSONException -> 0x007b }
            java.lang.String r1 = "from"
            java.lang.String r2 = "feed"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x007b }
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ JSONException -> 0x007b }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001d
            int r1 = r1.length()     // Catch:{ JSONException -> 0x007b }
            if (r1 != 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r1 = r2
            goto L_0x001e
        L_0x001d:
            r1 = r3
        L_0x001e:
            if (r1 != 0) goto L_0x0026
            java.lang.String r1 = "type"
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x007b }
        L_0x0026:
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ JSONException -> 0x007b }
            if (r1 == 0) goto L_0x0034
            int r1 = r1.length()     // Catch:{ JSONException -> 0x007b }
            if (r1 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = r2
            goto L_0x0035
        L_0x0034:
            r1 = r3
        L_0x0035:
            if (r1 != 0) goto L_0x003d
            java.lang.String r1 = "source"
            r0.put(r1, r6)     // Catch:{ JSONException -> 0x007b }
        L_0x003d:
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ JSONException -> 0x007b }
            if (r1 == 0) goto L_0x004b
            int r1 = r1.length()     // Catch:{ JSONException -> 0x007b }
            if (r1 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r1 = r2
            goto L_0x004c
        L_0x004b:
            r1 = r3
        L_0x004c:
            if (r1 != 0) goto L_0x0054
            java.lang.String r1 = "page"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x007b }
        L_0x0054:
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ JSONException -> 0x007b }
            if (r1 == 0) goto L_0x005f
            int r1 = r1.length()     // Catch:{ JSONException -> 0x007b }
            if (r1 != 0) goto L_0x0060
        L_0x005f:
            r2 = r3
        L_0x0060:
            if (r2 != 0) goto L_0x0068
            java.lang.String r1 = "value"
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x007b }
        L_0x0068:
            if (r9 == 0) goto L_0x006f
            java.lang.String r1 = "ext"
            r0.put(r1, r9)     // Catch:{ JSONException -> 0x007b }
        L_0x006f:
            com.baidu.pyramid.runtime.service.ServiceReference r1 = com.baidu.ubc.UBCManager.SERVICE_REFERENCE     // Catch:{ JSONException -> 0x007b }
            java.lang.Object r1 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r1)     // Catch:{ JSONException -> 0x007b }
            com.baidu.ubc.UBCManager r1 = (com.baidu.ubc.UBCManager) r1     // Catch:{ JSONException -> 0x007b }
            r1.onEvent((java.lang.String) r4, (org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.music.utils.PureListenUbcUtilsKt.pureListenUBCEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }
}
