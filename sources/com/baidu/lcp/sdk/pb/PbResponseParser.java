package com.baidu.lcp.sdk.pb;

import com.baidu.lcp.sdk.client.bean.BLCPEventList;
import com.baidu.lcp.sdk.connect.Message;
import com.baidu.lcp.sdk.connect.SocketConstants;
import com.baidu.lcp.sdk.pb.LcmPb;
import com.baidu.lcp.sdk.pb.RpcMetaPb;
import com.baidu.lcp.sdk.utils.LCPConstants;
import com.baidu.lcp.sdk.utils.LogUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class PbResponseParser {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.lcp.sdk.connect.Message parseResponse(java.io.DataInputStream r20, org.json.JSONArray r21) throws java.lang.Exception {
        /*
            r19 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "parseResponse array :"
            java.lang.String r4 = "PbProcessor"
            java.lang.String r0 = "parseResponse"
            com.baidu.lcp.sdk.utils.LogUtils.d(r4, r0)
            com.baidu.lcp.sdk.connect.Message r0 = new com.baidu.lcp.sdk.connect.Message
            r0.<init>()
            r5 = r0
            byte r6 = r20.readByte()
            byte r7 = r20.readByte()
            byte r8 = r20.readByte()
            byte r9 = r20.readByte()
            int r10 = r20.readInt()
            int r11 = r20.readInt()
            java.lang.String r0 = ", rpc :"
            java.lang.String r12 = ",data : "
            java.lang.String r13 = ", v :"
            java.lang.String r14 = ", p :"
            java.lang.String r15 = ", c :"
            r16 = r5
            java.lang.String r5 = "l :"
            r17 = r3
            r3 = 1048576(0x100000, float:1.469368E-39)
            if (r10 > r3) goto L_0x010f
            if (r11 > r3) goto L_0x010f
            byte[] r3 = new byte[r11]
            r1.readFully(r3)
            r18 = r3
            int r3 = r10 - r11
            byte[] r3 = new byte[r3]
            r1.readFully(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.StringBuilder r1 = r1.append(r15)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.StringBuilder r1 = r1.append(r14)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.StringBuilder r1 = r1.append(r13)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r1 = ", payload :"
            java.lang.StringBuilder r0 = r0.append(r1)
            int r1 = r3.length
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.baidu.lcp.sdk.utils.LogUtils.v(r4, r0)
            if (r2 == 0) goto L_0x00f6
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00df }
            r0.<init>()     // Catch:{ Exception -> 0x00df }
            java.lang.String r1 = "event"
            java.lang.String r5 = "CLCPParse"
            r0.put(r1, r5)     // Catch:{ Exception -> 0x00df }
            java.lang.String r1 = "timestamp_ms"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00df }
            r5.<init>()     // Catch:{ Exception -> 0x00df }
            java.lang.String r12 = ""
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ Exception -> 0x00df }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00df }
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ Exception -> 0x00df }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00df }
            r0.put(r1, r5)     // Catch:{ Exception -> 0x00df }
            r2.put(r0)     // Catch:{ Exception -> 0x00df }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00df }
            r1.<init>()     // Catch:{ Exception -> 0x00df }
            r5 = r17
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ Exception -> 0x00dd }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00dd }
            com.baidu.lcp.sdk.utils.LogUtils.d(r4, r1)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00f6
        L_0x00dd:
            r0 = move-exception
            goto L_0x00e2
        L_0x00df:
            r0 = move-exception
            r5 = r17
        L_0x00e2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.baidu.lcp.sdk.utils.LogUtils.e(r4, r1, r0)
        L_0x00f6:
            r1 = r19
            r4 = r16
            r5 = r18
            com.baidu.lcp.sdk.connect.Message r0 = r1.parseRpcMeta(r4, r5, r3, r2)
            int r4 = r10 - r11
            long r12 = (long) r4
            r0.responseBodySize = r12
            int r4 = r0.errorCode
            r12 = -1
            if (r4 != r12) goto L_0x010e
            r4 = 8002(0x1f42, float:1.1213E-41)
            r0.errorCode = r4
        L_0x010e:
            return r0
        L_0x010f:
            r1 = r19
            r3 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.StringBuilder r1 = r1.append(r15)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.StringBuilder r1 = r1.append(r14)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.StringBuilder r1 = r1.append(r13)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r0 = r0.toString()
            com.baidu.lcp.sdk.utils.LogUtils.e(r4, r0)
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = " Failed to allocate a larger byte allocation, data length = "
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lcp.sdk.pb.PbResponseParser.parseResponse(java.io.DataInputStream, org.json.JSONArray):com.baidu.lcp.sdk.connect.Message");
    }

    private Message parseRpcMeta(Message msg, byte[] rpc, byte[] payload, JSONArray array) throws Exception {
        RpcMetaPb.RpcMeta meta = null;
        try {
            meta = RpcMetaPb.RpcMeta.parseFrom(rpc);
        } catch (Throwable e2) {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.e(PbConstants.TAG, "parseRpcMeta RpcMeta.parseFrom exception ", e2);
            }
        }
        if (meta == null) {
            return msg;
        }
        if (meta.getCompressType() == 1) {
            payload = ungzip(payload);
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(PbConstants.TAG, "payload is gzip compressed，length : " + payload.length);
            }
        }
        msg.responseBody = payload;
        if (meta.hasNotify()) {
            RpcMetaPb.RpcNotifyMeta notifyMeta = meta.getNotify();
            msg.errorCode = 0;
            msg.errorMsg = "notify";
            msg.serviceId = notifyMeta.getServiceId();
            msg.methodId = notifyMeta.getMethodId();
            msg.msgId = notifyMeta.getLogId();
            msg.isNotify = true;
            msg.eventLists.clear();
            if (array != null) {
                for (int i2 = 0; i2 < array.length(); i2++) {
                    JSONObject obj = (JSONObject) array.get(i2);
                    msg.eventLists.add(new BLCPEventList(obj.optString("event"), obj.optLong("timestamp_ms")));
                }
            }
            for (int i3 = 0; i3 < notifyMeta.getEventListCount(); i3++) {
                msg.eventLists.add(new BLCPEventList(notifyMeta.getEventList(i3).getEvent(), notifyMeta.getEventList(i3).getTimestampMs()));
            }
            msg.eventLists.add(new BLCPEventList("CLCPNotify", System.currentTimeMillis()));
        } else if (meta.hasResponse()) {
            RpcMetaPb.RpcResponseMeta responseMeta = meta.getResponse();
            msg.errorCode = responseMeta.getErrorCode();
            msg.errorMsg = responseMeta.getErrorText();
            msg.serviceId = responseMeta.getServiceId();
            msg.methodId = responseMeta.getMethodId();
            msg.msgId = responseMeta.getLogId();
            msg.isNotify = false;
            msg.eventLists.clear();
            for (int i4 = 0; i4 < responseMeta.getEventListCount(); i4++) {
                msg.eventLists.add(new BLCPEventList(responseMeta.getEventList(i4).getEvent(), responseMeta.getEventList(i4).getTimestampMs()));
            }
            msg.eventLists.add(new BLCPEventList("CLCPResEnd", System.currentTimeMillis()));
            if (msg.errorCode == 0 && msg.serviceId == 1) {
                return parseLcmResponse(msg, payload);
            }
        } else if (meta.hasRequest()) {
            RpcMetaPb.RpcRequestMeta requestMeta = meta.getRequest();
            msg.serviceId = requestMeta.getServiceId();
            msg.methodId = requestMeta.getMethodId();
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(PbConstants.TAG, "parseRpcMeta requestMeta");
            }
            return parseLcmResponse(msg, payload);
        }
        return msg;
    }

    private Message parseLcmResponse(Message msg, byte[] lcm) throws Exception {
        LcmPb.RpcData lcmPb = LcmPb.RpcData.parseFrom(lcm);
        if (lcmPb.hasLcmResponse()) {
            LcmPb.LcmResponse lcmResponse = lcmPb.getLcmResponse();
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(PbConstants.TAG, "methodId ：" + msg.methodId + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
            }
            if (lcmResponse.getErrorCode() == 0) {
                if (msg.methodId == 1) {
                    msg.connectState = 0;
                    msg.sCurPingIntervalMs = lcmResponse.getNextIntervalMs();
                    msg.responseServerInfo = lcmResponse.getServerInfo();
                    msg.sMaxPingIntervalMs = lcmResponse.getMaxIntervalMs();
                } else if (msg.methodId == 2) {
                    msg.connectState = -1;
                } else if (msg.methodId == 3) {
                    msg.sCurPingIntervalMs = lcmResponse.getNextIntervalMs();
                    msg.sMaxPingIntervalMs = lcmResponse.getMaxIntervalMs();
                } else if (msg.methodId == 4 && LCPConstants.LOG_DEBUG) {
                    LogUtils.d(PbConstants.TAG, "parseLcmResponse notify");
                }
                msg.errorCode = 0;
            } else {
                msg.errorCode = lcmResponse.getErrorCode();
                msg.errorMsg = lcmResponse.getErrorMsg();
                msg.connectState = -1;
            }
        } else if (lcmPb.hasLcmNotify()) {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(PbConstants.TAG, "lcmpb hasLcmNotify");
            }
        } else if (lcmPb.hasLcmRequest()) {
            msg.msgId = lcmPb.getLcmRequest().getLogId();
            msg.errorCode = 0;
        }
        return msg;
    }

    private byte[] ungzip(byte[] buf) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ungzip = null;
        try {
            ByteArrayInputStream in2 = new ByteArrayInputStream(buf);
            GZIPInputStream ungzip2 = new GZIPInputStream(in2);
            byte[] buffer = new byte[1024];
            while (true) {
                int read = ungzip2.read(buffer);
                int n = read;
                if (read < 0) {
                    break;
                }
                out.write(buffer, 0, n);
            }
            byte[] byteArray = out.toByteArray();
            try {
                ungzip2.close();
                in2.close();
                out.close();
            } catch (Exception e2) {
                if (LCPConstants.LOG_DEBUG) {
                    LogUtils.e(SocketConstants.TAG, "Exception ", e2);
                }
            }
            return byteArray;
        } catch (Throwable th2) {
            if (ungzip != null) {
                try {
                    ungzip.close();
                } catch (Exception e3) {
                    if (LCPConstants.LOG_DEBUG) {
                        LogUtils.e(SocketConstants.TAG, "Exception ", e3);
                    }
                    throw th2;
                }
            }
            if (in != null) {
                in.close();
            }
            out.close();
            throw th2;
        }
    }
}
