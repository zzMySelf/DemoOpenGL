package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.booster.SapiUtil;
import com.baidu.sapi2.callback.NFCReadCardCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.touchid.FingerprintUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.Security;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiUpgradeInterpreters {
    public static final List<String> SUPPORT_LIST;
    public static final String TAG = "SapiUpgradeInterpreters";
    public SapiConfiguration configuration;
    public Context context;
    public HashMap<String, AbstractInterpreter> interpreterHashMap = new HashMap<>();
    public SapiJsCallBacks.CallBacks jsCallBacks;
    public SapiWebView sapiWebView;

    public abstract class AbstractInterpreter {
        public AbstractInterpreter() {
        }

        public abstract String interpret(SapiUtil.Command command);
    }

    public class ActionGetLoadtime extends AbstractInterpreter {
        public ActionGetLoadtime() {
            super();
        }

        public String interpret(SapiUtil.Command command) {
            SapiWebView unused = SapiUpgradeInterpreters.this.sapiWebView;
            if (SapiWebView.statLoadLogin == null) {
                return null;
            }
            SapiWebView unused2 = SapiUpgradeInterpreters.this.sapiWebView;
            JSONObject json = SapiWebView.statLoadLogin.toJSON();
            try {
                json.put("errno", 0);
            } catch (Exception e) {
                String access$100 = SapiUpgradeInterpreters.TAG;
                Log.e(access$100, "ActionGetLoadtime" + e.getMessage());
            }
            return json.toString();
        }
    }

    public class Finish extends AbstractInterpreter {
        public Finish() {
            super();
        }

        public String interpret(SapiUtil.Command command) {
            SapiUpgradeInterpreters.this.sapiWebView.handleOpenApiAuthorizeResponse(SapiUpgradeInterpreters.this.jsCallBacks.rrLoginResponse);
            if (command.getActionParams().size() > 0) {
                try {
                    SapiUpgradeInterpreters.this.sapiWebView.finish(new JSONObject(command.getActionParams().get(0)).optString(UBCManager.CONTENT_KEY_PAGE));
                } catch (JSONException e) {
                    String access$100 = SapiUpgradeInterpreters.TAG;
                    Log.e(access$100, "Finish" + e.getMessage());
                }
            } else {
                SapiUpgradeInterpreters.this.sapiWebView.finish();
            }
            if (SapiUpgradeInterpreters.this.jsCallBacks.webviewPageFinishCallback == null) {
                return null;
            }
            SapiUpgradeInterpreters.this.jsCallBacks.webviewPageFinishCallback.onFinish(command.getActionParams().size() > 0 ? command.getActionParams().get(0) : "");
            return null;
        }
    }

    public class GetAllClientAccounts extends AbstractInterpreter {
        public GetAllClientAccounts() {
            super();
        }

        private boolean isShareEnable() {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration != null && sapiConfiguration.loginShareStrategy() == LoginShareStrategy.CHOICE) {
                String packageName = sapiConfiguration.context.getPackageName();
                if (TextUtils.isEmpty(packageName)) {
                    return false;
                }
                for (String matches : SapiContext.getInstance().getAuthorizedPackages().keySet()) {
                    if (packageName.matches(matches)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String interpret(final SapiUtil.Command command) {
            Log.d(SapiUpgradeInterpreters.TAG, "GetAllClientAccounts ----- start --------");
            SapiContext instance = SapiContext.getInstance();
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException e) {
                String access$100 = SapiUpgradeInterpreters.TAG;
                Log.e(access$100, "GetAllClientAccounts put interpret: " + e.getMessage());
            }
            List<SapiAccount> touchidAccounts = instance.getTouchidAccounts();
            try {
                JSONArray jSONArray = new JSONArray();
                boolean z = FingerprintUtil.getFingerPrintState(SapiUpgradeInterpreters.this.configuration) == 0;
                for (SapiAccount next : touchidAccounts) {
                    JSONObject jSONObject2 = next.toJSONObject();
                    if (!TextUtils.isEmpty(next.phone) && next.phone.contains("http://")) {
                        next.phone = next.phone.replace("http://", "https://");
                    }
                    jSONObject2.put(SapiAccount.SAPI_ACCOUNT_PORTRAIT, next.phone);
                    String str = "1";
                    if (!z) {
                        jSONObject2.put("touchCode", str);
                    } else {
                        if (!TextUtils.isEmpty(next.email)) {
                            str = "0";
                        }
                        jSONObject2.put("touchCode", str);
                    }
                    jSONObject2.remove("phone");
                    jSONObject2.remove(SapiAccount.SAPI_ACCOUNT_EXTRA);
                    jSONObject2.remove("app");
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("fingerAccounts", jSONArray);
            } catch (Exception e2) {
                String access$1002 = SapiUpgradeInterpreters.TAG;
                Log.e(access$1002, "GetAllClientAccounts finger interpret: " + e2.getMessage());
            }
            try {
                jSONObject.put("onekeyAccounts", new OneKeyLoginSdkCall().getEncryptPhone());
            } catch (Exception e3) {
                String access$1003 = SapiUpgradeInterpreters.TAG;
                Log.e(access$1003, "GetAllClientAccounts onekey interpret: " + e3.getMessage());
            }
            try {
                jSONObject.put("faceAccounts", instance.getV2FaceLoginCheckResults());
            } catch (Exception e4) {
                String access$1004 = SapiUpgradeInterpreters.TAG;
                Log.e(access$1004, "GetAllClientAccounts face interpret: " + e4.getMessage());
            }
            try {
                JSONArray jSONArray2 = LoginHistoryItem.toJSONArray(LoginHistoryLoginModel.getAvailableLoginHistoryItems());
                if (jSONArray2 != null) {
                    jSONObject.put("history", jSONArray2);
                }
            } catch (Exception e5) {
                String access$1005 = SapiUpgradeInterpreters.TAG;
                Log.e(access$1005, "GetAllClientAccounts history interpret: " + e5.getMessage());
            }
            try {
                jSONObject.put("recentLoginUid", instance.getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
                if (SapiUpgradeInterpreters.this.sapiWebView != null) {
                    if (SapiUpgradeInterpreters.this.sapiWebView.mExcludeTypesList != null) {
                        if (SapiUpgradeInterpreters.this.sapiWebView.mExcludeTypesList.size() != 0) {
                            ArrayList<LoginTypes> arrayList = SapiUpgradeInterpreters.this.sapiWebView.mExcludeTypesList;
                            StringBuilder sb = new StringBuilder();
                            int i2 = 0;
                            while (i2 < arrayList.size()) {
                                LoginTypes loginTypes = arrayList.get(i2);
                                if (loginTypes != null) {
                                    if (loginTypes == LoginTypes.FACE) {
                                        SapiAccountManager.getInstance().getConfignation().setSupportFaceLogin(false);
                                    }
                                    if (loginTypes == LoginTypes.FINGER) {
                                        SapiAccountManager.getInstance().getConfignation().setSupportTouchLogin(false);
                                    }
                                    String str2 = i2 == arrayList.size() - 1 ? "" : ",";
                                    sb.append(loginTypes.getName());
                                    sb.append(str2);
                                    jSONObject.put("excludeTypes", sb.toString());
                                }
                                i2++;
                            }
                        }
                    }
                    if (SapiUpgradeInterpreters.this.sapiWebView.mExcludeTypes != null) {
                        jSONObject.put("excludeTypes", SapiUpgradeInterpreters.this.sapiWebView.mExcludeTypes.getName());
                    }
                }
            } catch (JSONException e6) {
                String access$1006 = SapiUpgradeInterpreters.TAG;
                Log.e(access$1006, "GetAllClientAccounts last interpret: " + e6.getMessage());
            }
            try {
                if (isShareEnable()) {
                    Log.d(SapiUpgradeInterpreters.TAG, "GetAllClientAccounts share login is enable");
                    SapiAccountManager.getInstance().getShareModels((long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS, false, (ShareModelCallback) new ShareModelCallback() {
                        public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                            if (list == null || list.size() == 0) {
                                Log.d(SapiUpgradeInterpreters.TAG, "GetAllClientAccounts shareModelList is empty");
                                SapiUpgradeInterpreters.this.jsCallBacks.evalJavaScript.postResult(SapiUpgradeInterpreters.this.sapiWebView, jSONObject.toString(), command);
                                return;
                            }
                            try {
                                JSONArray jSONArray = ShareStorage.StorageModel.toJSONArray(list);
                                jSONObject.put("from", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                                jSONObject.put("canshare2Accounts", jSONArray);
                                String access$100 = SapiUpgradeInterpreters.TAG;
                                Log.d(access$100, "GetAllClientAccounts shareV2 value=" + jSONObject.toString());
                                SapiStatUtil.statShareV2Open(list, (String) null, SapiUpgradeInterpreters.this.sapiWebView.extras);
                                SapiUpgradeInterpreters.this.jsCallBacks.evalJavaScript.postResult(SapiUpgradeInterpreters.this.sapiWebView, jSONObject.toString(), command);
                            } catch (JSONException e) {
                                String access$1002 = SapiUpgradeInterpreters.TAG;
                                Log.e(access$1002, "GetAllClientAccounts jsonArray interpret: " + e.getMessage());
                                SapiUpgradeInterpreters.this.jsCallBacks.evalJavaScript.postResult(SapiUpgradeInterpreters.this.sapiWebView, jSONObject.toString(), command);
                                e.printStackTrace();
                            }
                        }
                    });
                    return null;
                }
                Log.d(SapiUpgradeInterpreters.TAG, "GetAllClientAccounts share login is disable");
                SapiUpgradeInterpreters.this.jsCallBacks.evalJavaScript.postResult(SapiUpgradeInterpreters.this.sapiWebView, jSONObject.toString(), command);
                return null;
            } catch (Exception e7) {
                String access$1007 = SapiUpgradeInterpreters.TAG;
                Log.e(access$1007, "GetAllClientAccounts share interpret: " + e7.getMessage());
                SapiUpgradeInterpreters.this.jsCallBacks.evalJavaScript.postResult(SapiUpgradeInterpreters.this.sapiWebView, jSONObject.toString(), command);
                return null;
            }
        }
    }

    public class SapiActionCheckMethodSupport extends AbstractInterpreter {
        public SapiActionCheckMethodSupport() {
            super();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a2, code lost:
            if (com.baidu.sapi2.SapiUpgradeInterpreters.access$300(r8.this$0).supportFaceLogin != false) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d1, code lost:
            if (com.baidu.sapi2.SapiUpgradeInterpreters.access$200(r8.this$0).invokeScAppCallback != null) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e6, code lost:
            if (com.baidu.sapi2.SapiUpgradeInterpreters.access$300(r8.this$0).supportFaceLogin != false) goto L_0x00a6;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00f2 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:51:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.booster.SapiUtil.Command r9) {
            /*
                r8 = this;
                java.lang.String r0 = ""
                r1 = 1
                r2 = 0
                java.lang.String r3 = r9.getKey()     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                if (r3 != 0) goto L_0x0024
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.util.List r4 = r9.getActionParams()     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.lang.Object r4 = r4.get(r2)     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                r3.<init>(r4)     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.lang.String r4 = "method"
                java.lang.String r0 = r3.getString(r4)     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                goto L_0x002f
            L_0x0024:
                java.util.List r3 = r9.getActionParams()     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.lang.Object r3 = r3.get(r2)     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                r0 = r3
            L_0x002f:
                com.baidu.sapi2.SapiUpgradeInterpreters r3 = com.baidu.sapi2.SapiUpgradeInterpreters.this     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.lang.String r3 = r3.interpreterNameToClassFullName(r0)     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0065, JSONException -> 0x0063 }
                java.util.List r3 = r9.getActionParams()     // Catch:{ ClassNotFoundException -> 0x0060, JSONException -> 0x005e }
                int r3 = r3.size()     // Catch:{ ClassNotFoundException -> 0x0060, JSONException -> 0x005e }
                if (r3 <= r1) goto L_0x005b
                java.util.List r9 = r9.getActionParams()     // Catch:{ ClassNotFoundException -> 0x0060, JSONException -> 0x005e }
                java.lang.Object r9 = r9.get(r1)     // Catch:{ ClassNotFoundException -> 0x0060, JSONException -> 0x005e }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ ClassNotFoundException -> 0x0060, JSONException -> 0x005e }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ ClassNotFoundException -> 0x0060, JSONException -> 0x005e }
                r3.<init>(r9)     // Catch:{ ClassNotFoundException -> 0x0060, JSONException -> 0x005e }
                java.lang.String r9 = "version"
                int r9 = r3.getInt(r9)     // Catch:{ ClassNotFoundException -> 0x0060, JSONException -> 0x005e }
                if (r9 <= r1) goto L_0x005b
                r9 = 1
                goto L_0x005c
            L_0x005b:
                r9 = 0
            L_0x005c:
                r3 = 1
                goto L_0x0088
            L_0x005e:
                r9 = move-exception
                goto L_0x0061
            L_0x0060:
                r9 = move-exception
            L_0x0061:
                r3 = 1
                goto L_0x0067
            L_0x0063:
                r9 = move-exception
                goto L_0x0066
            L_0x0065:
                r9 = move-exception
            L_0x0066:
                r3 = 0
            L_0x0067:
                java.lang.String r4 = com.baidu.sapi2.SapiUpgradeInterpreters.TAG
                java.lang.Object[] r5 = new java.lang.Object[r1]
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "SapiActionCheckMethodSupport"
                r6.append(r7)
                java.lang.String r9 = r9.getMessage()
                r6.append(r9)
                java.lang.String r9 = r6.toString()
                r5[r2] = r9
                com.baidu.sapi2.utils.Log.e((java.lang.String) r4, (java.lang.Object[]) r5)
                r9 = 0
            L_0x0088:
                java.lang.String r4 = "sapi_biometrics_identification_with_uid"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x00a8
                com.baidu.sapi2.SapiUpgradeInterpreters r3 = com.baidu.sapi2.SapiUpgradeInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r3 = r3.jsCallBacks
                com.baidu.sapi2.SapiWebView$BioScanFaceCallback r3 = r3.bioScanFaceCallback
                if (r3 == 0) goto L_0x00a5
                com.baidu.sapi2.SapiUpgradeInterpreters r3 = com.baidu.sapi2.SapiUpgradeInterpreters.this
                com.baidu.sapi2.SapiConfiguration r3 = r3.configuration
                boolean r3 = r3.supportFaceLogin
                if (r3 == 0) goto L_0x00a5
                goto L_0x00a6
            L_0x00a5:
                r1 = 0
            L_0x00a6:
                r3 = r1
                goto L_0x00e9
            L_0x00a8:
                java.lang.String r4 = "sapi_biometrics_identification"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x00d4
                java.lang.String r4 = "sapi_biometrics_identification_no_bduss"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x00d4
                java.lang.String r4 = "sapi_biometrics_identification_with_authtoken"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x00c1
                goto L_0x00d4
            L_0x00c1:
                java.lang.String r4 = "sapi_action_sc_app_check"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x00e9
                com.baidu.sapi2.SapiUpgradeInterpreters r3 = com.baidu.sapi2.SapiUpgradeInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r3 = r3.jsCallBacks
                com.baidu.sapi2.SapiWebView$InvokeScAppCallback r3 = r3.invokeScAppCallback
                if (r3 == 0) goto L_0x00a5
                goto L_0x00a6
            L_0x00d4:
                com.baidu.sapi2.SapiUpgradeInterpreters r3 = com.baidu.sapi2.SapiUpgradeInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r3 = r3.jsCallBacks
                com.baidu.sapi2.SapiWebView$BiometricsIdentifyCallback r3 = r3.biometricsIdentifyCallback
                if (r3 == 0) goto L_0x00a5
                com.baidu.sapi2.SapiUpgradeInterpreters r3 = com.baidu.sapi2.SapiUpgradeInterpreters.this
                com.baidu.sapi2.SapiConfiguration r3 = r3.configuration
                boolean r3 = r3.supportFaceLogin
                if (r3 == 0) goto L_0x00a5
                goto L_0x00a6
            L_0x00e9:
                if (r3 == 0) goto L_0x00ee
                java.lang.String r1 = "1"
                goto L_0x00f0
            L_0x00ee:
                java.lang.String r1 = "0"
            L_0x00f0:
                if (r3 == 0) goto L_0x0116
                if (r9 == 0) goto L_0x0116
                java.util.List r9 = com.baidu.sapi2.SapiUpgradeInterpreters.SUPPORT_LIST
                boolean r9 = r9.contains(r0)
                com.baidu.sapi2.SapiContext r0 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.SapiOptions r0 = r0.getSapiOptions()
                com.baidu.sapi2.SapiOptions$Gray r0 = r0.gray
                java.lang.String r2 = "android_method_v2"
                com.baidu.sapi2.SapiOptions$Gray$GrayModule r0 = r0.getGrayModuleByFunName(r2)
                boolean r0 = r0.isMeetGray()
                if (r0 == 0) goto L_0x0116
                if (r9 == 0) goto L_0x0116
                java.lang.String r1 = "2"
            L_0x0116:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiUpgradeInterpreters.SapiActionCheckMethodSupport.interpret(com.baidu.sapi2.booster.SapiUtil$Command):java.lang.String");
        }
    }

    public class SapiActionGetNaUiConfig extends AbstractInterpreter {
        public SapiActionGetNaUiConfig() {
            super();
        }

        public String interpret(SapiUtil.Command command) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                if (SapiUpgradeInterpreters.this.configuration != null) {
                    jSONObject.put("textZoom", SapiUpgradeInterpreters.this.configuration.getTextZoom());
                    jSONObject.put("browseModeState", SapiUpgradeInterpreters.this.configuration.browseModeState);
                    if (SapiUpgradeInterpreters.this.configuration.mCallbackProtocol != null) {
                        JSONArray jSONArray = new JSONArray(SapiUpgradeInterpreters.this.configuration.mCallbackProtocol.callbackCustomProtocol());
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            ((JSONObject) jSONArray.get(i2)).put("id", i2);
                        }
                        jSONObject.put("tplAgrees", jSONArray);
                    } else {
                        jSONObject.put("tplAgrees", "");
                    }
                } else {
                    jSONObject.put("textZoom", 100);
                    jSONObject.put("browseModeState", 1);
                    jSONObject.put("tplAgrees", "");
                }
                return jSONObject.toString();
            } catch (Exception e) {
                String access$100 = SapiUpgradeInterpreters.TAG;
                Log.e(access$100, "SapiActionGetNaUiConfig" + e.getMessage());
                return null;
            }
        }
    }

    public class SapiActionGetSecurityZid extends AbstractInterpreter {
        public SapiActionGetSecurityZid() {
            super();
        }

        public String interpret(SapiUtil.Command command) {
            try {
                int optInt = new JSONObject(command.getActionParams().get(0)).optInt("eventId");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                jSONObject.put("zid", Security.getZid(ServiceManager.getInstance().getIsAccountManager().getConfignation().context, optInt));
                return jSONObject.toString();
            } catch (JSONException e) {
                String access$100 = SapiUpgradeInterpreters.TAG;
                Log.e(access$100, "SapiActionGetSecurityZid" + e.getMessage());
                return null;
            }
        }
    }

    public class SapiActionIdCardRead extends AbstractInterpreter {
        public SapiActionIdCardRead() {
            super();
        }

        public String interpret(final SapiUtil.Command command) {
            if (SapiUpgradeInterpreters.this.jsCallBacks == null) {
                Log.e(SapiUpgradeInterpreters.TAG, "sapi_action_id_card_read jsCallBacks is null");
                return "";
            }
            final JSONObject jSONObject = new JSONObject();
            try {
                if (SapiUpgradeInterpreters.this.jsCallBacks.mIdCardNfcCallback == null) {
                    Log.e(SapiUpgradeInterpreters.TAG, "sapi_action_id_card_read jsCallBacks,mIdCardNfcCallback is null");
                    SapiUpgradeInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                }
                SapiUpgradeInterpreters.this.jsCallBacks.mIdCardNfcCallback.startIdCardRead(5, 20000, new NFCReadCardCallback() {
                    public void onBegin() {
                    }

                    public void onFailure(int i2, String str, String str2) {
                        try {
                            jSONObject.put("errno", i2);
                            jSONObject.put("errmsg", str);
                            Log.e("NFC", "读卡失败：i=" + i2 + ",s=" + str);
                            SapiUpgradeInterpreters.this.jsCallBacks.evalJavaScript.postResult(SapiUpgradeInterpreters.this.sapiWebView, jSONObject.toString(), command);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    public void onSuccess(String str) {
                        try {
                            jSONObject.put("errno", 0);
                            jSONObject.put("errmsg", "");
                            jSONObject.put("bizId", str);
                            Log.e("NFC", "读卡成功：" + str);
                            SapiUpgradeInterpreters.this.jsCallBacks.evalJavaScript.postResult(SapiUpgradeInterpreters.this.sapiWebView, jSONObject.toString(), command);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                return null;
            } catch (Exception e) {
                SapiUpgradeInterpreters.this.jsCallBacks.evalJavaScript.postResult(SapiUpgradeInterpreters.this.sapiWebView, jSONObject.toString(), command);
                String access$100 = SapiUpgradeInterpreters.TAG;
                Log.e(access$100, "sapi_action_id_card_available error" + e.getMessage());
                return null;
            }
        }
    }

    public class SapiActionLastLoginType extends AbstractInterpreter {
        public SapiActionLastLoginType() {
            super();
        }

        public String interpret(SapiUtil.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lastLoginType", SapiUtils.getLastLoginType());
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                String access$100 = SapiUpgradeInterpreters.TAG;
                Log.e(access$100, "SapiActionLastLoginType" + e.getMessage());
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionMiniDi extends AbstractInterpreter {
        public SapiActionMiniDi() {
            super();
        }

        public String interpret(SapiUtil.Command command) {
            JSONArray jSONArray;
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                if (!TextUtils.isEmpty(command.getKey())) {
                    jSONArray = new JSONArray(jSONObject.getString("di_keys").replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, ""));
                } else {
                    jSONArray = jSONObject.optJSONArray("di_keys");
                }
                if (jSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                        arrayList.add(jSONArray.optString(i2));
                    }
                }
                JSONObject jSONObject2 = new JSONObject(SapiDeviceInfo.getDiCookieInfo(arrayList, false));
                jSONObject2.put("errno", 0);
                return jSONObject2.toString();
            } catch (Exception e) {
                String access$100 = SapiUpgradeInterpreters.TAG;
                Log.e(access$100, "SapiActionMiniDi" + e.getMessage());
                return null;
            }
        }
    }

    public class SapiActionUpdateNavigator extends AbstractInterpreter {
        public SapiActionUpdateNavigator() {
            super();
        }

        public String interpret(SapiUtil.Command command) {
            try {
                int optInt = new JSONObject(command.getActionParams().get(0)).optInt(WXLoginActivity.w);
                if (SapiUpgradeInterpreters.this.jsCallBacks.pageStateCallback != null) {
                    SapiUpgradeInterpreters.this.jsCallBacks.pageStateCallback.pageState(optInt);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                } catch (JSONException e) {
                    String access$100 = SapiUpgradeInterpreters.TAG;
                    Log.e(access$100, "SapiActionUpdateNavigator put interpret: " + e.getMessage());
                }
                return jSONObject.toString();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public class SwitchStyleForCloseBtnAndStatusBar extends AbstractInterpreter {
        public SwitchStyleForCloseBtnAndStatusBar() {
            super();
        }

        public String interpret(SapiUtil.Command command) {
            if (SapiUpgradeInterpreters.this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack == null) {
                return null;
            }
            try {
                SapiUpgradeInterpreters.this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack.switchStyle(new JSONObject(command.getActionParams().get(0)).optString("styleType"));
                return null;
            } catch (Exception e) {
                String access$100 = SapiUpgradeInterpreters.TAG;
                Log.e(access$100, "SwitchStyleForCloseBtnAndStatusBar" + e.getMessage());
                return null;
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        SUPPORT_LIST = arrayList;
        arrayList.add("sapi_action_get_security_zid");
        SUPPORT_LIST.add("sapi_action_get_na_ui_config");
        SUPPORT_LIST.add("action_get_loadtime");
        SUPPORT_LIST.add("switch_style_for_close_btn_and_status_bar");
        SUPPORT_LIST.add("sapi_action_mini_di");
        SUPPORT_LIST.add("sapi_action_update_navigator");
        SUPPORT_LIST.add("finish");
        SUPPORT_LIST.add("get_all_client_accounts");
        SUPPORT_LIST.add("sapi_action_last_login_type");
        SUPPORT_LIST.add("sapi_action_id_card_read");
    }

    public SapiUpgradeInterpreters(SapiWebView sapiWebView2, SapiJsCallBacks.CallBacks callBacks) {
        this.sapiWebView = sapiWebView2;
        this.context = sapiWebView2.getContext();
        this.jsCallBacks = callBacks;
        this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    private AbstractInterpreter buidInterpreterByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (AbstractInterpreter) Class.forName(interpreterNameToClassFullName(str)).getDeclaredConstructor(new Class[]{getClass()}).newInstance(new Object[]{this});
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "buidInterpreterByName" + e.getMessage());
            return null;
        }
    }

    public static List<String> getSupportList() {
        return SUPPORT_LIST;
    }

    /* access modifiers changed from: private */
    public String interpreterNameToClassFullName(String str) {
        String[] split = str.split("_");
        StringBuilder sb = new StringBuilder();
        sb.append("com.baidu.sapi2.SapiUpgradeInterpreters$");
        for (String charArray : split) {
            char[] charArray2 = charArray.toCharArray();
            if (charArray2[0] >= 'a' && charArray2[0] <= 'z') {
                charArray2[0] = (char) (charArray2[0] - ' ');
            }
            sb.append(new String(charArray2));
        }
        return sb.toString();
    }

    public AbstractInterpreter getInterpreter(String str) {
        AbstractInterpreter abstractInterpreter = this.interpreterHashMap.get(str);
        if (abstractInterpreter == null && (abstractInterpreter = buidInterpreterByName(str)) != null) {
            this.interpreterHashMap.put(str, abstractInterpreter);
        }
        return abstractInterpreter;
    }
}
