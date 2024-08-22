package fe.fe.ddd.nn.fe;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import fe.fe.ddd.mmm.qw.uk;

public class qw {
    public static String qw(@NonNull uk ukVar) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(ukVar.qw())) {
            sb.append(ukVar.qw());
            sb.append(ukVar.ad());
        }
        if (!TextUtils.isEmpty(ukVar.fe())) {
            sb.append("->");
            sb.append(ukVar.fe());
            sb.append(ukVar.rg());
        }
        return sb.toString();
    }
}
