package fe.fe.p004if.qw.fe;

import android.content.Context;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import fe.fe.p004if.qw.de.qw;
import fe.fe.p004if.qw.qw.fe;
import fe.fe.p004if.qw.yj.ad;
import fe.fe.p004if.qw.yj.rg;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;

/* renamed from: fe.fe.if.qw.fe.de  reason: invalid package */
public class de {
    public qw ad(qw qwVar, boolean z) {
        qwVar.ppp = z;
        uk(qwVar, th(qwVar.f1960uk, qwVar.f1955i, qwVar.when, fe(false)), qw(qwVar.qw, fe(false)));
        return qwVar;
    }

    public qw de(Context context, long j) {
        long random = (long) ((Math.random() * 1000000.0d) + 10000.0d);
        qw qwVar = new qw();
        qwVar.when = random;
        boolean z = true;
        qwVar.ppp = true;
        qwVar.f1960uk = 1;
        qwVar.f1955i = j;
        qwVar.f45if = j == 1;
        if (j != 3) {
            z = false;
        }
        qwVar.f1957pf = z;
        uk(qwVar, th(1, j, random, fe(false)), qw(rg(context, random, j), fe(false)));
        return qwVar;
    }

    public final int fe(boolean z) {
        return z ? 1 : 0;
    }

    public final byte[] qw(byte[] bArr, int i2) {
        return i2 == 1 ? yj(bArr) : bArr;
    }

    public final byte[] rg(Context context, long j, long j2) {
        LcmPb$LcmRequest lcmPb$LcmRequest;
        if (j2 == 4) {
            return LcmPb$RpcData.newBuilder().setLcmNotify(LcmPb$LcmNotify.newBuilder().setLogId(j).setAction(2).build()).build().toByteArray();
        }
        if (j2 == 1) {
            try {
                LcmPb$Common lcmPb$Common = (LcmPb$Common) ad.de(context, false);
                lcmPb$LcmRequest = LcmPb$LcmRequest.newBuilder().setLogId(j).setCommon(lcmPb$Common).setToken(rg.o(context)).setTimestamp(System.currentTimeMillis()).setStartType(fe.th(context)).setConnType(rg.fe(context)).build();
                fe.fe.p004if.qw.yj.fe.qw("PbProcessor", "cuid :" + lcmPb$Common.getCuid() + ", device :" + lcmPb$Common.getDeviceType() + ", os:" + lcmPb$Common.getOsVersion() + ", man :" + lcmPb$Common.getManufacture() + ", model :" + lcmPb$Common.getModelType() + ", appId :" + lcmPb$Common.getAppId() + ", app :" + lcmPb$Common.getAppVersion() + ", sdk :" + lcmPb$Common.getSdkVersion() + ", token :" + lcmPb$LcmRequest.getToken() + ", net :" + lcmPb$Common.getNetwork() + ", rom :" + lcmPb$Common.getRomVersion() + ", start :" + lcmPb$LcmRequest.getStartType() + "，connType :" + lcmPb$LcmRequest.getConnType());
            } catch (Exception unused) {
                lcmPb$LcmRequest = LcmPb$LcmRequest.newBuilder().setLogId(j).setToken(rg.o(context)).setTimestamp(System.currentTimeMillis()).setStartType(fe.th(context)).setConnType(rg.fe(context)).build();
            }
        } else if (j2 == 2) {
            lcmPb$LcmRequest = LcmPb$LcmRequest.newBuilder().setLogId(j).setTimestamp(System.currentTimeMillis()).build();
        } else {
            lcmPb$LcmRequest = LcmPb$LcmRequest.newBuilder().setLogId(j).setTimestamp(System.currentTimeMillis()).build();
        }
        fe.fe.p004if.qw.yj.fe.th("PbProcessor", "logId :" + j + ", requestTime :" + lcmPb$LcmRequest.getTimestamp() + "，methodId :" + j2);
        return LcmPb$RpcData.newBuilder().setLcmRequest(lcmPb$LcmRequest).build().toByteArray();
    }

    public final byte[] th(long j, long j2, long j3, int i2) {
        return RpcMetaPb$RpcMeta.newBuilder().setRequest(RpcMetaPb$RpcRequestMeta.newBuilder().setLogId(j3).setServiceId(j).setMethodId(j2).setNeedCommon(1).build()).setCorrelationId(j3).setCompressType(i2).setAcceptCompressType(1).build().toByteArray();
    }

    public final qw uk(qw qwVar, byte[] bArr, byte[] bArr2) {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12 + bArr2.length);
            allocate.put((byte) 108);
            allocate.put((byte) 99);
            allocate.put((byte) 112);
            allocate.put((byte) 1);
            allocate.putInt(bArr.length + bArr2.length);
            allocate.putInt(bArr.length);
            allocate.put(bArr);
            allocate.put(bArr2);
            qwVar.qw = allocate.array();
        } catch (Exception unused) {
        }
        return qwVar;
    }

    public final byte[] yj(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
