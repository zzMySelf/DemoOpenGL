package com.baidu.swan.apps.setting.oauth.record;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.setting.oauth.SwanAppAuthDialogUtils;
import com.baidu.swan.apps.setting.oauth.agreement.SwanServiceAgreementActivity;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/swan/apps/setting/oauth/record/SwanAppUserPrivacyManager;", "", "()V", "KEY_IS_SIGN_PRIVACY", "", "KEY_PRIVACY_ABOUT", "KEY_PRIVACY_KEYWORD", "KEY_PRIVACY_URL", "getPrivacyTextForAbout", "obtainUserPrivacyJson", "Lorg/json/JSONObject;", "transferTextToSpannableString", "", "content", "showComplaint", "", "updateSpanArea", "", "spannableString", "Landroid/text/SpannableString;", "keyword", "listener", "Landroid/view/View$OnClickListener;", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanAppUserPrivacyManager.kt */
public final class SwanAppUserPrivacyManager {
    public static final SwanAppUserPrivacyManager INSTANCE = new SwanAppUserPrivacyManager();
    private static final String KEY_IS_SIGN_PRIVACY = "is_sign_privacy";
    private static final String KEY_PRIVACY_ABOUT = "privacy_about";
    private static final String KEY_PRIVACY_KEYWORD = "privacy_keyword";
    private static final String KEY_PRIVACY_URL = "privacy_url";

    private SwanAppUserPrivacyManager() {
    }

    public final String getPrivacyTextForAbout() {
        JSONObject json = obtainUserPrivacyJson();
        if (!json.optBoolean(KEY_IS_SIGN_PRIVACY)) {
            return null;
        }
        return json.optString(KEY_PRIVACY_ABOUT);
    }

    public static /* synthetic */ CharSequence transferTextToSpannableString$default(SwanAppUserPrivacyManager swanAppUserPrivacyManager, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return swanAppUserPrivacyManager.transferTextToSpannableString(str, z);
    }

    public final CharSequence transferTextToSpannableString(String content, boolean showComplaint) {
        Intrinsics.checkNotNullParameter(content, "content");
        JSONObject json = obtainUserPrivacyJson();
        boolean privacyEnabled = json.optBoolean(KEY_IS_SIGN_PRIVACY);
        String keyword = json.optString(KEY_PRIVACY_KEYWORD);
        String privacyUrl = json.optString("privacy_url");
        SpannableString spannableString = new SpannableString(content);
        Application context = SwanAppRuntime.getAppContext();
        String complaintWords = context.getResources().getString(R.string.swan_app_explain_view_complaint_text);
        Intrinsics.checkNotNullExpressionValue(complaintWords, "context.resources.getStr…lain_view_complaint_text)");
        if (showComplaint) {
            updateSpanArea(spannableString, complaintWords, new SwanAppUserPrivacyManager$$ExternalSyntheticLambda0());
        }
        if (privacyEnabled) {
            Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
            updateSpanArea(spannableString, keyword, new SwanAppUserPrivacyManager$$ExternalSyntheticLambda1(keyword, context, privacyUrl));
        }
        return spannableString;
    }

    /* access modifiers changed from: private */
    /* renamed from: transferTextToSpannableString$lambda-0  reason: not valid java name */
    public static final void m8058transferTextToSpannableString$lambda0(View it) {
        SwanAppAuthDialogUtils.INSTANCE.openFeedbackPage();
    }

    /* access modifiers changed from: private */
    /* renamed from: transferTextToSpannableString$lambda-1  reason: not valid java name */
    public static final void m8059transferTextToSpannableString$lambda1(String $keyword, Application $context, String $privacyUrl, View it) {
        Intrinsics.checkNotNullExpressionValue($keyword, "keyword");
        String title = StringsKt.removeSuffix(StringsKt.removePrefix($keyword, (CharSequence) "《"), (CharSequence) "》");
        Intent intent = new Intent($context, SwanServiceAgreementActivity.class);
        intent.putExtra("name", title);
        intent.putExtra("url", $privacyUrl);
        Activity activity = Swan.get().getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    private final void updateSpanArea(SpannableString spannableString, String keyword, View.OnClickListener listener) {
        int index = StringsKt.lastIndexOf$default((CharSequence) spannableString, keyword, 0, false, 6, (Object) null);
        if (index >= 0) {
            spannableString.setSpan(new SwanAppUserPrivacyManager$updateSpanArea$clickSpan$1(listener), index, keyword.length() + index, 33);
        }
    }

    private final JSONObject obtainUserPrivacyJson() {
        PMSAppInfo pmsAppInfo = Swan.get().getApp().getInfo().getPmsAppInfo();
        JSONObject parseString = SwanAppJSONUtils.parseString(pmsAppInfo != null ? pmsAppInfo.userPrivacy : null);
        Intrinsics.checkNotNullExpressionValue(parseString, "parseString(userPrivacy)");
        return parseString;
    }
}
