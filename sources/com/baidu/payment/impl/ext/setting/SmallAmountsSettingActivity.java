package com.baidu.payment.impl.ext.setting;

import android.os.Bundle;
import com.baidu.payment.impl.ext.R;
import com.baidu.payment.impl.ext.setting.base.PaymentBasePreferenceActivity;
import com.baidu.payment.impl.ext.setting.utils.UBCUtils;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarOptionFloatingBack;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.widget.preference.Preference;
import com.baidu.searchbox.widget.preference.PreferenceFragment;

public class SmallAmountsSettingActivity extends PaymentBasePreferenceActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    public CharSequence getActivityTitle() {
        return getResources().getString(R.string.small_amounts_setting);
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        return new BottomBarOptionFloatingBack();
    }

    /* access modifiers changed from: protected */
    public PreferenceFragment getPreferenceFragment() {
        UBCUtils.onPreferenceClickUBC("show", "enter", "mianmi");
        return new SmallAmountsSettingsFragment();
    }

    /* access modifiers changed from: protected */
    public void onFeedBackClickUBC() {
        UBCUtils.onPreferenceClickUBC("click", "fankui", "mianmi");
    }

    public static class SmallAmountsSettingsFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.small_amounts_payment_setting);
        }

        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }

        private void updateFloatingState() {
        }

        public void onResume() {
            super.onResume();
        }

        public boolean onPreferenceClick(Preference preference) {
            if (!"pref_key_title_small_amounts_setting".equals(preference.getKey())) {
                return false;
            }
            UBCUtils.onPreferenceClickUBC("click", "alipay", "mianmi");
            return false;
        }
    }
}
