package com.baidu.searchbox.aipersonal.widgets;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.home.tabs.extend.IHomeTabFun;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/home/tabs/extend/IHomeTabFun;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiCacheView.kt */
final class PersonalAiCacheView$homeTabFun$2 extends Lambda implements Function0<IHomeTabFun> {
    public static final PersonalAiCacheView$homeTabFun$2 INSTANCE = new PersonalAiCacheView$homeTabFun$2();

    PersonalAiCacheView$homeTabFun$2() {
        super(0);
    }

    public final IHomeTabFun invoke() {
        return (IHomeTabFun) ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE);
    }
}
