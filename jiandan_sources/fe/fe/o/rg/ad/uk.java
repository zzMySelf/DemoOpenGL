package fe.fe.o.rg.ad;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.down.loopj.android.b.b;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import com.baidu.sapi2.SapiContext;
import com.baidubce.services.vod.VodClient;
import fe.fe.o.de.de;
import fe.fe.o.fe.qw.de.Cswitch;
import fe.fe.o.fe.qw.de.o;
import fe.fe.o.rg.de.i;
import fe.fe.o.rg.de.th;
import java.util.Timer;
import java.util.TreeSet;
import org.json.JSONObject;

public class uk implements b {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OnFetchDataRequestListener f2607ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ rg f2608de;
    public final /* synthetic */ long qw;

    public uk(rg rgVar, long j, OnFetchDataRequestListener onFetchDataRequestListener) {
        this.f2608de = rgVar;
        this.qw = j;
        this.f2607ad = onFetchDataRequestListener;
    }

    public void a() {
        if (this.f2608de.L != null) {
            this.f2608de.L.cancel();
            Timer unused = this.f2608de.L = null;
            OnFetchDataRequestListener onFetchDataRequestListener = this.f2607ad;
            if (onFetchDataRequestListener != null) {
                onFetchDataRequestListener.qw(false, (TreeSet) null);
            }
            long unused2 = this.f2608de.I = SystemClock.elapsedRealtime() - this.qw;
            rg rgVar = this.f2608de;
            o oVar = rgVar.f2601i;
            ((Cswitch) oVar).f80switch.f2449th = 1;
            ((Cswitch) oVar).f80switch.f2451yj = rgVar.I;
        }
    }

    public void a(String str) {
        if (this.f2608de.L != null) {
            this.f2608de.L.cancel();
            Timer unused = this.f2608de.L = null;
            long unused2 = this.f2608de.I = SystemClock.elapsedRealtime() - this.qw;
            rg rgVar = this.f2608de;
            ((Cswitch) rgVar.f2601i).f80switch.f2451yj = rgVar.I;
            ((Cswitch) this.f2608de.f2601i).f80switch.f2449th = 0;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("error_no") == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("fres");
                        if (jSONObject.optInt("fstat", 1) == 0 && optJSONObject != null && !optJSONObject.optString("download_inner").equals("")) {
                            this.f2608de.n = optJSONObject.optString(SapiContext.KEY_SEARCH_BOX_SID, "");
                            de deVar = new de();
                            String str2 = this.f2608de.n;
                            this.f2608de.r = Integer.parseInt(optJSONObject.optString(VodClient.PARA_MODE, "-1"));
                            int i2 = this.f2608de.r;
                            int parseInt = Integer.parseInt(optJSONObject.optString("tn", "-1"));
                            if (parseInt > 0) {
                                this.f2608de.f2600ad = parseInt;
                            }
                            this.f2608de.w = optJSONObject.optString("download_inner", "");
                            i.ad((Context) null).qw().uk(Long.valueOf(this.f2608de.ppp), deVar);
                            if ((this.f2608de.r & 1) != 1) {
                                ((Cswitch) this.f2608de.f2601i).f80switch.f2445i = 7;
                                if (this.f2607ad != null) {
                                    this.f2607ad.qw(true, (TreeSet) null);
                                    return;
                                }
                                return;
                            } else if (this.f2608de.H) {
                                TreeSet treeSet = new TreeSet();
                                th thVar = new th();
                                ((Cswitch) this.f2608de.f2601i).f80switch.f2450uk = jSONObject.optInt("dystat", 1);
                                if (jSONObject.optInt("dystat", 1) == 0) {
                                    this.f2608de.e(jSONObject.optJSONObject("dyres"), this.f2607ad, treeSet, thVar);
                                }
                                if (treeSet.isEmpty()) {
                                    ((Cswitch) this.f2608de.f2601i).f80switch.f2445i = 2;
                                    if (this.f2607ad != null) {
                                        this.f2607ad.qw(false, (TreeSet) null);
                                    }
                                } else {
                                    ((Cswitch) this.f2608de.f2601i).f80switch.f2445i = 1;
                                    if (this.f2607ad != null) {
                                        this.f2607ad.qw(true, treeSet);
                                    }
                                }
                                i.ad((Context) null).qw().c(thVar);
                                return;
                            } else if (this.f2607ad != null) {
                                this.f2607ad.qw(true, (TreeSet) null);
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ((Cswitch) this.f2608de.f2601i).f80switch.f2449th = 1;
                }
            }
            ((Cswitch) this.f2608de.f2601i).f80switch.f2445i = 8;
            OnFetchDataRequestListener onFetchDataRequestListener = this.f2607ad;
            if (onFetchDataRequestListener != null) {
                onFetchDataRequestListener.qw(false, (TreeSet) null);
            }
        }
    }
}
