package com.baidu.searchbox.dynamicpublisher.aiimggentxt;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/aiimggentxt/RequestFailEvent;", "", "type", "", "errorCode", "errorMessage", "", "taskId", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMessage", "()Ljava/lang/String;", "getTaskId", "getType", "()I", "Companion", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RequestFailEvent.kt */
public final class RequestFailEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_CREATE = 0;
    public static final int TYPE_QUERY_GEN = 1;
    private final Integer errorCode;
    private final String errorMessage;
    private final String taskId;
    private final int type;

    public RequestFailEvent(int type2, Integer errorCode2, String errorMessage2, String taskId2) {
        this.type = type2;
        this.errorCode = errorCode2;
        this.errorMessage = errorMessage2;
        this.taskId = taskId2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestFailEvent(int i2, Integer num, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2);
    }

    public final int getType() {
        return this.type;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/aiimggentxt/RequestFailEvent$Companion;", "", "()V", "TYPE_CREATE", "", "TYPE_QUERY_GEN", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RequestFailEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
