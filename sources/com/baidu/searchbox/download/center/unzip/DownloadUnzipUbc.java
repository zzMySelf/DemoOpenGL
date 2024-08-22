package com.baidu.searchbox.download.center.unzip;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006JJ\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J$\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006J$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006J.\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/download/center/unzip/DownloadUnzipUbc;", "", "()V", "doUbc", "", "from", "", "page", "source", "type", "extFileType", "extErrorMessage", "ubc", "id", "value", "ext", "ubcUnZipDialog", "ubcWithDefaultParams", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadUnzipUbc.kt */
public final class DownloadUnzipUbc {
    public static final DownloadUnzipUbc INSTANCE = new DownloadUnzipUbc();

    private DownloadUnzipUbc() {
    }

    public final void ubcWithDefaultParams(String page, String source, String type) {
        ubcWithDefaultParams(page, source, type, "");
    }

    public final void ubcWithDefaultParams(String page, String source, String type, String ext) {
        ubc("1079", "tool", "compress", page, source, type, ext);
    }

    public final void ubcUnZipDialog(String value, String page, String type) {
        ubc(DownloadStatisticConstants.UBC_UNZIP_ID, "", value, page, "", type, "");
    }

    public final void ubc(String id, String from, String value, String page, String source, String type, String ext) {
        Intrinsics.checkNotNullParameter(id, "id");
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        JSONObject json = new JSONObject();
        if (!TextUtils.isEmpty(from)) {
            json.put("from", from);
        }
        if (!TextUtils.isEmpty(value)) {
            json.put("value", value);
        }
        if (!TextUtils.isEmpty(page)) {
            json.put("page", page);
        }
        if (!TextUtils.isEmpty(source)) {
            json.put("source", source);
        }
        if (!TextUtils.isEmpty(type)) {
            json.put("type", type);
        }
        if (!TextUtils.isEmpty(ext)) {
            json.put("ext", ext);
        }
        ubc.onEvent(id, json);
    }

    public static /* synthetic */ void doUbc$default(DownloadUnzipUbc downloadUnzipUbc, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        downloadUnzipUbc.doUbc(str, str2, str3, str4, str5, (i2 & 32) != 0 ? null : str6);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062 A[Catch:{ Exception -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0075 A[Catch:{ Exception -> 0x008d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void doUbc(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x008d }
            r0.<init>()     // Catch:{ Exception -> 0x008d }
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x008d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x008d }
            if (r1 != 0) goto L_0x0014
            java.lang.String r1 = "from"
            r0.put(r1, r6)     // Catch:{ Exception -> 0x008d }
        L_0x0014:
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x008d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x008d }
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = "page"
            r0.put(r1, r7)     // Catch:{ Exception -> 0x008d }
        L_0x0023:
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x008d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x008d }
            if (r1 != 0) goto L_0x0032
            java.lang.String r1 = "source"
            r0.put(r1, r8)     // Catch:{ Exception -> 0x008d }
        L_0x0032:
            r1 = r9
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x008d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x008d }
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = "type"
            r0.put(r1, r9)     // Catch:{ Exception -> 0x008d }
        L_0x0041:
            java.lang.String r1 = "value"
            java.lang.String r2 = "zip"
            r0.put(r1, r2)     // Catch:{ Exception -> 0x008d }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x008d }
            r1.<init>()     // Catch:{ Exception -> 0x008d }
            r2 = r10
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x008d }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x005f
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ Exception -> 0x008d }
            if (r2 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r2 = r3
            goto L_0x0060
        L_0x005f:
            r2 = r4
        L_0x0060:
            if (r2 != 0) goto L_0x0067
            java.lang.String r2 = "compress_type"
            r1.put(r2, r10)     // Catch:{ Exception -> 0x008d }
        L_0x0067:
            r2 = r11
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x008d }
            if (r2 == 0) goto L_0x0072
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ Exception -> 0x008d }
            if (r2 == 0) goto L_0x0073
        L_0x0072:
            r3 = r4
        L_0x0073:
            if (r3 != 0) goto L_0x007a
            java.lang.String r2 = "error_msg"
            r1.put(r2, r11)     // Catch:{ Exception -> 0x008d }
        L_0x007a:
            java.lang.String r2 = "ext"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x008d }
            com.baidu.pyramid.runtime.service.ServiceReference r2 = com.baidu.ubc.UBCManager.SERVICE_REFERENCE     // Catch:{ Exception -> 0x008d }
            java.lang.Object r2 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r2)     // Catch:{ Exception -> 0x008d }
            com.baidu.ubc.UBCManager r2 = (com.baidu.ubc.UBCManager) r2     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = "1079"
            r2.onEvent((java.lang.String) r3, (org.json.JSONObject) r0)     // Catch:{ Exception -> 0x008d }
            goto L_0x0097
        L_0x008d:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x0097
            r0.printStackTrace()
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.unzip.DownloadUnzipUbc.doUbc(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
