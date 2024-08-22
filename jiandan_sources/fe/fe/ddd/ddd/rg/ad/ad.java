package fe.fe.ddd.ddd.rg.ad;

import java.util.ArrayList;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public String f1334ad;

    /* renamed from: de  reason: collision with root package name */
    public String f1335de;

    /* renamed from: fe  reason: collision with root package name */
    public long f1336fe;

    /* renamed from: i  reason: collision with root package name */
    public String f1337i;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f1338rg;

    /* renamed from: th  reason: collision with root package name */
    public long f1339th;

    /* renamed from: uk  reason: collision with root package name */
    public ArrayList<String> f1340uk;

    /* renamed from: yj  reason: collision with root package name */
    public long f1341yj;

    public ad(String str, String str2, String str3, long j, long j2, long j3, long j4, ArrayList<String> arrayList, String str4) {
        this.qw = str;
        this.f1334ad = str2;
        this.f1335de = str3;
        this.f1336fe = j;
        this.f1338rg = j2;
        this.f1339th = j3;
        this.f1341yj = j4;
        this.f1340uk = arrayList;
        this.f1337i = str4;
    }

    public String ad() {
        return this.qw;
    }

    public long de() {
        return this.f1341yj;
    }

    public String fe() {
        return this.f1337i;
    }

    public long qw() {
        return this.f1339th;
    }

    public ArrayList<String> rg() {
        return this.f1340uk;
    }

    public long th() {
        return this.f1338rg;
    }

    public String toString() {
        return "FetchLogBean{mJobId='" + this.qw + ExtendedMessageFormat.QUOTE + ", mType='" + this.f1334ad + ExtendedMessageFormat.QUOTE + ", mVersion='" + this.f1335de + ExtendedMessageFormat.QUOTE + ", mExpiredTime=" + this.f1336fe + ", mStartTime=" + this.f1338rg + ", mEndTime=" + this.f1339th + ", maxSizeLimit=" + this.f1341yj + ", mSpace=" + this.f1340uk + ", network='" + this.f1337i + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    public String uk() {
        return this.f1335de;
    }

    public String yj() {
        return this.f1334ad;
    }
}
