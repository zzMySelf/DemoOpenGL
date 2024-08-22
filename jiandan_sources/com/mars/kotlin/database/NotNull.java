package com.mars.kotlin.database;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/mars/kotlin/database/NotNull;", "Lcom/mars/kotlin/database/Constraint;", "", "toString", "()Ljava/lang/String;", "conflict", "Ljava/lang/String;", "getConflict$annotations", "()V", "<init>", "(Ljava/lang/String;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class NotNull extends Constraint {
    public final String conflict;

    public NotNull() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public NotNull(@Nullable String str) {
        super((DefaultConstructorMarker) null);
        this.conflict = str;
    }

    public static /* synthetic */ void getConflict$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("NOT NULL");
        if (this.conflict != null) {
            str = " ON CONFLICT " + this.conflict;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotNull(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str);
    }
}
