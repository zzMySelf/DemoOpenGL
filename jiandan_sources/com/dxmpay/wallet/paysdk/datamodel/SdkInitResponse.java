package com.dxmpay.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SdkInitResponse implements IBeanResponse {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile boolean f4348ad = true;
    public static final String sNfcCfgKey = "nfcKyc";
    public String acsSupportBanks110;
    public String authSignUrl = "";
    public String backSensorHost = "";
    public String balanceHomeUrl = "";
    public String balanceSchemeUrl = BeanConstants.SWAN_APP_BALANCE_SCHEME_URL;
    public String bankCardListUrl = "";
    public String bankCardSchemeUrl = BeanConstants.SWAN_APP_BANK_CARD_SCHEME_URL;
    public String bankcard_detect;
    public String bindCardCollectUserDataUrl = "";
    public String bindCardReviewingUrl = "";
    public String bindCardSafeTipUrl = "";
    public String certWhiteList = "";
    public String cookiesSyncDomainList = "";
    public int displayAcsMode = 0;
    public String domainConfig = "";
    public String domainSwitch = "";
    public String download_file = "";
    public String download_liveness = "";
    public String dxm_lite_liveness_dependon_cpu = "";
    public String dxmscan_whitelist = "";
    public String findPayPwdUrl = "";
    public String fp = "";
    public String h5CashierUrl = "";
    public String h5ChargeUrl = "";
    public String h5bindCardUrl = "";
    public String hostWhiteList = "";
    public int is_sdk_sm_open = 0;
    public boolean jumpSwanApp = false;
    public String kefuPhoneNum = "";
    public String langbridge_permission_dialog = "";
    public String loadingDurationInterval = "";
    public JSONObject loginUrl;
    public SdkInitCallBack mSdkInitCallBack;
    public String na_method_stat_black_list = "";
    public String needShowLoadingInterval = "";
    public String nfcKyc;
    public int ocrBankCardBadCaseCount = 1;
    public String ocr_idcard_dependon_cpu = "";
    public int openAuthSign = 0;
    public String passAuthUrl = "";
    public String payAuthSignUrl = "";
    public String payConfigUrl = "";
    public String payHost = "";
    public String paymentCodeUrl = "";
    public String permission_dialog_audio = "";
    public String permission_dialog_camera = "";
    public String permission_dialog_contacts = "";
    public String permission_dialog_info = "";
    public String permission_dialog_location = "";
    public String permission_dialog_storage = "";
    public int playback = 0;
    public double playbackEventsSize = 10.0d;
    public int playbackPerCount = 200;
    public String polymerHost = "";
    public String quickBindCardUrl = "";
    public String recordHost = "";
    public String rtcHost = "";
    public String sdk_method_black_list = "";
    public String sdk_net_stat_path_list;
    public long sdk_net_stat_threshold = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    public String sdk_permission_dialog = "";
    public String sdk_sm_path_list;
    public String securityCenterUrl = "";
    public String sensorHost = "";
    public String setPayPwdUrl = "";
    public int showAccessiGuide = 0;
    public String simplify_liveness_dependon_cpu = "";
    public String simulatorInfos = "";
    public int statisticNativePoint_switch = 0;
    public String supportedACS = "0";
    public String takePicWaitTime = "";
    public String transactionRecordsUrl = "";
    public String transactionSchemeUrl = BeanConstants.SWAN_APP_TRANSACTION_SCHEME_URL;
    public String useH5BindCard = "";

    public interface SdkInitCallBack extends NoProguard {
        void onSuccess();
    }

    public static final class qw {
        public static final SdkInitResponse qw = new SdkInitResponse();
    }

    public static SdkInitResponse getInstance() {
        return qw.qw;
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public String getAppPayHost(Context context) {
        if (TextUtils.isEmpty(this.payHost)) {
            this.payHost = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_app_pay_host", "");
        }
        return this.payHost;
    }

    public String getAuthSignUrl(Context context) {
        if (TextUtils.isEmpty(this.authSignUrl)) {
            this.authSignUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_auth_sign_url", "");
        }
        return this.authSignUrl;
    }

    public String getBackSensorHost(Context context) {
        if (TextUtils.isEmpty(this.backSensorHost)) {
            this.backSensorHost = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_back_sensor_host", "");
        }
        return this.backSensorHost;
    }

    public String getBalanceHomeUrl(Context context) {
        if (TextUtils.isEmpty(this.balanceHomeUrl)) {
            this.balanceHomeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.d, "");
        }
        return this.balanceHomeUrl;
    }

    public String getBankCardListUrl(Context context) {
        if (TextUtils.isEmpty(this.bankCardListUrl)) {
            this.bankCardListUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_bank_card_list_url", "");
        }
        return this.bankCardListUrl;
    }

    public String getBindCardSafeTipUrl(Context context) {
        if (TextUtils.isEmpty(this.bindCardSafeTipUrl)) {
            this.bindCardSafeTipUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_bind_card_safe_tip_url", "");
        }
        return this.bindCardSafeTipUrl;
    }

    public String getCollectUserUrl(Context context) {
        if (TextUtils.isEmpty(this.bindCardCollectUserDataUrl)) {
            this.bindCardCollectUserDataUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_bind_card_collect_user_url", "");
        }
        return this.bindCardCollectUserDataUrl;
    }

    public String getCookiesSyncDomainList(Context context) {
        if (TextUtils.isEmpty(this.cookiesSyncDomainList)) {
            this.cookiesSyncDomainList = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.e, "");
        }
        return this.cookiesSyncDomainList;
    }

    public String[] getDxmScanWhiteList(Context context) {
        String[] strArr = new String[0];
        if (TextUtils.isEmpty(this.dxmscan_whitelist)) {
            this.dxmscan_whitelist = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_dxmscan_whitelist", "");
        }
        try {
            return (String[]) JsonUtils.fromJson(this.dxmscan_whitelist, String[].class);
        } catch (JSONException e) {
            e.getMessage();
            return strArr;
        }
    }

    public String getFindPayPwdUrl(Context context) {
        if (TextUtils.isEmpty(this.findPayPwdUrl)) {
            this.findPayPwdUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_find_pay_pwd_url", "");
        }
        return this.findPayPwdUrl;
    }

    public String getH5BindCardUrl(Context context) {
        if (TextUtils.isEmpty(this.h5bindCardUrl)) {
            this.h5bindCardUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_h5_bind_card_url", "");
        }
        return this.h5bindCardUrl;
    }

    public String getH5CashierUrl(Context context) {
        if (TextUtils.isEmpty(this.h5CashierUrl)) {
            this.h5CashierUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_h5_cashier_url", "");
        }
        return this.h5CashierUrl;
    }

    public String getH5ChargeUrl(Context context) {
        if (TextUtils.isEmpty(this.h5ChargeUrl)) {
            this.h5ChargeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_h5_charge_url", "");
        }
        return this.h5ChargeUrl;
    }

    public boolean getIs_sdk_sm_open() {
        return this.is_sdk_sm_open == 1;
    }

    public String getLoadingDurationInterval(Context context) {
        if (TextUtils.isEmpty(this.loadingDurationInterval) && context != null) {
            this.loadingDurationInterval = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.g, "");
        }
        return this.loadingDurationInterval;
    }

    public String getLoginUrl(String str) {
        StatisticManager.onEvent("event_get_bindurl");
        JSONObject jSONObject = this.loginUrl;
        if (jSONObject == null) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public String[] getNaMethodStatBlackList() {
        String[] strArr = new String[0];
        if (TextUtils.isEmpty(this.na_method_stat_black_list)) {
            return strArr;
        }
        try {
            return (String[]) JsonUtils.fromJson(this.na_method_stat_black_list, String[].class);
        } catch (JSONException e) {
            LogUtil.e("SdkInitResponse", e.getMessage(), e);
            return strArr;
        }
    }

    public String getPassAuthUrl(Context context) {
        String str = DomainConfig.getInstance().getAppPayHost() + "/content/resource/pass_normal/index.html";
        if (!TextUtils.isEmpty(qw.qw.passAuthUrl)) {
            return qw.qw.passAuthUrl;
        }
        String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.b, "");
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public String getPayAuthSignUrl(Context context) {
        if (TextUtils.isEmpty(this.payAuthSignUrl)) {
            this.payAuthSignUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_auth_sign_url", "");
        }
        return this.payAuthSignUrl;
    }

    public String getPayCodeUrl(Context context) {
        if (TextUtils.isEmpty(this.paymentCodeUrl)) {
            this.paymentCodeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.c, "");
        }
        return this.paymentCodeUrl;
    }

    public String getPayPwdSettingUrl(Context context) {
        if (TextUtils.isEmpty(this.setPayPwdUrl)) {
            this.setPayPwdUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_pwd_setting_url", "");
        }
        return this.setPayPwdUrl;
    }

    public String getPaySecurityCenterUrl(Context context) {
        if (TextUtils.isEmpty(this.securityCenterUrl)) {
            this.securityCenterUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_security_center_url", "");
        }
        return this.securityCenterUrl;
    }

    public String getPaySettingUrl(Context context) {
        if (TextUtils.isEmpty(this.payConfigUrl)) {
            this.payConfigUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_setting_url", "");
        }
        return this.payConfigUrl;
    }

    public String getPolymerHost(Context context) {
        if (TextUtils.isEmpty(this.polymerHost)) {
            this.polymerHost = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_polymer_host", "");
        }
        return this.polymerHost;
    }

    public String getQuickBindCardUrl(Context context) {
        if (TextUtils.isEmpty(this.quickBindCardUrl)) {
            this.quickBindCardUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_quick_bind_card_url", "");
        }
        return this.quickBindCardUrl;
    }

    public String getRecordHost(Context context) {
        if (TextUtils.isEmpty(this.recordHost)) {
            this.recordHost = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_record_host", "");
        }
        return this.recordHost;
    }

    public String getReviewingUrl(Context context) {
        if (TextUtils.isEmpty(this.bindCardReviewingUrl)) {
            this.bindCardReviewingUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_bind_card_reviewing_url", "");
        }
        return this.bindCardReviewingUrl;
    }

    public String getRtcHost(Context context) {
        if (TextUtils.isEmpty(this.rtcHost)) {
            this.rtcHost = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_rtc_host", "");
        }
        return this.rtcHost;
    }

    public String[] getSdkMethodBlackList() {
        String[] strArr = new String[0];
        if (TextUtils.isEmpty(this.sdk_method_black_list)) {
            return strArr;
        }
        try {
            return (String[]) JsonUtils.fromJson(this.sdk_method_black_list, String[].class);
        } catch (JSONException e) {
            e.printStackTrace();
            return strArr;
        }
    }

    public String[] getSdkNetStatPathList() {
        String[] strArr = new String[0];
        if (TextUtils.isEmpty(this.sdk_net_stat_path_list)) {
            return strArr;
        }
        try {
            return (String[]) JsonUtils.fromJson(this.sdk_net_stat_path_list, String[].class);
        } catch (JSONException e) {
            e.printStackTrace();
            return strArr;
        }
    }

    public String[] getSdkSMPathList() {
        String[] strArr = new String[0];
        if (TextUtils.isEmpty(this.sdk_sm_path_list)) {
            return strArr;
        }
        try {
            return (String[]) JsonUtils.fromJson(this.sdk_sm_path_list, String[].class);
        } catch (JSONException e) {
            e.printStackTrace();
            return strArr;
        }
    }

    public String getSensorHost(Context context) {
        if (TextUtils.isEmpty(this.sensorHost)) {
            this.sensorHost = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_sensor_host", "");
        }
        return this.sensorHost;
    }

    public String getSimulatorInfos(Context context) {
        if (TextUtils.isEmpty(this.simulatorInfos)) {
            this.simulatorInfos = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_wcp_simulator", "");
        }
        return this.simulatorInfos;
    }

    public int getTakePicWaitTime() {
        if (!TextUtils.isEmpty(qw.qw.takePicWaitTime)) {
            return Integer.valueOf(qw.qw.takePicWaitTime).intValue();
        }
        return 2000;
    }

    public String getTransactionRecordsUrl(Context context) {
        if (TextUtils.isEmpty(this.transactionRecordsUrl)) {
            this.transactionRecordsUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.h, "");
        }
        return this.transactionRecordsUrl;
    }

    public String getUseH5BindCard(Context context) {
        if (TextUtils.isEmpty(this.useH5BindCard)) {
            this.useH5BindCard = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_use_h5_bind_card", "");
        }
        return this.useH5BindCard;
    }

    public void setSdkInitCallBack(SdkInitCallBack sdkInitCallBack) {
        this.mSdkInitCallBack = sdkInitCallBack;
        sdkInitCallBack.onSuccess();
    }

    public void storeResponse(Context context) {
        if (f4348ad) {
            f4348ad = false;
            if (!TextUtils.isEmpty(this.fp)) {
                String decrypt = SecurePay.getInstance().decrypt(this.fp);
                if (!TextUtils.isEmpty(decrypt) && !decrypt.equals(BdWalletUtils.getDeviceFP(context))) {
                    BdWalletUtils.setDeviceFP(context, decrypt);
                }
            }
            if (!TextUtils.isEmpty(this.kefuPhoneNum)) {
                BdWalletUtils.setKefuPhoneNumToSP(context, this.kefuPhoneNum);
            }
            if (!TextUtils.isEmpty(this.passAuthUrl)) {
                qw.qw.passAuthUrl = this.passAuthUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.b, this.passAuthUrl);
            }
            qw.qw.paymentCodeUrl = this.paymentCodeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.c, this.paymentCodeUrl);
            qw.qw.transactionRecordsUrl = this.transactionRecordsUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.h, this.transactionRecordsUrl);
            qw.qw.balanceHomeUrl = this.balanceHomeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.d, this.balanceHomeUrl);
            qw.qw.securityCenterUrl = this.securityCenterUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_security_center_url", this.securityCenterUrl);
            qw.qw.payConfigUrl = this.payConfigUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_setting_url", this.payConfigUrl);
            qw.qw.setPayPwdUrl = this.setPayPwdUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_pwd_setting_url", this.setPayPwdUrl);
            qw.qw.h5CashierUrl = this.h5CashierUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_h5_cashier_url", this.h5CashierUrl);
            if (!TextUtils.isEmpty(this.payAuthSignUrl)) {
                qw.qw.payAuthSignUrl = this.payAuthSignUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_auth_sign_url", this.payAuthSignUrl);
            }
            if (!TextUtils.isEmpty(this.authSignUrl)) {
                qw.qw.authSignUrl = this.authSignUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_auth_sign_url", this.authSignUrl);
            }
            qw.qw.h5ChargeUrl = this.h5ChargeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_pay_h5_charge_url", this.h5ChargeUrl);
            qw.qw.findPayPwdUrl = this.findPayPwdUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_find_pay_pwd_url", this.findPayPwdUrl);
            qw.qw.bankCardListUrl = this.bankCardListUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_bank_card_list_url", this.bankCardListUrl);
            qw.qw.payHost = this.payHost;
            if (!TextUtils.isEmpty(this.payHost)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_app_pay_host", this.payHost);
            }
            qw.qw.polymerHost = this.polymerHost;
            if (!TextUtils.isEmpty(this.polymerHost)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_polymer_host", this.polymerHost);
            }
            qw.qw.rtcHost = this.rtcHost;
            if (!TextUtils.isEmpty(this.rtcHost)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_rtc_host", this.rtcHost);
            }
            qw.qw.recordHost = this.recordHost;
            if (!TextUtils.isEmpty(this.recordHost)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_record_host", this.recordHost);
            }
            qw.qw.sensorHost = this.sensorHost;
            if (!TextUtils.isEmpty(this.sensorHost)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_sensor_host", this.sensorHost);
            }
            qw.qw.backSensorHost = this.backSensorHost;
            if (!TextUtils.isEmpty(this.backSensorHost)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_back_sensor_host", this.backSensorHost);
            }
            qw.qw.quickBindCardUrl = this.quickBindCardUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_quick_bind_card_url", this.quickBindCardUrl);
            qw.qw.bindCardCollectUserDataUrl = this.bindCardCollectUserDataUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_bind_card_collect_user_url", this.bindCardCollectUserDataUrl);
            qw.qw.bindCardReviewingUrl = this.bindCardReviewingUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_bind_card_reviewing_url", this.bindCardReviewingUrl);
            qw.qw.useH5BindCard = this.useH5BindCard;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_use_h5_bind_card", this.useH5BindCard);
            qw.qw.bindCardSafeTipUrl = this.bindCardSafeTipUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_bind_card_safe_tip_url", this.bindCardSafeTipUrl);
            qw.qw.h5bindCardUrl = this.h5bindCardUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_h5_bind_card_url", this.h5bindCardUrl);
            qw.qw.fp = this.fp;
            qw.qw.kefuPhoneNum = this.kefuPhoneNum;
            qw.qw.loginUrl = this.loginUrl;
            qw.qw.certWhiteList = this.certWhiteList;
            qw.qw.hostWhiteList = this.hostWhiteList;
            qw.qw.passAuthUrl = this.passAuthUrl;
            qw.qw.domainSwitch = this.domainSwitch;
            qw.qw.domainConfig = this.domainConfig;
            qw.qw.paymentCodeUrl = this.paymentCodeUrl;
            qw.qw.balanceHomeUrl = this.balanceHomeUrl;
            qw.qw.transactionRecordsUrl = this.transactionRecordsUrl;
            qw.qw.takePicWaitTime = this.takePicWaitTime;
            qw.qw.cookiesSyncDomainList = this.cookiesSyncDomainList;
            qw.qw.sdk_permission_dialog = this.sdk_permission_dialog;
            qw.qw.langbridge_permission_dialog = this.langbridge_permission_dialog;
            qw.qw.permission_dialog_info = this.permission_dialog_info;
            qw.qw.permission_dialog_contacts = this.permission_dialog_contacts;
            qw.qw.permission_dialog_location = this.permission_dialog_location;
            qw.qw.permission_dialog_camera = this.permission_dialog_camera;
            qw.qw.permission_dialog_audio = this.permission_dialog_audio;
            qw.qw.permission_dialog_storage = this.permission_dialog_storage;
            qw.qw.securityCenterUrl = this.securityCenterUrl;
            qw.qw.payConfigUrl = this.payConfigUrl;
            qw.qw.h5CashierUrl = this.h5CashierUrl;
            qw.qw.h5ChargeUrl = this.h5ChargeUrl;
            qw.qw.setPayPwdUrl = this.setPayPwdUrl;
            qw.qw.findPayPwdUrl = this.findPayPwdUrl;
            qw.qw.bankCardListUrl = this.bankCardListUrl;
            qw.qw.download_file = this.download_file;
            qw.qw.dxmscan_whitelist = this.dxmscan_whitelist;
            qw.qw.openAuthSign = this.openAuthSign;
            if (!TextUtils.isEmpty(this.dxmscan_whitelist)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_dxmscan_whitelist", this.dxmscan_whitelist);
            }
            qw.qw.download_liveness = this.download_liveness;
            qw.qw.simulatorInfos = this.simulatorInfos;
            qw.qw.simplify_liveness_dependon_cpu = this.simplify_liveness_dependon_cpu;
            qw.qw.dxm_lite_liveness_dependon_cpu = this.dxm_lite_liveness_dependon_cpu;
            qw.qw.ocr_idcard_dependon_cpu = this.ocr_idcard_dependon_cpu;
            if (!TextUtils.isEmpty(this.simulatorInfos)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_wcp_simulator", this.simulatorInfos);
            }
            qw.qw.statisticNativePoint_switch = this.statisticNativePoint_switch;
            qw.qw.bankcard_detect = this.bankcard_detect;
            qw.qw.ocrBankCardBadCaseCount = this.ocrBankCardBadCaseCount;
            qw.qw.quickBindCardUrl = this.quickBindCardUrl;
            qw.qw.bindCardCollectUserDataUrl = this.bindCardCollectUserDataUrl;
            qw.qw.bindCardReviewingUrl = this.bindCardReviewingUrl;
            qw.qw.useH5BindCard = this.useH5BindCard;
            qw.qw.bindCardSafeTipUrl = this.bindCardSafeTipUrl;
            qw.qw.h5bindCardUrl = this.h5bindCardUrl;
            if (!TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.e, this.cookiesSyncDomainList);
            }
            qw.qw.needShowLoadingInterval = this.needShowLoadingInterval;
            qw.qw.loadingDurationInterval = this.loadingDurationInterval;
            if (!TextUtils.isEmpty(this.loadingDurationInterval)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.paysdk.datamodel.SdkInitResponse.g, this.loadingDurationInterval);
            }
            TextUtils.isEmpty(this.nfcKyc);
            qw.qw.is_sdk_sm_open = this.is_sdk_sm_open;
            qw.qw.sdk_sm_path_list = this.sdk_sm_path_list;
            qw.qw.sdk_net_stat_path_list = this.sdk_net_stat_path_list;
            qw.qw.sdk_net_stat_threshold = this.sdk_net_stat_threshold;
            qw.qw.acsSupportBanks110 = this.acsSupportBanks110;
            qw.qw.supportedACS = this.supportedACS;
            qw.qw.showAccessiGuide = this.showAccessiGuide;
            qw.qw.displayAcsMode = this.displayAcsMode;
            qw.qw.sdk_method_black_list = this.sdk_method_black_list;
            qw.qw.na_method_stat_black_list = this.na_method_stat_black_list;
            qw.qw.playback = this.playback;
            qw.qw.playbackEventsSize = this.playbackEventsSize;
            qw.qw.playbackPerCount = this.playbackPerCount;
            if (qw.qw.mSdkInitCallBack != null) {
                qw.qw.mSdkInitCallBack.onSuccess();
                qw.qw.mSdkInitCallBack = null;
            }
        }
    }

    public String toString() {
        return "sdk-init:" + "\n\tfp:" + this.fp + "\n\tkefuPhoneNum:" + this.kefuPhoneNum + "\n\tcertWhiteList:" + this.certWhiteList + "\n\thostWhiteList:" + this.hostWhiteList + "\n\tloginUrl:" + this.loginUrl + "\n\tpassAuthUrl:" + this.passAuthUrl + "\n\tdomainSwitch:" + this.domainSwitch + "\n\tdomainConfig:" + this.domainConfig + "\n\tpaymentCodeUrl:" + this.paymentCodeUrl + "\n\tbalanceHomeUrl:" + this.balanceHomeUrl + "\n\ttransactionRecordsUrl:" + this.transactionRecordsUrl + "\n\tcookiesSyncDomainList:" + this.cookiesSyncDomainList + "\n\tneedShowLoadingInterval:" + this.needShowLoadingInterval + "\n\tloadingDurationInterval:" + this.loadingDurationInterval + "\n\tsecurityCenterUrl:" + this.securityCenterUrl + "\n\tpayConfigUrl:" + this.payConfigUrl + "\n\th5CashierUrl:" + this.h5CashierUrl + "\n\th5ChargeUrl:" + this.h5ChargeUrl + "\n\tsetPayPwdUrl:" + this.setPayPwdUrl + "\n\tfindPayPwdUrl:" + this.findPayPwdUrl + "\n\tbankCardListUrl:" + this.bankCardListUrl + "\n\tquickBindCardUrl:" + this.quickBindCardUrl + "\n\tuseH5BindCard:" + this.useH5BindCard + "\n\tbindCardSafeTipUrl:" + this.bindCardSafeTipUrl + "\n\th5bindCardUrl:" + this.h5bindCardUrl + "\n\tnfcKyc:" + this.nfcKyc;
    }
}
