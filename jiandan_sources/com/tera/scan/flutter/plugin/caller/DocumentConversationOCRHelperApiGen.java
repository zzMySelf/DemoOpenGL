package com.tera.scan.flutter.plugin.caller;

import android.app.Activity;
import androidx.annotation.Keep;
import java.util.ArrayList;

@Keep
public interface DocumentConversationOCRHelperApiGen {
    void documentConvertClick(ArrayList<String> arrayList, String str, boolean z, Activity activity, VoidCallback<Void> voidCallback);

    void openOCRExportPDFActivity(Activity activity, String str, String str2, Boolean bool, ArrayList<String> arrayList, int i2);

    void showPayGuideDialog(Activity activity, int i2, int i3);

    void showPdfMergePayGuideDialog(Activity activity, int i2, int i3);
}
