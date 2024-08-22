package fe.fe.o.rg.de;

import fe.fe.o.rg.ad.qw;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public long f2612ad;

    /* renamed from: de  reason: collision with root package name */
    public byte[] f2613de = new byte[qw.D];

    /* renamed from: fe  reason: collision with root package name */
    public String f2614fe;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f2615rg = true;

    public void finalize() {
        if (!this.f2615rg) {
            "### Maybe ByteArrayInfo has not been recycled! last used : " + this.f2614fe + ", pos=" + this.f2612ad + ", len=" + this.qw;
        }
        super.finalize();
    }
}
