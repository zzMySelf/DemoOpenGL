package com.baidu.browser.ioc;

import android.content.ContentValues;
import android.content.Context;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.ISailorWebViewExt;

public interface IBrowserDownload {
    void doDownload(Context context, String str, String str2, String str3, String str4, String str5, long j2, ContentValues contentValues);

    void doDownload(Context context, String str, String str2, String str3, String str4, String str5, String str6, long j2);

    void doDownload(Context context, String str, String str2, String str3, String str4, String str5, String str6, long j2, ContentValues contentValues);

    void doDownloadJob(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    void doDownloadJob(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, ContentValues contentValues);

    String getConstantExtraSource();

    int getConstantFileManagerSourceMenu();

    Class<?> getFileManagerActivityClass();

    void processSaveWebForDebug(ISailorWebViewExt iSailorWebViewExt, Context context);

    void saveWebArchive(String str, String str2, BdSailorWebView bdSailorWebView, Context context, String str3);

    void showDownloadDialog(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j2, String str10, String str11, byte[] bArr);

    void showDownloadDialog(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j2, byte[] bArr);
}
