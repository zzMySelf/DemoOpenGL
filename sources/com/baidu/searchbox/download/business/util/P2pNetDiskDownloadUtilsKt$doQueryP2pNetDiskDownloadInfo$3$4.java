package com.baidu.searchbox.download.business.util;

import android.content.Context;
import com.baidu.netdisk.io.ErrorCode;
import com.baidu.searchbox.containers.nps.netdisk.face.INetdiskPluginFace;
import com.baidu.searchbox.containers.nps.netdisk.face.data.NetDiskRapidEnableQueryInfo;
import com.baidu.searchbox.download.util.DebugUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p2pEnable", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: P2pNetDiskDownloadUtils.kt */
final class P2pNetDiskDownloadUtilsKt$doQueryP2pNetDiskDownloadInfo$3$4 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function5<Boolean, String, Long, Long, String, Unit> $callback;
    final /* synthetic */ Long $contentLength;
    final /* synthetic */ Context $context;
    final /* synthetic */ INetdiskPluginFace $it;
    final /* synthetic */ String $m3u8HighResMd5;
    final /* synthetic */ String $originUrl;
    final /* synthetic */ long $timeout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    P2pNetDiskDownloadUtilsKt$doQueryP2pNetDiskDownloadInfo$3$4(Function5<? super Boolean, ? super String, ? super Long, ? super Long, ? super String, Unit> function5, INetdiskPluginFace iNetdiskPluginFace, Context context, String str, Long l, String str2, long j2) {
        super(1);
        this.$callback = function5;
        this.$it = iNetdiskPluginFace;
        this.$context = context;
        this.$originUrl = str;
        this.$contentLength = l;
        this.$m3u8HighResMd5 = str2;
        this.$timeout = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean p2pEnable) {
        if (!p2pEnable) {
            DebugUtilsKt.printLog("p2pDownload", AnonymousClass1.INSTANCE);
            P2pNetDiskDownloadUtilsKt.onCallbackInvoke(false, "", 0, 0, "", this.$callback);
            return;
        }
        INetdiskPluginFace iNetdiskPluginFace = this.$it;
        Context context = this.$context;
        String str = this.$originUrl;
        Long l = this.$contentLength;
        String str2 = this.$m3u8HighResMd5;
        Integer valueOf = Integer.valueOf((int) this.$timeout);
        final Function5<Boolean, String, Long, Long, String, Unit> function5 = this.$callback;
        final long j2 = this.$timeout;
        final Function5<Boolean, String, Long, Long, String, Unit> function52 = this.$callback;
        iNetdiskPluginFace.queryUrlP2pDownloadEnable(context, str, l, (Long) null, str2, valueOf, new Function3<Integer, String, NetDiskRapidEnableQueryInfo, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                invoke(((Number) p1).intValue(), (String) p2, (NetDiskRapidEnableQueryInfo) p3);
                return Unit.INSTANCE;
            }

            public final void invoke(int errCode, String errMsg, NetDiskRapidEnableQueryInfo rapidEnableQueryInfo) {
                String str;
                switch (errCode) {
                    case 0:
                        if (rapidEnableQueryInfo == null) {
                            DebugUtilsKt.printLog("p2pDownload", AnonymousClass4.INSTANCE);
                            P2pNetDiskDownloadUtilsKt.onCallbackInvoke(false, "", 0, 0, "", function5);
                            return;
                        } else if (rapidEnableQueryInfo.getRapidDownload() == 1) {
                            DebugUtilsKt.printLog("p2pDownload", AnonymousClass1.INSTANCE);
                            Function5<Boolean, String, Long, Long, String, Unit> function5 = function5;
                            NetDiskRapidEnableQueryInfo it = rapidEnableQueryInfo;
                            String link = it.getLink();
                            if (link == null) {
                                link = "";
                            }
                            Long fileSize = it.getFileSize();
                            long j2 = 0;
                            long longValue = fileSize != null ? fileSize.longValue() : 0;
                            Long mTime = it.getMTime();
                            if (mTime != null) {
                                j2 = mTime.longValue();
                            }
                            String md5 = it.getMd5();
                            if (md5 == null) {
                                str = "";
                            } else {
                                str = md5;
                            }
                            P2pNetDiskDownloadUtilsKt.onCallbackInvoke(true, link, longValue, j2, str, function5);
                            return;
                        } else {
                            DebugUtilsKt.printLog("p2pDownload", AnonymousClass3.INSTANCE);
                            P2pNetDiskDownloadUtilsKt.onCallbackInvoke(false, "", 0, 0, "", function5);
                            return;
                        }
                    case ErrorCode.ERROR_USER_NOT_FOUND:
                        final long j3 = j2;
                        DebugUtilsKt.printLog("p2pDownload", new Function0<String>() {
                            public final String invoke() {
                                return "P2pNetDiskDownloadUtils.doQueryP2pNetDiskDownloadInfo: false callback, server response timeout with " + j3 + '.';
                            }
                        });
                        P2pNetDiskDownloadUtilsKt.onCallbackInvoke(false, "", 0, 0, "", function5);
                        return;
                    default:
                        DebugUtilsKt.printLog("p2pDownload", AnonymousClass6.INSTANCE);
                        P2pNetDiskDownloadUtilsKt.onCallbackInvoke(false, "", 0, 0, "", function5);
                        return;
                }
            }
        }, new Function2<Integer, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                invoke((Integer) p1, (String) p2);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num, String str) {
                DebugUtilsKt.printLog("p2pDownload", AnonymousClass1.INSTANCE);
                P2pNetDiskDownloadUtilsKt.onCallbackInvoke(false, "", 0, 0, "", function52);
            }
        });
    }
}
