package fe.i.ad.de;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.download.b;
import com.dxmpay.wallet.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public String f4445ad;

    /* renamed from: th  reason: collision with root package name */
    public String f4446th;

    /* renamed from: uk  reason: collision with root package name */
    public b.a f4447uk;

    /* renamed from: yj  reason: collision with root package name */
    public String f4448yj;

    public qw(String str, String str2, String str3, b.a aVar) {
        this.f4445ad = str;
        this.f4446th = str2;
        this.f4448yj = str3;
        this.f4447uk = aVar;
    }

    public void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4445ad).openConnection();
            httpURLConnection.setConnectTimeout(50000);
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                File file = new File(this.f4448yj);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[524288];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    if (this.f4447uk != null) {
                        this.f4447uk.a();
                    }
                }
                fileOutputStream.flush();
                inputStream.close();
                if (!FileUtils.existsFile(file) || !TextUtils.equals(Md5Utils.getMd5FromFileV2(this.f4448yj), this.f4446th)) {
                    if (this.f4447uk != null) {
                        this.f4447uk.b("md5 not match");
                    }
                } else if (this.f4447uk != null) {
                    this.f4447uk.a(this.f4448yj);
                }
            } else if (this.f4447uk != null) {
                b.a aVar = this.f4447uk;
                aVar.b("Server Response Code is " + httpURLConnection.getResponseCode());
            }
        } catch (IOException e) {
            b.a aVar2 = this.f4447uk;
            if (aVar2 != null) {
                aVar2.b(e.getMessage());
            }
        }
    }
}
