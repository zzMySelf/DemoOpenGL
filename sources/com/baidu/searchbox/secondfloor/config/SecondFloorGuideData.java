package com.baidu.searchbox.secondfloor.config;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00002\b\u0010$\u001a\u0004\u0018\u00010%R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001c\u0010 \u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e¨\u0006("}, d2 = {"Lcom/baidu/searchbox/secondfloor/config/SecondFloorGuideData;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "hardGuide", "Lcom/baidu/searchbox/secondfloor/config/SecondFloorGuideData$GuideDataItem;", "getHardGuide", "()Lcom/baidu/searchbox/secondfloor/config/SecondFloorGuideData$GuideDataItem;", "setHardGuide", "(Lcom/baidu/searchbox/secondfloor/config/SecondFloorGuideData$GuideDataItem;)V", "interval", "", "getInterval", "()I", "setInterval", "(I)V", "isQuit", "", "()Z", "setQuit", "(Z)V", "startTime", "getStartTime", "setStartTime", "times", "getTimes", "setTimes", "weakGuide", "getWeakGuide", "setWeakGuide", "parseGuideData", "config", "Lorg/json/JSONObject;", "Companion", "GuideDataItem", "lib-secondfloor-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondFloorGuideData.kt */
public final class SecondFloorGuideData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DURATION_KEY = "duration";
    private static final String END_TIME_KEY = "end_time";
    private static final String HARD_KEY = "hard";
    public static final long INTERVAL_CONVERSION = 3600000;
    public static final int INTERVAL_DEFAULT = 0;
    private static final String INTERVAL_KEY = "interval";
    private static final String IS_QUIT_KEY = "is_quit";
    private static final String START_TIME_KEY = "start_time";
    private static final String TEXT_COLOR_KEY = "text_color";
    private static final String TEXT_COLOR_NIGHT_KEY = "text_color_dn";
    private static final String TEXT_KEY = "text";
    public static final int TIMES_DEFAULT = 0;
    private static final String TIMES_KEY = "times";
    public static final long TIME_DEFAULT = -1;
    private static final String WEAK_KEY = "weak";
    private long endTime = -1;
    private GuideDataItem hardGuide;
    private int interval;
    private boolean isQuit;
    private long startTime = -1;
    private int times;
    private GuideDataItem weakGuide;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/secondfloor/config/SecondFloorGuideData$Companion;", "", "()V", "DURATION_KEY", "", "END_TIME_KEY", "HARD_KEY", "INTERVAL_CONVERSION", "", "INTERVAL_DEFAULT", "", "INTERVAL_KEY", "IS_QUIT_KEY", "START_TIME_KEY", "TEXT_COLOR_KEY", "TEXT_COLOR_NIGHT_KEY", "TEXT_KEY", "TIMES_DEFAULT", "TIMES_KEY", "TIME_DEFAULT", "WEAK_KEY", "lib-secondfloor-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecondFloorGuideData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j2) {
        this.startTime = j2;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j2) {
        this.endTime = j2;
    }

    public final int getTimes() {
        return this.times;
    }

    public final void setTimes(int i2) {
        this.times = i2;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final void setInterval(int i2) {
        this.interval = i2;
    }

    public final boolean isQuit() {
        return this.isQuit;
    }

    public final void setQuit(boolean z) {
        this.isQuit = z;
    }

    public final GuideDataItem getHardGuide() {
        return this.hardGuide;
    }

    public final void setHardGuide(GuideDataItem guideDataItem) {
        this.hardGuide = guideDataItem;
    }

    public final GuideDataItem getWeakGuide() {
        return this.weakGuide;
    }

    public final void setWeakGuide(GuideDataItem guideDataItem) {
        this.weakGuide = guideDataItem;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/secondfloor/config/SecondFloorGuideData$GuideDataItem;", "", "()V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "textColorNight", "getTextColorNight", "setTextColorNight", "parseItem", "config", "Lorg/json/JSONObject;", "lib-secondfloor-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecondFloorGuideData.kt */
    public static final class GuideDataItem {
        private long duration = -1;
        private String text;
        private String textColor;
        private String textColorNight;

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public final void setTextColor(String str) {
            this.textColor = str;
        }

        public final String getTextColorNight() {
            return this.textColorNight;
        }

        public final void setTextColorNight(String str) {
            this.textColorNight = str;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final void setDuration(long j2) {
            this.duration = j2;
        }

        public final GuideDataItem parseItem(JSONObject config) {
            if (config == null) {
                return null;
            }
            try {
                this.text = config.optString("text");
                this.textColor = config.optString("text_color");
                this.textColorNight = config.optString(SecondFloorGuideData.TEXT_COLOR_NIGHT_KEY);
                this.duration = config.optLong("duration");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this;
        }
    }

    public final SecondFloorGuideData parseGuideData(JSONObject config) {
        if (config == null) {
            return null;
        }
        try {
            this.times = config.optInt("times");
            this.interval = config.optInt("interval");
            boolean z = true;
            if (config.optInt(IS_QUIT_KEY) != 1) {
                z = false;
            }
            this.isQuit = z;
            String optString = config.optString("start_time");
            Intrinsics.checkNotNullExpressionValue(optString, "config.optString(START_TIME_KEY)");
            this.startTime = Long.parseLong(optString);
            String optString2 = config.optString("end_time");
            Intrinsics.checkNotNullExpressionValue(optString2, "config.optString(END_TIME_KEY)");
            this.endTime = Long.parseLong(optString2);
            JSONObject hardObj = config.optJSONObject(HARD_KEY);
            if (hardObj != null) {
                this.hardGuide = new GuideDataItem().parseItem(hardObj);
            }
            JSONObject weakObj = config.optJSONObject("weak");
            if (weakObj != null) {
                this.weakGuide = new GuideDataItem().parseItem(weakObj);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }
}
