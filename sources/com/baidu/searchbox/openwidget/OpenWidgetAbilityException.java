package com.baidu.searchbox.openwidget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/openwidget/OpenWidgetAbilityException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "message", "", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()I", "Companion", "lib-openwidget-ability-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetAbilityException.kt */
public final class OpenWidgetAbilityException extends Exception {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ERR_INSTALL = 1003;
    private static final int ERR_INSTANTIATE = 1002;
    private static final int ERR_LOAD_CLAZZ = 1001;
    private final int errorCode;

    public final int getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OpenWidgetAbilityException(int errorCode2, String message, Throwable cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        this.errorCode = errorCode2;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/openwidget/OpenWidgetAbilityException$Companion;", "", "()V", "ERR_INSTALL", "", "ERR_INSTANTIATE", "ERR_LOAD_CLAZZ", "installFail", "Lcom/baidu/searchbox/openwidget/OpenWidgetAbilityException;", "status", "message", "", "instantiateFail", "throwable", "", "loadClazzFail", "lib-openwidget-ability-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetAbilityException.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OpenWidgetAbilityException loadClazzFail(int status, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new OpenWidgetAbilityException(1001, "status=" + status + ", msg=" + message, (Throwable) null);
        }

        public final OpenWidgetAbilityException instantiateFail(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            String message = throwable.getMessage();
            if (message == null) {
                message = "";
            }
            return new OpenWidgetAbilityException(1002, message, throwable);
        }

        public final OpenWidgetAbilityException installFail(int status, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new OpenWidgetAbilityException(1003, "status=" + status + ", msg=" + message, (Throwable) null);
        }
    }
}
