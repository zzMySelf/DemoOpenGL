package com.baidu.netdisk.account.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.base.service.constant.BaseExtras;
import com.baidu.netdisk.component.base.service.BaseSchedulerService;
import com.baidu.netdisk.executor.job.PriorityScheduler;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;

public class AccountService extends BaseSchedulerService {
    private static final String TAG = "AccountService";

    public AccountService(PriorityScheduler scheduler) {
        super(scheduler);
    }

    public void onHandleIntent(Intent intent, Context context) {
        String uid;
        String bduss = intent.getStringExtra(BaseExtras.BDUSS);
        String action = intent.getAction();
        ResultReceiver receiver = (ResultReceiver) intent.getParcelableExtra(BaseExtras.RESULT_RECEIVER);
        boolean isAccountInvalid = bduss != null && !bduss.equals(AccountUtils.getInstance().getBduss());
        if (Actions.ACTION_GET_ACCOUNT_THIRD_INFO.equals(action)) {
            if (TextUtils.isEmpty(bduss)) {
                if (receiver != null) {
                    receiver.send(2, Bundle.EMPTY);
                    return;
                }
                return;
            }
        } else if (isAccountInvalid || (!AccountUtils.getInstance().isLogin() && !supportEmptyBdussAction(action))) {
            NetDiskLog.d(TAG, action + " cancel");
            return;
        }
        String uid2 = intent.getStringExtra(BaseExtras.UID);
        if (!AccountUtils.getInstance().isAnonymous() || Actions.ACTION_GET_ACCOUNT_THIRD_INFO.equals(action)) {
            uid = uid2;
        } else {
            bduss = null;
            uid = null;
        }
        NetDiskLog.d(TAG, "trace onHandleIntent:" + action);
        handleAction(intent, bduss, uid, action, receiver, context);
    }

    /* access modifiers changed from: protected */
    public boolean supportEmptyBdussAction(String action) {
        return Actions.ACTION_GET_ACCOUNT_THIRD_INFO.equals(action);
    }

    /* access modifiers changed from: protected */
    public void handleAction(Intent intent, String bduss, String uid, String action, ResultReceiver receiver, Context context) {
        if (Actions.IS_VIP.equals(action)) {
            this.mPriorityScheduler.addJobWithHigh(new IsVipJob(context, bduss, uid, receiver));
        } else if (Actions.IS_SIGN.equals(action)) {
            this.mPriorityScheduler.addJobWithHigh(new SignInfoJob(context, bduss, uid, receiver));
        } else if (Actions.ACTION_GET_ACCOUNT_THIRD_INFO.equals(action)) {
            this.mPriorityScheduler.addJobWithLow(new GetAccountThirdInfoJob(context, receiver, bduss, uid));
        }
    }
}
