package com.baidu.searchbox.feed.ui.biserialassembly;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/ui/biserialassembly/IBiSerialRequestCallback;", "", "onFail", "", "errorCode", "", "onSuccess", "list", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "Lkotlin/collections/ArrayList;", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IBiSerialRequestCallback.kt */
public interface IBiSerialRequestCallback {
    void onFail(int i2);

    void onSuccess(ArrayList<FeedBaseModel> arrayList);
}
