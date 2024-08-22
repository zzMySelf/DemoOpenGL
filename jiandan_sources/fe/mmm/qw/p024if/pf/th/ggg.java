package fe.mmm.qw.p024if.pf.th;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.if.pf.th.ggg  reason: invalid package */
public final class ggg {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f7923ad = "document_tool/event_channel/scan_data_change_listener";
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final EventChannel f7924de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final String f7925fe;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public ContentObserver f7926i;
    @Nullable
    public final Context qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public Map<String, EventChannel.EventSink> f7927rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public ContentObserver f7928th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public ContentObserver f7929uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public ContentObserver f7930yj;

    /* renamed from: fe.mmm.qw.if.pf.th.ggg$ad */
    public static final class ad extends ContentObserver {
        public final /* synthetic */ ggg qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(ggg ggg) {
            super((Handler) null);
            this.qw = ggg;
        }

        public void onChange(boolean z, @Nullable Uri uri) {
            Set<String> queryParameterNames;
            Object obj;
            Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("event_type", "record_file"));
            if (!(uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null)) {
                try {
                    Result.Companion companion = Result.Companion;
                    for (String next : queryParameterNames) {
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        mutableMapOf.put(next, uri.getQueryParameter(next));
                    }
                    obj = Result.m1155constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
                }
                Result.m1154boximpl(obj);
            }
            this.qw.ppp(mutableMapOf);
        }
    }

    /* renamed from: fe.mmm.qw.if.pf.th.ggg$de */
    public static final class de extends ContentObserver {
        public final /* synthetic */ ggg qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public de(ggg ggg) {
            super((Handler) null);
            this.qw = ggg;
        }

        public void onChange(boolean z, @Nullable Uri uri) {
            Set<String> queryParameterNames;
            Object obj;
            Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("event_type", "record_file_upload"));
            if (!(uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null)) {
                try {
                    Result.Companion companion = Result.Companion;
                    for (String next : queryParameterNames) {
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        mutableMapOf.put(next, uri.getQueryParameter(next));
                    }
                    obj = Result.m1155constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
                }
                Result.m1154boximpl(obj);
            }
            this.qw.ppp(mutableMapOf);
        }
    }

    /* renamed from: fe.mmm.qw.if.pf.th.ggg$fe */
    public static final class fe extends ContentObserver {
        public final /* synthetic */ ggg qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public fe(ggg ggg) {
            super((Handler) null);
            this.qw = ggg;
        }

        public void onChange(boolean z, @Nullable Uri uri) {
            Set<String> queryParameterNames;
            Object obj;
            Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("event_type", "record"));
            if (!(uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null)) {
                try {
                    Result.Companion companion = Result.Companion;
                    for (String next : queryParameterNames) {
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        mutableMapOf.put(next, uri.getQueryParameter(next));
                    }
                    obj = Result.m1155constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
                }
                Result.m1154boximpl(obj);
            }
            this.qw.ppp(mutableMapOf);
        }
    }

    /* renamed from: fe.mmm.qw.if.pf.th.ggg$qw */
    public static final class qw extends ContentObserver {
        public final /* synthetic */ ggg qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(ggg ggg) {
            super((Handler) null);
            this.qw = ggg;
        }

        public void onChange(boolean z, @Nullable Uri uri) {
            Set<String> queryParameterNames;
            Object obj;
            Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("event_type", "export_file"));
            if (!(uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null)) {
                try {
                    Result.Companion companion = Result.Companion;
                    for (String next : queryParameterNames) {
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        mutableMapOf.put(next, uri.getQueryParameter(next));
                    }
                    obj = Result.m1155constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
                }
                Result.m1154boximpl(obj);
            }
            this.qw.ppp(mutableMapOf);
        }
    }

    /* renamed from: fe.mmm.qw.if.pf.th.ggg$rg */
    public static final class rg implements EventChannel.StreamHandler {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ggg f7931ad;

        public rg(ggg ggg) {
            this.f7931ad = ggg;
        }

        public void onCancel(@Nullable Object obj) {
            if (obj instanceof String) {
                this.f7931ad.f7927rg.remove(obj);
                this.f7931ad.o();
            }
        }

        public void onListen(@Nullable Object obj, @Nullable EventChannel.EventSink eventSink) {
            if ((obj instanceof String) && Intrinsics.areEqual((Object) this.f7931ad.yj(), obj)) {
                this.f7931ad.f7927rg.put(this.f7931ad.yj(), eventSink);
                ggg ggg = this.f7931ad;
                ggg.i(ggg.th());
            }
        }
    }

    public ggg(@NotNull BinaryMessenger binaryMessenger, @Nullable Context context) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        this.qw = context;
        this.f7924de = new EventChannel(binaryMessenger, "document_tool/event_channel/scan_data_change_listener");
        this.f7925fe = "scanDataChangeListener";
        this.f7927rg = new LinkedHashMap();
        this.f7928th = new fe(this);
        this.f7930yj = new ad(this);
        this.f7929uk = new de(this);
        this.f7926i = new qw(this);
    }

    public static final void ggg(EventChannel.EventSink eventSink, Map map) {
        Intrinsics.checkNotNullParameter(eventSink, "$this_apply");
        Intrinsics.checkNotNullParameter(map, "$event");
        eventSink.success(map);
    }

    public final Uri fe(String str) {
        Uri parse = Uri.parse("content://" + str + ".ocr.doc_scan");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(\"content://${pkgName}.ocr.doc_scan\")");
        return parse;
    }

    public final void i(Context context) {
        if (context != null) {
            for (Map.Entry next : uk(context).entrySet()) {
                ContentObserver contentObserver = (ContentObserver) next.getValue();
                if (contentObserver != null) {
                    context.getContentResolver().registerContentObserver((Uri) next.getKey(), false, contentObserver);
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final Uri m975if(Context context) {
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        Uri build = fe(packageName).buildUpon().appendPath("tb_doc_scan_file").appendPath("upload").build();
        Intrinsics.checkNotNullExpressionValue(build, "contentUri(context.packa…endPath(\"upload\").build()");
        return build;
    }

    public final void o() {
        xxx(this.qw);
    }

    public final Uri pf(Context context) {
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        Uri build = fe(packageName).buildUpon().appendPath("tb_doc_scan_export_file").build();
        Intrinsics.checkNotNullExpressionValue(build, "contentUri(context.packa…can_export_file\").build()");
        return build;
    }

    public final void ppp(Map<String, ? extends Object> map) {
        EventChannel.EventSink rg2 = rg();
        if (rg2 != null) {
            new Handler(Looper.getMainLooper()).post(new fe(rg2, map));
        }
    }

    public final EventChannel.EventSink rg() {
        return this.f7927rg.get(this.f7925fe);
    }

    /* renamed from: switch  reason: not valid java name */
    public final Uri m976switch(Context context) {
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        Uri build = fe(packageName).buildUpon().appendPath("tb_doc_scan_file").build();
        Intrinsics.checkNotNullExpressionValue(build, "contentUri(context.packa…b_doc_scan_file\").build()");
        return build;
    }

    @Nullable
    public final Context th() {
        return this.qw;
    }

    public final Map<Uri, ContentObserver> uk(Context context) {
        return MapsKt__MapsKt.mapOf(TuplesKt.to(when(context), this.f7928th), TuplesKt.to(m976switch(context), this.f7930yj), TuplesKt.to(m975if(context), this.f7929uk), TuplesKt.to(pf(context), this.f7926i));
    }

    public final void vvv() {
        this.f7924de.setStreamHandler(new rg(this));
    }

    public final Uri when(Context context) {
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        Uri build = fe(packageName).buildUpon().appendPath("tb_doc_scan_record").build();
        Intrinsics.checkNotNullExpressionValue(build, "contentUri(context.packa…doc_scan_record\").build()");
        return build;
    }

    public final void xxx(Context context) {
        if (context != null) {
            for (Map.Entry<Uri, ContentObserver> value : uk(context).entrySet()) {
                ContentObserver contentObserver = (ContentObserver) value.getValue();
                if (contentObserver != null) {
                    context.getContentResolver().unregisterContentObserver(contentObserver);
                }
            }
        }
    }

    @NotNull
    public final String yj() {
        return this.f7925fe;
    }
}
