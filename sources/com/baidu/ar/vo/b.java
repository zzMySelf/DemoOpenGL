package com.baidu.ar.vo;

import com.baidu.ar.slam.TrackModel;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.vo.d.a;
import com.baidu.ar.vo.d.g;
import com.baidu.ar.vo.e.c;
import com.baidu.ar.vo.e.d;
import com.baidu.ar.vo.e.e;
import com.baidu.ar.vo.e.f;
import java.util.ArrayList;

class b {

    /* renamed from: a  reason: collision with root package name */
    private d f10530a;

    /* renamed from: b  reason: collision with root package name */
    private c f10531b;

    /* renamed from: c  reason: collision with root package name */
    private com.baidu.ar.vo.d.d f10532c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f10533d = false;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f10534e = true;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f10535f = false;

    public b(d dVar, com.baidu.ar.vo.c.b bVar, a aVar, com.baidu.ar.vo.d.d dVar2) {
        this.f10530a = dVar;
        this.f10532c = dVar2;
        if (bVar != null) {
            this.f10534e = bVar.f();
        }
        this.f10531b = a(bVar, aVar);
    }

    private c a(com.baidu.ar.vo.c.b bVar, a aVar) {
        if (bVar == null) {
            d dVar = this.f10530a;
            com.baidu.ar.vo.d.d dVar2 = this.f10532c;
            return new com.baidu.ar.vo.e.a(dVar, dVar2.f10552a, dVar2.f10553b);
        } else if (bVar.d() == 1) {
            d dVar3 = this.f10530a;
            com.baidu.ar.vo.d.d dVar4 = this.f10532c;
            f fVar = new f(dVar3, bVar, dVar4.f10552a, dVar4.f10553b);
            fVar.a(aVar);
            return fVar;
        } else if (bVar.d() != 0) {
            return null;
        } else {
            d dVar5 = this.f10530a;
            com.baidu.ar.vo.d.d dVar6 = this.f10532c;
            return new e(dVar5, bVar, dVar6.f10552a, dVar6.f10553b);
        }
    }

    private float[] a(g gVar) {
        ArrayList<TrackModel> b2 = gVar.b();
        return (b2 == null || b2.isEmpty()) ? new float[0] : b2.get(0).getPose();
    }

    public void a() {
        d dVar = this.f10530a;
        if (dVar != null) {
            dVar.release();
            this.f10530a = null;
        }
        this.f10531b = null;
    }

    public void a(float f2, float f3, float f4) {
        com.baidu.ar.vo.e.b bVar = new com.baidu.ar.vo.e.b();
        bVar.f10568a = f2;
        bVar.f10569b = f3;
        bVar.f10571d = f4;
        bVar.f10570c = 2;
        a(bVar);
    }

    public void a(com.baidu.ar.vo.d.f fVar, float[] fArr) {
        float[] a2;
        if (this.f10534e && !this.f10535f) {
            g e2 = fVar.e();
            if (!this.f10533d) {
                c cVar = this.f10531b;
                if (cVar != null) {
                    this.f10533d = cVar.a(fArr);
                    if (this.f10533d) {
                        this.f10530a.a();
                        StatisticApi.onEvent(StatisticConstants.SLAM_TRACK_ON);
                    }
                }
            } else if (e2 != null && (a2 = a(e2)) != null && a2.length > 0) {
                this.f10530a.a(a2);
            }
        }
    }

    public void a(com.baidu.ar.vo.e.b bVar) {
        this.f10530a.a(bVar);
    }

    public void a(boolean z) {
        this.f10535f = z;
    }

    public void b() {
        this.f10534e = true;
    }
}
