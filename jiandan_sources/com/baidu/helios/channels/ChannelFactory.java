package com.baidu.helios.channels;

import fe.fe.pf.rg.qw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelFactory {
    public Map<String, qw> qw = new HashMap();

    public interface ChannelProvider {
        List<qw> qw();
    }

    public ChannelFactory(ChannelProvider channelProvider) {
        for (qw next : channelProvider.qw()) {
            this.qw.put(next.de(), next);
        }
    }

    public List<qw> qw() {
        return new ArrayList(this.qw.values());
    }
}
