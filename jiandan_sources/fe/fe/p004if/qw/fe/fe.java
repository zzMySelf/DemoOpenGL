package fe.fe.p004if.qw.fe;

import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
import fe.fe.p004if.qw.de.qw;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

/* renamed from: fe.fe.if.qw.fe.fe  reason: invalid package */
public class fe {
    public qw ad(InputStream inputStream) throws Exception {
        InputStream inputStream2 = inputStream;
        qw qwVar = new qw();
        if (inputStream2 instanceof ByteArrayInputStream) {
            fe.fe.p004if.qw.yj.fe.qw("PbProcessor", "parseResponse quic");
        } else if (inputStream2 instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) inputStream2;
            byte readByte = dataInputStream.readByte();
            byte readByte2 = dataInputStream.readByte();
            byte readByte3 = dataInputStream.readByte();
            byte readByte4 = dataInputStream.readByte();
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            if (readInt > 1048576 || readInt2 > 1048576) {
                fe.fe.p004if.qw.yj.fe.ad("PbProcessor", "l :" + readByte + ", c :" + readByte2 + ", p :" + readByte3 + ", v :" + readByte4 + ",data : " + readInt + ", rpc :" + readInt2);
                throw new Exception(" Failed to allocate a larger byte allocation, data length = " + readInt);
            }
            byte[] bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
            qw qwVar2 = qwVar;
            int i2 = readInt - readInt2;
            byte[] bArr2 = bArr;
            byte[] bArr3 = new byte[i2];
            dataInputStream.readFully(bArr3);
            fe.fe.p004if.qw.yj.fe.rg("PbProcessor", "l :" + readByte + ", c :" + readByte2 + ", p :" + readByte3 + ", v :" + readByte4 + ",data : " + readInt + ", rpc :" + readInt2 + ", payload :" + i2);
            qw qwVar3 = qwVar2;
            de(qwVar3, bArr2, bArr3);
            return qwVar3;
        }
        return qwVar;
    }

    public final qw de(qw qwVar, byte[] bArr, byte[] bArr2) throws Exception {
        RpcMetaPb$RpcMeta parseFrom = RpcMetaPb$RpcMeta.parseFrom(bArr);
        if (parseFrom.getCompressType() == 1) {
            bArr2 = fe(bArr2);
            fe.fe.p004if.qw.yj.fe.qw("PbProcessor", "payload is gzip compressed，length : " + bArr2.length);
        }
        qwVar.f1959th = bArr2;
        if (parseFrom.hasNotify()) {
            RpcMetaPb$RpcNotifyMeta notify = parseFrom.getNotify();
            qwVar.f1953de = 0;
            qwVar.f1954fe = "notify";
            qwVar.f1960uk = notify.getServiceId();
            qwVar.f1955i = notify.getMethodId();
            qwVar.when = notify.getLogId();
            qwVar.f1958rg = true;
        } else if (parseFrom.hasResponse()) {
            RpcMetaPb$RpcResponseMeta response = parseFrom.getResponse();
            qwVar.f1953de = response.getErrorCode();
            qwVar.f1954fe = response.getErrorText();
            qwVar.f1960uk = response.getServiceId();
            qwVar.f1955i = response.getMethodId();
            qwVar.when = response.getLogId();
            qwVar.f1958rg = false;
            if (qwVar.f1953de == 0 && qwVar.f1960uk == 1) {
                qw(qwVar, bArr2);
                return qwVar;
            }
        } else if (parseFrom.hasRequest()) {
            RpcMetaPb$RpcRequestMeta request = parseFrom.getRequest();
            qwVar.f1960uk = request.getServiceId();
            qwVar.f1955i = request.getMethodId();
            fe.fe.p004if.qw.yj.fe.qw("PbProcessor", "parseRpcMeta requestMeta");
            qw(qwVar, bArr2);
        }
        return qwVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048 A[SYNTHETIC, Splitter:B:25:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0059 A[SYNTHETIC, Splitter:B:32:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] fe(byte[] r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Exception "
            java.lang.String r1 = "SocketTransceiver"
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r10)
            r4 = 0
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            r5.<init>(r3)     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0039 }
        L_0x0018:
            int r6 = r5.read(r4)     // Catch:{ IOException -> 0x0039 }
            if (r6 < 0) goto L_0x0023
            r7 = 0
            r2.write(r4, r7, r6)     // Catch:{ IOException -> 0x0039 }
            goto L_0x0018
        L_0x0023:
            byte[] r10 = r2.toByteArray()     // Catch:{ IOException -> 0x0039 }
            r5.close()     // Catch:{ Exception -> 0x0031 }
            r3.close()     // Catch:{ Exception -> 0x0031 }
            r2.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r2 = move-exception
            fe.fe.p004if.qw.yj.fe.de(r1, r0, r2)
        L_0x0035:
            return r10
        L_0x0036:
            r10 = move-exception
            r4 = r5
            goto L_0x0057
        L_0x0039:
            r4 = move-exception
            goto L_0x0041
        L_0x003b:
            r10 = move-exception
            goto L_0x0057
        L_0x003d:
            r5 = move-exception
            r8 = r5
            r5 = r4
            r4 = r8
        L_0x0041:
            java.lang.String r6 = "unzip exception :"
            fe.fe.p004if.qw.yj.fe.de(r1, r6, r4)     // Catch:{ all -> 0x0036 }
            if (r5 == 0) goto L_0x004b
            r5.close()     // Catch:{ Exception -> 0x0052 }
        L_0x004b:
            r3.close()     // Catch:{ Exception -> 0x0052 }
            r2.close()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r2 = move-exception
            fe.fe.p004if.qw.yj.fe.de(r1, r0, r2)
        L_0x0056:
            return r10
        L_0x0057:
            if (r4 == 0) goto L_0x005c
            r4.close()     // Catch:{ Exception -> 0x0063 }
        L_0x005c:
            r3.close()     // Catch:{ Exception -> 0x0063 }
            r2.close()     // Catch:{ Exception -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r2 = move-exception
            fe.fe.p004if.qw.yj.fe.de(r1, r0, r2)
        L_0x0067:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p004if.qw.fe.fe.fe(byte[]):byte[]");
    }

    public final qw qw(qw qwVar, byte[] bArr) throws Exception {
        LcmPb$RpcData parseFrom = LcmPb$RpcData.parseFrom(bArr);
        if (parseFrom.hasLcmResponse()) {
            LcmPb$LcmResponse lcmResponse = parseFrom.getLcmResponse();
            fe.fe.p004if.qw.yj.fe.qw("PbProcessor", "methodId ：" + qwVar.f1955i + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
            if (lcmResponse.getErrorCode() == 0) {
                long j = qwVar.f1955i;
                if (j == 1) {
                    qwVar.f1956o = 0;
                    qwVar.f1961yj = lcmResponse.getNextIntervalMs();
                } else if (j == 2) {
                    qwVar.f1956o = -1;
                } else if (j == 3) {
                    qwVar.f1961yj = lcmResponse.getNextIntervalMs();
                } else if (j == 4) {
                    fe.fe.p004if.qw.yj.fe.qw("PbProcessor", "parseLcmResponse notify");
                }
            } else {
                qwVar.f1953de = lcmResponse.getErrorCode();
                qwVar.f1954fe = lcmResponse.getErrorMsg();
                qwVar.f1956o = -1;
            }
        } else if (parseFrom.hasLcmNotify()) {
            fe.fe.p004if.qw.yj.fe.qw("PbProcessor", "lcmpb hasLcmNotify");
        } else if (parseFrom.hasLcmRequest()) {
            qwVar.when = parseFrom.getLcmRequest().getLogId();
        }
        return qwVar;
    }
}
