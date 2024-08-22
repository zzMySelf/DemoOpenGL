package com.dxmpay.wallet.download;

import android.text.TextUtils;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.utils.FileUtils;
import fe.i.ad.de.qw;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b {
    public Executor qw = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public interface a {
        void a();

        void a(String str);

        void b(String str);
    }

    public b(String str) {
    }

    public void ad(String str, String str2, String str3, a aVar) {
        File file = new File(str3);
        FileUtils.ensureParent(file);
        if (!FileUtils.existsFile(file) || !TextUtils.equals(Md5Utils.getMd5FromFileV2(str3), str2)) {
            if (FileUtils.existsFile(file)) {
                file.delete();
            }
            this.qw.execute(new qw(str, str2, str3, aVar));
            return;
        }
        qw(aVar, str3);
    }

    public final void qw(a aVar, String str) {
        if (aVar != null) {
            aVar.a(str);
        }
    }
}
