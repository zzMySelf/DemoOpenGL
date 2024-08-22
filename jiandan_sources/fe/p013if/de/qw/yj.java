package fe.p013if.de.qw;

import fe.p013if.de.qw.uk.qw;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* renamed from: fe.if.de.qw.yj  reason: invalid package */
public class yj extends qw {

    /* renamed from: th  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f4624th = new LinkedHashMap<>();

    /* renamed from: fe  reason: collision with root package name */
    public int f4625fe;

    /* renamed from: rg  reason: collision with root package name */
    public Thread f4626rg;

    public yj(Thread thread, long j) {
        this(thread, 100, j);
    }

    public void ad() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f4626rg.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\r\n");
        }
        synchronized (f4624th) {
            if (f4624th.size() == this.f4625fe && this.f4625fe > 0) {
                f4624th.remove(f4624th.keySet().iterator().next());
            }
            f4624th.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> rg(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f4624th) {
            for (Long next : f4624th.keySet()) {
                if (j < next.longValue() && next.longValue() < j2) {
                    arrayList.add(qw.eee.format(next) + "\r\n" + "\r\n" + f4624th.get(next));
                }
            }
        }
        return arrayList;
    }

    public yj(Thread thread, int i2, long j) {
        super(j);
        this.f4625fe = 100;
        this.f4626rg = thread;
        this.f4625fe = i2;
    }
}
