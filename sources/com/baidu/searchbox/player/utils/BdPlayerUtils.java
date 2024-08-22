package com.baidu.searchbox.player.utils;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.block.BlockUpdateListener;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.searchbox.player.model.FloatRange;
import com.baidu.searchbox.player.model.IntRange;
import com.baidu.searchbox.player.model.StringArrayBundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000´\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a(\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0007\u001a\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0012H\u0007\u001a\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\u0007\u001a\u001c\u0010\u001c\u001a\u00020\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0001H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u001eH\u0007\u001a\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007\u001a&\u0010#\u001a\u00020 *\u0012\u0012\u0004\u0012\u00020\u00030$j\b\u0012\u0004\u0012\u00020\u0003`%2\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0007\u001a1\u0010'\u001a\u00020 \"\u0004\b\u0000\u0010\u0016*\u0012\u0012\u0004\u0012\u0002H\u00160$j\b\u0012\u0004\u0012\u0002H\u0016`%2\b\u0010&\u001a\u0004\u0018\u0001H\u0016H\u0007¢\u0006\u0002\u0010(\u001a\u0018\u0010)\u001a\u00020\u000b*\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0007\u001a\u0016\u0010+\u001a\u00020\u0001*\u0004\u0018\u00010\"2\u0006\u0010,\u001a\u00020\u0019H\u0007\u001a\u0018\u0010-\u001a\u00020\u0019*\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u00020\u0019H\u0007\u001a$\u00100\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0002012\u0006\u00102\u001a\u00020\u0001H\b¢\u0006\u0002\u00103\u001a0\u00104\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u0001052\b\u00102\u001a\u0004\u0018\u00010\u00032\u0006\u0010/\u001a\u0002H\u0016H\b¢\u0006\u0002\u00106\u001a\u000e\u00107\u001a\u00020\u0001*\u0004\u0018\u00010\u000eH\u0007\u001a(\u00108\u001a\u00020\u0003*\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`%2\u0006\u00109\u001a\u00020\u0001H\u0007\u001a\u000e\u0010:\u001a\u00020\u0001*\u0004\u0018\u00010\u000eH\u0007\u001a\u000e\u0010;\u001a\u00020\u0019*\u0004\u0018\u00010\u000eH\u0007\u001a\u001d\u0010<\u001a\u00020\u000b*\u0004\u0018\u00010=\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u0010\u0010>\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u000105H\u0007\u001a\u0013\u0010?\u001a\u00020\u000b*\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010@\u001a\u0013\u0010A\u001a\u00020\u000b*\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010@\u001a\u0013\u0010B\u001a\u00020C*\u0004\u0018\u00010CH\u0007¢\u0006\u0002\u0010D\u001a\u0013\u0010B\u001a\u00020\u0019*\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010E\u001a\u0013\u0010B\u001a\u00020\u0001*\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010F\u001a\u0013\u0010B\u001a\u00020\u001e*\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010G\u001a\u000e\u0010H\u001a\u00020 *\u0004\u0018\u00010\"H\u0007\u001a/\u0010I\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u0016*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00160J2\b\u00102\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010K\u001a/\u0010L\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u0016*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00160J2\b\u00102\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010K\u001a\u0016\u0010M\u001a\u00020 *\u0004\u0018\u00010.2\u0006\u0010N\u001a\u00020\u0019H\u0007\u001a\"\u0010O\u001a\u00020 *\u0004\u0018\u0001052\b\u00102\u001a\u0004\u0018\u00010\u00032\b\u0010&\u001a\u0004\u0018\u00010PH\u0007\u001a\u000e\u0010Q\u001a\u00020 *\u0004\u0018\u00010.H\u0007\u001a\u0016\u0010R\u001a\u00020 *\u0004\u0018\u00010\u000e2\u0006\u0010S\u001a\u00020\u0001H\u0007\u001a\u0016\u0010T\u001a\u00020 *\u0004\u0018\u00010\u000e2\u0006\u0010U\u001a\u00020\u0019H\u0007\u001a\u001f\u0010V\u001a\u00020 *\u0004\u0018\u00010\u000b2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020 0\u0012¢\u0006\u0002\u0010X\u001a\u0010\u0010Y\u001a\u0004\u0018\u00010Z*\u0004\u0018\u00010\u0003H\u0007\u001a\u0010\u0010[\u001a\u0004\u0018\u00010\\*\u0004\u0018\u00010\u0003H\u0007\u001a\f\u0010]\u001a\u00020\u0003*\u00020\u0001H\u0007\u001a$\u0010^\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u0002H\u0016H\b¢\u0006\u0002\u0010_\u001a\u001c\u0010`\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020aH\b¢\u0006\u0002\u0010b\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006XT¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"MSG_CONTROL_AUTO_HIDE", "", "getStageType", "", "player", "Lcom/baidu/searchbox/player/BDVideoPlayer;", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "getTextWithSecond", "second", "hours", "", "handleVolumeKeyDown", "context", "Landroid/content/Context;", "event", "Landroid/view/KeyEvent;", "block", "Lkotlin/Function0;", "isHeadsetConnect", "lazyNone", "Lkotlin/Lazy;", "T", "operation", "parseFloatSafe", "", "content", "fallback", "parseIntSafe", "parseLongSafe", "", "removeViewFromParent", "", "view", "Landroid/view/View;", "addNoEmpty", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "value", "addNoNull", "(Ljava/util/ArrayList;Ljava/lang/Object;)V", "compareUrlTo", "targetUrl", "dp2px", "dpValue", "getCurrentBrightness", "Landroid/app/Activity;", "defaultValue", "getEventExtra", "Lcom/baidu/searchbox/player/event/VideoEvent;", "key", "(Lcom/baidu/searchbox/player/event/VideoEvent;I)Ljava/lang/Object;", "getExtra", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "(Lcom/baidu/searchbox/player/layer/BaseKernelLayer;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getMaxVolume", "getOrEmpty", "index", "getVolume", "getVolumePercent", "isNullOrEmpty", "Lorg/json/JSONArray;", "kernelType", "orFalse", "(Ljava/lang/Boolean;)Z", "orTrue", "orZero", "", "(Ljava/lang/Double;)D", "(Ljava/lang/Float;)F", "(Ljava/lang/Integer;)I", "(Ljava/lang/Long;)J", "removeFromParent", "safeGet", "Ljava/util/concurrent/ConcurrentHashMap;", "(Ljava/util/concurrent/ConcurrentHashMap;Ljava/lang/String;)Ljava/lang/Object;", "safeRemove", "setBrightness", "screenBrightness", "setExtra", "", "setMaxBrightness", "setVolume", "size", "setVolumePercent", "percent", "then", "call", "(Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "toFloatRange", "Lcom/baidu/searchbox/player/model/FloatRange;", "toIntRange", "Lcom/baidu/searchbox/player/model/IntRange;", "toTextString", "toValueSafe", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "transform", "Lcom/baidu/searchbox/player/layer/LayerContainer;", "(Lcom/baidu/searchbox/player/layer/LayerContainer;)Ljava/lang/Object;", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdPlayerUtils.kt */
public final class BdPlayerUtils {
    @StableApi
    public static final int MSG_CONTROL_AUTO_HIDE = 100;

    @StableApi
    public static final float getCurrentBrightness(Activity activity) {
        return getCurrentBrightness$default(activity, 0.0f, 1, (Object) null);
    }

    @StableApi
    public static final float parseFloatSafe(String str) {
        return parseFloatSafe$default(str, 0.0f, 2, (Object) null);
    }

    @StableApi
    public static final int parseIntSafe(String str) {
        return parseIntSafe$default(str, 0, 2, (Object) null);
    }

    @StableApi
    public static final long parseLongSafe(String str) {
        return parseLongSafe$default(str, 0, 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r0 = (r0 = (r0 = r3.getContext()).getResources()).getDisplayMetrics();
     */
    @com.baidu.pyramid.annotation.tekes.StableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int dp2px(android.view.View r3, float r4) {
        /*
            if (r3 == 0) goto L_0x0017
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L_0x0017
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0017
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            if (r0 == 0) goto L_0x0017
            float r0 = r0.density
            goto L_0x0019
        L_0x0017:
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x0019:
            float r1 = r4 * r0
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r2
            int r1 = (int) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.utils.BdPlayerUtils.dp2px(android.view.View, float):int");
    }

    @StableApi
    public static final String getTextWithSecond(int second, boolean hours) {
        String str;
        if (second < 0) {
            return "";
        }
        int hh = second / 3600;
        int mm = (second % 3600) / 60;
        int ss = second % 60;
        if (hh != 0 || hours) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(Locale.US, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(hh), Integer.valueOf(mm), Integer.valueOf(ss)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(mm), Integer.valueOf(ss)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        }
        return str;
    }

    @StableApi
    public static final int getVolume(Context $this$getVolume) {
        AudioManager audioManager = null;
        Object systemService = $this$getVolume != null ? $this$getVolume.getSystemService("audio") : null;
        if (systemService instanceof AudioManager) {
            audioManager = (AudioManager) systemService;
        }
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    @StableApi
    public static final float getVolumePercent(Context $this$getVolumePercent) {
        AudioManager audioManager = null;
        Object systemService = $this$getVolumePercent != null ? $this$getVolumePercent.getSystemService("audio") : null;
        if (systemService instanceof AudioManager) {
            audioManager = (AudioManager) systemService;
        }
        if (audioManager == null) {
            return 0.0f;
        }
        return ((float) MathKt.roundToInt((((float) getVolume($this$getVolumePercent)) / ((float) getMaxVolume($this$getVolumePercent))) * ((float) 10))) / 10.0f;
    }

    @StableApi
    public static final int getMaxVolume(Context $this$getMaxVolume) {
        AudioManager audioManager = null;
        Object systemService = $this$getMaxVolume != null ? $this$getMaxVolume.getSystemService("audio") : null;
        if (systemService instanceof AudioManager) {
            audioManager = (AudioManager) systemService;
        }
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return -1;
    }

    @StableApi
    public static final void setVolume(Context $this$setVolume, int size) {
        AudioManager audioManager = null;
        Object systemService = $this$setVolume != null ? $this$setVolume.getSystemService("audio") : null;
        if (systemService instanceof AudioManager) {
            audioManager = (AudioManager) systemService;
        }
        if (audioManager != null) {
            audioManager.setStreamVolume(3, size, 8);
        }
    }

    @StableApi
    public static final void setVolumePercent(Context $this$setVolumePercent, float percent) {
        setVolume($this$setVolumePercent, MathKt.roundToInt(((float) getMaxVolume($this$setVolumePercent)) * percent));
    }

    @StableApi
    public static final boolean handleVolumeKeyDown(Context context, KeyEvent event, Function0<Boolean> block) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(block, BlockUpdateListener.ACTION_BLOCK);
        if (context == null) {
            return false;
        }
        Context $this$handleVolumeKeyDown_u24lambda_u2d2 = context;
        try {
            if (!block.invoke().booleanValue()) {
                return false;
            }
            Object systemService = $this$handleVolumeKeyDown_u24lambda_u2d2.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager == null) {
                return false;
            }
            if (event.getKeyCode() == 25) {
                audioManager.adjustStreamVolume(3, -1, 0);
                return true;
            } else if (event.getKeyCode() != 24) {
                return false;
            } else {
                audioManager.adjustStreamVolume(3, 1, 0);
                return true;
            }
        } catch (Exception e2) {
            BdVideoLog.d("handleVolumeKeyDown", e2.getMessage());
            return false;
        }
    }

    public static /* synthetic */ int parseIntSafe$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return parseIntSafe(str, i2);
    }

    @StableApi
    public static final int parseIntSafe(String content, int fallback) {
        int fallback$iv = fallback;
        String $this$toValueSafe$iv = content;
        CharSequence charSequence = $this$toValueSafe$iv;
        if (charSequence == null || charSequence.length() == 0) {
            return fallback$iv;
        }
        try {
            return Integer.parseInt($this$toValueSafe$iv);
        } catch (NumberFormatException exception$iv) {
            BdVideoLog.e("string to target value, catch exception:", (Throwable) exception$iv);
            return fallback$iv;
        }
    }

    public static /* synthetic */ float parseFloatSafe$default(String str, float f2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        return parseFloatSafe(str, f2);
    }

    @StableApi
    public static final float parseFloatSafe(String content, float fallback) {
        Object fallback$iv = Float.valueOf(fallback);
        String $this$toValueSafe$iv = content;
        CharSequence charSequence = $this$toValueSafe$iv;
        if (!(charSequence == null || charSequence.length() == 0)) {
            try {
                fallback$iv = fallback$iv instanceof Integer ? (Float) Integer.valueOf(Integer.parseInt($this$toValueSafe$iv)) : fallback$iv instanceof Double ? (Float) Double.valueOf(Double.parseDouble($this$toValueSafe$iv)) : fallback$iv instanceof Long ? (Float) Long.valueOf(Long.parseLong($this$toValueSafe$iv)) : Float.valueOf(Float.parseFloat($this$toValueSafe$iv));
            } catch (NumberFormatException exception$iv) {
                BdVideoLog.e("string to target value, catch exception:", (Throwable) exception$iv);
            }
        }
        return ((Number) fallback$iv).floatValue();
    }

    public static /* synthetic */ long parseLongSafe$default(String str, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return parseLongSafe(str, j2);
    }

    @StableApi
    public static final long parseLongSafe(String content, long fallback) {
        Object fallback$iv = Long.valueOf(fallback);
        String $this$toValueSafe$iv = content;
        CharSequence charSequence = $this$toValueSafe$iv;
        if (!(charSequence == null || charSequence.length() == 0)) {
            try {
                fallback$iv = fallback$iv instanceof Integer ? (Long) Integer.valueOf(Integer.parseInt($this$toValueSafe$iv)) : fallback$iv instanceof Double ? (Long) Double.valueOf(Double.parseDouble($this$toValueSafe$iv)) : Long.valueOf(Long.parseLong($this$toValueSafe$iv));
            } catch (NumberFormatException exception$iv) {
                BdVideoLog.e("string to target value, catch exception:", (Throwable) exception$iv);
            }
        }
        return ((Number) fallback$iv).longValue();
    }

    @StableApi
    public static final /* synthetic */ <T> T toValueSafe(String $this$toValueSafe, T fallback) {
        CharSequence charSequence = $this$toValueSafe;
        if (charSequence == null || charSequence.length() == 0) {
            return fallback;
        }
        try {
            if (fallback instanceof Integer) {
                T valueOf = Integer.valueOf(Integer.parseInt($this$toValueSafe));
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return (Object) valueOf;
            } else if (fallback instanceof Double) {
                T valueOf2 = Double.valueOf(Double.parseDouble($this$toValueSafe));
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return (Object) valueOf2;
            } else if (fallback instanceof Long) {
                T valueOf3 = Long.valueOf(Long.parseLong($this$toValueSafe));
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return (Object) valueOf3;
            } else if (fallback instanceof Float) {
                T valueOf4 = Float.valueOf(Float.parseFloat($this$toValueSafe));
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return (Object) valueOf4;
            } else {
                if (fallback instanceof Boolean) {
                    T valueOf5 = Boolean.valueOf(Boolean.parseBoolean($this$toValueSafe));
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    return (Object) valueOf5;
                }
                return fallback;
            }
        } catch (NumberFormatException exception) {
            BdVideoLog.e("string to target value, catch exception:", (Throwable) exception);
        }
    }

    @StableApi
    public static final <T> Lazy<T> lazyNone(Function0<? extends T> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new BdPlayerUtils$lazyNone$1(operation));
    }

    @StableApi
    public static final /* synthetic */ <T> T transform(LayerContainer $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return $this$transform;
    }

    @StableApi
    public static final /* synthetic */ <T> T getEventExtra(VideoEvent $this$getEventExtra, int key) {
        Intrinsics.checkNotNullParameter($this$getEventExtra, "<this>");
        T extra = $this$getEventExtra.getExtra(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = (Object) extra;
        return extra;
    }

    @StableApi
    public static final String toTextString(int $this$toTextString) {
        return $this$toTextString <= 0 ? "" : String.valueOf($this$toTextString);
    }

    @StableApi
    public static final int orZero(Integer $this$orZero) {
        if ($this$orZero != null) {
            return $this$orZero.intValue();
        }
        return 0;
    }

    @StableApi
    public static final double orZero(Double $this$orZero) {
        if ($this$orZero != null) {
            return $this$orZero.doubleValue();
        }
        return 0.0d;
    }

    @StableApi
    public static final long orZero(Long $this$orZero) {
        if ($this$orZero != null) {
            return $this$orZero.longValue();
        }
        return 0;
    }

    @StableApi
    public static final float orZero(Float $this$orZero) {
        if ($this$orZero != null) {
            return $this$orZero.floatValue();
        }
        return 0.0f;
    }

    @StableApi
    public static final boolean orFalse(Boolean $this$orFalse) {
        if ($this$orFalse != null) {
            return $this$orFalse.booleanValue();
        }
        return false;
    }

    @StableApi
    public static final boolean orTrue(Boolean $this$orTrue) {
        if ($this$orTrue != null) {
            return $this$orTrue.booleanValue();
        }
        return true;
    }

    @StableApi
    public static final <T> T safeGet(ConcurrentHashMap<String, T> $this$safeGet, String key) {
        Intrinsics.checkNotNullParameter($this$safeGet, "<this>");
        if (key == null) {
            return null;
        }
        return $this$safeGet.get(key);
    }

    @StableApi
    public static final <T> T safeRemove(ConcurrentHashMap<String, T> $this$safeRemove, String key) {
        Intrinsics.checkNotNullParameter($this$safeRemove, "<this>");
        if (key == null) {
            return null;
        }
        try {
            return $this$safeRemove.remove(key);
        } catch (IllegalStateException e2) {
            return null;
        }
    }

    @StableApi
    public static final void addNoEmpty(ArrayList<String> $this$addNoEmpty, String value) {
        Intrinsics.checkNotNullParameter($this$addNoEmpty, "<this>");
        CharSequence charSequence = value;
        if (!(charSequence == null || charSequence.length() == 0)) {
            $this$addNoEmpty.add(value);
        }
    }

    @StableApi
    public static final <T> void addNoNull(ArrayList<T> $this$addNoNull, T value) {
        Intrinsics.checkNotNullParameter($this$addNoNull, "<this>");
        if (value != null) {
            $this$addNoNull.add(value);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = (java.lang.String) kotlin.collections.CollectionsKt.getOrNull(r1, r2);
     */
    @com.baidu.pyramid.annotation.tekes.StableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getOrEmpty(java.util.ArrayList<java.lang.String> r1, int r2) {
        /*
            if (r1 == 0) goto L_0x000d
            r0 = r1
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x000f
        L_0x000d:
            java.lang.String r0 = ""
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.utils.BdPlayerUtils.getOrEmpty(java.util.ArrayList, int):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    @com.baidu.pyramid.annotation.tekes.StableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getStageType(com.baidu.searchbox.player.BDVideoPlayer r2, com.baidu.searchbox.player.model.BasicVideoSeries r3) {
        /*
            if (r2 == 0) goto L_0x000b
            int r0 = r2.getPlayerStageType()
        L_0x0006:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0013
        L_0x000b:
            if (r3 == 0) goto L_0x0012
            int r0 = r3.getPlayerStageType()
            goto L_0x0006
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 != 0) goto L_0x001a
            r1 = -1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
        L_0x001a:
            java.lang.String r1 = r0.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.utils.BdPlayerUtils.getStageType(com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.model.BasicVideoSeries):java.lang.String");
    }

    @StableApi
    public static final void removeViewFromParent(View view2) {
        ViewGroup viewParent = null;
        ViewParent parent = view2 != null ? view2.getParent() : null;
        if (parent instanceof ViewGroup) {
            viewParent = (ViewGroup) parent;
        }
        if (viewParent != null) {
            try {
                viewParent.removeView(view2);
            } catch (Exception ex) {
                BdVideoLog.e("removeView(" + System.identityHashCode(view2) + ')', (Throwable) ex);
            }
        }
    }

    @StableApi
    public static final void removeFromParent(View $this$removeFromParent) {
        removeViewFromParent($this$removeFromParent);
    }

    @StableApi
    public static final void setMaxBrightness(Activity $this$setMaxBrightness) {
        setBrightness($this$setMaxBrightness, 1.0f);
    }

    @StableApi
    public static final void setBrightness(Activity $this$setBrightness, float screenBrightness) {
        Window window;
        if ($this$setBrightness != null && (window = $this$setBrightness.getWindow()) != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.screenBrightness = screenBrightness;
            window.setAttributes(lp);
        }
    }

    public static /* synthetic */ float getCurrentBrightness$default(Activity activity, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.5f;
        }
        return getCurrentBrightness(activity, f2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = (r0 = r1.getWindow()).getAttributes();
     */
    @com.baidu.pyramid.annotation.tekes.StableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float getCurrentBrightness(android.app.Activity r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0011
            android.view.Window r0 = r1.getWindow()
            if (r0 == 0) goto L_0x0011
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x0011
            float r0 = r0.screenBrightness
            goto L_0x0012
        L_0x0011:
            r0 = r2
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.utils.BdPlayerUtils.getCurrentBrightness(android.app.Activity, float):float");
    }

    @StableApi
    public static final String kernelType(BaseKernelLayer $this$kernelType) {
        AbsVideoKernel videoKernel;
        if ($this$kernelType == null || (videoKernel = $this$kernelType.getVideoKernel()) == null) {
            return null;
        }
        return videoKernel.getKernelType();
    }

    public static final /* synthetic */ <T> T getExtra(BaseKernelLayer $this$getExtra, String key, T defaultValue) {
        StringArrayBundle this_$iv;
        if (key == null) {
            return defaultValue;
        }
        if ($this$getExtra == null || (this_$iv = $this$getExtra.getExtraBundle()) == null) {
            return null;
        }
        Object $this$toValue$iv$iv = this_$iv.get((Object) key);
        StringArrayBundle stringArrayBundle = this_$iv;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ($this$toValue$iv$iv instanceof Object) {
            return $this$toValue$iv$iv;
        }
        return defaultValue;
    }

    @StableApi
    public static final void setExtra(BaseKernelLayer $this$setExtra, String key, Object value) {
        StringArrayBundle extraBundle;
        if (key != null && $this$setExtra != null && (extraBundle = $this$setExtra.getExtraBundle()) != null) {
            extraBundle.putExtra(key, value);
        }
    }

    @StableApi
    public static final boolean compareUrlTo(String $this$compareUrlTo, String targetUrl) {
        if ($this$compareUrlTo == null || targetUrl == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) Uri.parse($this$compareUrlTo).getPath(), (Object) Uri.parse(targetUrl).getPath());
    }

    @StableApi
    public static final boolean isHeadsetConnect(Context context) {
        boolean curBluetoothHeadsetConnect;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            AudioManager audioManager = BdVolumeUtils.getAudioManager(context);
            boolean curHeadsetConnect = audioManager != null ? audioManager.isWiredHeadsetOn() : false;
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter != null) {
                curBluetoothHeadsetConnect = adapter.getProfileConnectionState(1) == 2;
            } else {
                curBluetoothHeadsetConnect = false;
            }
            if (curHeadsetConnect || curBluetoothHeadsetConnect) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    @StableApi
    public static final FloatRange toFloatRange(String $this$toFloatRange) {
        if ($this$toFloatRange != null) {
            return new FloatRange($this$toFloatRange);
        }
        FloatRange floatRange = null;
        return null;
    }

    @StableApi
    public static final IntRange toIntRange(String $this$toIntRange) {
        if ($this$toIntRange != null) {
            return new IntRange($this$toIntRange);
        }
        IntRange intRange = null;
        return null;
    }

    public static final void then(Boolean $this$then, Function0<Unit> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        if (Intrinsics.areEqual((Object) $this$then, (Object) true)) {
            call.invoke();
        }
    }

    public static final boolean isNullOrEmpty(JSONArray $this$isNullOrEmpty) {
        return $this$isNullOrEmpty == null || $this$isNullOrEmpty.length() == 0;
    }
}
