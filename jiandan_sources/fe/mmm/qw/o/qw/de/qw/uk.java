package fe.mmm.qw.o.qw.de.qw;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.alipay.sdk.m.x.d;
import com.baidu.aiscan.R;
import com.github.barteksc.pdfviewer.PDFThumb;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfPasswordException;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.tera.scan.component.base.ui.widget.AboveInputDialog;
import com.tera.scan.doc.preview.document.ui.view.ILoadCallback;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.widget.LengthLimitedEditText;
import fe.p013if.ad.qw.p014if.de;
import fe.p013if.ad.qw.th;
import java.io.File;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class uk {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Activity f8156ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public String f8157de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public PDFThumb f8158fe;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f8159i;

    /* renamed from: if  reason: not valid java name */
    public boolean f342if = true;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public Handler f8160o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public AboveInputDialog f8161pf;
    public volatile boolean ppp;
    @NotNull
    public final String qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public PdfiumCore f8162rg;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public ILoadCallback f343switch;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public PdfDocument f8163th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Handler f8164uk = new Handler(Looper.getMainLooper());
    public boolean when;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public th f8165yj;

    public static final class qw implements LengthLimitedEditText.EditTextWatcher {
        public final /* synthetic */ AboveInputDialog qw;

        public qw(AboveInputDialog aboveInputDialog) {
            this.qw = aboveInputDialog;
        }

        public void ad() {
        }

        public void qw(int i2) {
            this.qw.getOk().setEnabled(true);
            this.qw.getOk().setAlpha(1.0f);
            if (i2 > 0) {
                this.qw.getDeleteView().setVisibility(0);
            } else {
                this.qw.getDeleteView().setVisibility(8);
            }
        }
    }

    public uk(@NotNull String str, @NotNull Activity activity, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "localPath");
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.qw = str;
        this.f8156ad = activity;
        this.f8157de = str2;
    }

    public static final void fe(uk ukVar, AboveInputDialog aboveInputDialog, View view) {
        Intrinsics.checkNotNullParameter(ukVar, "this$0");
        Intrinsics.checkNotNullParameter(aboveInputDialog, "$this_apply");
        String obj = aboveInputDialog.getEditText().getText().toString();
        ukVar.f8157de = obj;
        if (!TextUtils.isEmpty(obj)) {
            ukVar.ppp();
        }
    }

    public static final void ggg(uk ukVar) {
        Intrinsics.checkNotNullParameter(ukVar, "this$0");
        try {
            if (!ukVar.pf()) {
                ukVar.f8156ad.finish();
            } else {
                ukVar.m997switch();
            }
        } catch (IOException e) {
            fe.mmm.qw.i.qw.ad("PdfThumbProxy", e.getMessage());
            if (e instanceof PdfPasswordException) {
                ukVar.nn();
            } else {
                ukVar.f8156ad.finish();
            }
        }
    }

    public static final void mmm(AboveInputDialog aboveInputDialog, uk ukVar) {
        Intrinsics.checkNotNullParameter(ukVar, "this$0");
        if (aboveInputDialog == null || !aboveInputDialog.isShowing()) {
            ukVar.f342if = true;
            AboveInputDialog de2 = ukVar.de();
            ukVar.f8161pf = de2;
            if (de2 != null) {
                de2.show();
                return;
            }
            return;
        }
        TextView errorInfoView = aboveInputDialog.getErrorInfoView();
        if (errorInfoView != null) {
            errorInfoView.setTextColor(ukVar.f8156ad.getResources().getColor(R.color.logout_text));
        }
        aboveInputDialog.setErrorInfo(R.string.doc_password_error);
    }

    public static final void o(uk ukVar) {
        Intrinsics.checkNotNullParameter(ukVar, "this$0");
        if (!TextUtils.isEmpty(ukVar.qw)) {
            HandlerThread handlerThread = new HandlerThread("PdfThumbProxy");
            ukVar.f8159i = handlerThread;
            if (handlerThread != null) {
                handlerThread.start();
            }
            HandlerThread handlerThread2 = ukVar.f8159i;
            Looper looper = handlerThread2 != null ? handlerThread2.getLooper() : null;
            Intrinsics.checkNotNull(looper);
            ukVar.f8160o = new Handler(looper);
            ukVar.ppp();
        }
    }

    public static final void rg(uk ukVar, View view) {
        Intrinsics.checkNotNullParameter(ukVar, "this$0");
        ukVar.qw();
        ukVar.f8156ad.finish();
    }

    public static final void th(uk ukVar, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(ukVar, "this$0");
        if (ukVar.f342if) {
            ukVar.f8156ad.finish();
        }
    }

    public static final void when(uk ukVar) {
        Intrinsics.checkNotNullParameter(ukVar, "this$0");
        ukVar.qw();
        ukVar.when = true;
        ILoadCallback iLoadCallback = ukVar.f343switch;
        if (iLoadCallback != null) {
            iLoadCallback.onLoadSucceed();
        }
    }

    public final int ad() {
        PDFThumb pDFThumb = this.f8158fe;
        if (pDFThumb != null) {
            return pDFThumb.fe();
        }
        return 0;
    }

    public final void ddd(@NotNull PDFThumb.IThumbCallback iThumbCallback) {
        Intrinsics.checkNotNullParameter(iThumbCallback, d.u);
        PDFThumb pDFThumb = this.f8158fe;
        if (pDFThumb != null) {
            pDFThumb.yj(iThumbCallback);
        }
    }

    public final AboveInputDialog de() {
        Activity activity = this.f8156ad;
        AboveInputDialog aboveInputDialog = new AboveInputDialog(activity, activity);
        aboveInputDialog.setDialogTitle((int) R.string.passwd_input_nothing);
        aboveInputDialog.setRightBtnText(R.string.okay);
        aboveInputDialog.getInputNumTextView().setVisibility(8);
        aboveInputDialog.setCanCancelOutsideTouch(false);
        aboveInputDialog.getDeleteView().setVisibility(8);
        aboveInputDialog.getErrorInfoView().setVisibility(0);
        aboveInputDialog.getErrorInfoView().setText(R.string.doc_password_input_reminder);
        aboveInputDialog.getErrorInfoView().setTextColor(this.f8156ad.getResources().getColor(R.color.text_assist_color));
        aboveInputDialog.getEditText().setInputType(15);
        aboveInputDialog.getEditText().setHint(R.string.passwd_input_nothing);
        aboveInputDialog.getEditText().setEditTextWatcher(new qw(aboveInputDialog));
        aboveInputDialog.setRightBtnOnClickListener(new qw(this, aboveInputDialog));
        aboveInputDialog.setCancelButtonClickListener(new yj(this));
        aboveInputDialog.setOnDismissListener(new th(this));
        return aboveInputDialog;
    }

    public final void i() {
        this.f8156ad.runOnUiThread(new de(this));
    }

    /* renamed from: if  reason: not valid java name */
    public final void m996if() {
        if (!this.ppp) {
            try {
                PDFThumb pDFThumb = this.f8158fe;
                if (pDFThumb != null) {
                    pDFThumb.de();
                }
                HandlerThread handlerThread = this.f8159i;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                PdfiumCore pdfiumCore = this.f8162rg;
                if (pdfiumCore != null) {
                    PdfDocument pdfDocument = this.f8163th;
                    if (pdfDocument != null) {
                        pdfiumCore.closeDocument(pdfDocument);
                    } else {
                        return;
                    }
                }
                this.ppp = true;
                ExpectKt.success(Unit.INSTANCE);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                ExpectKt.failure(th2);
            }
        }
    }

    public final void nn() {
        this.f8164uk.post(new fe(this.f8161pf, this));
    }

    public final boolean pf() throws IOException {
        Context context = BaseApplication.mContext;
        if (context == null) {
            return false;
        }
        File file = new File(this.qw);
        if (!file.exists()) {
            return false;
        }
        if (this.f8162rg == null) {
            this.f8162rg = new PdfiumCore(context);
        }
        if (this.f8163th == null) {
            this.f8163th = new de(file).qw(context, this.f8162rg, this.f8157de);
        }
        if (this.f8158fe == null) {
            this.f8165yj = new th(this.f8162rg, this.f8163th, FitPolicy.WIDTH, uk(), (int[]) null, true, 0, false, true);
        }
        HandlerThread handlerThread = this.f8159i;
        if (handlerThread != null && !handlerThread.isAlive()) {
            return false;
        }
        HandlerThread handlerThread2 = this.f8159i;
        this.f8158fe = yj(handlerThread2 != null ? handlerThread2.getLooper() : null, this.f8165yj);
        return true;
    }

    public final void ppp() {
        Handler handler = this.f8160o;
        if (handler != null) {
            handler.post(new rg(this));
        }
    }

    public final void qw() {
        this.f342if = false;
        AboveInputDialog aboveInputDialog = this.f8161pf;
        if (aboveInputDialog != null && aboveInputDialog.isShowing()) {
            aboveInputDialog.dismiss();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m997switch() {
        this.f8164uk.post(new ad(this));
    }

    @NotNull
    public abstract Size uk();

    public final void vvv(int i2) {
        PDFThumb pDFThumb = this.f8158fe;
        if (pDFThumb != null) {
            pDFThumb.th(i2);
        }
    }

    public final void xxx(@NotNull ILoadCallback iLoadCallback) {
        Intrinsics.checkNotNullParameter(iLoadCallback, "callback");
        this.f343switch = iLoadCallback;
    }

    @NotNull
    public abstract PDFThumb yj(@Nullable Looper looper, @Nullable th thVar);
}
