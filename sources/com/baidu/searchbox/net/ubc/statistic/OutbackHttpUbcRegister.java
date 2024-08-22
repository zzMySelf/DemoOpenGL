package com.baidu.searchbox.net.ubc.statistic;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.buildconfig.BuildConfigManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.abtest.config.networkconfig.HttpConfig;
import com.baidu.searchbox.http.abtest.config.networkconfig.NetworkUpdateConfig;
import com.baidu.searchbox.net.statistic.onlinelog.NetworkOnlineLogTool;
import com.baidu.searchbox.network.outback.statistics.DoRecordManager;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.outback.statistics.RecordObserver;
import com.baidu.ubc.UBCManager;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public final class OutbackHttpUbcRegister {
    public static final String NET_TAG = "network_log";
    private volatile boolean isRegister;
    private UBC1625RecordObserver ubc1625RecordObserver;
    private UBC850RecordObserver ubc850RecordObserver;
    private UBC94RecordObserver ubc94RecordObserver;

    private OutbackHttpUbcRegister() {
        this.isRegister = false;
        this.ubc94RecordObserver = new UBC94RecordObserver();
        this.ubc1625RecordObserver = new UBC1625RecordObserver();
        this.ubc850RecordObserver = new UBC850RecordObserver();
    }

    private static class SingleInstance {
        /* access modifiers changed from: private */
        public static OutbackHttpUbcRegister sOutbackHttpUbcRegister = new OutbackHttpUbcRegister();

        private SingleInstance() {
        }
    }

    public static OutbackHttpUbcRegister getInstance() {
        return SingleInstance.sOutbackHttpUbcRegister;
    }

    public synchronized void registerOutbackHttpUbc() {
        if (!this.isRegister) {
            this.isRegister = true;
            DoRecordManager.getInstance().attach(this.ubc94RecordObserver);
            DoRecordManager.getInstance().attach(this.ubc1625RecordObserver);
            DoRecordManager.getInstance().attach(this.ubc850RecordObserver);
        }
    }

    private static class UBC94RecordObserver implements RecordObserver {
        private static final int FLAG_DISABLE_REALTIME_UPLOAD = 64;
        private static final String TAG = "UBC94RecordObserver";

        private UBC94RecordObserver() {
        }

        public void doRecord(NetworkStatRecord networkStatRecord, int type) {
            reportToSampleLoadUbc(networkStatRecord);
        }

        private boolean shouldRecord(NetworkStatRecord record) {
            if ((record.from != 3 || (!BuildConfigManager.getBoolean("NBSwitcher", "SWITCH_BETA") && !BuildConfigManager.getBoolean("BuildConfig", "DEBUG"))) && new Random().nextInt(100) < NetworkUpdateConfig.getNetworkConfigInt("network_log_sample", 10)) {
                return true;
            }
            return false;
        }

        private void reportToSampleLoadUbc(NetworkStatRecord record) {
            if (record != null && shouldRecord(record)) {
                JSONObject ubcJson = record.toUBCJson();
                int option = 0;
                if (AppConfig.isDebug()) {
                    option = 0 | 64;
                }
                if (AppConfig.isDebug()) {
                    Log.e(TAG, "OutbackHttpUbcRegister reportToFullLoadUbc UBC.onEvent!UbcEventId:94，ubcJson:" + ubcJson);
                }
                NetworkOnlineLogTool networkOnlineLogTool = NetworkOnlineLogTool.getInstance();
                String ubcJsonStr = ubcJson.toString();
                if (networkOnlineLogTool.needRealTimeTotalLogByYalog()) {
                    networkOnlineLogTool.insertRealTimeLogByYalog(ubcJsonStr);
                } else if (OutbackHttpUbcRegister.needExceptionLogByYalog(record)) {
                    networkOnlineLogTool.insertExceptionLogByYalog(ubcJsonStr);
                }
                OutbackHttpUbcRegister.needExceptionLogByYalog(record);
                UBCManager manager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (manager != null) {
                    manager.onEvent(HttpConfig.UBC_HTTP_ID, ubcJson.toString(), option);
                }
            }
        }
    }

    public static boolean needExceptionLogByYalog(NetworkStatRecord record) {
        return record.exception != null || record.receiveHeaderTs - record.sendHeaderTs >= ((long) NetworkUpdateConfig.getThresholdToStoreLog()) || record.realResponseLength > 1048576 || record.requestBodyLength > 1048576;
    }

    private static class UBC1625RecordObserver implements RecordObserver {
        private static final String TAG = "1625RecordObserver";

        private UBC1625RecordObserver() {
        }

        public void doRecord(NetworkStatRecord networkStatRecord, int type) {
            reportToFullLoadUbc(networkStatRecord);
        }

        private void reportToFullLoadUbc(NetworkStatRecord record) {
            if (record != null) {
                JSONObject ubcJson = new JSONObject();
                try {
                    ubcJson.put("ext", record.toUBCJson());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (AppConfig.isDebug()) {
                    Log.e(TAG, "OutbackHttpUbcRegister reportToFullLoadUbc UBC.onEvent!UbcEventId:1625，ubcJson:" + ubcJson);
                }
                UBCManager manager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (manager != null) {
                    manager.onEvent(HttpConfig.UBC_HTTP_CRONET_LOAD_ID, ubcJson);
                }
            }
        }
    }

    private static class UBC850RecordObserver implements RecordObserver {
        public static final String NET_TAG = "network_log";
        private static final String TAG = "UBC850RecordObserver";

        private UBC850RecordObserver() {
        }

        public void doRecord(NetworkStatRecord record, int type) {
            reportExceptionToFullLoadUbc(record, type);
        }

        private void reportExceptionToFullLoadUbc(NetworkStatRecord record, int type) {
            if (record != null && type == DoRecordManager.FAILED_MSG) {
                JSONObject ubcJson = record.toUBCJson();
                if (AppConfig.isDebug()) {
                    Log.e(TAG, "OutbackHttpUbcRegister reportExceptionToFullLoadUbc UBC.onEvent!UbcEventId:850，ubcJson:" + ubcJson);
                }
                UBCManager manager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (manager != null) {
                    manager.onEvent(HttpConfig.UBC_HTTP_EXCEPTION_ID, ubcJson.toString());
                }
            }
        }
    }
}
