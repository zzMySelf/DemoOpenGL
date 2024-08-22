package com.tera.scan.flutter.documentscan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.aiscan.R;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import com.tera.scan.flutter.ui.FlutterBaseActivity;
import io.flutter.embedding.android.TransparencyMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016RJ\u0010\u0003\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\t`\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R.\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00020\u0006`\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00020\u0006`\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tera/scan/flutter/documentscan/OCRRectifyActivity;", "Lcom/tera/scan/flutter/ui/FlutterBaseActivity;", "()V", "aiScanImages", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "category", "", "cloudFiles", "dataList", "docResourceFrom", "docScanFilterIndex", "from", "images", "savePath", "scanMode", "source", "ubcSource", "initFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "Companion", "lib-flutter_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Route(path = "/flutternetdisk/native/OCRRectifyActivity")
public final class OCRRectifyActivity extends FlutterBaseActivity {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_AI_SCAN_IMAGES = "ai_scan_images";
    @NotNull
    public static final String EXTRA_CATEGORY = "doc_scan_category";
    @NotNull
    public static final String EXTRA_DOC_RESOURCE_FROM = "doc_resource_from";
    @NotNull
    public static final String EXTRA_FLUTTER_ROUTE_PATH = "flutter_route_path";
    @NotNull
    public static final String EXTRA_IMAGE_PATHS = "doc_scan_params";
    @NotNull
    public static final String EXTRA_RESULT_DATA_LIST = "doc_scan_data_list";
    @NotNull
    public static final String EXTRA_SAVE_PATH = "save_path";
    @NotNull
    public static final String EXTRA_SCAN_CLOUD_FILES = "cloud_files";
    @NotNull
    public static final String EXTRA_SCAN_FILTER_INDEX = "doc_scan_filter_index";
    @NotNull
    public static final String EXTRA_SCAN_FROM = "from";
    @NotNull
    public static final String EXTRA_SCAN_MODE = "doc_scan_mode";
    @NotNull
    public static final String EXTRA_SOURCE = "extra_source";
    @NotNull
    public static final String EXTRA_UBC_SOURCE = "ubc_source";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Autowired(name = "aiScanImages")
    @NotNull
    @JvmField
    public ArrayList<HashMap<String, Object>> aiScanImages = new ArrayList<>();
    @Autowired(name = "category")
    @JvmField
    public int category;
    @Autowired(name = "cloudFiles")
    @NotNull
    @JvmField
    public HashMap<String, String> cloudFiles = new HashMap<>();
    @Autowired(name = "dataList")
    @NotNull
    @JvmField
    public ArrayList<String> dataList = new ArrayList<>();
    @NotNull
    @Autowired(name = "docResourceFrom")
    @JvmField
    public String docResourceFrom = "";
    @Autowired(name = "scanFilterIndex")
    @JvmField
    public int docScanFilterIndex;
    @NotNull
    @Autowired(name = "from")
    @JvmField
    public String from = "";
    @Autowired(name = "images")
    @NotNull
    @JvmField
    public ArrayList<String> images = new ArrayList<>();
    @NotNull
    @Autowired(name = "savePath")
    @JvmField
    public String savePath = "";
    @Autowired(name = "scanMode")
    @JvmField
    public int scanMode;
    @Autowired(name = "source")
    @JvmField
    public int source;
    @NotNull
    @Autowired(name = "ubcSource")
    @JvmField
    public String ubcSource = "";

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void fe(qw qwVar, Context context, String str, fe.mmm.qw.p024if.yj.qw.qw qwVar2, int i2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                i2 = 0;
            }
            qwVar.de(context, str, qwVar2, i2);
        }

        @JvmStatic
        public final void ad(@Nullable Context context, @Nullable String str, @NotNull fe.mmm.qw.p024if.yj.qw.qw qwVar) {
            Intrinsics.checkNotNullParameter(qwVar, "ocrRectifyData");
            if (str == null) {
                str = "/netdisk/doc_scan";
            }
            fe(this, context, str, qwVar, 0, 8, (Object) null);
        }

        @JvmStatic
        public final void de(@Nullable Context context, @Nullable String str, @NotNull fe.mmm.qw.p024if.yj.qw.qw qwVar, int i2) {
            Intrinsics.checkNotNullParameter(qwVar, "ocrRectifyData");
            if (context != null) {
                Intent intent = new Intent(context, OCRRectifyActivity.class);
                intent.putExtra(OCRRectifyActivity.EXTRA_IMAGE_PATHS, qwVar.uk());
                intent.putExtra(OCRRectifyActivity.EXTRA_SOURCE, qwVar.pf());
                intent.putExtra(OCRRectifyActivity.EXTRA_CATEGORY, qwVar.ad());
                intent.putExtra("doc_scan_mode", qwVar.o());
                intent.putExtra("doc_scan_filter_index", qwVar.th());
                intent.putExtra(OCRRectifyActivity.EXTRA_RESULT_DATA_LIST, qwVar.fe());
                intent.putExtra(OCRRectifyActivity.EXTRA_SCAN_CLOUD_FILES, qwVar.de());
                intent.putExtra("from", qwVar.yj());
                intent.putExtra(OCRRectifyActivity.EXTRA_AI_SCAN_IMAGES, qwVar.qw());
                if (str == null) {
                    str = "/netdisk/doc_scan";
                }
                intent.putExtra(OCRRectifyActivity.EXTRA_FLUTTER_ROUTE_PATH, str);
                intent.putExtra(OCRRectifyActivity.EXTRA_SAVE_PATH, qwVar.i());
                intent.putExtra(OCRRectifyActivity.EXTRA_DOC_RESOURCE_FROM, qwVar.rg());
                intent.putExtra("ubc_source", qwVar.m977if());
                boolean z = context instanceof Activity;
                if (!z) {
                    intent.setFlags(268435456);
                }
                if (i2 <= 0 || !z) {
                    context.startActivity(intent);
                } else {
                    ((Activity) context).startActivityForResult(intent, i2);
                }
            }
        }

        @JvmStatic
        public final void qw(@Nullable Context context, @NotNull fe.mmm.qw.p024if.yj.qw.qw qwVar) {
            Intrinsics.checkNotNullParameter(qwVar, "ocrRectifyData");
            fe(this, context, "/netdisk/doc_scan", qwVar, 0, 8, (Object) null);
        }
    }

    @JvmStatic
    public static final void startActivity(@Nullable Context context, @NotNull fe.mmm.qw.p024if.yj.qw.qw qwVar) {
        Companion.qw(context, qwVar);
    }

    @JvmStatic
    public static final void startActivity(@Nullable Context context, @Nullable String str, @NotNull fe.mmm.qw.p024if.yj.qw.qw qwVar) {
        Companion.ad(context, str, qwVar);
    }

    @JvmStatic
    public static final void startActivityForResult(@Nullable Context context, @Nullable String str, @NotNull fe.mmm.qw.p024if.yj.qw.qw qwVar, int i2) {
        Companion.de(context, str, qwVar, i2);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @NotNull
    public Fragment initFragment() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object serializableExtra = getIntent().getSerializableExtra(EXTRA_IMAGE_PATHS);
        if (serializableExtra == null) {
            serializableExtra = this.images;
        }
        linkedHashMap.put(EXTRA_IMAGE_PATHS, serializableExtra);
        linkedHashMap.put(EXTRA_SOURCE, Integer.valueOf(getIntent().getIntExtra(EXTRA_SOURCE, this.source)));
        linkedHashMap.put(EXTRA_CATEGORY, Integer.valueOf(getIntent().getIntExtra(EXTRA_CATEGORY, this.category)));
        linkedHashMap.put("doc_scan_mode", Integer.valueOf(getIntent().getIntExtra("doc_scan_mode", this.scanMode)));
        linkedHashMap.put("doc_scan_filter_index", Integer.valueOf(getIntent().getIntExtra("doc_scan_filter_index", this.docScanFilterIndex)));
        Object serializableExtra2 = getIntent().getSerializableExtra(EXTRA_RESULT_DATA_LIST);
        if (serializableExtra2 == null) {
            serializableExtra2 = this.dataList;
        }
        linkedHashMap.put(EXTRA_RESULT_DATA_LIST, serializableExtra2);
        Object serializableExtra3 = getIntent().getSerializableExtra(EXTRA_SCAN_CLOUD_FILES);
        if (serializableExtra3 == null) {
            serializableExtra3 = this.cloudFiles;
        }
        linkedHashMap.put(EXTRA_SCAN_CLOUD_FILES, serializableExtra3);
        String stringExtra = getIntent().getStringExtra("from");
        if (stringExtra == null) {
            stringExtra = this.from;
        }
        linkedHashMap.put("from", stringExtra);
        Object serializableExtra4 = getIntent().getSerializableExtra(EXTRA_AI_SCAN_IMAGES);
        if (serializableExtra4 == null) {
            serializableExtra4 = this.aiScanImages;
        }
        linkedHashMap.put(EXTRA_AI_SCAN_IMAGES, serializableExtra4);
        String stringExtra2 = getIntent().getStringExtra(EXTRA_SAVE_PATH);
        if (stringExtra2 == null) {
            stringExtra2 = this.savePath;
        }
        linkedHashMap.put(EXTRA_SAVE_PATH, stringExtra2);
        String stringExtra3 = getIntent().getStringExtra(EXTRA_DOC_RESOURCE_FROM);
        if (stringExtra3 == null) {
            stringExtra3 = this.docResourceFrom;
        }
        linkedHashMap.put(EXTRA_DOC_RESOURCE_FROM, stringExtra3);
        String stringExtra4 = getIntent().getStringExtra("ubc_source");
        if (stringExtra4 == null) {
            stringExtra4 = this.ubcSource;
        }
        linkedHashMap.put("ubc_source", stringExtra4);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        String stringExtra5 = getIntent().getStringExtra(EXTRA_FLUTTER_ROUTE_PATH);
        if (stringExtra5 == null) {
            stringExtra5 = "/netdisk/doc_scan";
        }
        FlutterBoostFragment.qw qwVar = new FlutterBoostFragment.qw(FlutterBoostFragment.class);
        qwVar.th(stringExtra5);
        qwVar.yj(linkedHashMap);
        qwVar.de(false);
        qwVar.fe(true);
        qwVar.rg(TransparencyMode.opaque);
        FlutterBoostFragment qw2 = qwVar.qw();
        beginTransaction.replace((int) R.id.content, (Fragment) qw2, "com.tera.scan.flutter.documentscan.OCRRectifyActivity");
        beginTransaction.commitAllowingStateLoss();
        Intrinsics.checkNotNullExpressionValue(qw2, "fragment");
        return qw2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        fe.ad.qw.qw.ad.qw.de().rg(this);
        super.onCreate(bundle);
    }

    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
