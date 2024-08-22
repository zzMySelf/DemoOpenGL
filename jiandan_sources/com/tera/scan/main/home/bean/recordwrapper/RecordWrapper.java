package com.tera.scan.main.home.bean.recordwrapper;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/main/home/bean/recordwrapper/RecordWrapper;", "T", "", "data", "getData", "()Ljava/lang/Object;", "getFileCount", "", "()Ljava/lang/Integer;", "getFileName", "", "getIcon", "getSize", "", "()Ljava/lang/Long;", "getTime", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RecordWrapper<T> {

    public static final class qw {
        @Nullable
        public static <T> Integer qw(@NotNull RecordWrapper<T> recordWrapper) {
            return null;
        }
    }

    @Nullable
    Long ad();

    T getData();

    @Nullable
    Integer getFileCount();

    @Nullable
    String getFileName();

    @Nullable
    String getIcon();

    @Nullable
    Long qw();
}
