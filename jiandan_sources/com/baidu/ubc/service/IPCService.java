package com.baidu.ubc.service;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.ubc.Flow;
import com.baidu.ubc.IRemoteUBCService;
import com.baidu.ubc.UBCManager;
import com.baidu.ubc.inter.IIPCService;
import fe.fe.mmm.tt;
import fe.fe.vvv.ad.ad.ad;
import fe.fe.vvv.ad.qw.qw;
import org.json.JSONException;
import org.json.JSONObject;

public class IPCService implements IIPCService {
    public static final boolean qw = tt.vvv();

    public IBinder ad(String str) {
        return IPCServiceManager.th(str, true);
    }

    public void qw() {
        IPCServiceManager.de("remote_ubc_service", new IRemoteUBCService.Stub() {
            public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                if (flow != null) {
                    UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                    if (uBCManager != null) {
                        uBCManager.flowAddEvent(flow, str, str2);
                    }
                    if (IPCService.qw) {
                        " [add Event] flow id " + flow.getId() + " handler id " + flow.getHandle();
                    }
                }
            }

            public void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException {
                UBCManager uBCManager;
                if (flow != null && (uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)) != null) {
                    uBCManager.flowAddEventWithDate(flow, str, str2, j);
                }
            }

            public void flowCancel(Flow flow) throws RemoteException {
                UBCManager uBCManager;
                if (flow != null && (uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)) != null) {
                    uBCManager.flowCancel(flow);
                }
            }

            public void flowEnd(Flow flow) throws RemoteException {
                if (flow != null) {
                    UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                    if (uBCManager != null) {
                        uBCManager.flowEnd(flow);
                    }
                    if (IPCService.qw) {
                        " [end] flow id " + flow.getId() + " handler id " + flow.getHandle();
                    }
                }
            }

            public void flowEndSlot(Flow flow, String str) throws RemoteException {
                UBCManager uBCManager;
                if (flow != null && (uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)) != null) {
                    uBCManager.flowEndSlot(flow, str);
                }
            }

            public void flowSetValue(Flow flow, String str) throws RemoteException {
                UBCManager uBCManager;
                if (flow != null && (uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)) != null) {
                    uBCManager.flowSetValue(flow, str);
                }
            }

            public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                UBCManager uBCManager;
                if (flow != null && (uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)) != null) {
                    uBCManager.flowSetValueWithDuration(flow, str);
                }
            }

            public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                if (flow == null) {
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                    if (uBCManager != null) {
                        uBCManager.flowStartSlot(flow, str, (JSONObject) null);
                        return;
                    }
                    return;
                }
                try {
                    UBCManager uBCManager2 = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                    if (uBCManager2 != null) {
                        uBCManager2.flowStartSlot(flow, str, new JSONObject(str2));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public void flush() throws RemoteException {
                UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.flush();
                }
            }

            public String getUploadType(String str) throws RemoteException {
                UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                return uBCManager != null ? uBCManager.getUploadType(str) : "";
            }

            public Flow ubcBeginFlow(String str, String str2, int i2) throws RemoteException {
                Flow beginFlow = ((UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)).beginFlow(str, str2, i2);
                if (IPCService.qw && beginFlow != null) {
                    " process name " + qw.ad() + " flow hashCode " + beginFlow.hashCode() + " flow id " + str + " handle id " + beginFlow.getHandle();
                }
                return beginFlow;
            }

            public Flow ubcBeginFlowWithBizInfo(String str, String str2, int i2, String str3) throws RemoteException {
                Flow beginFlow = ((UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)).beginFlow(str, str2, i2);
                if (IPCService.qw && beginFlow != null) {
                    " process name " + qw.ad() + " flow hashCode " + beginFlow.hashCode() + " flow id " + str + " handle id " + beginFlow.getHandle();
                }
                return beginFlow;
            }

            public void ubcOnEvent(String str, String str2, int i2) throws RemoteException {
                ((UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)).onEvent(str, str2, i2);
            }

            public void ubcOnEventWithBizInfo(String str, String str2, int i2, String str3) throws RemoteException {
                ((UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)).onEvent(str, str2, i2);
            }

            public void upload() throws RemoteException {
                UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.upload();
                }
            }

            public void uploadFailedData() throws RemoteException {
                UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.uploadFailedData();
                }
            }

            public void uploadLocalDatas() throws RemoteException {
                UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.uploadLocalDatas();
                }
            }
        }, false);
    }
}
