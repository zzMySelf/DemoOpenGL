package leakcanary.uploader;

import android.util.Log;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
/* compiled from: HprofUploader.kt */
final class HprofUploader$asyncUpload$1 implements Runnable {
    final /* synthetic */ AnalysisObject $analysisObject;
    final /* synthetic */ HprofUploader this$0;

    HprofUploader$asyncUpload$1(HprofUploader hprofUploader, AnalysisObject analysisObject) {
        this.this$0 = hprofUploader;
        this.$analysisObject = analysisObject;
    }

    public final void run() {
        Log.e("LeakCanary", "asyncUpload: start to upload hprof");
        this.this$0.syncUpload(this.$analysisObject);
    }
}
