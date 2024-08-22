package com.baidu.nadcore.lp.reward.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.baidu.nadcore.business.R;
import com.baidu.nadcore.eventbus.EventBusWrapper;
import com.baidu.nadcore.eventbus.lifecycle.AdBackForegroundEvent;
import com.baidu.nadcore.lp.reward.data.NadRewardDialogData;
import com.baidu.nadcore.lp.reward.util.MultipleStartCountDownTime;
import com.baidu.nadcore.model.LottieDialogRewardData;
import com.baidu.nadcore.utils.DeviceUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0017\u0010\u0017\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "()V", "countDown", "Landroid/widget/TextView;", "countDownComponent", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "generateTimeStr", "", "time", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "initCommonView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onDetach", "onStart", "onStop", "registerBackForegroundEvent", "setCountDown", "(Ljava/lang/Integer;)V", "setDialogContentView", "setFestivalCoinData", "lottieRewardData", "Lcom/baidu/nadcore/model/LottieDialogRewardData;", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardLottieDialog.kt */
public final class NadRewardLottieDialog extends NadRewardVideoDialog {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public TextView countDown;
    /* access modifiers changed from: private */
    public MultipleStartCountDownTime countDownComponent;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View view3 = getView();
        if (view3 == null || (findViewById = view3.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setFestivalCoinData(LottieDialogRewardData lottieRewardData) {
        NadRewardDialogData dialogData = getDialogData();
        if (dialogData != null) {
            dialogData.setLottieRewardData(lottieRewardData);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.reward_dialog_outside_not_close_style);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Window window;
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        NadRewardDialogData dialogData = getDialogData();
        if (Intrinsics.areEqual((Object) dialogData != null ? dialogData.getDialogAnimationSwitch() : null, (Object) "1") && (window = dialog.getWindow()) != null) {
            window.setWindowAnimations(R.style.reward_video_dialog_entrance_anim);
        }
        return dialog;
    }

    public void initCommonView() {
        super.initCommonView();
        ViewGroup.LayoutParams topImgLp = getTopImg().getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(topImgLp, "topImg.layoutParams");
        topImgLp.height = DeviceUtils.ScreenInfo.dp2px(getContext(), 83.0f);
        getTopImg().setLayoutParams(topImgLp);
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0202  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDialogContentView() {
        /*
            r24 = this;
            r0 = r24
            android.view.ViewStub r1 = r24.getDialogStub()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r2 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r2 = r2.getLottieDialogContentUI()
            r1.setLayoutResource(r2)
            android.view.ViewStub r1 = r24.getDialogStub()
            android.view.View r1 = r1.inflate()
            java.lang.String r2 = "dialogStub.inflate()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.setDialogContent(r1)
            android.content.res.Resources r1 = r24.getResources()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r2 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r2 = r2.getDialogMainBtnTextSize()
            float r1 = r1.getDimension(r2)
            android.view.View r2 = r24.getDialogContent()
            int r3 = com.baidu.nadcore.business.R.id.close_img
            android.view.View r2 = r2.findViewById(r3)
            java.lang.String r3 = "dialogContent.findViewById(R.id.close_img)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.baidu.nadcore.widget.AdImageView r2 = (com.baidu.nadcore.widget.AdImageView) r2
            android.view.View r3 = r24.getDialogContent()
            int r4 = com.baidu.nadcore.business.R.id.title
            android.view.View r3 = r3.findViewById(r4)
            java.lang.String r4 = "dialogContent.findViewById(R.id.title)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.view.View r4 = r24.getDialogContent()
            int r5 = com.baidu.nadcore.business.R.id.coin_count
            android.view.View r4 = r4.findViewById(r5)
            java.lang.String r5 = "dialogContent.findViewById(R.id.coin_count)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            android.view.View r5 = r24.getDialogContent()
            int r6 = com.baidu.nadcore.business.R.id.coin_desc
            android.view.View r5 = r5.findViewById(r6)
            java.lang.String r6 = "dialogContent.findViewById(R.id.coin_desc)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.view.View r6 = r24.getDialogContent()
            int r7 = com.baidu.nadcore.business.R.id.button_container
            android.view.View r6 = r6.findViewById(r7)
            java.lang.String r7 = "dialogContent.findViewById(R.id.button_container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            android.view.View r7 = r24.getDialogContent()
            int r8 = com.baidu.nadcore.business.R.id.dialog_lottie_count_down
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0.countDown = r7
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r7 = r24.getDialogData()
            if (r7 == 0) goto L_0x00c5
            com.baidu.nadcore.lp.reward.data.NadDialogButtonData r10 = r7.getMainBtn()
            if (r10 == 0) goto L_0x00c5
            r7 = 0
            r9 = r0
            com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog r9 = (com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog) r9
            com.baidu.nadcore.stats.request.ClogBuilder$LogType r11 = com.baidu.nadcore.stats.request.ClogBuilder.LogType.CLICK
            java.lang.String r11 = r11.type
            java.lang.String r12 = "CLICK.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            com.baidu.nadcore.stats.request.ClogBuilder$Area r12 = com.baidu.nadcore.stats.request.ClogBuilder.Area.AD_BTN_DETAIL
            java.lang.String r12 = r12.type
            java.lang.String r13 = "AD_BTN_DETAIL.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r14 = 1
            r15 = 0
            r16 = 1
            r17 = 32
            r18 = 0
            java.lang.String r13 = "1"
            android.widget.TextView r7 = com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.buildButton$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x00c6
        L_0x00c5:
            r7 = 0
        L_0x00c6:
            com.airbnb.lottie.LottieAnimationView r9 = r24.getDialogBgLottie()
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            if (r9 == 0) goto L_0x0252
            android.widget.RelativeLayout$LayoutParams r9 = (android.widget.RelativeLayout.LayoutParams) r9
            android.content.Context r10 = r24.getContext()
            int r10 = com.baidu.nadcore.utils.DeviceUtils.ScreenInfo.getDisplayHeight(r10)
            r9.height = r10
            android.content.Context r10 = r24.getContext()
            int r10 = com.baidu.nadcore.utils.DeviceUtils.ScreenInfo.getDisplayWidth(r10)
            int r10 = r10 / 2
            android.content.Context r11 = r24.getContext()
            r12 = 1109917696(0x42280000, float:42.0)
            int r11 = com.baidu.nadcore.utils.DeviceUtils.ScreenInfo.dp2px(r11, r12)
            int r10 = r10 + r11
            r11 = -1
            int r10 = r10 * r11
            r9.bottomMargin = r10
            com.airbnb.lottie.LottieAnimationView r10 = r24.getDialogBgLottie()
            r12 = r9
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r10.setLayoutParams(r12)
            r10 = r3
            r12 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r13 = r24.getDialogData()
            if (r13 == 0) goto L_0x010c
            java.lang.String r13 = r13.getSubTitle()
            goto L_0x010d
        L_0x010c:
            r13 = 0
        L_0x010d:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r14 = 1
            r15 = 0
            if (r13 == 0) goto L_0x011c
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)
            if (r13 == 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            r13 = r15
            goto L_0x011d
        L_0x011c:
            r13 = r14
        L_0x011d:
            if (r13 == 0) goto L_0x0125
            r13 = 8
            r10.setVisibility(r13)
            goto L_0x014f
        L_0x0125:
            r10.setVisibility(r15)
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r13 = r24.getDialogData()
            if (r13 == 0) goto L_0x0133
            java.lang.String r13 = r13.getSubTitle()
            goto L_0x0134
        L_0x0133:
            r13 = 0
        L_0x0134:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r10.setText(r13)
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r13 = r24.getDialogData()
            if (r13 == 0) goto L_0x0144
            java.lang.String r13 = r13.getTitleColor()
            goto L_0x0145
        L_0x0144:
            r13 = 0
        L_0x0145:
            int r8 = com.baidu.nadcore.business.R.color.nad_lottie_dialog_text_default
            int r8 = com.baidu.nadcore.utils.ColorUtils.parseColorSafe(r13, r8)
            r10.setTextColor(r8)
        L_0x014f:
            r8 = r4
            r10 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r12 = r24.getDialogData()
            java.lang.String r13 = ""
            if (r12 == 0) goto L_0x0169
            com.baidu.nadcore.model.LottieDialogRewardData r12 = r12.getLottieRewardData()
            if (r12 == 0) goto L_0x0169
            java.lang.String r12 = r12.getCoin()
            if (r12 == 0) goto L_0x0169
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            goto L_0x016c
        L_0x0169:
            r12 = r13
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
        L_0x016c:
            r8.setText(r12)
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r12 = r24.getDialogData()
            if (r12 == 0) goto L_0x017a
            java.lang.String r12 = r12.getTitleColor()
            goto L_0x017b
        L_0x017a:
            r12 = 0
        L_0x017b:
            int r11 = com.baidu.nadcore.business.R.color.nad_lottie_dialog_text_default
            int r11 = com.baidu.nadcore.utils.ColorUtils.parseColorSafe(r12, r11)
            r8.setTextColor(r11)
            r8 = r5
            r10 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r11 = r24.getDialogData()
            if (r11 == 0) goto L_0x0197
            java.lang.String r11 = r11.getContentTips()
            if (r11 == 0) goto L_0x0197
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            goto L_0x019a
        L_0x0197:
            r11 = r13
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
        L_0x019a:
            r8.setText(r11)
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r11 = r24.getDialogData()
            if (r11 == 0) goto L_0x01a8
            java.lang.String r11 = r11.getTitleColor()
            goto L_0x01a9
        L_0x01a8:
            r11 = 0
        L_0x01a9:
            int r12 = com.baidu.nadcore.business.R.color.nad_lottie_dialog_text_default
            int r11 = com.baidu.nadcore.utils.ColorUtils.parseColorSafe(r11, r12)
            r8.setTextColor(r11)
            android.widget.TextView r8 = r0.countDown
            if (r8 == 0) goto L_0x020e
            r10 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r11 = r24.getDialogData()
            if (r11 == 0) goto L_0x01f1
            java.lang.String r18 = r11.getCountDownTips()
            if (r18 == 0) goto L_0x01f1
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r11 = r24.getDialogData()
            if (r11 == 0) goto L_0x01db
            com.baidu.nadcore.model.LottieDialogRewardData r11 = r11.getLottieRewardData()
            if (r11 == 0) goto L_0x01db
            int r11 = r11.getCountDownTime()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x01dc
        L_0x01db:
            r11 = 0
        L_0x01dc:
            java.lang.String r20 = r0.generateTimeStr(r11)
            r21 = 0
            r22 = 4
            r23 = 0
            java.lang.String r19 = "__REMAININGTIME__"
            java.lang.String r11 = kotlin.text.StringsKt.replace$default((java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (boolean) r21, (int) r22, (java.lang.Object) r23)
            if (r11 == 0) goto L_0x01f1
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            goto L_0x01f4
        L_0x01f1:
            r11 = r13
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
        L_0x01f4:
            r8.setText(r11)
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r11 = r24.getDialogData()
            if (r11 == 0) goto L_0x0202
            java.lang.String r11 = r11.getTitleColor()
            goto L_0x0203
        L_0x0202:
            r11 = 0
        L_0x0203:
            int r12 = com.baidu.nadcore.business.R.color.nad_lottie_dialog_text_default
            int r11 = com.baidu.nadcore.utils.ColorUtils.parseColorSafe(r11, r12)
            r8.setTextColor(r11)
        L_0x020e:
            if (r7 == 0) goto L_0x0232
            r8 = r7
            r10 = 0
            android.graphics.Typeface r11 = android.graphics.Typeface.defaultFromStyle(r14)
            r8.setTypeface(r11)
            r8.setTextSize(r15, r1)
            r11 = 17
            r8.setGravity(r11)
            android.widget.LinearLayout$LayoutParams r11 = new android.widget.LinearLayout$LayoutParams
            r12 = -1
            r11.<init>(r12, r12)
            r12 = r8
            android.view.View r12 = (android.view.View) r12
            r13 = r11
            android.view.ViewGroup$LayoutParams r13 = (android.view.ViewGroup.LayoutParams) r13
            r6.addView(r12, r15, r13)
        L_0x0232:
            r0.initCloseIcon(r2)
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r8 = r24.getDialogData()
            if (r8 == 0) goto L_0x024a
            com.baidu.nadcore.model.LottieDialogRewardData r8 = r8.getLottieRewardData()
            if (r8 == 0) goto L_0x024a
            int r8 = r8.getCountDownTime()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x024b
        L_0x024a:
            r8 = 0
        L_0x024b:
            r0.setCountDown(r8)
            r24.registerBackForegroundEvent()
            return
        L_0x0252:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.view.NadRewardLottieDialog.setDialogContentView():void");
    }

    private final void setCountDown(Integer time) {
        Ref.IntRef countDownTime = new Ref.IntRef();
        if (time != null) {
            countDownTime.element = time.intValue();
            this.countDownComponent = new NadRewardLottieDialog$setCountDown$1(countDownTime, this, TimeUnit.SECONDS.toMillis((long) countDownTime.element));
            getMainHandler().removeCallbacksAndMessages((Object) null);
            getMainHandler().postDelayed(new NadRewardLottieDialog$$ExternalSyntheticLambda0(this), 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setCountDown$lambda-6  reason: not valid java name */
    public static final void m14135setCountDown$lambda6(NadRewardLottieDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MultipleStartCountDownTime multipleStartCountDownTime = this$0.countDownComponent;
        if (multipleStartCountDownTime != null) {
            multipleStartCountDownTime.start();
        }
    }

    /* access modifiers changed from: private */
    public final String generateTimeStr(Integer time) {
        if (time == null) {
            return "";
        }
        time.intValue();
        return time.intValue() < 10 ? new StringBuilder().append('0').append(time).toString() : time.toString();
    }

    private final void registerBackForegroundEvent() {
        EventBusWrapper.getDefault().register(this, new NadRewardLottieDialog$registerBackForegroundEvent$1(this, AdBackForegroundEvent.class));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
            r3 = this;
            super.onStart()
            android.app.Dialog r0 = r3.getDialog()
            r1 = 0
            if (r0 == 0) goto L_0x0015
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x0015
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 != 0) goto L_0x0019
            goto L_0x001d
        L_0x0019:
            r2 = 17
            r0.gravity = r2
        L_0x001d:
            r2 = -1
            if (r0 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r0.width = r2
        L_0x0023:
            if (r0 != 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0.height = r2
        L_0x0028:
            android.app.Dialog r2 = r3.getDialog()
            if (r2 == 0) goto L_0x0032
            android.view.Window r1 = r2.getWindow()
        L_0x0032:
            if (r1 != 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r1.setAttributes(r0)
        L_0x0038:
            android.content.Context r1 = r3.getContext()
            r3.startBgLottie(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.view.NadRewardLottieDialog.onStart():void");
    }

    public void onStop() {
        super.onStop();
        MultipleStartCountDownTime multipleStartCountDownTime = this.countDownComponent;
        if (multipleStartCountDownTime != null) {
            multipleStartCountDownTime.cancel();
        }
    }

    public void onDetach() {
        super.onDetach();
        NadRewardDialogData dialogData = getDialogData();
        LottieDialogRewardData lottieRewardData = dialogData != null ? dialogData.getLottieRewardData() : null;
        if (lottieRewardData != null) {
            MultipleStartCountDownTime multipleStartCountDownTime = this.countDownComponent;
            lottieRewardData.setCountDownTime(multipleStartCountDownTime != null ? (int) (multipleStartCountDownTime.getMillisUntilFinishedSubStartProgress() / ((long) 1000)) : 0);
        }
        EventBusWrapper.getDefault().unregister(this);
    }
}
