package com.tera.scan.flutter.plugin.statistic;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.ubc.UBCManager;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import fe.mmm.qw.ggg.qw;
import fe.mmm.qw.p024if.pf.de.o;
import fe.mmm.qw.p024if.pf.de.th;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0016"}, d2 = {"Lcom/tera/scan/flutter/plugin/statistic/StatisticsPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "()V", "channelName", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "retrieveLogSave", "retrieveLogUniqueId", "retrieveLogUpload", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class StatisticsPluginProxy extends BaseFlutterPlugin implements FlutterPlugin {
    public final void i(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(BindVerifyActivity.c);
        if (str == null) {
            str = "";
        }
        Map map = (Map) methodCall.argument("message");
        if (map == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        String str2 = (String) map.get("detail");
        if (str2 != null) {
            String str3 = (String) map.get("jsonMessage");
            if (str3 == null) {
                str3 = StringUtil.EMPTY_ARRAY;
            }
            if (str.length() > 0) {
                th.fe(str2, str3, str);
            } else {
                th.qw(str2);
            }
        }
    }

    public final void o(MethodCall methodCall, MethodChannel.Result result) {
        result.success(th.ad());
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        return false;
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str5 = methodCall.method;
        if (str5 != null) {
            switch (str5.hashCode()) {
                case -1282942009:
                    if (str5.equals("ubc_statistic")) {
                        String str6 = (String) methodCall.argument("eventId");
                        String str7 = str6 == null ? "" : str6;
                        String str8 = (String) methodCall.argument("from");
                        if (str8 == null) {
                            str = "";
                        } else {
                            str = str8;
                        }
                        String str9 = (String) methodCall.argument("type");
                        if (str9 == null) {
                            str2 = "";
                        } else {
                            str2 = str9;
                        }
                        String str10 = (String) methodCall.argument(UBCManager.CONTENT_KEY_PAGE);
                        if (str10 == null) {
                            str3 = "";
                        } else {
                            str3 = str10;
                        }
                        String str11 = (String) methodCall.argument(SavedStateHandle.VALUES);
                        if (str11 == null) {
                            str11 = (String) methodCall.argument("value");
                        }
                        String str12 = str11;
                        String str13 = (String) methodCall.argument(UBCManager.CONTENT_KEY_SOURCE);
                        if (str13 == null) {
                            str4 = "";
                        } else {
                            str4 = str13;
                        }
                        Map map = (Map) methodCall.argument(UBCManager.CONTENT_KEY_EXT);
                        JSONObject jSONObject = map != null ? new JSONObject(map) : null;
                        if (jSONObject == null) {
                            o.qw(str7, str, str2, str3, str12, str4);
                            return;
                        } else {
                            o.ad(str7, str, str2, str3, str12, str4, jSONObject);
                            return;
                        }
                    }
                    break;
                case -840396204:
                    if (str5.equals("retrieveLogUniqueId")) {
                        o(methodCall, result);
                        return;
                    }
                    break;
                case -599441978:
                    if (str5.equals("updateCount")) {
                        Object obj = methodCall.arguments;
                        if (obj != null) {
                            ArrayList arrayList = (ArrayList) obj;
                            Object obj2 = arrayList.get(0);
                            Intrinsics.checkNotNullExpressionValue(obj2, "args[0]");
                            String str14 = (String) obj2;
                            if (arrayList.size() > 1) {
                                List subList = arrayList.subList(1, arrayList.size());
                                Intrinsics.checkNotNullExpressionValue(subList, "args.subList(1, args.size)");
                                Object[] array = subList.toArray(new String[0]);
                                if (array != null) {
                                    qw.qw.qw(str14, ArraysKt___ArraysKt.toList((T[]) (String[]) array));
                                    return;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            }
                            qw.qw.qw(str14, CollectionsKt__CollectionsKt.emptyList());
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
                    }
                    break;
                case -563121403:
                    if (str5.equals("retrieveLogSave")) {
                        i(methodCall, result);
                        return;
                    }
                    break;
                case 77036937:
                    if (str5.equals("retrieveLogUpload")) {
                        pf(methodCall, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    public final void pf(MethodCall methodCall, MethodChannel.Result result) {
        th.de((String) null);
    }

    @NotNull
    public String qw() {
        return "statistics";
    }
}
