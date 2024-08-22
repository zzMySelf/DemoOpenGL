package com.baidu.searchbox.kmm.home.popup;

import com.baidu.searchbox.kmm.foundation.storage.KVInstance;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"HOME_POPUP_RULE_CATEGORY_FREQUENCY_KEY", "", "HOME_POPUP_RULE_FREQUENCY_KEY", "HOME_POPUP_RULE_SHOWED_VERSION", "HOME_POPUP_RULE_VERSION_INFO_KEY", "showedKvInstance", "Lcom/baidu/searchbox/kmm/foundation/storage/KVInstance;", "getShowedKvInstance", "()Lcom/baidu/searchbox/kmm/foundation/storage/KVInstance;", "showedKvInstance$delegate", "Lkotlin/Lazy;", "com.baidu.searchbox.kmm.business.home"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PopupRuleManager.kt */
public final class PopupRuleManagerKt {
    private static final String HOME_POPUP_RULE_CATEGORY_FREQUENCY_KEY = "category_frequency_control";
    private static final String HOME_POPUP_RULE_FREQUENCY_KEY = "frequency_control_content";
    private static final String HOME_POPUP_RULE_SHOWED_VERSION = "home_popup_rule_version";
    private static final String HOME_POPUP_RULE_VERSION_INFO_KEY = "version_info";
    private static final Lazy showedKvInstance$delegate = LazyKt.lazy(PopupRuleManagerKt$showedKvInstance$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final KVInstance getShowedKvInstance() {
        return (KVInstance) showedKvInstance$delegate.getValue();
    }
}
