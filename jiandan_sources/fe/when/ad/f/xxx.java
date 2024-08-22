package fe.when.ad.f;

public class xxx {

    /* renamed from: ad  reason: collision with root package name */
    public final int f9840ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f9841de;
    public final int qw;

    public xxx(int i2, int i3, String str) {
        this.qw = i2;
        this.f9840ad = i3;
        this.f9841de = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xxx.class != obj.getClass()) {
            return false;
        }
        xxx xxx = (xxx) obj;
        String str = this.f9841de;
        if (str == null) {
            if (xxx.f9841de != null) {
                return false;
            }
        } else if (!str.equals(xxx.f9841de)) {
            return false;
        }
        return this.qw == xxx.qw && this.f9840ad == xxx.f9840ad;
    }

    public int hashCode() {
        String str = this.f9841de;
        return (((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.qw) * 31) + this.f9840ad;
    }

    public String toString() {
        return xxx.class.getSimpleName() + " [id=" + this.qw + ", width=" + this.f9840ad + ", chars=" + this.f9841de + "]";
    }
}
