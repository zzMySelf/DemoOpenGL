package fe.fe.o.fe.qw.de;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.down.loopj.android.a.a.b;
import com.baidu.sapi2.utils.SapiUtils;
import fe.fe.o.de.yj;
import fe.fe.o.rg.ad.qw;
import fe.fe.o.rg.de.ad;
import fe.fe.o.rg.de.i;
import fe.fe.o.th.ggg;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.client.HttpResponseException;

public class o extends uk {

    /* renamed from: i  reason: collision with root package name */
    public static Pattern f2528i = Pattern.compile("\\s*(bytes)?\\s*(\\d+)\\s*\\-+\\s*\\d+\\s*/\\s*(\\d+)\\s*");

    /* renamed from: fe  reason: collision with root package name */
    public long f2529fe = 0;

    /* renamed from: rg  reason: collision with root package name */
    public String f2530rg;

    /* renamed from: th  reason: collision with root package name */
    public int f2531th = 0;

    /* renamed from: uk  reason: collision with root package name */
    public qw f2532uk = null;

    /* renamed from: yj  reason: collision with root package name */
    public List f2533yj = new CopyOnWriteArrayList();

    public void a(byte[] bArr, long j) {
    }

    public void aaa(int i2, Header[] headerArr, String str, long j) {
        m168switch(qw(0, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}));
    }

    public void b(int i2) {
        nn(i2);
    }

    public void c(int i2, byte[] bArr, long j) {
        mmm(i2, bArr, j);
    }

    public void d(long j, String str) {
        qqq(j, str);
    }

    public long ddd(b bVar, rg rgVar) {
        long j;
        long j2;
        int a = bVar.a();
        this.f2560ad = true;
        if (a == 200 || a == 206) {
            this.f2530rg = bVar.fe("ETag");
            String fe2 = bVar.fe("Content-Range");
            if (fe2 != null) {
                Matcher matcher = f2528i.matcher(fe2);
                if (matcher.matches()) {
                    j2 = Long.valueOf(matcher.group(2)).longValue();
                    this.f2529fe = Long.valueOf(matcher.group(3)).longValue();
                } else {
                    j2 = 0;
                }
                j = j2;
            } else {
                this.f2560ad = false;
                String a2 = bVar.a(false);
                this.f2532uk.z = "server not support resume broken transfer, sc=" + a + ", headers : \n" + a2.toString();
                String fe3 = bVar.fe("Content-Length");
                if (fe3 != null) {
                    this.f2529fe = Long.valueOf(fe3).longValue();
                }
                j = 0;
            }
            if (this.f2529fe > 0) {
                l();
            } else if (!this.f2561de) {
                String fe4 = bVar.fe("Transfer-Encoding");
                if (fe4 == null || (!"trunked".equalsIgnoreCase(fe4) && !"chunked".equalsIgnoreCase(fe4))) {
                    String a3 = bVar.a(false);
                    throw new IOException("Oops! content-length illegal : \n" + a3.toString());
                }
                this.f2529fe = Long.MAX_VALUE;
                this.f2561de = true;
                l();
                return 0;
            }
            return xxx(bVar, j, a, rgVar);
        }
        String a4 = bVar.a(false);
        if (a == 412 || a == 416) {
            this.f2560ad = false;
        }
        throw new HttpResponseException(a, a4);
    }

    public void e(ad adVar) {
        m168switch(qw(4, new Object[]{adVar}));
    }

    public void eee(yj yjVar) {
        List list;
        if (!ggg.th(this.f2533yj)) {
            for (yj qw : this.f2533yj) {
                if (qw.compareTo(yjVar) == 0) {
                    return;
                }
            }
            list = this.f2533yj;
        } else {
            list = new CopyOnWriteArrayList();
            this.f2533yj = list;
        }
        list.add(yjVar);
    }

    public void f(int i2) {
        this.f2531th = i2;
        if (i2 == 1) {
            System.currentTimeMillis();
        }
    }

    public void g(ad adVar) {
        tt(adVar);
    }

    public void h() {
        this.qw = true;
    }

    public void j() {
        this.qw = false;
    }

    public long k() {
        return this.f2529fe;
    }

    public void l() {
        Message obtain = Message.obtain();
        obtain.what = 6;
        Bundle bundle = new Bundle();
        bundle.putLong("filetotalbytes", this.f2529fe);
        bundle.putString("etag", this.f2530rg);
        obtain.setData(bundle);
        m168switch(obtain);
    }

    public int m() {
        return this.f2531th;
    }

    public void mmm(int i2, byte[] bArr, long j) {
        a(bArr, j);
    }

    public List n() {
        return this.f2533yj;
    }

    public void nn(int i2) {
    }

    public void p() {
        this.f2533yj = new CopyOnWriteArrayList();
    }

    public void qqq(long j, String str) {
    }

    public void rg(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            Object[] objArr = (Object[]) message.obj;
            c(((Integer) objArr[0]).intValue(), (byte[]) objArr[1], ((Long) objArr[2]).longValue());
        } else if (i2 == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2[0] != null && objArr2[1] != null) {
                when((Throwable) objArr2[0], objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
            } else if (objArr2[1] == null) {
                when((Throwable) objArr2[0], SapiUtils.KEY_QR_LOGIN_ERROR, ((Integer) objArr2[2]).intValue());
            } else if (objArr2[0] == null) {
                when((Throwable) null, objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
            } else {
                when((Throwable) null, SapiUtils.KEY_QR_LOGIN_ERROR, ((Integer) objArr2[2]).intValue());
            }
        } else if (i2 == 4) {
            g((ad) ((Object[]) message.obj)[0]);
        } else if (i2 == 5) {
            Object obj = message.obj;
            if (obj == null) {
                b(0);
            } else {
                b(((Integer) obj).intValue());
            }
        } else if (i2 != 6) {
            super.rg(message);
        } else {
            Bundle data = message.getData();
            d(data.getLong("filetotalbytes"), data.getString("etag"));
        }
    }

    public void rrr(qw qwVar) {
        this.f2532uk = qwVar;
    }

    public void tt(ad adVar) {
    }

    public long xxx(b bVar, long j, int i2, rg rgVar) {
        int read;
        InputStream f = bVar.f();
        bVar.g();
        fe.fe.o.ad.yj i3 = rgVar.i();
        if (i3 != null) {
            rgVar.de(j);
            i3.f2474uk = this.f2529fe;
        }
        if (f != null) {
            ad qw = i.ad((Context) null).qw().vvv().qw();
            qw.f2612ad = j;
            qw.qw = 0;
            this.qw = true;
            int length = qw.f2613de.length;
            byte[] bArr = new byte[length];
            while (this.qw && (read = f.read(bArr)) != -1) {
                try {
                    int i4 = length - qw.qw;
                    if (read <= i4) {
                        i4 = read;
                    }
                    if (qw.qw + i4 >= length) {
                        System.arraycopy(bArr, 0, qw.f2613de, qw.qw, i4);
                        qw.qw += i4;
                        e(qw);
                        j += (long) i4;
                        qw = i.ad((Context) null).qw().vvv().qw();
                        qw.f2612ad = j;
                        qw.qw = 0;
                    } else {
                        System.arraycopy(bArr, 0, qw.f2613de, qw.qw, i4);
                        qw.qw += i4;
                        j += (long) i4;
                    }
                    if (i4 < read) {
                        int i5 = read - i4;
                        System.arraycopy(bArr, i4, qw.f2613de, qw.qw, i5);
                        qw.qw += i5;
                        j += (long) i5;
                    }
                    if (i3 != null) {
                        i3.f69switch = j;
                    }
                } catch (IOException e) {
                    throw e;
                } catch (Throwable th2) {
                    if (i3 != null) {
                        i3.f68if = SystemClock.elapsedRealtime();
                    }
                    bVar.k();
                    throw th2;
                }
            }
            if (i3 != null) {
                i3.f68if = SystemClock.elapsedRealtime();
            }
            bVar.k();
            if (!this.qw || qw.qw <= 0) {
                i.ad((Context) null).qw().vvv().de(qw);
            } else {
                e(qw);
            }
        }
        if (this.qw) {
            if (i3 != null) {
                i3.f2475yj += i3.f69switch;
                i3.f69switch = 0;
            }
            aaa(i2, (Header[]) null, (String) null, j);
        }
        if (this.f2561de) {
            this.qw = false;
        }
        return j;
    }
}
