package com.baidu.searchbox.mall.container;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.lightbrowserbeeinterface.ILightBrowerBeePreCreateInterface;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"DEBUG", "", "TAG", "", "activeContainerIds", "", "windowControlReferences", "Ljava/util/WeakHashMap;", "Lcom/baidu/searchbox/lightbrowserbeeinterface/ILightBrowerBeePreCreateInterface;", "lib-aisearch-bee-runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AISearchContainer.kt */
public final class AISearchContainerKt {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "AISearchContainer";
    /* access modifiers changed from: private */
    public static final Set<String> activeContainerIds = new LinkedHashSet();
    /* access modifiers changed from: private */
    public static final WeakHashMap<String, ILightBrowerBeePreCreateInterface> windowControlReferences = new WeakHashMap<>();
}
