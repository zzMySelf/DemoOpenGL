package com.baidu.searchbox.download.center.clearcache.view.funison.fileScan;

import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/CacheDataSerialer;", "Data", "", "deserialization", "file", "Ljava/io/File;", "(Ljava/io/File;)Ljava/lang/Object;", "serialization", "", "data", "(Ljava/lang/Object;Ljava/io/File;)V", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CacheData.kt */
public interface CacheDataSerialer<Data> {
    Data deserialization(File file);

    void serialization(Data data, File file);
}
