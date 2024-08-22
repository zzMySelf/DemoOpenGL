package com.baidu.netdisk.statistics.activation;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.base.service.BaseServiceHelper;
import com.baidu.netdisk.base.service.constant.BaseExtras;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;

public class ActivationServiceHelper extends BaseServiceHelper {
    private static final String TAG = "ActiveServiceHelper";

    public static Intent buildIntent(Context context, String bduss, String uid, ResultReceiver resultReceiver) {
        return BaseServiceHelper.buildIntent(context, bduss, uid, resultReceiver).putExtra(BaseExtras.EXTRA_SERVICE_TYPE, 19);
    }

    static void sendActive(Context context, ResultReceiver resultReceiver, String action, String backupSource) {
        NetDiskLog.d(TAG, "【Upload-SDK】调起发送日活任务");
        if (AccountUtils.getInstance().isLogin() && isNetWorkAvailable(context, resultReceiver)) {
            String bduss = AccountUtils.getInstance().getBduss();
            if (!TextUtils.isEmpty(bduss)) {
                String uid = AccountUtils.getInstance().getUid();
                if (!TextUtils.isEmpty(uid)) {
                    NetDiskLog.d(TAG, "sendActive::startACTION_SEND_ACTIVE");
                    try {
                        BaseServiceHelper.startTargetVersionService(28, context, buildIntent(context, bduss, uid, resultReceiver).setAction(ActivationService.ACTION_SEND_ACTIVE).putExtra(ActivationService.EXTRA_ACTIVE_ACTION_TYPE, action).putExtra(ActivationService.EXTRA_REPORT_BACKUP_SOURCE, backupSource));
                    } catch (Exception ignore) {
                        NetDiskLog.w(TAG, "【Upload-SDK】调起发送日活任务", ignore);
                    }
                }
            }
        }
    }
}
