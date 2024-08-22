package com.baidu.searchbox.track;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.fe.ddd.mmm.qw.uk;
import fe.fe.ddd.mmm.qw.yj;
import java.util.LinkedList;

public class Track {

    /* renamed from: ad  reason: collision with root package name */
    public LinkedList<OnTrackUIListener> f1077ad;

    /* renamed from: de  reason: collision with root package name */
    public Object f1078de;

    /* renamed from: fe  reason: collision with root package name */
    public Object f1079fe;
    public fe.fe.ddd.mmm.qw.ad<uk> qw;

    public interface OnTrackUIListener {
        void qw(uk ukVar);
    }

    public static final class ad {
        public static final Track qw = new Track();
    }

    public static Track fe() {
        return ad.qw;
    }

    public void ad(@NonNull OnTrackUIListener onTrackUIListener) {
        synchronized (this.f1079fe) {
            if (!this.f1077ad.contains(onTrackUIListener)) {
                this.f1077ad.add(onTrackUIListener);
            }
        }
    }

    public LinkedList<uk> de() {
        LinkedList<uk> linkedList;
        synchronized (this.f1078de) {
            linkedList = new LinkedList<>(this.qw.ad());
        }
        return linkedList;
    }

    public void qw(@NonNull uk ukVar) {
        if (ukVar != null) {
            synchronized (this.f1078de) {
                this.qw.de(ukVar);
            }
            return;
        }
        throw new NullPointerException("trackUI should not be null");
    }

    @Nullable
    public uk rg() {
        uk fe2;
        synchronized (this.f1078de) {
            fe2 = this.qw.fe();
        }
        return fe2;
    }

    public LinkedList<OnTrackUIListener> th() {
        return this.f1077ad;
    }

    public void uk(Context context) {
        if (!yj.rg().th()) {
            yj.rg().yj(context);
        }
    }

    public boolean yj() {
        return fe.fe.ddd.rg.qw.ad();
    }

    public Track() {
        this.f1078de = new Object();
        this.f1079fe = new Object();
        this.qw = fe.fe.ddd.mmm.qw.ad.qw(20);
        this.f1077ad = new LinkedList<>();
    }
}
