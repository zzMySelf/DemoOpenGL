package com.baidu.searchbox.network.socketinfo;

public class TCPInfo {
    public int tcpiLost = -1;
    public int tcpiRtt = -1;

    public TCPInfo(int rtt, int lost) {
        this.tcpiRtt = rtt;
        this.tcpiLost = lost;
    }
}
