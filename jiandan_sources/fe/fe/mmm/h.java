package fe.fe.mmm;

import android.content.SharedPreferences;
import android.os.RemoteException;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.ubc.Flow;
import com.baidu.ubc.IRemoteUBCService;
import com.baidu.ubc.IUBCStatisticCallback;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBCApiCollector;
import com.baidu.ubc.UBCManager;
import com.baidu.ubc.bypass.BypassConstants$Funnel;
import fe.fe.mmm.Cswitch;
import fe.fe.vvv.ad.qw.qw;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements UBCManager {

    /* renamed from: de  reason: collision with root package name */
    public static final boolean f2032de = tt.vvv();

    /* renamed from: ad  reason: collision with root package name */
    public String f2033ad = "";
    public String qw = "";

    public final Flow ad(String str, String str2, int i2) {
        Flow ubcBeginFlowWithBizInfo;
        Flow flow = null;
        try {
            if (TextUtils.isEmpty(this.qw)) {
                ubcBeginFlowWithBizInfo = qw().ubcBeginFlow(str, str2, i2);
            } else {
                ubcBeginFlowWithBizInfo = qw().ubcBeginFlowWithBizInfo(str, str2, i2, this.qw);
            }
            flow = ubcBeginFlowWithBizInfo;
            if (f2032de) {
                "flow id " + str + " beginFlow  process name " + qw.ad() + "flow hashCode " + flow.hashCode() + " handle id " + flow.getHandle();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return flow == null ? new Flow() : flow;
    }

    public final Flow beginFlow(String str) {
        UBCApiCollector.ad().qw(str, 0, UBCApiCollector.ApiType.BEGIN_FLOW_1);
        return beginFlow(str, "", 0);
    }

    public void flowAddEvent(Flow flow, String str) {
        UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_ADD_EVENT_1);
        flowAddEvent(flow, str, (String) null);
    }

    public void flowAddEventWithDate(Flow flow, String str, String str2, long j) {
        if (f2032de) {
            " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid();
        }
        if (flow != null && flow.getValid()) {
            if (qw.yj()) {
                UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_ADD_EVENT_WITH_DATE);
                th.nn().c(flow.getId(), str, flow.getHandle(), str2, j, flow.getOption());
                return;
            }
            try {
                mmm.qw().flowAddEventWithTime(flow, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void flowCancel(Flow flow) {
        if (f2032de) {
            "cancel flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid();
        }
        if (flow != null && flow.getValid()) {
            if (!flow.hasEnd()) {
                flow.markEnd();
                if (qw.yj()) {
                    UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_CANCEL);
                    th.nn().ggg(flow.getId(), flow.getHandle());
                    return;
                }
                try {
                    mmm.qw().flowCancel(flow);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else if (f2032de) {
                "flow has end, should not end again!!! ubc id=" + flow.getId() + ", flow handle=" + flow.getHandle();
            }
        }
    }

    public void flowEnd(Flow flow) {
        if (f2032de) {
            "end flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid();
        }
        if (flow != null && flow.getValid()) {
            if (!flow.hasEnd()) {
                UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_END);
                flow.markEnd();
                if (qw.yj()) {
                    fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.CALL_ON_FLOW, System.currentTimeMillis());
                    JSONArray jSONArray = new JSONArray();
                    if (!(flow.getSlotMaps() == null || (r0 = flow.getSlotMaps().entrySet().iterator()) == null)) {
                        for (Map.Entry next : flow.getSlotMaps().entrySet()) {
                            Slot slot = (Slot) next.getValue();
                            if (slot.isBegin() && !slot.isEnded()) {
                                slot.setEnd(System.currentTimeMillis());
                            }
                            JSONObject jSONObject = ((Slot) next.getValue()).getJSONObject();
                            if (jSONObject != null) {
                                jSONArray.put(jSONObject);
                            }
                        }
                    }
                    th.nn().xxx(flow.getId(), flow.getHandle(), flow.getOption(), jSONArray, flow.getEndTime());
                    return;
                }
                try {
                    mmm.qw().flowEnd(flow);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else if (f2032de) {
                "flow has end, should not end again!!! ubc id=" + flow.getId() + ", flow handle=" + flow.getHandle();
            }
        }
    }

    public void flowEndSlot(Flow flow, String str) {
        Slot slot;
        if (flow != null && flow.getValid()) {
            UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_END_SLOT);
            if (!TextUtils.isEmpty(str) && (slot = flow.getSlotMaps().get(str)) != null && slot.isBegin() && !slot.isEnded()) {
                slot.setEnd(System.currentTimeMillis());
            }
        }
    }

    public void flowSetValue(Flow flow, String str) {
        if (f2032de) {
            " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid();
        }
        if (flow != null && flow.getValid()) {
            if (qw.yj()) {
                UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_SET_VALUE_1);
                th.nn().l(flow.getId(), flow.getHandle(), str);
                return;
            }
            try {
                mmm.qw().flowSetValue(flow, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void flowSetValueWithDuration(Flow flow, String str) {
        if (f2032de) {
            " flow setValueWithDuration, mId:" + flow.getId() + " handle: " + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid();
        }
        if (flow != null && flow.getValid()) {
            if (qw.yj()) {
                UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_SET_VALUE_WITH_DURATION);
                JSONObject jSONObject = new JSONObject();
                try {
                    if (flow.isCustomEndTime()) {
                        jSONObject.put("realendtime", Long.toString(System.currentTimeMillis()));
                    } else {
                        flow.setEndTime(System.currentTimeMillis());
                    }
                    float endTime = (float) (flow.getEndTime() - flow.getStartTime());
                    float f = endTime / 1000.0f;
                    if (f < 0.0f) {
                        f = 0.0f;
                    }
                    jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(f)}));
                    float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - flow.getClockStartTime());
                    if (Math.abs(elapsedRealtime - endTime) > 1000.0f) {
                        jSONObject.put("cduration", String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(elapsedRealtime / 1000.0f)}));
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("option", str);
                    }
                    if (f2032de) {
                        " flow setValueWithDuration, mId:" + flow.getId() + ", duration: " + jSONObject.toString();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                th.nn().l(flow.getId(), flow.getHandle(), jSONObject.toString());
                return;
            }
            try {
                mmm.qw().flowSetValueWithDuration(flow, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void flowStartSlot(Flow flow, String str, JSONObject jSONObject) {
        if (flow != null && flow.getValid()) {
            UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_START_SLOT);
            if (!TextUtils.isEmpty(str)) {
                Slot slot = flow.getSlotMaps().get(str);
                if (slot == null) {
                    flow.getSlotMaps().put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                    return;
                }
                slot.setOption(jSONObject);
            }
        }
    }

    public void flush() {
        boolean z = f2032de;
        if (qw.yj()) {
            th.nn().ddd();
            return;
        }
        try {
            mmm.qw().flush();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public String getUploadType(String str) {
        if (qw.yj()) {
            return th.nn().mmm(str);
        }
        try {
            return mmm.qw().getUploadType(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isUBCDebug() {
        if (f2032de) {
            return PreferenceManager.getDefaultSharedPreferences(tt.ad()).getBoolean("KEY_UBC_DEBUG", f2032de);
        }
        return false;
    }

    public boolean isUBCSample() {
        if (f2032de) {
            return PreferenceManager.getDefaultSharedPreferences(tt.ad()).getBoolean("KEY_UBC_SAMPLE", false);
        }
        return true;
    }

    public boolean isUseOfflineUrl() {
        if (f2032de) {
            return PreferenceManager.getDefaultSharedPreferences(tt.ad()).getBoolean("KEY_UBC_OFFLINE_URL", false);
        }
        return false;
    }

    public final void onEvent(String str) {
        onEvent(str, "", 0);
        UBCApiCollector.ad().qw(str, 0, UBCApiCollector.ApiType.ON_EVENT_1);
    }

    public final IRemoteUBCService qw() throws RemoteException {
        return mmm.qw();
    }

    public void registerBizParamData(Cif ifVar) {
        if (qw.yj()) {
            th.nn().e(ifVar);
        }
    }

    public void registerConfig(nn nnVar) {
        registerConfig(nnVar, false, (IUBCStatisticCallback) null);
    }

    public void setDefaultConfig(ggg ggg) {
        if (ggg != null && qw.yj()) {
            Cswitch.qw qwVar = new Cswitch.qw();
            qwVar.de(ggg.f2031th);
            qwVar.th(ggg.qw);
            qwVar.rg(ggg.f2027ad);
            qwVar.fe(ggg.f2029fe);
            qwVar.yj(ggg.f2028de);
            qwVar.ad(true);
            Cswitch qw2 = qwVar.qw();
            if (!ggg.qw(ggg.f2031th)) {
                qw2.g(ggg.f2030rg);
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(qw2);
            registerConfig(new nn(arrayList));
        }
    }

    public void setUBCDebug(boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(tt.ad()).edit();
        edit.putBoolean("KEY_UBC_DEBUG", z);
        edit.commit();
    }

    public void setUBCSample(boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(tt.ad()).edit();
        edit.putBoolean("KEY_UBC_SAMPLE", z);
        edit.commit();
    }

    public void setUseOfflineUrl(boolean z) {
        if (f2032de) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(tt.ad()).edit();
            edit.putBoolean("KEY_UBC_OFFLINE_URL", z);
            edit.commit();
        }
    }

    public void upload() {
        boolean z = f2032de;
        if (qw.yj()) {
            th.nn().m();
            th.nn().h();
            th.nn().g();
            return;
        }
        try {
            mmm.qw().upload();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void uploadFailedData() {
        boolean z = f2032de;
        if (qw.yj()) {
            th.nn().a();
            th.nn().j();
            return;
        }
        try {
            mmm.qw().uploadFailedData();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void uploadLocalDatas() {
        if (qw.yj()) {
            th.nn().v();
            return;
        }
        try {
            mmm.qw().uploadLocalDatas();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void registerConfig(nn nnVar, boolean z, IUBCStatisticCallback iUBCStatisticCallback) {
        th.nn().k(nnVar, z, iUBCStatisticCallback);
    }

    public final Flow beginFlow(String str, int i2) {
        UBCApiCollector.ad().qw(str, i2, UBCApiCollector.ApiType.BEGIN_FLOW_2);
        return beginFlow(str, "", i2);
    }

    public void flowAddEvent(Flow flow, String str, String str2) {
        if (f2032de) {
            " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid();
        }
        if (flow != null && flow.getValid()) {
            if (qw.yj()) {
                UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_ADD_EVENT_2);
                th.nn().b(flow.getId(), str, flow.getHandle(), str2, flow.getOption());
                return;
            }
            try {
                mmm.qw().flowAddEvent(flow, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void onEvent(String str, int i2) {
        onEvent(str, "", i2);
        UBCApiCollector.ad().qw(str, i2, UBCApiCollector.ApiType.ON_EVENT_2);
    }

    public final Flow beginFlow(String str, String str2) {
        UBCApiCollector.ad().qw(str, 0, UBCApiCollector.ApiType.BEGIN_FLOW_3);
        return beginFlow(str, str2, 0);
    }

    public final void onEvent(String str, String str2) {
        onEvent(str, str2, 0);
        UBCApiCollector.ad().qw(str, 0, UBCApiCollector.ApiType.ON_EVENT_3);
    }

    public final Flow beginFlow(String str, JSONObject jSONObject) {
        UBCApiCollector.ad().qw(str, 0, UBCApiCollector.ApiType.BEGIN_FLOW_4);
        return beginFlow(str, jSONObject, 0);
    }

    public final void onEvent(String str, JSONObject jSONObject) {
        onEvent(str, jSONObject, 0);
        UBCApiCollector.ad().qw(str, 0, UBCApiCollector.ApiType.ON_EVENT_4);
    }

    public final Flow beginFlow(String str, Map<String, String> map) {
        UBCApiCollector.ad().qw(str, 0, UBCApiCollector.ApiType.BEGIN_FLOW_5);
        return beginFlow(str, map, 0);
    }

    public final void onEvent(String str, Map<String, String> map) {
        onEvent(str, map, 0);
        UBCApiCollector.ad().qw(str, 0, UBCApiCollector.ApiType.ON_EVENT_5);
    }

    public final Flow beginFlow(String str, Map<String, String> map, int i2) {
        UBCApiCollector.ad().qw(str, i2, UBCApiCollector.ApiType.BEGIN_FLOW_6);
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        } catch (JSONException e) {
            if (f2032de) {
                "UBC beginFlow# exception:" + e.getMessage();
            }
        }
        return beginFlow(str, jSONObject.toString(), i2);
    }

    public void flowSetValue(Flow flow, Map<String, String> map) {
        if (flow != null && flow.getValid()) {
            UBCApiCollector.ad().qw(flow.getId(), 0, UBCApiCollector.ApiType.FLOW_SET_VALUE_2);
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException e) {
                if (f2032de) {
                    "UBC beginFlow# exception:" + e.getMessage();
                }
            }
            if (f2032de) {
                " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + jSONObject.toString();
            }
            flowSetValue(flow, jSONObject.toString());
        }
    }

    public final void onEvent(String str, Map<String, String> map, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        } catch (JSONException e) {
            if (f2032de) {
                "UBC onEvent# exception:" + e.getMessage();
            }
        }
        onEvent(str, jSONObject.toString(), i2);
        UBCApiCollector.ad().qw(str, i2, UBCApiCollector.ApiType.ON_EVENT_6);
    }

    public Flow beginFlow(String str, String str2, int i2) {
        if (!qw.yj()) {
            return ad(str, str2, i2);
        }
        if (!TextUtils.isEmpty(str)) {
            UBCApiCollector.ad().qw(str, i2, UBCApiCollector.ApiType.BEGIN_FLOW_7);
            if (f2032de) {
                "begin flow id:" + str + i2 + " value:" + str2 + " option:" + i2;
            }
            if (TextUtils.isEmpty(this.qw)) {
                return th.nn().m140if(str, str2, i2);
            }
            return th.nn().m141switch(str, str2, i2, this.f2033ad);
        } else if (!f2032de) {
            return null;
        } else {
            throw new IllegalArgumentException("UBC beginFlow#flowId must not be null.");
        }
    }

    public void onEvent(String str, String str2, int i2) {
        if (!qw.yj()) {
            try {
                IRemoteUBCService qw2 = qw();
                if (TextUtils.isEmpty(this.qw)) {
                    qw2.ubcOnEvent(str, str2, i2);
                } else {
                    qw2.ubcOnEventWithBizInfo(str, str2, i2, this.qw);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else if (!TextUtils.isEmpty(str)) {
            fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.CALL_ON_EVENT, System.currentTimeMillis());
            if (f2032de) {
                "on event id:" + str + " value:" + str2 + " option:" + i2;
            }
            if (TextUtils.isEmpty(this.qw)) {
                th.nn().qqq(str, str2, i2);
            } else {
                th.nn().eee(str, str2, i2, this.f2033ad);
            }
            UBCApiCollector.ad().qw(str, i2, UBCApiCollector.ApiType.ON_EVENT_7);
        } else if (f2032de) {
            throw new IllegalArgumentException("UBC onEvent#eventId must not be null.");
        }
    }

    public Flow beginFlow(String str, JSONObject jSONObject, int i2) {
        if (!qw.yj()) {
            return ad(str, jSONObject.toString(), i2);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        UBCApiCollector.ad().qw(str, i2, UBCApiCollector.ApiType.BEGIN_FLOW_8);
        if (f2032de) {
            "begin flow id:" + str + " value:" + jSONObject + " option:" + i2;
        }
        if (TextUtils.isEmpty(this.qw)) {
            return th.nn().when(str, jSONObject, i2);
        }
        return th.nn().ppp(str, jSONObject, i2, this.f2033ad);
    }

    public void onEvent(String str, JSONObject jSONObject, int i2) {
        if (!qw.yj()) {
            try {
                IRemoteUBCService qw2 = qw();
                if (TextUtils.isEmpty(this.qw)) {
                    qw2.ubcOnEvent(str, jSONObject.toString(), i2);
                } else {
                    qw2.ubcOnEventWithBizInfo(str, jSONObject.toString(), i2, this.qw);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else if (!TextUtils.isEmpty(str)) {
            fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.CALL_ON_EVENT, System.currentTimeMillis());
            if (f2032de) {
                "on event id:" + str + " value:" + jSONObject + " option:" + i2;
            }
            if (TextUtils.isEmpty(this.qw)) {
                th.nn().rrr(str, jSONObject, i2);
            } else {
                th.nn().tt(str, jSONObject, i2, this.f2033ad);
            }
            UBCApiCollector.ad().qw(str, i2, UBCApiCollector.ApiType.ON_EVENT_8);
        }
    }
}
