package com.baidu.ar.steploading;

import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.ar.m.a;
import com.baidu.ar.p.v;
import java.io.File;

class c extends a<String, Void> {

    /* renamed from: i  reason: collision with root package name */
    private ARCaseBundleInfo f10434i;

    /* renamed from: j  reason: collision with root package name */
    private String f10435j;
    private a k;
    private IProgressCallback l;

    public c(ARCaseBundleInfo aRCaseBundleInfo, String str, a aVar, IProgressCallback iProgressCallback) {
        this.f10434i = aRCaseBundleInfo;
        this.f10435j = str;
        this.k = aVar;
        this.l = iProgressCallback;
    }

    private String a(f fVar) {
        StringBuilder append;
        String str;
        String parent = new File(this.f10434i.caseDir).getParent();
        if ("gzip".equalsIgnoreCase(fVar.f10455c)) {
            str = String.format("/temp/%s.zip", new Object[]{fVar.f10454b});
            append = new StringBuilder().append(parent);
        } else if (!"identity".equalsIgnoreCase(fVar.f10455c)) {
            return null;
        } else {
            append = new StringBuilder().append(parent).append(File.separator);
            str = fVar.f10453a;
        }
        return append.append(str).toString();
    }

    private boolean a(String str, f fVar, int i2) {
        File file = new File(str);
        if (!file.exists() || file.length() != ((long) i2)) {
            return false;
        }
        if ("gzip".equalsIgnoreCase(fVar.f10455c)) {
            return v.a(new File(str), new File(this.f10434i.caseDir).getParentFile());
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(String str, ICallbackWith<Void> iCallbackWith, IError iError) {
        if (TextUtils.isEmpty(str)) {
            iError.onError(2, "res url is not exists", (Exception) null);
        } else if ("local".equals(str)) {
            iCallbackWith.run(null);
        } else {
            f a2 = this.k.a(this.f10435j);
            if (a2 == null) {
                iError.onError(2, "res is not exists", (Exception) null);
                return;
            }
            String a3 = a(a2);
            if (a3 == null) {
                iError.onError(2, "未知的资源encoding", (Exception) null);
                return;
            }
            Downloader downloader = new Downloader(str);
            try {
                int fileSize = downloader.getFileSize();
                if (!a(a3, a2, fileSize)) {
                    try {
                        downloader.download(a3, this.l);
                        if (!a(a3, a2, fileSize)) {
                            iError.onError(2, "download fail", (Exception) null);
                            return;
                        }
                    } catch (Exception e2) {
                        iError.onError(2, e2.getMessage(), e2);
                        return;
                    }
                }
                iCallbackWith.run(null);
            } catch (HttpException e3) {
                iError.onError(2, e3.getMessage(), e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
    }
}
