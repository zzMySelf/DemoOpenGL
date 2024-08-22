package com.tera.scan.business.textrecognition;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.ClipboardManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.baidu.aiscan.R;
import com.baidu.netdisk.trade.privilege.MemberProduct;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.ui.view.widget.UITextView;
import com.tera.scan.vip.ui.view.PrivilegeBannerView;
import fe.mmm.qw.nn.qw.qw.i;
import fe.mmm.qw.rg.de.aaa.ad;
import fe.mmm.qw.rg.de.ggg;
import fe.mmm.qw.rg.de.pf;
import fe.mmm.qw.th.qw.rg.fe.de.qw;
import fe.mmm.qw.th.qw.th.o;
import i.qw.Cif;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010\r\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0007H\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0006*\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0000\u001a9\u0010\u0014\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\t2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0017H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0006*\u00020\u0007H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"login", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copy", "", "Lcom/tera/scan/business/textrecognition/TextRecognitionResultActivity;", "text", "", "copyToClipboard", "context", "Landroid/content/Context;", "initPrivilegeBannerView", "isSVip", "observerFreeCount", "bannerView", "Lcom/tera/scan/vip/ui/view/PrivilegeBannerView;", "onToWordClickEvent", "content", "openHalfProductPage", "from", "onResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "updateToWordVipIconStatus", "business-text-recongition_aiscanConfigRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "TextRecognitionResultActivityFlavor")
public final class TextRecognitionResultActivityFlavor {
    public static final boolean i(TextRecognitionResultActivity textRecognitionResultActivity) {
        return TradeAccount.f913rg.o(MemberProduct.SCAN_VIP);
    }

