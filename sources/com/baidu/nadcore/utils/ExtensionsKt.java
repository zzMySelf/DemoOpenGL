package com.baidu.nadcore.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.nadcore.core.AdRuntime;
import com.baidu.nadcore.load.AdLoadRuntime;
import com.baidu.nadcore.load.ILoadImage;
import com.baidu.nadcore.utils.DeviceUtils;
import com.baidu.swan.game.ad.interfaces.IAdResonseInfo;
import java.lang.reflect.Proxy;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u001a\u0010\u0007\u001a\u0002H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\tH\b¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0003*\u0002H\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a@\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0014\b\u0004\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u00172\u000e\b\u0006\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\rH\bø\u0001\u0000\u001a\u0012\u0010\u001a\u001a\u00020\u0011*\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0011\u001a\u001a\u0010\u001a\u001a\u00020\u0011*\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0007\u001a\n\u0010 \u001a\u00020\u0003*\u00020\u0003\u001a(\u0010!\u001a\u00020\u0013\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0003*\u0002H\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\b¢\u0006\u0002\u0010\"\u001a\u0016\u0010#\u001a\u00020\u001e*\u00020\u00112\b\b\u0001\u0010$\u001a\u00020\u001eH\u0007\"*\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006%"}, d2 = {"value", "", "isVisible", "Landroid/view/View;", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "noOpDelegate", "T", "", "()Ljava/lang/Object;", "checkVisible", "predicate", "Lkotlin/Function0;", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)Landroid/view/View;", "cmdToJsonObj", "Lorg/json/JSONObject;", "", "loadDrawableFromUrl", "", "Landroid/content/Context;", "url", "success", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "loadFail", "optStringCheckNonNull", "key", "fallback", "px", "", "context", "removeFromParent", "setBgFromUrl", "(Landroid/view/View;Ljava/lang/String;)V", "toColor", "defaultColor", "nadcore-lib-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Extensions.kt */
public final class ExtensionsKt {
    public static final /* synthetic */ <T extends View> T checkVisible(T $this$checkVisible, Function0<Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$checkVisible, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (predicate.invoke().booleanValue()) {
            $this$checkVisible.setVisibility(0);
            return $this$checkVisible;
        }
        $this$checkVisible.setVisibility(8);
        View view2 = null;
        return null;
    }

    public static final int px(int $this$px, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtils.ScreenInfo.dp2px(context, (float) $this$px);
    }

    public static final int toColor(String $this$toColor, int defaultColor) {
        Integer num;
        Intrinsics.checkNotNullParameter($this$toColor, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m8971constructorimpl(Integer.valueOf(Color.parseColor($this$toColor)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Integer valueOf = Integer.valueOf(ContextCompat.getColor(AdRuntime.applicationContext(), defaultColor));
        if (Result.m8977isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    public static final boolean isVisible(View $this$isVisible) {
        Intrinsics.checkNotNullParameter($this$isVisible, "<this>");
        return $this$isVisible.getVisibility() == 0;
    }

    public static final void setVisible(View $this$isVisible, boolean value) {
        Intrinsics.checkNotNullParameter($this$isVisible, "<this>");
        $this$isVisible.setVisibility(value ? 0 : 8);
    }

    public static final View removeFromParent(View $this$removeFromParent) {
        Intrinsics.checkNotNullParameter($this$removeFromParent, "<this>");
        ViewParent parent = $this$removeFromParent.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView($this$removeFromParent);
        }
        return $this$removeFromParent;
    }

    public static final /* synthetic */ <T> T noOpDelegate() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class javaClass = Object.class;
        T newProxyInstance = Proxy.newProxyInstance(javaClass.getClassLoader(), new Class[]{javaClass}, ExtensionsKt$noOpDelegate$1.INSTANCE);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = (Object) newProxyInstance;
        return newProxyInstance;
    }

    public static final String optStringCheckNonNull(JSONObject $this$optStringCheckNonNull, String key) {
        Intrinsics.checkNotNullParameter($this$optStringCheckNonNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return optStringCheckNonNull($this$optStringCheckNonNull, key, "");
    }

    public static final String optStringCheckNonNull(JSONObject $this$optStringCheckNonNull, String key, String fallback) {
        Intrinsics.checkNotNullParameter($this$optStringCheckNonNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(fallback, IAdResonseInfo.APO_FALLBACK);
        if ($this$optStringCheckNonNull.isNull(key)) {
            return fallback;
        }
        String optString = $this$optStringCheckNonNull.optString(key, fallback);
        Intrinsics.checkNotNullExpressionValue(optString, "optString(key, fallback)");
        return optString;
    }

    public static final /* synthetic */ <T extends View> void setBgFromUrl(T $this$setBgFromUrl, String url) {
        Intrinsics.checkNotNullParameter($this$setBgFromUrl, "<this>");
        Context $this$loadDrawableFromUrl_u24default$iv = $this$setBgFromUrl.getContext();
        Intrinsics.checkNotNullExpressionValue($this$loadDrawableFromUrl_u24default$iv, "context");
        CharSequence charSequence = url;
        if (!(charSequence == null || charSequence.length() == 0)) {
            ILoadImage image = AdLoadRuntime.image();
            Intrinsics.needClassReification();
            image.loadImage(url, new ExtensionsKt$setBgFromUrl$$inlined$loadDrawableFromUrl$default$1($this$loadDrawableFromUrl_u24default$iv, $this$setBgFromUrl));
        }
    }

    public static /* synthetic */ void loadDrawableFromUrl$default(Context $this$loadDrawableFromUrl_u24default, String url, Function1 success, Function0 loadFail, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            loadFail = ExtensionsKt$loadDrawableFromUrl$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$loadDrawableFromUrl_u24default, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(loadFail, "loadFail");
        CharSequence charSequence = url;
        if (charSequence == null || charSequence.length() == 0) {
            loadFail.invoke();
        } else {
            AdLoadRuntime.image().loadImage(url, new ExtensionsKt$loadDrawableFromUrl$2(success, $this$loadDrawableFromUrl_u24default, loadFail));
        }
    }

    public static final void loadDrawableFromUrl(Context $this$loadDrawableFromUrl, String url, Function1<? super Drawable, Unit> success, Function0<Unit> loadFail) {
        Intrinsics.checkNotNullParameter($this$loadDrawableFromUrl, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(loadFail, "loadFail");
        CharSequence charSequence = url;
        if (charSequence == null || charSequence.length() == 0) {
            loadFail.invoke();
        } else {
            AdLoadRuntime.image().loadImage(url, new ExtensionsKt$loadDrawableFromUrl$2(success, $this$loadDrawableFromUrl, loadFail));
        }
    }

    public static final JSONObject cmdToJsonObj(String $this$cmdToJsonObj) {
        Intrinsics.checkNotNullParameter($this$cmdToJsonObj, "<this>");
        JSONObject jsonObject = new JSONObject();
        Uri uri = Uri.parse($this$cmdToJsonObj);
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
        for (String it : SequencesKt.filter(CollectionsKt.asSequence(queryParameterNames), new ExtensionsKt$cmdToJsonObj$1($this$cmdToJsonObj, uri))) {
            String value = uri.getQueryParameter(it);
            try {
                jsonObject.put(it, new JSONObject(value));
            } catch (Exception e2) {
                jsonObject.put(it, value);
            }
        }
        return jsonObject;
    }
}
