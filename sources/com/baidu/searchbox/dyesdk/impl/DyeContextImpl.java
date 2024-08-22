package com.baidu.searchbox.dyesdk.impl;

import com.baidu.searchbox.dyesdk.ioc.IDyeContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/dyesdk/impl/DyeContextImpl;", "Lcom/baidu/searchbox/dyesdk/ioc/IDyeContext;", "()V", "getDyeIdsFromCache", "", "isDyeSDKEnable", "", "setDyeIdsToCache", "", "dyeIds", "lib-dye-box_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DyeContextImpl.kt */
public final class DyeContextImpl implements IDyeContext {
    public boolean isDyeSDKEnable() {
        return DyeSdkCommandListener.Companion.isDyeSdkEnable();
    }

    public void setDyeIdsToCache(String dyeIds) {
        Intrinsics.checkNotNullParameter(dyeIds, "dyeIds");
        DyePersistConfig.INSTANCE.putString("dye_ids", dyeIds);
    }

    public String getDyeIdsFromCache() {
        return String.valueOf(DyePersistConfig.INSTANCE.getString("dye_ids", ""));
    }
}
