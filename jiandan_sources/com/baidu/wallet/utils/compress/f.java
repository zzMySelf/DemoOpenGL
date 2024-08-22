package com.baidu.wallet.utils.compress;

import android.os.AsyncTask;
import com.baidu.wallet.utils.compress.VideoCompressUtils;

public class f extends AsyncTask<Object, Float, Boolean> {
    public VideoCompressUtils.ProgressListener a;

    public f(VideoCompressUtils.ProgressListener progressListener) {
        this.a = progressListener;
    }

    public void onPreExecute() {
        super.onPreExecute();
        VideoCompressUtils.ProgressListener progressListener = this.a;
        if (progressListener != null) {
            progressListener.onStart();
        }
    }

    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        return Boolean.valueOf(new e().a(objArr[0], objArr[1], objArr[2], new b() {
            public void a(float f) {
                f.this.publishProgress(new Float[]{Float.valueOf(f)});
            }
        }));
    }

    /* renamed from: a */
    public void onProgressUpdate(Float... fArr) {
        super.onProgressUpdate(fArr);
        VideoCompressUtils.ProgressListener progressListener = this.a;
        if (progressListener != null) {
            progressListener.onProgress(fArr[0].floatValue());
        }
    }

    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (this.a == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.a.onFinish(true);
        } else {
            this.a.onFinish(false);
        }
    }
}
