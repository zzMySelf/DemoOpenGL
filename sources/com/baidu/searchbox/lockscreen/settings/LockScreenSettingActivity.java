package com.baidu.searchbox.lockscreen.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.feedback.FeedbackInfoManager;
import com.baidu.searchbox.lightbrowser.NativeBottomNavigationActivity;
import com.baidu.searchbox.lockscreen.ILockScreenActivity;
import com.baidu.searchbox.lockscreen.LockScreenActivity;
import com.baidu.searchbox.lockscreen.base.R;
import com.baidu.searchbox.lockscreen.bridge.LockScreenRuntime;
import com.baidu.searchbox.lockscreen.browser.LockScreenBrowserActivity;
import com.baidu.searchbox.lockscreen.common.Constant;
import com.baidu.searchbox.lockscreen.config.Config;
import com.baidu.searchbox.lockscreen.controller.LockScreenManager;
import com.baidu.searchbox.lockscreen.guide.LockScreenSwitch;
import com.baidu.searchbox.lockscreen.statistics.LockScreenHome;
import com.baidu.searchbox.lockscreen.statistics.LockScreenStatisticConstants;
import com.baidu.searchbox.lockscreen.util.ActivityStack;
import com.baidu.searchbox.lockscreen.util.LockScreenPreferenceUtils;
import com.baidu.searchbox.lockscreen.util.LockScreenUiUtils;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.searchbox.lockscreen.util.TestFileUtil;
import com.baidu.searchbox.lockscreen.view.AlertWindowRequestPermission;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.widget.preference.CheckBoxPreference;
import com.baidu.searchbox.widget.preference.Preference;
import com.baidu.searchbox.widget.preference.PreferenceCategory;
import com.baidu.searchbox.widget.preference.PreferenceFragment;
import com.baidu.searchbox.widget.preference.PreferenceScreen;
import com.baidu.searchbox.widget.preference.TimePickerPreference;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
import shark.AndroidReferenceMatchers;

