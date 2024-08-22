package fe.when.ad.f.r2;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public String f9748ad;

    /* renamed from: de  reason: collision with root package name */
    public int f9749de;
    public int[] qw;

    public qw(String str, int[] iArr) {
        this.f9748ad = str;
        this.qw = iArr;
        this.f9749de = iArr.length;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f9749de; i3++) {
            stringBuffer.append(this.f9748ad.substring(i2, this.qw[i3]));
            stringBuffer.append('-');
            i2 = this.qw[i3];
        }
        stringBuffer.append(this.f9748ad.substring(i2));
        return stringBuffer.toString();
    }
}
