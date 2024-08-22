package b.a.a.a.c.q;

import android.media.MediaPlayer;
import android.text.TextUtils;
import b.a.a.a.c.d.a;
import b.a.a.a.c.o.d;
import com.baidu.searchbox.net.MediaPlayerTracker;

/* compiled from: WNMediaPlayer */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static m f1410a;

    /* renamed from: b  reason: collision with root package name */
    private MediaPlayer f1411b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f1412c = false;

    private m() {
    }

    private void c() {
        if (this.f1411b == null) {
            this.f1411b = new MediaPlayer();
        }
    }

    private void d() {
        MediaPlayer mediaPlayer = this.f1411b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f1411b = null;
        }
    }

    public boolean b() {
        return this.f1412c;
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (f1410a == null) {
                f1410a = new m();
            }
            mVar = f1410a;
        }
        return mVar;
    }

    public void b(String str) {
        a.c("yang12", "WN player playEnd-->" + str);
        d();
        c();
        try {
            this.f1412c = true;
            if (com.baidu.platform.comapi.walknavi.m.h().c() != null) {
                MediaPlayerTracker.setDataSource(this.f1411b, str);
                this.f1411b.prepare();
                this.f1411b.start();
                this.f1411b.setOnCompletionListener(new l(this));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str) {
        a.c("yang12", "WN player playStart-->" + str);
        d();
        c();
        try {
            this.f1412c = true;
            if (com.baidu.platform.comapi.walknavi.m.h().c() != null) {
                MediaPlayerTracker.setDataSource(this.f1411b, str);
                this.f1411b.prepare();
                this.f1411b.start();
                this.f1411b.setOnCompletionListener(new k(this));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(String str) {
        a.b("WN player play-->" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d();
        c();
        try {
            d.a().a(true);
            if (com.baidu.platform.comapi.walknavi.m.h().c() == null) {
                return false;
            }
            MediaPlayerTracker.setDataSource(this.f1411b, str);
            this.f1411b.prepare();
            this.f1411b.start();
            this.f1411b.setOnCompletionListener(new j(this));
            return true;
        } catch (Exception e2) {
            d.a().a(false);
            return false;
        }
    }
}
