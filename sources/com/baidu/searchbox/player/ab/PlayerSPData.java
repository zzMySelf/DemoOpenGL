package com.baidu.searchbox.player.ab;

import com.baidu.searchbox.player.data.KVData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/player/ab/PlayerSPData;", "V", "Lcom/baidu/searchbox/player/data/KVData;", "key", "", "defaultValue", "spFileName", "useCache", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Z)V", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerSPManager.kt */
public class PlayerSPData<V> extends KVData<V> {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayerSPData(String str, Object obj, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i2 & 4) != 0 ? "com.baidu.searchbox_videoplayer" : str2, (i2 & 8) != 0 ? false : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSPData(String key, V defaultValue, String spFileName, boolean useCache) {
        super(key, defaultValue, KVStorageDataProviderKt.createKVProvider(useCache, spFileName));
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(spFileName, "spFileName");
    }
}
