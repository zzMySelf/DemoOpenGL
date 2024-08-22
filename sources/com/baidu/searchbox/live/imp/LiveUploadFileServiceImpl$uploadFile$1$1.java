package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.live.interfaces.upload.UploadFileBean;
import com.baidu.searchbox.live.interfaces.upload.UploadFileCallBack;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.services.bos.model.PutObjectRequest;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/live/imp/LiveUploadFileServiceImpl$uploadFile$1$1", "Lcom/baidubce/services/bos/callback/BosProgressCallback;", "Lcom/baidubce/services/bos/model/PutObjectRequest;", "onProgress", "", "request", "currentSize", "", "totalSize", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveUploadFileServiceImpl.kt */
public final class LiveUploadFileServiceImpl$uploadFile$1$1 extends BosProgressCallback<PutObjectRequest> {
    final /* synthetic */ UploadFileCallBack $callBack;
    final /* synthetic */ UploadFileBean $uploadFileBean;

    LiveUploadFileServiceImpl$uploadFile$1$1(UploadFileCallBack $callBack2, UploadFileBean $uploadFileBean2) {
        this.$callBack = $callBack2;
        this.$uploadFileBean = $uploadFileBean2;
    }

    public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
        super.onProgress(request, currentSize, totalSize);
        int process = (int) ((((float) currentSize) / ((float) totalSize)) * ((float) 100));
        UploadFileCallBack uploadFileCallBack = this.$callBack;
        if (uploadFileCallBack != null) {
            uploadFileCallBack.process(process);
        }
        if (process == 100) {
            String remotePath = this.$uploadFileBean.endpoint + File.separator + this.$uploadFileBean.bucketName + File.separator + this.$uploadFileBean.objectName;
            UploadFileCallBack uploadFileCallBack2 = this.$callBack;
            if (uploadFileCallBack2 != null) {
                uploadFileCallBack2.complete(this.$uploadFileBean.filePath, remotePath);
            }
        }
    }
}
