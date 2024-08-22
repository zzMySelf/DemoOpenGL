package com.baidu.netdisk.backup.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/baidu/netdisk/backup/model/BackupState;", "", "state", "", "stateCode", "(II)V", "getState", "()I", "setState", "(I)V", "getStateCode", "setStateCode", "Companion", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupState.kt */
public final class BackupState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FAILED = 5;
    public static final int NO_STATUS = 0;
    public static final int PAUSE = 3;
    public static final int PENGDING = 1;
    public static final int RUNNING = 2;
    public static final int SUCCEED = 4;
    private int state;
    private int stateCode;

    public BackupState(int state2, int stateCode2) {
        this.state = state2;
        this.stateCode = stateCode2;
    }

    public final int getState() {
        return this.state;
    }

    public final void setState(int i2) {
        this.state = i2;
    }

    public final int getStateCode() {
        return this.stateCode;
    }

    public final void setStateCode(int i2) {
        this.stateCode = i2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/netdisk/backup/model/BackupState$Companion;", "", "()V", "FAILED", "", "NO_STATUS", "PAUSE", "PENGDING", "RUNNING", "SUCCEED", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BackupState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
