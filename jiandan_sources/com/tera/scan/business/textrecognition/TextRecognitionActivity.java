package com.tera.scan.business.textrecognition;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.baidu.aiscan.R;
import com.google.common.base.Ascii;
import com.tera.scan.business.textrecognition.dialog.NoTextDetectDialog;
import com.tera.scan.business.textrecognition.viewmodel.TextRecognitionViewModel;
import com.tera.scan.component.base.ui.manager.DialogCtrListener;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.ui.widget.titlebar.ICommonTitleBarClickListener;
import fe.mmm.qw.rg.de.nn.fe;
import fe.mmm.qw.rg.de.nn.th;
import fe.mmm.qw.rg.de.nn.uk;
import fe.mmm.qw.rg.de.nn.yj;
import fe.mmm.qw.rg.de.rg;
import i.qw.Cif;
import i.qw.u;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010/\u001a\u000200H\u0014J\u0012\u00101\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0014J\b\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u000203H\u0014J\b\u00107\u001a\u000203H\u0002J\u0012\u00108\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u000203H\u0002J\b\u0010<\u001a\u000203H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u001aR\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b(\u0010\u0007R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b,\u0010-¨\u0006>"}, d2 = {"Lcom/tera/scan/business/textrecognition/TextRecognitionActivity;", "Lcom/tera/scan/framework/BaseActivity;", "Lcom/tera/scan/ui/widget/titlebar/ICommonTitleBarClickListener;", "()V", "from", "", "getFrom", "()Ljava/lang/String;", "from$delegate", "Lkotlin/Lazy;", "imagePathList", "", "getImagePathList", "()Ljava/util/List;", "imagePathList$delegate", "languageType", "getLanguageType", "languageType$delegate", "pageHandler", "Lcom/tera/scan/business/textrecognition/ocrresulthandler/BaseResultHandler;", "getPageHandler", "()Lcom/tera/scan/business/textrecognition/ocrresulthandler/BaseResultHandler;", "pageHandler$delegate", "previewImage", "Landroid/widget/ImageView;", "getPreviewImage", "()Landroid/widget/ImageView;", "previewImage$delegate", "progressAnim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "scanLineImage", "getScanLineImage", "scanLineImage$delegate", "scanlineAnimation", "Landroid/view/animation/TranslateAnimation;", "getScanlineAnimation", "()Landroid/view/animation/TranslateAnimation;", "scanlineAnimation$delegate", "ubcSource", "getUbcSource", "ubcSource$delegate", "viewModel", "Lcom/tera/scan/business/textrecognition/viewmodel/TextRecognitionViewModel;", "getViewModel", "()Lcom/tera/scan/business/textrecognition/viewmodel/TextRecognitionViewModel;", "viewModel$delegate", "getLayoutId", "", "getOcrResultAdapterByFrom", "initListener", "", "initView", "onBackButtonClicked", "onDestroy", "onOcrError", "onRightButtonClicked", "view", "Landroid/view/View;", "setPreview", "showLoading", "Companion", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionActivity extends BaseActivity implements ICommonTitleBarClickListener {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String FROM_CAMERA_TRANSLATE = "camera_translate";
    @NotNull
    public static final String FROM_IMAGE_TRANSLATE = "image_translate";
    @NotNull
    public static final String FROM_PDF_TRANSLATE = "pdf_translate";
    @NotNull
    public static final String FROM_SCAN_PREVIEW = "doc_scan_preview";
    @NotNull
    public static final String FROM_TEXT_OCR = "text_ocr";
    @NotNull
    public static final String KEY_FROM = "from";
    @NotNull
    public static final String KEY_IMAGE_URI_LIST = "KEY_IMAGE_URI_LIST";
    @NotNull
    public static final String KEY_LANGUAGE = "KEY_LANGUAGE";
    @NotNull
    public static final String KEY_UBC_SOURCE = "ubc_source";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy from$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionActivity$from$2(this));
    @NotNull
    public final Lazy imagePathList$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionActivity$imagePathList$2(this));
    @NotNull
    public final Lazy languageType$delegate;
    @NotNull
    public final Lazy pageHandler$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionActivity$pageHandler$2(this));
    @NotNull
    public final Lazy previewImage$delegate;
    public final ValueAnimator progressAnim;
    @NotNull
    public final Lazy scanLineImage$delegate;
    @NotNull
    public final Lazy scanlineAnimation$delegate;
    @NotNull
    public final Lazy ubcSource$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionActivity$ubcSource$2(this));
    @NotNull
    public final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionActivity$viewModel$2(this));

    public static final class ad implements DialogCtrListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Dialog f6820ad;
        public final /* synthetic */ TextRecognitionActivity qw;

        public ad(TextRecognitionActivity textRecognitionActivity, Dialog dialog) {
            this.qw = textRecognitionActivity;
            this.f6820ad = dialog;
        }

        public void ad() {
            this.f6820ad.cancel();
        }

        public void qw() {
            this.qw.finish();
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent ad(qw qwVar, Context context, List list, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                str2 = null;
            }
            return qwVar.qw(context, list, str, str2, str3);
        }

        @NotNull
        public final Intent qw(@NotNull Context context, @NotNull List<String> list, @NotNull String str, @Nullable String str2, @NotNull String str3) {
            Context context2 = context;
            String str4 = str;
            String str5 = str3;
            Intrinsics.checkNotNullParameter(context, "context");
            List<String> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "pathList");
            Intrinsics.checkNotNullParameter(str4, "from");
            Intrinsics.checkNotNullParameter(str5, "ubcSource");
            Intent intent = new Intent(context, TextRecognitionActivity.class);
            intent.putExtra(TextRecognitionActivity.KEY_IMAGE_URI_LIST, CollectionsKt___CollectionsKt.joinToString$default(list2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            intent.putExtra(TextRecognitionActivity.KEY_LANGUAGE, str2 == null ? Locale.getDefault().getLanguage() : str2);
            intent.putExtra("from", str4);
            intent.putExtra("ubc_source", str5);
            return intent;
        }
    }

    public TextRecognitionActivity() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 99});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(3000);
        ofInt.addUpdateListener(new rg(this));
        this.progressAnim = ofInt;
        this.previewImage$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionActivity$previewImage$2(this));
        this.languageType$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionActivity$languageType$2(this));
        this.scanLineImage$delegate = LazyKt__LazyJVMKt.lazy(new TextRecognitionActivity$scanLineImage$2(this));
        this.scanlineAnimation$delegate = LazyKt__LazyJVMKt.lazy(TextRecognitionActivity$scanlineAnimation$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final String getFrom() {
        return (String) this.from$delegate.getValue();
    }

    private final String getLanguageType() {
        Object value = this.languageType$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-languageType>(...)");
        return (String) value;
    }

    /* access modifiers changed from: private */
    public final fe getOcrResultAdapterByFrom(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1814522303:
                    if (str.equals(FROM_PDF_TRANSLATE)) {
                        return new yj(str);
                    }
                    break;
                case -1003306228:
                    if (str.equals(FROM_TEXT_OCR)) {
                        return new uk(str, getUbcSource());
                    }
                    break;
                case 583589738:
                    if (str.equals(FROM_IMAGE_TRANSLATE)) {
                        return new th(str);
                    }
                    break;
                case 1248969908:
                    if (str.equals(FROM_CAMERA_TRANSLATE)) {
                        return new fe.mmm.qw.rg.de.nn.rg(str);
                    }
                    break;
            }
        }
        return new uk(str, getUbcSource());
    }

    private final fe getPageHandler() {
        return (fe) this.pageHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ImageView getPreviewImage() {
        Object value = this.previewImage$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-previewImage>(...)");
        return (ImageView) value;
    }

    private final ImageView getScanLineImage() {
        Object value = this.scanLineImage$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-scanLineImage>(...)");
        return (ImageView) value;
    }

    private final TranslateAnimation getScanlineAnimation() {
        return (TranslateAnimation) this.scanlineAnimation$delegate.getValue();
    }

    private final String getUbcSource() {
        return (String) this.ubcSource$delegate.getValue();
    }

    private final TextRecognitionViewModel getViewModel() {
        return (TextRecognitionViewModel) this.viewModel$delegate.getValue();
    }

    private final void initListener() {
        getViewModel().getOrcResultLiveData().observe(this, new fe.mmm.qw.rg.de.ad(this));
    }

    /* renamed from: initListener$lambda-5  reason: not valid java name */
    public static final void m732initListener$lambda5(TextRecognitionActivity textRecognitionActivity, List list) {
        Intrinsics.checkNotNullParameter(textRecognitionActivity, "this$0");
        if (list != null) {
            boolean z = true;
            if (!list.isEmpty()) {
                int i2 = 0;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!TextUtils.isEmpty((String) it.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (Object next : list) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        arrayList.add(new fe.mmm.qw.rg.de.ddd.qw(textRecognitionActivity.getImagePathList().get(i2), (String) null, (String) next));
                        i2 = i3;
                    }
                    try {
                        textRecognitionActivity.getPageHandler().qw(textRecognitionActivity, arrayList, textRecognitionActivity.getLanguageType());
                        return;
                    } catch (Exception e) {
                        fe.mmm.qw.i.qw.rg("TextRecognitionActivity", "pageHandler.afterOcr error : " + e);
                        return;
                    }
                }
            }
            textRecognitionActivity.onOcrError();
        }
    }

    private final void onOcrError() {
        NoTextDetectDialog noTextDetectDialog = new NoTextDetectDialog();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        Intrinsics.checkNotNullExpressionValue(context, "context");
        noTextDetectDialog.qw(supportFragmentManager, context, new TextRecognitionActivity$onOcrError$1(this), new TextRecognitionActivity$onOcrError$2(this));
        getPageHandler().ad();
    }

    /* renamed from: progressAnim$lambda-1$lambda-0  reason: not valid java name */
    public static final void m733progressAnim$lambda1$lambda0(TextRecognitionActivity textRecognitionActivity, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(textRecognitionActivity, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        TextView textView = (TextView) textRecognitionActivity._$_findCachedViewById(R.id.tv_ocr_progress);
        StringBuilder sb = new StringBuilder();
        sb.append(textRecognitionActivity.getString(R.string.image2text_percentage));
        sb.append(Ascii.CASE_MASK);
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            sb.append(((Integer) animatedValue).intValue());
            sb.append('%');
            textView.setText(sb.toString());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void setPreview() {
        T t;
        Context applicationContext;
        Iterator<T> it = getImagePathList().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (new File((String) t).exists()) {
                break;
            }
        }
        String str = (String) t;
        if (str != null && (applicationContext = getApplicationContext()) != null) {
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext ?: return@let");
            Job unused = Cif.fe(LifecycleOwnerKt.getLifecycleScope(this), u.qw(), (CoroutineStart) null, new TextRecognitionActivity$setPreview$1$1(str, applicationContext, str, this, (Continuation<? super TextRecognitionActivity$setPreview$1$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        setPreview();
        getScanLineImage().startAnimation(getScanlineAnimation());
        if (getViewModel().startRecognition(getImagePathList(), getLanguageType())) {
            this.progressAnim.start();
        }
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
    public final List<String> getImagePathList() {
        return (List) this.imagePathList$delegate.getValue();
    }

    public int getLayoutId() {
        return R.layout.layout_image2text_recognition;
    }

    public void initView() {
        try {
            Result.Companion companion = Result.Companion;
            InputStream open = getAssets().open("ocr/img_0.png");
            Intrinsics.checkNotNullExpressionValue(open, "assetManager.open(\"ocr/img_0.png\")");
            getScanLineImage().setImageBitmap(BitmapFactory.decodeStream(open));
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        initListener();
        showLoading();
        getPageHandler().de();
        fe.mmm.qw.rg.de.aaa.qw.fe("OCRing", "OCRCrp", (String) null, (Map) null, 12, (Object) null);
    }

    public void onBackButtonClicked() {
        fe.mmm.qw.th.qw.rg.de.fe feVar = new fe.mmm.qw.th.qw.rg.de.fe();
        Dialog uk2 = feVar.uk(this, R.string.image2text_discard_title, R.string.image2text_discard_desc, R.string.confirm, R.string.cancel);
        feVar.de(new ad(this, uk2));
        uk2.show();
    }

    public void onDestroy() {
        super.onDestroy();
        getViewModel().releaseMemo();
        this.progressAnim.cancel();
    }

    public void onRightButtonClicked(@Nullable View view) {
    }
}
