package com.baidu.searchbox.feed.factory;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataHotMultiTab;
import com.baidu.searchbox.feed.template.FeedHotMultiTabView;
import com.baidu.searchbox.safemode.impl.config.ConfigImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/feed/factory/FeedTplHotMultiTab;", "Lcom/baidu/searchbox/feed/base/SimpleFeedTemplate;", "name", "", "viewClass", "Ljava/lang/Class;", "Lcom/baidu/searchbox/feed/base/FeedTemplate;", "modelClass", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "policy", "Lcom/baidu/searchbox/feed/base/SimpleFeedTemplate$Policy;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lcom/baidu/searchbox/feed/base/SimpleFeedTemplate$Policy;)V", "newItemModel", "dataObj", "Lorg/json/JSONObject;", "newItemView", "ctx", "Landroid/content/Context;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTplHotMultiTab.kt */
public final class FeedTplHotMultiTab extends SimpleFeedTemplate {
    public FeedTplHotMultiTab() {
        this((String) null, (Class) null, (Class) null, (SimpleFeedTemplate.Policy) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FeedTplHotMultiTab(java.lang.String r1, java.lang.Class r2, java.lang.Class r3, com.baidu.searchbox.feed.base.SimpleFeedTemplate.Policy r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L_0x000b
            java.lang.String r1 = com.baidu.searchbox.feed.template.constant.FeedTplNameCenter.HOT_MULTI_TAB
            java.lang.String r6 = "HOT_MULTI_TAB"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
        L_0x000b:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x0011
            java.lang.Class<com.baidu.searchbox.feed.template.FeedHotMultiTabView> r2 = com.baidu.searchbox.feed.template.FeedHotMultiTabView.class
        L_0x0011:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0017
            java.lang.Class<com.baidu.searchbox.feed.model.FeedItemDataHotMultiTab> r3 = com.baidu.searchbox.feed.model.FeedItemDataHotMultiTab.class
        L_0x0017:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0022
            com.baidu.searchbox.feed.base.SimpleFeedTemplate$Policy r4 = com.baidu.searchbox.feed.base.SimpleFeedTemplate.Policy.POLICY
            java.lang.String r5 = "POLICY"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L_0x0022:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.factory.FeedTplHotMultiTab.<init>(java.lang.String, java.lang.Class, java.lang.Class, com.baidu.searchbox.feed.base.SimpleFeedTemplate$Policy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedTplHotMultiTab(String name, Class<? extends FeedTemplate> viewClass, Class<? extends FeedItemData> modelClass, SimpleFeedTemplate.Policy policy) {
        super(name, viewClass, modelClass, policy);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(policy, ConfigImpl.JSONConstant.POLICY);
    }

    /* access modifiers changed from: protected */
    public FeedTemplate newItemView(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return new FeedHotMultiTabView(ctx);
    }

    /* access modifiers changed from: protected */
    public FeedItemData newItemModel(JSONObject dataObj) {
        Intrinsics.checkNotNullParameter(dataObj, "dataObj");
        return new FeedItemDataHotMultiTab();
    }
}
