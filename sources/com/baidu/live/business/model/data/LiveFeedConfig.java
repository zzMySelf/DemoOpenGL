package com.baidu.live.business.model.data;

import android.text.TextUtils;
import com.baidu.live.business.util.LiveFeedPreferenceUtils;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveFeedConfig {
    public static final String LIVE_FEED_PAGE_CONFIG_CACHE_KEY = "live_feed_page_config_cache_key";
    public AbSwitchConfig abSwitchConfig;
    private int followShowNum;
    public boolean footprintSwitch;
    public String footprintUrl;
    public InterestInsert interestInsert;
    public String minorUfoUrl;
    public PlayConfig playConfig;
    public boolean searchIsOpen;
    public String startLiveScheme;
    public long timeoutRefreshTime;

    public void parserJson(JSONObject config, boolean isPageInit, boolean isLiveChannel) {
        JSONObject jSONObject = config;
        boolean z = false;
        if (jSONObject != null) {
            this.startLiveScheme = jSONObject.optString("start_live_scheme");
            this.timeoutRefreshTime = jSONObject.optLong("timeout_refresh_time");
            if (jSONObject.optInt("feed_search_switch") == 1) {
                z = true;
            }
            this.searchIsOpen = z;
            this.playConfig = PlayConfig.parserJson(jSONObject.optJSONObject("auto_play"));
            this.abSwitchConfig = AbSwitchConfig.parserJson(jSONObject.optJSONObject("ab_switch"));
            this.interestInsert = InterestInsert.parserJson(jSONObject.optJSONObject("interest_insert"));
            this.footprintSwitch = jSONObject.optString("watch_history_switch").equals("1");
            this.footprintUrl = jSONObject.optString("watch_history_url");
            this.followShowNum = jSONObject.optInt(BDCommentStatisticHelper.UBC_COMMENT_FOLLOW_BUTTON_SHOW_KEY);
            JSONObject userMinorConf = jSONObject.optJSONObject("user_minor_conf");
            if (userMinorConf != null) {
                this.minorUfoUrl = userMinorConf.optString("ufo_url");
            }
            if (isPageInit && isLiveChannel) {
                LiveFeedPreferenceUtils.putString(LIVE_FEED_PAGE_CONFIG_CACHE_KEY, config.toString());
            }
        } else if (isPageInit && isLiveChannel) {
            String configCache = LiveFeedPreferenceUtils.getString(LIVE_FEED_PAGE_CONFIG_CACHE_KEY, "");
            if (!TextUtils.isEmpty(configCache)) {
                try {
                    JSONObject configJson = new JSONObject(configCache);
                    this.startLiveScheme = configJson.optString("start_live_scheme");
                    this.timeoutRefreshTime = configJson.optLong("timeout_refresh_time");
                    if (configJson.optInt("feed_search_switch") == 1) {
                        z = true;
                    }
                    this.searchIsOpen = z;
                    this.playConfig = PlayConfig.parserJson(configJson.optJSONObject("auto_play"));
                    this.abSwitchConfig = AbSwitchConfig.parserJson(configJson.optJSONObject("ab_switch"));
                    this.followShowNum = configJson.optInt(BDCommentStatisticHelper.UBC_COMMENT_FOLLOW_BUTTON_SHOW_KEY);
                    JSONObject userMinorConf2 = configJson.optJSONObject("user_minor_conf");
                    if (userMinorConf2 != null) {
                        this.minorUfoUrl = userMinorConf2.optString("ufo_url");
                    }
                } catch (JSONException e2) {
                    LiveFeedPreferenceUtils.removeKey(LIVE_FEED_PAGE_CONFIG_CACHE_KEY);
                }
            }
        }
    }

    public int getFollowShowNum() {
        if (this.followShowNum <= 0) {
            this.followShowNum = 20;
        }
        return this.followShowNum;
    }

    public boolean supportPlay() {
        PlayConfig playConfig2 = this.playConfig;
        if (playConfig2 != null) {
            return playConfig2.enable;
        }
        return false;
    }

    public boolean isHitNewFeedAbTest() {
        AbSwitchConfig abSwitchConfig2 = this.abSwitchConfig;
        if (abSwitchConfig2 != null) {
            return abSwitchConfig2.newFeed;
        }
        return false;
    }

    public boolean isHitNewFollowAbTest() {
        AbSwitchConfig abSwitchConfig2 = this.abSwitchConfig;
        if (abSwitchConfig2 != null) {
            return abSwitchConfig2.newFollow;
        }
        return false;
    }

    public static class PlayConfig {
        public boolean enable;
        public int maxPlayCount;

        public static PlayConfig parserJson(JSONObject config) {
            if (config == null) {
                return null;
            }
            PlayConfig playConfig = new PlayConfig();
            boolean z = true;
            if (config.optInt("enable") != 1) {
                z = false;
            }
            playConfig.enable = z;
            playConfig.maxPlayCount = config.optInt("max_auto_play_count");
            return playConfig;
        }
    }

    public static class AbSwitchConfig {
        public boolean newBanner;
        public boolean newFeed;
        public boolean newFollow;
        public boolean newTab;
        public boolean otherNewStyle;

        public static AbSwitchConfig parserJson(JSONObject config) {
            if (config == null) {
                return null;
            }
            AbSwitchConfig abSwitchConfig = new AbSwitchConfig();
            boolean z = false;
            abSwitchConfig.newBanner = config.optInt("banner") == 1;
            abSwitchConfig.newTab = config.optInt("tab") == 1;
            abSwitchConfig.otherNewStyle = config.optInt("other") == 1;
            abSwitchConfig.newFeed = config.optInt("new_feed") == 1;
            if (config.optInt("new_follow") == 1) {
                z = true;
            }
            abSwitchConfig.newFollow = z;
            return abSwitchConfig;
        }
    }

    public static class InterestInsert {
        public int duration;
        public int frequency;
        public JSONArray tab;

        public static InterestInsert parserJson(JSONObject config) {
            if (config == null) {
                return null;
            }
            InterestInsert interestInsert = new InterestInsert();
            interestInsert.duration = config.optInt("duration");
            interestInsert.frequency = config.optInt("frequency");
            interestInsert.tab = config.optJSONArray("tab");
            return interestInsert;
        }
    }
}
