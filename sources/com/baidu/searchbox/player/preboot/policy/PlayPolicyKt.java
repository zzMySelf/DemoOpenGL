package com.baidu.searchbox.player.preboot.policy;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.preboot.env.PolicyScene;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010@\u001a\u0004\u0018\u00010\u00012\u0006\u0010A\u001a\u00020BH\u0000\u001a\u0017\u0010C\u001a\u00020\u0007*\u0004\u0018\u00010Dø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\bE\u001a$\u0010F\u001a\u00020G*\u0004\u0018\u00010H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L\u001a\f\u0010M\u001a\u00020N*\u0004\u0018\u00010N\u001a\f\u0010M\u001a\u00020O*\u0004\u0018\u00010O\u001a\u0018\u0010P\u001a\u0004\u0018\u00010B*\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020SH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0010\u0010?\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006T"}, d2 = {"BUFFER_RANGE_MAX_FIRST", "", "getBUFFER_RANGE_MAX_FIRST", "()[I", "DEFAULT_GR_PLAY_TIME_RATIO", "", "DEFAULT_PER_PREFETCH_MIN_SIZE", "", "DEFAULT_QUICK_ENTER_N", "DEFAULT_QUICK_ENTER_X", "DEFAULT_QUICK_EXIT_N", "DEFAULT_QUICK_EXIT_SERIES_N", "DEFAULT_QUICK_EXIT_SERIES_X", "DEFAULT_QUICK_TYPE", "JSON_KEY_BAND_WIDTH", "", "JSON_KEY_BUFFER_RANGE", "JSON_KEY_BUFFER_WEIGHT", "JSON_KEY_CONDITION", "JSON_KEY_DEPT_RANGE", "JSON_KEY_DEVICE", "JSON_KEY_DURATION", "JSON_KEY_DUR_EXPIRED_CNT", "JSON_KEY_DUR_EXPIRED_TIME", "JSON_KEY_EXPIRED_COUNT", "JSON_KEY_FROM", "JSON_KEY_GLOBAL_CONFIG", "JSON_KEY_GROUP", "JSON_KEY_GROUP_LIST", "JSON_KEY_GR_SCALE_FOR_PREFETCH_BUFFER", "JSON_KEY_GR_SCALE_FOR_RENDER_BUFFER", "JSON_KEY_PAGE", "JSON_KEY_PER_PREFETCH_MIN_SIZE", "JSON_KEY_PLAY_BUFFER", "JSON_KEY_PLAY_CONFIG", "JSON_KEY_PLAY_ON_FLING", "JSON_KEY_PLAY_ON_FLING_ENABLE", "JSON_KEY_PLAY_ON_FLING_SCROLL_TIME", "JSON_KEY_PLAY_ON_FLING_SPEED", "JSON_KEY_PREBOOT_TYPE", "JSON_KEY_PREDICT_EXPIRED_CNT", "JSON_KEY_PREDICT_EXPIRED_TIME", "JSON_KEY_PREFETCH_BUFFER", "JSON_KEY_PREFETCH_BUFFER_RANGE", "JSON_KEY_PREFETCH_CNT", "JSON_KEY_PREFETCH_PERCENT", "JSON_KEY_PREFETCH_START_DEPTH", "JSON_KEY_PRERENDER_BUFFER", "JSON_KEY_QUICK_ENTER_N", "JSON_KEY_QUICK_ENTER_X", "JSON_KEY_QUICK_EXIT_N", "JSON_KEY_QUICK_EXIT_SERIES_N", "JSON_KEY_QUICK_EXIT_SERIES_X", "JSON_KEY_QUICK_EXIT_TYPE", "JSON_KEY_RECORD_TIME", "JSON_KEY_RELATIVE_INTENT_RANGE", "JSON_KEY_RENDER_BUFFER_RANGE", "JSON_KEY_RESOURCE", "JSON_KEY_SOURCE", "JSON_KEY_SUB_SOURCE", "JSON_KEY_USER", "POLICY_OTHER_DEFAULT_VALUE", "POLICY_PREFETCH_BUFFER_DEFAULT_VALUE", "POLICY_PREFETCH_CNT_DEFAULT_VALUE", "bufferMuxer", "config", "Lcom/baidu/searchbox/player/preboot/policy/BufferConfig;", "getLevel", "Lcom/baidu/searchbox/player/preboot/policy/NetLevel;", "getLevel-l28qxAQ", "isMatch", "", "Lcom/baidu/searchbox/player/preboot/policy/IPolicy;", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "scene", "Lcom/baidu/searchbox/player/preboot/env/PolicyScene;", "orDefault", "Lcom/baidu/searchbox/player/preboot/policy/SlideMode;", "Lcom/baidu/searchbox/player/preboot/policy/SpeedLevel;", "toBufferConfig", "Lorg/json/JSONObject;", "type", "Lcom/baidu/searchbox/player/preboot/policy/BufferStrategyType;", "preboot_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayPolicy.kt */
public final class PlayPolicyKt {
    private static final int[] BUFFER_RANGE_MAX_FIRST = {2, 6, 10};
    public static final float DEFAULT_GR_PLAY_TIME_RATIO = 180.0f;
    public static final int DEFAULT_PER_PREFETCH_MIN_SIZE = 3;
    public static final int DEFAULT_QUICK_ENTER_N = 3000;
    public static final int DEFAULT_QUICK_ENTER_X = 2;
    public static final int DEFAULT_QUICK_EXIT_N = 5000;
    public static final int DEFAULT_QUICK_EXIT_SERIES_N = 5000;
    public static final int DEFAULT_QUICK_EXIT_SERIES_X = 2;
    public static final int DEFAULT_QUICK_TYPE = 1;
    public static final String JSON_KEY_BAND_WIDTH = "bandwidth";
    public static final String JSON_KEY_BUFFER_RANGE = "bufferRange";
    public static final String JSON_KEY_BUFFER_WEIGHT = "weight";
    public static final String JSON_KEY_CONDITION = "condition";
    public static final String JSON_KEY_DEPT_RANGE = "deptRange";
    public static final String JSON_KEY_DEVICE = "device";
    public static final String JSON_KEY_DURATION = "duration";
    public static final String JSON_KEY_DUR_EXPIRED_CNT = "durExpiredCnt";
    public static final String JSON_KEY_DUR_EXPIRED_TIME = "durExpiredTime";
    public static final String JSON_KEY_EXPIRED_COUNT = "expired_count";
    public static final String JSON_KEY_FROM = "from";
    public static final String JSON_KEY_GLOBAL_CONFIG = "config";
    public static final String JSON_KEY_GROUP = "group";
    public static final String JSON_KEY_GROUP_LIST = "group_list";
    public static final String JSON_KEY_GR_SCALE_FOR_PREFETCH_BUFFER = "prefetchBufferScale";
    public static final String JSON_KEY_GR_SCALE_FOR_RENDER_BUFFER = "renderBufferScale";
    public static final String JSON_KEY_PAGE = "page";
    public static final String JSON_KEY_PER_PREFETCH_MIN_SIZE = "perPrefetchMinSize";
    public static final String JSON_KEY_PLAY_BUFFER = "playBuffer";
    public static final String JSON_KEY_PLAY_CONFIG = "result";
    public static final String JSON_KEY_PLAY_ON_FLING = "playOnFling";
    public static final String JSON_KEY_PLAY_ON_FLING_ENABLE = "enable";
    public static final String JSON_KEY_PLAY_ON_FLING_SCROLL_TIME = "scrollTime";
    public static final String JSON_KEY_PLAY_ON_FLING_SPEED = "speed";
    public static final String JSON_KEY_PREBOOT_TYPE = "prebootType";
    public static final String JSON_KEY_PREDICT_EXPIRED_CNT = "predictExpiredCnt";
    public static final String JSON_KEY_PREDICT_EXPIRED_TIME = "predictExpiredTime";
    public static final String JSON_KEY_PREFETCH_BUFFER = "prefetchBuffer";
    public static final String JSON_KEY_PREFETCH_BUFFER_RANGE = "prefetchBufferRange";
    public static final String JSON_KEY_PREFETCH_CNT = "prefetchCnt";
    public static final String JSON_KEY_PREFETCH_PERCENT = "prefetchPercent";
    public static final String JSON_KEY_PREFETCH_START_DEPTH = "prefetchStartDepth";
    public static final String JSON_KEY_PRERENDER_BUFFER = "prerenderBuffer";
    public static final String JSON_KEY_QUICK_ENTER_N = "quickEnterN";
    public static final String JSON_KEY_QUICK_ENTER_X = "quickEnterX";
    public static final String JSON_KEY_QUICK_EXIT_N = "quickExitN";
    public static final String JSON_KEY_QUICK_EXIT_SERIES_N = "quickExitSeriesN";
    public static final String JSON_KEY_QUICK_EXIT_SERIES_X = "quickExitSeriesX";
    public static final String JSON_KEY_QUICK_EXIT_TYPE = "quickExitType";
    public static final String JSON_KEY_RECORD_TIME = "record_time";
    public static final String JSON_KEY_RELATIVE_INTENT_RANGE = "relativeDeptRange";
    public static final String JSON_KEY_RENDER_BUFFER_RANGE = "renderBufferRange";
    public static final String JSON_KEY_RESOURCE = "resource";
    public static final String JSON_KEY_SOURCE = "source";
    public static final String JSON_KEY_SUB_SOURCE = "subSource";
    public static final String JSON_KEY_USER = "user";
    public static final String POLICY_OTHER_DEFAULT_VALUE = "other";
    public static final int POLICY_PREFETCH_BUFFER_DEFAULT_VALUE = 5;
    @StableApi
    public static final int POLICY_PREFETCH_CNT_DEFAULT_VALUE = 2;

    public static final int[] getBUFFER_RANGE_MAX_FIRST() {
        return BUFFER_RANGE_MAX_FIRST;
    }

    public static final int[] bufferMuxer(BufferConfig config) {
        Object obj;
        Intrinsics.checkNotNullParameter(config, "config");
        Ref.ObjectRef result = new Ref.ObjectRef();
        try {
            Result.Companion companion = Result.Companion;
            ArrayList<String> bufferRange$preboot_release = config.getBufferRange$preboot_release();
            if (bufferRange$preboot_release != null) {
                Iterable<String> $this$map$iv = bufferRange$preboot_release;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (String value : $this$map$iv) {
                    destination$iv$iv.add(Integer.valueOf((int) (((double) Integer.parseInt(value)) * config.getWeight())));
                }
                obj = CollectionsKt.toIntArray((List) destination$iv$iv);
            } else {
                obj = null;
            }
            result.element = obj;
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        return (int[]) result.element;
    }

    public static final BufferConfig toBufferConfig(JSONObject $this$toBufferConfig, BufferStrategyType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if ($this$toBufferConfig == null) {
            return null;
        }
        try {
            return new BufferConfig(type, PlayPolicyParserKt.toStringList($this$toBufferConfig.optString(JSON_KEY_BUFFER_RANGE)), $this$toBufferConfig.optDouble("weight", 1.0d), (Function1) null, 8, (DefaultConstructorMarker) null);
        } catch (Exception e2) {
            BufferConfig bufferConfig = null;
            return null;
        }
    }

    public static /* synthetic */ boolean isMatch$default(IPolicy iPolicy, BasicVideoSeries basicVideoSeries, PolicyScene policyScene, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            basicVideoSeries = null;
        }
        if ((i2 & 2) != 0) {
            policyScene = null;
        }
        return isMatch(iPolicy, basicVideoSeries, policyScene);
    }

    public static final boolean isMatch(IPolicy $this$isMatch, BasicVideoSeries series, PolicyScene scene) {
        return $this$isMatch == null || $this$isMatch.match(series, scene);
    }

    /* renamed from: getLevel-l28qxAQ  reason: not valid java name */
    public static final int m2391getLevell28qxAQ(NetLevel $this$getLevel_u2dl28qxAQ) {
        if ($this$getLevel_u2dl28qxAQ != null) {
            return $this$getLevel_u2dl28qxAQ.m2390unboximpl();
        }
        return 0;
    }

    public static final SpeedLevel orDefault(SpeedLevel $this$orDefault) {
        return $this$orDefault == null ? SpeedLevel.NONE_SPEED : $this$orDefault;
    }

    public static final SlideMode orDefault(SlideMode $this$orDefault) {
        return $this$orDefault == null ? SlideMode.NONE_SLIDE : $this$orDefault;
    }
}
