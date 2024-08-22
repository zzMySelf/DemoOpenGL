package com.tera.scan.network.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/tera/scan/network/network/NetworkDetailException;", "Ljava/lang/Exception;", "type", "", "expMessage", "", "expCause", "statusCode", "(ILjava/lang/String;Ljava/lang/Exception;I)V", "getExpCause", "()Ljava/lang/Exception;", "getExpMessage", "()Ljava/lang/String;", "getStatusCode", "()I", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-network_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkDetailException extends Exception {
    @Nullable
    public final Exception expCause;
    @Nullable
    public final String expMessage;
    public final int statusCode;
    public final int type;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkDetailException(int i2, String str, Exception exc, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, exc, (i4 & 8) != 0 ? -1 : i3);
    }

    public static /* synthetic */ NetworkDetailException copy$default(NetworkDetailException networkDetailException, int i2, String str, Exception exc, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = networkDetailException.type;
        }
        if ((i4 & 2) != 0) {
            str = networkDetailException.expMessage;
        }
        if ((i4 & 4) != 0) {
            exc = networkDetailException.expCause;
        }
        if ((i4 & 8) != 0) {
            i3 = networkDetailException.statusCode;
        }
        return networkDetailException.copy(i2, str, exc, i3);
    }

    public final int component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.expMessage;
    }

    @Nullable
    public final Exception component3() {
        return this.expCause;
    }

    public final int component4() {
        return this.statusCode;
    }

    @NotNull
    public final NetworkDetailException copy(int i2, @Nullable String str, @Nullable Exception exc, int i3) {
        return new NetworkDetailException(i2, str, exc, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkDetailException)) {
            return false;
        }
        NetworkDetailException networkDetailException = (NetworkDetailException) obj;
        return this.type == networkDetailException.type && Intrinsics.areEqual((Object) this.expMessage, (Object) networkDetailException.expMessage) && Intrinsics.areEqual((Object) this.expCause, (Object) networkDetailException.expCause) && this.statusCode == networkDetailException.statusCode;
    }

    @Nullable
    public final Exception getExpCause() {
        return this.expCause;
    }

    @Nullable
    public final String getExpMessage() {
        return this.expMessage;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.type * 31;
        String str = this.expMessage;
        int i3 = 0;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        Exception exc = this.expCause;
        if (exc != null) {
            i3 = exc.hashCode();
        }
        return ((hashCode + i3) * 31) + this.statusCode;
    }

    @NotNull
    public String toString() {
        return "NetworkDetailException(type=" + this.type + ", expMessage=" + this.expMessage + ", expCause=" + this.expCause + ", statusCode=" + this.statusCode + ')';
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkDetailException(int i2, @Nullable String str, @Nullable Exception exc, int i3) {
        super(str == null ? "" : str, exc);
        this.type = i2;
        this.expMessage = str;
        this.expCause = exc;
        this.statusCode = i3;
    }
}
