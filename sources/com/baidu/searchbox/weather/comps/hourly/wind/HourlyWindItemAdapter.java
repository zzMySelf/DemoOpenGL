package com.baidu.searchbox.weather.comps.hourly.wind;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.fontsize.IFontSize;
import com.baidu.searchbox.nacomp.extension.nightmode.INightMode;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.weather.R;
import com.baidu.searchbox.weather.model.HourlyData;
import com.baidu.searchbox.weather.model.HourlyForecast;
import com.baidu.searchbox.weather.util.ResExtKt;
import com.baidu.searchbox.weather.util.WeatherUiUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/weather/comps/hourly/wind/HourlyWindItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/weather/comps/hourly/wind/HourlyWindItem;", "Lcom/baidu/searchbox/nacomp/extension/nightmode/INightMode;", "Lcom/baidu/searchbox/nacomp/extension/fontsize/IFontSize;", "forecast", "Lcom/baidu/searchbox/weather/model/HourlyForecast;", "(Lcom/baidu/searchbox/weather/model/HourlyForecast;)V", "bindItemSize", "", "holder", "bindTime", "data", "Lcom/baidu/searchbox/weather/model/HourlyData;", "bindWindDirection", "bindWindPower", "pos", "", "getItemCount", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onNightModeChange", "isNightMode", "", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HourlyWindItemAdapter.kt */
public final class HourlyWindItemAdapter extends RecyclerView.Adapter<HourlyWindItem> implements INightMode, IFontSize {
    private final HourlyForecast forecast;

    public HourlyWindItemAdapter(HourlyForecast forecast2) {
        Intrinsics.checkNotNullParameter(forecast2, "forecast");
        this.forecast = forecast2;
    }

