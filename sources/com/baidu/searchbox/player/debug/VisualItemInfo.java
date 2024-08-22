package com.baidu.searchbox.player.debug;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.searchbox.bdvideoplayer.debug.tools.playerVisual.PlayerVisualManager;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/debug/VisualItemInfo;", "", "itemName", "", "key", "(Ljava/lang/String;Ljava/lang/String;)V", "getItemInfo", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "lib-player-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VisualItemInfo.kt */
public final class VisualItemInfo {
    private final String itemName;
    private final String key;

    public VisualItemInfo(String itemName2, String key2) {
        Intrinsics.checkNotNullParameter(itemName2, "itemName");
        this.itemName = itemName2;
        this.key = key2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VisualItemInfo(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2);
    }

    public final DebugItemInfo getItemInfo() {
        String str = this.itemName;
        return new TextItemInfo(str, str, new VisualItemInfo$$ExternalSyntheticLambda0());
    }

    /* access modifiers changed from: private */
    /* renamed from: getItemInfo$lambda-1  reason: not valid java name */
    public static final void m2310getItemInfo$lambda1(View view2) {
        Context context = view2.getContext();
        Activity $this$getItemInfo_u24lambda_u2d1_u24lambda_u2d0 = context instanceof Activity ? (Activity) context : null;
        if ($this$getItemInfo_u24lambda_u2d1_u24lambda_u2d0 != null) {
            PlayerVisualManager.INSTANCE.start($this$getItemInfo_u24lambda_u2d1_u24lambda_u2d0);
        }
    }
}
