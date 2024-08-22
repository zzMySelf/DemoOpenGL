package com.baidu.searchbox.music.data;

import android.text.TextUtils;
import com.baidu.searchbox.music.bean.Song;
import java.util.ArrayList;

public class CommonMusicParser extends AbstractMusicParser {
    private static final String ERROR_STATUS_SUCCESS = "0";
    private static final String KEY_CMD = "603";
    private static final String KEY_DATA = "data";
    private static final String KEY_DATA_CURRENT_INDEX = "currentIndex";
    private static final String KEY_DATA_DATA = "data";
    private static final String KEY_DATA_EXTRA = "extra";
    private static final String KEY_DATA_HAS_MORE = "has_more";
    private static final String KEY_DATA_LIST = "list";
    private static final String KEY_DATA_PN = "pn";
    private static final String KEY_DATA_SIGN = "sign";
    private static final String KEY_DATA_SONG_PARAMS = "songParams";
    private static final String KEY_ERROR_NO = "errno";
    private static final String KEY_FEED_CMD = "255";
    private static final String KEY_PLAYLIST_INIT_STRATEGY = "dataReplace";
    private int mCurrentIndex;
    private String mResourceKey = "";
    private String mResourceSign = "";
    private ArrayList<Song> mSongList;

    public String getResourceSign() {
        return this.mResourceSign;
    }

    public void setResouceKey(String resouceKey) {
        if (!TextUtils.isEmpty(resouceKey)) {
            this.mResourceKey = resouceKey;
        }
    }

