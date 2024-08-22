package fe.fe.pf.yj.fe.de;

public class rg {
    public long qw;

    public rg() {
        this(0);
    }

    public void ad(long j) {
        this.qw = j;
    }

    public boolean de(long j, long j2) {
        long j3 = this.qw;
        long j4 = (j & j2) | ((~j2) & j3);
        this.qw = j4;
        return (j4 ^ j3) != 0;
    }

    public long fe() {
        return this.qw;
    }

    public long qw(long j) {
        return j & this.qw;
    }

    public rg(long j) {
        this.qw = j;
    }
}
