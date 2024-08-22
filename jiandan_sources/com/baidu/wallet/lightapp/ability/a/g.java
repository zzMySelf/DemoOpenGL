package com.baidu.wallet.lightapp.ability.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.restnet.http.b;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.core.permission.PermissionListener;
import com.baidu.wallet.core.permission.PermissionsUtil;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.lightapp.ability.NativeAbilityInvoker;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityNewLocationModel;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import com.baidu.wallet.lightapp.base.datamodel.LightAppLocationModel;
import com.baidu.wallet.lightapp.base.datamodel.LocationProvider;
import com.baidu.wallet.permission.CommonPermissionCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class g extends b {
    public Method a = null;
    public boolean b = false;
    public LocationProvider c = LocationProvider.HOST;
    public CommonPermissionCallback d;

    public static class a implements LocationListener {
        public final ILightappInvokerCallback a;
        public final String b;
        public final LocationManager c;
        public final ArrayList<String> d;
        public final NativeAbilityNewLocationModel e;
        public Context f;

        public a(Context context, ILightappInvokerCallback iLightappInvokerCallback, String str, LocationManager locationManager, ArrayList<String> arrayList, NativeAbilityNewLocationModel nativeAbilityNewLocationModel) {
            this.f = context;
            this.a = iLightappInvokerCallback;
            this.b = str;
            this.c = locationManager;
            this.d = arrayList;
            this.e = nativeAbilityNewLocationModel;
        }

        public void onLocationChanged(Location location) {
            if (location != null) {
                NativeAbilityNewLocationModel nativeAbilityNewLocationModel = this.e;
                nativeAbilityNewLocationModel.result = 0;
                nativeAbilityNewLocationModel.cnt.data.latitude = location.getLatitude();
                this.e.cnt.data.longitude = location.getLongitude();
                Bundle a2 = com.baidu.wallet.lightapp.ability.b.a.a().a(this.f, JsonUtils.toJson(this.e.cnt.data));
                this.e.cnt.aesdata = a2.getString("aesContent");
                this.e.cnt.aeskey = a2.getString("aesKey");
                NativeAbilityNewLocationModel nativeAbilityNewLocationModel2 = this.e;
                nativeAbilityNewLocationModel2.cnt.data = null;
                this.a.onResult(0, nativeAbilityNewLocationModel2.toJson());
            } else {
                NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
                NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
                data.errCode = "10003";
                data.des = "定位失败";
                this.a.onResult(1, nativeAbilityErrorModel.toJson());
            }
            this.c.removeUpdates(this);
        }

        public void onProviderDisabled(String str) {
            NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
            NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
            data.errCode = "10003";
            data.des = "定位失败";
            this.a.onResult(1, nativeAbilityErrorModel.toJson());
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    public String a() {
        return LightappJsNativeClient.METHOD_GET_CURRENT_POSITION;
    }

    /* access modifiers changed from: private */
    public void b(Context context, String str, NativeAbilityNewLocationModel nativeAbilityNewLocationModel, ILightappInvokerCallback iLightappInvokerCallback) {
        if (context != null && iLightappInvokerCallback != null) {
            if (nativeAbilityNewLocationModel == null) {
                nativeAbilityNewLocationModel = new NativeAbilityNewLocationModel();
            }
            nativeAbilityNewLocationModel.result = 1;
            NativeAbilityNewLocationModel.Data data = nativeAbilityNewLocationModel.cnt;
            data.errCode = "10002";
            data.des = PhoneUtils.getApplicationName(context) + "没有" + "获取地理位置的权限";
            iLightappInvokerCallback.onResult(1, nativeAbilityNewLocationModel.toJson());
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(CheckUtils.stripUrlParams(str));
            } catch (Exception unused) {
            }
            arrayList.add(nativeAbilityNewLocationModel.cnt.des);
        }
    }

    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (PermissionManager.checkCallingPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || PermissionManager.checkCallingPermission(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            a((Context) activity, str, iLightappInvokerCallback, str2);
            return;
        }
        final Activity activity2 = activity;
        final String str3 = str;
        final ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        final String str4 = str2;
        this.d = BaiduWalletUtils.requestPermissionsDialog((String) null, activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
            public void isAllAgree(Boolean bool) {
                if (bool.booleanValue()) {
                    PermissionsUtil.requestPermission(activity2, new PermissionListener() {
                        public void permissionDenied(@NonNull List<String> list) {
                            AnonymousClass1 r7 = AnonymousClass1.this;
                            g.this.b(activity2, str4, (NativeAbilityNewLocationModel) null, iLightappInvokerCallback2);
                            if (g.this.d != null) {
                                g.this.d.onRequestPermissionsResult(64, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new int[]{-1});
                                CommonPermissionCallback unused = g.this.d = null;
                            }
                        }

                        public void permissionGranted(@NonNull List<String> list) {
                            AnonymousClass1 r5 = AnonymousClass1.this;
                            g.this.a((Context) activity2, str3, iLightappInvokerCallback2, str4);
                            if (g.this.d != null) {
                                g.this.d.onRequestPermissionsResult(64, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new int[]{0});
                                CommonPermissionCallback unused = g.this.d = null;
                            }
                        }
                    }, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION");
                } else {
                    g.this.b(activity2, str4, (NativeAbilityNewLocationModel) null, iLightappInvokerCallback2);
                }
            }

            public void isShow(String str, Boolean bool) {
            }

            public void requestResult(String str, Boolean bool) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        iLightappInvokerCallback.onResult(-1, "");
        new Thread() {
            public void run() {
                try {
                    new ArrayList().add(CheckUtils.stripUrlParams(str2));
                } catch (Exception unused) {
                }
                final NativeAbilityNewLocationModel nativeAbilityNewLocationModel = new NativeAbilityNewLocationModel();
                final AnonymousClass1 r1 = new ILocationCallback() {
                    public void onReceiveLocation(Object obj) {
                        AnonymousClass2 r0 = AnonymousClass2.this;
                        ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                        if (iLightappInvokerCallback instanceof NativeAbilityInvoker.NativeAbilityInvokerCallback) {
                            ((NativeAbilityInvoker.NativeAbilityInvokerCallback) iLightappInvokerCallback).addStatics(g.this.c.name());
                        }
                        if (obj == null || !(obj instanceof LightAppLocationModel)) {
                            NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
                            NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
                            data.errCode = "10003";
                            data.des = "定位失败";
                            iLightappInvokerCallback.onResult(1, nativeAbilityErrorModel.toJson());
                            return;
                        }
                        NativeAbilityNewLocationModel nativeAbilityNewLocationModel = nativeAbilityNewLocationModel;
                        nativeAbilityNewLocationModel.result = 0;
                        NativeAbilityNewLocationModel.Loc loc = nativeAbilityNewLocationModel.cnt.data;
                        LightAppLocationModel.Coords coords = ((LightAppLocationModel) obj).coords;
                        loc.latitude = coords.latitude;
                        loc.longitude = coords.longitude;
                        Bundle a2 = com.baidu.wallet.lightapp.ability.b.a.a().a(context, JsonUtils.toJson(nativeAbilityNewLocationModel.cnt.data));
                        nativeAbilityNewLocationModel.cnt.aesdata = a2.getString("aesContent");
                        nativeAbilityNewLocationModel.cnt.aeskey = a2.getString("aesKey");
                        NativeAbilityNewLocationModel nativeAbilityNewLocationModel2 = nativeAbilityNewLocationModel;
                        nativeAbilityNewLocationModel2.cnt.data = null;
                        iLightappInvokerCallback.onResult(0, nativeAbilityNewLocationModel2.toJson());
                    }
                };
                if (!LightAppWrapper.getInstance().getCurrentLocation(r1)) {
                    LocationProvider unused2 = g.this.c = LocationProvider.OWN;
                    if (!g.this.b) {
                        try {
                            Class<?> cls = Class.forName("com.baidu.wallet.locationsdk.LocationInvoker");
                            Method unused3 = g.this.a = cls.getDeclaredMethod("getLocation", new Class[]{Context.class, InvocationHandler.class});
                        } catch (Throwable th2) {
                            boolean unused4 = g.this.b = true;
                            throw th2;
                        }
                        boolean unused5 = g.this.b = true;
                    }
                    if (g.this.a != null) {
                        try {
                            g.this.a.invoke((Object) null, new Object[]{context, new InvocationHandler() {
                                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                                    if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0 || objArr.length < 3) {
                                        r1.onReceiveLocation((Object) null);
                                    } else {
                                        LightAppLocationModel lightAppLocationModel = new LightAppLocationModel();
                                        lightAppLocationModel.result = 0;
                                        LightAppLocationModel.Coords coords = new LightAppLocationModel.Coords();
                                        lightAppLocationModel.coords = coords;
                                        coords.accuracy = objArr[0].floatValue();
                                        lightAppLocationModel.coords.latitude = objArr[1].doubleValue();
                                        lightAppLocationModel.coords.longitude = objArr[2].doubleValue();
                                        r1.onReceiveLocation(lightAppLocationModel);
                                    }
                                    return null;
                                }
                            }});
                        } catch (Throwable unused6) {
                            r1.onReceiveLocation((Object) null);
                            LogUtil.d("InvokeLocatonLib", "lib invoke fail");
                        }
                    } else {
                        LocationProvider unused7 = g.this.c = LocationProvider.SYSTEM;
                        g.this.a(context, str2, nativeAbilityNewLocationModel, iLightappInvokerCallback);
                        com.baidu.wallet.core.utils.LogUtil.d("InvokeLocatonLib", "systme location lib invoke");
                    }
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void a(Context context, String str, NativeAbilityNewLocationModel nativeAbilityNewLocationModel, ILightappInvokerCallback iLightappInvokerCallback) {
        if (context != null && iLightappInvokerCallback != null) {
            if (nativeAbilityNewLocationModel == null) {
                nativeAbilityNewLocationModel = new NativeAbilityNewLocationModel();
            }
            NativeAbilityNewLocationModel nativeAbilityNewLocationModel2 = nativeAbilityNewLocationModel;
            if (iLightappInvokerCallback instanceof NativeAbilityInvoker.NativeAbilityInvokerCallback) {
                ((NativeAbilityInvoker.NativeAbilityInvokerCallback) iLightappInvokerCallback).addStatics(LocationProvider.SYSTEM.name());
            }
            LocationManager locationManager = (LocationManager) DxmApplicationContextImpl.getApplicationContext(context).getSystemService(b.c.j);
            if (locationManager != null) {
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(CheckUtils.stripUrlParams(str));
                } catch (Exception unused) {
                }
                locationManager.requestSingleUpdate("network", new a(context, iLightappInvokerCallback, str, locationManager, arrayList, nativeAbilityNewLocationModel2), (Looper) null);
                return;
            }
            NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
            NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
            data.errCode = "10003";
            data.des = "定位失败";
            iLightappInvokerCallback.onResult(1, nativeAbilityErrorModel.toJson());
        }
    }
}
