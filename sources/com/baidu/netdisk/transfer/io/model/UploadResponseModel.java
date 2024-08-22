package com.baidu.netdisk.transfer.io.model;

import android.net.Uri;
import com.baidu.netdisk.transfer.transmitter.constant.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;

public class UploadResponseModel {
    boolean isSuccess = false;
    UploadControlModel mControlModel;
    Object mData;
    HashMap<Uri, Boolean> mFileModels;
    HashMap<Integer, ArrayList<UploadTaskModel>> mTaskModels;

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean success) {
        this.isSuccess = success;
    }

    public UploadControlModel getControlModel() {
        return this.mControlModel;
    }

    public void setControlModel(UploadControlModel controlModel) {
        this.mControlModel = controlModel;
    }

    public HashMap<Integer, ArrayList<UploadTaskModel>> getTaskModels() {
        return this.mTaskModels;
    }

    public void setTaskModels(HashMap<Integer, ArrayList<UploadTaskModel>> taskModels) {
        this.mTaskModels = taskModels;
    }

    public HashMap<Uri, Boolean> getFileModels() {
        return this.mFileModels;
    }

    public void setFileModels(HashMap<Uri, Boolean> fileModels) {
        this.mFileModels = fileModels;
    }

    public void setData(Object data) {
        this.mData = data;
    }

    public <T> T getData() {
        return this.mData;
    }

    public static UploadResponseModel buildUploadResponseModel(ErrorCode errno, Object data) {
        UploadResponseModel responseModel = new UploadResponseModel();
        responseModel.setSuccess(errno.mErrno == ErrorCode.ERROR_DEFAULT.mErrno);
        UploadControlModel controlModel = new UploadControlModel();
        controlModel.setErrorCode(errno.mErrno);
        controlModel.setErrorMsg(errno.mErrmsg);
        responseModel.setControlModel(controlModel);
        responseModel.setData(data);
        return responseModel;
    }

    public static UploadResponseModel buildUploadResponseModel(ErrorCode errno) {
        return buildUploadResponseModel(errno, (Object) null);
    }
}
