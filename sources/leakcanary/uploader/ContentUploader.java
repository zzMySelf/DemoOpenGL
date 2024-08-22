package leakcanary.uploader;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.uploader.tools.FileUtils;
import leakcanary.uploader.tools.HttpManager;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lleakcanary/uploader/ContentUploader;", "Lleakcanary/uploader/BaseUploader;", "()V", "asyncUpload", "", "analysisObject", "Lleakcanary/uploader/AnalysisObject;", "syncUpload", "", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: ContentUploader.kt */
public final class ContentUploader implements BaseUploader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "LeakCanaryContentUploader";
    private static final String uploadAPI = "/report?needcallback=1";
    private static final String uploadContentAPI = "http://creator.soarx.cc/report?needcallback=1";

    public void asyncUpload(AnalysisObject analysisObject) {
        new ContentUploader$asyncUpload$1(this, analysisObject).run();
    }

    public boolean syncUpload(AnalysisObject analysisObject) {
        if (analysisObject == null || analysisObject.getJsonFileList().size() <= 0) {
            return false;
        }
        Log.e("LeakCanary", "syncUpload: start to upload content");
        boolean[] results = new boolean[analysisObject.getJsonFileList().size()];
        int size = analysisObject.getJsonFileList().size();
        for (int i2 = 0; i2 < size; i2++) {
            results[i2] = false;
            File contentFile = analysisObject.getJsonFileList().get(i2);
            File flagFile = new File(contentFile.getParent() + "/" + contentFile.getName() + ".flag");
            if (flagFile.exists()) {
                flagFile.delete();
            }
            try {
                flagFile.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Log.e(TAG, "syncUpload: flag file path: " + flagFile.getAbsolutePath());
            String jsonString = FileUtils.readContentFromFile(contentFile);
            if (!TextUtils.isEmpty(jsonString)) {
                String response = HttpManager.doPostJsonToIcafe(uploadContentAPI, jsonString);
                if (!TextUtils.isEmpty(response)) {
                    results[i2] = true;
                    if (Intrinsics.areEqual(new JSONObject(response).get("code"), (Object) 0)) {
                        analysisObject.setNeedUploadHprof(true);
                    }
                } else {
                    results[i2] = false;
                }
            }
            Log.e(TAG, "syncUpload: index " + i2 + " upload success? " + results[i2]);
            if (results[i2]) {
                if (flagFile.exists()) {
                    Log.e(TAG, "syncUpload: del flagfile " + flagFile.getAbsolutePath());
                    flagFile.delete();
                }
                contentFile.delete();
            }
        }
        for (boolean result : results) {
            if (!result) {
                return false;
            }
        }
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lleakcanary/uploader/ContentUploader$Companion;", "", "()V", "TAG", "", "uploadAPI", "uploadContentAPI", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: ContentUploader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
