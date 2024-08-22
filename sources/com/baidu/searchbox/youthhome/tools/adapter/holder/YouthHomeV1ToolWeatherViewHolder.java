package com.baidu.searchbox.youthhome.tools.adapter.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.kmm.home.youth.YouthHomeToolsItemModel;
import com.baidu.searchbox.kmm.home.youth.YouthHomeToolsUBCKt;
import com.baidu.searchbox.youthhome.tools.R;
import com.baidu.searchbox.youthhome.tools.adapter.YouthHomeV1ToolBaseViewHolder;
import com.baidu.searchbox.youthhome.tools.adapter.YouthHomeV1ToolBaseViewHolderKt;
import com.baidu.searchbox.youthhome.tools.util.CommonUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\r\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/youthhome/tools/adapter/holder/YouthHomeV1ToolWeatherViewHolder;", "Lcom/baidu/searchbox/youthhome/tools/adapter/YouthHomeV1ToolBaseViewHolder;", "Lcom/baidu/searchbox/kmm/home/youth/YouthHomeToolsItemModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "currentFontSize", "", "model", "yhWeatherContainer", "Landroid/view/ViewGroup;", "yhWeatherContentRoot", "Landroidx/cardview/widget/CardView;", "yhWeatherIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "yhWeatherIconRoot", "yhWeatherImage", "yhWeatherLocation", "Landroid/widget/TextView;", "yhWeatherRoot", "yhWeatherStatus", "yhWeatherTemperature", "yhWeatherTemperatureSign", "yhWeatherTitle", "eventReport", "", "onBindView", "data", "setToolFontSizeChanged", "setToolFontSizeChanged$youth_home_tools_release", "setToolWeatherStyle", "setToolWeatherStyle$youth_home_tools_release", "youth-home-tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeV1ToolWeatherViewHolder.kt */
public final class YouthHomeV1ToolWeatherViewHolder extends YouthHomeV1ToolBaseViewHolder<YouthHomeToolsItemModel> {
    private int currentFontSize = -1;
    private YouthHomeToolsItemModel model;
    private final ViewGroup yhWeatherContainer;
    private final CardView yhWeatherContentRoot;
    private final SimpleDraweeView yhWeatherIcon;
    private final CardView yhWeatherIconRoot;
    private final SimpleDraweeView yhWeatherImage;
    private final TextView yhWeatherLocation;
    private final CardView yhWeatherRoot;
    private final TextView yhWeatherStatus;
    private final TextView yhWeatherTemperature;
    private final TextView yhWeatherTemperatureSign;
    private final TextView yhWeatherTitle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YouthHomeV1ToolWeatherViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.youth_home_tool_weather_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…h_home_tool_weather_icon)");
        this.yhWeatherIcon = (SimpleDraweeView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.youth_home_tool_weather_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…_home_tool_weather_title)");
        this.yhWeatherTitle = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.youth_home_tool_weather_root);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.…h_home_tool_weather_root)");
        this.yhWeatherRoot = (CardView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.youth_home_tool_weather_status_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.…tool_weather_status_text)");
        this.yhWeatherStatus = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.youth_home_tool_weather_location_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.…ol_weather_location_text)");
        this.yhWeatherLocation = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.youth_home_tool_weather_temperature_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.…weather_temperature_text)");
        this.yhWeatherTemperature = (TextView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.youth_home_tool_weather_temperature_sign);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.…weather_temperature_sign)");
        this.yhWeatherTemperatureSign = (TextView) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.youth_home_tool_weather_image);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.…_home_tool_weather_image)");
        this.yhWeatherImage = (SimpleDraweeView) findViewById8;
        View findViewById9 = itemView.findViewById(R.id.youth_home_tool_weather_container);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.…e_tool_weather_container)");
        this.yhWeatherContainer = (ViewGroup) findViewById9;
        View findViewById10 = itemView.findViewById(R.id.youth_home_tool_weather_content_card_view);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.…eather_content_card_view)");
        this.yhWeatherContentRoot = (CardView) findViewById10;
        View findViewById11 = itemView.findViewById(R.id.youth_home_tool_weather_image_card_view);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.…_weather_image_card_view)");
        this.yhWeatherIconRoot = (CardView) findViewById11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057 A[Catch:{ all -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008c A[Catch:{ all -> 0x00c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindView(com.baidu.searchbox.kmm.home.youth.YouthHomeToolsItemModel r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            r8.model = r9
            com.facebook.drawee.view.SimpleDraweeView r1 = r8.yhWeatherIcon
            java.lang.String r2 = r9.getIcon()
            r1.setImageURI((java.lang.String) r2)
            android.widget.TextView r1 = r8.yhWeatherTitle
            java.lang.String r2 = r9.getTitle()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            android.widget.TextView r1 = r8.yhWeatherTemperature
            com.baidu.searchbox.bdpfont.utils.BDPFont r2 = com.baidu.searchbox.bdpfont.utils.BDPFont.INSTANCE
            java.lang.String r3 = "baidunumber-Medium"
            android.graphics.Typeface r2 = r2.getBDPFontTypeFace(r3)
            r1.setTypeface(r2)
            org.json.JSONObject r1 = r9.getExt()
            if (r1 == 0) goto L_0x00d6
            r2 = 0
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x00c7 }
            r3 = r8
            com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolWeatherViewHolder r3 = (com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolWeatherViewHolder) r3     // Catch:{ all -> 0x00c7 }
            r4 = 0
            java.lang.String r5 = "status"
            java.lang.String r5 = r1.optString(r5, r0)     // Catch:{ all -> 0x00c7 }
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00c7 }
            if (r6 == 0) goto L_0x004c
            int r6 = r6.length()     // Catch:{ all -> 0x00c7 }
            if (r6 != 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r6 = 0
            goto L_0x004d
        L_0x004c:
            r6 = 1
        L_0x004d:
            if (r6 != 0) goto L_0x008c
            java.lang.String r6 = "1"
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00c7 }
            if (r6 == 0) goto L_0x008c
            android.widget.TextView r6 = r3.yhWeatherStatus     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = "weather"
            java.lang.String r7 = r1.optString(r7, r0)     // Catch:{ all -> 0x00c7 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00c7 }
            r6.setText(r7)     // Catch:{ all -> 0x00c7 }
            android.widget.TextView r6 = r3.yhWeatherLocation     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = "city"
            java.lang.String r7 = r1.optString(r7, r0)     // Catch:{ all -> 0x00c7 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00c7 }
            r6.setText(r7)     // Catch:{ all -> 0x00c7 }
            android.widget.TextView r6 = r3.yhWeatherTemperature     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = "temperature"
            java.lang.String r7 = r1.optString(r7, r0)     // Catch:{ all -> 0x00c7 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00c7 }
            r6.setText(r7)     // Catch:{ all -> 0x00c7 }
            com.facebook.drawee.view.SimpleDraweeView r6 = r3.yhWeatherImage     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = "icon"
            java.lang.String r0 = r1.optString(r7, r0)     // Catch:{ all -> 0x00c7 }
            r6.setImageURI((java.lang.String) r0)     // Catch:{ all -> 0x00c7 }
            goto L_0x00bf
        L_0x008c:
            android.widget.TextView r0 = r3.yhWeatherStatus     // Catch:{ all -> 0x00c7 }
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x00c7 }
            int r7 = com.baidu.searchbox.youthhome.tools.R.string.youth_home_tool_weather_status_default_text     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.getString(r7)     // Catch:{ all -> 0x00c7 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00c7 }
            r0.setText(r6)     // Catch:{ all -> 0x00c7 }
            android.widget.TextView r0 = r3.yhWeatherLocation     // Catch:{ all -> 0x00c7 }
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x00c7 }
            int r7 = com.baidu.searchbox.youthhome.tools.R.string.youth_home_tool_weather_location_default_text     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.getString(r7)     // Catch:{ all -> 0x00c7 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00c7 }
            r0.setText(r6)     // Catch:{ all -> 0x00c7 }
            android.widget.TextView r0 = r3.yhWeatherTemperature     // Catch:{ all -> 0x00c7 }
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x00c7 }
            int r7 = com.baidu.searchbox.youthhome.tools.R.string.youth_home_tool_weather_location_default_temp     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.getString(r7)     // Catch:{ all -> 0x00c7 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00c7 }
            r0.setText(r6)     // Catch:{ all -> 0x00c7 }
        L_0x00bf:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c7 }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x00c7 }
            goto L_0x00d2
        L_0x00c7:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x00d2:
            kotlin.Result.m8970boximpl(r0)
        L_0x00d6:
            android.view.ViewGroup r0 = r8.yhWeatherContainer
            com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolWeatherViewHolder$$ExternalSyntheticLambda0 r1 = new com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolWeatherViewHolder$$ExternalSyntheticLambda0
            r1.<init>(r9)
            r0.setOnClickListener(r1)
            android.view.ViewGroup r0 = r8.yhWeatherContainer
            com.baidu.searchbox.ui.TouchStateListener r1 = new com.baidu.searchbox.ui.TouchStateListener
            r1.<init>()
            android.view.View$OnTouchListener r1 = (android.view.View.OnTouchListener) r1
            r0.setOnTouchListener(r1)
            r8.eventReport()
            r8.setToolWeatherStyle$youth_home_tools_release()
            r8.setToolFontSizeChanged$youth_home_tools_release()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolWeatherViewHolder.onBindView(com.baidu.searchbox.kmm.home.youth.YouthHomeToolsItemModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindView$lambda-2  reason: not valid java name */
    public static final void m7826onBindView$lambda2(YouthHomeToolsItemModel $data, View it) {
        Intrinsics.checkNotNullParameter($data, "$data");
        YouthHomeToolsUBCKt.toolsItemClick($data);
        Router.invoke(AppRuntime.getAppContext(), $data.getScheme());
    }

    public void eventReport() {
        YouthHomeToolsItemModel dataModel = this.model;
        if (dataModel != null) {
            this.itemView.post(new YouthHomeV1ToolWeatherViewHolder$$ExternalSyntheticLambda1(this, dataModel));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: eventReport$lambda-4$lambda-3  reason: not valid java name */
    public static final void m7825eventReport$lambda4$lambda3(YouthHomeV1ToolWeatherViewHolder this$0, YouthHomeToolsItemModel $dataModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($dataModel, "$dataModel");
        if (this$0.itemView.getGlobalVisibleRect(new Rect()) && !$dataModel.isDisplayed()) {
            $dataModel.setDisplayed(true);
            YouthHomeToolsUBCKt.toolsItemShow($dataModel);
        }
    }

    public final void setToolWeatherStyle$youth_home_tools_release() {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        Context context = this.itemView.getContext();
        if (context != null && (resources = context.getResources()) != null) {
            int bgColor = resources.getColor(com.baidu.android.common.ui.style.R.color.GC1);
            this.yhWeatherTitle.setTextColor(bgColor);
            this.yhWeatherTemperature.setTextColor(bgColor);
            this.yhWeatherTemperatureSign.setTextColor(bgColor);
            Context context2 = this.itemView.getContext();
            if (context2 != null && (resources2 = context2.getResources()) != null) {
                int subTitleColor = resources2.getColor(com.baidu.android.common.ui.style.R.color.GC4);
                this.yhWeatherStatus.setTextColor(subTitleColor);
                this.yhWeatherLocation.setTextColor(subTitleColor);
                Context context3 = this.itemView.getContext();
                if (context3 != null && (resources3 = context3.getResources()) != null) {
                    this.yhWeatherRoot.setCardBackgroundColor(resources3.getColor(com.baidu.android.common.ui.style.R.color.GC17));
                    Context context4 = this.itemView.getContext();
                    if (context4 != null && (resources4 = context4.getResources()) != null) {
                        this.yhWeatherContentRoot.setCardBackgroundColor(resources4.getColor(com.baidu.android.common.ui.style.R.color.GC9));
                        Context context5 = this.itemView.getContext();
                        if (context5 != null && (resources5 = context5.getResources()) != null) {
                            this.yhWeatherIconRoot.setCardBackgroundColor(resources5.getColor(com.baidu.android.common.ui.style.R.color.GC17));
                        }
                    }
                }
            }
        }
    }

    public final void setToolFontSizeChanged$youth_home_tools_release() {
        if (this.currentFontSize != FontSizeHelper.getFontSizeType()) {
            FontSizeViewExtKt.setScaledSizeRes$default(this.yhWeatherIconRoot, YouthHomeV1ToolBaseViewHolderKt.getTOOL_TEXT_SCALE(), R.dimen.youth_home_tool_express_icon_small_size, R.dimen.youth_home_tool_express_icon_small_size, 0, 8, (Object) null);
            FontSizeViewExtKt.setScaledSizeRes$default(this.yhWeatherIcon, YouthHomeV1ToolBaseViewHolderKt.getTOOL_TEXT_SCALE(), R.dimen.youth_home_tool_express_icon_small_size, R.dimen.youth_home_tool_express_icon_small_size, 0, 8, (Object) null);
            FontSizeTextViewExtKt.setScaledSize$default(this.yhWeatherTitle, YouthHomeV1ToolBaseViewHolderKt.getTOOL_TEXT_SCALE(), 1, 11.0f, 0, 8, (Object) null);
            FontSizeTextViewExtKt.setScaledSize$default(this.yhWeatherStatus, YouthHomeV1ToolBaseViewHolderKt.getTOOL_TEXT_SCALE(), 1, 10.0f, 0, 8, (Object) null);
            FontSizeTextViewExtKt.setScaledSize$default(this.yhWeatherLocation, YouthHomeV1ToolBaseViewHolderKt.getTOOL_TEXT_SCALE(), 1, 10.0f, 0, 8, (Object) null);
            ViewGroup.LayoutParams $this$setToolFontSizeChanged_u24lambda_u2d5 = this.yhWeatherRoot.getLayoutParams();
            if ($this$setToolFontSizeChanged_u24lambda_u2d5 != null) {
                $this$setToolFontSizeChanged_u24lambda_u2d5.height = CommonUtilsKt.getToolLifeInnerRootHeight();
            }
            this.currentFontSize = FontSizeHelper.getFontSizeType();
        }
    }
}
