package com.baidu.searchbox.feed.biserialdetail.net;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H&J\b\u0010\b\u001a\u00020\u0004H&J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/net/NetCallback;", "T", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponse", "onSuccess", "model", "(Ljava/lang/Object;)V", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailRequestManager.kt */
public interface NetCallback<T> {
    void onFail(Exception exc);

    void onResponse();

    void onSuccess(T t);
}
