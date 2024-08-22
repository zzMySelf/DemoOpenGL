package com.baidu.netdisk.backup.task;

import com.baidu.netdisk.transfer.transmitter.constant.ErrorCode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/netdisk/backup/task/DefaultPrivilegeChecker;", "Lcom/baidu/netdisk/backup/task/IPrivilegeChecker;", "()V", "check", "", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrivilegeChecker.kt */
public final class DefaultPrivilegeChecker implements IPrivilegeChecker {
    public static final DefaultPrivilegeChecker INSTANCE = new DefaultPrivilegeChecker();

    private DefaultPrivilegeChecker() {
    }

    public int check() {
        return ErrorCode.ERROR_DEFAULT.mErrno;
    }
}
