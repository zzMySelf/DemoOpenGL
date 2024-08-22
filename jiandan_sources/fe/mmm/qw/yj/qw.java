package fe.mmm.qw.yj;

public abstract class qw {
    public fe qw;

    public void ad() {
    }

    public void de() {
        fe feVar = this.qw;
        if (feVar != null) {
            feVar.qw();
            this.qw = null;
        }
    }

    public boolean fe(String str, boolean z) {
        fe feVar = this.qw;
        if (feVar == null) {
            return z;
        }
        return feVar.rg(str, z);
    }

    public boolean i(String str) {
        fe feVar = this.qw;
        if (feVar == null) {
            return false;
        }
        return feVar.th(str);
    }

    /* renamed from: if  reason: not valid java name */
    public void m1012if(String str, long j) {
        fe feVar = this.qw;
        if (feVar != null) {
            feVar.uk(str, Long.valueOf(j));
        }
    }

    public void o(String str, boolean z) {
        fe feVar = this.qw;
        if (feVar != null) {
            feVar.uk(str, Boolean.valueOf(z));
        }
    }

    public void pf(String str, int i2) {
        fe feVar = this.qw;
        if (feVar != null) {
            feVar.uk(str, Integer.valueOf(i2));
        }
    }

    public void qw() {
    }

    public int rg(String str, int i2) {
        fe feVar = this.qw;
        if (feVar == null) {
            return i2;
        }
        return feVar.ad(str, i2);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1013switch(String str, String str2) {
        fe feVar = this.qw;
        if (feVar != null) {
            feVar.uk(str, str2);
        }
    }

    public long th(String str, long j) {
        fe feVar = this.qw;
        if (feVar == null) {
            return j;
        }
        return feVar.de(str, j);
    }

    public String uk(String str, String str2) {
        fe feVar = this.qw;
        if (feVar == null) {
            return str2;
        }
        return feVar.fe(str, str2);
    }

    public void when(String str) {
        fe feVar = this.qw;
        if (feVar != null) {
            feVar.i(str);
        }
    }

    public String yj(String str) {
        return uk(str, "");
    }
}
