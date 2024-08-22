package com.baidu.live.business.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0002\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/baidu/live/business/model/Result;", "T", "", "()V", "toString", "", "Error", "Success", "Lcom/baidu/live/business/model/Result$Success;", "Lcom/baidu/live/business/model/Result$Error;", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Result.kt */
public abstract class Result<T> {
    public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Result() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\n\b\u0001\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/live/business/model/Result$Success;", "T", "", "Lcom/baidu/live/business/model/Result;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/baidu/live/business/model/Result$Success;", "equals", "", "other", "hashCode", "", "toString", "", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Result.kt */
    public static final class Success<T> extends Result<T> {
        private final T data;

        public static /* synthetic */ Success copy$default(Success success, T t, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                t = success.data;
            }
            return success.copy(t);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T t) {
            Intrinsics.checkNotNullParameter(t, "data");
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.data, (Object) ((Success) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(T data2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(data2, "data");
            this.data = data2;
        }

        public final T getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\n\b\u0001\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B)\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\nJ\r\u0010\u0013\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0002\u0010\fJ:\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0001HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00018\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/baidu/live/business/model/Result$Error;", "T", "", "Lcom/baidu/live/business/model/Result;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorno", "", "data", "(Ljava/lang/Exception;Ljava/lang/Integer;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getErrorno", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getException", "()Ljava/lang/Exception;", "component1", "component2", "component3", "copy", "(Ljava/lang/Exception;Ljava/lang/Integer;Ljava/lang/Object;)Lcom/baidu/live/business/model/Result$Error;", "equals", "", "other", "hashCode", "toString", "", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Result.kt */
    public static final class Error<T> extends Result<T> {
        private final T data;
        private final Integer errorno;
        private final Exception exception;

        public static /* synthetic */ Error copy$default(Error error, Exception exc, Integer num, T t, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                exc = error.exception;
            }
            if ((i2 & 2) != 0) {
                num = error.errorno;
            }
            if ((i2 & 4) != 0) {
                t = error.data;
            }
            return error.copy(exc, num, t);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final Integer component2() {
            return this.errorno;
        }

        public final T component3() {
            return this.data;
        }

        public final Error<T> copy(Exception exc, Integer num, T t) {
            Intrinsics.checkNotNullParameter(exc, "exception");
            return new Error<>(exc, num, t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.exception, (Object) error.exception) && Intrinsics.areEqual((Object) this.errorno, (Object) error.errorno) && Intrinsics.areEqual((Object) this.data, (Object) error.data);
        }

        public int hashCode() {
            int hashCode = this.exception.hashCode() * 31;
            Integer num = this.errorno;
            int i2 = 0;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            T t = this.data;
            if (t != null) {
                i2 = t.hashCode();
            }
            return hashCode2 + i2;
        }

        public String toString() {
            return "Error(exception=" + this.exception + ", errorno=" + this.errorno + ", data=" + this.data + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(Exception exception2, Integer errorno2, T data2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(exception2, "exception");
            this.exception = exception2;
            this.errorno = errorno2;
            this.data = data2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(Exception exc, Integer num, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(exc, (i2 & 2) != 0 ? -1 : num, (i2 & 4) != 0 ? null : obj);
        }

        public final T getData() {
            return this.data;
        }

        public final Integer getErrorno() {
            return this.errorno;
        }

        public final Exception getException() {
            return this.exception;
        }
    }

    public String toString() {
        if (this instanceof Success) {
            return "Success[data=" + ((Success) this).getData() + AbstractJsonLexerKt.END_LIST;
        }
        if (this instanceof Error) {
            return "Error[exception=" + ((Error) this).getException() + AbstractJsonLexerKt.END_LIST;
        }
        throw new NoWhenBranchMatchedException();
    }
}
