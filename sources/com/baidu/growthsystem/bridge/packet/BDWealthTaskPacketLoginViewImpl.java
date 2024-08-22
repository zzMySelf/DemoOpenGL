package com.baidu.growthsystem.bridge.packet;

import android.content.Context;
import com.baidu.growthsystem.bridge.bdwealth.impl.R;
import com.baidu.growthsystem.wealth.dialog.packet.BaseWealthTaskPacketLoginView;
import com.baidu.growthsystem.wealth.dialog.packet.WealthTaskPacketLoginConfig;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/growthsystem/bridge/packet/BDWealthTaskPacketLoginViewImpl;", "Lcom/baidu/growthsystem/wealth/dialog/packet/BaseWealthTaskPacketLoginView;", "()V", "buildAccountComponentConfig", "Lcom/baidu/searchbox/account/component/AccountComponentConfig;", "wealthTaskConfig", "Lcom/baidu/growthsystem/wealth/dialog/packet/WealthTaskPacketLoginConfig;", "createView", "", "config", "impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BDWealthTaskPacketLoginViewImpl.kt */
public final class BDWealthTaskPacketLoginViewImpl extends BaseWealthTaskPacketLoginView {
    public void createView(WealthTaskPacketLoginConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        BDWealthTaskPacketLoginViewImplKt.getAccountManager().getWealthTaskView(config.getContext(), new BDWealthTaskPacketLoginViewImpl$createView$callback$1(config), config.getButtonText(), config.getLoginPriority(), config.getCommonLoginBottomText(), config.getWeChatLoginBottomText(), config.getWeChatIconBitmap(), buildAccountComponentConfig(config));
    }

    private final AccountComponentConfig buildAccountComponentConfig(WealthTaskPacketLoginConfig wealthTaskConfig) {
        Context context = wealthTaskConfig.getContext();
        int userNameTextColor = context.getResources().getColor(R.color.wealth_video_packet_guide_login_user_name_text_color);
        int appNameTextColor = context.getResources().getColor(R.color.wealth_video_packet_guide_login_app_name_text_color);
        int agreeTextColor = context.getResources().getColor(R.color.wealth_video_packet_guide_login_agree_text_color);
        int agreeIconColor = context.getResources().getColor(R.color.wealth_video_packet_guide_login_agree_icon_color);
        int phoneTextColor = context.getResources().getColor(R.color.wealth_video_packet_guide_login_phone_text_color);
        AccountComponentConfig.Builder $this$buildAccountComponentConfig_u24lambda_u2d0 = AccountComponentConfig.getDefaulgParamsBuilder().setSupportWxEnhanceLogin(true).setPhoneTextColor(phoneTextColor, phoneTextColor).setUserNameTextColor(userNameTextColor, userNameTextColor).setAppNameTextColor(appNameTextColor, appNameTextColor).setAgreeTextColor(agreeTextColor, agreeTextColor).setAgreeCheckedIconColor(agreeIconColor, agreeIconColor).setLoginSrc(wealthTaskConfig.getLoginSource()).setLoginDialogBackgroundBitmap(wealthTaskConfig.getWeChatIconBitmap()).setSupportGuest(true).setNeedBpPush(true).setPushBpFrom("baiduboxapp");
        $this$buildAccountComponentConfig_u24lambda_u2d0.mIsWaitViewReady = true;
        AccountComponentConfig build = $this$buildAccountComponentConfig_u24lambda_u2d0.build();
        Intrinsics.checkNotNullExpressionValue(build, "getDefaulgParamsBuilder(…\n                .build()");
        return build;
    }
}
