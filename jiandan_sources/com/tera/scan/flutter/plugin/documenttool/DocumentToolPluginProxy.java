package com.tera.scan.flutter.plugin.documenttool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.ubc.UBCManager;
import com.baidubce.services.vod.VodClient;
import com.google.gson.Gson;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import com.tera.scan.model.CropInfo;
import com.tera.scan.model.ImageCropPredictor;
import com.tera.scan.model.ImageEnhance;
import com.tera.scan.model.ImagePredictor;
import com.tera.scan.model.ImagePredictorCallback;
import com.tera.scan.model.callback.IImageEnhanceResult;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import com.tera.scan.record.database.DocScanProviderHelper;
import com.tera.scan.record.database.ScanRecordSortRule;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import fe.mmm.qw.p024if.pf.de.yj;
import fe.mmm.qw.p024if.pf.th.Cif;
import fe.mmm.qw.p024if.pf.th.Cswitch;
import fe.mmm.qw.p024if.pf.th.ggg;
import fe.mmm.qw.p024if.pf.th.i;
import fe.mmm.qw.p024if.pf.th.o;
import fe.mmm.qw.p024if.pf.th.pf;
import fe.mmm.qw.p024if.pf.th.ppp;
import fe.mmm.qw.p024if.pf.th.th;
import fe.mmm.qw.p024if.pf.th.uk;
import fe.mmm.qw.p024if.pf.th.when;
import i.qw.i0;
import i.qw.u;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J6\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u001e\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\"\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010#\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\n\u0010$\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010%\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\tH\u0002J\u0010\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0002J\u0018\u00100\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u00101\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u00102\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u00103\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u00104\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u00105\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u00106\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u00020\u000f2\b\u0010A\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020?H\u0016J\u001c\u0010D\u001a\u00020\u000f2\b\u0010A\u001a\u0004\u0018\u00010!2\b\u0010E\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010F\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010G\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010H\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010I\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010J\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010K\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010L\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010M\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010N\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010O\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010P\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010Q\u001a\u00020\u000fH\u0002J\u0018\u0010R\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010S\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010T\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010U\u001a\u00020\u000f2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/tera/scan/flutter/plugin/documenttool/DocumentToolPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "()V", "eventChannel", "Lio/flutter/plugin/common/EventChannel;", "eventSinkCache", "", "", "Lio/flutter/plugin/common/EventChannel$EventSink;", "recognizeChannel", "scanDataChangeEventChannel", "Lcom/tera/scan/flutter/plugin/documenttool/ScanDataChangeEventChannel;", "addImageTextWatermark", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "bitmapToByteArray", "page", "", "bitmap", "Landroid/graphics/Bitmap;", "map", "", "channelName", "composeImagesToPDF", "cropDocArea", "deleteScanRecordByRecordIds", "params", "", "", "deleteScanRecordExportFile", "deleteScanRecordPictures", "docAreaPathRecognizeEventSink", "docAreaRecognizeEventSink", "docEditClick", "docScanAreaRecognition", "docScanAreaRecognitionAppend", "docScanFirstRecord", "exportPdf", "getLongValue", "", "key", "getNameFromPath", "path", "imageEnhanceFilter", "imageShadowFilter", "imageTextOcr", "insertScanExportFiles", "insertScanRecordFiles", "insertScanRecords", "localModelIsReady", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onCancel", "arguments", "onDetachedFromEngine", "binding", "onListen", "events", "onMethodCall", "openImageExtract", "pdfThumbCount", "pdfThumbs", "queryScanExport", "queryScanRecord", "queryScanRecordDetail", "retryScanRecordExportUpload", "retryScanRecordFileUpload", "scanDataSource", "showPayGuide", "startScanRecordDiff", "takeCameraShoot", "takeLocalPhotos", "updateScanRecordName", "updateScanRecordOpenTime", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DocumentToolPluginProxy extends BaseFlutterPlugin implements FlutterPlugin, EventChannel.StreamHandler {
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public EventChannel f282if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public Map<String, EventChannel.EventSink> f6930o = new LinkedHashMap();
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public EventChannel f6931pf;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public ggg f283switch;

    public static final class ad implements ImagePredictorCallback {
        public final /* synthetic */ DocumentToolPluginProxy qw;

        public ad(DocumentToolPluginProxy documentToolPluginProxy) {
            this.qw = documentToolPluginProxy;
        }

        public void predictorResult(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "resultMap");
            EventChannel.EventSink o2 = this.qw.qqq();
            if (o2 != null) {
                o2.success(map);
            }
            EventChannel.EventSink i2 = this.qw.aaa();
            if (i2 != null) {
                i2.success(map);
            }
        }
    }

    public static final class de implements ImagePredictorCallback {
        public final /* synthetic */ DocumentToolPluginProxy qw;

        public de(DocumentToolPluginProxy documentToolPluginProxy) {
            this.qw = documentToolPluginProxy;
        }

        public void predictorResult(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "resultMap");
            EventChannel.EventSink o2 = this.qw.qqq();
            if (o2 != null) {
                o2.success(map);
            }
            EventChannel.EventSink i2 = this.qw.aaa();
            if (i2 != null) {
                i2.success(map);
            }
        }
    }

    public static final class fe implements IImageEnhanceResult {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f6932ad;
        public boolean qw;

        public fe(MethodChannel.Result result) {
            this.f6932ad = result;
        }

        public void ad(boolean z) {
            if (!this.qw) {
                this.qw = true;
                this.f6932ad.success(Boolean.valueOf(z));
                LoggerKt.e$default("zsj Flutter 通道 滤镜结束 " + System.currentTimeMillis(), (Object) null, 1, (Object) null);
            }
        }

        public void qw(@Nullable byte[] bArr) {
            this.f6932ad.success(bArr);
            LoggerKt.e$default("zsj Flutter 通道 滤镜结束 " + System.currentTimeMillis(), (Object) null, 1, (Object) null);
        }
    }

    public static final class qw implements IPdfEditCallback {
        public final /* synthetic */ MethodChannel.Result qw;

        public qw(MethodChannel.Result result) {
            this.qw = result;
        }

        public void ad(@Nullable String str) {
            this.qw.success(str);
        }

        public void qw(int i2) {
        }
    }

    public static final class rg implements IImageEnhanceResult {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f6933ad;
        public boolean qw;

        public rg(MethodChannel.Result result) {
            this.f6933ad = result;
        }

        public void ad(boolean z) {
            this.f6933ad.success((Object) null);
        }

        public void qw(@Nullable byte[] bArr) {
            if (!this.qw) {
                this.qw = true;
                this.f6933ad.success(bArr);
            }
        }
    }

    public static final void I(MethodChannel.Result result, int i2) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.valueOf(i2 > 0));
    }

    public static final void ddd(MethodChannel.Result result, int i2) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.valueOf(i2 > 0));
    }

    public static final void j(MethodChannel.Result result, boolean z) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.valueOf(z));
    }

    public static final void l(MethodChannel.Result result, boolean z) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.valueOf(z));
        LoggerKt.d$default("scan_record >> insertScanRecordFiles >> success=" + z, (Object) null, 1, (Object) null);
    }

    public static final void mmm(MethodChannel.Result result, int i2) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.valueOf(i2 > 0));
    }

    public static final void n(MethodChannel.Result result, boolean z) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.valueOf(z));
    }

    public static final void ppp(Ref.BooleanRef booleanRef, MethodChannel.Result result, String str) {
        Intrinsics.checkNotNullParameter(booleanRef, "$replyed");
        Intrinsics.checkNotNullParameter(result, "$result");
        if (!booleanRef.element) {
            booleanRef.element = true;
            result.success(str);
        }
    }

    public static final void rrr(MethodChannel.Result result, Void voidR) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(0);
    }

    public static final void u(MethodChannel.Result result, List list) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(list, "$exportList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(fe.mmm.qw.rrr.ad.ad.ad((ScanRecordExportFile) it.next()));
        }
        result.success(CollectionsKt___CollectionsKt.toList(arrayList));
    }

    public static final void vvv(MethodChannel.Result result, int i2) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.valueOf(i2 > 0));
    }

    public static final void w(MethodChannel.Result result, List list) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(list, "$recordList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(fe.mmm.qw.rrr.ad.ad.qw((ScanRecord) it.next()));
        }
        result.success(CollectionsKt___CollectionsKt.toList(arrayList));
    }

    public static final void y(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success((Object) null);
    }

    public static final void z(MethodChannel.Result result, Activity activity, String str) {
        Intrinsics.checkNotNullParameter(result, "$result");
        ScanRecord ggg = new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).ggg(activity, str);
        result.success(ggg != null ? fe.mmm.qw.rrr.ad.ad.qw(ggg) : null);
    }

    public final void A(Map<String, ? extends Object> map, MethodChannel.Result result) {
    }

    public final void B(Map<String, ? extends Object> map, MethodChannel.Result result) {
    }

    public final void C(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("fun_name");
        Map map = (Map) methodCall.argument("params");
        if (str != null) {
            switch (str.hashCode()) {
                case -1333743831:
                    if (str.equals("retry_scan_record_export_upload")) {
                        A(map, result);
                        return;
                    }
                    return;
                case -1291256172:
                    if (str.equals("query_scan_record_detail")) {
                        x(map, result);
                        return;
                    }
                    return;
                case -978194050:
                    if (str.equals("add_scan_record_export")) {
                        h(map, result);
                        return;
                    }
                    return;
                case -841325906:
                    if (str.equals("start_scan_record_diff")) {
                        E();
                        return;
                    }
                    return;
                case -767557953:
                    if (str.equals("query_scan_export")) {
                        t(map, result);
                        return;
                    }
                    return;
                case -763549791:
                    if (str.equals("retry_scan_record_file_upload")) {
                        B(map, result);
                        return;
                    }
                    return;
                case -496387659:
                    if (str.equals("add_scan_record")) {
                        m(map, result);
                        return;
                    }
                    return;
                case -413313188:
                    if (str.equals("query_scan_record")) {
                        v(map, result);
                        return;
                    }
                    return;
                case -327480665:
                    if (str.equals("delete_scan_record_export_file")) {
                        xxx(map, result);
                        return;
                    }
                    return;
                case 465668031:
                    if (str.equals("delete_scan_record")) {
                        ggg(map, result);
                        return;
                    }
                    return;
                case 665045952:
                    if (str.equals("update_scan_record_open_time")) {
                        J(map, result);
                        return;
                    }
                    return;
                case 1689400245:
                    if (str.equals("delete_scan_record_pictures")) {
                        nn(map, result);
                        return;
                    }
                    return;
                case 1749276287:
                    if (str.equals("add_scan_record_pictures")) {
                        k(map, result);
                        return;
                    }
                    return;
                case 1882314669:
                    if (str.equals("update_scan_record_name")) {
                        H(map, result);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void D(MethodCall methodCall, MethodChannel.Result result) {
        th().put("showDocPayGuide", result);
        Integer num = (Integer) methodCall.argument("type");
        if (num == null) {
            num = 0;
        }
        fe.mmm.qw.p024if.pf.de.fe.de(ad(), 1202, num.intValue());
    }

    public final void E() {
    }

    public final void F(MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        th().put("reShoot", result);
        Integer num = (Integer) methodCall2.argument("replaceIndex");
        Integer num2 = 0;
        if (num == null) {
            num = num2;
        }
        int intValue = num.intValue();
        Integer num3 = (Integer) methodCall2.argument("maxCount");
        if (num3 == null) {
            num3 = num2;
        }
        int intValue2 = num3.intValue();
        Integer num4 = (Integer) methodCall2.argument("currentCount");
        if (num4 == null) {
            num4 = num2;
        }
        int intValue3 = num4.intValue();
        Integer num5 = (Integer) methodCall2.argument(VodClient.PARA_MODE);
        if (num5 == null) {
            num5 = 2;
        }
        int intValue4 = num5.intValue();
        Integer num6 = (Integer) methodCall2.argument(UBCManager.CONTENT_KEY_SOURCE);
        if (num6 == null) {
            num6 = 2;
        }
        int intValue5 = num6.intValue();
        String str = (String) methodCall2.argument(OCRTakePhotoActivity.ROUTER_INIT_TAB);
        if (str == null) {
            str = "pdf";
        }
        String str2 = str;
        Integer num7 = (Integer) methodCall2.argument("category");
        if (num7 == null) {
            num7 = -1;
        }
        int intValue6 = num7.intValue();
        Integer num8 = (Integer) methodCall2.argument("subCount");
        if (num8 != null) {
            num2 = num8;
        }
        int intValue7 = num2.intValue();
        String str3 = (String) methodCall2.argument("ubcSource");
        if (str3 == null) {
            str3 = "";
        }
        int i2 = intValue2 - intValue3;
        yj.ad(ad(), 1200, i2, str2, intValue4, intValue, intValue5, intValue6);
        Activity ad2 = ad();
        if (ad2 != null) {
            OCRTakePhotoActivity.ad adVar = OCRTakePhotoActivity.Companion;
            Context applicationContext = ad2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
            ad2.startActivityForResult(adVar.qw(applicationContext, str2, intValue4, intValue, intValue7, i2, intValue5, intValue6, str3), 1200);
        }
    }

    public final void G(MethodCall methodCall, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 != null) {
            th().put("openLocalAlbum", result);
            Integer num = (Integer) methodCall.argument("maxCount");
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue();
            Integer num2 = (Integer) methodCall.argument("currentCount");
            if (num2 == null) {
                num2 = 0;
            }
            int intValue2 = num2.intValue();
            String str = (String) methodCall.argument("ubcSource");
            if (str == null) {
                str = "";
            }
            int i2 = intValue - intValue2;
            LocalImageSelectActivity.qw.fe(LocalImageSelectActivity.Companion, ad2, i2, 4500, 1201, 0, str, 16, (Object) null);
        }
    }

    public final void H(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Object obj = null;
        String str = (String) (map != null ? map.get("record_id") : null);
        if (map != null) {
            obj = map.get("name");
        }
        String str2 = (String) obj;
        Activity ad2 = ad();
        if (ad2 == null || str == null || str2 == null) {
            result.success(Boolean.FALSE);
        } else {
            ad2.runOnUiThread(new fe.mmm.qw.p024if.pf.th.ad(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).aaa(ad2, str, str2)));
        }
    }

    public final void J(Map<String, ? extends Object> map, MethodChannel.Result result) {
        long j;
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        Long l = null;
        Object obj = map != null ? map.get("record_id") : null;
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map != null ? map.get("time_in_second") : null;
        if (obj2 instanceof Integer) {
            j = (long) ((Number) obj2).intValue();
        } else {
            if (obj2 instanceof Long) {
                l = (Long) obj2;
            }
            j = l != null ? l.longValue() : Calendar.getInstance().getTimeInMillis() / ((long) 1000);
        }
        result.success(Boolean.valueOf(new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).qqq(ad2, Long.valueOf(j), str)));
    }

    public final void a(MethodCall methodCall, MethodChannel.Result result) {
        List list = (List) methodCall.argument("imagePathList");
        if (list == null) {
            list = new ArrayList();
        }
        Boolean bool = (Boolean) methodCall.argument("priority");
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Context rg2 = rg();
        if (rg2 == null) {
            result.success(MapsKt__MapsKt.emptyMap());
        } else {
            ImagePredictor.f7037o.qw().nn(rg2, list, booleanValue ? 1 : 0, new de(this));
        }
    }

    public final EventChannel.EventSink aaa() {
        return this.f6930o.get("areaPathRecognizeListener");
    }

    public final void b(MethodCall methodCall, MethodChannel.Result result) {
        Integer num = (Integer) methodCall.argument("hasData");
        if (num == null) {
            num = 0;
        }
        int intValue = num.intValue();
        long d = d(methodCall, "mTime");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hasData", intValue);
        jSONObject.put("path", (String) methodCall.argument("path"));
        jSONObject.put("mtime", d);
        jSONObject.put("name", (String) methodCall.argument("name"));
        jSONObject.put("pageCount", (Integer) methodCall.argument("pageCount"));
        fe.mmm.qw.p024if.pf.de.de.o("key_newest_scan_record", jSONObject.toString(), true);
    }

    public final void c(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        th().put("ocrExportPdf", result);
        String str2 = (String) methodCall.argument("fileName");
        String str3 = str2 == null ? "" : str2;
        String str4 = (String) methodCall.argument("remotePath");
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        Boolean bool = (Boolean) methodCall.argument("sA4");
        if (bool == null) {
            bool = Boolean.TRUE;
        }
        boolean booleanValue = bool.booleanValue();
        ArrayList arrayList = (ArrayList) methodCall.argument("files");
        Integer num = (Integer) methodCall.argument(UBCManager.CONTENT_KEY_SOURCE);
        if (num == null) {
            num = 0;
        }
        fe.mmm.qw.p024if.pf.de.fe.ad(ad(), str3, str, Boolean.valueOf(booleanValue), arrayList, num.intValue());
    }

    public final long d(MethodCall methodCall, String str) {
        int argument = methodCall.argument(str);
        if (argument == null) {
            argument = 0;
        }
        if (argument instanceof Integer) {
            argument = Long.valueOf((long) ((Number) argument).intValue());
        }
        return ((Long) argument).longValue();
    }

    public final void e(MethodCall methodCall, MethodChannel.Result result) {
        th().put("imageEnhanceFilter", result);
        String str = (String) methodCall.argument("imagePath");
        String str2 = (String) methodCall.argument("resultPath");
        LoggerKt.e$default("zsj Flutter 通道 开始滤镜 " + System.currentTimeMillis(), (Object) null, 1, (Object) null);
        Boolean bool = (Boolean) methodCall.argument("postProcess");
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Boolean bool2 = (Boolean) methodCall.argument("enalbeDewarp");
        boolean booleanValue2 = bool2 == null ? true : bool2.booleanValue();
        Context rg2 = rg();
        if (str == null) {
            result.success((Object) null);
        } else if (str2 == null) {
            result.success((Object) null);
        } else if (rg2 == null) {
            result.success((Object) null);
        } else {
            ImageEnhance.f7031yj.qw().uk(rg2, str, str2, booleanValue, booleanValue2, new fe(result));
        }
    }

    public final void eee(MethodCall methodCall, MethodChannel.Result result) {
        Collection collection = (List) methodCall.argument("fsids");
        if (collection == null) {
            collection = new ArrayList();
        }
        List<Map> list = (List) methodCall.argument("entrances");
        boolean z = false;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (Map map : list) {
                if (map != null) {
                    try {
                        if (!map.keySet().isEmpty()) {
                            JSONObject jSONObject = new JSONObject();
                            for (String str : map.keySet()) {
                                jSONObject.put(str, map.get(str));
                            }
                            jSONArray.put(jSONObject);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
            Boolean bool = (Boolean) methodCall.argument("fromSearch");
            if (bool != null) {
                z = bool.booleanValue();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(collection);
            fe.mmm.qw.p024if.pf.de.fe.qw(arrayList, jSONArray2, z, ad(), new th(result));
        }
    }

    public final void f(MethodCall methodCall, MethodChannel.Result result) {
        th().put("imageShadowFilter", result);
        String str = (String) methodCall.argument("imagePath");
        Boolean bool = (Boolean) methodCall.argument("postProcess");
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Boolean bool2 = (Boolean) methodCall.argument("enalbeDewarp");
        boolean booleanValue2 = bool2 == null ? true : bool2.booleanValue();
        Context rg2 = rg();
        if (str == null) {
            result.success((Object) null);
        } else if (rg2 == null) {
            result.success((Object) null);
        } else {
            ImageEnhance.f7031yj.qw().i(rg2, str, booleanValue, booleanValue2, new rg(result));
        }
    }

    public final void g(MethodCall methodCall, MethodChannel.Result result) {
        Context rg2 = rg();
        if (rg2 != null) {
            List list = (List) methodCall.argument("files");
            if (list == null) {
                list = new ArrayList();
            }
            String str = (String) methodCall.argument("lan_type");
            if (str == null) {
                str = "";
            }
            fe.mmm.qw.rg.de.qqq.qw qwVar = new fe.mmm.qw.rg.de.qqq.qw(rg2, str, list);
            qwVar.de(new DocumentToolPluginProxy$imageTextOcr$1(result, qwVar, list));
        }
    }

    public final void ggg(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        List list = (List) (map != null ? map.get("record_id_list") : null);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ad2.runOnUiThread(new i(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).rg(ad2, list)));
    }

    public final void h(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        List list = (List) (map != null ? map.get("export_files") : null);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ad2.runOnUiThread(new uk(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).pf(ad2, fe.mmm.qw.rrr.ad.ad.th(list))));
    }

    /* renamed from: if  reason: not valid java name */
    public final void m759if(MethodCall methodCall, MethodChannel.Result result) {
        List list = (List) methodCall.argument("imageUrls");
        if (list == null) {
            list = new ArrayList();
        }
        List list2 = list;
        String str = (String) methodCall.argument("text");
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Double d = (Double) methodCall.argument("textSize");
        double doubleValue = d == null ? 16.0d : d.doubleValue();
        Double d2 = (Double) methodCall.argument("textSizeScale");
        double doubleValue2 = d2 == null ? 1.0d : d2.doubleValue();
        Double d3 = (Double) methodCall.argument("textTransparency");
        double doubleValue3 = d3 == null ? 0.2d : d3.doubleValue();
        String str3 = (String) methodCall.argument("textColor");
        if (str3 == null) {
            str3 = "000000";
        }
        String str4 = str3;
        if (str2.length() == 0) {
            result.success(Boolean.FALSE);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("watermark_info_text_cache", str2);
        jSONObject.put("watermark_info_text_size_cache", doubleValue);
        jSONObject.put("watermark_info_text_size_scale_cache", doubleValue2);
        jSONObject.put("watermark_info_text_transparency_cache", doubleValue3);
        jSONObject.put("watermark_info_text_color_cache", str4);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        fe.mmm.qw.yj.th.ppp().m1013switch("key_watermark_info_cache", jSONObject2);
        if (fe.mmm.qw.qqq.i.ad.qw.qw(list2, str2, doubleValue, doubleValue2, doubleValue3, str4).isEmpty()) {
            result.success(Boolean.FALSE);
        } else {
            result.success(Boolean.TRUE);
        }
    }

    public final void k(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        List list = (List) (map != null ? map.get("pictures") : null);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ad2.runOnUiThread(new pf(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).m892if(ad2, fe.mmm.qw.rrr.ad.ad.uk(list))));
    }

    public final void m(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        List list = (List) (map != null ? map.get("scan_records") : null);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ad2.runOnUiThread(new Cif(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).m893switch(ad2, fe.mmm.qw.rrr.ad.ad.i(list))));
    }

    public final void nn(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        List list = null;
        Object obj = map != null ? map.get("files") : null;
        if (obj instanceof List) {
            list = (List) obj;
        }
        if (list == null) {
            result.success(Boolean.FALSE);
        } else {
            ad2.runOnUiThread(new fe.mmm.qw.p024if.pf.th.de(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).i(ad2, fe.mmm.qw.rrr.ad.ad.uk(list))));
        }
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        boolean z = false;
        if (1020 == i2) {
            th().get("showPdfMergePayGuide");
            MethodChannel.Result remove = th().remove("showPdfMergePayGuide");
            if (remove != null) {
                if (i3 == -1) {
                    z = true;
                }
                remove.success(Boolean.valueOf(z));
            }
            return true;
        }
        Object obj = null;
        if (i2 == 1201 && i3 == -1) {
            if (intent != null) {
                obj = intent.getSerializableExtra("extra_result_files");
            }
            MethodChannel.Result remove2 = th().remove("openLocalAlbum");
            if (remove2 != null) {
                remove2.success(obj);
            }
            return true;
        } else if (i2 == 1200 && i3 == -1) {
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("extra_result_files") : null;
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, 0)) : null;
            Integer valueOf2 = intent != null ? Integer.valueOf(intent.getIntExtra("doc_scan_mode", 0)) : null;
            if (intent != null) {
                obj = Integer.valueOf(intent.getIntExtra("doc_scan_filter_index", 0));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("extra_result_files", serializableExtra);
            hashMap.put(OCRTakePhotoActivity.EXTRA_RESULT_CATEGORY, valueOf);
            hashMap.put("doc_scan_mode", valueOf2);
            hashMap.put("doc_scan_filter_index", obj);
            MethodChannel.Result remove3 = th().remove("reShoot");
            if (remove3 != null) {
                remove3.success(hashMap);
            }
            return true;
        } else if (i2 == 1203 && i3 == -1) {
            if (intent != null) {
                obj = intent.getStringExtra("SELECT_PATH_STRING");
            }
            MethodChannel.Result remove4 = th().remove("selectNetdiskFile");
            if (remove4 != null) {
                remove4.success(obj);
            }
            return true;
        } else if (i2 != 1202) {
            return false;
        } else {
            MethodChannel.Result remove5 = th().remove("showDocPayGuide");
            if (remove5 != null) {
                if (i3 == -1) {
                    z = true;
                }
                remove5.success(Boolean.valueOf(z));
            }
            return true;
        }
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        super.onAttachedToEngine(flutterPluginBinding);
        EventChannel eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "document_tool/event_channel_docPathRecognize");
        this.f6931pf = eventChannel;
        if (eventChannel != null) {
            eventChannel.setStreamHandler(this);
        }
        EventChannel eventChannel2 = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "document_tool/event_channel");
        this.f282if = eventChannel2;
        if (eventChannel2 != null) {
            eventChannel2.setStreamHandler(this);
        }
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterPluginBinding.binaryMessenger");
        ggg ggg = new ggg(binaryMessenger, rg());
        this.f283switch = ggg;
        if (ggg != null) {
            ggg.vvv();
        }
    }

    public void onCancel(@Nullable Object obj) {
        if (obj instanceof String) {
            this.f6930o.remove(obj);
        }
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        super.onDetachedFromEngine(flutterPluginBinding);
        EventChannel eventChannel = this.f6931pf;
        if (eventChannel != null) {
            eventChannel.setStreamHandler((EventChannel.StreamHandler) null);
        }
        EventChannel eventChannel2 = this.f282if;
        if (eventChannel2 != null) {
            eventChannel2.setStreamHandler((EventChannel.StreamHandler) null);
        }
        ggg ggg = this.f283switch;
        if (ggg != null) {
            ggg.o();
        }
    }

    public void onListen(@Nullable Object obj, @Nullable EventChannel.EventSink eventSink) {
        boolean z = obj instanceof String;
        if (z && Intrinsics.areEqual((Object) "areaRecognizeListener", obj)) {
            this.f6930o.put("areaRecognizeListener", eventSink);
        } else if (z && Intrinsics.areEqual((Object) "areaPathRecognizeListener", obj)) {
            this.f6930o.put("areaPathRecognizeListener", eventSink);
        }
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Object obj;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1875800083:
                    if (str.equals("composeImagesToPDF")) {
                        m760switch(methodCall, result);
                        return;
                    }
                    break;
                case -1839805733:
                    if (str.equals("recognizeText")) {
                        String str2 = (String) methodCall.argument("filesInJson");
                        if (str2 != null) {
                            String str3 = (String) methodCall.argument("docSavePath");
                            try {
                                Result.Companion companion = Result.Companion;
                                fe.mmm.qw.p024if.pf.de.uk.qw(ad(), new JSONArray(str2).get(0).toString(), str3, fe.mmm.qw.p024if.pf.de.uk.ad());
                                obj = Result.m1155constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
                            }
                            if (Result.m1162isSuccessimpl(obj)) {
                                Unit unit = (Unit) obj;
                                result.success(Boolean.TRUE);
                            }
                            Throwable r0 = Result.m1158exceptionOrNullimpl(obj);
                            if (r0 != null) {
                                result.error("recognizeTextError", String.valueOf(r0.getMessage()), r0);
                            }
                            Result.m1154boximpl(obj);
                            return;
                        }
                        return;
                    }
                    break;
                case -1772613077:
                    if (str.equals("imageEnhanceFilter")) {
                        e(methodCall, result);
                        return;
                    }
                    break;
                case -1557868858:
                    if (str.equals("scanDataSourceAccess")) {
                        Job unused = i.qw.Cif.fe(i0.f6136ad, u.qw(), (CoroutineStart) null, new DocumentToolPluginProxy$onMethodCall$2(this, methodCall, result, (Continuation<? super DocumentToolPluginProxy$onMethodCall$2>) null), 2, (Object) null);
                        return;
                    }
                    break;
                case -1392772011:
                    if (str.equals("docScanAreaRecognition")) {
                        tt(methodCall, result);
                        return;
                    }
                    break;
                case -1140939341:
                    if (str.equals("imageShadowFilter")) {
                        f(methodCall, result);
                        return;
                    }
                    break;
                case -1127421077:
                    if (str.equals("pdfThumbCount")) {
                        r(methodCall, result);
                        return;
                    }
                    break;
                case -982030869:
                    if (str.equals("pdfThumbRequest")) {
                        s(methodCall, result);
                        return;
                    }
                    break;
                case -877830086:
                    if (str.equals("image_ocr")) {
                        g(methodCall, result);
                        return;
                    }
                    break;
                case -876860321:
                    if (str.equals("merge_images")) {
                        List list = (List) methodCall.argument("images");
                        if (list == null) {
                            list = new ArrayList();
                        }
                        Job unused2 = i.qw.Cif.fe(i0.f6136ad, u.qw(), (CoroutineStart) null, new DocumentToolPluginProxy$onMethodCall$3(this, result, list, (Continuation<? super DocumentToolPluginProxy$onMethodCall$3>) null), 2, (Object) null);
                        return;
                    }
                    break;
                case -707027290:
                    if (str.equals("imageExtract")) {
                        q(methodCall);
                        return;
                    }
                    break;
                case -377927371:
                    if (str.equals("cropDocArea")) {
                        when(methodCall, result);
                        return;
                    }
                    break;
                case -318880099:
                    if (str.equals("addImageTextWatermark")) {
                        m759if(methodCall, result);
                        return;
                    }
                    break;
                case 246728622:
                    if (str.equals("openLocalAlbum")) {
                        G(methodCall, result);
                        return;
                    }
                    break;
                case 262117190:
                    if (str.equals("docEditClick")) {
                        eee(methodCall, result);
                        return;
                    }
                    break;
                case 1067609516:
                    if (str.equals("reShoot")) {
                        F(methodCall, result);
                        return;
                    }
                    break;
                case 1095823695:
                    if (str.equals("showDocPayGuide")) {
                        D(methodCall, result);
                        return;
                    }
                    break;
                case 1137405216:
                    if (str.equals("ocrExportPdf")) {
                        c(methodCall, result);
                        return;
                    }
                    break;
                case 1190223419:
                    if (str.equals("localModelIsReady")) {
                        p(methodCall, result);
                        return;
                    }
                    break;
                case 1245078540:
                    if (str.equals("docScanFirstRecord")) {
                        b(methodCall, result);
                        return;
                    }
                    break;
                case 1825203151:
                    if (str.equals("docScanAreaRecognitionAppend")) {
                        a(methodCall, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    public final void p(MethodCall methodCall, MethodChannel.Result result) {
        result.success(Boolean.TRUE);
    }

    public final void q(MethodCall methodCall) {
        String str = (String) methodCall.argument("srcPath");
        String str2 = (String) methodCall.argument("cropPath");
        String str3 = (String) methodCall.argument(OCRRectifyActivity.EXTRA_SAVE_PATH);
        Integer num = (Integer) methodCall.argument(UBCManager.CONTENT_KEY_SOURCE);
        if (num == null) {
            num = 1;
        }
        num.intValue();
        String str4 = (String) methodCall.argument("ubcSource");
        if (str4 == null) {
            str4 = "";
        }
        String str5 = str4;
        Activity ad2 = ad();
        if (ad2 != null) {
            if (str2 != null) {
                str = str2;
            }
            if (str != null) {
                ad2.startActivity(TextRecognitionActivity.qw.ad(TextRecognitionActivity.Companion, ad2, CollectionsKt__CollectionsJVMKt.listOf(str), TextRecognitionActivity.FROM_SCAN_PREVIEW, (String) null, str5, 8, (Object) null));
            }
        }
    }

    public final EventChannel.EventSink qqq() {
        return this.f6930o.get("areaRecognizeListener");
    }

    @NotNull
    public String qw() {
        return "document_tool";
    }

    public final void r(MethodCall methodCall, MethodChannel.Result result) {
    }

    public final void s(MethodCall methodCall, MethodChannel.Result result) {
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m760switch(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("fileName");
        String str2 = (String) methodCall.argument("savePath");
        List list = (List) methodCall.argument("filesLocalPath");
        Boolean bool = (Boolean) methodCall.argument("isA4Size");
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        boolean booleanValue = bool.booleanValue();
        Boolean bool2 = (Boolean) methodCall.argument("showLogo");
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        boolean booleanValue2 = bool2.booleanValue();
        Context rg2 = rg();
        if (rg2 == null || str2 == null || list == null) {
            result.success((Object) null);
        } else {
            fe.mmm.qw.qqq.ad.qw.qw.qw(rg2, str2, new ArrayList(list), booleanValue, booleanValue2, new qw(result));
        }
    }

    public final void t(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(CollectionsKt__CollectionsKt.emptyList());
            return;
        }
        Object obj = null;
        Object obj2 = map != null ? map.get("record_id") : null;
        String str = obj2 instanceof String ? (String) obj2 : null;
        Integer num = (Integer) (map != null ? map.get("offset") : null);
        if (map != null) {
            obj = map.get("page_size");
        }
        Integer num2 = (Integer) obj;
        ad2.runOnUiThread(new when(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).xxx(ad2, str, num != null ? num.intValue() : 0, num2 != null ? num2.intValue() : 200).getSecond()));
    }

    public final void tt(MethodCall methodCall, MethodChannel.Result result) {
        List list = (List) methodCall.arguments();
        if (list == null) {
            list = new ArrayList();
        }
        Context rg2 = rg();
        if (rg2 == null) {
            result.success(MapsKt__MapsKt.emptyMap());
        } else {
            ImagePredictor.f7037o.qw().nn(rg2, list, 0, new ad(this));
        }
    }

    public final void v(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(CollectionsKt__CollectionsKt.emptyList());
            return;
        }
        Object obj = null;
        Integer num = (Integer) (map != null ? map.get("offset") : null);
        Integer num2 = (Integer) (map != null ? map.get("page_size") : null);
        if (map != null) {
            obj = map.get("sort_rule");
        }
        List list = (List) obj;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<Number> arrayList = new ArrayList<>();
        for (Object next : list) {
            if (next instanceof Integer) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Number intValue : arrayList) {
            arrayList2.add(ScanRecordSortRule.values()[intValue.intValue()]);
        }
        ad2.runOnUiThread(new fe.mmm.qw.p024if.pf.th.rg(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).vvv(ad2, num != null ? num.intValue() : 0, num2 != null ? num2.intValue() : 200, arrayList2).getSecond()));
    }

    public final void when(MethodCall methodCall, MethodChannel.Result result) {
        Object obj;
        Context rg2 = rg();
        if (rg2 != null) {
            String str = (String) methodCall.argument("cropInfo");
            if (str == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "call.argument<String>(\"cropInfo\") ?: \"\"");
            if (str.length() == 0) {
                result.success((Object) null);
                return;
            }
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m1155constructorimpl((CropInfo) new Gson().fromJson(str, CropInfo.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m1161isFailureimpl(obj)) {
                obj = null;
            }
            CropInfo cropInfo = (CropInfo) obj;
            if (cropInfo == null) {
                result.success((Object) null);
            } else {
                ImageCropPredictor.f7026o.qw().vvv(rg2, cropInfo, new ppp(booleanRef, result));
            }
        }
    }

    public final void x(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        String str = null;
        Object obj = map != null ? map.get("record_id") : null;
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (ad2 != null && str != null) {
            ad2.runOnUiThread(new fe.mmm.qw.p024if.pf.th.qw(result, ad2, str));
        } else if (ad2 != null) {
            ad2.runOnUiThread(new Cswitch(result));
        }
    }

    public final void xxx(Map<String, ? extends Object> map, MethodChannel.Result result) {
        Activity ad2 = ad();
        if (ad2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        List list = null;
        Object obj = map != null ? map.get("files") : null;
        if (obj instanceof List) {
            list = (List) obj;
        }
        if (list == null) {
            result.success(Boolean.FALSE);
        } else {
            ad2.runOnUiThread(new o(result, new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).th(ad2, fe.mmm.qw.rrr.ad.ad.th(list))));
        }
    }
}
