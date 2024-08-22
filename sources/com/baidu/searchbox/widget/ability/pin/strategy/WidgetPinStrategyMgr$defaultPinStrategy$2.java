package com.baidu.searchbox.widget.ability.pin.strategy;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.widget.ability.pin.strategy.miui.MiuiPinStrategy;
import com.baidu.searchbox.widget.ability.pin.strategy.vivo.VivoPinStrategy;
import com.baidu.searchbox.widget.ability.pin.utils.DeviceHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/widget/ability/pin/strategy/IWidgetPinStrategy;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetPinStrategyMgr.kt */
final class WidgetPinStrategyMgr$defaultPinStrategy$2 extends Lambda implements Function0<IWidgetPinStrategy> {
    public static final WidgetPinStrategyMgr$defaultPinStrategy$2 INSTANCE = new WidgetPinStrategyMgr$defaultPinStrategy$2();

    WidgetPinStrategyMgr$defaultPinStrategy$2() {
        super(0);
    }

    public final IWidgetPinStrategy invoke() {
        if (DeviceHelpersKt.isMiuiCompat()) {
            return new MiuiPinStrategy();
        }
        if (RomUtils.isVivo()) {
            return new VivoPinStrategy();
        }
        return new DefaultPinStrategy();
    }
}
