package fe.fe.ddd.when.qw.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.fe.ddd.when.fe.fe;
import fe.fe.ddd.when.fe.i.ad.ad;
import fe.fe.ddd.when.fe.i.qw;
import fe.fe.ddd.when.yj.de;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class th extends ad {
    @Nullable
    public Set<fe> qw(@NonNull Context context, @NonNull File file, @NonNull qw qwVar) {
        if (qwVar.qw.contains("UnsatisfiedLinkError")) {
            File file2 = new File(file, "sofileinfo");
            if (de.qw(file2)) {
                HashSet hashSet = new HashSet(1);
                de.i(context, file2);
                hashSet.add(new fe(file2));
                return hashSet;
            }
        }
        return null;
    }
}
