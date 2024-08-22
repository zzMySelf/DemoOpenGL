package com.baidu.searchbox.video.feedflow.utils;

import android.graphics.Bitmap;
import com.baidu.android.util.io.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "deleteBitmapFile", "", "filePath", "saveBitmapToLocal", "", "fileName", "bitmap", "Landroid/graphics/Bitmap;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BitmapUtils.kt */
public final class BitmapUtilsKt {
    private static final String TAG = "flow_bitmap_utils";

    public static final boolean saveBitmapToLocal(String fileName, String filePath, Bitmap bitmap) {
        if (bitmap != null) {
            CharSequence charSequence = fileName;
            if (!(charSequence == null || charSequence.length() == 0)) {
                File file = new File(filePath, fileName);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileOutputStream out = null;
                try {
                    out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                    out.flush();
                    out.close();
                    try {
                        out.close();
                    } catch (IOException e2) {
                    }
                    return true;
                } catch (FileNotFoundException e3) {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (IOException e5) {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (Throwable th2) {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e7) {
                        }
                    }
                    throw th2;
                }
            }
        }
        return false;
        return false;
    }

    public static final void deleteBitmapFile(String filePath) {
        try {
            FileUtils.deleteFile(filePath);
        } catch (Exception e2) {
        }
    }
}
