package fe.fe.ddd.when.fe;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.wallet.paysdk.datamodel.Bank;

public class qw {
    public static String qw = (fe.fe.ddd.fe.de.qw.qw().replaceAll(Bank.HOT_BANK_LETTER, "") + Bank.HOT_BANK_LETTER + System.currentTimeMillis());

    /* renamed from: fe.fe.ddd.when.fe.qw$qw  reason: collision with other inner class name */
    public static final class C0090qw {

        /* renamed from: ad  reason: collision with root package name */
        public long f1678ad;
        public String qw;

        public C0090qw(@NonNull String str, long j) {
            this.qw = str;
            this.f1678ad = j;
        }

        public static String ad(@NonNull C0090qw qwVar) {
            if (qwVar == null || TextUtils.isEmpty(qwVar.qw) || qwVar.f1678ad < 0) {
                return null;
            }
            return qwVar.qw.replaceAll(Bank.HOT_BANK_LETTER, "") + Bank.HOT_BANK_LETTER + qwVar.f1678ad;
        }

        public static C0090qw qw(@NonNull String str) {
            String[] split;
            long j;
            if (str == null || TextUtils.isEmpty(str) || (split = str.split(Bank.HOT_BANK_LETTER)) == null || split.length != 2 || TextUtils.isEmpty(split[0])) {
                return null;
            }
            try {
                j = Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                j = 0;
            }
            if (j <= 0) {
                return null;
            }
            return new C0090qw(split[0], j);
        }
    }

    public static void ad() {
    }

    public static final String qw() {
        return qw;
    }
}
