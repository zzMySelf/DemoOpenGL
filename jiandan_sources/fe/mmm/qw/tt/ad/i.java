package fe.mmm.qw.tt.ad;

import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class i {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f8400ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public String f8401de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final IOCRTakePhotoControl f8402fe;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f8403rg;

    /* renamed from: th  reason: collision with root package name */
    public final int f8404th;

    public i(int i2, @NotNull String str, @NotNull String str2, @NotNull IOCRTakePhotoControl iOCRTakePhotoControl, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "showHot");
        Intrinsics.checkNotNullParameter(iOCRTakePhotoControl, "ctrl");
        this.qw = i2;
        this.f8400ad = str;
        this.f8401de = str2;
        this.f8402fe = iOCRTakePhotoControl;
        this.f8403rg = z;
        this.f8404th = i3;
    }

    @NotNull
    public final IOCRTakePhotoControl ad() {
        return this.f8402fe;
    }

    public final int de() {
        return this.qw;
    }

    @NotNull
    public final String fe() {
        return this.f8401de;
    }

    public final int qw() {
        return this.f8404th;
    }

    public final boolean rg() {
        return this.f8403rg;
    }

    @NotNull
    public final String th() {
        return this.f8400ad;
    }

    public final void yj(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f8401de = str;
    }
}
