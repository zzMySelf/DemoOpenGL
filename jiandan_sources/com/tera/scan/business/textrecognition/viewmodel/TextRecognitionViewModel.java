package com.tera.scan.business.textrecognition.viewmodel;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.google.common.net.MediaType;
import fe.mmm.qw.rg.de.tt.de;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tera/scan/business/textrecognition/viewmodel/TextRecognitionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "handler", "Landroid/os/Handler;", "orcResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "", "getOrcResultLiveData", "()Landroidx/lifecycle/MutableLiveData;", "recognizer", "Lcom/tera/scan/business/textrecognition/textdetector/ScanTextRecognizer;", "releaseMemo", "", "startRecognition", "", "imageList", "languageType", "Companion", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "TextRecognitionViewModel";
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final MutableLiveData<List<String>> f6828ad = new MutableLiveData<>(null);
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public fe.mmm.qw.rg.de.qqq.qw f6829de;
    @NotNull
    public final Handler qw = new Handler(Looper.getMainLooper());

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r1 = (r1 = kotlin.collections.MapsKt__MapsJVMKt.toSortedMap((r1 = r1.ad()))).values();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void qw(com.tera.scan.business.textrecognition.viewmodel.TextRecognitionViewModel r1) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> r0 = r1.f6828ad
            fe.mmm.qw.rg.de.qqq.qw r1 = r1.f6829de
            if (r1 == 0) goto L_0x0022
            java.util.Map r1 = r1.ad()
            if (r1 == 0) goto L_0x0022
            java.util.SortedMap r1 = kotlin.collections.MapsKt__MapsJVMKt.toSortedMap(r1)
            if (r1 == 0) goto L_0x0022
            java.util.Collection r1 = r1.values()
            if (r1 == 0) goto L_0x0022
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1)
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            r0.postValue(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.business.textrecognition.viewmodel.TextRecognitionViewModel.qw(com.tera.scan.business.textrecognition.viewmodel.TextRecognitionViewModel):void");
    }

    @NotNull
    public final MutableLiveData<List<String>> getOrcResultLiveData() {
        return this.f6828ad;
    }

    public final void releaseMemo() {
        this.qw.removeCallbacksAndMessages((Object) null);
        fe.mmm.qw.rg.de.qqq.qw qwVar = this.f6829de;
        if (qwVar != null) {
            qwVar.qw();
        }
        this.f6829de = null;
    }

    public final boolean startRecognition(@NotNull List<String> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "imageList");
        Intrinsics.checkNotNullParameter(str, "languageType");
        if (list.isEmpty()) {
            return false;
        }
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        fe.mmm.qw.rg.de.qqq.qw qwVar = new fe.mmm.qw.rg.de.qqq.qw(application, str, list);
        this.f6829de = qwVar;
        if (qwVar != null) {
            qwVar.de(new TextRecognitionViewModel$startRecognition$1(this));
        }
        this.qw.postDelayed(new de(this), 30000);
        return true;
    }
}
