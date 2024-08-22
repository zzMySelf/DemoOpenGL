package fe.when.ad;

import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.f.a;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class rg implements DocListener {

    /* renamed from: ad  reason: collision with root package name */
    public a f9886ad;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9887th = false;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f9888uk = true;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f9889yj = false;

    public rg() {
    }

    public static final byte[] rg(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) str.charAt(i2);
        }
        return bArr;
    }

    public boolean ad(Element element) throws DocumentException {
        return false;
    }

    public void close() {
        this.f9887th = false;
        try {
            this.f9886ad.flush();
            if (this.f9888uk) {
                this.f9886ad.close();
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean de(aaa aaa) {
        return true;
    }

    public boolean fe(float f, float f2, float f3, float f4) {
        return false;
    }

    public void open() {
        this.f9887th = true;
    }

    public boolean qw() {
        return this.f9887th;
    }

    public boolean th() {
        return this.f9889yj;
    }

    public rg(th thVar, OutputStream outputStream) {
        this.f9886ad = new a(new BufferedOutputStream(outputStream));
    }
}
