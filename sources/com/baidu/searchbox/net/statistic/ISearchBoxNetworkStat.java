package com.baidu.searchbox.net.statistic;

import com.baidu.searchbox.dns.DnsParseResult;
import com.baidu.searchbox.http.statistics.NetworkStat;

public interface ISearchBoxNetworkStat<T> extends NetworkStat<T> {
    void onDnsParse(T t, long j2, long j3, DnsParseResult dnsParseResult);
}
