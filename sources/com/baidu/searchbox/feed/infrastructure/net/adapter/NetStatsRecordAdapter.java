package com.baidu.searchbox.feed.infrastructure.net.adapter;

import android.text.TextUtils;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.video.detail.core.DataManager;
import org.json.JSONException;
import org.json.JSONObject;

public class NetStatsRecordAdapter {
    private final NetworkStatRecord mHttpNetStatsRecord;
    private final com.baidu.searchbox.network.outback.statistics.NetworkStatRecord mOutbackNetStatsRecord;
    private String turboNetLog;

    public static class NetStatsData {
        public long connect;
        public long dns;
        public boolean isConnReused;
        public int netEngine;
        public long netTotal;
        public long okHttp;
        public long responseNetTran = ((this.netTotal - this.connect) - this.server);
        public long server;
        public long threadSwitch;
    }

    public NetStatsRecordAdapter(Object real) {
        if (real instanceof NetworkStatRecord) {
            this.mHttpNetStatsRecord = (NetworkStatRecord) real;
            this.mOutbackNetStatsRecord = null;
        } else if (real instanceof com.baidu.searchbox.network.outback.statistics.NetworkStatRecord) {
            this.mHttpNetStatsRecord = null;
            this.mOutbackNetStatsRecord = (com.baidu.searchbox.network.outback.statistics.NetworkStatRecord) real;
        } else {
            throw new UnsupportedOperationException("Unknown type!");
        }
    }

    public void setTurboNetLog(String turboNetLog2) {
        this.turboNetLog = turboNetLog2;
    }

    public JSONObject toUBCJson() {
        NetworkStatRecord networkStatRecord = this.mHttpNetStatsRecord;
        if (networkStatRecord != null) {
            return networkStatRecord.toUBCJson();
        }
        com.baidu.searchbox.network.outback.statistics.NetworkStatRecord networkStatRecord2 = this.mOutbackNetStatsRecord;
        if (networkStatRecord2 != null) {
            return networkStatRecord2.toUBCJson();
        }
        return null;
    }

    public boolean isConnReused() {
        NetworkStatRecord networkStatRecord = this.mHttpNetStatsRecord;
        if (networkStatRecord != null) {
            return networkStatRecord.isConnReused;
        }
        com.baidu.searchbox.network.outback.statistics.NetworkStatRecord networkStatRecord2 = this.mOutbackNetStatsRecord;
        if (networkStatRecord2 != null) {
            return networkStatRecord2.isConnReused;
        }
        return false;
    }

    public NetStatsData asNetStatsData(long serverCost, long finalStart) {
        NetworkStatRecord networkStatRecord = this.mHttpNetStatsRecord;
        if (networkStatRecord != null) {
            return getStatsParams(networkStatRecord, serverCost, finalStart);
        }
        com.baidu.searchbox.network.outback.statistics.NetworkStatRecord networkStatRecord2 = this.mOutbackNetStatsRecord;
        if (networkStatRecord2 != null) {
            return getStatsParams(networkStatRecord2, serverCost, finalStart);
        }
        return null;
    }

    private NetStatsData getStatsParams(com.baidu.searchbox.network.outback.statistics.NetworkStatRecord statRecord, long serverCost, long finalStart) {
        NetStatsData data = new NetStatsData();
        data.dns = statRecord.dnsEndTs - statRecord.dnsStartTs;
        data.connect = statRecord.connTs - statRecord.startTs;
        data.netTotal = statRecord.finishTs - statRecord.startTs;
        data.server = serverCost;
        data.responseNetTran = (data.netTotal - data.connect) - data.server;
        data.okHttp = System.currentTimeMillis() - finalStart;
        data.threadSwitch = data.okHttp - data.netTotal;
        data.isConnReused = statRecord.isConnReused;
        data.netEngine = statRecord.netEngine;
        if (statRecord.dnsEndTs < 0 || statRecord.dnsStartTs < 0 || statRecord.connTs < 0 || statRecord.startTs < 0) {
            checkData(data);
        }
        return data;
    }

    private NetStatsData getStatsParams(NetworkStatRecord statRecord, long serverCost, long finalStart) {
        NetStatsData data = new NetStatsData();
        data.dns = statRecord.dnsEndTs - statRecord.dnsStartTs;
        data.connect = statRecord.connTs - statRecord.startTs;
        data.netTotal = statRecord.finishTs - statRecord.startTs;
        data.server = serverCost;
        data.responseNetTran = (data.netTotal - data.connect) - data.server;
        data.okHttp = System.currentTimeMillis() - finalStart;
        data.threadSwitch = data.okHttp - data.netTotal;
        data.isConnReused = statRecord.isConnReused;
        data.netEngine = statRecord.netEngine;
        if (statRecord.dnsEndTs < 0 || statRecord.dnsStartTs < 0 || statRecord.connTs < 0 || statRecord.startTs < 0) {
            checkData(data);
        }
        return data;
    }

    private void checkData(NetStatsData data) {
        if (data != null) {
            if (TextUtils.isEmpty(this.turboNetLog)) {
                data.dns = 0;
                data.connect = 0;
                data.responseNetTran = (data.netTotal - data.connect) - data.server;
                if (data.responseNetTran < 0) {
                    data.responseNetTran = 0;
                    return;
                }
                return;
            }
            try {
                JSONObject timeObj = new JSONObject(this.turboNetLog).optJSONObject("timing");
                if (timeObj != null) {
                    data.dns = timeObj.optLong(DataManager.IPerformanceAbilityProvider.KEY_DNS);
                    data.connect = timeObj.optLong("init_connect");
                    data.responseNetTran = (data.netTotal - data.connect) - data.server;
                    if (data.responseNetTran < 0) {
                        data.responseNetTran = 0;
                    }
                }
            } catch (JSONException e2) {
                data.dns = 0;
                data.connect = 0;
                data.responseNetTran = (data.netTotal - data.connect) - data.server;
                if (data.responseNetTran < 0) {
                    data.responseNetTran = 0;
                }
            }
        }
    }
}
