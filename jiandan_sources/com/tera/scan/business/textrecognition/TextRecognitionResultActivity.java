package com.tera.scan.business.textrecognition;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.google.common.base.Ascii;
import com.tera.scan.account.OnLoginCallBack;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import com.tera.scan.business.textrecognition.dialog.OcrResultBottomMenuDialog;
import com.tera.scan.business.textrecognition.viewmodel.TextRecognitionResultViewModel;
import com.tera.scan.component.base.ui.dialog.ConfirmDialog;
import com.tera.scan.component.base.ui.widget.LoadingDialog;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.record.database.DocScanProviderHelper;
import com.tera.scan.record.model.FileUploadStatus;
import com.tera.scan.record.model.LocalExportType;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.scanner.ui.camera.CameraFragment;
import com.tera.scan.ui.widget.titlebar.ICommonTitleBarClickListener;
import com.tera.scan.vip.ui.view.PrivilegeBannerView;
import com.tera.scan.widget.NoCopyEditText;
import fe.mmm.qw.rg.de.Cif;
import fe.mmm.qw.rg.de.Cswitch;
import fe.mmm.qw.rg.de.eee.de;
import fe.mmm.qw.rg.de.ppp;
import fe.mmm.qw.rg.de.th;
import fe.mmm.qw.rg.de.uk;
import fe.mmm.qw.rg.de.when;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.th.qw.th.pf;
import java.io.File;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 r2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001rB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020)H\u0014J\u0010\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001dH\u0002J\b\u0010P\u001a\u00020)H\u0014J\u0012\u0010Q\u001a\u00020L2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\b\u0010T\u001a\u00020LH\u0014J\u0010\u0010U\u001a\u00020L2\u0006\u0010V\u001a\u00020\u001dH\u0002J\"\u0010W\u001a\u00020L2\u0006\u0010X\u001a\u00020)2\u0006\u0010Y\u001a\u00020)2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\b\u0010Z\u001a\u00020LH\u0002J\b\u0010[\u001a\u00020LH\u0016J\b\u0010\\\u001a\u00020LH\u0016J\b\u0010]\u001a\u00020LH\u0016J\b\u0010^\u001a\u00020LH\u0014J\b\u0010_\u001a\u00020LH\u0016J\b\u0010`\u001a\u00020LH\u0016J\b\u0010a\u001a\u00020LH\u0002J\b\u0010b\u001a\u00020LH\u0014J\u0012\u0010c\u001a\u00020L2\b\u0010d\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010e\u001a\u00020LH\u0016J\b\u0010f\u001a\u00020LH\u0016J\b\u0010g\u001a\u00020LH\u0002J\u0010\u0010h\u001a\u00020L2\u0006\u0010i\u001a\u00020\u0018H\u0002J\u0010\u0010j\u001a\u00020L2\u0006\u0010k\u001a\u00020lH\u0002J\r\u0010m\u001a\u00020LH\u0000¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020L2\u0006\u0010\u0005\u001a\u00020\u001dH\u0002J\r\u0010p\u001a\u00020LH\u0000¢\u0006\u0002\bqR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b.\u0010\u001aR\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068@X\u0002¢\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b<\u0010\n\u001a\u0004\b;\u0010\u001fR\u001d\u0010=\u001a\u0004\u0018\u00010\u001d8BX\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b>\u0010\u001fR\u001b\u0010@\u001a\u00020A8@X\u0002¢\u0006\f\n\u0004\bD\u0010\n\u001a\u0004\bB\u0010CR\u001b\u0010E\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\bG\u0010\n\u001a\u0004\bF\u0010\u001aR\u001b\u0010H\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\bJ\u0010\n\u001a\u0004\bI\u0010\u001f¨\u0006s"}, d2 = {"Lcom/tera/scan/business/textrecognition/TextRecognitionResultActivity;", "Lcom/tera/scan/framework/BaseActivity;", "Lcom/tera/scan/ui/widget/titlebar/ICommonTitleBarClickListener;", "Lcom/tera/scan/business/textrecognition/dialog/OcrResultBottomMenuDialog$OnMenuItemClickListener;", "()V", "content", "Lcom/tera/scan/widget/NoCopyEditText;", "getContent", "()Lcom/tera/scan/widget/NoCopyEditText;", "content$delegate", "Lkotlin/Lazy;", "copyOper", "Landroid/view/View;", "getCopyOper", "()Landroid/view/View;", "copyOper$delegate", "dragLayout", "Lcom/tera/scan/business/textrecognition/DragLayout;", "getDragLayout", "()Lcom/tera/scan/business/textrecognition/DragLayout;", "dragLayout$delegate", "exportLoading", "Landroid/app/Dialog;", "exportOper", "Landroid/widget/TextView;", "getExportOper", "()Landroid/widget/TextView;", "exportOper$delegate", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "imagePath$delegate", "keyBoardWatcher", "Lcom/tera/scan/business/textrecognition/tools/KeyBoardWatcher;", "getKeyBoardWatcher", "()Lcom/tera/scan/business/textrecognition/tools/KeyBoardWatcher;", "keyBoardWatcher$delegate", "loginCallback", "Lcom/tera/scan/account/OnLoginCallBack;", "maxTopMarginOffset", "", "getMaxTopMarginOffset", "()I", "maxTopMarginOffset$delegate", "moreOper", "getMoreOper", "moreOper$delegate", "previewImage", "Landroid/widget/ImageView;", "getPreviewImage", "()Landroid/widget/ImageView;", "previewImage$delegate", "privilegeBannerView", "Lcom/tera/scan/vip/ui/view/PrivilegeBannerView;", "getPrivilegeBannerView$business_text_recongition_aiscanConfigRelease", "()Lcom/tera/scan/vip/ui/view/PrivilegeBannerView;", "privilegeBannerView$delegate", "sourceLan", "getSourceLan", "sourceLan$delegate", "text", "getText", "text$delegate", "textRecognitionResultViewModel", "Lcom/tera/scan/business/textrecognition/viewmodel/TextRecognitionResultViewModel;", "getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease", "()Lcom/tera/scan/business/textrecognition/viewmodel/TextRecognitionResultViewModel;", "textRecognitionResultViewModel$delegate", "toWordOper", "getToWordOper", "toWordOper$delegate", "ubcSource", "getUbcSource", "ubcSource$delegate", "backHint", "", "getLayoutId", "getNameFromPath", "path", "getStatusBarColorResId", "handleChooseLanguageResult", "data", "Landroid/content/Intent;", "initView", "insertExportRecord", "filePath", "onActivityResult", "requestCode", "resultCode", "onAiTranslateClick", "onBackButtonClicked", "onBackPressed", "onCopyClick", "onDestroy", "onEditClick", "onExportClick", "onMoreMenuClick", "onResume", "onRightButtonClicked", "view", "onToWordClick", "onTranslateClick", "requestExportFile", "setDetectLanguageText", "textView", "setEditTextCanTouch", "canTouchMode", "", "showTranslateVipStatusView", "showTranslateVipStatusView$business_text_recongition_aiscanConfigRelease", "startAiTranslate", "startPhotoToWord", "startPhotoToWord$business_text_recongition_aiscanConfigRelease", "Companion", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivity extends BaseActivity implements ICommonTitleBarClickListener, OcrResultBottomMenuDialog.OnMenuItemClickListener {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String KEY_IMAGE_URI = "KEY_IMAGE_URI";
    @NotNull
    public static final String KEY_RESULT_TEXT = "KEY_RESULT_TEXT";
    @NotNull
    public static final String KEY_SOURCE_LAN = "KEY_SOURCE_LAN";
    @NotNull
    public static final String KEY_UBC_SOURCE = "KEY_UBC_SOURCE";
    public static final long OPEN_KEYBOARD_DELAY_TIME = 500;
    @NotNull
    public static final String TAG = "qqqq";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy content$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$content$2(this));
    @NotNull
    public final Lazy copyOper$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$copyOper$2(this));
    @NotNull
    public final Lazy dragLayout$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$dragLayout$2(this));
    @Nullable
    public Dialog exportLoading;
    @NotNull
    public final Lazy exportOper$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$exportOper$2(this));
    @NotNull
    public final Lazy imagePath$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$imagePath$2(this));
    @NotNull
    public final Lazy keyBoardWatcher$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$keyBoardWatcher$2(this));
    @Nullable
    public OnLoginCallBack loginCallback = new ad();
    @NotNull
    public final Lazy maxTopMarginOffset$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$maxTopMarginOffset$2(this));
    @NotNull
    public final Lazy moreOper$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$moreOper$2(this));
    @NotNull
    public final Lazy previewImage$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$previewImage$2(this));
    @NotNull
    public final Lazy privilegeBannerView$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$privilegeBannerView$2(this));
    @NotNull
    public final Lazy sourceLan$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$sourceLan$2(this));
    @NotNull
    public final Lazy text$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$text$2(this));
    @NotNull
    public final Lazy textRecognitionResultViewModel$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$textRecognitionResultViewModel$2(this));
    @NotNull
    public final Lazy toWordOper$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$toWordOper$2(this));
    @NotNull
    public final Lazy ubcSource$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionResultActivity$ubcSource$2(this));

    public static final class ad implements OnLoginCallBack {
        public void ad() {
            fe.mmm.qw.rg.de.aaa.qw.ad("OCRLd", "OCRCrp", (String) null, (Map) null, 12, (Object) null);
        }

        public void qw() {
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent qw(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "path");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "lan");
            Intrinsics.checkNotNullParameter(str4, "ubcSource");
            Intent intent = new Intent(context, TextRecognitionResultActivity.class);
            intent.putExtra(TextRecognitionResultActivity.KEY_IMAGE_URI, str);
            intent.putExtra(TextRecognitionResultActivity.KEY_RESULT_TEXT, str2);
            intent.putExtra(TextRecognitionResultActivity.KEY_SOURCE_LAN, str3);
            intent.putExtra(TextRecognitionResultActivity.KEY_UBC_SOURCE, str4);
            return intent;
        }
    }

    private final void backHint() {
        ConfirmDialog.qw qwVar = new ConfirmDialog.qw();
        String string = getString(R.string.image2text_discard_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.image2text_discard_title)");
        qwVar.xxx(string);
        String string2 = getString(R.string.image2text_discard_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.image2text_discard_desc)");
        qwVar.rg(string2);
        String string3 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.cancel)");
        qwVar.ad(string3);
        String string4 = getString(R.string.discard);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.discard)");
        qwVar.fe(string4);
        qwVar.de(true);
        ConfirmDialog qw2 = qwVar.qw();
        qw2.setOnConfirmChange(new TextRecognitionResultActivity$backHint$1$1(this));
        qw2.setOnCancelChange(new TextRecognitionResultActivity$backHint$1$2(qw2));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        qw2.show(supportFragmentManager, "discard hint dialog");
    }

    private final NoCopyEditText getContent() {
        Object value = this.content$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-content>(...)");
        return (NoCopyEditText) value;
    }

    private final View getCopyOper() {
        Object value = this.copyOper$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-copyOper>(...)");
        return (View) value;
    }

    private final DragLayout getDragLayout() {
        Object value = this.dragLayout$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dragLayout>(...)");
        return (DragLayout) value;
    }

    private final TextView getExportOper() {
        Object value = this.exportOper$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-exportOper>(...)");
        return (TextView) value;
    }

    private final String getImagePath() {
        return (String) this.imagePath$delegate.getValue();
    }

    private final fe.mmm.qw.rg.de.eee.ad getKeyBoardWatcher() {
        return (fe.mmm.qw.rg.de.eee.ad) this.keyBoardWatcher$delegate.getValue();
    }

    private final int getMaxTopMarginOffset() {
        return ((Number) this.maxTopMarginOffset$delegate.getValue()).intValue();
    }

    private final TextView getMoreOper() {
        Object value = this.moreOper$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-moreOper>(...)");
        return (TextView) value;
    }

    private final String getNameFromPath(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            String substring = str.substring(StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "/", 0, false, 6, (Object) null) + 1, str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            obj = Result.m1155constructorimpl(substring);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        return str2 == null ? "" : str2;
    }

    private final ImageView getPreviewImage() {
        Object value = this.previewImage$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-previewImage>(...)");
        return (ImageView) value;
    }

    private final String getSourceLan() {
        return (String) this.sourceLan$delegate.getValue();
    }

    private final String getText() {
        return (String) this.text$delegate.getValue();
    }

    private final TextView getToWordOper() {
        Object value = this.toWordOper$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-toWordOper>(...)");
        return (TextView) value;
    }

    private final String getUbcSource() {
        return (String) this.ubcSource$delegate.getValue();
    }

    private final void handleChooseLanguageResult(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("lan_type")) != null) {
            TextRecognitionActivity.qw qwVar = TextRecognitionActivity.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String imagePath = getImagePath();
            if (imagePath == null) {
                imagePath = "";
            }
            startActivity(qwVar.qw(context, CollectionsKt__CollectionsJVMKt.listOf(imagePath), TextRecognitionActivity.FROM_TEXT_OCR, stringExtra, getUbcSource()));
            finish();
        }
    }

    /* renamed from: initView$lambda-2$lambda-1  reason: not valid java name */
    public static final void m736initView$lambda2$lambda1(TextRecognitionResultActivity textRecognitionResultActivity, View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        fe.mmm.qw.rg.de.aaa.qw.ad("OCRPF_clk", "OCRCrp", (String) null, (Map) null, 12, (Object) null);
        textRecognitionResultActivity.onEditClick();
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m737initView$lambda3(TextRecognitionResultActivity textRecognitionResultActivity, View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        fe.mmm.qw.rg.de.aaa.qw.ad("OCRCp_clk", "OCRCrp", (String) null, (Map) null, 12, (Object) null);
        textRecognitionResultActivity.onCopyClick();
    }

    /* renamed from: initView$lambda-4  reason: not valid java name */
    public static final void m738initView$lambda4(TextRecognitionResultActivity textRecognitionResultActivity, View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        fe.mmm.qw.rg.de.aaa.qw.ad("OCR2W_clk", "OCRCrp", (String) null, (Map) null, 12, (Object) null);
        textRecognitionResultActivity.onToWordClick();
    }

    /* renamed from: initView$lambda-5  reason: not valid java name */
    public static final void m739initView$lambda5(TextRecognitionResultActivity textRecognitionResultActivity, View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        textRecognitionResultActivity.onExportClick();
    }

    /* renamed from: initView$lambda-6  reason: not valid java name */
    public static final void m740initView$lambda6(TextRecognitionResultActivity textRecognitionResultActivity, View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        textRecognitionResultActivity.onMoreMenuClick();
    }

    /* renamed from: initView$lambda-8$lambda-7  reason: not valid java name */
    public static final void m741initView$lambda8$lambda7(TextRecognitionResultActivity textRecognitionResultActivity, View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        Pair[] pairArr = new Pair[1];
        String sourceLan = textRecognitionResultActivity.getSourceLan();
        if (sourceLan == null) {
            sourceLan = "";
        }
        pairArr[0] = TuplesKt.to("lan_type", sourceLan);
        fe.mmm.qw.p024if.when.qw.ad(textRecognitionResultActivity, 100, "/netdisk/choose_language_dialog", MapsKt__MapsKt.hashMapOf(pairArr));
        textRecognitionResultActivity.overridePendingTransition(0, 0);
    }

    private final void insertExportRecord(String str) {
        String nameFromPath = getNameFromPath(str);
        new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).pf(this, CollectionsKt__CollectionsJVMKt.listOf(new ScanRecordExportFile(LocalExportType.TextOcr.getValue(), nameFromPath, "", (String) null, (int) new File(str).length(), System.currentTimeMillis() / ((long) 1000), str, FileUploadStatus.LOCAL)));
    }

    private final void onAiTranslateClick() {
        String str;
        String obj;
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "ocr_result_translate_click", (List) null, 2, (Object) null);
        Editable text = getContent().getText();
        if (text == null || (obj = text.toString()) == null || (str = StringsKt__StringsKt.trim((CharSequence) obj).toString()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            o.rg(R.string.error);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        fe.mmm.qw.rg.de.xxx.ad.qw(this, context, supportFragmentManager, new TextRecognitionResultActivity$onAiTranslateClick$1(this, str));
    }

    /* renamed from: onEditClick$lambda-18  reason: not valid java name */
    public static final boolean m742onEditClick$lambda18(TextRecognitionResultActivity textRecognitionResultActivity, View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        return !fe.mmm.qw.rg.de.xxx.ad.de(textRecognitionResultActivity);
    }

    /* renamed from: onEditClick$lambda-19  reason: not valid java name */
    public static final void m743onEditClick$lambda19(TextRecognitionResultActivity textRecognitionResultActivity) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        fe.mmm.qw.rg.de.eee.ad.f8271fe.qw(textRecognitionResultActivity, textRecognitionResultActivity.getContent());
    }

    private final void onMoreMenuClick() {
        OcrResultBottomMenuDialog ocrResultBottomMenuDialog = new OcrResultBottomMenuDialog();
        ocrResultBottomMenuDialog.setOnMenuItemClickListener(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        ocrResultBottomMenuDialog.show(supportFragmentManager, OcrResultBottomMenuDialog.class.getName());
    }

    private final void requestExportFile() {
        if (this.exportLoading == null) {
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "ts_file_export", (List) null, 2, (Object) null);
            String valueOf = String.valueOf(getContent().getText());
            this.exportLoading = LoadingDialog.show(this);
            "requestExportFile: start:" + valueOf;
            String ad2 = new fe.mmm.qw.h.de.qw().ad(this, DocumentOpenUtil.TXT);
            if (ad2 != null) {
                FilesKt__FileReadWriteKt.writeText$default(new File(ad2), valueOf, (Charset) null, 2, (Object) null);
            }
            Dialog dialog = this.exportLoading;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.exportLoading = null;
            if (ad2 != null) {
                startActivity(PreViewActivity.Companion.qw(this, ad2));
                insertExportRecord(ad2);
                finish();
            }
        }
    }

    private final void setDetectLanguageText(TextView textView) {
        try {
            Result.Companion companion = Result.Companion;
            String str = Ascii.CASE_MASK + de.qw.qw(this, getSourceLan());
            String string = getString(R.string.source_language_detected, new Object[]{str});
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.sourc…e_detected, languageName)");
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new ForegroundColorSpan(-16776961), string.length() - str.length(), string.length(), 33);
            textView.setText(spannableString);
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    public final void setEditTextCanTouch(boolean z) {
        getContent().setCursorVisible(z);
        getContent().setFocusableInTouchMode(z);
        if (z) {
            getContent().requestFocus();
        } else {
            getContent().clearFocus();
        }
    }

    /* renamed from: showTranslateVipStatusView$lambda-12  reason: not valid java name */
    public static final void m744showTranslateVipStatusView$lambda12(View view, TextRecognitionResultActivity textRecognitionResultActivity) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "translateVipStatusView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.rightMargin = (textRecognitionResultActivity.getToWordOper().getWidth() / 2) - view.getWidth();
            view.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    /* access modifiers changed from: private */
    public final void startAiTranslate(String str) {
        View findViewById = findViewById(R.id.tv_free_times);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (!fe.mmm.qw.p030switch.rg.qw.qw().qw()) {
            showTranslateVipStatusView$business_text_recongition_aiscanConfigRelease();
        }
        Bundle bundle = new Bundle();
        bundle.putString("content", str);
        bundle.putString("target_lan", Locale.getDefault().getLanguage());
        bundle.putString("image_path", getImagePath());
        bundle.putInt("from", 1);
        fe.mmm.qw.p024if.when.qw.de(this, "/netdisk/translate_text_result", bundle);
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

    public int getLayoutId() {
        return R.layout.layout_image2text_result;
    }

    @NotNull
    public final PrivilegeBannerView getPrivilegeBannerView$business_text_recongition_aiscanConfigRelease() {
        Object value = this.privilegeBannerView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-privilegeBannerView>(...)");
        return (PrivilegeBannerView) value;
    }

    public int getStatusBarColorResId() {
        return fe.mmm.qw.rg.de.xxx.ad.ad(this);
    }

    @NotNull
    public final TextRecognitionResultViewModel getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease() {
        return (TextRecognitionResultViewModel) this.textRecognitionResultViewModel$delegate.getValue();
    }

    public void initView() {
        new pf(CameraFragment.CONTENT_TYPE_OCR, new String[0]).qw();
        fe.mmm.qw.f.fe.ad.ad adVar = new fe.mmm.qw.f.fe.ad.ad(this);
        this.mTitleBar = adVar;
        adVar.m969switch(R.string.image2text_result_title);
        this.mTitleBar.o(true);
        this.mTitleBar.xxx(false);
        this.mTitleBar.aaa(this);
        this.mTitleBar.pf(R.color.color_title_bar);
        String imagePath = getImagePath();
        if (imagePath != null) {
            fe.rg.qw.ad.mmm(getApplicationContext()).ppp(new File(imagePath)).m317switch(getPreviewImage());
        }
        fe.mmm.qw.rg.de.xxx.ad.fe(this, getContent(), getText());
        getContent().setCopyEnable(false);
        TextView textView = (TextView) _$_findCachedViewById(R.id.layout_image2text_result_operation_proofread);
        Intrinsics.checkNotNullExpressionValue(textView, "it");
        if (fe.mmm.qw.rg.de.xxx.ad.yj(this, textView)) {
            textView.setOnClickListener(new Cif(this));
        }
        getCopyOper().setOnClickListener(new fe.mmm.qw.rg.de.o(this));
        getToWordOper().setOnClickListener(new ppp(this));
        fe.mmm.qw.rg.de.xxx.ad.rg(this, getExportOper());
        getExportOper().setOnClickListener(new fe.mmm.qw.rg.de.de(this));
        if (fe.mmm.qw.rg.de.xxx.ad.th(this, getMoreOper())) {
            getMoreOper().setOnClickListener(new Cswitch(this));
        }
        TextRecognitionResultActivityFlavor.ppp(this);
        getDragLayout().setContentDragMode(false);
        setEditTextCanTouch(false);
        TextRecognitionResultActivityFlavor.yj(this);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_text_detect_language);
        Intrinsics.checkNotNullExpressionValue(textView2, "it");
        if (fe.mmm.qw.rg.de.xxx.ad.uk(this, textView2)) {
            setDetectLanguageText(textView2);
            textView2.setOnClickListener(new uk(this));
        }
        if (!fe.mmm.qw.qw.qw.qw.pf()) {
            fe.mmm.qw.rg.de.aaa.qw.fe("OCRUnld", "OCRCrp", (String) null, (Map) null, 12, (Object) null);
        }
        OnLoginCallBack onLoginCallBack = this.loginCallback;
        if (onLoginCallBack != null) {
            fe.mmm.qw.qw.qw.qw.de(onLoginCallBack);
        }
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && 100 == i2) {
            handleChooseLanguageResult(intent);
        }
    }

    public void onBackButtonClicked() {
        backHint();
    }

    public void onBackPressed() {
        backHint();
    }

    public void onCopyClick() {
        Editable text = getContent().getText();
        TextRecognitionResultActivityFlavor.rg(this, text != null ? text.toString() : null);
    }

    public void onDestroy() {
        super.onDestroy();
        OnLoginCallBack onLoginCallBack = this.loginCallback;
        if (onLoginCallBack != null) {
            fe.mmm.qw.qw.qw.qw.ggg(onLoginCallBack);
        }
        this.loginCallback = null;
    }

    public void onEditClick() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "ocr_result_check_click", (List) null, 2, (Object) null);
        setEditTextCanTouch(true);
        getContent().setSelection(0);
        getContent().setOnLongClickListener(new when(this));
        getDragLayout().setExpandState(true);
        if (!getKeyBoardWatcher().fe()) {
            getDragLayout().postDelayed(new th(this), 500);
        }
    }

    public void onExportClick() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "ocr_result_export_click", (List) null, 2, (Object) null);
        requestExportFile();
    }

    public void onResume() {
        super.onResume();
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "ocr_result_show", (List) null, 2, (Object) null);
    }

    public void onRightButtonClicked(@Nullable View view) {
    }

    public void onToWordClick() {
        Editable text = getContent().getText();
        TextRecognitionResultActivityFlavor.m746switch(this, text != null ? text.toString() : null);
    }

    public void onTranslateClick() {
        onAiTranslateClick();
    }

    public final void showTranslateVipStatusView$business_text_recongition_aiscanConfigRelease() {
        View findViewById = findViewById(R.id.fl_to_word_vip_status);
        if (findViewById != null) {
            fe.mmm.qw.th.qw.rg.fe.de.qw.fe(findViewById);
        }
        if (findViewById != null) {
            findViewById.post(new fe.mmm.qw.rg.de.qw(findViewById, this));
        }
    }

    public final void startPhotoToWord$business_text_recongition_aiscanConfigRelease() {
        String[] strArr = new String[1];
        String imagePath = getImagePath();
        if (imagePath == null) {
            imagePath = "";
        }
        strArr[0] = imagePath;
        new fe.mmm.qw.p024if.p025if.qw.qw().de(this, CollectionsKt__CollectionsKt.arrayListOf(strArr), 15, Boolean.FALSE, "from_shot", "", getUbcSource());
        TextRecognitionResultActivityFlavor.ppp(this);
    }
}
