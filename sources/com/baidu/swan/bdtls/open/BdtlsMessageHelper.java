package com.baidu.swan.bdtls.open;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.bdtls.open.ioc.BdtlsRuntime;
import com.baidu.swan.bdtls.open.model.Bdtls;
import com.baidu.swan.bdtls.open.model.BdtlsModel;
import com.baidu.swan.bdtls.open.protocol.Handshake;
import com.baidu.swan.bdtls.open.protocol.Record;
import com.baidu.swan.bdtls.open.utils.BdtlsMD5Utils;

public class BdtlsMessageHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "MessageController";
    private static volatile BdtlsMessageHelper sInstance;

    public static BdtlsMessageHelper getInstance() {
        if (sInstance == null) {
            synchronized (BdtlsMessageHelper.class) {
                if (sInstance == null) {
                    sInstance = new BdtlsMessageHelper();
                }
            }
        }
        return sInstance;
    }

    private BdtlsMessageHelper() {
    }

    public byte[] getHandshakeRequestMessage(BdtlsModel.SessionParams sessionParams) {
        if (sessionParams == null) {
            return null;
        }
        try {
            byte[] handshakeBytes = Handshake.encode(sessionParams, new BdtlsModel.HandshakeParams());
            if (handshakeBytes == null) {
                return null;
            }
            BdtlsModel.RecordParams recordParams = BdtlsModel.RecordParams.createRecordParams();
            recordParams.setSchemeType((byte) 22);
            recordParams.setSchemeLen(Short.valueOf((short) handshakeBytes.length));
            recordParams.setIdentity(BdtlsRuntime.getBdtlsContext().getIdentity());
            recordParams.setScheme(handshakeBytes);
            return Record.encode(recordParams);
        } catch (Exception e2) {
            return null;
        }
    }

    public byte[] getApplicationRequestMessage(BdtlsModel.SessionParams sessionParams, byte[] requestMessage) {
        byte[] encodeMessageByte;
        if (sessionParams == null) {
            return null;
        }
        try {
            BdtlsModel.RecordParams recordParams = BdtlsModel.RecordParams.createRecordParams();
            recordParams.setSchemeType((byte) 23);
            long currentTime = System.currentTimeMillis() / 1000;
            byte[] skrByte = Bdtls.ApplicationData.newBuilder().setSKR(sessionParams.getSKR()).setTS(currentTime).setCheckSign(BdtlsMD5Utils.toMd5((currentTime + "@" + sessionParams.getAk()).getBytes(), false)).build().toByteArray();
            if (skrByte != null && skrByte.length > 0 && skrByte.length <= 32767) {
                recordParams.setSchemeLen(Short.valueOf((short) skrByte.length));
                recordParams.setScheme(skrByte);
            }
            if (requestMessage != null && requestMessage.length > 0) {
                try {
                    if (BdtlsManager.ABTEST_SWITCH_HIDE_BDTLS_AES_KEY) {
                        encodeMessageByte = AES.aesEncrypt(requestMessage, AppRuntime.getApplication(), BdtlsMD5Utils.toMd5(sessionParams.getAk().getBytes(), true));
                    } else {
                        encodeMessageByte = AES.aesEncrypt(requestMessage, sessionParams.getAesSecretKey());
                    }
                    recordParams.setContentLen(Integer.valueOf(encodeMessageByte.length));
                    recordParams.setContent(encodeMessageByte);
                } catch (Throwable th2) {
                }
            }
            recordParams.setIdentity(BdtlsRuntime.getBdtlsContext().getIdentity());
            return Record.encode(recordParams);
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.swan.bdtls.open.model.BdtlsModel.ResponseParams getApplicationResponseMessage(com.baidu.swan.bdtls.open.model.BdtlsModel.SessionParams r12, byte[] r13) {
        /*
            r11 = this;
            java.lang.String r0 = "MessageController"
            com.baidu.swan.bdtls.open.model.BdtlsModel$ResponseParams r1 = new com.baidu.swan.bdtls.open.model.BdtlsModel$ResponseParams
            r1.<init>()
            r2 = -1
            r3 = 0
            com.baidu.swan.bdtls.open.model.BdtlsModel$RecordParams r4 = com.baidu.swan.bdtls.open.protocol.Record.decode(r13)     // Catch:{ Exception -> 0x00b7 }
            byte r5 = r4.getSchemeType()     // Catch:{ Exception -> 0x00b7 }
            r6 = 1
            switch(r5) {
                case 21: goto L_0x0065;
                case 22: goto L_0x0015;
                case 23: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x00b6
        L_0x0017:
            byte[] r7 = r4.getContent()     // Catch:{ all -> 0x0045 }
            boolean r8 = com.baidu.swan.bdtls.open.BdtlsManager.ABTEST_SWITCH_HIDE_BDTLS_AES_KEY     // Catch:{ all -> 0x0045 }
            if (r8 == 0) goto L_0x0036
            android.app.Application r8 = com.baidu.searchbox.common.runtime.AppRuntime.getApplication()     // Catch:{ all -> 0x0045 }
            java.lang.String r9 = r12.getAk()     // Catch:{ all -> 0x0045 }
            byte[] r9 = r9.getBytes()     // Catch:{ all -> 0x0045 }
            java.lang.String r9 = com.baidu.swan.bdtls.open.utils.BdtlsMD5Utils.toMd5((byte[]) r9, (boolean) r6)     // Catch:{ all -> 0x0045 }
            byte[] r9 = com.baidu.swan.bdtls.AES.aesDecrypt(r7, r8, r9)     // Catch:{ all -> 0x0045 }
            r8 = r9
            goto L_0x003e
        L_0x0036:
            byte[] r8 = r12.getAesSecretKey()     // Catch:{ all -> 0x0045 }
            byte[] r8 = com.baidu.swan.bdtls.AES.aesDecrypt(r7, r8)     // Catch:{ all -> 0x0045 }
        L_0x003e:
            r1.setResponseMessage(r8)     // Catch:{ all -> 0x0045 }
            r1.setResponseStatusCode(r6)     // Catch:{ all -> 0x0045 }
            goto L_0x00b6
        L_0x0045:
            r6 = move-exception
            com.baidu.swan.bdtls.open.ioc.IBdtlsContext r7 = com.baidu.swan.bdtls.open.ioc.BdtlsRuntime.getBdtlsContext()     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r8.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r9 = "application response decode error:"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r9 = android.util.Log.getStackTraceString(r6)     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00b7 }
            r7.logToFile(r0, r8, r3)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00b6
        L_0x0065:
            byte[] r7 = r4.getScheme()     // Catch:{ Exception -> 0x00b7 }
            com.baidu.swan.bdtls.open.model.Bdtls$Alert r7 = com.baidu.swan.bdtls.open.model.Bdtls.Alert.parseFrom((byte[]) r7)     // Catch:{ Exception -> 0x00b7 }
            if (r7 == 0) goto L_0x00b2
            java.lang.String r8 = new java.lang.String     // Catch:{ Exception -> 0x00b7 }
            com.google.protobuf.ByteString r9 = r7.getDescription()     // Catch:{ Exception -> 0x00b7 }
            byte[] r9 = r9.toByteArray()     // Catch:{ Exception -> 0x00b7 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00b7 }
            int r9 = r7.getLevel()     // Catch:{ Exception -> 0x00b7 }
            if (r6 != r9) goto L_0x0087
            r6 = -2
            r1.setResponseStatusCode(r6)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x0097
        L_0x0087:
            java.lang.String r6 = "down grade"
            boolean r6 = android.text.TextUtils.equals(r8, r6)     // Catch:{ Exception -> 0x00b7 }
            if (r6 == 0) goto L_0x0094
            r6 = 2
            r1.setResponseStatusCode(r6)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x0097
        L_0x0094:
            r1.setResponseStatusCode(r2)     // Catch:{ Exception -> 0x00b7 }
        L_0x0097:
            com.baidu.swan.bdtls.open.ioc.IBdtlsContext r6 = com.baidu.swan.bdtls.open.ioc.BdtlsRuntime.getBdtlsContext()     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r9.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "application response alert message="
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r9 = r9.append(r8)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00b7 }
            r6.logToFile(r0, r9, r3)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00b6
        L_0x00b2:
            r1.setResponseStatusCode(r2)     // Catch:{ Exception -> 0x00b7 }
        L_0x00b6:
            goto L_0x00d9
        L_0x00b7:
            r4 = move-exception
            com.baidu.swan.bdtls.open.ioc.IBdtlsContext r5 = com.baidu.swan.bdtls.open.ioc.BdtlsRuntime.getBdtlsContext()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "application response exc error:"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = android.util.Log.getStackTraceString(r4)
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.logToFile(r0, r6, r3)
            r1.setResponseStatusCode(r2)
        L_0x00d9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.bdtls.open.BdtlsMessageHelper.getApplicationResponseMessage(com.baidu.swan.bdtls.open.model.BdtlsModel$SessionParams, byte[]):com.baidu.swan.bdtls.open.model.BdtlsModel$ResponseParams");
    }

    public static byte[] intToByte(int val) {
        return new byte[]{(byte) ((val >> 24) & 255), (byte) ((val >> 16) & 255), (byte) ((val >> 8) & 255), (byte) (val & 255)};
    }

    public static int byteToInt(byte[] val) {
        int ret = 0;
        if (val != null) {
            for (byte b2 : val) {
                ret = (ret << 8) | (b2 & 255);
            }
        }
        return ret;
    }

    public static String getBytesData(byte[] data) {
        if (data == null) {
            return "";
        }
        StringBuilder sd = new StringBuilder();
        for (int i2 = 0; i2 < data.length; i2++) {
            sd.append(data[i2] > 0 ? data[i2] : data[i2] & 255);
            sd.append(",");
        }
        return sd.toString();
    }

    public static String getBytesHexData(byte[] data) {
        StringBuilder sd = new StringBuilder();
        for (int i2 = 0; i2 < data.length; i2++) {
            sd.append(Integer.toHexString(data[i2] > 0 ? data[i2] : data[i2] & 255));
            sd.append(",");
        }
        return sd.toString();
    }
}
