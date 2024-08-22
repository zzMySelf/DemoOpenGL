package com.tera.scan.flutter.plugin.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import com.tera.scan.record.database.DocScanProviderHelper;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.p030switch.rg.qw;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/flutter/plugin/fileviewer/FileViewerPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "()V", "channelName", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FileViewerPluginProxy extends BaseFlutterPlugin implements FlutterPlugin {
    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i2 != 100 || i3 != -1) {
            return false;
        }
        if (!TextUtils.equals(intent != null ? intent.getStringExtra("from") : null, "from_shot")) {
            return false;
        }
        Activity ad2 = ad();
        if (ad2 == null) {
            return true;
        }
        ad2.finish();
        return true;
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Activity ad2;
        Object obj;
        Activity ad3;
        MethodCall methodCall2 = methodCall;
        Intrinsics.checkNotNullParameter(methodCall2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall2.method;
        boolean z = true;
        String str2 = "";
        if (Intrinsics.areEqual((Object) str, (Object) "previewLocalPdf")) {
            String str3 = (String) methodCall2.argument("path");
            String str4 = str3 == null ? str2 : str3;
            String str5 = (String) methodCall2.argument("from");
            if (str4.length() != 0) {
                z = false;
            }
            if (!z && (ad3 = ad()) != null) {
                ad3.startActivity(DocumentViewerActivity.getStartIntent(ad3.getApplicationContext(), str4, "", -1, 0, ""));
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) "previewLocalWord")) {
            String str6 = (String) methodCall2.argument("path");
            String str7 = str6 == null ? str2 : str6;
            String str8 = (String) methodCall2.argument("record_id");
            if (str8 != null) {
                str2 = str8;
            }
            String str9 = (String) methodCall2.argument("from");
            if (str7.length() != 0) {
                z = false;
            }
            if (!z && new File(str7).exists() && (ad2 = ad()) != null) {
                Iterator it = new DocScanProviderHelper(qw.qw().getBduss()).xxx(ad2, str2, 0, 200).getSecond().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((ScanRecordExportFile) obj).getLocalPath(), (Object) str7)) {
                        break;
                    }
                }
                ad2.startActivityForResult(DocumentViewerActivity.getStartIntent(ad2.getApplicationContext(), str7, (ScanRecordExportFile) obj, str9, -1, 0, ""), 100);
            }
        } else {
            result.notImplemented();
        }
    }

    @NotNull
    public String qw() {
        return "file_viewer";
    }
}
