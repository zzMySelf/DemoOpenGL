package com.baidu.searchbox.praise.debug;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.parise.R;
import com.baidu.searchbox.praise.runtime.PraiseRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/praise/debug/TripleDebugConfigProvider;", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "()V", "mTripleListener", "Landroid/view/View$OnClickListener;", "getChildItemList", "", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "getGroupName", "", "getTripleOperationInfo", "lib-praise-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TripleDebugConfigProvider.kt */
public final class TripleDebugConfigProvider extends DebugDataGroupProvider {
    private final View.OnClickListener mTripleListener = new TripleDebugConfigProvider$$ExternalSyntheticLambda0();

    /* access modifiers changed from: private */
    /* renamed from: mTripleListener$lambda-0  reason: not valid java name */
    public static final void m2479mTripleListener$lambda0(View it) {
        Activity activity = BdBoxActivityManager.getTopActivity();
        if (activity != null) {
            activity.startActivity(new Intent(activity, TripleDebugActivity.class));
        }
    }

    public List<DebugItemInfo> getChildItemList() {
        return getTripleOperationInfo();
    }

    public String getGroupName() {
        String string = PraiseRuntime.getAppContext().getResources().getString(R.string.praise_triple_debug_title);
        Intrinsics.checkNotNullExpressionValue(string, "getAppContext()\n        …raise_triple_debug_title)");
        return string;
    }

    private final List<DebugItemInfo> getTripleOperationInfo() {
        List itemInfos = new ArrayList();
        itemInfos.add(new TextItemInfo((String) null, PraiseRuntime.getAppContext().getResources().getString(R.string.praise_triple_debug_sub_title), this.mTripleListener));
        return itemInfos;
    }
}
