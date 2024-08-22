package com.baidu.wallet.lightapp.base;

import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.Vibrator;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.biometric.BiometricPrompt;
import com.baidu.aiscan.R;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.restnet.http.b;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.Crypto;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ImageBase64Utils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.dialog.PromptTipDialog;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.FileFetchManager;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LocationCache;
import com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger;
import com.baidu.wallet.lightapp.base.datamodel.LightAppContactSelectModelBase64;
import com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppLocationModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppNewLocationModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppTakePictureModel;
import com.baidu.wallet.lightapp.base.datamodel.LocationProvider;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LightappBrowseActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.lightapp.multipage.i;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.permission.CommonPermissionCallback;
import com.baidu.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LightappJsNativeClient implements ILightappInvoker {
    public static final String ADJUST_SCREEN_BRIGHTNESS = "adjustScreenBrightness";
    public static String B = "";
    public static long C = ("iqiyi".equals(BeanConstants.CHANNEL_ID) ? 30000 : 15000);
    public static final int CONTRACT_FAIL = 1;
    public static final int CONTRACT_SUCCESS = 0;
    public static final int FIXED_CONTACT_SIZE = 1000;
    public static final int FIXED_IMAGE_WIDTH = 640;
    public static final String INSERT_CALENDAR_EVENT = "insertCalendarEvent";
    public static final int JS_CALL_CAMERA = 3;
    public static final int JS_CALL_SELECT_ADDRESS_BOOK = 3;
    public static final String METHOD_CALL_FILE_FETCH = "callFileFetch";
    public static final String METHOD_CALL_SHARE = "callShare";
    public static final String METHOD_CALL_VIBRATE = "callVibrate";
    public static final String METHOD_CLOSE_WINDOW = "closeWindow";
    public static final String METHOD_GET_CURRENT_POSITION = "getCurrentPosition";
    public static final String METHOD_GET_DEVIDE_INFO = "getDeviceInfo";
    public static final String METHOD_SELECT_CONTACTS = "selectPhonefromAdressBook";
    public static final String MW_CLOSE_TOP_WEBVIEW = "closeTopWebview";
    public static final String MW_GET_LANGBRIDGE_HASH_STAMP = "getLangbridgeHashStamp";
    public static final String MW_GET_LANGBRIDGE_SETTINGS = "getLangbridgeSettings";
    public static final String MW_HSITORY_GO = "historyGo";
    public static final String MW_IS_PRELOADED = "isPreloaded";
    public static final String MW_NATIVE_LOG = "nativeLog";
    public static final String MW_OPEN_NEW_WEBVIEW = "openInNewWebView";
    public static final String MW_PRE_LOAD_EXCEPTION = "preLoadException";
    public static final String MW_PRE_LOAD_URL = "preLoadUrl";
    public static final String MW_RM_FROM_PRELOAD_POOL = "rmFromPreloadPool";
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final String SCREEN_CAPTURE_SETTINGS = "screenCaptureSettings";
    public static final String VIEW_CALENDAR_EVENT = "viewCalendarEvent";
    public static int c = 1;
    public static int d = 2;
    public static int e = 1;
    public long A = 0;
    public String a = LightappJsNativeClient.class.getSimpleName();
    public final HashMap<String, ILightappInvokerCallback> b = new HashMap<>();
    public final String f = "访问相机的权限";
    public final String g = "读写存储卡的权限";
    public final String h = "访问通信录的权限";

    /* renamed from: i  reason: collision with root package name */
    public final String f3559i = "获取地理位置的权限";
    public final String j = "没有";
    public com.baidu.wallet.lightapp.multipage.a k;
    public String l;
    public int m = -1;
    public int n = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f3560o = -1;
    public String p = null;
    public Method q = null;
    public boolean r = false;
    public LocationProvider s = LocationProvider.HOST;
    public CommonPermissionCallback t;
    public double u = -1.0d;
    public String v = "";
    public String w = "";
    public ILightappInvokerCallback x;
    public String y = null;
    public String z = null;

    public static class a implements LocationListener {
        public final ILightappInvokerCallback a;
        public final String b;
        public final LocationManager c;
        public final ArrayList<String> d;
        public final LightAppNewLocationModel e;

        public a(ILightappInvokerCallback iLightappInvokerCallback, String str, LocationManager locationManager, ArrayList<String> arrayList, LightAppNewLocationModel lightAppNewLocationModel) {
            this.a = iLightappInvokerCallback;
            this.b = str;
            this.c = locationManager;
            this.d = arrayList;
            this.e = lightAppNewLocationModel;
        }

        public void onLocationChanged(Location location) {
            if (location != null) {
                LightAppNewLocationModel lightAppNewLocationModel = this.e;
                lightAppNewLocationModel.result = 0;
                lightAppNewLocationModel.cnt.data.latitude = location.getLatitude();
                this.e.cnt.data.longitude = location.getLongitude();
                String json = this.e.toJson();
                String unused = LightappJsNativeClient.B = json;
                this.a.onResult(0, json);
                LocationCache.a(location.getLatitude(), location.getLongitude(), LocationCache.Coord.WGS84, LocationProvider.SYSTEM);
            } else {
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                data.errCode = "10003";
                data.des = "定位失败";
                String unused2 = LightappJsNativeClient.B = "";
                this.a.onResult(1, lightAppErrorModel.toJson());
            }
            this.c.removeUpdates(this);
        }

        public void onProviderDisabled(String str) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = "10003";
            data.des = "定位失败";
            String unused = LightappJsNativeClient.B = "";
            this.a.onResult(1, lightAppErrorModel.toJson());
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    public LightappJsNativeClient(com.baidu.wallet.lightapp.multipage.a aVar) {
        this.k = aVar;
    }

    private void f() {
        this.k.rmFromPreloadPool();
    }

    private void g() {
        this.k.closeTopWebview();
    }

    public static Set<String> getSupportMethodList(Context context) {
        HashSet hashSet = new HashSet();
        hashSet.add("selectPhonefromAdressBook");
        hashSet.add(METHOD_GET_DEVIDE_INFO);
        hashSet.add(METHOD_CLOSE_WINDOW);
        hashSet.add(METHOD_GET_CURRENT_POSITION);
        hashSet.add(METHOD_CALL_SHARE);
        hashSet.add(INSERT_CALENDAR_EVENT);
        hashSet.add(VIEW_CALENDAR_EVENT);
        hashSet.add(ADJUST_SCREEN_BRIGHTNESS);
        hashSet.add(SCREEN_CAPTURE_SETTINGS);
        hashSet.add(METHOD_CALL_VIBRATE);
        LangbridgeSettings a2 = h.a().a(context);
        if (a2.MW_ON && a2.MW_MULTI_ON) {
            hashSet.add(MW_OPEN_NEW_WEBVIEW);
            hashSet.add(MW_CLOSE_TOP_WEBVIEW);
            hashSet.add(MW_PRE_LOAD_URL);
            hashSet.add(MW_PRE_LOAD_EXCEPTION);
        }
        hashSet.add(MW_HSITORY_GO);
        hashSet.add(MW_NATIVE_LOG);
        hashSet.add(MW_IS_PRELOADED);
        hashSet.add(MW_RM_FROM_PRELOAD_POOL);
        hashSet.add(MW_GET_LANGBRIDGE_HASH_STAMP);
        hashSet.add(MW_GET_LANGBRIDGE_SETTINGS);
        hashSet.add(METHOD_CALL_FILE_FETCH);
        return hashSet;
    }

    private void h(JSONObject jSONObject, String str) {
        long optLong = jSONObject.optLong("beginTime");
        int i2 = (optLong > 0 ? 1 : (optLong == 0 ? 0 : -1));
        if (i2 < 0) {
            LightappUtils.onError(this.b.get(VIEW_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, "时间必须大于零", "#viewCalendarEventFail");
            return;
        }
        if (i2 == 0) {
            optLong = Calendar.getInstance().getTimeInMillis();
        }
        Uri.Builder buildUpon = CalendarContract.CONTENT_URI.buildUpon();
        buildUpon.appendPath("time");
        ContentUris.appendId(buildUpon, optLong);
        Intent data = new Intent("android.intent.action.VIEW").setData(buildUpon.build());
        if (this.k.getActivity() != null) {
            try {
                this.k.getActivity().startActivity(data);
            } catch (ActivityNotFoundException unused) {
                LightappUtils.onError(this.b.get(VIEW_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, ResUtils.getString(this.k.getContext(), "view_calendar_not_available"), LightAppStatEvent.LIGHT_APP_VIEW_CALENDAR_NOT_AVAILABLE);
            }
        }
    }

    private void i(JSONObject jSONObject, String str) {
        ILightappInvokerCallback iLightappInvokerCallback = this.b.get(ADJUST_SCREEN_BRIGHTNESS);
        if (this.k.getActivity() == null) {
            iLightappInvokerCallback.onResult(1, LightappUtils.assembleFailResultWithErrCode("10003", EnterDxmPayServiceAction.ERROR_MSG_INSIDE));
            return;
        }
        try {
            c.a((float) jSONObject.getDouble("brightness"), this.k.getActivity());
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
        } catch (JSONException unused) {
            iLightappInvokerCallback.onResult(1, LightappUtils.assembleFailResultWithErrCode(LightappConstants.ERRCODE_INVALID_PARAMETER, "参数错误"));
        }
    }

    public void callShare(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            LightAppShareModel lightAppShareModel = null;
            try {
                lightAppShareModel = (LightAppShareModel) JsonUtils.fromJson(str, LightAppShareModel.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (lightAppShareModel != null && lightAppShareModel.valid()) {
                try {
                    str3 = new JSONObject(str).getString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
                } catch (Exception unused) {
                    str3 = "";
                }
                final ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(CheckUtils.stripUrlParams(str3));
                } catch (Exception unused2) {
                }
                LightAppWrapper.getInstance().callShare(this.k.getActivity(), lightAppShareModel, new ILightappInvokerCallback() {
                    public void onResult(int i2, String str) {
                        if (1 == i2 && !TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                        ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                        if (iLightappInvokerCallback != null) {
                            iLightappInvokerCallback.onResult(i2, str);
                        }
                    }
                });
            }
        }
    }

    public void closeWindow(String str) {
        com.baidu.wallet.lightapp.multipage.a aVar = this.k;
        if (aVar != null) {
            aVar.closeWindow();
        }
    }

    public void getBattery(String str, String str2) {
    }

    public Set<String> getMethodList() {
        return getSupportMethodList(this.k.getContext());
    }

    public void handleInsertEventDone(boolean z2) {
        ILightappInvokerCallback iLightappInvokerCallback = this.b.get(INSERT_CALENDAR_EVENT);
        if (iLightappInvokerCallback == null) {
            b(INSERT_CALENDAR_EVENT, Integer.valueOf(LightappConstants.ERRCODE_ACTION_WITHOUT_RESULT).intValue(), "callback is null");
        } else if (z2) {
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", LightappConstants.ERRCODE_ACTION_WITHOUT_RESULT);
            iLightappInvokerCallback.onResult(1, LightappUtils.assembleResult((Map<String, Object>) hashMap, false));
        }
    }

    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_METHOD_NAME);
                if (!TextUtils.isEmpty(string)) {
                    this.b.put(string, iLightappInvokerCallback);
                    String string2 = jSONObject.getString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
                    if (!JavascriptInterfaceManager.verifyPermission(new URL(string2), string)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(CheckUtils.stripUrlParams(string2));
                        arrayList.add(string);
                        LightappUtils.onError(iLightappInvokerCallback, LightappConstants.ERRCODE_HOST_NOT_AUTHORITY, ResUtils.getString(context, "host_not_authority"), LightAppStatEvent.LIGHT_APP_NOT_INTERNAL_URL, (Collection<String>) arrayList);
                    } else if ("selectPhonefromAdressBook".equals(string)) {
                        a(context, str, iLightappInvokerCallback, string2);
                    } else if (METHOD_GET_DEVIDE_INFO.equals(string)) {
                        b(context, str, iLightappInvokerCallback, string2);
                    } else if (METHOD_CLOSE_WINDOW.equals(string)) {
                        closeWindow(string2);
                    } else if (METHOD_GET_CURRENT_POSITION.equals(string)) {
                        c(context, str, iLightappInvokerCallback, string2);
                    } else if (METHOD_CALL_SHARE.equals(string)) {
                        callShare(context, str, iLightappInvokerCallback, string2);
                    } else if (INSERT_CALENDAR_EVENT.equals(string)) {
                        g(jSONObject, string2);
                    } else if (VIEW_CALENDAR_EVENT.equals(string)) {
                        h(jSONObject, string2);
                    } else if (ADJUST_SCREEN_BRIGHTNESS.equals(string)) {
                        i(jSONObject, string2);
                    } else if (SCREEN_CAPTURE_SETTINGS.equals(string)) {
                        f(jSONObject, string2);
                    } else if (METHOD_CALL_VIBRATE.equals(string)) {
                        e(context, str, iLightappInvokerCallback, string2);
                    } else if (MW_OPEN_NEW_WEBVIEW.equals(string)) {
                        b(jSONObject, string2);
                    } else if (MW_PRE_LOAD_URL.equals(string)) {
                        c(jSONObject, string2);
                    } else if (MW_HSITORY_GO.equals(string)) {
                        a(jSONObject, string2);
                    } else if (MW_NATIVE_LOG.equals(string)) {
                        d(jSONObject, string2);
                    } else if (MW_PRE_LOAD_EXCEPTION.equals(string)) {
                        e(jSONObject, string2);
                    } else if (MW_CLOSE_TOP_WEBVIEW.equals(string)) {
                        g();
                    } else if (MW_IS_PRELOADED.equals(string)) {
                        a(iLightappInvokerCallback, string2);
                    } else if (MW_RM_FROM_PRELOAD_POOL.equals(string)) {
                        f();
                    } else if (MW_GET_LANGBRIDGE_HASH_STAMP.equals(string)) {
                        b(context, iLightappInvokerCallback, string2);
                    } else if (MW_GET_LANGBRIDGE_SETTINGS.equals(string)) {
                        a(context, iLightappInvokerCallback, string2);
                    } else if (METHOD_CALL_FILE_FETCH.equals(string)) {
                        a(context, jSONObject, iLightappInvokerCallback, string2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onCallCameraPicCallback() {
        final LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(0);
        ImageBase64Utils.getInstance().getImgageBase64(this.l, 640, new ImageBase64Utils.ImageBase64Listener() {
            public void onBase64Result(String str) {
                LightAppTakePictureModel lightAppTakePictureModel = lightAppTakePictureModel;
                lightAppTakePictureModel.cnt.image = str;
                LightappJsNativeClient.this.a(LightappBusinessClient.METHOD_CALL_CAMERA, 0, lightAppTakePictureModel.toJson());
                try {
                    File file = new File(LightappJsNativeClient.this.l);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onContactsSelected(String str, int i2, String[] strArr, String str2) {
        final ContactSelectModel contactSelectModel = new ContactSelectModel();
        if (i2 != 0) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(CheckUtils.stripUrlParams(str));
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
            contactSelectModel.result = 1;
            ContactSelectModel.Data data = contactSelectModel.cnt;
            data.errCode = "10002";
            data.des = str2;
            a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
        } else if (strArr != null) {
            String str3 = "";
            String str4 = strArr.length > 0 ? strArr[0] : str3;
            if (strArr.length > 1) {
                str3 = strArr[1];
            }
            contactSelectModel.result = 0;
            ContactSelectModel.SelectedContact selectedContact = contactSelectModel.cnt.selected;
            selectedContact.name = str4;
            selectedContact.phone = str3;
            if (this.m == d) {
                PhoneContactsMananger.a(this.k.getContext()).a((PhoneContactsMananger.d) new PhoneContactsMananger.d() {
                    public void a(List<ContactSelectModel.AllContact> list, int i2) {
                        if (LightappJsNativeClient.this.p != null) {
                            contactSelectModel.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), LightappJsNativeClient.this.p));
                        } else {
                            contactSelectModel.cnt.all = list;
                        }
                        if (LightappJsNativeClient.this.f3560o == LightappJsNativeClient.e) {
                            LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                            ContactSelectModel contactSelectModel = contactSelectModel;
                            lightAppContactSelectModelBase64.result = contactSelectModel.result;
                            ContactSelectModel.Data data = contactSelectModel.cnt;
                            if (data != null) {
                                lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data).getBytes());
                            }
                            LightappJsNativeClient.this.a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
                            return;
                        }
                        LightappJsNativeClient.this.a("selectPhonefromAdressBook", 0, contactSelectModel.toJson());
                    }
                });
                if (this.n > 0) {
                    PhoneContactsMananger.a(this.k.getContext()).a(this.n, false);
                } else {
                    PhoneContactsMananger.a(this.k.getContext()).a(1000, false);
                }
            } else if (this.f3560o == e) {
                LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                lightAppContactSelectModelBase64.result = contactSelectModel.result;
                ContactSelectModel.Data data2 = contactSelectModel.cnt;
                if (data2 != null) {
                    lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data2).getBytes());
                }
                a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
            } else {
                a("selectPhonefromAdressBook", 0, contactSelectModel.toJson());
            }
        }
    }

    public void onFileFetchDone(int i2, int i3, Intent intent) {
        ILightappInvokerCallback iLightappInvokerCallback = this.b.get(METHOD_CALL_FILE_FETCH);
        if (iLightappInvokerCallback == null) {
            b(METHOD_CALL_FILE_FETCH, Integer.parseInt("10003"), "callback is null");
        } else if (i2 == 7 && i3 == -1) {
            Uri data = intent.getData();
            if (data == null) {
                a(iLightappInvokerCallback, "10003", "uri is null");
                return;
            }
            try {
                String fileAbsolutePath = FileFetchManager.getFileAbsolutePath(this.k.getActivity(), data);
                if (TextUtils.isEmpty(fileAbsolutePath)) {
                    a(iLightappInvokerCallback, "10003", "file path is null");
                    return;
                }
                File file = new File(fileAbsolutePath);
                if (file.exists()) {
                    boolean isValidFileLength = FileFetchManager.isValidFileLength(this.u, file.length());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("" + file.length());
                    arrayList.add(this.w);
                    arrayList.add(String.valueOf(isValidFileLength));
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_FETCH_FILE_SIZE, arrayList);
                    if (!isValidFileLength) {
                        PromptTipDialog promptTipDialog = new PromptTipDialog(this.k.getActivity());
                        promptTipDialog.setTitleMessage(this.k.getActivity().getString(R.string.wallet_file_fetch_dialog_title));
                        promptTipDialog.setMessage(this.k.getActivity().getString(R.string.wallet_file_fetch_dialog_message, new Object[]{String.valueOf(this.u)}));
                        promptTipDialog.show();
                        a(iLightappInvokerCallback, LightappConstants.ERRCODE_FILE_SIZE_TOO_LARGE, "file size is too large");
                        return;
                    }
                    String name = file.getName();
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[((int) file.length())];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    String encodeToString = Base64Utils.encodeToString(bArr);
                    if (iLightappInvokerCallback != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("file_data", encodeToString);
                        jSONObject.put("file_name", name);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("data", jSONObject);
                        jSONObject2.put("errCode", 0);
                        jSONObject2.put("desc", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("cnt", jSONObject2);
                        jSONObject3.put("result", 0);
                        iLightappInvokerCallback.onResult(0, jSONObject3.toString());
                        return;
                    }
                    b(METHOD_CALL_FILE_FETCH, Integer.parseInt("10003"), "callback is null");
                    return;
                }
                a(iLightappInvokerCallback, "10003", "file is not exists");
            } catch (Exception unused) {
                a(iLightappInvokerCallback, "10003", "file fetch exception");
            }
        } else {
            a(iLightappInvokerCallback, "10005", "file fetch is cancel");
        }
    }

    public void onRequestPermissionsResult(String str, int i2, String[] strArr, int[] iArr) {
        int i3 = 0;
        boolean z2 = ArrayUtils.isEmpty((Object[]) strArr) || ArrayUtils.isEmpty(iArr);
        CommonPermissionCallback commonPermissionCallback = this.t;
        if (commonPermissionCallback != null) {
            commonPermissionCallback.onRequestPermissionsResult(i2, strArr, iArr);
            this.t = null;
        }
        switch (i2) {
            case 209:
                if (z2) {
                    b();
                    return;
                }
                while (i3 < strArr.length) {
                    if ("android.permission.CAMERA".equalsIgnoreCase(strArr[i3]) && i3 < iArr.length) {
                        int i4 = iArr[i3];
                        if (i4 == 0) {
                            if (PermissionManager.checkCallingPermission(this.k.getActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                                a((Context) this.k.getActivity());
                            } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 210)) {
                                b(LightappBusinessClient.METHOD_CALL_CAMERA);
                            }
                        } else if (i4 == -1) {
                            b();
                        }
                    }
                    i3++;
                }
                return;
            case 210:
                if (z2) {
                    b(LightappBusinessClient.METHOD_CALL_CAMERA);
                    return;
                }
                while (i3 < strArr.length) {
                    if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i3]) && i3 < iArr.length) {
                        int i5 = iArr[i3];
                        if (i5 == 0) {
                            if (PermissionManager.checkCallingPermission(this.k.getActivity(), "android.permission.CAMERA")) {
                                a((Context) this.k.getActivity());
                            } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{"android.permission.CAMERA"}, 209)) {
                                b();
                            }
                        } else if (i5 == -1) {
                            b(LightappBusinessClient.METHOD_CALL_CAMERA);
                        }
                    }
                    i3++;
                }
                return;
            case 211:
                if (z2) {
                    c(str);
                    return;
                }
                while (i3 < strArr.length) {
                    if ("android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i3]) && i3 < iArr.length) {
                        int i6 = iArr[i3];
                        if (i6 == 0) {
                            c();
                        } else if (i6 == -1) {
                            c(str);
                        }
                    }
                    i3++;
                }
                return;
            case 212:
                if (ArrayUtils.isEmpty(iArr) || iArr[0] == 0) {
                    d();
                    return;
                }
                a(this.k.getContext(), this.z, new LightAppNewLocationModel());
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_NO_PERMISSION);
                return;
            case 213:
                if (z2 || (!ArrayUtils.isEmpty(iArr) && iArr[0] != 0)) {
                    b(METHOD_CALL_FILE_FETCH);
                    return;
                } else {
                    FileFetchManager.pickFile(this.k.getActivity(), 7, this.v);
                    return;
                }
            default:
                return;
        }
    }

    private void b() {
        LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
        LogUtil.d(lightAppTakePictureModel.toJson());
        LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
        data.errCode = "10002";
        data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有" + "访问相机的权限";
        a(LightappBusinessClient.METHOD_CALL_CAMERA, 1, lightAppTakePictureModel.toJson());
    }

    private void c(String str) {
        ContactSelectModel contactSelectModel = new ContactSelectModel(1);
        ContactSelectModel.Data data = contactSelectModel.cnt;
        data.errCode = "10002";
        data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有" + "访问通信录的权限";
        a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
    }

    private void d() {
        if (!TextUtils.isEmpty(this.y)) {
            d(this.k.getContext(), this.y, this.x, this.z);
            this.y = null;
            this.z = null;
        }
    }

    private void e() {
        if (this.x != null) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = "10003";
            data.des = "定位失败";
            B = "";
            this.x.onResult(1, lightAppErrorModel.toJson());
        }
    }

    private void f(JSONObject jSONObject, String str) {
        ILightappInvokerCallback iLightappInvokerCallback = this.b.get(SCREEN_CAPTURE_SETTINGS);
        final boolean optBoolean = jSONObject.optBoolean("prevent", false);
        if (this.k.getActivity() != null) {
            LightappUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (optBoolean) {
                        BdWalletUtils.addFlagsSecure(LightappJsNativeClient.this.k.getActivity());
                    } else {
                        BdWalletUtils.clearFlagsSecure(LightappJsNativeClient.this.k.getActivity());
                    }
                }
            });
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
            return;
        }
        iLightappInvokerCallback.onResult(1, LightappUtils.assembleFailResultWithErrCode("10003", EnterDxmPayServiceAction.ERROR_MSG_INSIDE));
    }

    private void g(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = jSONObject;
        String str2 = str;
        String optString = jSONObject2.optString("title");
        if (TextUtils.isEmpty(optString)) {
            LightappUtils.onError(this.b.get(INSERT_CALENDAR_EVENT), str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "标题不能为空", "#insertCalendarEventFail");
            return;
        }
        Long valueOf = Long.valueOf(jSONObject2.optLong("beginTime"));
        Long valueOf2 = Long.valueOf(jSONObject2.optLong("endTime"));
        if (valueOf.longValue() < 0 || valueOf2.longValue() < 0 || valueOf2.longValue() < valueOf.longValue()) {
            String str3 = valueOf.longValue() < 0 ? "开始时间必须大于零" : "";
            if (valueOf2.longValue() < 0) {
                str3 = str3 + "结束时间必须大于零";
            }
            if (valueOf2.longValue() < valueOf.longValue()) {
                str3 = str3 + "结束时间必须大于开始时间";
            }
            LightappUtils.onError(this.b.get(INSERT_CALENDAR_EVENT), str2, LightappConstants.ERRCODE_INVALID_PARAMETER, str3, "#insertCalendarEventFail");
            return;
        }
        Intent putExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("title", optString).putExtra("beginTime", valueOf).putExtra("endTime", valueOf2).putExtra("allDay", jSONObject2.optBoolean("allDay")).putExtra("eventLocation", jSONObject2.optString("eventLocation")).putExtra(BiometricPrompt.KEY_DESCRIPTION, jSONObject2.optString(BiometricPrompt.KEY_DESCRIPTION)).putExtra("rrule", jSONObject2.optString("rrule"));
        if (this.k.getActivity() != null) {
            try {
                this.k.getActivity().startActivityForResult(putExtra, 6);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(this.k.getActivity(), ResUtils.string(this.k.getActivity(), "insert_calendar_not_available"), 1).show();
                LightappUtils.onError(this.b.get(INSERT_CALENDAR_EVENT), str2, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, ResUtils.getString(this.k.getContext(), "insert_calendar_not_available"), LightAppStatEvent.LIGHT_APP_INSERT_CALENDAR_NOT_AVAILABLE);
            }
        } else {
            LightappUtils.onError(this.b.get(INSERT_CALENDAR_EVENT), str2, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, "mImpl getActivity is null", LightAppStatEvent.LIGHT_APP_INSERT_CALENDAR_NOT_AVAILABLE);
        }
    }

    private void a(String str, String str2) {
        LogUtil.logd("method:" + str + "#options=" + str2);
    }

    private void d(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (TextUtils.isEmpty(B) || System.currentTimeMillis() - this.A >= C) {
            this.A = System.currentTimeMillis();
            LogUtil.d(METHOD_GET_CURRENT_POSITION, "use not cache");
            a(METHOD_GET_CURRENT_POSITION, str);
            final LightAppNewLocationModel lightAppNewLocationModel = new LightAppNewLocationModel();
            final AnonymousClass4 r0 = new ILocationCallback() {
                public void onReceiveLocation(Object obj) {
                    ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                    if (iLightappInvokerCallback instanceof LightappJsClient.LightappInvokerCallbackImpl) {
                        ((LightappJsClient.LightappInvokerCallbackImpl) iLightappInvokerCallback).addStatics(LightappJsNativeClient.this.s.name());
                    }
                    if (obj == null || !(obj instanceof LightAppLocationModel)) {
                        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                        data.errCode = "10003";
                        data.des = "定位失败";
                        String unused = LightappJsNativeClient.B = "";
                        iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
                        return;
                    }
                    LightAppLocationModel lightAppLocationModel = (LightAppLocationModel) obj;
                    LightAppNewLocationModel lightAppNewLocationModel = lightAppNewLocationModel;
                    lightAppNewLocationModel.result = 0;
                    LightAppNewLocationModel.Loc loc = lightAppNewLocationModel.cnt.data;
                    LightAppLocationModel.Coords coords = lightAppLocationModel.coords;
                    loc.latitude = coords.latitude;
                    loc.longitude = coords.longitude;
                    String json = lightAppNewLocationModel.toJson();
                    String unused2 = LightappJsNativeClient.B = json;
                    iLightappInvokerCallback.onResult(0, json);
                    LightAppLocationModel.Coords coords2 = lightAppLocationModel.coords;
                    LocationCache.a(coords2.latitude, coords2.longitude, LocationCache.Coord.BD09LL, LightappJsNativeClient.this.s);
                }
            };
            if (!LightAppWrapper.getInstance().getCurrentLocation(r0)) {
                if (!this.r) {
                    try {
                        this.q = Class.forName("com.baidu.wallet.locationsdk.LocationInvoker").getDeclaredMethod("getLocation", new Class[]{Context.class, InvocationHandler.class});
                    } catch (Throwable th2) {
                        this.r = true;
                        throw th2;
                    }
                    this.r = true;
                }
                Method method = this.q;
                if (method != null) {
                    this.s = LocationProvider.OWN;
                    try {
                        method.invoke((Object) null, new Object[]{context, new InvocationHandler() {
                            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0 || objArr.length < 3) {
                                    r0.onReceiveLocation((Object) null);
                                } else {
                                    LightAppLocationModel lightAppLocationModel = new LightAppLocationModel();
                                    lightAppLocationModel.result = 0;
                                    LightAppLocationModel.Coords coords = new LightAppLocationModel.Coords();
                                    lightAppLocationModel.coords = coords;
                                    coords.accuracy = objArr[0].floatValue();
                                    lightAppLocationModel.coords.latitude = objArr[1].doubleValue();
                                    lightAppLocationModel.coords.longitude = objArr[2].doubleValue();
                                    r0.onReceiveLocation(lightAppLocationModel);
                                }
                                return null;
                            }
                        }});
                    } catch (Throwable unused) {
                        r0.onReceiveLocation((Object) null);
                        LogUtil.d("InvokeLocatonLib", "lib invoke fail");
                    }
                } else {
                    this.s = LocationProvider.SYSTEM;
                    b(context, str2, lightAppNewLocationModel);
                    LogUtil.d("InvokeLocatonLib", "systme location lib invoke");
                }
            }
        } else {
            LogUtil.d(METHOD_GET_CURRENT_POSITION, "use cache::  " + (System.currentTimeMillis() - this.A));
            if (iLightappInvokerCallback != null) {
                if (iLightappInvokerCallback instanceof LightappJsClient.LightappInvokerCallbackImpl) {
                    ((LightappJsClient.LightappInvokerCallbackImpl) iLightappInvokerCallback).addStatics(SapiOptions.KEY_CACHE);
                }
                iLightappInvokerCallback.onResult(0, B);
            }
        }
    }

    private void a(Context context) {
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if (externalStoragePublicDirectory != null && !externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
            if (externalStoragePublicDirectory != null) {
                File file = new File(externalStoragePublicDirectory.getAbsolutePath() + File.separator + "call_camera.jpg");
                if (file.exists()) {
                    file.delete();
                }
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                try {
                    intent.putExtra("output", Uri.fromFile(file));
                    this.k.getActivity().startActivityForResult(intent, 3);
                    this.l = file.getAbsolutePath();
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
            LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
            data.errCode = "10003";
            data.des = e3.getMessage();
            a(LightappBusinessClient.METHOD_CALL_CAMERA, 1, lightAppTakePictureModel.toJson());
        }
    }

    private void c() {
        ContactManager.getIContactsImpl().pickContactsByContactsContentUri(this.k.getActivity(), 4);
    }

    private void b(String str, int i2, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("" + i2);
        arrayList.add(str2);
        arrayList.add(str);
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList);
    }

    private void c(final Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        this.x = iLightappInvokerCallback;
        if (PermissionManager.checkCallingPermission(context, "android.permission.ACCESS_FINE_LOCATION") || PermissionManager.checkCallingPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            d(context, str, iLightappInvokerCallback, str2);
            return;
        }
        this.y = str;
        this.z = str2;
        this.t = BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", this.k.getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
            public void isAllAgree(Boolean bool) {
                if (bool.booleanValue()) {
                    PermissionManager.checkCallingOrSelfPermission(LightappJsNativeClient.this.k.getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 212);
                } else {
                    LightappJsNativeClient.this.a(context, str2, new LightAppNewLocationModel());
                }
            }

            public void isShow(String str, Boolean bool) {
            }

            public void requestResult(String str, Boolean bool) {
            }
        });
    }

    private void e(JSONObject jSONObject, String str) {
        this.k.preLoadException(jSONObject.optString("msg", ""));
    }

    private void e(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Long l2;
        Long l3 = 500L;
        try {
            l2 = Long.valueOf(new JSONObject(str).optLong("time", l3.longValue()));
        } catch (JSONException e2) {
            e2.printStackTrace();
            l2 = l3;
        }
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (l2.longValue() > 0) {
            l3 = l2;
        }
        vibrator.vibrate(l3.longValue());
        iLightappInvokerCallback.onResult(0, "");
    }

    private void b(String str) {
        LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
        LogUtil.d(lightAppTakePictureModel.toJson());
        LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
        data.errCode = "10002";
        data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有" + "读写存储卡的权限";
        a(str, 1, lightAppTakePictureModel.toJson());
    }

    private void c(JSONObject jSONObject, String str) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = -1;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("url");
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                String optString = jSONArray.optString(i4);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            i2 = jSONObject.optInt("life", -1);
        } catch (JSONException e2) {
            e2.printStackTrace();
            i2 = -1;
        }
        if (arrayList.size() > 0) {
            com.baidu.wallet.lightapp.multipage.a aVar = this.k;
            if (i2 > 0) {
                i3 = i2;
            }
            aVar.preLoadUrl(arrayList, i3);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Context r8, java.lang.String r9, com.baidu.wallet.api.ILightappInvokerCallback r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "getDeviceInfo"
            r7.a((java.lang.String) r1, (java.lang.String) r9)
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel r9 = new com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel     // Catch:{ Exception -> 0x00b6 }
            r2 = 0
            r9.<init>(r2)     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x0017 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x0017 }
            java.lang.String r4 = com.baidu.android.common.util.DeviceId.getCUID(r8)     // Catch:{ Exception -> 0x0017 }
            r3.BAIDUCUID = r4     // Catch:{ Exception -> 0x0017 }
        L_0x0017:
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = com.baidu.apollon.utils.PhoneUtils.getCUID(r8)     // Catch:{ Exception -> 0x00b6 }
            r3.cuid = r4     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = "Android"
            r3.os = r4     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ Exception -> 0x00b6 }
            r3.brand = r4     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x00b6 }
            r3.version = r4     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ Exception -> 0x00b6 }
            r3.model = r4     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = com.baidu.apollon.utils.PhoneUtils.getIpInfo()     // Catch:{ Exception -> 0x00b6 }
            r3.ip = r4     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r3 = com.baidu.apollon.utils.PhoneUtils.getApplicationName(r8)     // Catch:{ Exception -> 0x00b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6 }
            r4.<init>()     // Catch:{ Exception -> 0x00b6 }
            int r5 = com.baidu.apollon.utils.PhoneUtils.getAppVersionCode(r8)     // Catch:{ Exception -> 0x00b6 }
            r4.append(r5)     // Catch:{ Exception -> 0x00b6 }
            r4.append(r0)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r5 = com.baidu.apollon.utils.PhoneUtils.getAppVersionName(r8)     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r6 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r6 = r6.data     // Catch:{ Exception -> 0x00b6 }
            r6.appversioncode = r4     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r4 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r4 = r4.data     // Catch:{ Exception -> 0x00b6 }
            r4.appversionname = r5     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r4 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r4 = r4.data     // Catch:{ Exception -> 0x00b6 }
            r4.name = r3     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = com.baidu.apollon.utils.BussinessUtils.getUA(r8)     // Catch:{ Exception -> 0x00b6 }
            r3.ua = r4     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$Data r3 = r9.cnt     // Catch:{ Exception -> 0x00b6 }
            com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel$DeviceInfo r3 = r3.data     // Catch:{ Exception -> 0x00b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6 }
            r4.<init>()     // Catch:{ Exception -> 0x00b6 }
            r4.append(r0)     // Catch:{ Exception -> 0x00b6 }
            int r8 = com.baidu.apollon.utils.NetworkUtils.getNetworkType(r8)     // Catch:{ Exception -> 0x00b6 }
            r4.append(r8)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r8 = r4.toString()     // Catch:{ Exception -> 0x00b6 }
            r3.networktype = r8     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r8 = r9.toJson()     // Catch:{ Exception -> 0x00b6 }
            r7.a((java.lang.String) r1, (int) r2, (java.lang.String) r8)     // Catch:{ Exception -> 0x00b6 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b6 }
            r9.<init>()     // Catch:{ Exception -> 0x00b6 }
            r9.add(r11)     // Catch:{ Exception -> 0x00b6 }
            byte[] r8 = r8.getBytes()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r8 = com.baidu.apollon.utils.Base64Utils.encodeToString(r8)     // Catch:{ Exception -> 0x00b6 }
            r9.add(r8)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00bd
        L_0x00b6:
            java.lang.String r8 = "10008"
            java.lang.String r9 = "getDeviceInfo fail"
            com.baidu.wallet.lightapp.base.utils.LightappUtils.onError((com.baidu.wallet.api.ILightappInvokerCallback) r10, (java.lang.String) r0, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r0)
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.base.LightappJsNativeClient.b(android.content.Context, java.lang.String, com.baidu.wallet.api.ILightappInvokerCallback, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2, String str2) {
        try {
            if (this.b != null) {
                ILightappInvokerCallback iLightappInvokerCallback = this.b.get(str);
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(i2, str2);
                    this.b.remove(str);
                    return;
                }
                b(str, i2, str2);
                return;
            }
            b(str, i2, str2);
        } catch (Exception e2) {
            b(str, i2, str2);
            e2.printStackTrace();
        }
    }

    private boolean d(String str) {
        return TextUtils.equals("pdf", str) || TextUtils.equals("all", str);
    }

    private void d(JSONObject jSONObject, String str) {
        LogUtil.d("WEBLOG", jSONObject.optString("log", ""));
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        a("selectPhonefromAdressBook", str);
        try {
            String optString = new JSONObject(str).optString("key", (String) null);
            this.p = optString;
            if (optString != null) {
                if (optString.trim().length() == 0) {
                    throw new InvalidParameterException("加密密钥格式非法");
                }
            }
            this.m = LightappUtils.parseJsonInt(str, "type");
            this.n = LightappUtils.parseJsonInt(str, "maxNum");
            this.f3560o = LightappUtils.parseJsonInt(str, "base64");
            if (this.m != c) {
                if (this.m != d) {
                    throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
                }
            }
            if (PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
                c();
            } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, 211)) {
                c(str2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            throw new InvalidParameterException("参数格式非法");
        } catch (Exception e3) {
            e3.printStackTrace();
            ContactSelectModel contactSelectModel = new ContactSelectModel(1);
            ContactSelectModel.Data data = contactSelectModel.cnt;
            data.errCode = LightappConstants.ERRCODE_INVALID_PARAMETER;
            data.des = e3.getLocalizedMessage();
            iLightappInvokerCallback.onResult(1, contactSelectModel.toJson());
        }
    }

    private void b(Context context, String str, LightAppNewLocationModel lightAppNewLocationModel) {
        if (context != null && this.x != null) {
            if (lightAppNewLocationModel == null) {
                lightAppNewLocationModel = new LightAppNewLocationModel();
            }
            LightAppNewLocationModel lightAppNewLocationModel2 = lightAppNewLocationModel;
            ILightappInvokerCallback iLightappInvokerCallback = this.x;
            if (iLightappInvokerCallback instanceof LightappJsClient.LightappInvokerCallbackImpl) {
                ((LightappJsClient.LightappInvokerCallbackImpl) iLightappInvokerCallback).addStatics(LocationProvider.SYSTEM.name());
            }
            LocationManager locationManager = (LocationManager) DxmApplicationContextImpl.getApplicationContext(context).getSystemService(b.c.j);
            if (locationManager != null) {
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(CheckUtils.stripUrlParams(str));
                } catch (Exception unused) {
                }
                locationManager.requestSingleUpdate("network", new a(this.x, str, locationManager, arrayList, lightAppNewLocationModel2), (Looper) null);
                return;
            }
            e();
        }
    }

    private void b(Context context, ILightappInvokerCallback iLightappInvokerCallback, String str) {
        if (this.k instanceof LightappBrowseActivity) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = "10004";
            data.des = "没有找到对应的方法";
            iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String[] a2 = i.a().a(context);
            a2[0] = this.k.getCellHashStamps();
            jSONObject.put("data", new JSONArray(JsonUtils.toJson(a2)));
            String str2 = this.a;
            LogUtil.i(str2, "端能力返回值 getLangbridgeHashStamp = " + jSONObject.toString());
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
        } catch (Throwable th2) {
            th2.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str, "10003", "返回值异常", "#getLangbridgeHashStampFail");
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, LightAppNewLocationModel lightAppNewLocationModel) {
        if (context != null && this.x != null) {
            if (lightAppNewLocationModel == null) {
                lightAppNewLocationModel = new LightAppNewLocationModel();
            }
            lightAppNewLocationModel.result = 1;
            LightAppNewLocationModel.Data data = lightAppNewLocationModel.cnt;
            data.errCode = "10002";
            data.des = PhoneUtils.getApplicationName(context) + "没有" + "获取地理位置的权限";
            a(METHOD_GET_CURRENT_POSITION, 1, lightAppNewLocationModel.toJson());
        }
    }

    private void a(Context context, JSONObject jSONObject, ILightappInvokerCallback iLightappInvokerCallback, String str) {
        this.v = "";
        if (context == null || jSONObject == null || iLightappInvokerCallback == null) {
            b(METHOD_CALL_FILE_FETCH, Integer.valueOf("10003").intValue(), "optionsJson is null");
            return;
        }
        try {
            this.w = jSONObject.toString();
            String optString = jSONObject.optString("file_type");
            this.v = optString;
            if (TextUtils.isEmpty(optString)) {
                a(iLightappInvokerCallback, LightappConstants.ERRCODE_INVALID_PARAMETER, "file_type is null");
            } else if (!d(this.v)) {
                a(iLightappInvokerCallback, LightappConstants.ERRCODE_INVALID_PARAMETER, "file_type is invalid :: " + this.v);
            } else {
                double optDouble = jSONObject.optDouble("file_size", 0.0d);
                this.u = optDouble;
                if (optDouble <= 0.0d) {
                    a(iLightappInvokerCallback, LightappConstants.ERRCODE_INVALID_PARAMETER, "file_size is invalid param :: " + this.u);
                } else if (PermissionManager.checkCallingPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                    FileFetchManager.pickFile(this.k.getActivity(), 7, this.v);
                } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 213)) {
                    b(METHOD_CALL_FILE_FETCH);
                }
            }
        } catch (Exception unused) {
            a(iLightappInvokerCallback, "10003", "callFileFetch exception");
        }
    }

    private void b(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("backup_url", "");
        if (!TextUtils.isEmpty(optString)) {
            this.k.openInNewWebView(optString, optString2);
        }
    }

    private void a(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2) {
        LightappUtils.onError(iLightappInvokerCallback, "", str, str2, "");
    }

    private void a(Context context, ILightappInvokerCallback iLightappInvokerCallback, String str) {
        LangbridgeSettings a2 = h.a().a(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", JsonUtils.toJson(a2));
            String str2 = this.a;
            LogUtil.i(str2, "端能力返回值 框架配置情况 = " + jSONObject.toString());
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
        } catch (Throwable th2) {
            th2.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str, "10003", "返回值异常", "#getLangbridgeSettingsFail");
        }
    }

    private void a(JSONObject jSONObject, String str) {
        this.k.historyGo(jSONObject.optInt(ShareCallPacking.StatModel.KEY_INDEX));
    }

    private void a(ILightappInvokerCallback iLightappInvokerCallback, String str) {
        if (this.k == null) {
            LightappUtils.onError(iLightappInvokerCallback, str, "10003", "internal error", "#isPreloadedFail");
        }
        boolean isPreloaded = this.k.isPreloaded();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", isPreloaded ? "1" : "0");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (iLightappInvokerCallback != null) {
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
        }
    }
}
