package com.mars.kotlin.service;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB9\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0002\u001a\u0004\u0018\u00018\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0001\u0005\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/mars/kotlin/service/Result;", "T", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "Landroid/os/Bundle;", "errorData", "Landroid/os/Bundle;", "getErrorData", "()Landroid/os/Bundle;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "", "errorNumber", "Ljava/lang/Integer;", "getErrorNumber", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Landroid/os/Bundle;)V", "NetworkError", "Operating", "ServerError", "Success", "UnknownError", "Lcom/mars/kotlin/service/Result$Success;", "Lcom/mars/kotlin/service/Result$Operating;", "Lcom/mars/kotlin/service/Result$ServerError;", "Lcom/mars/kotlin/service/Result$NetworkError;", "Lcom/mars/kotlin/service/Result$UnknownError;", "service_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public abstract class Result<T> {
    @Nullable
    public final T data;
    @Nullable
    public final Bundle errorData;
    @Nullable
    public final String errorMessage;
    @Nullable
    public final Integer errorNumber;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mars/kotlin/service/Result$NetworkError;", "T", "Lcom/mars/kotlin/service/Result;", "Landroid/os/Bundle;", "data", "<init>", "(Landroid/os/Bundle;)V", "service_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class NetworkError<T> extends Result<T> {
        public NetworkError() {
            this((Bundle) null, 1, (DefaultConstructorMarker) null);
        }

        public NetworkError(@Nullable Bundle bundle) {
            super((Object) null, (Integer) null, (String) null, bundle, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NetworkError(Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : bundle);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mars/kotlin/service/Result$Operating;", "T", "Lcom/mars/kotlin/service/Result;", "data", "<init>", "(Ljava/lang/Object;)V", "service_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class Operating<T> extends Result<T> {
        public Operating(@Nullable T t) {
            super(t, (Integer) null, (String) null, (Bundle) null, 14, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mars/kotlin/service/Result$ServerError;", "T", "Lcom/mars/kotlin/service/Result;", "", "number", "", "message", "Landroid/os/Bundle;", "data", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/os/Bundle;)V", "service_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class ServerError<T> extends Result<T> {
        public ServerError(@Nullable Integer num, @Nullable String str, @Nullable Bundle bundle) {
            super((Object) null, num, str, bundle, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ServerError(Integer num, String str, Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : bundle);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mars/kotlin/service/Result$Success;", "T", "Lcom/mars/kotlin/service/Result;", "data", "<init>", "(Ljava/lang/Object;)V", "service_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class Success<T> extends Result<T> {
        public Success(@Nullable T t) {
            super(t, (Integer) null, (String) null, (Bundle) null, 14, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mars/kotlin/service/Result$UnknownError;", "T", "Lcom/mars/kotlin/service/Result;", "Landroid/os/Bundle;", "data", "<init>", "(Landroid/os/Bundle;)V", "service_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class UnknownError<T> extends Result<T> {
        public UnknownError() {
            this((Bundle) null, 1, (DefaultConstructorMarker) null);
        }

        public UnknownError(@Nullable Bundle bundle) {
            super((Object) null, (Integer) null, (String) null, bundle, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UnknownError(Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : bundle);
        }
    }

    public Result(T t, Integer num, String str, Bundle bundle) {
        this.data = t;
        this.errorNumber = num;
        this.errorMessage = str;
        this.errorData = bundle;
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @Nullable
    public final Bundle getErrorData() {
        return this.errorData;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final Integer getErrorNumber() {
        return this.errorNumber;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Result(Object obj, Integer num, String str, Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : obj, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : bundle);
    }
}
