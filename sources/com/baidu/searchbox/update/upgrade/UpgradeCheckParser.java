package com.baidu.searchbox.update.upgrade;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.MigrateStatisticConstants;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.home.tabs.theme.HomeTabDataUtils;
import com.baidu.searchbox.update.UpdateInfo;
import com.baidu.searchbox.update.UpdateSignUtil;
import com.baidu.searchbox.update.UpdateSpUtil;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class UpgradeCheckParser {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String FORCE = "1";
    public static final String KEY_DOWNLOAD_CON = "download_con";
    public static final String KEY_EXP_DATA = "expdata";
    private static final String KEY_IS_BACK_GROUND = "background";
    private static final String KEY_IS_BTN = "btn";
    private static final String KEY_IS_DAY = "day";
    private static final String KEY_IS_DESCRIPTS = "descripts";
    private static final String KEY_IS_DISPLAY_TIME = "displayTime";
    private static final String KEY_IS_END_BG_COLOR = "endBgColor";
    private static final String KEY_IS_END_BG_COLOR_NIGHT = "endBgColorNight";
    public static final String KEY_IS_FORCE = "isforce";
    private static final String KEY_IS_FORMAL = "isformal";
    private static final String KEY_IS_NIGHT = "night";
    private static final String KEY_IS_START_BG_COLOR = "startBgColor";
    private static final String KEY_IS_START_BG_COLOR_NIGHT = "startBgColorNight";
    private static final String KEY_IS_TEXT = "text";
    private static final String KEY_IS_TEXT_COLOR = "textColor";
    private static final String KEY_IS_TEXT_COLOR_NIGHT = "textColorNight";
    private static final String KEY_IS_TITLE = "title";
    private static final String KEY_IS_TOP_LEFT_ICON = "topLeftIcon";
    public static final String KEY_JSON_DATA = "json_data";
    public static final String KEY_MAX_RECORDS = "rec_max";
    public static final String KEY_NOTIFY_INFO = "notify_info";
    public static final String KEY_NOTIFY_TYPE = "notify_type";
    public static final String KEY_RECORD_USER_ACTION = "record_user_action";
    public static final String KEY_SIGN = "sign";
    public static final String KEY_SILENT_VERSION_INFO = "sil_version";
    public static final String KEY_TARGET_VERSION = "t_av";
    public static final String KEY_UPDATE_MD5 = "md5";
    public static final String KEY_UPDATE_TOAST = "toast";
    public static final String KEY_UPDATE_URL = "updateurl";
    public static final String KEY_URL = "htmlurl";
    public static final String KEY_VERSION = "version";
    public static final String KEY_VERSION_INFO = "version_info";
    public static final String KEY_VSTR = "vstr";
    public static final String RECORD = "1";
    protected UpdateData mCurData;
    private String mRn;

    public static class UpdateData extends UpdateInfo {
    }

    public UpgradeCheckParser(String rn) {
        this.mRn = rn;
    }

    public UpdateData getCurData() {
        return this.mCurData;
    }

    public UpdateData parseJson(JSONObject data) {
        if (data == null) {
            return null;
        }
        try {
            UpdateData updateData = new UpdateData();
            this.mCurData = updateData;
            updateData.setRn(this.mRn);
            if (data.has("version_info")) {
                JSONObject upgradeData = data.getJSONObject("version_info");
                if (upgradeData != null) {
                    if (!upgradeData.isNull("htmlurl")) {
                        parseToDialogMaterial(upgradeData);
                        this.mCurData.setForceUpgrade(TextUtils.equals("1", upgradeData.optString("isforce")));
                        this.mCurData.setVstr(upgradeData.getString("vstr"));
                        this.mCurData.setUpdateVersion(upgradeData.getString("t_av"));
                        this.mCurData.setUpdateVersionCode(Integer.valueOf(upgradeData.getString("version")).intValue());
                        this.mCurData.setMaxBtnRec(Integer.valueOf(upgradeData.getString(KEY_MAX_RECORDS)).intValue());
                        UpdateSpUtil.getInstance().putString(UpdateSpUtil.KEY_UPDATE_MAX_REC, upgradeData.getString(KEY_MAX_RECORDS));
                        if (TextUtils.equals(upgradeData.getString(KEY_RECORD_USER_ACTION), "1")) {
                            this.mCurData.setRecordUserAction(true);
                        }
                        if (DEBUG) {
                            Log.d("UpgradeCheckParser", "——> mCurData.isRecordAction() " + this.mCurData.isRecordAction());
                        }
                        this.mCurData.setIsFormal(upgradeData.optString(KEY_IS_FORMAL));
                        UpdateSpUtil.getInstance().putBoolean(UpdateSpUtil.KEY_REC_USER_ACTION, this.mCurData.isRecordAction());
                        String expStr = upgradeData.getString("expdata");
                        this.mCurData.setSigCheckMatched(false);
                        JSONObject expJson = new JSONObject(expStr);
                        if (UpdateSignUtil.checkSignVaild(expJson, this.mRn)) {
                            JSONObject dataJsonObj = new JSONObject(new String(Base64.decode(expJson.getString("data"), 0), "utf-8"));
                            this.mCurData.setUrl(dataJsonObj.getString("url"));
                            this.mCurData.setZipUrl(dataJsonObj.getString(HomeTabDataUtils.KEY_ZIP_URL));
                            this.mCurData.setZipMd5(dataJsonObj.getString("zip_md5"));
                            this.mCurData.setPreDownCon(dataJsonObj.optString("predowncon"));
                            this.mCurData.setJsData(dataJsonObj.getString("jsdata"));
                            this.mCurData.setSigCheckMatched(true);
                        } else {
                            MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UDPATE_VALID_FAILED_TYPE, MigrateStatisticUtils.build("EXPDATA VALID FAILED:" + expStr));
                        }
                    }
                }
                return this.mCurData;
            } else if (data.has("sil_version")) {
                JSONObject slientData = data.getJSONObject("sil_version");
                if (slientData != null) {
                    if (!slientData.isNull("updateurl")) {
                        String sign = slientData.getString("sign");
                        String jsonData = slientData.getString("json_data");
                        this.mCurData.setUpdateVersion(slientData.getString("t_av"));
                        this.mCurData.setUpdateVersionCode(Integer.valueOf(slientData.getString("version")).intValue());
                        this.mCurData.setMaxBtnRec(Integer.valueOf(slientData.getString(KEY_MAX_RECORDS)).intValue());
                        this.mCurData.setSigCheckMatched(false);
                        JSONObject jsonObj = new JSONObject(jsonData);
                        this.mCurData.setDownloadConditon(jsonObj.optString("download_con"));
                        this.mCurData.setNotifyType(jsonObj.optString("notify_type"));
                        this.mCurData.setNotifyInfo(jsonObj.optString("notify_info"));
                        this.mCurData.setUrl(jsonObj.optString("updateurl"));
                        this.mCurData.setSilentMD5(jsonObj.optString("md5"));
                        this.mCurData.setJsData("");
                        if (UpdateSignUtil.checkSignVaild(sign, jsonData, this.mRn)) {
                            this.mCurData.setSigCheckMatched(true);
                        }
                    }
                }
                return this.mCurData;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.mCurData = null;
            if (DEBUG) {
                Log.d("UpgradeCheckParser", "——> parseJson: " + e2.getMessage());
            }
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            this.mCurData = null;
            if (DEBUG) {
                Log.d("UpgradeCheckParser", "——> parseJson: " + e3.getMessage());
            }
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            this.mCurData = null;
            if (DEBUG) {
                Log.d("UpgradeCheckParser", "——> parseJson: " + e4.getMessage());
            }
        }
        return this.mCurData;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseToDialogMaterial(org.json.JSONObject r17) {
        /*
            r16 = this;
            r1 = r17
            if (r1 == 0) goto L_0x0144
            java.lang.String r0 = "toast"
            boolean r2 = r1.has(r0)
            if (r2 != 0) goto L_0x0011
            r5 = r16
            goto L_0x0146
        L_0x0011:
            org.json.JSONObject r0 = r1.optJSONObject(r0)     // Catch:{ Exception -> 0x011c }
            if (r0 == 0) goto L_0x0119
            com.baidu.searchbox.update.NonBlockIngUpdateDialogMaterial r2 = new com.baidu.searchbox.update.NonBlockIngUpdateDialogMaterial     // Catch:{ Exception -> 0x011c }
            r2.<init>()     // Catch:{ Exception -> 0x011c }
            java.lang.String r3 = "title"
            org.json.JSONObject r3 = r0.optJSONObject(r3)     // Catch:{ Exception -> 0x011c }
            java.lang.String r4 = "textColorNight"
            java.lang.String r5 = "textColor"
            java.lang.String r6 = "text"
            if (r3 == 0) goto L_0x0043
            java.lang.String r7 = r3.getString(r6)     // Catch:{ Exception -> 0x011c }
            r2.setMTitle(r7)     // Catch:{ Exception -> 0x011c }
            java.lang.String r7 = r3.optString(r5)     // Catch:{ Exception -> 0x011c }
            r2.setMTitleColor(r7)     // Catch:{ Exception -> 0x011c }
            java.lang.String r7 = r3.optString(r4)     // Catch:{ Exception -> 0x011c }
            r2.setMTitleColorNight(r7)     // Catch:{ Exception -> 0x011c }
        L_0x0043:
            java.lang.String r7 = "background"
            org.json.JSONObject r7 = r0.optJSONObject(r7)     // Catch:{ Exception -> 0x011c }
            java.lang.String r8 = "night"
            java.lang.String r9 = "day"
            if (r7 == 0) goto L_0x005d
            java.lang.String r10 = r7.optString(r9)     // Catch:{ Exception -> 0x011c }
            r2.setMBackgroundUrl(r10)     // Catch:{ Exception -> 0x011c }
            java.lang.String r10 = r7.optString(r8)     // Catch:{ Exception -> 0x011c }
            r2.setMBackgroundUrlNight(r10)     // Catch:{ Exception -> 0x011c }
        L_0x005d:
            java.lang.String r10 = "displayTime"
            int r10 = r0.getInt(r10)     // Catch:{ Exception -> 0x011c }
            long r10 = (long) r10     // Catch:{ Exception -> 0x011c }
            r2.setMDisplayTime(r10)     // Catch:{ Exception -> 0x011c }
            java.lang.String r10 = "descripts"
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x011c }
            if (r10 == 0) goto L_0x00aa
            org.json.JSONArray r11 = r10.optJSONArray(r6)     // Catch:{ Exception -> 0x011c }
            if (r11 == 0) goto L_0x009c
            int r12 = r11.length()     // Catch:{ Exception -> 0x011c }
            if (r12 <= 0) goto L_0x009c
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x011c }
            r12.<init>()     // Catch:{ Exception -> 0x011c }
            r13 = 0
        L_0x0081:
            int r14 = r11.length()     // Catch:{ Exception -> 0x011c }
            if (r13 >= r14) goto L_0x0099
            java.lang.String r14 = r11.optString(r13)     // Catch:{ Exception -> 0x011c }
            if (r14 == 0) goto L_0x0096
            boolean r15 = r14.isEmpty()     // Catch:{ Exception -> 0x011c }
            if (r15 != 0) goto L_0x0096
            r12.add(r14)     // Catch:{ Exception -> 0x011c }
        L_0x0096:
            int r13 = r13 + 1
            goto L_0x0081
        L_0x0099:
            r2.setMDescriptions(r12)     // Catch:{ Exception -> 0x011c }
        L_0x009c:
            java.lang.String r12 = r10.optString(r5)     // Catch:{ Exception -> 0x011c }
            r2.setMDescColor(r12)     // Catch:{ Exception -> 0x011c }
            java.lang.String r12 = r10.optString(r4)     // Catch:{ Exception -> 0x011c }
            r2.setMDescColorNight(r12)     // Catch:{ Exception -> 0x011c }
        L_0x00aa:
            java.lang.String r11 = "btn"
            org.json.JSONObject r11 = r0.optJSONObject(r11)     // Catch:{ Exception -> 0x011c }
            if (r11 == 0) goto L_0x00ed
            java.lang.String r6 = r11.getString(r6)     // Catch:{ Exception -> 0x011c }
            r2.setMActionText(r6)     // Catch:{ Exception -> 0x011c }
            java.lang.String r5 = r11.optString(r5)     // Catch:{ Exception -> 0x011c }
            r2.setMActionTextColor(r5)     // Catch:{ Exception -> 0x011c }
            java.lang.String r4 = r11.optString(r4)     // Catch:{ Exception -> 0x011c }
            r2.setMActionTextColorNight(r4)     // Catch:{ Exception -> 0x011c }
            java.lang.String r4 = "startBgColor"
            java.lang.String r4 = r11.optString(r4)     // Catch:{ Exception -> 0x011c }
            r2.setMActionBtnStartColor(r4)     // Catch:{ Exception -> 0x011c }
            java.lang.String r4 = "startBgColorNight"
            java.lang.String r4 = r11.optString(r4)     // Catch:{ Exception -> 0x011c }
            r2.setMActionBtnStartColorNight(r4)     // Catch:{ Exception -> 0x011c }
            java.lang.String r4 = "endBgColor"
            java.lang.String r4 = r11.optString(r4)     // Catch:{ Exception -> 0x011c }
            r2.setMActionBtnEndColor(r4)     // Catch:{ Exception -> 0x011c }
            java.lang.String r4 = "endBgColorNight"
            java.lang.String r4 = r11.optString(r4)     // Catch:{ Exception -> 0x011c }
            r2.setMActionBtnEndColorNight(r4)     // Catch:{ Exception -> 0x011c }
        L_0x00ed:
            java.lang.String r4 = "topLeftIcon"
            org.json.JSONObject r4 = r0.optJSONObject(r4)     // Catch:{ Exception -> 0x011c }
            if (r4 == 0) goto L_0x0104
            java.lang.String r5 = r4.optString(r9)     // Catch:{ Exception -> 0x011c }
            r2.setMTitleIcon(r5)     // Catch:{ Exception -> 0x011c }
            java.lang.String r5 = r4.optString(r8)     // Catch:{ Exception -> 0x011c }
            r2.setMTitleIconNight(r5)     // Catch:{ Exception -> 0x011c }
        L_0x0104:
            java.lang.String r5 = "downloadType"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x011c }
            r2.setMDownloadType(r5)     // Catch:{ Exception -> 0x011c }
            r5 = r16
            com.baidu.searchbox.update.upgrade.UpgradeCheckParser$UpdateData r6 = r5.mCurData     // Catch:{ Exception -> 0x0117 }
            if (r6 == 0) goto L_0x011b
            r6.setUpdateToastMaterial(r2)     // Catch:{ Exception -> 0x0117 }
            goto L_0x011b
        L_0x0117:
            r0 = move-exception
            goto L_0x011f
        L_0x0119:
            r5 = r16
        L_0x011b:
            goto L_0x0143
        L_0x011c:
            r0 = move-exception
            r5 = r16
        L_0x011f:
            r0.printStackTrace()
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x0143
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "——> parseToDialogMaterial: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "UpgradeCheckParser"
            android.util.Log.d(r3, r2)
        L_0x0143:
            return
        L_0x0144:
            r5 = r16
        L_0x0146:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.upgrade.UpgradeCheckParser.parseToDialogMaterial(org.json.JSONObject):void");
    }
}
