package com.baidu.searchbox.download.center.ui.fusion;

import android.net.Uri;
import com.baidu.netdisk.transfer.base.IUploadCallback;
import com.baidu.netdisk.transfer.io.model.UploadResponseModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FileManagerActivity$$ExternalSyntheticLambda25 implements IUploadCallback {
    public final /* synthetic */ FileManagerActivity f$0;
    public final /* synthetic */ Uri f$1;
    public final /* synthetic */ FileManagerActivity f$2;

    public /* synthetic */ FileManagerActivity$$ExternalSyntheticLambda25(FileManagerActivity fileManagerActivity, Uri uri, FileManagerActivity fileManagerActivity2) {
        this.f$0 = fileManagerActivity;
        this.f$1 = uri;
        this.f$2 = fileManagerActivity2;
    }

    public final void onResult(UploadResponseModel uploadResponseModel) {
        FileManagerActivity.m17517processShareFileToNetDisk$lambda19(this.f$0, this.f$1, this.f$2, uploadResponseModel);
    }
}
