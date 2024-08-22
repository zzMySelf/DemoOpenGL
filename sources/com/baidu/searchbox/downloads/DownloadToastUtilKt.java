package com.baidu.searchbox.downloads;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.data.DialogData;
import com.baidu.searchbox.download.center.utils.DebugUtilsKt;
import com.baidu.searchbox.downloads.appsearch.helper.CommonDialogHelper;
import com.baidu.searchbox.downloads.appsearch.helper.ToastMessageInfo;
import com.baidu.searchbox.downloads.appsearch.helper.TransferNetDiskDownloadHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u001a\u0006\u0010\f\u001a\u00020\t\u001a\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0002\u001a\b\u0010\u0010\u001a\u00020\tH\u0007\u001a\b\u0010\u0011\u001a\u00020\tH\u0007\u001a\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0015"}, d2 = {"getDownloadFailedToastMessage", "Lcom/baidu/searchbox/downloads/appsearch/helper/ToastMessageInfo;", "fileName", "", "getDownloadSuccessToastMessage", "getDownloadedToastMessage", "dialogData", "Lcom/baidu/searchbox/data/DialogData;", "showDownloadFailedToast", "", "onClickCallback", "Lkotlin/Function0;", "showDownloadStartToast", "showDownloadSuccessToast", "showDownloadToast", "toastInfo", "showP2pDownloadErrorToast", "showP2pDownloadStartToast", "showToastByDownloadedStatus", "status", "", "lib-download-center_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadToastUtil.kt */
public final class DownloadToastUtilKt {
    public static final void showToastByDownloadedStatus(int status, DialogData dialogData) {
        Intrinsics.checkNotNullParameter(dialogData, "dialogData");
        DebugUtilsKt.printLog("downloadToast", new DownloadToastUtilKt$showToastByDownloadedStatus$1(status));
        switch (status) {
            case 190:
                showDownloadToast$default(new ToastMessageInfo("下载任务进行中", "查看"), (Function0) null, 2, (Object) null);
                return;
            case 192:
                showDownloadToast$default(new ToastMessageInfo("下载任务进行中", "查看"), (Function0) null, 2, (Object) null);
                return;
            case 193:
                showDownloadToast$default(new ToastMessageInfo("下载任务已暂停", "查看"), (Function0) null, 2, (Object) null);
                return;
            case 200:
                showDownloadToast$default(getDownloadedToastMessage(dialogData), (Function0) null, 2, (Object) null);
                return;
            default:
                showDownloadToast$default(new ToastMessageInfo("下载失败", "查看"), (Function0) null, 2, (Object) null);
                return;
        }
    }

    public static final void showDownloadStartToast() {
        DebugUtilsKt.printLog("downloadToast", DownloadToastUtilKt$showDownloadStartToast$1.INSTANCE);
        showDownloadToast$default(new ToastMessageInfo("已加入下载任务", "查看"), (Function0) null, 2, (Object) null);
    }

    public static final void showDownloadSuccessToast(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        DebugUtilsKt.printLog("downloadToast", DownloadToastUtilKt$showDownloadSuccessToast$1.INSTANCE);
        showDownloadToast$default(getDownloadSuccessToastMessage(fileName), (Function0) null, 2, (Object) null);
    }

