package com.mars.kotlin.database.shard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/mars/kotlin/database/shard/HashCode;", "", "id", "shard", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class HashCode {
    @NotNull
    public final String shard(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return String.valueOf(str.hashCode());
    }
}
