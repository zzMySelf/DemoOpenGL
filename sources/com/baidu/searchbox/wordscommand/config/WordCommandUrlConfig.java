package com.baidu.searchbox.wordscommand.config;

import com.baidu.searchbox.config.HostConfig;

public class WordCommandUrlConfig {

    public interface TopicBusinessIndexStat {

        public interface BasicFun {
            public static final int TOPIC = 10;

            public interface SubFrom {
                public static final int WORDCOMMAND = 1009;
            }
        }
    }

    public static String getWordCommandRegexUrl() {
        return String.format("%s/cmptoken/getconfig", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getWordCommandTokenUrl() {
        return String.format("%s/cmptoken/gettoken", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getWordCommandContentUrl() {
        return String.format("%s/cmptoken/getscheme", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }
}
