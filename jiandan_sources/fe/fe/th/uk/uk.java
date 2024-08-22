package fe.fe.th.uk;

public final class uk {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.baidu.clientupdate.appinfo.RuleInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.baidu.clientupdate.appinfo.ClientUpdateInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: com.baidu.clientupdate.appinfo.RuleInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.baidu.clientupdate.appinfo.RuleInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.clientupdate.appinfo.AppInfo qw(org.json.JSONObject r3, int r4) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "content_url"
            if (r4 != 0) goto L_0x001d
            com.baidu.clientupdate.appinfo.ClientUpdateInfo r4 = new com.baidu.clientupdate.appinfo.ClientUpdateInfo
            r4.<init>()
            java.lang.String r0 = "isforce"
            java.lang.String r0 = r3.optString(r0)
            r4.mIsForceUpdate = r0
            java.lang.String r0 = r3.optString(r1)
            r4.mContentUrl = r0
            goto L_0x00a1
        L_0x001d:
            r2 = 3
            if (r2 != r4) goto L_0x011a
            com.baidu.clientupdate.appinfo.RuleInfo r4 = new com.baidu.clientupdate.appinfo.RuleInfo
            r4.<init>()
            java.lang.String r0 = "upgradeid"
            java.lang.String r2 = r3.optString(r0)
            r4.mUpgradeid = r2
            java.lang.String r2 = "level"
            java.lang.String r2 = r3.optString(r2)
            r4.mLevel = r2
            java.lang.String r2 = "silent_down"
            java.lang.String r2 = r3.optString(r2)
            r4.mSilentDown = r2
            java.lang.String r2 = "category"
            java.lang.String r2 = r3.optString(r2)
            r4.mCategory = r2
            java.lang.String r2 = "remind"
            java.lang.String r2 = r3.optString(r2)
            r4.mRemind = r2
            java.lang.String r2 = "remind_time"
            java.lang.String r2 = r3.optString(r2)
            r4.mRemindTime = r2
            java.lang.String r2 = "remind_point"
            java.lang.String r2 = r3.optString(r2)
            r4.mRemindPoint = r2
            java.lang.String r2 = "remind_place"
            java.lang.String r2 = r3.optString(r2)
            r4.mRemindPlace = r2
            java.lang.String r2 = "network"
            java.lang.String r2 = r3.optString(r2)
            r4.mNetwork = r2
            java.lang.String r2 = "wifi"
            java.lang.String r2 = r3.optString(r2)
            r4.mWifi = r2
            java.lang.String r2 = "gprs"
            java.lang.String r2 = r3.optString(r2)
            r4.mGprs = r2
            java.lang.String r2 = "visit_interface"
            java.lang.String r2 = r3.optString(r2)
            r4.mVisitInterface = r2
            java.lang.String r2 = "auto_download"
            java.lang.String r2 = r3.optString(r2)
            r4.mAutoDownload = r2
            java.lang.String r2 = "ruleid"
            java.lang.String r2 = r3.optString(r2)
            r4.mRuleid = r2
            java.lang.String r0 = r3.optString(r0)
            r4.mUpgradeid = r0
            java.lang.String r0 = r3.optString(r1)
            r4.mContentUrl = r0
        L_0x00a1:
            java.lang.String r0 = "label"
            java.lang.String r0 = r3.optString(r0)
            r4.mSname = r0
            java.lang.String r0 = "changelog"
            java.lang.String r0 = r3.optString(r0)
            r4.mChangelog = r0
            java.lang.String r0 = "sign"
            java.lang.String r0 = r3.optString(r0)
            r4.mSign = r0
            java.lang.String r0 = "prodline"
            java.lang.String r0 = r3.optString(r0)
            r4.mProdline = r0
            java.lang.String r0 = "downurl"
            java.lang.String r0 = r3.optString(r0)
            r4.mDownurl = r0
            java.lang.String r0 = "vname"
            java.lang.String r0 = r3.optString(r0)
            r4.mVername = r0
            java.lang.String r0 = "vcode"
            java.lang.String r0 = r3.optString(r0)
            r4.mVercode = r0
            java.lang.String r0 = "signmd5"
            java.lang.String r0 = r3.optString(r0)
            r4.mSignMd5 = r0
            java.lang.String r0 = "apkmd5"
            java.lang.String r0 = r3.optString(r0)
            r4.mApkMd5 = r0
            java.lang.String r0 = "size"
            java.lang.String r0 = r3.optString(r0)
            r4.mSize = r0
            java.lang.String r0 = "patch_downurl"
            java.lang.String r0 = r3.optString(r0)
            r4.mPatchDownUrl = r0
            java.lang.String r0 = "patch_size"
            java.lang.String r0 = r3.optString(r0)
            r4.mPatchSize = r0
            java.lang.String r0 = "iconurl"
            java.lang.String r0 = r3.optString(r0)
            r4.mIconUrl = r0
            java.lang.String r0 = "packagename"
            java.lang.String r0 = r3.optString(r0)
            r4.mPackageName = r0
            java.lang.String r0 = "update_time"
            java.lang.String r3 = r3.optString(r0)
            r4.mUpdateTime = r3
            return r4
        L_0x011a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.uk.uk.qw(org.json.JSONObject, int):com.baidu.clientupdate.appinfo.AppInfo");
    }
}
