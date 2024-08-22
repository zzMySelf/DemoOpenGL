package com.baidu.wallet.lightapp.monitor;

import com.baidu.wallet.core.NoProguard;

public class WhiteScreenConfig implements NoProguard {
    public static final Policy a = new Policy(1000, 1, 0.8d);
    public Policy finishPolicy;
    public Policy resumePolicy;
    public Policy startPolicy;
    public int wsc_alive_time = 10;
    public int wsc_area_detect = 9;
    public int wsc_core_cache = 2;
    public int wsc_core_task = 2;
    public int wsc_delay_time = 3000;
    public boolean wsc_enable = false;
    public int wsc_general_detect = 1;
    public int wsc_max_task = 5;
    public int wsc_simple_count = 3;
    public boolean wsc_view_enable = false;
    public int wsc_wait_time = 500;

    public static class Policy implements NoProguard {
        public double backoffMultiplier;
        public int initialDelayMs;
        public int maxNumRetries;

        public Policy() {
        }

        public Policy(int i2, int i3, double d) {
            this.initialDelayMs = i2;
            this.maxNumRetries = i3;
            this.backoffMultiplier = d;
        }
    }

    public WhiteScreenConfig() {
        Policy policy = a;
        this.resumePolicy = policy;
        this.startPolicy = policy;
        this.finishPolicy = policy;
    }

    public boolean isValid() {
        int i2;
        int i3;
        int i4;
        if (this.wsc_delay_time >= 0 && (i2 = this.wsc_core_cache) >= 0 && i2 <= 5 && this.wsc_core_task >= 1 && this.wsc_max_task >= 1 && this.wsc_alive_time > 0 && (i3 = this.wsc_area_detect) > 0 && i3 <= 9 && this.wsc_general_detect >= 0 && (i4 = this.wsc_simple_count) >= 1 && i4 <= 9) {
            return true;
        }
        return false;
    }
}
