package com.tera.scan.ubc.log.task;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/tera/scan/ubc/log/task/MonitorJsonException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorNumber", "", "message", "", "(ILjava/lang/String;)V", "getErrorNumber", "()I", "lib_ubc_analytics_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MonitorJsonException extends Exception {
    public final int errorNumber;

    public MonitorJsonException(int i2, @Nullable String str) {
        super(str);
        this.errorNumber = i2;
    }

    public final int getErrorNumber() {
        return this.errorNumber;
    }
}
