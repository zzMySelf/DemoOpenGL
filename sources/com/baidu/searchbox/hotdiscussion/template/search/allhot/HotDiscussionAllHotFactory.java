package com.baidu.searchbox.hotdiscussion.template.search.allhot;

import android.content.Context;
import com.baidu.searchbox.dynamic.template.HotDiscussionTemplateType;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.generalcommunity.injector.TemplateDecoderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/hotdiscussion/template/search/allhot/HotDiscussionAllHotFactory;", "Lcom/baidu/searchbox/generalcommunity/injector/TemplateDecoderFactory;", "()V", "buildModel", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "baseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "buildTemplate", "Lcom/baidu/searchbox/feed/base/FeedTemplate;", "context", "Landroid/content/Context;", "getType", "", "lib-hotdiscussion-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotDiscussionAllHotFactory.kt */
public final class HotDiscussionAllHotFactory implements TemplateDecoderFactory {
    public String getType() {
        return HotDiscussionTemplateType.ALL_HOT;
    }

    public FeedItemData buildModel(FeedBaseModel baseModel) {
        return new HotDiscussionItemAllHotData();
    }

    public FeedTemplate buildTemplate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new HotDiscussionAllHotLayout(context);
    }
}
