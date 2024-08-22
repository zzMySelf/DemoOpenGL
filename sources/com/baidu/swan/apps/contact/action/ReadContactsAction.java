package com.baidu.swan.apps.contact.action;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.media.image.Closeables;
import com.baidu.swan.apps.permission.RequestPermissionHelper;
import com.baidu.swan.apps.permission.RequestPermissionListener;
import com.baidu.swan.apps.permission.SwanAppPermission;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.setting.SwanAppSetting;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.record.SwanAppAuthRecordManager;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadContactsAction extends SwanAppAction {
    public static final String ACTION_TYPE = "/swanAPI/getPhoneContacts";
    private static final String KEY_CONTACTS = "contacts";
    private static final String KEY_DISPLAY_NAME = "name";
    private static final String KEY_FAMILY_NAME = "lastName";
    private static final String KEY_GIVEN_NAME = "firstName";
    private static final String KEY_MIDDLE_NAME = "middleName";
    private static final String KEY_MOBILE_PHONE_NUMBER = "phoneNumbers";
    private static final String KEY_NICK_NAME = "nickName";
    private static final String KEY_NOTE = "remark";
    private static final String MODULE_TAG = "ReadContacts";
    private static final String PERMISSION_READ_CONTACTS = "android.permission.READ_CONTACTS";
    private static final String TAG = "ReadContactsAction";

    public ReadContactsAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        Context context2 = context;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        if (swanApp == null) {
            SwanAppLog.e(MODULE_TAG, "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject joParams = UnitedSchemeUtility.optParamsAsJo(entity);
        if (joParams == null) {
            SwanAppLog.e(MODULE_TAG, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        SwanAppLog.i(MODULE_TAG, "params is:" + joParams.toString());
        if (!(context2 instanceof Activity)) {
            SwanAppLog.e(MODULE_TAG, "the context is error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the context is error");
            return false;
        }
        Activity activity = (Activity) context2;
        String cb = joParams.optString("cb");
        if (TextUtils.isEmpty(cb)) {
            SwanAppLog.e(MODULE_TAG, "the callback is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the callback is null");
            return false;
        }
        String invokeFrom = joParams.optString("invokeFrom");
        boolean isAlreadyLogin = swanApp.getAccount().isLogin(context2);
        if (!isAlreadyLogin) {
            SwanAppUBCStatistic.onSwanAppLoginDataStatistic("show", 7, invokeFrom);
        }
        final SwanApp swanApp2 = swanApp;
        final Context context3 = context;
        final boolean z = isAlreadyLogin;
        final String str = invokeFrom;
        final CallbackHandler callbackHandler = handler;
        AnonymousClass1 r11 = r0;
        final String str2 = cb;
        SwanAppSetting setting = swanApp.getSetting();
        final Activity activity2 = activity;
        AnonymousClass1 r0 = new TypedCallback<TaskResult<Authorize.Result>>() {
            public void onCallback(TaskResult<Authorize.Result> result) {
                boolean isLogin = swanApp2.getAccount().isLogin(context3);
                if (!OAuthUtils.isAuthorizeOk(result)) {
                    if (!isLogin && !z) {
                        SwanAppUBCStatistic.onSwanAppLoginDataStatistic("fail", 7, str);
                    }
                    OAuthUtils.processPermissionDeny(result, callbackHandler, str2);
                    return;
                }
                if (isLogin && !z) {
                    SwanAppUBCStatistic.onSwanAppLoginDataStatistic("success", 7, str);
                }
                SwanAppLog.i(ReadContactsAction.MODULE_TAG, "request authorize success");
                ReadContactsAction.this.startReadContacts(activity2, callbackHandler, str2);
            }
        };
        setting.checkOrAuthorize(activity, "mapp_i_read_contacts", r11);
        UnitedSchemeUtility.callCallback(handler, unitedSchemeEntity, 0);
        return true;
    }

    /* access modifiers changed from: private */
    public void startReadContacts(final Activity activity, final CallbackHandler handler, final String callback) {
        RequestPermissionListener listener = new RequestPermissionListener() {
            public void onAuthorizedSuccess(String msg) {
                ReadContactsAction.this.responseContacts(activity, handler, callback);
                SwanAppLog.e(ReadContactsAction.MODULE_TAG, msg + "");
            }

            public void onAuthorizedFailed(int errorCode, String errorMsg) {
                OAuthUtils.processPermissionDeny(10005, handler, callback);
                SwanAppLog.e(ReadContactsAction.MODULE_TAG, errorMsg + "");
            }
        };
        RequestPermissionHelper.handleSystemAuthorizedWithDialog(PERMISSION_READ_CONTACTS, new String[]{PERMISSION_READ_CONTACTS}, SwanAppPermission.REQUEST_CONTACTS_CODE, activity, listener);
    }

    /* access modifiers changed from: private */
    public void responseContacts(Activity activity, CallbackHandler handler, String callback) {
        try {
            JSONObject contacts = readPhoneContacts(activity);
            if (DEBUG) {
                Log.i("ReadContactsAction", "read contacts:" + contacts.toString());
            }
            setErrorCallback(handler, callback, 0, contacts);
            SwanAppAuthRecordManager.INSTANCE.record("mapp_i_read_contacts");
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e("ReadContactsAction", "read contacts error caused by JsonException");
                e2.printStackTrace();
            }
            SwanAppLog.e(MODULE_TAG, "read contacts error caused by JsonException");
            setErrorCallback(handler, callback, 1001, "json parse error");
        } catch (Exception e3) {
            SwanAppLog.e(MODULE_TAG, "read contacts error caused by Exception");
            setErrorCallback(handler, callback, 1001, "read contact error");
        }
    }

    private void setErrorCallback(CallbackHandler handler, String callback, int errCode, JSONObject data) {
        handler.handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams(data, errCode).toString());
    }

    private void setErrorCallback(CallbackHandler handler, String callback, int errCode, String message) {
        handler.handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams(errCode, message).toString());
    }

    private JSONObject readPhoneContacts(Context context) throws JSONException, SecurityException {
        JSONArray res = new JSONArray();
        int preContactId = -1;
        JSONObject item = null;
        JSONArray mobileNums = null;
        Cursor contactCursor = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, (String[]) null, (String) null, (String[]) null, "raw_contact_id");
        if (contactCursor != null && contactCursor.getCount() > 0) {
            while (contactCursor.moveToNext()) {
                int contactId = contactCursor.getInt(contactCursor.getColumnIndex("raw_contact_id"));
                if (preContactId != contactId) {
                    if (!(item == null || mobileNums == null || mobileNums.length() <= 0)) {
                        res.put(item);
                    }
                    item = new JSONObject();
                    mobileNums = new JSONArray();
                    preContactId = contactId;
                }
                if (item != null) {
                    String mimetype = contactCursor.getString(contactCursor.getColumnIndex("mimetype"));
                    char c2 = 65535;
                    switch (mimetype.hashCode()) {
                        case -1079224304:
                            if (mimetype.equals("vnd.android.cursor.item/name")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -1079210633:
                            if (mimetype.equals("vnd.android.cursor.item/note")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 684173810:
                            if (mimetype.equals("vnd.android.cursor.item/phone_v2")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 2034973555:
                            if (mimetype.equals("vnd.android.cursor.item/nickname")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    String str = "";
                    switch (c2) {
                        case 0:
                            String displayName = contactCursor.getString(contactCursor.getColumnIndex("data1"));
                            String familyName = contactCursor.getString(contactCursor.getColumnIndex("data3"));
                            String givenName = contactCursor.getString(contactCursor.getColumnIndex("data2"));
                            String middleName = contactCursor.getString(contactCursor.getColumnIndex("data5"));
                            item.put("name", displayName != null ? displayName : str);
                            item.put("lastName", familyName != null ? familyName : str);
                            item.put("firstName", givenName != null ? givenName : str);
                            if (middleName != null) {
                                str = middleName;
                            }
                            item.put("middleName", str);
                            break;
                        case 1:
                            String note = contactCursor.getString(contactCursor.getColumnIndex("data1"));
                            if (note != null) {
                                str = note;
                            }
                            item.put("remark", str);
                            break;
                        case 2:
                            String mobile = contactCursor.getString(contactCursor.getColumnIndex("data1"));
                            if (!TextUtils.isEmpty(mobile) && mobileNums != null) {
                                mobileNums.put(mobile);
                            }
                            item.put(KEY_MOBILE_PHONE_NUMBER, mobileNums);
                            break;
                        case 3:
                            item.put("nickName", contactCursor.getString(contactCursor.getColumnIndex("data1")));
                            break;
                    }
                }
            }
            if (!(item == null || mobileNums == null || mobileNums.length() <= 0)) {
                res.put(item);
            }
            Closeables.closeSafely(contactCursor);
        }
        JSONObject contacts = new JSONObject();
        contacts.put("contacts", res);
        return contacts;
    }
}
