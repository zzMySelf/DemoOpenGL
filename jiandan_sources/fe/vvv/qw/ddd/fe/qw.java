package fe.vvv.qw.ddd.fe;

import androidx.annotation.NonNull;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f8921ad = 1;

    /* renamed from: de  reason: collision with root package name */
    public String f8922de;

    /* renamed from: fe  reason: collision with root package name */
    public String f8923fe = "audio/mp4a-latm";
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f8924rg = 44100;

    /* renamed from: th  reason: collision with root package name */
    public final int f8925th = (44100 * 2);

    public int ad() {
        return 50;
    }

    public int de() {
        return 500;
    }

    public int fe() {
        return this.f8925th * this.f8921ad;
    }

    public int qw() {
        int i2 = this.f8921ad;
        if (i2 == 1) {
            return 16;
        }
        if (i2 == 2) {
            return 12;
        }
        throw new RuntimeException("Invalid number of channels: " + this.f8921ad);
    }

    @NonNull
    public qw rg() {
        qw qwVar = new qw();
        qwVar.qw = this.qw;
        qwVar.f8921ad = this.f8921ad;
        qwVar.f8922de = this.f8922de;
        qwVar.f8923fe = this.f8923fe;
        qwVar.f8924rg = this.f8924rg;
        return qwVar;
    }

    public int th() {
        return this.f8921ad * 1024;
    }
}
