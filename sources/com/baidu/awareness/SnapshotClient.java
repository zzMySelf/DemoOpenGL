package com.baidu.awareness;

import android.content.Context;
import com.baidu.awareness.impl.GeneralResultWrapper;
import com.baidu.awareness.snapshot.ActivityStateResult;
import com.baidu.awareness.snapshot.BatteryStateResult;
import com.baidu.awareness.snapshot.HeadphoneStateResult;
import com.baidu.awareness.snapshot.PendingResult;
import com.baidu.awareness.snapshot.SnapshotResultCallback;
import com.baidu.awareness.snapshot.StorageStateResult;
import com.baidu.awareness.snapshot.VolumeStateResult;

public class SnapshotClient {
    /* access modifiers changed from: private */
    public Context mContext;

    public SnapshotClient(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    public PendingResult<BatteryStateResult> getBatteryStateResult() {
        return new PendingResult<BatteryStateResult>() {
            public BatteryStateResult get() {
                return GeneralResultWrapper.wrapBatteryState(SnapshotClient.this.mContext);
            }

            public void setResultCallback(SnapshotResultCallback<BatteryStateResult> resultCallback) {
                GeneralResultWrapper.wrapBatteryState(SnapshotClient.this.mContext, resultCallback);
            }
        };
    }

    public PendingResult<HeadphoneStateResult> getHeadphoneStateResult() {
        return new PendingResult<HeadphoneStateResult>() {
            public HeadphoneStateResult get() {
                return GeneralResultWrapper.wrapHeadphoneState(SnapshotClient.this.mContext);
            }

            public void setResultCallback(SnapshotResultCallback<HeadphoneStateResult> resultCallback) {
                GeneralResultWrapper.wrapHeadphoneState(SnapshotClient.this.mContext, resultCallback);
            }
        };
    }

    public PendingResult<VolumeStateResult> getVolumeStateResult() {
        return new PendingResult<VolumeStateResult>() {
            public VolumeStateResult get() {
                return GeneralResultWrapper.wrapVolumeState(SnapshotClient.this.mContext);
            }

            public void setResultCallback(SnapshotResultCallback<VolumeStateResult> resultCallback) {
                GeneralResultWrapper.wrapVolumeState(SnapshotClient.this.mContext, resultCallback);
            }
        };
    }

    public PendingResult<StorageStateResult> getStorageStateResult() {
        return new PendingResult<StorageStateResult>() {
            public StorageStateResult get() {
                return GeneralResultWrapper.wrapStorageState(SnapshotClient.this.mContext);
            }

            public void setResultCallback(SnapshotResultCallback<StorageStateResult> resultCallback) {
                GeneralResultWrapper.wrapStorageState(SnapshotClient.this.mContext, resultCallback);
            }
        };
    }

    public PendingResult<ActivityStateResult> getActivityStateResult() {
        return new PendingResult<ActivityStateResult>() {
            public ActivityStateResult get() {
                return GeneralResultWrapper.wrapActivityState(SnapshotClient.this.mContext);
            }

            public void setResultCallback(SnapshotResultCallback<ActivityStateResult> resultCallback) {
                GeneralResultWrapper.wrapActivityState(SnapshotClient.this.mContext, resultCallback);
            }
        };
    }
}
