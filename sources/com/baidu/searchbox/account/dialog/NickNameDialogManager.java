package com.baidu.searchbox.account.dialog;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.app.account.BoxAccountContants;
import com.baidu.android.app.account.BoxAccountPreference;
import com.baidu.android.app.account.BoxSapiAccountManager;
import com.baidu.android.app.account.utils.LogUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountDialog;
import com.baidu.searchbox.account.IGetBoxAccountListener;
import com.baidu.searchbox.account.INickNameGuideDialogListener;
import com.baidu.searchbox.account.INickNamePortraitDialogCallback;
import com.baidu.searchbox.account.component.NicknamePortraitConfig;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.dialog.NicknameGuideDialog;
import com.baidu.searchbox.account.manager.AccountLoginDialogManager;
import com.baidu.searchbox.account.request.AccountSaveRequest;
import com.baidu.searchbox.account.result.NickNameGuideErrorCode;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.push.MyMessageConstants;
import com.baidu.ubc.UBCManager;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class NickNameDialogManager {
    public static final String UBC_EXT_BUTTONSTATE = "buttonstate";
    public static final String UBC_EXT_CHANGE = "change";
    public static final String UBC_EXT_CONFIRM = "confirm";
    public static final String UBC_EXT_NICKNAME = "nickname";
    public static final String UBC_EXT_PORTRAIT_URL = "url";
    public static final String UBC_FROM_VALUE = "personalpage";
    public static final String UBC_SOURCE_VALUE_SIGNIN = "login";
    public static final String UBC_TYPE_CANCEL = "cancel";
    public static final String UBC_TYPE_CHANGE = "change";
    public static final String UBC_TYPE_CONFIRM = "confirm";
    public static final String UBC_TYPE_EDIT = "edit";
    public static final String UBC_TYPE_PORTRAIT_CHANGE = "portrait_change";
    public static final String UBC_TYPE_PORTRAIT_EDIT = "portrait_edit";
    public static final String UBC_TYPE_PORTRAIT_SAVE = "portrait_save";
    public static final String UBC_TYPE_SHOW = "show";
    public static final String UBC_VALUE_FAILED = "failing";
    public static final String UBC_VALUE_SUCCESS = "success";
    private static INickNameGuideDialogListener mListener;
    public static NicknameGuideDialog mNickNameDialog;
    private static INickNamePortraitDialogCallback mNicknamePortraitCallback;

    public static void showFirstPopupDistributeDialog(final Activity activity, String source, final INickNamePortraitDialogCallback listener) {
        if (!ActivityUtils.isDestroyed(activity) && (activity instanceof FragmentActivity)) {
            final BoxSapiAccountManager accountManager = (BoxSapiAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            if (accountManager.shouldShowFirstPopupDialog()) {
                final String ubcSource = PtokenStat.LOGIN + source;
                accountManager.getAccountFirstPopupFromServer(new IGetBoxAccountListener() {
                    public void onSuccess(BoxAccount account) {
                        if (account != null) {
                            switch (account.getFirstPopType()) {
                                case 1:
                                    NicknameGuideDialog nicknameGuideDialog = new NicknameGuideDialog(NicknameGuideDialog.DialogType.DISTRIBUTE, ubcSource, new INickNameGuideDialogListener() {
                                        public void isShowSuccess(boolean isShow, int errorCode) {
                                            if (listener != null) {
                                                listener.onDialogShow(isShow, errorCode);
                                            }
                                        }

                                        public void dismissByModifySuccess(boolean isModifySuccess) {
                                            if (listener != null) {
                                                listener.onDialogDismiss();
                                            }
                                        }

                                        public void onDialogCreate(IAccountDialog dialog) {
                                        }
                                    });
                                    nicknameGuideDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), "NickNameDialogManager");
                                    listener.onDialogCreate(nicknameGuideDialog);
                                    break;
                                case 2:
                                    NicknamePortraitConfig portraitConfig = NicknamePortraitConfig.getDefaultBuilder().setSource(ubcSource).build();
                                    portraitConfig.isRecommend = false;
                                    NicknamePortraitGuideDialog portraitGuideDialog = new NicknamePortraitGuideDialog(portraitConfig, listener);
                                    portraitGuideDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), "NickNameDialogManager");
                                    listener.onDialogCreate(portraitGuideDialog);
                                    break;
                                case 3:
                                    NicknamePortraitConfig.Builder builder = new NicknamePortraitConfig.Builder();
                                    builder.setNicknamePortraitType(2).setSource(ubcSource);
                                    NicknamePortraitConfig config = builder.build();
                                    config.isRecommend = false;
                                    NicknamePortraitGuideDialog dialog = new NicknamePortraitGuideDialog(config, listener);
                                    dialog.show(((FragmentActivity) activity).getSupportFragmentManager(), "NickNameDialogManager");
                                    listener.onDialogCreate(dialog);
                                    break;
                                default:
                                    INickNamePortraitDialogCallback iNickNamePortraitDialogCallback = listener;
                                    if (iNickNamePortraitDialogCallback != null) {
                                        iNickNamePortraitDialogCallback.onDialogShow(false, NickNameGuideErrorCode.NO_NEED_DISTRIBUTE);
                                        return;
                                    }
                                    return;
                            }
                            new AccountSaveRequest().requestModifyIsLay();
                            BoxAccount boxAccount = accountManager.getBoxAccount();
                            if (boxAccount != null) {
                                boxAccount.setIsLay("1");
                                BoxAccountPreference.setAccountStringPreference(BoxAccountContants.ACCOUNT_ISLAY, "1");
                                return;
                            }
                            return;
                        }
                        INickNamePortraitDialogCallback iNickNamePortraitDialogCallback2 = listener;
                        if (iNickNamePortraitDialogCallback2 != null) {
                            iNickNamePortraitDialogCallback2.onDialogShow(false, 4000);
                        }
                    }

                    public void onFailed(int errorCode) {
                        INickNamePortraitDialogCallback iNickNamePortraitDialogCallback = listener;
                        if (iNickNamePortraitDialogCallback == null) {
                            return;
                        }
                        if (errorCode == 4) {
                            iNickNamePortraitDialogCallback.onDialogShow(false, NickNameGuideErrorCode.NO_NEED_DISTRIBUTE);
                        } else {
                            iNickNamePortraitDialogCallback.onDialogShow(false, 4000);
                        }
                    }
                });
            } else if (listener != null) {
                listener.onDialogShow(false, 4000);
            }
        }
    }

    @Deprecated
    public static void showShareLoginDialog(final Activity activity, final String source, final INickNameGuideDialogListener listener) {
        mListener = listener;
        if (!ActivityUtils.isDestroyed(activity) && (activity instanceof FragmentActivity)) {
            BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            BoxAccount boxAccount = accountManager.getBoxAccount();
            if (accountManager.isLogin(2)) {
                if ((System.currentTimeMillis() / 1000) - getLastTime() < boxAccount.getGuideNickDialogInterval()) {
                    if (listener != null) {
                        listener.isShowSuccess(false, NickNameGuideErrorCode.UNARRIVED_TIME_INTERVAL);
                    }
                } else if (!TextUtils.equals(boxAccount.getPopType(), "1")) {
                    if (listener != null) {
                        listener.isShowSuccess(false, 4000);
                    }
                } else if (boxAccount.isDefaultNick()) {
                    ((BoxSapiAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getAccountInfoFromServer(new IGetBoxAccountListener() {
                        public void onSuccess(BoxAccount account) {
                            if (TextUtils.equals(account.getPopType(), "0")) {
                                NickNameDialogManager.invokeDistributeDialog(activity, source, listener);
                            } else if (TextUtils.equals(account.getPopType(), "1")) {
                                NickNameDialogManager.invokeRecommendDialog(activity, source, listener);
                            } else {
                                INickNameGuideDialogListener iNickNameGuideDialogListener = listener;
                                if (iNickNameGuideDialogListener != null) {
                                    iNickNameGuideDialogListener.isShowSuccess(false, 4000);
                                }
                            }
                        }

                        public void onFailed(int errorCode) {
                            INickNameGuideDialogListener iNickNameGuideDialogListener = listener;
                            if (iNickNameGuideDialogListener != null) {
                                iNickNameGuideDialogListener.isShowSuccess(false, 4000);
                            }
                        }
                    });
                } else if (listener != null) {
                    listener.isShowSuccess(false, NickNameGuideErrorCode.NO_DEFAULT_NICKNAME);
                }
            } else if (listener != null) {
                listener.isShowSuccess(false, NickNameGuideErrorCode.NO_SUPPORT_GUEST_LOGIN);
            }
        } else if (listener != null) {
            listener.isShowSuccess(false, 4000);
        }
    }

    private static boolean isLandscape() {
        Configuration configuration;
        Resources resources = AppRuntime.getAppContext().getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    public static void showShareLoginDialog(Activity activity, int nicknameDialogType, String source, INickNameGuideDialogListener listener) {
        final Activity activity2 = activity;
        int i2 = nicknameDialogType;
        final INickNameGuideDialogListener iNickNameGuideDialogListener = listener;
        mListener = iNickNameGuideDialogListener;
        if (ActivityUtils.isDestroyed(activity) || !(activity2 instanceof FragmentActivity)) {
            String str = source;
        } else if (isLandscape()) {
            String str2 = source;
        } else {
            BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            BoxAccount boxAccount = accountManager.getBoxAccount();
            if (accountManager.isLogin(2)) {
                long currentTime = System.currentTimeMillis() / 1000;
                long lastTime = getLastTime();
                long nickDialogInterval = 0;
                if (i2 == 0) {
                    nickDialogInterval = getNickNameDistributeInterval();
                } else if (i2 == 1) {
                    nickDialogInterval = getNickNameRecommendInterval();
                }
                if (currentTime - lastTime < nickDialogInterval) {
                    if (iNickNameGuideDialogListener != null) {
                        iNickNameGuideDialogListener.isShowSuccess(false, NickNameGuideErrorCode.UNARRIVED_TIME_INTERVAL);
                        return;
                    }
                    return;
                } else if (isDialogExit(currentTime - lastTime)) {
                    if (iNickNameGuideDialogListener != null) {
                        iNickNameGuideDialogListener.isShowSuccess(false, NickNameGuideErrorCode.UNARRIVED_TIME_INTERVAL);
                        return;
                    }
                    return;
                } else if (boxAccount.isDefaultNick()) {
                    final String str3 = source;
                    ((BoxSapiAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getAccountNicknamePopupFromServer(i2, new IGetBoxAccountListener() {
                        public void onSuccess(BoxAccount account) {
                            if (TextUtils.equals(account.getPopType(), "0")) {
                                NickNameDialogManager.invokeDistributeDialog(activity2, str3, iNickNameGuideDialogListener);
                            } else if (TextUtils.equals(account.getPopType(), "1")) {
                                NickNameDialogManager.invokeRecommendDialog(activity2, str3, iNickNameGuideDialogListener);
                            } else {
                                INickNameGuideDialogListener iNickNameGuideDialogListener = iNickNameGuideDialogListener;
                                if (iNickNameGuideDialogListener != null) {
                                    iNickNameGuideDialogListener.isShowSuccess(false, 4000);
                                }
                            }
                        }

                        public void onFailed(int errorCode) {
                            INickNameGuideDialogListener iNickNameGuideDialogListener = iNickNameGuideDialogListener;
                            if (iNickNameGuideDialogListener == null) {
                                return;
                            }
                            if (errorCode == 3) {
                                iNickNameGuideDialogListener.isShowSuccess(false, NickNameGuideErrorCode.NO_DEFAULT_NICKNAME);
                            } else {
                                iNickNameGuideDialogListener.isShowSuccess(false, 4000);
                            }
                        }
                    });
                    return;
                } else if (iNickNameGuideDialogListener != null) {
                    iNickNameGuideDialogListener.isShowSuccess(false, NickNameGuideErrorCode.NO_DEFAULT_NICKNAME);
                    return;
                } else {
                    return;
                }
            } else if (iNickNameGuideDialogListener != null) {
                iNickNameGuideDialogListener.isShowSuccess(false, NickNameGuideErrorCode.NO_SUPPORT_GUEST_LOGIN);
                return;
            } else {
                return;
            }
        }
        if (iNickNameGuideDialogListener != null) {
            iNickNameGuideDialogListener.isShowSuccess(false, 4000);
        }
    }

    private static boolean isDialogExit(long interval) {
        long times = getShowCount();
        long maxTimes = getMaxShowGuideTimes();
        long notShowInterval = getNotShowGuideInterval();
        if (times < maxTimes) {
            return false;
        }
        if (maxTimes <= 0 || interval < notShowInterval) {
            return true;
        }
        setShowCount(0);
        return false;
    }

    public static long getNickNameRecommendInterval() {
        return BoxAccountPreference.getAccountLongPreference(BoxAccountContants.RECOMMEND_INTERVAL, 604800);
    }

    public static long getNickNameDistributeInterval() {
        return BoxAccountPreference.getAccountLongPreference(BoxAccountContants.DISTRIBUTE_INTERVAL, 86400);
    }

    public static long getMaxShowGuideTimes() {
        return BoxAccountPreference.getAccountLongPreference(BoxAccountContants.MAX_SHOW_GUIDE_TIMES, 3);
    }

    public static long getNotShowGuideInterval() {
        return BoxAccountPreference.getAccountLongPreference(BoxAccountContants.NOT_SHOW_GUIDE_INTERVAL, MyMessageConstants.LEADING_DIALOG_ADJUST_INTERVAL_TIME);
    }

    public static long getLastTime() {
        return BoxAccountPreference.getAccountLongPreference(BoxAccountContants.ACCOUNT_NICKDIALOG_LAST_TIME, 0);
    }

    public static void setShowTime() {
        BoxAccountPreference.setAccountLongPreference(BoxAccountContants.ACCOUNT_NICKDIALOG_LAST_TIME, System.currentTimeMillis() / 1000);
    }

    public static long getShowCount() {
        return BoxAccountPreference.getAccountLongPreference(BoxAccountContants.SHOW_GUIDE_COUNT, 0);
    }

    public static void setShowCount(long count) {
        BoxAccountPreference.setAccountLongPreference(BoxAccountContants.SHOW_GUIDE_COUNT, count);
    }

    /* access modifiers changed from: private */
    public static void invokeDistributeDialog(Activity activity, String source, INickNameGuideDialogListener listener) {
        if (activity != null && !activity.isFinishing()) {
            mListener = listener;
            NicknameGuideDialog nicknameGuideDialog = new NicknameGuideDialog(NicknameGuideDialog.DialogType.DISTRIBUTE, source, listener);
            mNickNameDialog = nicknameGuideDialog;
            nicknameGuideDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), AccountLoginDialogManager.TAG);
            if (listener != null) {
                listener.onDialogCreate(mNickNameDialog);
            }
        } else if (listener != null) {
            listener.isShowSuccess(false, 4000);
        }
    }

    /* access modifiers changed from: private */
    public static void invokeRecommendDialog(Activity activity, String source, INickNameGuideDialogListener listener) {
        if (activity != null && !activity.isFinishing()) {
            mListener = listener;
            NicknameGuideDialog nicknameGuideDialog = new NicknameGuideDialog(NicknameGuideDialog.DialogType.RECOMMEND, source, listener);
            mNickNameDialog = nicknameGuideDialog;
            nicknameGuideDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), AccountLoginDialogManager.TAG);
            if (listener != null) {
                listener.onDialogCreate(mNickNameDialog);
            }
        } else if (listener != null) {
            listener.isShowSuccess(false, 4000);
        }
    }

    public static void dismissDialog() {
        NicknameGuideDialog nicknameGuideDialog = mNickNameDialog;
        if (nicknameGuideDialog != null) {
            nicknameGuideDialog.dismissAllowingStateLoss();
            INickNameGuideDialogListener iNickNameGuideDialogListener = mListener;
            if (iNickNameGuideDialogListener != null) {
                iNickNameGuideDialogListener.dismissByModifySuccess(false);
                mListener = null;
            }
            mNickNameDialog = null;
        }
    }

    public static int getNickNamePortraitType() {
        BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (!accountManager.isLogin(2)) {
            return -1;
        }
        BoxAccount boxAccount = accountManager.getBoxAccount();
        if (boxAccount.isDefaultNick() && !boxAccount.isDefaultPortriat()) {
            return 0;
        }
        if (!boxAccount.isDefaultNick() && boxAccount.isDefaultPortriat()) {
            return 1;
        }
        if (!boxAccount.isDefaultNick() || !boxAccount.isDefaultPortriat()) {
            return 3;
        }
        return 2;
    }

    public static void showNicknamePortraitDialog(Activity activity, NicknamePortraitConfig config, INickNamePortraitDialogCallback callback) {
        NicknamePortraitConfig config2;
        final Activity activity2 = activity;
        final INickNamePortraitDialogCallback iNickNamePortraitDialogCallback = callback;
        if (config == null) {
            config2 = NicknamePortraitConfig.getDefaultBuilder().build();
        } else {
            config2 = config;
        }
        if (ActivityUtils.isDestroyed(activity) || !(activity2 instanceof FragmentActivity)) {
            if (iNickNamePortraitDialogCallback != null) {
                iNickNamePortraitDialogCallback.onDialogShow(false, 4000);
            }
        } else if (((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin(2)) {
            int nicknamePortraitType = config2.nicknamePortraitType;
            if (nicknamePortraitType == -1) {
                nicknamePortraitType = getNickNamePortraitType();
            }
            if (nicknamePortraitType != 3) {
                config2.nicknamePortraitType = nicknamePortraitType;
                if (nicknamePortraitType == 0) {
                    showShareLoginDialog(activity2, 1, config2.source, new INickNameGuideDialogListener() {
                        public void isShowSuccess(boolean isShow, int errorCode) {
                            INickNamePortraitDialogCallback iNickNamePortraitDialogCallback = INickNamePortraitDialogCallback.this;
                            if (iNickNamePortraitDialogCallback != null) {
                                iNickNamePortraitDialogCallback.onDialogShow(isShow, errorCode);
                            }
                        }

                        public void dismissByModifySuccess(boolean isModifySuccess) {
                            INickNamePortraitDialogCallback iNickNamePortraitDialogCallback = INickNamePortraitDialogCallback.this;
                            if (iNickNamePortraitDialogCallback != null) {
                                iNickNamePortraitDialogCallback.onNicknameModifyResult(isModifySuccess);
                            }
                        }

                        public void onDialogCreate(IAccountDialog dialog) {
                        }
                    });
                    return;
                }
                long currentTime = System.currentTimeMillis() / 1000;
                long lastTime = getLastTime();
                if (currentTime - lastTime < getNickNameRecommendInterval()) {
                    if (iNickNamePortraitDialogCallback != null) {
                        iNickNamePortraitDialogCallback.onDialogShow(false, NickNameGuideErrorCode.UNARRIVED_TIME_INTERVAL);
                    }
                } else if (isDialogExit(currentTime - lastTime)) {
                    if (iNickNamePortraitDialogCallback != null) {
                        iNickNamePortraitDialogCallback.onDialogShow(false, NickNameGuideErrorCode.UNARRIVED_TIME_INTERVAL);
                    }
                } else if (nicknamePortraitType == 1) {
                    invokeNicknamePortraitDialog(activity2, config2, iNickNamePortraitDialogCallback);
                } else {
                    final NicknamePortraitConfig finalConfig = config2;
                    ((BoxSapiAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getAccountNicknamePopupFromServer(1, new IGetBoxAccountListener() {
                        public void onSuccess(BoxAccount account) {
                            NickNameDialogManager.invokeNicknamePortraitDialog(activity2, finalConfig, iNickNamePortraitDialogCallback);
                        }

                        public void onFailed(int errorCode) {
                            INickNamePortraitDialogCallback iNickNamePortraitDialogCallback = iNickNamePortraitDialogCallback;
                            if (iNickNamePortraitDialogCallback == null) {
                                return;
                            }
                            if (errorCode == 3) {
                                iNickNamePortraitDialogCallback.onDialogShow(false, NickNameGuideErrorCode.NO_DEFAULT_NICKNAME_PORTRAIT);
                            } else {
                                iNickNamePortraitDialogCallback.onDialogShow(false, 4000);
                            }
                        }
                    });
                }
            } else if (iNickNamePortraitDialogCallback != null) {
                iNickNamePortraitDialogCallback.onDialogShow(false, NickNameGuideErrorCode.NO_DEFAULT_NICKNAME_PORTRAIT);
            }
        } else if (iNickNamePortraitDialogCallback != null) {
            iNickNamePortraitDialogCallback.onDialogShow(false, NickNameGuideErrorCode.NO_SUPPORT_GUEST_LOGIN);
        }
    }

    public static void invokeNicknamePortraitDialog(Activity activity, NicknamePortraitConfig config, INickNamePortraitDialogCallback callback) {
        if (activity != null && !activity.isFinishing()) {
            mNicknamePortraitCallback = callback;
            new NicknamePortraitGuideDialog(config, callback).show(((FragmentActivity) activity).getSupportFragmentManager(), "NickNameDialogManager");
        } else if (callback != null) {
            callback.onDialogShow(false, 4000);
        }
    }

    public static String getExt(String key, String value) {
        JSONObject jsonExt = new JSONObject();
        try {
            jsonExt.put(key, value);
        } catch (JSONException e2) {
            LogUtils.d(e2.toString());
        }
        return jsonExt.toString();
    }

    public static void staisticUbc(String source, String type, String page, String value, String ext) {
        HashMap<String, String> ubcMap = new HashMap<>();
        ubcMap.put("from", "personalpage");
        ubcMap.put("source", source);
        ubcMap.put("page", page);
        ubcMap.put("type", type);
        if (!TextUtils.isEmpty(value)) {
            ubcMap.put("value", value);
        }
        if (!TextUtils.isEmpty(ext)) {
            ubcMap.put("ext", ext);
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(BoxAccountContants.NICKNAME_DIALOG_UBC_ID, (Map<String, String>) ubcMap);
    }

    public static boolean checkNickModifyDurationAndTimes(BoxAccount boxAccount) {
        if (boxAccount == null) {
            return false;
        }
        long startTime = getNickModifyDurationStartTime(boxAccount.getUk());
        if (startTime == 0 || System.currentTimeMillis() / 1000 >= boxAccount.getNickModifyDuration() + startTime) {
            return true;
        }
        if (getNickModifyTimes(boxAccount.getUk()) < ((long) boxAccount.getNickModifyTimes())) {
            return true;
        }
        return false;
    }

    public static void updateNickModifyDurationAndTimes() {
        BoxAccount boxAccount = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getBoxAccount();
        if (boxAccount != null) {
            long startTime = getNickModifyDurationStartTime(boxAccount.getUk());
            if (startTime == 0) {
                setNickModifyDurationStartTime(boxAccount.getUk());
            } else if (System.currentTimeMillis() / 1000 > boxAccount.getNickModifyDuration() + startTime) {
                setNickModifyDurationStartTime(boxAccount.getUk());
                setNickModifyTimes(boxAccount.getUk(), 0);
            }
            setNickModifyTimes(boxAccount.getUk(), 1 + getNickModifyTimes(boxAccount.getUk()));
        }
    }

    public static long getNickModifyDurationStartTime(String uk) {
        return getNickModeFreqKeyValue(uk, BoxAccountContants.NICKNAME_MODIFY_DURATION_START_TIME);
    }

    public static void setNickModifyDurationStartTime(String uk) {
        setNickModeFreqKeyValue(uk, BoxAccountContants.NICKNAME_MODIFY_DURATION_START_TIME, getStartTimeOfDay(System.currentTimeMillis()) / 1000);
    }

    public static long getNickModifyTimes(String uk) {
        return getNickModeFreqKeyValue(uk, BoxAccountContants.NICKNAME_MODIFY_TIMES);
    }

    public static void setNickModifyTimes(String uk, long newTimes) {
        setNickModeFreqKeyValue(uk, BoxAccountContants.NICKNAME_MODIFY_TIMES, newTimes);
    }

    public static long getStartTimeOfDay(long dateMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateMillis);
        calendar.setTimeZone(TimeZone.getDefault());
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    private static String getUidKey(String uk) {
        return "BoxAccount_uk_" + uk;
    }

    private static void setNickModeFreqKeyValue(String uk, String key, long value) {
        try {
            String data = BoxAccountPreference.getAccountStringPreference(getUidKey(uk), "");
            JSONObject dataJson = new JSONObject();
            if (!TextUtils.isEmpty(data)) {
                dataJson = new JSONObject(data);
            }
            dataJson.put(key, value);
            BoxAccountPreference.setAccountStringPreference(getUidKey(uk), dataJson.toString());
        } catch (Exception e2) {
            LogUtils.e(e2.toString());
        }
    }

    private static long getNickModeFreqKeyValue(String uk, String key) {
        try {
            String data = BoxAccountPreference.getAccountStringPreference(getUidKey(uk), "");
            if (!TextUtils.isEmpty(data)) {
                return new JSONObject(data).optLong(key);
            }
            return 0;
        } catch (Exception e2) {
            LogUtils.e(e2.toString());
            return 0;
        }
    }
}
