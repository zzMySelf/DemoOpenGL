package com.baidu.swan.apps.extension.netdisk.ipc;

import android.os.Bundle;
import com.baidu.netdisk.transfer.base.IUploadCallback;
import com.baidu.netdisk.transfer.io.model.UploadControlModel;
import com.baidu.netdisk.transfer.io.model.UploadResponseModel;
import com.baidu.netdisk.transfer.io.model.UploadTaskModel;
import com.baidu.searchbox.diskupload.BdDiskUpload;
import com.baidu.swan.apps.extension.netdisk.NetDiskUtils;
import com.baidu.swan.apps.process.delegate.delegation.SwanAppMessengerDelegation;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.util.ArrayList;
import java.util.HashMap;

public class OnNetDiskTaskProgressUpdateDelegation extends SwanAppMessengerDelegation {
    public void execCall(Bundle params) {
        onNetDiskTaskProgressUpdate(new TypedCallback<UploadResponseModel>() {
            public void onCallback(UploadResponseModel model) {
                if (model != null) {
                    OnNetDiskTaskProgressUpdateDelegation.this.result.putBoolean("result", model.isSuccess());
                    UploadControlModel controlModel = model.getControlModel();
                    if (controlModel != null) {
                        OnNetDiskTaskProgressUpdateDelegation.this.result.putInt("errorCode", controlModel.getErrorCode());
                        OnNetDiskTaskProgressUpdateDelegation.this.result.putString("errorMsg", controlModel.getErrorMsg());
                    }
                    HashMap<Integer, ArrayList<UploadTaskModel>> taskModels = model.getTaskModels();
                    if (taskModels != null) {
                        OnNetDiskTaskProgressUpdateDelegation.this.result.putString("data", NetDiskUtils.parseTaskModel(taskModels).toString());
                    }
                    OnNetDiskTaskProgressUpdateDelegation.this.finish();
                }
            }
        });
    }

    private void onNetDiskTaskProgressUpdate(final TypedCallback<UploadResponseModel> callback) {
        BdDiskUpload.get().getTasksByState(NetDiskUtils.getTypeCode("running"), new IUploadCallback() {
            public void onResult(UploadResponseModel uploadResponseModel) {
                callback.onCallback(uploadResponseModel);
            }
        });
    }
}
