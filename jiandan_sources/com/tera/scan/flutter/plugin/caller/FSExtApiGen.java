package com.tera.scan.flutter.plugin.caller;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Map;

@Keep
public interface FSExtApiGen {
    void getFilesMeta(Context context, String str, GetFileMetaCallback getFileMetaCallback);

    void getFilesMetaByFsid(Context context, String str, GetFileMetaCallback getFileMetaCallback);

    void openNetdiskFile(Activity activity, long j, String str, boolean z, String str2, int i2, ResultCallback<Boolean> resultCallback);

    void printFiles(ArrayList<String> arrayList, boolean z, Activity activity);

    void saveToAlbumFiles(Activity activity, ArrayList<Map<String, String>> arrayList, boolean z, String str, ResultCallback<Boolean> resultCallback);

    void shareOCRImagePdf(Activity activity, String str, String str2, boolean z, String str3, String str4, String str5);

    void shareOCRImagePdf(Activity activity, ArrayList<Map<String, String>> arrayList, boolean z, String str, String str2, Boolean bool);

    void systemPrintFiles(Activity activity, ArrayList<Map<String, String>> arrayList, boolean z, String str);
}
