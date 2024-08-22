package com.baidu.searchbox.search.webvideo.utils;

import android.text.TextUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.search.webvideo.model.AddNetDiskModel;
import com.baidu.searchbox.search.webvideo.model.SearchVideoH5DownloadModel;
import com.baidu.searchbox.search.webvideo.ui.SearchH5SnifferNetDiskButton;
import com.baidu.searchbox.search.webvideo.ui.SnifferNetDiskButtonStateEnum;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "success", "", "data", "Lcom/baidu/searchbox/search/webvideo/model/AddNetDiskModel;", "errCode", "", "errMsg", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5SaveNetUtils.kt */
final class SearchH5SaveNetUtilsKt$addNetDisk$1 extends Lambda implements Function4<Boolean, AddNetDiskModel, String, String, Unit> {
    final /* synthetic */ WeakReference<SearchH5SnifferNetDiskButton> $btnRef;
    final /* synthetic */ boolean $isFromRequestGetVip;
    final /* synthetic */ String $url;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchH5SaveNetUtilsKt$addNetDisk$1(WeakReference<SearchH5SnifferNetDiskButton> weakReference, String str, boolean z) {
        super(4);
        this.$btnRef = weakReference;
        this.$url = str;
        this.$isFromRequestGetVip = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        invoke(((Boolean) p1).booleanValue(), (AddNetDiskModel) p2, (String) p3, (String) p4);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean success, AddNetDiskModel data, String errCode, String errMsg) {
        AddNetDiskModel addNetDiskModel = data;
        String str = errCode;
        String str2 = errMsg;
        SearchH5SnifferNetDiskButton btn = (SearchH5SnifferNetDiskButton) this.$btnRef.get();
        boolean z = true;
        if (!success) {
            if (btn == null || !btn.isShown()) {
                z = false;
            }
            if (z) {
                UiThreadUtils.runOnUiThread(new SearchH5SaveNetUtilsKt$addNetDisk$1$$ExternalSyntheticLambda0(btn));
            }
            UiThreadUtils.runOnUiThread(new SearchH5SaveNetUtilsKt$addNetDisk$1$$ExternalSyntheticLambda1(str, str2, btn));
            return;
        }
        SearchH5NetDiskVipUtilsKt.minusFreeNum();
        String it = this.$url;
        Long l = null;
        if (it != null) {
            Set<String> hasAddNetDisk = FloatingBallViewUtilsKt.getHasAddNetDisk();
            (hasAddNetDisk != null ? Boolean.valueOf(hasAddNetDisk.add(it)) : null).booleanValue();
        }
        if (!TextUtils.isEmpty(str)) {
            UiThreadUtils.runOnUiThread(new SearchH5SaveNetUtilsKt$addNetDisk$1$$ExternalSyntheticLambda2(str, str2, btn));
        }
        SearchH5SaveNetUtilsKt.notifyDownloadCenterSaveBegin();
        if (addNetDiskModel != null && true == addNetDiskModel.rapidDownload) {
            String it2 = this.$url;
            if (it2 != null) {
                SearchH5DetectUtlsKt.getADD_TASK_MAP().put(it2, addNetDiskModel);
            }
            if (btn == null || !btn.isShown()) {
                z = false;
            }
            if (z) {
                btn.setSavePath(addNetDiskModel.savePath);
                btn.setFsid(addNetDiskModel.fsid);
                UiThreadUtils.runOnUiThread(new SearchH5SaveNetUtilsKt$addNetDisk$1$$ExternalSyntheticLambda3(btn));
                SearchH5VideoUbcUtils.lcbVideoStepCommonUbc(SearchH5VideoUbcUtils.STEP_LCB_WANGPAN_SOON_NEW_TASK_DONE);
                return;
            }
            SearchH5SaveNetUtilsKt.showToastRandomDelay(addNetDiskModel.savePath, this.$isFromRequestGetVip, addNetDiskModel.fsid);
            return;
        }
        String str3 = this.$url;
        if (str3 != null) {
            String str4 = str3;
            if (addNetDiskModel != null) {
                Long put = SearchH5DetectUtlsKt.getDOWNLOADING_TASK_MAP().put(str3, Long.valueOf(addNetDiskModel.taskId));
            }
        }
        if (addNetDiskModel != null) {
            l = Long.valueOf(addNetDiskModel.taskId);
        }
        SearchH5SaveNetUtilsKt.queryNetDiskTaskDelay(l, btn);
        if (btn == null || !btn.isShown()) {
            z = false;
        }
        if (z) {
            UiThreadUtils.runOnUiThread(new SearchH5SaveNetUtilsKt$addNetDisk$1$$ExternalSyntheticLambda4(btn));
        } else if (this.$isFromRequestGetVip) {
            SearchH5ToastUtilKt.showLcpFreeVipSaveBeginToast();
        } else if (TextUtils.isEmpty(str)) {
            SearchH5ToastUtilKt.showSaveBeginToast();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m3011invoke$lambda0(SearchH5SnifferNetDiskButton $btn) {
        $btn.changeStatus(5);
        $btn.moveViewToState(SnifferNetDiskButtonStateEnum.INIT.getStateValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m3012invoke$lambda1(String $errCode, String $errMsg, SearchH5SnifferNetDiskButton $btn) {
        String str;
        SearchVideoH5DownloadModel searchVideoH5DownloadModel;
        if ($btn == null || (searchVideoH5DownloadModel = $btn.getSearchVideoH5DownloadModel()) == null || (str = searchVideoH5DownloadModel.getTitle()) == null) {
            str = "";
        }
        SearchH5ToastUtilKt.showSaveFailToast(SearchH5VideoUbcUtils.STEP_LCB_WANGPAN_TASK_ADD_FAIL, $errCode, $errMsg, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final void m3013invoke$lambda3(String $errCode, String $errMsg, SearchH5SnifferNetDiskButton $btn) {
        String str;
        SearchVideoH5DownloadModel searchVideoH5DownloadModel;
        if ($btn == null || (searchVideoH5DownloadModel = $btn.getSearchVideoH5DownloadModel()) == null || (str = searchVideoH5DownloadModel.getTitle()) == null) {
            str = "";
        }
        SearchH5ToastUtilKt.showSaveFailToast(SearchH5VideoUbcUtils.STEP_LCB_WANGPAN_TASK_ADD_FAIL, $errCode, $errMsg, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final void m3014invoke$lambda5(SearchH5SnifferNetDiskButton $btn) {
        $btn.changeStatus(2);
        $btn.moveViewToState(SnifferNetDiskButtonStateEnum.FINISHED.getStateValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8  reason: not valid java name */
    public static final void m3015invoke$lambda8(SearchH5SnifferNetDiskButton $btn) {
        $btn.changeStatus(1);
        $btn.moveViewToState(SnifferNetDiskButtonStateEnum.PREPARING.getStateValue());
    }
}
