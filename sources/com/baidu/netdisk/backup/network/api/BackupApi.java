package com.baidu.netdisk.backup.network.api;

import com.baidu.netdisk.backup.network.parser.UserConfSetParser;
import com.baidu.netdisk.base.network.FallbackManager;
import com.baidu.netdisk.base.network.NetworkTaskWrapper;
import com.baidu.netdisk.base.network.ServerURL;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.network.BaseApi;
import com.baidu.netdisk.network.exception.RemoteException;
import com.baidu.netdisk.network.request.HttpParams;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J*\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\u00072\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J&\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f¨\u0006\u0011"}, d2 = {"Lcom/baidu/netdisk/backup/network/api/BackupApi;", "Lcom/baidu/netdisk/network/BaseApi;", "bduss", "", "uid", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserConf", "Lkotlin/Pair;", "", "", "key", "cursor", "setUserConf", "value", "source", "", "saveType", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupApi.kt */
public final class BackupApi extends BaseApi {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackupApi(String bduss, String uid) {
        super(bduss, uid, new FallbackManager());
        Intrinsics.checkNotNullParameter(bduss, "bduss");
        Intrinsics.checkNotNullParameter(uid, "uid");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<java.lang.Boolean, java.util.List<java.lang.String>> getUserConf(java.lang.String r11, java.lang.String r12) throws org.json.JSONException, com.baidu.netdisk.network.exception.RemoteException, java.security.UnrecoverableKeyException, java.security.NoSuchAlgorithmException, java.security.KeyManagementException, java.security.KeyStoreException, java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "BackupApi"
            java.lang.String r1 = "getUserConf"
            com.baidu.netdisk.kernel.architecture.debug.NetDiskLog.d(r0, r1)
            java.lang.String r0 = r10.mBduss
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r0 = r2
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            if (r0 != 0) goto L_0x0126
            java.lang.String r0 = r10.mBduss
            com.baidu.netdisk.account.AccountUtils r3 = com.baidu.netdisk.account.AccountUtils.getInstance()
            java.lang.String r3 = r3.getBduss()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x0032
            goto L_0x0126
        L_0x0032:
            java.lang.String r0 = com.baidu.netdisk.base.network.ServerURL.getConfGetUrl()
            com.baidu.netdisk.network.request.HttpParams r3 = new com.baidu.netdisk.network.request.HttpParams
            r3.<init>()
            r4 = r3
            r5 = 0
            java.lang.String r6 = "item_key"
            r4.add(r6, r11)
            r6 = r12
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0050
            int r6 = r6.length()
            if (r6 != 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r6 = r2
            goto L_0x0051
        L_0x0050:
            r6 = r1
        L_0x0051:
            if (r6 != 0) goto L_0x0058
            java.lang.String r6 = "cursor"
            r4.add(r6, r12)
        L_0x0058:
            java.lang.String r6 = "source"
            java.lang.String r7 = "0"
            r4.add(r6, r7)
            java.lang.String r4 = "albumbackup"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r4)
            java.lang.String r5 = "res"
            r6 = 2
            if (r4 == 0) goto L_0x009e
            com.baidu.netdisk.base.network.NetworkTaskWrapper r4 = new com.baidu.netdisk.base.network.NetworkTaskWrapper
            r4.<init>()
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.baidu.netdisk.network.request.HttpRequest[] r7 = r10.buildGetRequest(r0, r3)
            r6[r2] = r7
            com.baidu.netdisk.backup.network.parser.OldestBackupConfParser r2 = new com.baidu.netdisk.backup.network.parser.OldestBackupConfParser
            r2.<init>()
            r6[r1] = r2
            java.lang.Object r1 = r4.send(r6)
            com.baidu.netdisk.backup.network.model.OldestBackupConfBean r1 = (com.baidu.netdisk.backup.network.model.OldestBackupConfBean) r1
            kotlin.Pair r2 = new kotlin.Pair
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            boolean r4 = com.baidu.netdisk.backup.network.model.OldestBackupConfBeanKt.isSuccess(r1)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.util.List r5 = com.baidu.netdisk.backup.network.model.OldestBackupConfBeanKt.items(r1)
            r2.<init>(r4, r5)
            return r2
        L_0x009e:
            r4 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            com.baidu.netdisk.base.network.NetworkTaskWrapper r8 = new com.baidu.netdisk.base.network.NetworkTaskWrapper
            r8.<init>()
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.baidu.netdisk.network.request.HttpRequest[] r9 = r10.buildGetRequest(r0, r3)
            r6[r2] = r9
            com.baidu.netdisk.backup.network.parser.OldBackupConfParser r9 = new com.baidu.netdisk.backup.network.parser.OldBackupConfParser
            r9.<init>()
            r6[r1] = r9
            java.lang.Object r6 = r8.send(r6)
            com.baidu.netdisk.backup.network.model.OldBackupConfBean r6 = (com.baidu.netdisk.backup.network.model.OldBackupConfBean) r6
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            boolean r4 = com.baidu.netdisk.backup.network.model.OldBackupConfBeanKt.isSuccess(r6)
            if (r4 == 0) goto L_0x00d3
            java.util.List r5 = com.baidu.netdisk.backup.network.model.OldBackupConfBeanKt.items(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            r7.addAll(r5)
        L_0x00d3:
            if (r4 == 0) goto L_0x011c
            int r5 = r6.getHasMore()
            int r8 = com.baidu.netdisk.backup.network.model.OldBackupConfBeanKt.getHAS_MORE_YES()
            if (r5 != r8) goto L_0x011c
            java.lang.String r5 = r6.getCursor()
            if (r5 == 0) goto L_0x00f4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x00ef
            r5 = r1
            goto L_0x00f0
        L_0x00ef:
            r5 = r2
        L_0x00f0:
            if (r5 != r1) goto L_0x00f4
            r5 = r1
            goto L_0x00f5
        L_0x00f4:
            r5 = r2
        L_0x00f5:
            if (r5 == 0) goto L_0x011c
            java.lang.String r5 = r6.getCursor()
            kotlin.Pair r5 = r10.getUserConf(r11, r5)
            java.lang.Object r8 = r5.component1()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            java.lang.Object r5 = r5.component2()
            java.util.List r5 = (java.util.List) r5
            if (r4 == 0) goto L_0x0114
            if (r8 == 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r1 = r2
        L_0x0115:
            r4 = r1
            r1 = r5
            java.util.Collection r1 = (java.util.Collection) r1
            r7.addAll(r1)
        L_0x011c:
            kotlin.Pair r1 = new kotlin.Pair
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)
            r1.<init>(r2, r7)
            return r1
        L_0x0126:
            kotlin.Pair r0 = new kotlin.Pair
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.backup.network.api.BackupApi.getUserConf(java.lang.String, java.lang.String):kotlin.Pair");
    }

    public final boolean setUserConf(String key, String value, int source, int saveType) throws JSONException, RemoteException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException, IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        NetDiskLog.d("BackupApi", "setUserConf " + key + ' ' + value + ' ' + source + ' ' + saveType);
        String url = ServerURL.getConfSetUrl();
        HttpParams params = new HttpParams();
        HttpParams $this$setUserConf_u24lambda_u2d1 = params;
        $this$setUserConf_u24lambda_u2d1.add("item_key", key);
        $this$setUserConf_u24lambda_u2d1.add("item_value", value);
        $this$setUserConf_u24lambda_u2d1.add("save_type", String.valueOf(saveType));
        $this$setUserConf_u24lambda_u2d1.add("source", String.valueOf(source));
        Object send = new NetworkTaskWrapper().send(buildPostRequest(url, params), new UserConfSetParser());
        Intrinsics.checkNotNullExpressionValue(send, "NetworkTaskWrapper<Boole…ConfSetParser()\n        )");
        return ((Boolean) send).booleanValue();
    }
}
