package fe.fe.ddd.fe.qw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.searchbox.aperf.bosuploader.UploadUrlListener;
import com.baidu.searchbox.config.AppConfig;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import fe.fe.yj.ad.qw;
import java.io.File;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile de f1407ad;
    public static final boolean qw = AppConfig.rg();

    public static de de() {
        if (f1407ad == null) {
            synchronized (de.class) {
                if (f1407ad == null) {
                    f1407ad = new de();
                }
            }
        }
        return f1407ad;
    }

    public String ad(@NonNull String str, @NonNull String str2) {
        return qw.ad().qw() + "/" + SapiDeviceInfo.OS_TYPE + "/" + str + "/" + str2;
    }

    public qw fe(@NonNull String str, @NonNull String str2, @NonNull File file) {
        qw th2 = th(uk.ad(str), str, str2, file);
        return (th2.de() || th2.qw() == 0 || !uk.qw(str)) ? th2 : th(uk.fe(str), str, str2, file);
    }

    public final BosClient qw(@NonNull yj yjVar) {
        if (TextUtils.isEmpty(yjVar.qw) || TextUtils.isEmpty(yjVar.f1428ad) || TextUtils.isEmpty(yjVar.f1429de)) {
            return null;
        }
        BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
        bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(yjVar.qw, yjVar.f1428ad, yjVar.f1429de));
        bosClientConfiguration.setEndpoint(yjVar.f1434yj);
        return new BosClient(bosClientConfiguration);
    }

    public qw rg(@NonNull String str, @NonNull String str2, @NonNull File file, @NonNull UploadUrlListener uploadUrlListener) {
        i.qw().de(uploadUrlListener);
        return fe(str, str2, file);
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0111 A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0128 A[Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final fe.fe.ddd.fe.qw.qw th(fe.fe.ddd.fe.qw.yj r20, @androidx.annotation.NonNull java.lang.String r21, @androidx.annotation.NonNull java.lang.String r22, @androidx.annotation.NonNull java.io.File r23) {
        /*
            r19 = this;
            r0 = r20
            r1 = r23
            r2 = 0
            if (r0 != 0) goto L_0x000f
            fe.fe.ddd.fe.qw.qw r0 = new fe.fe.ddd.fe.qw.qw     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            java.lang.String r1 = "stsInfo is null"
            r0.<init>(r2, r1)     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            return r0
        L_0x000f:
            com.baidubce.services.bos.BosClient r3 = r19.qw(r20)     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            if (r3 != 0) goto L_0x001d
            fe.fe.ddd.fe.qw.qw r0 = new fe.fe.ddd.fe.qw.qw     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            java.lang.String r1 = "mBosClient is null"
            r0.<init>(r2, r1)     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            return r0
        L_0x001d:
            java.lang.String r4 = r0.f1432th     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            if (r0 == 0) goto L_0x002d
            fe.fe.ddd.fe.qw.qw r0 = new fe.fe.ddd.fe.qw.qw     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            java.lang.String r1 = "bucketName is null"
            r0.<init>(r2, r1)     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            return r0
        L_0x002d:
            long r5 = r23.length()     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x003f
            fe.fe.ddd.fe.qw.qw r0 = new fe.fe.ddd.fe.qw.qw     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            java.lang.String r1 = "fileLength is 0"
            r0.<init>(r2, r1)     // Catch:{ BceServiceException -> 0x01ad, BceClientException -> 0x0187, JSONException -> 0x0161, Exception -> 0x0153 }
            return r0
        L_0x003f:
            r9 = r19
            r0 = r21
            r10 = r22
            java.lang.String r10 = r9.ad(r0, r10)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r11 = 1
            r12 = 5242880(0x500000, double:2.590327E-317)
            int r0 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x005f
            com.baidubce.services.bos.model.PutObjectResponse r0 = r3.putObject((java.lang.String) r4, (java.lang.String) r10, (java.io.File) r1)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            fe.fe.ddd.fe.qw.qw r1 = new fe.fe.ddd.fe.qw.qw     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            java.lang.String r0 = r0.getETag()     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r1.<init>(r11, r0)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            return r1
        L_0x005f:
            com.baidubce.services.bos.model.InitiateMultipartUploadRequest r0 = new com.baidubce.services.bos.model.InitiateMultipartUploadRequest     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r0.<init>(r4, r10)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            com.baidubce.services.bos.model.InitiateMultipartUploadResponse r5 = r3.initiateMultipartUpload(r0)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            long r14 = r23.length()     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            long r14 = r14 / r12
            int r0 = (int) r14     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            long r14 = r23.length()     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            long r14 = r14 % r12
            int r6 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0079
            int r0 = r0 + 1
        L_0x0079:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r6.<init>(r0)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r7 = 0
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x010c }
            r8.<init>(r1)     // Catch:{ IOException -> 0x010c }
            r7 = 0
        L_0x0085:
            if (r7 >= r0) goto L_0x0106
            long r14 = (long) r7
            long r14 = r14 * r12
            long r16 = r23.length()     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            long r16 = r16 - r14
            int r18 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x0096
            r14 = r12
            goto L_0x009e
        L_0x0096:
            long r16 = r23.length()     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            long r16 = r16 - r14
            r14 = r16
        L_0x009e:
            int r12 = (int) r14     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            byte[] r13 = new byte[r12]     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
        L_0x00a1:
            int r17 = r8.read(r13, r2, r12)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            int r2 = r2 + r17
            if (r17 < 0) goto L_0x00b5
            r17 = r12
            long r11 = (long) r2     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            int r18 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r18 < 0) goto L_0x00b1
            goto L_0x00b5
        L_0x00b1:
            r12 = r17
            r11 = 1
            goto L_0x00a1
        L_0x00b5:
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r2.<init>(r13)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            com.baidubce.services.bos.model.UploadPartRequest r11 = new com.baidubce.services.bos.model.UploadPartRequest     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.<init>()     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.setBucketName(r4)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.setKey(r10)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            java.lang.String r12 = r5.getUploadId()     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.setUploadId(r12)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.setInputStream(r2)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.setPartSize(r14)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            int r7 = r7 + 1
            r11.setPartNumber(r7)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            com.baidubce.services.bos.model.UploadPartResponse r2 = r3.uploadPart(r11)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            com.baidubce.services.bos.model.PartETag r11 = r2.getPartETag()     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r6.add(r11)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            boolean r11 = qw     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            if (r11 == 0) goto L_0x00fa
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.<init>()     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            java.lang.String r12 = "partETags etag "
            r11.append(r12)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            com.baidubce.services.bos.model.PartETag r2 = r2.getPartETag()     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.append(r2)     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
            r11.toString()     // Catch:{ IOException -> 0x0103, all -> 0x0100 }
        L_0x00fa:
            r2 = 0
            r11 = 1
            r12 = 5242880(0x500000, double:2.590327E-317)
            goto L_0x0085
        L_0x0100:
            r0 = move-exception
            r7 = r8
            goto L_0x0147
        L_0x0103:
            r0 = move-exception
            r7 = r8
            goto L_0x010d
        L_0x0106:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r8)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            goto L_0x0117
        L_0x010a:
            r0 = move-exception
            goto L_0x0147
        L_0x010c:
            r0 = move-exception
        L_0x010d:
            boolean r1 = qw     // Catch:{ all -> 0x010a }
            if (r1 == 0) goto L_0x0114
            r0.printStackTrace()     // Catch:{ all -> 0x010a }
        L_0x0114:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r7)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
        L_0x0117:
            com.baidubce.services.bos.model.CompleteMultipartUploadRequest r0 = new com.baidubce.services.bos.model.CompleteMultipartUploadRequest     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            java.lang.String r1 = r5.getUploadId()     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r0.<init>(r4, r10, r1, r6)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            com.baidubce.services.bos.model.CompleteMultipartUploadResponse r0 = r3.completeMultipartUpload(r0)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            boolean r1 = qw     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            if (r1 == 0) goto L_0x013c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r1.<init>()     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            java.lang.String r2 = "PutObjectResponse etag "
            r1.append(r2)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            java.lang.String r2 = r0.getETag()     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r1.append(r2)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r1.toString()     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
        L_0x013c:
            fe.fe.ddd.fe.qw.qw r1 = new fe.fe.ddd.fe.qw.qw     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            java.lang.String r0 = r0.getETag()     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            r2 = 1
            r1.<init>(r2, r0)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            return r1
        L_0x0147:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r7)     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
            throw r0     // Catch:{ BceServiceException -> 0x0151, BceClientException -> 0x014f, JSONException -> 0x014d, Exception -> 0x014b }
        L_0x014b:
            r0 = move-exception
            goto L_0x0156
        L_0x014d:
            r0 = move-exception
            goto L_0x0164
        L_0x014f:
            r0 = move-exception
            goto L_0x018a
        L_0x0151:
            r0 = move-exception
            goto L_0x01b0
        L_0x0153:
            r0 = move-exception
            r9 = r19
        L_0x0156:
            fe.fe.ddd.fe.qw.qw r1 = new fe.fe.ddd.fe.qw.qw
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            r1.<init>(r2, r0)
            return r1
        L_0x0161:
            r0 = move-exception
            r9 = r19
        L_0x0164:
            boolean r1 = qw
            if (r1 == 0) goto L_0x017c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "JSONException Message: "
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            r1.toString()
        L_0x017c:
            fe.fe.ddd.fe.qw.qw r1 = new fe.fe.ddd.fe.qw.qw
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            r1.<init>(r2, r0)
            return r1
        L_0x0187:
            r0 = move-exception
            r9 = r19
        L_0x018a:
            boolean r1 = qw
            if (r1 == 0) goto L_0x01a2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "BceClientException Error Message:"
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            r1.toString()
        L_0x01a2:
            fe.fe.ddd.fe.qw.qw r1 = new fe.fe.ddd.fe.qw.qw
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            r1.<init>(r2, r0)
            return r1
        L_0x01ad:
            r0 = move-exception
            r9 = r19
        L_0x01b0:
            boolean r1 = qw
            if (r1 == 0) goto L_0x01c8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error Message: "
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            r1.toString()
        L_0x01c8:
            fe.fe.ddd.fe.qw.qw r1 = new fe.fe.ddd.fe.qw.qw
            java.lang.String r2 = r0.getMessage()
            int r0 = r0.getStatusCode()
            r3 = 0
            r1.<init>(r3, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.fe.qw.de.th(fe.fe.ddd.fe.qw.yj, java.lang.String, java.lang.String, java.io.File):fe.fe.ddd.fe.qw.qw");
    }
}
