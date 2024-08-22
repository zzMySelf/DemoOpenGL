package com.baidu.searchbox.feed.biserialdetail.debug;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.feed.biserialdetail.runtime.DynamicDetailRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/debug/DynamicDetailOperationProvider;", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "()V", "invokeDynamicListener", "Landroid/view/View$OnClickListener;", "getChildItemList", "", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "getDynamicOperationInfo", "getGroupName", "", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailOperationProvider.kt */
public final class DynamicDetailOperationProvider extends DebugDataGroupProvider {
    private final View.OnClickListener invokeDynamicListener = new DynamicDetailOperationProvider$$ExternalSyntheticLambda0();

    public List<DebugItemInfo> getChildItemList() {
        return getDynamicOperationInfo();
    }

    public String getGroupName() {
        return "双列流图文落地页";
    }

    public final List<DebugItemInfo> getDynamicOperationInfo() {
        ArrayList itemInfos = new ArrayList();
        itemInfos.add(new TextItemInfo("", "调起双列流图文落地页", this.invokeDynamicListener));
        return itemInfos;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeDynamicListener$lambda-0  reason: not valid java name */
    public static final void m18532invokeDynamicListener$lambda0(View it) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DynamicDetailRuntime.INSTANCE.getAppContext(), DebugDoubleListActivity.class));
        ActivityUtils.startActivitySafely(DynamicDetailRuntime.INSTANCE.getAppContext(), intent);
    }
}
