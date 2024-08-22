package com.tera.scan.main.viewmodel;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.baidu.aiscan.R;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.main.TeraScanApplication;
import com.tera.scan.main.welcome.PrivacyAgreementDialog;
import fe.mmm.qw.th.qw.th.rg;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¨\u0006\u000e"}, d2 = {"Lcom/tera/scan/main/viewmodel/WelcomeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "getDialogContent", "Landroid/text/SpannableString;", "activity", "Landroid/app/Activity;", "showAgreementDialog", "", "Lcom/tera/scan/framework/BaseActivity;", "clickOkListener", "Lkotlin/Function0;", "clickCancelListener", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WelcomeViewModel extends ViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);

    public static final class ad extends ClickableSpan {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Activity f7024ad;

        public ad(Activity activity) {
            this.f7024ad = activity;
        }

        public void onClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            fe.mmm.qw.l.de.ad(this.f7024ad, "https://pan.baidu.com/disk/base/protocol#/scan_privacy_android");
        }

        public void updateDrawState(@NotNull TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, BindVerifyActivity.h);
            textPaint.setColor(this.f7024ad.getResources().getColor(R.color.color_privacy));
            textPaint.setUnderlineText(this.f7024ad.getResources().getBoolean(R.bool.privacy_click_span_under_line_text));
        }
    }

    public static final class de extends ClickableSpan {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Activity f7025ad;

        public de(Activity activity) {
            this.f7025ad = activity;
        }

        public void onClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            fe.mmm.qw.l.de.ad(this.f7025ad, "https://pan.baidu.com/disk/base/protocol#/scan_service");
        }

        public void updateDrawState(@NotNull TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, BindVerifyActivity.h);
            textPaint.setColor(this.f7025ad.getResources().getColor(R.color.color_privacy));
            textPaint.setUnderlineText(this.f7025ad.getResources().getBoolean(R.bool.privacy_click_span_under_line_text));
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final SpannableString qw(Activity activity) {
        String string = activity.getResources().getString(R.string.privacy_agreement_desc);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt…g.privacy_agreement_desc)");
        String string2 = activity.getResources().getString(R.string.privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt…(R.string.privacy_policy)");
        String str = string;
        String str2 = string2;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        int length = string2.length() + StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        String string3 = activity.getResources().getString(R.string.terms_of_service);
        Intrinsics.checkNotNullExpressionValue(string3, "activity.resources.getSt….string.terms_of_service)");
        String str3 = string;
        String str4 = string3;
        int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str3, str4, 0, false, 6, (Object) null);
        int indexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) str3, str4, 0, false, 6, (Object) null) + string3.length();
        SpannableString spannableString = new SpannableString(string);
        if (indexOf$default > 0) {
            spannableString.setSpan(new ad(activity), indexOf$default, length, 33);
        }
        if (indexOf$default2 > 0) {
            spannableString.setSpan(new de(activity), indexOf$default2, indexOf$default3, 33);
        }
        return spannableString;
    }

    public final void showAgreementDialog(@NotNull BaseActivity baseActivity, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Object obj;
        Intrinsics.checkNotNullParameter(baseActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(function0, "clickOkListener");
        Intrinsics.checkNotNullParameter(function02, "clickCancelListener");
        if (rg.qw(baseActivity)) {
            TeraScanApplication teraScanApplication = TeraScanApplication.netdiskApplication;
            if (teraScanApplication != null) {
                teraScanApplication.onUserAgreePrivacyAgreement();
            }
        } else if (baseActivity.isFinishing() || baseActivity.isDestroyed()) {
            function02.invoke();
        } else {
            PrivacyAgreementDialog privacyAgreementDialog = new PrivacyAgreementDialog();
            privacyAgreementDialog.setCancelable(false);
            privacyAgreementDialog.setOnConfirmChange(new WelcomeViewModel$showAgreementDialog$1(baseActivity, function0));
            privacyAgreementDialog.setOnCancelChange(new WelcomeViewModel$showAgreementDialog$2(function02));
            privacyAgreementDialog.setContent(qw(baseActivity));
            try {
                Result.Companion companion = Result.Companion;
                FragmentManager supportFragmentManager = baseActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                privacyAgreementDialog.show(supportFragmentManager, "PrivacyAgreementDialog");
                obj = Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r3 = Result.m1158exceptionOrNullimpl(obj);
            if (r3 != null) {
                LoggerKt.e$default(r3, (Object) null, 1, (Object) null);
            }
        }
    }
}
