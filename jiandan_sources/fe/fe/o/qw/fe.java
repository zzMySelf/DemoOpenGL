package fe.fe.o.qw;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.down.a.e;
import com.baidu.down.loopj.android.b.b;
import com.baidubce.services.vod.VodClient;
import fe.fe.o.rg.de.th;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONObject;

public class fe implements b {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ e f2582ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ Context f2583de;

    /* renamed from: fe  reason: collision with root package name */
    public final /* synthetic */ ad f2584fe;
    public final /* synthetic */ long qw;

    public fe(ad adVar, long j, e eVar, Context context) {
        this.f2584fe = adVar;
        this.qw = j;
        this.f2582ad = eVar;
        this.f2583de = context;
    }

    public void a() {
        if (this.f2584fe.f2578ad != null) {
            this.f2584fe.f2578ad.cancel();
            Timer unused = this.f2584fe.f2578ad = null;
            e eVar = this.f2582ad;
            if (eVar != null) {
                eVar.qw(false, (th) null, 6);
            }
            long unused2 = this.f2584fe.qw = SystemClock.elapsedRealtime() - this.qw;
        }
    }

    public void a(String str) {
        e eVar;
        boolean z;
        if (this.f2584fe.f2578ad != null) {
            this.f2584fe.f2578ad.cancel();
            Timer unused = this.f2584fe.f2578ad = null;
            long unused2 = this.f2584fe.qw = SystemClock.elapsedRealtime() - this.qw;
            if (!TextUtils.isEmpty(str)) {
                try {
                    th thVar = new th();
                    JSONObject jSONObject = new JSONObject(str);
                    thVar.f85if = this.f2584fe.qw;
                    thVar.f2649i = SystemClock.elapsedRealtime();
                    thVar.when = jSONObject.optString("request_id");
                    if (jSONObject.optInt("error_no") == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("fres");
                        if (jSONObject.optInt("fstat", 1) == 0 && optJSONObject != null) {
                            thVar.f2651pf = Integer.parseInt(optJSONObject.optString(VodClient.PARA_MODE, "-1"));
                            optJSONObject.optString("download_inner", "");
                            thVar.f2653th = optJSONObject.optInt("ftime", 600);
                            thVar.f86switch = new ArrayList();
                            if (thVar.f2651pf == 4 || thVar.f2651pf == 5 || thVar.f2651pf == 7) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("down_retry_arr");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                        yj yjVar = new yj();
                                        yjVar.qw = jSONObject2.optString("url");
                                        yjVar.f2595ad = new HashMap();
                                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("header");
                                        if (optJSONArray2 != null && optJSONArray2.length() > 0 && optJSONArray2 != null && optJSONArray2.length() > 0) {
                                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                                                yjVar.f2595ad.put(jSONObject3.optString("name"), jSONObject3.optString("value"));
                                            }
                                        }
                                        if (URLUtil.isValidUrl(yjVar.qw)) {
                                            thVar.f86switch.add(yjVar);
                                        }
                                    }
                                }
                                if (thVar.f86switch != null) {
                                    if (thVar.f86switch.size() == 0) {
                                    }
                                }
                                this.f2582ad.qw(false, (th) null, 5);
                                return;
                            }
                            if (!(thVar.f2651pf == 4 || thVar.f2651pf == 5 || thVar.f2651pf == 6)) {
                                if (thVar.f2651pf != 7) {
                                    if (this.f2582ad != null) {
                                        this.f2582ad.qw(false, (th) null, 5);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (jSONObject.optInt("dystat", 1) == 0) {
                                this.f2584fe.rg(this.f2583de, jSONObject.optJSONObject("dyres"), thVar);
                                if (this.f2582ad != null) {
                                    eVar = this.f2582ad;
                                    z = true;
                                } else {
                                    return;
                                }
                            } else if (this.f2582ad != null) {
                                eVar = this.f2582ad;
                                z = true;
                            } else {
                                return;
                            }
                            eVar.qw(z, thVar, z ? 1 : 0);
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            e eVar2 = this.f2582ad;
            if (eVar2 != null) {
                eVar2.qw(false, (th) null, 5);
            }
        }
    }
}
