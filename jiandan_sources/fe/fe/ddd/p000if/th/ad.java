package fe.fe.ddd.p000if.th;

import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import fe.fe.ddd.p000if.de;

/* renamed from: fe.fe.ddd.if.th.ad  reason: invalid package */
public class ad implements Recordable {
    public final qw[] qw = new qw[4];

    public ad() {
        if (de.qw.length == 4) {
            int length = de.tt.length;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.qw[i2] = new qw();
        }
    }

    public ElasticTask ad() {
        for (int i2 = 0; i2 < 4; i2++) {
            if (!this.qw[i2].yj()) {
                return this.qw[i2].ad();
            }
        }
        return null;
    }

    public qw de(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = de.qw;
            if (i3 >= iArr.length) {
                qw[] qwVarArr = this.qw;
                return qwVarArr[qwVarArr.length - 1];
            } else if (iArr[i3] == i2) {
                return this.qw[i3];
            } else {
                i3++;
            }
        }
    }

    public void fe(Runnable runnable, String str, int i2) {
        de(i2).th(runnable, str, i2);
    }

    public double qw() {
        if (!de(0).yj()) {
            return 9999999.0d;
        }
        double d = 0.0d;
        for (int i2 = 0; i2 < 4; i2++) {
            d += ((double) this.qw[i2].qw()) * de.tt[i2];
        }
        return d / 1000.0d;
    }

    public void rg() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.qw[i2].uk();
        }
    }

    public void th() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.qw[i2].i();
        }
    }

    public void yj(ElasticTask elasticTask) {
        de(elasticTask.ad()).o(elasticTask);
    }
}
