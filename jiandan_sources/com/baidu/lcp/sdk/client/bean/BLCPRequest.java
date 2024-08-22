package com.baidu.lcp.sdk.client.bean;

public class BLCPRequest {

    /* renamed from: ad  reason: collision with root package name */
    public long f866ad = -1;

    /* renamed from: de  reason: collision with root package name */
    public byte[] f867de = new byte[0];

    /* renamed from: fe  reason: collision with root package name */
    public long f868fe = -1;
    public long qw = -1;

    /* renamed from: rg  reason: collision with root package name */
    public SendTimeoutSecond f869rg = SendTimeoutSecond.TIMEOUT_120s;

    public enum SendTimeoutSecond {
        TIMEOUT_20s,
        TIMEOUT_30s,
        TIMEOUT_50s,
        TIMEOUT_120s
    }
}
