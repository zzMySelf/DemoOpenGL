package com.baidu.searchbox.feed.factory;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedPolyHScrollModel;
import com.baidu.searchbox.feed.template.poly.FeedPolyHScrollView;
import com.baidu.searchbox.safemode.impl.config.ConfigImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/feed/factory/FeedPolyHScrollItem;", "Lcom/baidu/searchbox/feed/base/SimpleFeedTemplate;", "name", "", "viewClass", "Ljava/lang/Class;", "Lcom/baidu/searchbox/feed/base/FeedTemplate;", "modelClass", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "policy", "Lcom/baidu/searchbox/feed/base/SimpleFeedTemplate$Policy;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lcom/baidu/searchbox/feed/base/SimpleFeedTemplate$Policy;)V", "newItemModel", "Lcom/baidu/searchbox/feed/model/FeedPolyHScrollModel;", "dataObj", "Lorg/json/JSONObject;", "newItemView", "Lcom/baidu/searchbox/feed/template/poly/FeedPolyHScrollView;", "ctx", "Landroid/content/Context;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedPolyHScrollItem.kt */
public final class FeedPolyHScrollItem extends SimpleFeedTemplate {
    public FeedPolyHScrollItem() {
        this((String) null, (Class) null, (Class) null, (SimpleFeedTemplate.Policy) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FeedPolyHScrollItem(java.lang.String r1, java.lang.Class r2, java.lang.Class r3, com.baidu.searchbox.feed.base.SimpleFeedTemplate.Policy r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L_0x0007
            java.lang.String r1 = "same_topic_content_card"
        L_0x0007:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x000d
            java.lang.Class<com.baidu.searchbox.feed.template.poly.FeedPolyHScrollView> r2 = com.baidu.searchbox.feed.template.poly.FeedPolyHScrollView.class
        L_0x000d:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0013
            java.lang.Class<com.baidu.searchbox.feed.model.FeedPolyHScrollModel> r3 = com.baidu.searchbox.feed.model.FeedPolyHScrollModel.class
        L_0x0013:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x001e
            com.baidu.searchbox.feed.base.SimpleFeedTemplate$Policy r4 = com.baidu.searchbox.feed.base.SimpleFeedTemplate.Policy.POLICY
            java.lang.String r5 = "POLICY"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L_0x001e:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.factory.FeedPolyHScrollItem.<init>(java.lang.String, java.lang.Class, java.lang.Class, com.baidu.searchbox.feed.base.SimpleFeedTemplate$Policy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedPolyHScrollItem(String name, Class<? extends FeedTemplate> viewClass, Class<? extends FeedItemData> modelClass, SimpleFeedTemplate.Policy policy) {
        super(name, viewClass, modelClass, policy);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(policy, ConfigImpl.JSONConstant.POLICY);
    }

    /* access modifiers changed from: protected */
    public FeedPolyHScrollView newItemView(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return new FeedPolyHScrollView(ctx, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public FeedPolyHScrollModel newItemModel(JSONObject dataObj) {
        Intrinsics.checkNotNullParameter(dataObj, "dataObj");
        return new FeedPolyHScrollModel();
    }
}
