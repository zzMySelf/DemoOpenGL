package com.baidu.searchbox.dns;

import java.util.List;

public interface IHttpDnsConfig {
    boolean alternativeServerIp();

    String getAccountId();

    String getBceAccountId();

    String getBceSecret();

    String getBceTag();

    List<String> getHijackIpList();

    String getLabel();

    boolean ipv6ServerPrefer();

    boolean isIdcEnabled();

    boolean localDnsOnlyIfCacheMiss();

    boolean multiDnDisabled();

    boolean needPersistIdcIp();

    boolean useBceHttpDns();
}
