package com.baidu.searchbox.feed.video.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/feed/video/view/VideoBannerFormDialog$requestPhoneNumCallBack$1", "Lcom/baidu/searchbox/http/callback/StringResponseCallback;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "response", "", "statusCode", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoBannerFormDialog.kt */
public final class VideoBannerFormDialog$requestPhoneNumCallBack$1 extends StringResponseCallback {
    final /* synthetic */ VideoBannerFormDialog this$0;

    VideoBannerFormDialog$requestPhoneNumCallBack$1(VideoBannerFormDialog $receiver) {
        this.this$0 = $receiver;
    }

    public void onSuccess(String response, int statusCode) {
        if (response != null) {
            VideoBannerFormDialog videoBannerFormDialog = this.this$0;
            String str = response;
            if (statusCode == 200 && (!StringsKt.isBlank(response))) {
                try {
                    JSONObject dataJo = new JSONObject(response).optJSONObject("data");
                    TextView textView = null;
                    String phoneNum = dataJo != null ? dataJo.optString("phone") : null;
                    if (videoBannerFormDialog.isEncodePhoneNum(phoneNum)) {
                        videoBannerFormDialog.setFormType(FormType.AUTO_INPUT_LOGIN);
                        TextView access$getAutoInputView$p = videoBannerFormDialog.autoInputView;
                        if (access$getAutoInputView$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("autoInputView");
                            access$getAutoInputView$p = null;
                        }
                        access$getAutoInputView$p.setText(phoneNum);
                        TextView access$getSubmitButton$p = videoBannerFormDialog.submitButton;
                        if (access$getSubmitButton$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("submitButton");
                            access$getSubmitButton$p = null;
                        }
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = videoBannerFormDialog.getContextEx().getResources().getString(R.string.video_banner_form_submit_text_auto_input);
                        Intrinsics.checkNotNullExpressionValue(string, "contextEx.resources\n    …m_submit_text_auto_input)");
                        Object[] objArr = new Object[1];
                        String access$getSubmitBtnText$p = videoBannerFormDialog.submitBtnText;
                        if (access$getSubmitBtnText$p == null) {
                            access$getSubmitBtnText$p = "";
                        }
                        objArr[0] = access$getSubmitBtnText$p;
                        String format = String.format(string, Arrays.copyOf(objArr, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        access$getSubmitButton$p.setText(format);
                        TextView access$getSubmitButton$p2 = videoBannerFormDialog.submitButton;
                        if (access$getSubmitButton$p2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("submitButton");
                        } else {
                            textView = access$getSubmitButton$p2;
                        }
                        textView.setOnClickListener(new VideoBannerFormDialog$requestPhoneNumCallBack$1$$ExternalSyntheticLambda0(videoBannerFormDialog, phoneNum));
                        return;
                    }
                } catch (JSONException e2) {
                }
            }
        }
        this.this$0.startUserInputPhoneNum();
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-1$lambda-0  reason: not valid java name */
    public static final void m19732onSuccess$lambda1$lambda0(VideoBannerFormDialog this$02, String $phoneNum, View it) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Function3 access$getSubmitAction$p = this$02.submitAction;
        if (access$getSubmitAction$p != null) {
            access$getSubmitAction$p.invoke(this$02, $phoneNum == null ? "" : $phoneNum, this$02.getFormType());
        }
    }

    public void onFail(Exception e2) {
        this.this$0.startUserInputPhoneNum();
    }
}
