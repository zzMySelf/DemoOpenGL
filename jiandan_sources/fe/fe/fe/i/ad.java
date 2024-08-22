package fe.fe.fe.i;

public class ad {
    public long qw;

    public ad() {
        this(0);
    }

    public ad(long j) {
        this.qw = j;
    }

    public boolean qw(long j, long j2) {
        long j3 = this.qw;
        long j4 = (j & j2) | ((~j2) & j3);
        this.qw = j4;
        return (j4 ^ j3) != 0;
    }
}
