package fe.fe.o.fe.qw.de;

import android.os.Message;
import com.baidu.sapi2.utils.SapiUtils;
import org.apache.http.Header;

public class uk {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f2560ad = true;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2561de = false;
    public boolean qw = true;

    public void ad() {
    }

    public void de(int i2, String str) {
        th(str);
    }

    public void fe(int i2, Header[] headerArr, String str) {
        de(i2, str);
    }

    public void ggg() {
        m168switch(qw(3, (Object) null));
    }

    public void i(Throwable th2, String str, int i2) {
        yj(th2, i2);
    }

    /* renamed from: if  reason: not valid java name */
    public void m167if(int i2, Header[] headerArr, String str) {
        fe(i2, headerArr, str);
    }

    public void o(Throwable th2, byte[] bArr, int i2) {
        m168switch(qw(1, new Object[]{th2, bArr, Integer.valueOf(i2)}));
    }

    public void pf() {
    }

    public void ppp() {
        m168switch(qw(2, (Object) null));
    }

    public Message qw(int i2, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.obj = obj;
        return obtain;
    }

    public void rg(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            Object[] objArr = (Object[]) message.obj;
            m167if(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (String) objArr[2]);
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
        } else if (i2 == 2) {
            ad();
        } else if (i2 == 3) {
            pf();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m168switch(Message message) {
        rg(message);
    }

    public void th(String str) {
    }

    public void uk(Throwable th2, String str) {
        m168switch(qw(1, new Object[]{th2, str}));
    }

    public void vvv() {
        m168switch(qw(5, (Object) null));
    }

    public void when(Throwable th2, String str, int i2) {
        i(th2, str, i2);
    }

    public void yj(Throwable th2, int i2) {
    }
}
