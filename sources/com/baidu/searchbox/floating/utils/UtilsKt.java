package com.baidu.searchbox.floating.utils;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.videoplayer.floating.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u001aB\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001\u001a\n\u0010\u0014\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u0016\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u0017\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u0018\u001a\u00020\u0006*\u00020\u0015\u001a\u0014\u0010\u0019\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006H\u0007\u001a\n\u0010\u001b\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u001c\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u001d\u001a\u00020\u0006*\u00020\u0015\u001a\n\u0010\u001e\u001a\u00020\u0006*\u00020\u000e\u001a\f\u0010\u001f\u001a\u00020\u0001*\u00020 H\u0007\u001a\n\u0010!\u001a\u00020\u0006*\u00020\u000e\u001a\n\u0010\"\u001a\u00020\u0006*\u00020\u000e\u001a\n\u0010#\u001a\u00020\u0006*\u00020\u000e\u001a\n\u0010$\u001a\u00020%*\u00020\u000e\u001a\u001c\u0010&\u001a\u00020\n*\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007\u001a\u0012\u0010+\u001a\u00020,*\u00020\u000e2\u0006\u0010-\u001a\u00020.\u001a\u0012\u0010/\u001a\u00020\n*\u00020\u000e2\u0006\u0010-\u001a\u00020.\u001a\u0014\u00100\u001a\u00020\n*\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"NOTIFICATION_CHANNEL_ID", "", "doubleTapAnimator", "Landroid/animation/ValueAnimator;", "startSize", "Lkotlin/Pair;", "", "endSize", "updateListener", "Lkotlin/Function2;", "", "getDefaultNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "icon", "channelId", "channelName", "title", "content", "buttonBottomMargin", "Landroid/view/View;", "buttonExtraPadding", "buttonHorizontalMargin", "buttonVerticalMargin", "dpToPxByScale", "dp", "floatingButtonHeight", "floatingButtonWidth", "floatingImageViewSize", "getNavBarHeight", "getScale", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "getScreenHeight", "getScreenWidth", "getStatusBarHeight", "getWindowManager", "Landroid/view/WindowManager;", "registerLocalReceiver", "receiver", "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "sendLocalBroadcast", "", "intent", "Landroid/content/Intent;", "sendLocalBroadcastSync", "unregisterLocalReceiver", "floating-view_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Utils.kt */
public final class UtilsKt {
    public static final String NOTIFICATION_CHANNEL_ID = "floating_bd_video";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Utils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScaleMode.values().length];
            iArr[ScaleMode.S.ordinal()] = 1;
            iArr[ScaleMode.M.ordinal()] = 2;
            iArr[ScaleMode.L.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final WindowManager getWindowManager(Context $this$getWindowManager) {
        Intrinsics.checkNotNullParameter($this$getWindowManager, "<this>");
        Object systemService = $this$getWindowManager.getSystemService("window");
        if (systemService != null) {
            return (WindowManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public static final int getScreenHeight(Context $this$getScreenHeight) {
        Intrinsics.checkNotNullParameter($this$getScreenHeight, "<this>");
        return VideoSystemHelper.getDisplayHeight();
    }

    public static final int getScreenWidth(Context $this$getScreenWidth) {
        Intrinsics.checkNotNullParameter($this$getScreenWidth, "<this>");
        return VideoSystemHelper.getDisplayWidth();
    }

    public static final int getNavBarHeight(Context $this$getNavBarHeight) {
        Intrinsics.checkNotNullParameter($this$getNavBarHeight, "<this>");
        return VideoSystemHelper.getNavigationBarHeight();
    }

    public static final int getStatusBarHeight(Context $this$getStatusBarHeight) {
        Intrinsics.checkNotNullParameter($this$getStatusBarHeight, "<this>");
        return VideoSystemHelper.getStatusBarHeight();
    }

    public static final boolean sendLocalBroadcast(Context $this$sendLocalBroadcast, Intent intent) {
        Intrinsics.checkNotNullParameter($this$sendLocalBroadcast, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        return LocalBroadcastManager.getInstance($this$sendLocalBroadcast).sendBroadcast(intent);
    }

    public static final void sendLocalBroadcastSync(Context $this$sendLocalBroadcastSync, Intent intent) {
        Intrinsics.checkNotNullParameter($this$sendLocalBroadcastSync, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        LocalBroadcastManager.getInstance($this$sendLocalBroadcastSync).sendBroadcastSync(intent);
    }

    @StableApi
    public static final void registerLocalReceiver(Context $this$registerLocalReceiver, BroadcastReceiver receiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter($this$registerLocalReceiver, "<this>");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(filter, "filter");
        LocalBroadcastManager.getInstance($this$registerLocalReceiver).registerReceiver(receiver, filter);
    }

    @StableApi
    public static final void unregisterLocalReceiver(Context $this$unregisterLocalReceiver, BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter($this$unregisterLocalReceiver, "<this>");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance($this$unregisterLocalReceiver).unregisterReceiver(receiver);
    }

    @StableApi
    public static final int dpToPxByScale(Context $this$dpToPxByScale, int dp) {
        Intrinsics.checkNotNullParameter($this$dpToPxByScale, "<this>");
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager($this$dpToPxByScale).getDefaultDisplay().getMetrics(display);
        float density = 3.0f;
        if (display.density <= 2.5f || display.density > 3.0f) {
            density = display.density;
        }
        return (int) ((((float) dp) * density) + 0.5f);
    }

    public static final int floatingImageViewSize(View $this$floatingImageViewSize) {
        Intrinsics.checkNotNullParameter($this$floatingImageViewSize, "<this>");
        return BdPlayerUtils.dp2px($this$floatingImageViewSize, 20.0f);
    }

    public static final int floatingButtonWidth(View $this$floatingButtonWidth) {
        Intrinsics.checkNotNullParameter($this$floatingButtonWidth, "<this>");
        return BdPlayerUtils.dp2px($this$floatingButtonWidth, 29.0f);
    }

    public static final int floatingButtonHeight(View $this$floatingButtonHeight) {
        Intrinsics.checkNotNullParameter($this$floatingButtonHeight, "<this>");
        return BdPlayerUtils.dp2px($this$floatingButtonHeight, 21.0f);
    }

    public static final int buttonHorizontalMargin(View $this$buttonHorizontalMargin) {
        Intrinsics.checkNotNullParameter($this$buttonHorizontalMargin, "<this>");
        return BdPlayerUtils.dp2px($this$buttonHorizontalMargin, 5.0f);
    }

    public static final int buttonVerticalMargin(View $this$buttonVerticalMargin) {
        Intrinsics.checkNotNullParameter($this$buttonVerticalMargin, "<this>");
        return BdPlayerUtils.dp2px($this$buttonVerticalMargin, 5.0f);
    }

    public static final int buttonBottomMargin(View $this$buttonBottomMargin) {
        Intrinsics.checkNotNullParameter($this$buttonBottomMargin, "<this>");
        return BdPlayerUtils.dp2px($this$buttonBottomMargin, 26.0f);
    }

    public static final int buttonExtraPadding(View $this$buttonExtraPadding) {
        Intrinsics.checkNotNullParameter($this$buttonExtraPadding, "<this>");
        return BdPlayerUtils.dp2px($this$buttonExtraPadding, 6.0f);
    }

    public static /* synthetic */ Notification getDefaultNotification$default(Context context, int i2, String str, String str2, String str3, String str4, int i3, Object obj) {
        String str5;
        String str6;
        String str7;
        if ((i3 & 2) != 0) {
            i2 = R.drawable.bdvideoplayer_floating_notification;
        }
        String str8 = (i3 & 4) != 0 ? NOTIFICATION_CHANNEL_ID : str;
        if ((i3 & 8) != 0) {
            String string = context.getString(R.string.player_floating_notification_channel);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ing_notification_channel)");
            str5 = string;
        } else {
            str5 = str2;
        }
        if ((i3 & 16) != 0) {
            String string2 = context.getString(R.string.player_floating_notification_title);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…ating_notification_title)");
            str6 = string2;
        } else {
            str6 = str3;
        }
        if ((i3 & 32) != 0) {
            String string3 = context.getString(R.string.player_floating_notification_content);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…ing_notification_content)");
            str7 = string3;
        } else {
            str7 = str4;
        }
        return getDefaultNotification(context, i2, str8, str5, str6, str7);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.app.NotificationManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.app.Notification getDefaultNotification(android.content.Context r5, int r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "channelId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "channelName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto L_0x0062
            android.app.NotificationChannel r0 = new android.app.NotificationChannel
            r2 = r8
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            r0.<init>(r7, r2, r3)
            java.lang.String r2 = "notification"
            java.lang.Object r2 = r5.getSystemService(r2)
            boolean r4 = r2 instanceof android.app.NotificationManager
            if (r4 == 0) goto L_0x0038
            r1 = r2
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.createNotificationChannel(r0)
        L_0x003d:
            androidx.core.app.NotificationCompat$Builder r2 = new androidx.core.app.NotificationCompat$Builder
            r2.<init>((android.content.Context) r5, (java.lang.String) r7)
            r4 = r9
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            androidx.core.app.NotificationCompat$Builder r2 = r2.setContentTitle(r4)
            r4 = r10
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            androidx.core.app.NotificationCompat$Builder r2 = r2.setContentText(r4)
            r4 = 0
            androidx.core.app.NotificationCompat$Builder r2 = r2.setAutoCancel(r4)
            androidx.core.app.NotificationCompat$Builder r2 = r2.setSmallIcon((int) r6)
            androidx.core.app.NotificationCompat$Builder r2 = r2.setPriority(r3)
            android.app.Notification r2 = r2.build()
            return r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.floating.utils.UtilsKt.getDefaultNotification(android.content.Context, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.app.Notification");
    }

    @StableApi
    public static final String getScale(ScaleMode $this$getScale) {
        Intrinsics.checkNotNullParameter($this$getScale, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$getScale.ordinal()]) {
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            default:
                return "0";
        }
    }

    public static final ValueAnimator doubleTapAnimator(Pair<Integer, Integer> startSize, Pair<Integer, Integer> endSize, Function2<? super Integer, ? super Integer, Unit> updateListener) {
        Intrinsics.checkNotNullParameter(startSize, "startSize");
        Intrinsics.checkNotNullParameter(endSize, "endSize");
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("width", new int[]{startSize.getFirst().intValue(), endSize.getFirst().intValue()}), PropertyValuesHolder.ofInt("height", new int[]{startSize.getSecond().intValue(), endSize.getSecond().intValue()})});
        ValueAnimator $this$doubleTapAnimator_u24lambda_u2d1 = ofPropertyValuesHolder;
        $this$doubleTapAnimator_u24lambda_u2d1.addUpdateListener(new UtilsKt$$ExternalSyntheticLambda0($this$doubleTapAnimator_u24lambda_u2d1, updateListener));
        $this$doubleTapAnimator_u24lambda_u2d1.setDuration(400);
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(p…     duration = 400\n    }");
        return ofPropertyValuesHolder;
    }

    /* access modifiers changed from: private */
    /* renamed from: doubleTapAnimator$lambda-1$lambda-0  reason: not valid java name */
    public static final void m19842doubleTapAnimator$lambda1$lambda0(ValueAnimator $this_apply, Function2 $updateListener, ValueAnimator it) {
        Intrinsics.checkNotNullParameter($updateListener, "$updateListener");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = $this_apply.getAnimatedValue("width");
        if (animatedValue != null) {
            int width = ((Integer) animatedValue).intValue();
            Object animatedValue2 = $this_apply.getAnimatedValue("height");
            if (animatedValue2 != null) {
                $updateListener.invoke(Integer.valueOf(width), Integer.valueOf(((Integer) animatedValue2).intValue()));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
