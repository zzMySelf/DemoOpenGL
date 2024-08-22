package com.baidu.searchbox.player.utils;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.ConcurrentMapBundle;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u0012\u0010\u000b\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u000e\u0010\f\u001a\u00020\u0001*\u0004\u0018\u00010\rH\u0007\u001a\u000e\u0010\u000e\u001a\u00020\u0001*\u0004\u0018\u00010\rH\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"DEFAULT_CTR_VALUE", "", "DEFAULT_DUR_BIAS_VALUE", "DNN_Q", "", "DUR_BIAS", "EXTRA_KEY_CTR_VALUE", "EXTRA_KEY_DUR_BIAS_VALUE", "GR_EXT", "parseCtrValue", "extLog", "parseDurBiasValue", "getCtr", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "getDurBias", "logW", "", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "log", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExtLogUtil.kt */
public final class ExtLogUtil {
    public static final float DEFAULT_CTR_VALUE = 1.0f;
    public static final float DEFAULT_DUR_BIAS_VALUE = 0.0f;
    private static final String DNN_Q = "dnn_q";
    private static final String DUR_BIAS = "dur_bias";
    private static final String EXTRA_KEY_CTR_VALUE = "EXTRA_KEY_CTR_VALUE";
    private static final String EXTRA_KEY_DUR_BIAS_VALUE = "EXTRA_KEY_DUR_BIAS_VALUE";
    private static final String GR_EXT = "gr_ext";

    @StableApi
    public static final float getCtr(BasicVideoSeries $this$getCtr) {
        Object obj;
        if ($this$getCtr == null) {
            return 1.0f;
        }
        Object defaultValue$iv = Float.valueOf(1.0f);
        ConcurrentMapBundle this_$iv$iv = $this$getCtr.getExtMap();
        Object $this$toValue$iv$iv$iv = this_$iv$iv.get((Object) EXTRA_KEY_CTR_VALUE);
        ConcurrentMapBundle concurrentMapBundle = this_$iv$iv;
        if ($this$toValue$iv$iv$iv instanceof Float) {
            obj = $this$toValue$iv$iv$iv;
        } else {
            obj = defaultValue$iv;
        }
        float ctr = ((Number) obj).floatValue();
        if (!(ctr == 1.0f)) {
            return ctr;
        }
        float ctr2 = parseCtrValue($this$getCtr.getExtLog());
        $this$getCtr.set(EXTRA_KEY_CTR_VALUE, Float.valueOf(ctr2));
        return ctr2;
    }

    private static final float parseCtrValue(String extLog) {
        if (extLog != null) {
            String $this$parseCtrValue_u24lambda_u2d0 = extLog;
            boolean z = true;
            if ($this$parseCtrValue_u24lambda_u2d0.length() > 0) {
                try {
                    JSONObject optJSONObject = new JSONObject($this$parseCtrValue_u24lambda_u2d0).optJSONObject("gr_ext");
                    String ctr = optJSONObject != null ? optJSONObject.optString(DNN_Q) : null;
                    Object fallback$iv = Float.valueOf(1.0f);
                    String $this$toValueSafe$iv = ctr;
                    CharSequence charSequence = $this$toValueSafe$iv;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        try {
                            fallback$iv = fallback$iv instanceof Integer ? (Float) Integer.valueOf(Integer.parseInt($this$toValueSafe$iv)) : fallback$iv instanceof Double ? (Float) Double.valueOf(Double.parseDouble($this$toValueSafe$iv)) : fallback$iv instanceof Long ? (Float) Long.valueOf(Long.parseLong($this$toValueSafe$iv)) : Float.valueOf(Float.parseFloat($this$toValueSafe$iv));
                        } catch (NumberFormatException exception$iv) {
                            BdVideoLog.e("string to target value, catch exception:", (Throwable) exception$iv);
                        }
                    }
                    return ((Number) fallback$iv).floatValue();
                } catch (JSONException e2) {
                    BdVideoLog.d(e2.getMessage());
                }
            }
        }
        return 1.0f;
    }

    @StableApi
    public static final float getDurBias(BasicVideoSeries $this$getDurBias) {
        Object obj;
        if ($this$getDurBias == null) {
            return 0.0f;
        }
        Object defaultValue$iv = Float.valueOf(0.0f);
        ConcurrentMapBundle this_$iv$iv = $this$getDurBias.getExtMap();
        Object $this$toValue$iv$iv$iv = this_$iv$iv.get((Object) EXTRA_KEY_DUR_BIAS_VALUE);
        ConcurrentMapBundle concurrentMapBundle = this_$iv$iv;
        if ($this$toValue$iv$iv$iv instanceof Float) {
            obj = $this$toValue$iv$iv$iv;
        } else {
            obj = defaultValue$iv;
        }
        float durBias = ((Number) obj).floatValue();
        if (!(durBias == 0.0f)) {
            return durBias;
        }
        float durBias2 = parseDurBiasValue($this$getDurBias.getExtLog());
        $this$getDurBias.set(EXTRA_KEY_DUR_BIAS_VALUE, Float.valueOf(durBias2));
        return durBias2;
    }

    private static final float parseDurBiasValue(String extLog) {
        if (extLog != null) {
            String $this$parseDurBiasValue_u24lambda_u2d1 = extLog;
            boolean z = true;
            if ($this$parseDurBiasValue_u24lambda_u2d1.length() > 0) {
                try {
                    JSONObject optJSONObject = new JSONObject($this$parseDurBiasValue_u24lambda_u2d1).optJSONObject("gr_ext");
                    String durBias = optJSONObject != null ? optJSONObject.optString(DUR_BIAS) : null;
                    Object fallback$iv = Float.valueOf(0.0f);
                    String $this$toValueSafe$iv = durBias;
                    CharSequence charSequence = $this$toValueSafe$iv;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        try {
                            fallback$iv = fallback$iv instanceof Integer ? (Float) Integer.valueOf(Integer.parseInt($this$toValueSafe$iv)) : fallback$iv instanceof Double ? (Float) Double.valueOf(Double.parseDouble($this$toValueSafe$iv)) : fallback$iv instanceof Long ? (Float) Long.valueOf(Long.parseLong($this$toValueSafe$iv)) : Float.valueOf(Float.parseFloat($this$toValueSafe$iv));
                        } catch (NumberFormatException exception$iv) {
                            BdVideoLog.e("string to target value, catch exception:", (Throwable) exception$iv);
                        }
                    }
                    return ((Number) fallback$iv).floatValue();
                } catch (JSONException e2) {
                    BdVideoLog.d(e2.getMessage());
                }
            }
        }
        return 0.0f;
    }

    public static final void logW(AbsPlugin $this$logW, String log) {
        Intrinsics.checkNotNullParameter($this$logW, "<this>");
        if (log != null) {
            String it = log;
            BDVideoPlayer bindPlayer = $this$logW.getBindPlayer();
            BdVideoLog.w(bindPlayer != null ? bindPlayer.wrapMessage(it) : null);
        }
    }
}
