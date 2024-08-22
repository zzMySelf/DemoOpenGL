package fe.when.ad;

public class qw implements Comparable<qw> {

    /* renamed from: th  reason: collision with root package name */
    public static int f9884th;

    /* renamed from: ad  reason: collision with root package name */
    public int f9885ad = 0;

    public qw() {
        int i2 = f9884th + 1;
        f9884th = i2;
        this.f9885ad = i2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof qw) && this.f9885ad == ((qw) obj).f9885ad;
    }

    public int hashCode() {
        return this.f9885ad;
    }

    /* renamed from: qw */
    public int compareTo(qw qwVar) {
        int i2 = this.f9885ad;
        int i3 = qwVar.f9885ad;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public String toString() {
        return Integer.toString(this.f9885ad);
    }
}
