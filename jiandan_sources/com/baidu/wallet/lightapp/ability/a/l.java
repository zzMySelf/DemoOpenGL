package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.Crypto;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.permission.PermissionListener;
import com.baidu.wallet.core.permission.PermissionsUtil;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.ability.b.a;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityContactSelectModel;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityContactSelectModelBase64;
import com.baidu.wallet.lightapp.ability.proxy.SelectAddressProxy;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger;
import com.baidu.wallet.permission.CommonPermissionCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.security.InvalidParameterException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends b {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public String d = null;
    public CommonPermissionCallback e;

    public String a() {
        return "selectPhonefromAdressBook";
    }

    public void a(final Activity activity, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        try {
            String optString = new JSONObject(str).optString("key", (String) null);
            this.d = optString;
            if (optString != null) {
                if (optString.trim().length() == 0) {
                    throw new InvalidParameterException("加密密钥格式非法");
                }
            }
            this.a = a(str, "type");
            this.b = a(str, "maxNum");
            this.c = a(str, "base64");
            if (this.a != 1) {
                if (this.a != 2) {
                    throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
                }
            }
            if (PermissionManager.checkCallingPermission(activity, "android.permission.READ_CONTACTS")) {
                a(activity, iLightappInvokerCallback);
            } else {
                this.e = BaiduWalletUtils.requestPermissionsDialog((String) null, activity, new String[]{"android.permission.READ_CONTACTS"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                    public void isAllAgree(Boolean bool) {
                        if (bool.booleanValue()) {
                            PermissionsUtil.requestPermission(activity, new PermissionListener() {
                                public void permissionDenied(@NonNull List<String> list) {
                                    AnonymousClass1 r6 = AnonymousClass1.this;
                                    l.this.a((Context) activity, str2, iLightappInvokerCallback);
                                    if (l.this.e != null) {
                                        l.this.e.onRequestPermissionsResult(64, new String[]{"android.permission.READ_CONTACTS"}, new int[]{-1});
                                        CommonPermissionCallback unused = l.this.e = null;
                                    }
                                }

                                public void permissionGranted(@NonNull List<String> list) {
                                    AnonymousClass1 r5 = AnonymousClass1.this;
                                    l.this.a(activity, iLightappInvokerCallback);
                                    if (l.this.e != null) {
                                        l.this.e.onRequestPermissionsResult(64, new String[]{"android.permission.READ_CONTACTS"}, new int[]{0});
                                        CommonPermissionCallback unused = l.this.e = null;
                                    }
                                }
                            }, "android.permission.READ_CONTACTS");
                        } else {
                            l.this.a((Context) activity, str2, iLightappInvokerCallback);
                        }
                    }

                    public void isShow(String str, Boolean bool) {
                    }

                    public void requestResult(String str, Boolean bool) {
                    }
                });
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

    /* access modifiers changed from: private */
    public void a(final Activity activity, final ILightappInvokerCallback iLightappInvokerCallback) {
        SelectAddressProxy.startSelectAddress(activity, new com.baidu.wallet.lightapp.business.presenter.b() {
            public void onContactsSelected(String str, int i2, String[] strArr, String str2, final String str3) {
                final NativeAbilityContactSelectModel nativeAbilityContactSelectModel = new NativeAbilityContactSelectModel();
                if (i2 != 0) {
                    nativeAbilityContactSelectModel.result = 1;
                    if (TextUtils.equals(str2, "取消")) {
                        nativeAbilityContactSelectModel.cnt.errCode = "10005";
                    } else {
                        nativeAbilityContactSelectModel.cnt.errCode = "10002";
                    }
                    nativeAbilityContactSelectModel.cnt.des = str2;
                    iLightappInvokerCallback.onResult(1, nativeAbilityContactSelectModel.toJson());
                } else if (strArr != null) {
                    String str4 = "";
                    String str5 = strArr.length > 0 ? strArr[0] : str4;
                    if (strArr.length > 1) {
                        str4 = strArr[1];
                    }
                    nativeAbilityContactSelectModel.result = 0;
                    NativeAbilityContactSelectModel.SelectedContact selectedContact = nativeAbilityContactSelectModel.cnt.selected;
                    selectedContact.name = str5;
                    selectedContact.phone = str4;
                    if (l.this.a == 2) {
                        PhoneContactsMananger.a((Context) activity).a((PhoneContactsMananger.d) new PhoneContactsMananger.d() {
                            public void a(List<ContactSelectModel.AllContact> list, int i2) {
                                if (l.this.d != null) {
                                    nativeAbilityContactSelectModel.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), l.this.d));
                                    if (TextUtils.isEmpty(str3)) {
                                        nativeAbilityContactSelectModel.cnt.allCount = "0";
                                    } else {
                                        nativeAbilityContactSelectModel.cnt.allCount = str3;
                                    }
                                } else {
                                    Bundle a2 = a.a().a(activity, JsonUtils.toJson(list));
                                    NativeAbilityContactSelectModel.Data data = nativeAbilityContactSelectModel.cnt;
                                    data.all = null;
                                    data.aesall = a2.getString("aesContent");
                                    nativeAbilityContactSelectModel.cnt.aeskey = a2.getString("aesKey");
                                    if (TextUtils.isEmpty(str3)) {
                                        nativeAbilityContactSelectModel.cnt.allCount = "0";
                                    } else if (list != null) {
                                        NativeAbilityContactSelectModel.Data data2 = nativeAbilityContactSelectModel.cnt;
                                        data2.allCount = list.size() + "";
                                    } else {
                                        nativeAbilityContactSelectModel.cnt.allCount = str3;
                                    }
                                }
                                if (l.this.c == 1) {
                                    NativeAbilityContactSelectModelBase64 nativeAbilityContactSelectModelBase64 = new NativeAbilityContactSelectModelBase64();
                                    NativeAbilityContactSelectModel nativeAbilityContactSelectModel = nativeAbilityContactSelectModel;
                                    nativeAbilityContactSelectModelBase64.result = nativeAbilityContactSelectModel.result;
                                    NativeAbilityContactSelectModel.Data data3 = nativeAbilityContactSelectModel.cnt;
                                    if (data3 != null) {
                                        nativeAbilityContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data3).getBytes());
                                    }
                                    iLightappInvokerCallback.onResult(0, nativeAbilityContactSelectModelBase64.toJson());
                                    return;
                                }
                                iLightappInvokerCallback.onResult(0, nativeAbilityContactSelectModel.toJson());
                            }
                        });
                        if (l.this.b > 0) {
                            PhoneContactsMananger.a((Context) activity).a(l.this.b, false);
                        } else {
                            PhoneContactsMananger.a((Context) activity).a(1000, false);
                        }
                    } else if (l.this.c == 1) {
                        NativeAbilityContactSelectModelBase64 nativeAbilityContactSelectModelBase64 = new NativeAbilityContactSelectModelBase64();
                        nativeAbilityContactSelectModelBase64.result = nativeAbilityContactSelectModel.result;
                        if (nativeAbilityContactSelectModel.cnt != null) {
                            if (TextUtils.isEmpty(str3)) {
                                nativeAbilityContactSelectModel.cnt.allCount = "0";
                            } else {
                                nativeAbilityContactSelectModel.cnt.allCount = str3;
                            }
                            nativeAbilityContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(nativeAbilityContactSelectModel.cnt).getBytes());
                        }
                        iLightappInvokerCallback.onResult(0, nativeAbilityContactSelectModelBase64.toJson());
                    } else {
                        if (nativeAbilityContactSelectModel.cnt != null) {
                            if (TextUtils.isEmpty(str3)) {
                                nativeAbilityContactSelectModel.cnt.allCount = "0";
                            } else {
                                nativeAbilityContactSelectModel.cnt.allCount = str3;
                            }
                        }
                        iLightappInvokerCallback.onResult(0, nativeAbilityContactSelectModel.toJson());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        ContactSelectModel contactSelectModel = new ContactSelectModel(1);
        ContactSelectModel.Data data = contactSelectModel.cnt;
        data.errCode = "10002";
        data.des = PhoneUtils.getApplicationName(context) + "没有" + "访问通信录的权限";
        iLightappInvokerCallback.onResult(1, contactSelectModel.toJson());
    }
}
