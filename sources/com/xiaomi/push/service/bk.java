package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.searchbox.hissug.util.common.SceneConstantsKt;
import com.xiaomi.push.C0300r;
import com.xiaomi.push.bf;
import com.xiaomi.push.cy;
import com.xiaomi.push.db;
import com.xiaomi.push.dc;
import com.xiaomi.push.ev;
import com.xiaomi.push.ew;
import com.xiaomi.push.gd;
import com.xiaomi.push.gl;
import com.xiaomi.push.gn;
import com.xiaomi.push.ha;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.bw;
import com.yy.open.agent.OpenParams;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class bk extends bw.a implements dc.a {

    /* renamed from: a  reason: collision with root package name */
    private long f7618a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f1013a;

    public static void a(XMPushService xMPushService) {
        bk bkVar = new bk(xMPushService);
        bw.a().a((bw.a) bkVar);
        synchronized (dc.class) {
            dc.a((dc.a) bkVar);
            dc.a(xMPushService, (db) null, new a(), "0", "push", "2.2");
        }
    }

    bk(XMPushService xMPushService) {
        this.f1013a = xMPushService;
    }

    static class a implements dc.b {
        a() {
        }

        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(OpenParams.EXTRA_REQ_SDK_VER, String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", ic.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter(SceneConstantsKt.SCENE_MINIVIDEO, String.valueOf(C0300r.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = bf.a(C0300r.a(), url);
                gn.a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), (Exception) null);
                return a2;
            } catch (IOException e2) {
                gn.a(url.getHost() + ":" + port, -1, e2);
                throw e2;
            }
        }
    }

    static class b extends dc {
        protected b(Context context, db dbVar, dc.b bVar, String str) {
            super(context, dbVar, bVar, str);
        }

        /* access modifiers changed from: protected */
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (gl.a().a()) {
                    str2 = bw.a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                gn.a(0, gd.GSLB_ERR.a(), 1, (String) null, bf.c(f6829a) ? 1 : 0);
                throw e2;
            }
        }
    }

    public void a(ew.b bVar) {
        cy b2;
        if (bVar.b() && bVar.a() && System.currentTimeMillis() - this.f7618a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.a("fetch bucket :" + bVar.a());
            this.f7618a = System.currentTimeMillis();
            dc a2 = dc.a();
            a2.a();
            a2.b();
            ha a3 = this.f1013a.a();
            if (a3 != null && (b2 = a2.b(a3.a().c())) != null) {
                ArrayList a4 = b2.a();
                boolean z = true;
                Iterator it = a4.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((String) it.next()).equals(a3.a())) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z && !a4.isEmpty()) {
                    com.xiaomi.channel.commonutils.logger.b.a("bucket changed, force reconnect");
                    this.f1013a.a(0, (Exception) null);
                    this.f1013a.a(false);
                }
            }
        }
    }

    public void a(ev.a aVar) {
    }

    public dc a(Context context, db dbVar, dc.b bVar, String str) {
        return new b(context, dbVar, bVar, str);
    }
}