    /* renamed from: if  reason: not valid java name */
    public static final void m745if(TextRecognitionResultActivity textRecognitionResultActivity, PrivilegeBannerView privilegeBannerView, Integer num) {
        String str;
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "$this_observerFreeCount");
        Intrinsics.checkNotNullParameter(privilegeBannerView, "$bannerView");
        if (Intrinsics.areEqual((Object) textRecognitionResultActivity.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().getPrivilegeBannerViewVisibility().getValue(), (Object) Boolean.TRUE)) {
            if (!(privilegeBannerView.getVisibility() == 0)) {
                ad.fe("Gd_Display", "Trial_Guide", (String) null, (String) null, (Map) null, 28, (Object) null);
            }
            qw.fe(privilegeBannerView);
            if (num != null && num.intValue() == 0) {
                str = textRecognitionResultActivity.getContext().getResources().getString(R.string.privilege_banner_free_count_zero_message, new Object[]{textRecognitionResultActivity.getContext().getResources().getString(R.string.privilege_banner_text_recognition_name)});
            } else {
                str = textRecognitionResultActivity.getContext().getResources().getString(R.string.privilege_banner_free_count_message, new Object[]{textRecognitionResultActivity.getContext().getResources().getString(R.string.privilege_banner_text_recognition_name), num});
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (count == 0) {\n      …t\n            )\n        }");
            privilegeBannerView.setFreeCountText(str);
        }
    }

    public static final Object o(LifecycleOwner lifecycleOwner, Continuation<? super Boolean> continuation) {
        if (fe.mmm.qw.p030switch.rg.qw.qw().isLogin()) {
            return Boxing.boxBoolean(true);
        }
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        if (fe.mmm.qw.p030switch.rg.qw.qw().isLogin()) {
            Result.Companion companion = Result.Companion;
            safeContinuation.resumeWith(Result.m1155constructorimpl(Boxing.boxBoolean(true)));
        } else {
            fe.mmm.qw.qw.qw.xxx(fe.mmm.qw.qw.qw.qw, lifecycleOwner, (String) null, true, new TextRecognitionResultActivityFlavor$login$2$1(safeContinuation), 2, (Object) null);
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final void pf(TextRecognitionResultActivity textRecognitionResultActivity, PrivilegeBannerView privilegeBannerView) {
        textRecognitionResultActivity.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().queryPrivilegeFreeCount();
        textRecognitionResultActivity.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().getFreeCount().observe(textRecognitionResultActivity, new ggg(textRecognitionResultActivity, privilegeBannerView));
    }

    public static final void ppp(@NotNull TextRecognitionResultActivity textRecognitionResultActivity) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        UITextView uITextView = (UITextView) textRecognitionResultActivity.findViewById(R.id.tv_free_times);
        if (uITextView != null) {
            qw.qw(uITextView);
        }
    }

    public static final void rg(@NotNull TextRecognitionResultActivity textRecognitionResultActivity, @Nullable String str) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        if (!i.rg(textRecognitionResultActivity.getContext())) {
            o.rg(R.string.consume_vip_rights_when_network_unavailable);
            return;
        }
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            o.yj(textRecognitionResultActivity.getContext(), textRecognitionResultActivity.getResources().getString(R.string.copy_content_is_empty));
        } else {
            Job unused = Cif.fe(LifecycleOwnerKt.getLifecycleScope(textRecognitionResultActivity), (CoroutineContext) null, (CoroutineStart) null, new TextRecognitionResultActivityFlavor$copy$1(textRecognitionResultActivity, textRecognitionResultActivity, str, (Continuation<? super TextRecognitionResultActivityFlavor$copy$1>) null), 3, (Object) null);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static final void m746switch(@NotNull TextRecognitionResultActivity textRecognitionResultActivity, @Nullable String str) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        textRecognitionResultActivity.startPhotoToWord$business_text_recongition_aiscanConfigRelease();
    }

    public static final void th(TextRecognitionResultActivity textRecognitionResultActivity, Context context, String str) {
        Object obj;
        try {
            Object systemService = context.getSystemService("clipboard");
            ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            if (clipboardManager != null) {
                clipboardManager.setText(str);
            }
            o.yj(context, context.getResources().getString(R.string.copy_link_success));
            ad.fe("TrialUse", "Trial_Guide", (String) null, (String) null, (Map) null, 28, (Object) null);
            if (!i(textRecognitionResultActivity)) {
                textRecognitionResultActivity.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().consumeOncePrivilege(TextRecognitionResultActivityFlavor$copyToClipboard$1$1.INSTANCE);
            }
            obj = ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            obj = ExpectKt.failure(th2);
        }
        if (obj instanceof Either.Left) {
            Throwable th3 = (Throwable) ((Either.Left) obj).getValue();
            o.yj(context, textRecognitionResultActivity.getResources().getString(R.string.copy_link_failed));
            new Either.Left(Unit.INSTANCE);
        } else if (!(obj instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void uk(TextRecognitionResultActivity textRecognitionResultActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "$this_initPrivilegeBannerView");
        if (!bool.booleanValue()) {
            qw.qw(textRecognitionResultActivity.getPrivilegeBannerView$business_text_recongition_aiscanConfigRelease());
        } else {
            pf(textRecognitionResultActivity, textRecognitionResultActivity.getPrivilegeBannerView$business_text_recongition_aiscanConfigRelease());
        }
    }

    public static final void when(TextRecognitionResultActivity textRecognitionResultActivity, String str, Function1<? super Boolean, Unit> function1) {
        if (i(textRecognitionResultActivity)) {
            function1.invoke(Boolean.TRUE);
        } else {
            fe.mmm.qw.k.i.ad.ad(textRecognitionResultActivity.getContext(), str, new TextRecognitionResultActivityFlavor$openHalfProductPage$1(function1, new Handler(Looper.getMainLooper())));
        }
    }

    public static final void yj(@NotNull TextRecognitionResultActivity textRecognitionResultActivity) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        textRecognitionResultActivity.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().getPrivilegeBannerViewVisibility().observe(textRecognitionResultActivity, new pf(textRecognitionResultActivity));
        textRecognitionResultActivity.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().initPrivilegeBannerViewVisibility();
        textRecognitionResultActivity.getPrivilegeBannerView$business_text_recongition_aiscanConfigRelease().setOnCloseListener(new TextRecognitionResultActivityFlavor$initPrivilegeBannerView$2(textRecognitionResultActivity));
        textRecognitionResultActivity.getPrivilegeBannerView$business_text_recongition_aiscanConfigRelease().setOpenCashierDeskListener(new TextRecognitionResultActivityFlavor$initPrivilegeBannerView$3(textRecognitionResultActivity));
    }
}
