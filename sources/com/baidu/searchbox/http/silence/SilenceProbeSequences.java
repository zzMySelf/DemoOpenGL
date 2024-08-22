package com.baidu.searchbox.http.silence;

import android.content.Context;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.searchbox.http.silence.SilenceProbeResult;
import com.baidu.searchbox.network.ioc.NetCheckRuntime;
import java.util.ArrayList;
import java.util.List;

class SilenceProbeSequences {
    private Context mContext;
    private List<Protocols> mList;
    private SilenceProbeResult mSilenceProbeResult;

    public SilenceProbeSequences(String url, String ip, List<Integer> list, Context context, int tcpPort) {
        this.mContext = context;
        this.mList = new ArrayList(list.size());
        for (Integer id : list) {
            this.mList.add(new Protocols(url, ip, id.intValue(), tcpPort));
        }
        this.mSilenceProbeResult = new SilenceProbeResult();
        SilenceProbeResult.BasicBean basicBean = new SilenceProbeResult.BasicBean();
        basicBean.setUrl(url);
        basicBean.setRemoteIP(ip);
        basicBean.setClientIP(HttpManager.getClientIP());
        basicBean.setHttpDnsAreaInfo(DnsHelper.getAreaInfo());
        basicBean.setNetworkQuality(NetworkQuality.getNetworkQuality());
        basicBean.setNetType(ConnectManager.getNetworkInfo(this.mContext));
        basicBean.setSimCardFree(NetCheckRuntime.getNetCheckContext().getSimcardInfo());
        basicBean.setIpStack(DnsUtil.stackType);
        this.mSilenceProbeResult.setBasic(basicBean);
        this.mSilenceProbeResult.setTask(new ArrayList());
    }

    public synchronized SilenceProbeResult syncFinishAllTaskInQueue(int probeType) {
        try {
            for (Protocols protocol : this.mList) {
                SilenceProbeResult.TaskBean bean = SilenceProbeMethodCreator.getInstance().tryToProbe(protocol, this.mContext);
                this.mSilenceProbeResult.getTask().add(bean);
                if (probeType != 1 || !bean.isSuccess()) {
                }
            }
        } catch (Exception e2) {
        }
        return this.mSilenceProbeResult;
    }

    private static class SilenceProbeMethodCreator {
        private static SilenceProbeMethodCreator sSilenceProbeMethodCreater;
        private ISilenceProbeMethodFactory factory = new SilenceProbeMethodFactory();

        private SilenceProbeMethodCreator() {
        }

        public static SilenceProbeMethodCreator getInstance() {
            if (sSilenceProbeMethodCreater == null) {
                synchronized (SilenceProbeMethodCreator.class) {
                    if (sSilenceProbeMethodCreater == null) {
                        sSilenceProbeMethodCreater = new SilenceProbeMethodCreator();
                    }
                }
            }
            return sSilenceProbeMethodCreater;
        }

        public SilenceProbeResult.TaskBean tryToProbe(Protocols currentProtocol, Context context) {
            return this.factory.createSilenceProMethodProduct(currentProtocol.protocolId).syncProbe(currentProtocol.url, currentProtocol.ip, currentProtocol.method, context, currentProtocol.tcpPort);
        }
    }
}
