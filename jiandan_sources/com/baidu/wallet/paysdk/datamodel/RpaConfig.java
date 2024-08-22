package com.baidu.wallet.paysdk.datamodel;

import com.baidu.apollon.NoProguard;

public class RpaConfig implements NoProguard {
    public RpaAutomationStrategy[] rpa_automation_strategy;
    public RpaPlaybackStrategy[] rpa_playback_strategy;
    public RpaSenseStrategy[] rpa_sense_strategy;
    public String rpa_type;
    public String rpa_url;

    public static class RpaAutomationStrategy implements NoProguard {
        public String script_name;
        public String script_sha1;
        public String script_url;
        public String script_version;
    }

    public static class RpaPlaybackStrategy implements NoProguard {
    }

    public static class RpaSenseStrategy implements NoProguard {
        public String action;
        public String rpaUrl;
        public String timeInterval;
        public String type;
        public String url;
    }
}
