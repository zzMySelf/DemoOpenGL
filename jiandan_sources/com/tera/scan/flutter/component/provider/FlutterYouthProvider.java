package com.tera.scan.flutter.component.provider;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Keep;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import fe.mmm.qw.p024if.when.qw;
import java.util.ArrayList;

@Keep
public class FlutterYouthProvider {
    public void jumpToWatermarkEditPage(Activity activity, String str, ArrayList<String> arrayList, String str2) {
        Intent intent = new Intent();
        intent.putExtra("path", str);
        intent.putExtra("imageUrls", arrayList);
        qw.de(activity, "/netdisk/doc_scan/watermark_edit", intent.getExtras());
    }

    public void openFileMigrationHome(Activity activity, int i2) {
        qw.qw(activity, Integer.valueOf(i2), "youth/flutter/file_migration/home", new Intent().getExtras());
    }

    public void openOCRRectifyActivity(Activity activity, ArrayList<String> arrayList, int i2, int i3, ArrayList<String> arrayList2) {
        Intent intent = new Intent();
        intent.putExtra(OCRRectifyActivity.EXTRA_IMAGE_PATHS, arrayList);
        intent.putExtra(OCRRectifyActivity.EXTRA_SOURCE, i2);
        intent.putExtra(OCRRectifyActivity.EXTRA_CATEGORY, i3);
        intent.putExtra(OCRRectifyActivity.EXTRA_RESULT_DATA_LIST, arrayList2);
        qw.de(activity, "/netdisk/doc_scan", intent.getExtras());
    }

    public void openScanRecordActivity(Activity activity, String str) {
        Intent intent = new Intent();
        intent.putExtra("from", str);
        qw.de(activity, "/netdisk/doc_scan_list", intent.getExtras());
    }

    public void openScanRecordDetail(Activity activity, String str) {
        Intent intent = new Intent();
        intent.putExtra("recordId", str);
        qw.de(activity, "/netdisk/doc_scan/record_detail", intent.getExtras());
    }
}
