package com.tera.scan.main.ui.settingitems;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.dialog.ConfirmDialog;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import fe.mmm.qw.p030switch.th.de.ad.ad;
import fe.mmm.qw.qw.qw;
import fe.mmm.qw.xxx.pf.de;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/tera/scan/main/ui/settingitems/LogoutSettingItem;", "Lcom/tera/scan/main/ui/settingitems/ISettingItem;", "()V", "init", "", "item", "Lcom/tera/scan/main/view/SettingItemView;", "name", "", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogoutSettingItem implements ISettingItem {
    public static final void qw(SettingItemView settingItemView, View view) {
        Intrinsics.checkNotNullParameter(settingItemView, "$item");
        de.ad("PCntrExLg", "PCntr", (String) null, (Map) null, 12, (Object) null);
        Context context = settingItemView.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            ConfirmDialog.qw qwVar = new ConfirmDialog.qw();
            qwVar.xxx(ad.qw(R.string.logout));
            qwVar.rg(ad.qw(R.string.logout_dialog_content));
            qwVar.fe(ad.qw(R.string.logout_dialog_confirm));
            qwVar.de(false);
            ConfirmDialog qw = qwVar.qw();
            qw.setOnConfirmChange(new LogoutSettingItem$init$1$3$1(fragmentActivity));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "ac.supportFragmentManager");
            qw.show(supportFragmentManager, "退出登录确认弹窗");
        }
    }

    @NotNull
    public String name() {
        return ad.qw(R.string.logout);
    }

    public void onDestroy() {
        ISettingItem.qw.qw(this);
    }

    public void onPause() {
        ISettingItem.qw.ad(this);
    }

    public void onResume() {
        ISettingItem.qw.de(this);
    }

    @Nullable
    public String rg() {
        return ISettingItem.qw.fe(this);
    }

    public void th(@NotNull SettingItemView settingItemView) {
        Intrinsics.checkNotNullParameter(settingItemView, "item");
        if (!qw.qw.pf()) {
            settingItemView.setVisibility(8);
            return;
        }
        settingItemView.arrowVisible(false);
        settingItemView.tipsVisible(false);
        settingItemView.dividerVisible(false);
        TextView textView = (TextView) settingItemView.findViewById(R.id.tv_setting_item_title);
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R.id.tv_setting_item_title)");
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.gravity = 17;
                layoutParams2.setMargins(0, 0, 0, 0);
                textView.setLayoutParams(layoutParams2);
            }
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setTextColor(fe.mmm.qw.d.de.de.when().i(R.color.setting_item_logout_name_color));
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.dimen_14dp));
        }
        settingItemView.setBackgroundColor(fe.mmm.qw.d.de.de.when().i(R.color.white));
        fe.mmm.qw.f.de.ad.ad helper = settingItemView.getHelper();
        helper.h(settingItemView.getContext().getResources().getDimension(R.dimen.dimen_8dp));
        helper.f(true);
        settingItemView.setOnClickListener(new fe.mmm.qw.xxx.p032if.rg.ad(settingItemView));
    }
}