public class LockScreenSettingActivity extends NativeBottomNavigationActivity implements ILockScreenActivity {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = LockScreenUiUtils.GLOBAL_DEBUG;
    public static final String FRAGMENT_TAG = "Settings";
    private static final int LOCKSCREEN_SETTING_ACTION_BAR_HEIGHT = 165;
    public static final String TAG = "LockScreenSetting";
    public String mOpenSettingFrom = Constant.OPERATION_IN_CLIENT_SETTING;
    private RelativeLayout mRootView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(Constant.OPEN_LOCK_SCREEN_SETTING_FROM);
            this.mOpenSettingFrom = stringExtra;
            if (stringExtra == null) {
                this.mOpenSettingFrom = Constant.OPERATION_IN_CLIENT_SETTING;
            }
        }
        super.onCreate(savedInstanceState);
        setPendingTransition(R.anim.lockscreen_slide_in_from_right, R.anim.lockscreen_slide_out_to_left, R.anim.lockscreen_slide_in_from_left, R.anim.lockscreen_slide_out_to_right);
        setEnableSliding(true);
        setContentView(com.baidu.searchbox.lockscreen.host.R.layout.lockscreen_settings);
        getSupportFragmentManager().beginTransaction().add(com.baidu.searchbox.lockscreen.host.R.id.lockscreen_settings_fragment, (Fragment) LockScreenSettingsFragment.newInstance(this.mOpenSettingFrom), "Settings").commit();
        setActionBarTitle(getResources().getString(R.string.lockscreen_setting_title));
        showActionBarWithoutLeft();
        this.mRootView = (RelativeLayout) findViewById(com.baidu.searchbox.lockscreen.host.R.id.lockscreen_settings_root_view);
        if (TextUtils.equals(Constant.OPERATION_IN_LOCK_SCREEN_SETTING, this.mOpenSettingFrom)) {
            initLockScreenSetting();
        }
    }

    private void initLockScreenSetting() {
        LockScreenUtil.setViewShowFrontLockView((Activity) this);
        ActivityStack.getInstance().pushActivity(this);
        if (this.mToolBar != null) {
            this.mToolBar.setVisibility(8);
        }
        BdActionBar bdActionBar = getBdActionBar();
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2Src(R.drawable.lockscreen_settings_close);
            bdActionBar.setRightImgZone2Visibility(0);
            bdActionBar.setRightImgZone2OnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (TextUtils.equals(RomUtils.getDeviceBrand(), AndroidReferenceMatchers.SAMSUNG) && TextUtils.equals(DeviceInfoManager.INSTANCE.getModel("flist", "flist").deviceId, "SM-N9600") && Build.VERSION.SDK_INT >= 28) {
                        Intent alarmIntent = new Intent(LockScreenSettingActivity.this.getApplicationContext(), LockScreenActivity.class);
                        alarmIntent.addFlags(268435456);
                        LockScreenSettingActivity.this.startActivity(alarmIntent);
                    }
                    LockScreenSettingActivity.this.finish();
                }
            });
        }
        setActionBarParentHeight(LOCKSCREEN_SETTING_ACTION_BAR_HEIGHT);
        setActionBarGravity(17);
        addSurvey();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && !LockScreenUtil.isNeedOpenAlertWindow(getApplicationContext())) {
            LockScreenSwitch lockScreenSwitch = new LockScreenSwitch();
            lockScreenSwitch.way = "setting";
            lockScreenSwitch.page = this.mOpenSettingFrom;
            LockScreenPreferenceUtils.setActivated(LockScreenPreferenceUtils.KEY_LOCKSCREEN, true);
            LockScreenManager.openLockScreen(this);
            LockScreenHome.reportLockScreenStatus("1", this.mOpenSettingFrom, lockScreenSwitch);
        }
    }

    private void addSurvey() {
        final String rawUrl = LockScreenPreferenceUtils.getString(Config.LOCKSCREEN_SURVEY_URL, "");
        if (!TextUtils.isEmpty(rawUrl) && this.mRootView != null) {
            TextView surveyText = new TextView(this);
            surveyText.setText(R.string.lockscreen_settings_survey);
            surveyText.setTextColor(LockScreenUtil.createColorStateList(getResources().getColor(R.color.lockscreen_settings_survey_normal), getResources().getColor(R.color.lockscreen_settings_survey_click)));
            surveyText.setTextSize(12.0f);
            surveyText.setGravity(17);
            surveyText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(LockScreenRuntime.getAppContext(), LockScreenBrowserActivity.class);
                    intent.putExtra("url", UrlUtil.decodeWithUTF8(rawUrl));
                    LockScreenSettingActivity.this.startActivity(intent);
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.lockscreen_settings_survey_marginbottom);
            this.mRootView.addView(surveyText, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public int getToolBarStyle() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public int getToolBarMenuStyle() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public String getToolBarMenuStatisticSource() {
        return super.getToolBarMenuStatisticSource();
    }

    public void finish() {
        super.finish();
        ActivityStack.getInstance().clearActivity();
    }

    public static class LockScreenSettingsFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {
        private static final String FEED_BACK_ID = "33013";
        private static final String FRAGMENT_OPEN_SETTING_FROM = "fragment_open_setting_screen";
        private static final String KEY_CATEGORY_FEED_BACK = "pref_key_category_feed_back";
        private static final String KEY_CATEGORY_SILENCE_MODE = "pref_key_category_silence_mode";
        private static final String KEY_FEED_BACK = "pref_key_feed_back";
        private static final String KEY_SETTING_CATEGORY_SHOW_NEWS = "pref_key_category_setting_show_news";
        private static final String KEY_SETTING_LOCK_READ = "pref_key_setting_lock_read";
        private static final String KEY_SETTING_NOTIFICATION = "pref_key_setting_notification";
        private static final String KEY_SETTING_SHOW_NEWS = "pref_key_setting_show_news";
        private static final String KEY_SETTING_SILENCE_MODE = "pref_key_setting_silence_mode";
        private static final String KEY_SILENCE_MODE_END_TIME = "pref_key_silence_mode_end_time";
        private static final String KEY_SILENCE_MODE_START_TIME = "pref_key_silence_mode_start_time";
        private static final String SILENCE_MODE_DEFAULT_END_TIME = "21600000";
        private static final String SILENCE_MODE_DEFAULT_START_TIME = "84600000";
        private PreferenceCategory mFeedBackCategory;
        private Preference mFeedBackItem;
        private Flow mFlow;
        public String mOpenSettingFrom = Constant.OPERATION_IN_CLIENT_SETTING;
        private CheckBoxPreference mSettingLockReadItem;
        private CheckBoxPreference mSettingNotificationItem;
        private CheckBoxPreference mSettingShowNewsItem;
        private CheckBoxPreference mSettingSilenceModeItem;
        private TimePickerPreference mSilenceEndTimeItem;
        private PreferenceCategory mSilenceModeCategory;
        private TimePickerPreference mSilenceStartTimeItem;

        public static LockScreenSettingsFragment newInstance(String openSettingFrom) {
            LockScreenSettingsFragment lockScreenSettingsFragment = new LockScreenSettingsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(FRAGMENT_OPEN_SETTING_FROM, openSettingFrom);
            lockScreenSettingsFragment.setArguments(bundle);
            return lockScreenSettingsFragment;
        }

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(com.baidu.searchbox.lockscreen.host.R.xml.lockscreen_settings);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view2 = super.onCreateView(inflater, container, savedInstanceState);
            Bundle bundle = getArguments();
            if (bundle != null) {
                this.mOpenSettingFrom = bundle.getString(FRAGMENT_OPEN_SETTING_FROM);
            }
            return view2;
        }

        public void onActivityCreated(Bundle savedInstanceState) {
            CheckBoxPreference checkBoxPreference;
            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference(KEY_SETTING_LOCK_READ);
            this.mSettingLockReadItem = checkBoxPreference2;
            if (checkBoxPreference2 != null) {
                checkBoxPreference2.setOnPreferenceClickListener(this);
            }
            this.mSettingShowNewsItem = (CheckBoxPreference) findPreference(KEY_SETTING_SHOW_NEWS);
            if (1 != LockScreenUiUtils.getCardHideType() || (checkBoxPreference = this.mSettingShowNewsItem) == null) {
                getPreferenceScreen().removePreference(findPreference(KEY_SETTING_CATEGORY_SHOW_NEWS));
            } else {
                checkBoxPreference.setOnPreferenceClickListener(this);
            }
            CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference(KEY_SETTING_NOTIFICATION);
            this.mSettingNotificationItem = checkBoxPreference3;
            if (checkBoxPreference3 != null) {
                checkBoxPreference3.setOnPreferenceClickListener(this);
            }
            this.mFeedBackCategory = (PreferenceCategory) findPreference(KEY_CATEGORY_FEED_BACK);
            Preference findPreference = findPreference(KEY_FEED_BACK);
            this.mFeedBackItem = findPreference;
            if (findPreference != null) {
                findPreference.setOnPreferenceClickListener(this);
            }
            this.mSilenceModeCategory = (PreferenceCategory) findPreference(KEY_CATEGORY_SILENCE_MODE);
            CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) findPreference(KEY_SETTING_SILENCE_MODE);
            this.mSettingSilenceModeItem = checkBoxPreference4;
            if (checkBoxPreference4 != null) {
                checkBoxPreference4.setOnPreferenceClickListener(this);
            }
            TimePickerPreference timePickerPreference = (TimePickerPreference) findPreference(KEY_SILENCE_MODE_START_TIME);
            this.mSilenceStartTimeItem = timePickerPreference;
            if (timePickerPreference != null) {
                timePickerPreference.setOnPreferenceChangeListener(this);
                if (TextUtils.equals(Constant.OPERATION_IN_LOCK_SCREEN_SETTING, this.mOpenSettingFrom)) {
                    this.mSilenceStartTimeItem.setViewShowFrontLockView(true);
                }
            }
            TimePickerPreference timePickerPreference2 = (TimePickerPreference) findPreference(KEY_SILENCE_MODE_END_TIME);
            this.mSilenceEndTimeItem = timePickerPreference2;
            if (timePickerPreference2 != null) {
                timePickerPreference2.setOnPreferenceChangeListener(this);
                if (TextUtils.equals(Constant.OPERATION_IN_LOCK_SCREEN_SETTING, this.mOpenSettingFrom)) {
                    this.mSilenceEndTimeItem.setViewShowFrontLockView(true);
                }
            }
            if (!TextUtils.equals(Constant.OPERATION_IN_LOCK_SCREEN_SETTING, this.mOpenSettingFrom)) {
                updateClientUI();
            }
            super.onActivityCreated(savedInstanceState);
        }

        public void onResume() {
            super.onResume();
            initView();
            if (TextUtils.equals(Constant.OPERATION_IN_LOCK_SCREEN_SETTING, this.mOpenSettingFrom)) {
                beginPage();
            }
        }

        public void onPause() {
            super.onPause();
            if (TextUtils.equals(Constant.OPERATION_IN_LOCK_SCREEN_SETTING, this.mOpenSettingFrom)) {
                endPage();
            }
        }

        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            if (preference.getIntent() != null) {
                BaseActivity.setNextPendingTransition(R.anim.lockscreen_slide_in_from_right, R.anim.lockscreen_slide_out_to_left, R.anim.lockscreen_slide_in_from_left, R.anim.lockscreen_slide_out_to_right);
            }
            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }

        public boolean onPreferenceClick(Preference preference) {
            TimePickerPreference timePickerPreference;
            String str;
            String key = preference.getKey();
            if (KEY_SETTING_LOCK_READ.equals(key)) {
                boolean result = this.mSettingLockReadItem.isChecked();
                LockScreenSwitch lockScreenSwitch = new LockScreenSwitch();
                lockScreenSwitch.way = "setting";
                lockScreenSwitch.page = this.mOpenSettingFrom;
                if (!result) {
                    if (LockScreenUtil.GLOBAL_DEBUG) {
                        TestFileUtil.appendRecord("LockScreenSettingActivity onPreferenceClick closeLockScreen service");
                    }
                    LockScreenManager.closeLockScreen(getContext());
                    LockScreenHome.reportLockScreenStatus("0", this.mOpenSettingFrom, lockScreenSwitch);
                } else if (LockScreenUtil.isNeedOpenAlertWindow(getContext())) {
                    this.mSettingLockReadItem.setChecked(false);
                    new AlertWindowRequestPermission(getActivity()).mBoxAlertDialog.show();
                    return true;
                } else {
                    LockScreenPreferenceUtils.setActivated(LockScreenPreferenceUtils.KEY_LOCKSCREEN, result);
                    LockScreenManager.openLockScreen(getContext());
                    if (!TextUtils.equals(Constant.OPERATION_IN_LOCK_SCREEN_SETTING, this.mOpenSettingFrom) && LockScreenUtil.shouldOpenGuide()) {
                        LockScreenUtil.startGuideActivity(getContext());
                    }
                    LockScreenHome.reportLockScreenStatus("1", this.mOpenSettingFrom, lockScreenSwitch);
                }
                return true;
            } else if (KEY_SETTING_SHOW_NEWS.equals(key)) {
                boolean result2 = this.mSettingShowNewsItem.isChecked();
                LockScreenPreferenceUtils.putBoolean(LockScreenPreferenceUtils.KEY_LOCKSCREEN_SHOW_NEWS, result2);
                String str2 = this.mOpenSettingFrom;
                if (result2) {
                    str = "on";
                } else {
                    str = "off";
                }
                LockScreenHome.reportShowNewsClick(str2, LockScreenStatisticConstants.SHOW_NEWS_SWITCH_PAGE, str);
                return true;
            } else if (KEY_SETTING_NOTIFICATION.equals(key)) {
                boolean result3 = this.mSettingNotificationItem.isChecked();
                new SharedPrefsWrapper("").putBoolean(LockScreenPreferenceUtils.KEY_LOCKSCREEN_NOTIFI, result3);
                if (result3) {
                    LockScreenHome.reportNotification("1", this.mOpenSettingFrom);
                } else {
                    LockScreenHome.reportNotification("0", this.mOpenSettingFrom);
                }
                return true;
            } else if (KEY_FEED_BACK.equals(key)) {
                FeedbackInfoManager.startToFeedbackEditActivity(FEED_BACK_ID, new FeedBackInvokeListener());
                LockScreenHome.reportFeedBack(this.mOpenSettingFrom);
                return true;
            } else if (!KEY_SETTING_SILENCE_MODE.equals(key)) {
                return false;
            } else {
                boolean result4 = this.mSettingSilenceModeItem.isChecked();
                PreferenceCategory preferenceCategory = this.mSilenceModeCategory;
                if (!(preferenceCategory == null || (timePickerPreference = this.mSilenceStartTimeItem) == null || this.mSilenceEndTimeItem == null)) {
                    if (result4) {
                        preferenceCategory.addPreference(timePickerPreference);
                        this.mSilenceModeCategory.addPreference(this.mSilenceEndTimeItem);
                        updateSilenceModeTimeItem();
                    } else {
                        preferenceCategory.removePreference(timePickerPreference);
                        this.mSilenceModeCategory.removePreference(this.mSilenceEndTimeItem);
                    }
                    LockScreenHome.reportSilenceMode(result4, this.mSilenceStartTimeItem.getValue(), this.mSilenceEndTimeItem.getValue(), this.mOpenSettingFrom);
                }
                LockScreenPreferenceUtils.setSilenceModeOpen(result4);
                return true;
            }
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String key = preference.getKey();
            if (KEY_SILENCE_MODE_START_TIME.equals(key)) {
                if (!LockScreenPreferenceUtils.setSilenceModeTime((String) newValue, 0)) {
                    return false;
                }
                LockScreenHome.reportSilenceMode(true, (String) newValue, this.mSilenceEndTimeItem.getValue(), this.mOpenSettingFrom);
            } else if (KEY_SILENCE_MODE_END_TIME.equals(key)) {
                if (!LockScreenPreferenceUtils.setSilenceModeTime((String) newValue, 1)) {
                    return false;
                }
                LockScreenHome.reportSilenceMode(true, this.mSilenceStartTimeItem.getValue(), (String) newValue, this.mOpenSettingFrom);
            }
            return true;
        }

        private void initView() {
            CheckBoxPreference checkBoxPreference;
            CheckBoxPreference checkBoxPreference2 = this.mSettingLockReadItem;
            if (checkBoxPreference2 != null) {
                checkBoxPreference2.setChecked(LockScreenPreferenceUtils.isActivated(getContext()));
            }
            if (!(1 != LockScreenUiUtils.getCardHideType() || (checkBoxPreference = this.mSettingShowNewsItem) == null || checkBoxPreference == null)) {
                checkBoxPreference.setChecked(LockScreenPreferenceUtils.getBoolean(LockScreenPreferenceUtils.KEY_LOCKSCREEN_SHOW_NEWS, true));
            }
            CheckBoxPreference checkBoxPreference3 = this.mSettingNotificationItem;
            if (checkBoxPreference3 != null) {
                checkBoxPreference3.setChecked(new SharedPrefsWrapper("").getBoolean(LockScreenPreferenceUtils.KEY_LOCKSCREEN_NOTIFI, true));
            }
            if (this.mSettingSilenceModeItem != null && this.mSilenceStartTimeItem != null && this.mSilenceEndTimeItem != null) {
                boolean isSilenceModeOpen = LockScreenPreferenceUtils.isSilenceModeOpen();
                this.mSettingSilenceModeItem.setChecked(isSilenceModeOpen);
                PreferenceCategory preferenceCategory = this.mSilenceModeCategory;
                if (preferenceCategory == null) {
                    return;
                }
                if (isSilenceModeOpen) {
                    preferenceCategory.addPreference(this.mSilenceStartTimeItem);
                    this.mSilenceModeCategory.addPreference(this.mSilenceEndTimeItem);
                    updateSilenceModeTimeItem();
                    return;
                }
                preferenceCategory.removePreference(this.mSilenceStartTimeItem);
                this.mSilenceModeCategory.removePreference(this.mSilenceEndTimeItem);
            }
        }

        private void updateClientUI() {
            Preference preference;
            PreferenceCategory preferenceCategory = this.mFeedBackCategory;
            if (preferenceCategory != null && (preference = this.mFeedBackItem) != null) {
                preferenceCategory.removePreference(preference);
            }
        }

        public void beginPage() {
            this.mFlow = UBC.beginFlow(LockScreenStatisticConstants.DURATION_ID_NOT_LANDING, createDurationParams());
        }

        public void endPage() {
            Flow flow = this.mFlow;
            if (flow != null) {
                flow.setValueWithDuration(createDurationParams());
                this.mFlow.end();
                this.mFlow = null;
            }
        }

        private String createDurationParams() {
            JSONObject object = new JSONObject();
            try {
                object.put("page", LockScreenStatisticConstants.PAGE_SETTING);
            } catch (JSONException e2) {
                if (LockScreenSettingActivity.DEBUG) {
                    e2.printStackTrace();
                }
            }
            return object.toString();
        }

        private void updateSilenceModeTimeItem() {
            if (this.mSilenceStartTimeItem != null && this.mSilenceEndTimeItem != null) {
                String startTime = LockScreenPreferenceUtils.getMultiPreference(LockScreenPreferenceUtils.KEY_LOCKSCREEN_SILENCE_MODE_START_TIME, "");
                String endTime = LockScreenPreferenceUtils.getMultiPreference(LockScreenPreferenceUtils.KEY_LOCKSCREEN_SILENCE_MODE_END_TIME, "");
                if (TextUtils.isEmpty(startTime)) {
                    startTime = SILENCE_MODE_DEFAULT_START_TIME;
                    LockScreenPreferenceUtils.setSilenceModeTime(startTime, 0);
                }
                if (TextUtils.isEmpty(endTime)) {
                    endTime = SILENCE_MODE_DEFAULT_END_TIME;
                    LockScreenPreferenceUtils.setSilenceModeTime(endTime, 1);
                }
                this.mSilenceStartTimeItem.setValue(startTime, true);
                this.mSilenceEndTimeItem.setValue(endTime, true);
            }
        }

        private static class FeedBackInvokeListener implements FeedbackInfoManager.IFeedbackCallback {
            private FeedBackInvokeListener() {
            }

            public void onResult(int status, String a2) {
                if (LockScreenUtil.GLOBAL_DEBUG) {
                    Log.e(LockScreenSettingActivity.TAG, "feedback call:" + a2);
                }
                String result = "";
                try {
                    result = new JSONObject(a2).getString("result");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (!TextUtils.isEmpty(result) && "success".equals(result)) {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            UniversalToast.makeText(LockScreenRuntime.getAppContext(), com.baidu.searchbox.lockscreen.host.R.string.lockscreen_search_antihijack_upload_succ).setDuration(2).showToast();
                        }
                    });
                }
            }
        }
    }
}
