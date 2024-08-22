package com.baidu.netdisk.cloudfile.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.netdisk.base.service.BaseServiceHelper;
import com.baidu.netdisk.cloudfile.io.CloudFileApi;
import com.baidu.netdisk.cloudfile.storage.config.CloudFileConfigKey;
import com.baidu.netdisk.config.PersonalConfig;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.network.exception.RemoteException;
import com.baidu.netdisk.statistics.BaseReportJob;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import org.json.JSONException;

class CreateTaskJob extends BaseReportJob {
    private static final String TAG = "CreateTaskJob";
    private final String bduss;
    private final Context context;
    private final Intent intent;
    private final String mUid;
    private final ResultReceiver receiver;

    public CreateTaskJob(Context context2, Intent intent2, ResultReceiver receiver2, String bduss2, String uid) {
        super(TAG);
        this.context = context2;
        this.intent = intent2;
        this.receiver = receiver2;
        this.bduss = bduss2;
        this.mUid = uid;
    }

    /* access modifiers changed from: protected */
    public void performExecute() {
        int type = this.intent.getIntExtra(Extras.EXTRA_TASK_TYPE, 7);
        String task = Actions.ACTION_CREATE_TASK + type;
        try {
            NetDiskLog.d(TAG, "开始执行扩容任务服务");
            boolean isSuccess = createTask(type, this.mUid, this.bduss);
            NetDiskLog.d(TAG, "扩容任务服务结束");
            if (isSuccess) {
                PersonalConfig.getInstance().putInt(task, 1);
                if (7 == type) {
                    PersonalConfig.getInstance().putBoolean(CloudFileConfigKey.KEY_IS_SHOW_LOGIN_TASK_SUCCESS_DIALOG, true);
                }
                LocalBroadcastManager.getInstance(this.context).sendBroadcast(new Intent(this.context.getPackageName() + Actions.ACTION_CREATE_TASK));
                NetDiskLog.d(TAG, "容量成功");
            } else {
                PersonalConfig.getInstance().putInt(task, -1);
                NetDiskLog.d(TAG, "做失败标识，以便重试");
            }
            PersonalConfig.getInstance().commit();
            ResultReceiver resultReceiver = this.receiver;
            if (resultReceiver != null) {
                if (isSuccess) {
                    resultReceiver.send(1, Bundle.EMPTY);
                } else {
                    resultReceiver.send(2, Bundle.EMPTY);
                }
            }
        } catch (RemoteException e2) {
            NetDiskLog.d(TAG, "扩容任务服务结束");
            int errno = e2.getErrorCode();
            if (errno == -36 || errno == -29) {
                PersonalConfig.getInstance().putInt(task, 1);
                NetDiskLog.d(TAG, "容量已满,任务已经完成，做成功标识");
            } else {
                PersonalConfig.getInstance().putInt(task, -1);
                NetDiskLog.d(TAG, "做失败标识，以便重试");
            }
            PersonalConfig.getInstance().commit();
            BaseServiceHelper.handleRemoteException(e2, this.receiver);
        } catch (IOException e3) {
            PersonalConfig.getInstance().putInt(task, -1);
            PersonalConfig.getInstance().commit();
            NetDiskLog.d(TAG, "做失败标识，以便重试");
            BaseServiceHelper.handleIOException(e3, this.receiver);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean createTask(int type, String uid, String bduss2) throws RemoteException, IOException {
        try {
            new CloudFileApi(bduss2, uid).createTask(System.currentTimeMillis(), type, uid);
            return true;
        } catch (KeyManagementException e2) {
            NetDiskLog.e(TAG, "", e2);
            return false;
        } catch (UnrecoverableKeyException e3) {
            NetDiskLog.e(TAG, "", e3);
            return false;
        } catch (NoSuchAlgorithmException e4) {
            NetDiskLog.e(TAG, "", e4);
            return false;
        } catch (KeyStoreException e5) {
            NetDiskLog.e(TAG, "", e5);
            return false;
        } catch (JSONException e6) {
            NetDiskLog.e(TAG, "", e6);
            return false;
        }
    }
}