    public static final void showDownloadFailedToast(String fileName, Function0<Unit> onClickCallback) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        DebugUtilsKt.printLog("downloadToast", DownloadToastUtilKt$showDownloadFailedToast$1.INSTANCE);
        showDownloadToast(getDownloadFailedToastMessage(fileName), onClickCallback);
    }

    @StableApi
    public static final void showP2pDownloadStartToast() {
        DebugUtilsKt.printLog("downloadToast", DownloadToastUtilKt$showP2pDownloadStartToast$1.INSTANCE);
        showDownloadToast$default(new ToastMessageInfo("已加入极速下载任务", "查看"), (Function0) null, 2, (Object) null);
    }

    @StableApi
    public static final void showP2pDownloadErrorToast() {
        DebugUtilsKt.printLog("downloadToast", DownloadToastUtilKt$showP2pDownloadErrorToast$1.INSTANCE);
        showDownloadToast$default(new ToastMessageInfo("加速失败，已切换普通下载", "查看"), (Function0) null, 2, (Object) null);
    }

    static /* synthetic */ void showDownloadToast$default(ToastMessageInfo toastMessageInfo, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        showDownloadToast(toastMessageInfo, function0);
    }

    private static final void showDownloadToast(ToastMessageInfo toastInfo, Function0<Unit> onClickCallback) {
        UiThreadUtils.runOnUiThread(new DownloadToastUtilKt$$ExternalSyntheticLambda0(toastInfo, onClickCallback));
    }

    /* access modifiers changed from: private */
    /* renamed from: showDownloadToast$lambda-1  reason: not valid java name */
    public static final void m17762showDownloadToast$lambda1(ToastMessageInfo $toastInfo, Function0 $onClickCallback) {
        Intrinsics.checkNotNullParameter($toastInfo, "$toastInfo");
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        if (activity != null) {
            UniversalToast.makeText((Context) activity, (CharSequence) $toastInfo.getMessage()).setRightText($toastInfo.getRightMessage()).setTemplate(ToastTemplate.T2).setDuration(3).setOverFloatWindow(true).setToastCallback(new DownloadToastUtilKt$$ExternalSyntheticLambda1(activity, $onClickCallback)).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showDownloadToast$lambda-1$lambda-0  reason: not valid java name */
    public static final void m17763showDownloadToast$lambda1$lambda0(Activity $activity, Function0 $onClickCallback) {
        Intrinsics.checkNotNullParameter($activity, "$activity");
        DownloadDialogHelper.startDownloadCenterActivity($activity, (DialogData) null);
        if ($onClickCallback != null) {
            $onClickCallback.invoke();
        }
    }

    private static final ToastMessageInfo getDownloadedToastMessage(DialogData dialogData) {
        String type = CommonDialogHelper.getTypeByUrlOrName(dialogData.downloadUrl, dialogData.fileName);
        if (ArraysKt.contains((T[]) TransferNetDiskDownloadHelperKt.getTYPE_NOVEL(), type) || ArraysKt.contains((T[]) TransferNetDiskDownloadHelperKt.getTYPE_DOC(), type)) {
            return new ToastMessageInfo("该文档已下载", "查看");
        }
        if (ArraysKt.contains((T[]) TransferNetDiskDownloadHelperKt.getTYPE_ZIP(), type)) {
            return new ToastMessageInfo("该压缩文件已下载", "查看");
        }
        if (ArraysKt.contains((T[]) TransferNetDiskDownloadHelperKt.getTYPE_MUSIC(), type)) {
            return new ToastMessageInfo("该音频已下载", "查看");
        }
        if (ArraysKt.contains((T[]) TransferNetDiskDownloadHelperKt.getTYPE_VIDEO(), type)) {
            return new ToastMessageInfo("该视频已下载", "查看");
        }
        return new ToastMessageInfo("该文件已下载", "查看");
    }

    private static final ToastMessageInfo getDownloadSuccessToastMessage(String fileName) {
        if (fileName.length() <= 4) {
            return new ToastMessageInfo(fileName + "下载完成", "查看");
        }
        String suffix = fileName.substring(0, 5);
        Intrinsics.checkNotNullExpressionValue(suffix, "this as java.lang.String…ing(startIndex, endIndex)");
        return new ToastMessageInfo(suffix + "...下载完成", "查看");
    }

    private static final ToastMessageInfo getDownloadFailedToastMessage(String fileName) {
        if (fileName.length() <= 4) {
            return new ToastMessageInfo(fileName + "下载失败", "查看");
        }
        String suffix = fileName.substring(0, 5);
        Intrinsics.checkNotNullExpressionValue(suffix, "this as java.lang.String…ing(startIndex, endIndex)");
        return new ToastMessageInfo(suffix + "...下载失败", "查看");
    }
}
