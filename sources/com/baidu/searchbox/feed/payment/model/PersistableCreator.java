package com.baidu.searchbox.feed.payment.model;

import com.baidu.searchbox.feed.payment.model.ObjectPersistable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/PersistableCreator;", "T", "Lcom/baidu/searchbox/feed/payment/model/ObjectPersistable;", "", "copyTo", "oldInstance", "newId", "", "(Lcom/baidu/searchbox/feed/payment/model/ObjectPersistable;Ljava/lang/String;)Lcom/baidu/searchbox/feed/payment/model/ObjectPersistable;", "create", "id", "(Ljava/lang/String;)Lcom/baidu/searchbox/feed/payment/model/ObjectPersistable;", "getType", "Ljava/lang/Class;", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ObjectIdQueryBuilder.kt */
public interface PersistableCreator<T extends ObjectPersistable> {
    T copyTo(T t, String str);

    T create(String str);

    Class<T> getType();
}