    public void clearResource() {
        ArrayList<Song> arrayList = this.mSongList;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mSongList = null;
        this.mResourceSign = "";
        this.mResourceKey = "";
        this.mCurrentIndex = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0162 A[Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0132 A[Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0134 A[Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x013d A[Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0155 A[Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseResponse(java.io.InputStream r20, com.baidu.searchbox.music.data.AbstractMusicParser.DataParserCallback r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r21
            java.lang.String r0 = "songParams"
            java.lang.String r3 = "data"
            java.lang.String r4 = "list"
            if (r20 == 0) goto L_0x01a5
            if (r2 != 0) goto L_0x0011
            goto L_0x01a5
        L_0x0011:
            java.lang.String r5 = com.baidu.android.util.io.StreamUtils.streamToString(r20)
            if (r5 != 0) goto L_0x001d
            r0 = -100
            r2.onFail(r0)
            return
        L_0x001d:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            r6.<init>(r5)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            java.lang.String r7 = "errno"
            java.lang.String r7 = r6.optString(r7)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            r9 = -101(0xffffffffffffff9b, float:NaN)
            if (r8 != 0) goto L_0x0178
            java.lang.String r8 = "0"
            boolean r8 = r7.equals(r8)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            if (r8 != 0) goto L_0x003e
            r17 = r5
            r18 = r6
            goto L_0x017c
        L_0x003e:
            org.json.JSONObject r8 = r6.optJSONObject(r3)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            if (r8 != 0) goto L_0x0052
            r2.onFail(r9)     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            return
        L_0x0048:
            r0 = move-exception
            r17 = r5
            goto L_0x0187
        L_0x004d:
            r0 = move-exception
            r17 = r5
            goto L_0x0197
        L_0x0052:
            r10 = 0
            java.lang.String r11 = r1.mResourceKey     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            java.lang.String r12 = "feed"
            boolean r11 = android.text.TextUtils.equals(r11, r12)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            if (r11 == 0) goto L_0x0065
            java.lang.String r11 = "255"
            org.json.JSONObject r11 = r8.optJSONObject(r11)     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            r10 = r11
            goto L_0x006c
        L_0x0065:
            java.lang.String r11 = "603"
            org.json.JSONObject r11 = r8.optJSONObject(r11)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            r10 = r11
        L_0x006c:
            if (r10 != 0) goto L_0x0072
            r2.onFail(r9)     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            return
        L_0x0072:
            r9 = 0
            java.lang.String r11 = r1.mResourceKey     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            org.json.JSONObject r11 = r10.optJSONObject(r11)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            r12 = 0
            if (r11 != 0) goto L_0x0091
            java.util.ArrayList<com.baidu.searchbox.music.bean.Song> r0 = r1.mSongList     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            if (r0 == 0) goto L_0x0081
            goto L_0x0086
        L_0x0081:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
        L_0x0086:
            com.baidu.searchbox.music.data.PlaylistModel r3 = new com.baidu.searchbox.music.data.PlaylistModel     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            int r4 = r1.mCurrentIndex     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            r3.<init>(r0, r4, r12)     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            r2.onDataparse(r12, r3)     // Catch:{ NumberFormatException -> 0x004d, JSONException -> 0x0048 }
            return
        L_0x0091:
            java.lang.String r13 = "sign"
            java.lang.String r13 = r11.optString(r13)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            org.json.JSONObject r3 = r11.optJSONObject(r3)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            if (r3 == 0) goto L_0x0119
            org.json.JSONArray r14 = r3.optJSONArray(r4)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            if (r14 == 0) goto L_0x0114
            org.json.JSONArray r14 = r3.optJSONArray(r4)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            int r14 = r14.length()     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            if (r14 != 0) goto L_0x00b4
            r17 = r5
            r18 = r6
            goto L_0x011d
        L_0x00b4:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            r14.<init>()     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            org.json.JSONArray r4 = r3.optJSONArray(r4)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            r15 = 0
        L_0x00be:
            int r12 = r4.length()     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            if (r15 >= r12) goto L_0x010d
            org.json.JSONObject r12 = r4.getJSONObject(r15)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            if (r12 == 0) goto L_0x00fd
            com.baidu.searchbox.music.bean.Song r16 = r1.parseSong(r12)     // Catch:{ NumberFormatException -> 0x0194, JSONException -> 0x0184 }
            r17 = r16
            r16 = r4
            r4 = r17
            if (r4 == 0) goto L_0x00f8
            r17 = r5
            java.lang.String r5 = r1.mResourceKey     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r4.mSource = r5     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            java.lang.String r5 = r4.mOnlineUrl     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            if (r5 != 0) goto L_0x00ed
            r18 = r6
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r4.playUrlUpdateTime = r5     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            goto L_0x00ef
        L_0x00ed:
            r18 = r6
        L_0x00ef:
            java.lang.String r5 = "schemeServer"
            r4.dataSource = r5     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r14.add(r4)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            goto L_0x0103
        L_0x00f8:
            r17 = r5
            r18 = r6
            goto L_0x0103
        L_0x00fd:
            r16 = r4
            r17 = r5
            r18 = r6
        L_0x0103:
            int r15 = r15 + 1
            r4 = r16
            r5 = r17
            r6 = r18
            r12 = 0
            goto L_0x00be
        L_0x010d:
            r16 = r4
            r17 = r5
            r18 = r6
            goto L_0x011e
        L_0x0114:
            r17 = r5
            r18 = r6
            goto L_0x011d
        L_0x0119:
            r17 = r5
            r18 = r6
        L_0x011d:
            r14 = 0
        L_0x011e:
            r4 = 0
            if (r3 == 0) goto L_0x0130
            org.json.JSONObject r5 = r3.optJSONObject(r0)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            if (r5 == 0) goto L_0x0130
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            com.baidu.searchbox.music.ext.model.ISong r0 = com.baidu.searchbox.music.ext.model.SongParser.parseJsonAsSong(r0)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r4 = r0
        L_0x0130:
            if (r3 != 0) goto L_0x0134
            r0 = 0
            goto L_0x013a
        L_0x0134:
            java.lang.String r0 = "extra"
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
        L_0x013a:
            r5 = 0
            if (r0 == 0) goto L_0x0153
            java.lang.String r6 = "currentIndex"
            int r6 = r0.optInt(r6)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r1.mCurrentIndex = r6     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            java.lang.String r6 = "dataReplace"
            r12 = 0
            int r6 = r0.optInt(r6, r12)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r5 = r6
            if (r5 == 0) goto L_0x0153
            r6 = 1
            if (r5 == r6) goto L_0x0153
            r5 = 0
        L_0x0153:
            if (r14 == 0) goto L_0x0160
            java.util.ArrayList<com.baidu.searchbox.music.bean.Song> r6 = r1.mSongList     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            if (r6 == 0) goto L_0x015c
            r6.clear()     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
        L_0x015c:
            r1.mResourceSign = r13     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r1.mSongList = r14     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
        L_0x0160:
            if (r14 != 0) goto L_0x0169
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r12 = 0
            r6.<init>(r12)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r14 = r6
        L_0x0169:
            com.baidu.searchbox.music.data.PlaylistModel r6 = new com.baidu.searchbox.music.data.PlaylistModel     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            int r12 = r1.mCurrentIndex     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r6.<init>(r14, r12, r5)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r6.setCurInvokeSong(r4)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            r12 = 0
            r2.onDataparse(r12, r6)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            goto L_0x01a3
        L_0x0178:
            r17 = r5
            r18 = r6
        L_0x017c:
            r2.onFail(r9)     // Catch:{ NumberFormatException -> 0x0182, JSONException -> 0x0180 }
            return
        L_0x0180:
            r0 = move-exception
            goto L_0x0187
        L_0x0182:
            r0 = move-exception
            goto L_0x0197
        L_0x0184:
            r0 = move-exception
            r17 = r5
        L_0x0187:
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x018e
            r0.printStackTrace()
        L_0x018e:
            r3 = -103(0xffffffffffffff99, float:NaN)
            r2.onFail(r3)
            goto L_0x01a4
        L_0x0194:
            r0 = move-exception
            r17 = r5
        L_0x0197:
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x019e
            r0.printStackTrace()
        L_0x019e:
            r3 = -102(0xffffffffffffff9a, float:NaN)
            r2.onFail(r3)
        L_0x01a3:
        L_0x01a4:
            return
        L_0x01a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.music.data.CommonMusicParser.parseResponse(java.io.InputStream, com.baidu.searchbox.music.data.AbstractMusicParser$DataParserCallback):void");
    }
}
