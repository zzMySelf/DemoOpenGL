package com.baidu.searchbox.openwidget.config;

import com.baidu.searchbox.openwidget.config.StyleConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/openwidget/config/StyleConfig$RemoteStyleConfig;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StyleConfig.kt */
final class StyleConfig$styleConfig2x2$2 extends Lambda implements Function0<StyleConfig.RemoteStyleConfig> {
    public static final StyleConfig$styleConfig2x2$2 INSTANCE = new StyleConfig$styleConfig2x2$2();

    StyleConfig$styleConfig2x2$2() {
        super(0);
    }

    public final StyleConfig.RemoteStyleConfig invoke() {
        return StyleConfig.INSTANCE.loadRemoteStyle2x2();
    }
}