    public HourlyWindItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_hourly_wind_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…wind_item, parent, false)");
        return new HourlyWindItem(inflate);
    }

    public void onBindViewHolder(HourlyWindItem holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        onNightModeChange(NightModeHelper.getNightModeSwitcherState(), holder);
        bindItemSize(holder);
        List<HourlyData> hourlyList = this.forecast.getHourlyList();
        HourlyData itemData = hourlyList != null ? hourlyList.get(position) : null;
        if (itemData != null) {
            bindTime(holder, itemData);
            bindWindDirection(holder, itemData);
            bindWindPower(holder, itemData, position);
        }
    }

    private final void bindItemSize(HourlyWindItem holder) {
        ViewGroup.LayoutParams $this$bindItemSize_u24lambda_u2d0 = holder.itemView.getLayoutParams();
        if ($this$bindItemSize_u24lambda_u2d0 != null) {
            $this$bindItemSize_u24lambda_u2d0.width = WeatherUiUtils.getHourlyItemWidth();
            $this$bindItemSize_u24lambda_u2d0.height = ResExtKt.getScaledSize(R.dimen.weather_hourly_item_height);
        }
        holder.itemView.requestLayout();
    }

    private final void bindTime(HourlyWindItem holder, HourlyData data) {
        TextView $this$bindTime_u24lambda_u2d1 = (TextView) holder.itemView.findViewById(R.id.wind_time_tv);
        $this$bindTime_u24lambda_u2d1.setText(data.getShowTime());
        FontSizeExtKt.updateTextSize$default($this$bindTime_u24lambda_u2d1, 0, 1, (Object) null);
    }

    private final void bindWindDirection(HourlyWindItem holder, HourlyData data) {
        View $this$bindWindDirection_u24lambda_u2d4 = holder.itemView;
        TextView it = (TextView) $this$bindWindDirection_u24lambda_u2d4.findViewById(R.id.wind_direction_tv);
        it.setText(data.getWindDirection());
        FontSizeExtKt.updateTextSize$default(it, 0, 1, (Object) null);
        SimpleDraweeView it2 = (SimpleDraweeView) $this$bindWindDirection_u24lambda_u2d4.findViewById(R.id.wind_direction_img);
        it2.setImageURI(data.getWindIconUri());
        int imgSize = ResExtKt.getScaledSize(R.dimen.weather_hourly_wind_direction_size);
        it2.setPivotX(((float) imgSize) / 2.0f);
        it2.setPivotY(((float) imgSize) / 2.0f);
        it2.setRotation(data.getWindIconRotation());
        FontSizeExtKt.updateSize$default(it2, 0, 1, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindWindPower(com.baidu.searchbox.weather.comps.hourly.wind.HourlyWindItem r16, com.baidu.searchbox.weather.model.HourlyData r17, int r18) {
        /*
            r15 = this;
            r0 = r18
            r1 = r16
            android.view.View r2 = r1.itemView
            r3 = 0
            float r4 = r17.getWindPowerNum()
            r5 = 1
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x0014
            r4 = r5
            goto L_0x0015
        L_0x0014:
            r4 = r6
        L_0x0015:
            if (r4 != 0) goto L_0x0092
            int r4 = com.baidu.searchbox.weather.R.id.wind_level_tv
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r7 = 0
            java.lang.String r8 = r17.getWindPower()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            r4.setVisibility(r6)
            r8 = 0
            com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt.updateTextSize$default(r4, r6, r5, r8)
            int r4 = com.baidu.searchbox.weather.R.id.wind_power
            android.view.View r4 = r2.findViewById(r4)
            r7 = 0
            android.view.ViewGroup$LayoutParams r9 = r4.getLayoutParams()
            boolean r10 = r9 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r10 == 0) goto L_0x0044
            r8 = r9
            android.view.ViewGroup$MarginLayoutParams r8 = (android.view.ViewGroup.MarginLayoutParams) r8
        L_0x0044:
            if (r8 == 0) goto L_0x008d
            r9 = 0
            int r10 = com.baidu.searchbox.weather.R.dimen.weather_hourly_wind_max_height
            int r10 = com.baidu.searchbox.weather.util.ResExtKt.getScaledSize(r10)
            int r11 = com.baidu.searchbox.weather.R.dimen.weather_hourly_wind_min_height
            int r11 = com.baidu.searchbox.weather.util.ResExtKt.getScaledSize(r11)
            com.baidu.searchbox.weather.config.SearchWeatherConfig r12 = com.baidu.searchbox.weather.config.SearchWeatherConfig.INSTANCE
            float r12 = r12.getWindPowerMaxValue()
            com.baidu.searchbox.weather.config.SearchWeatherConfig r13 = com.baidu.searchbox.weather.config.SearchWeatherConfig.INSTANCE
            float r13 = r13.getWindPowerMinValue()
            float r14 = r17.getWindPowerNum()
            int r12 = com.baidu.searchbox.weather.util.ChartUtil.computeDataHeight(r10, r11, r12, r13, r14)
            r8.height = r12
            int r12 = com.baidu.searchbox.weather.R.dimen.weather_hourly_wind_item_space
            int r12 = com.baidu.searchbox.weather.util.ResExtKt.getDimensionPixelSize(r12)
            int r12 = r12 / 2
            if (r0 != 0) goto L_0x0079
            r13 = r6
            goto L_0x007a
        L_0x0079:
            r13 = r12
        L_0x007a:
            r8.leftMargin = r13
            int r13 = r15.getItemCount()
            int r13 = r13 - r5
            if (r0 != r13) goto L_0x0085
            r5 = r6
            goto L_0x0086
        L_0x0085:
            r5 = r12
        L_0x0086:
            r8.rightMargin = r5
            r4.requestLayout()
        L_0x008d:
            r4.setVisibility(r6)
            goto L_0x00a7
        L_0x0092:
            int r4 = com.baidu.searchbox.weather.R.id.wind_level_tv
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r5 = 4
            r4.setVisibility(r5)
            int r4 = com.baidu.searchbox.weather.R.id.wind_power
            android.view.View r4 = r2.findViewById(r4)
            r4.setVisibility(r5)
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.weather.comps.hourly.wind.HourlyWindItemAdapter.bindWindPower(com.baidu.searchbox.weather.comps.hourly.wind.HourlyWindItem, com.baidu.searchbox.weather.model.HourlyData, int):void");
    }

    public int getItemCount() {
        List<HourlyData> hourlyList = this.forecast.getHourlyList();
        if (hourlyList != null) {
            return hourlyList.size();
        }
        return 0;
    }

    public void onNightModeChange(boolean isNightMode) {
        notifyDataSetChanged();
    }

    private final void onNightModeChange(boolean isNightMode, HourlyWindItem holder) {
        View $this$onNightModeChange_u24lambda_u2d9 = holder.itemView;
        ResWrapper.setTextColor((TextView) $this$onNightModeChange_u24lambda_u2d9.findViewById(R.id.wind_time_tv), com.baidu.searchbox.search.style.res.R.color.SC10);
        ResWrapper.setTextColor((TextView) $this$onNightModeChange_u24lambda_u2d9.findViewById(R.id.wind_direction_tv), com.baidu.searchbox.search.style.res.R.color.SC10);
        ResWrapper.setTextColor((TextView) $this$onNightModeChange_u24lambda_u2d9.findViewById(R.id.wind_level_tv), com.baidu.searchbox.search.style.res.R.color.SC10);
        ResWrapper.setBackground($this$onNightModeChange_u24lambda_u2d9.findViewById(R.id.wind_power), R.drawable.search_weather_wind_power_bg);
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        notifyDataSetChanged();
    }
}
