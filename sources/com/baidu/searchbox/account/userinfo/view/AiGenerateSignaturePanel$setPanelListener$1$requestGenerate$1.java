package com.baidu.searchbox.account.userinfo.view;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.account.userinfo.view.AiGenerateSignatureView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.kmm.account.entities.WenxinProfileResultModel;
import com.baidu.searchbox.kmm.account.entities.WenxinProfileTips;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "resultModel", "Lcom/baidu/searchbox/kmm/account/entities/WenxinProfileResultModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiGenerateSignaturePanel.kt */
final class AiGenerateSignaturePanel$setPanelListener$1$requestGenerate$1 extends Lambda implements Function1<WenxinProfileResultModel, Unit> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ AiGenerateSignaturePanel this$0;
    final /* synthetic */ AiGenerateSignaturePanel$setPanelListener$1 this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiGenerateSignaturePanel$setPanelListener$1$requestGenerate$1(Function0<Unit> function0, AiGenerateSignaturePanel aiGenerateSignaturePanel, AiGenerateSignaturePanel$setPanelListener$1 aiGenerateSignaturePanel$setPanelListener$1) {
        super(1);
        this.$callback = function0;
        this.this$0 = aiGenerateSignaturePanel;
        this.this$1 = aiGenerateSignaturePanel$setPanelListener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((WenxinProfileResultModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(WenxinProfileResultModel resultModel) {
        AiGenerateSignatureView access$getMPanelView$p;
        this.$callback.invoke();
        if (resultModel == null) {
            AiGenerateSignatureView access$getMPanelView$p2 = this.this$0.mPanelView;
            if (access$getMPanelView$p2 != null) {
                access$getMPanelView$p2.showRegenerateError();
                return;
            }
            return;
        }
        WenxinProfileResultModel access$getMDataModel$p = this.this$0.mDataModel;
        List<WenxinProfileTips> promoteList = access$getMDataModel$p != null ? access$getMDataModel$p.getPromoteList() : null;
        this.this$0.mDataModel = resultModel;
        if (promoteList != null) {
            List<WenxinProfileTips> list = promoteList;
            WenxinProfileResultModel access$getMDataModel$p2 = this.this$0.mDataModel;
            if (access$getMDataModel$p2 != null) {
                access$getMDataModel$p2.updatePromoteList(promoteList);
            }
        }
        WenxinProfileResultModel it = this.this$0.mDataModel;
        if (!(it == null || (access$getMPanelView$p = this.this$0.mPanelView) == null)) {
            access$getMPanelView$p.updateDataModel(it);
        }
        String str = "";
        boolean z = true;
        if (resultModel.isBlocked()) {
            AiGenerateSignatureView access$getMPanelView$p3 = this.this$0.mPanelView;
            if (access$getMPanelView$p3 != null) {
                access$getMPanelView$p3.resetState();
            }
            String blockMsg = resultModel.getBlockMsg();
            if (blockMsg != null) {
                str = blockMsg;
            }
            String toastText = str;
            if (toastText.length() == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this.this$0.getResources().getString(R.string.generate_signature_unavailable);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…te_signature_unavailable)");
                String text = String.format(string, Arrays.copyOf(new Object[]{this.this$0.getResources().getString(R.string.user_info_audit_hint_sign)}, 1));
                Intrinsics.checkNotNullExpressionValue(text, "format(format, *args)");
                toastText = text;
            }
            UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) toastText).show();
            this.this$0.dismiss();
            AiGenerateSignatureView.PanelEventListener.DefaultImpls.onUbcEvent$default(this.this$1, "fail", (String) null, 2, (Object) null);
        } else if (resultModel.isToast()) {
            AiGenerateSignatureView access$getMPanelView$p4 = this.this$0.mPanelView;
            if (access$getMPanelView$p4 != null) {
                access$getMPanelView$p4.resetState();
            }
            AiGenerateSignatureView access$getMPanelView$p5 = this.this$0.mPanelView;
            if (access$getMPanelView$p5 != null) {
                access$getMPanelView$p5.updateEditAreaState();
            }
            String toastMsg = resultModel.getToastMsg();
            if (toastMsg != null) {
                str = toastMsg;
            }
            String toastText2 = str;
            if (toastText2.length() != 0) {
                z = false;
            }
            if (z) {
                String string2 = this.this$0.getResources().getString(R.string.generate_failed_retry);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…ng.generate_failed_retry)");
                toastText2 = string2;
            }
            UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) toastText2).show();
            AiGenerateSignatureView.PanelEventListener.DefaultImpls.onUbcEvent$default(this.this$1, "fail", (String) null, 2, (Object) null);
        } else {
            UiThreadUtils.runOnUiThread(new AiGenerateSignaturePanel$setPanelListener$1$requestGenerate$1$$ExternalSyntheticLambda0(this.this$0, resultModel, this.this$1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m14611invoke$lambda2(AiGenerateSignaturePanel this$02, WenxinProfileResultModel $resultModel, AiGenerateSignaturePanel$setPanelListener$1 this$12) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter(this$12, "this$1");
        this$02.mNeedShowLoadingDialog = true;
        String result = $resultModel.getResult();
        if (result == null) {
            result = "";
        }
        this$02.mSignatureText = result;
        AiGenerateSignatureView access$getMPanelView$p = this$02.mPanelView;
        if (access$getMPanelView$p != null) {
            access$getMPanelView$p.generateSignature(this$02.mSignatureText);
        }
        AiGenerateSignatureView.PanelEventListener.DefaultImpls.onUbcEvent$default(this$12, "success", (String) null, 2, (Object) null);
    }
}
