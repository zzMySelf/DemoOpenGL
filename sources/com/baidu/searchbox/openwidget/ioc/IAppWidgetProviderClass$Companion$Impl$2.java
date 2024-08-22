package com.baidu.searchbox.openwidget.ioc;

import com.baidu.searchbox.openwidget.runtime.OpenWidgetRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/openwidget/ioc/IAppWidgetProviderClass;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IAppWidgetProviderClass.kt */
final class IAppWidgetProviderClass$Companion$Impl$2 extends Lambda implements Function0<IAppWidgetProviderClass> {
    public static final IAppWidgetProviderClass$Companion$Impl$2 INSTANCE = new IAppWidgetProviderClass$Companion$Impl$2();

    IAppWidgetProviderClass$Companion$Impl$2() {
        super(0);
    }

    public final IAppWidgetProviderClass invoke() {
        return OpenWidgetRuntime.INSTANCE.getAppWidgetProviderClass();
    }
}
