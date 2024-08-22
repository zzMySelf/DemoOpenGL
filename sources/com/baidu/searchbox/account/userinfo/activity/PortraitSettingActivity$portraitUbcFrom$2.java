package com.baidu.searchbox.account.userinfo.activity;

import android.text.TextUtils;
import com.baidu.searchbox.account.accountconstant.PortraitConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PortraitSettingActivity.kt */
final class PortraitSettingActivity$portraitUbcFrom$2 extends Lambda implements Function0<String> {
    final /* synthetic */ PortraitSettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PortraitSettingActivity$portraitUbcFrom$2(PortraitSettingActivity portraitSettingActivity) {
        super(0);
        this.this$0 = portraitSettingActivity;
    }

    public final String invoke() {
        String result = this.this$0.getIntent().getStringExtra("from");
        if (TextUtils.isEmpty(result)) {
            return PortraitConstant.UBC_PORTRAIT_DEFAULT_FROM;
        }
        return result;
    }
}
