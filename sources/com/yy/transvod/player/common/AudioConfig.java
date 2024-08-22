package com.yy.transvod.player.common;

import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;

public class AudioConfig {
    public int audioCodec = 0;

    AudioConfig() {
    }

    public String toString() {
        return "VideoConfig [audioCodec=" + this.audioCodec + RhetoricalTagUtilKt.TAG_END_SYMBOL;
    }
}
