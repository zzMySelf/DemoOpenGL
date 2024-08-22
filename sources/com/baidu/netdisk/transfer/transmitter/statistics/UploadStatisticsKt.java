package com.baidu.netdisk.transfer.transmitter.statistics;

import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.base.utils.FileCategory;
import com.baidu.netdisk.base.utils.FileType;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.ubc.UBCStatistics;
import com.baidu.searchbox.sniffer.ubc.SnifferContants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"TAG", "", "statisticsUploadStateForUBC", "", "errno", "", "fileSize", "", "fileName", "isSuperFileUpload", "", "(ILjava/lang/Long;Ljava/lang/String;Z)V", "statisticsUploadTransferSizeToUBC", "extJson", "Lorg/json/JSONObject;", "component_transmitter_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UploadStatistics.kt */
public final class UploadStatisticsKt {
    private static final String TAG = "UploadStatistics";

    public static /* synthetic */ void statisticsUploadStateForUBC$default(int i2, Long l, String str, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = false;
        }
        statisticsUploadStateForUBC(i2, l, str, z);
    }

    public static final void statisticsUploadStateForUBC(int errno, Long fileSize, String fileName, boolean isSuperFileUpload) {
        Object obj;
        if (fileSize != null && fileSize.longValue() >= 0 && fileName != null) {
            try {
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                JSONObject $this$statisticsUploadStateForUBC_u24lambda_u2d1_u24lambda_u2d0 = jSONObject;
                $this$statisticsUploadStateForUBC_u24lambda_u2d1_u24lambda_u2d0.put("file_size", fileSize.longValue());
                $this$statisticsUploadStateForUBC_u24lambda_u2d1_u24lambda_u2d0.put("file_name", fileName);
                $this$statisticsUploadStateForUBC_u24lambda_u2d1_u24lambda_u2d0.put(SnifferContants.KEY_FILE_TYPE, FileCategory.getFileCategory(FileType.getType(fileName, false)));
                $this$statisticsUploadStateForUBC_u24lambda_u2d1_u24lambda_u2d0.put("error", errno);
                $this$statisticsUploadStateForUBC_u24lambda_u2d1_u24lambda_u2d0.put("vip", AccountUtils.getInstance().getLevel());
                $this$statisticsUploadStateForUBC_u24lambda_u2d1_u24lambda_u2d0.put("isSuperFileUpload", isSuperFileUpload);
                obj = Result.m8971constructorimpl(jSONObject);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable it = Result.m8974exceptionOrNullimpl(obj);
            if (it != null) {
                NetDiskLog.e(TAG, "uploadObject exception message is: " + it.getMessage());
            }
            if (Result.m8977isFailureimpl(obj)) {
                obj = null;
            }
            JSONObject uploadObject = (JSONObject) obj;
            if (uploadObject != null) {
                UBCStatistics.onEventStatistics(UBCStatistics.UBCStatisticsKeys.UPLOAD_SDK_UPLOAD_FILE_RESULT, UBCStatistics.UBC_KEY_FROM_UPLOAD, "clk", "", "", "", uploadObject);
            }
        }
    }

    public static final void statisticsUploadTransferSizeToUBC(JSONObject extJson) {
        Intrinsics.checkNotNullParameter(extJson, "extJson");
        UBCStatistics.onEventStatistics(UBCStatistics.UBCStatisticsKeys.UPLOAD_SDK_UPLOAD_FILE_RESULT, UBCStatistics.UBC_KEY_FROM_UPLOAD, "clk", "file_trans", "", "", extJson);
    }
}
