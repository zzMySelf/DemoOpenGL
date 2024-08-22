package fe.fe.ddd.when.fe;

import androidx.annotation.NonNull;
import java.io.File;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f1676ad = true;

    /* renamed from: de  reason: collision with root package name */
    public boolean f1677de = false;
    public File qw;

    public fe(@NonNull File file, boolean z) {
        this.qw = file;
        this.f1676ad = z;
    }

    public static void qw() {
    }

    public String toString() {
        return this.qw.getAbsolutePath() + "," + this.f1676ad + "," + this.f1677de;
    }

    public fe(@NonNull File file, boolean z, boolean z2) {
        this.qw = file;
        this.f1676ad = z;
        this.f1677de = z2;
    }

    public fe(@NonNull File file) {
        this.qw = file;
    }
}
