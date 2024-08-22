package fe.qw.qw.pf.ad;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public class i implements o, uk {

    /* renamed from: ad  reason: collision with root package name */
    public final Path f3297ad = new Path();

    /* renamed from: de  reason: collision with root package name */
    public final Path f3298de = new Path();

    /* renamed from: fe  reason: collision with root package name */
    public final String f3299fe;
    public final Path qw = new Path();

    /* renamed from: rg  reason: collision with root package name */
    public final List<o> f3300rg = new ArrayList();

    /* renamed from: th  reason: collision with root package name */
    public final MergePaths f3301th;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode[] r0 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.MERGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.ADD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.SUBTRACT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.INTERSECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x003e }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.pf.ad.i.qw.<clinit>():void");
        }
    }

    public i(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3299fe = mergePaths.de();
            this.f3301th = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    public void ad(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < this.f3300rg.size(); i2++) {
            this.f3300rg.get(i2).ad(list, list2);
        }
    }

    @TargetApi(19)
    public final void de(Path.Op op) {
        this.f3297ad.reset();
        this.qw.reset();
        for (int size = this.f3300rg.size() - 1; size >= 1; size--) {
            o oVar = this.f3300rg.get(size);
            if (oVar instanceof de) {
                de deVar = (de) oVar;
                List<o> i2 = deVar.i();
                for (int size2 = i2.size() - 1; size2 >= 0; size2--) {
                    Path path = i2.get(size2).getPath();
                    path.transform(deVar.o());
                    this.f3297ad.addPath(path);
                }
            } else {
                this.f3297ad.addPath(oVar.getPath());
            }
        }
        o oVar2 = this.f3300rg.get(0);
        if (oVar2 instanceof de) {
            de deVar2 = (de) oVar2;
            List<o> i3 = deVar2.i();
            for (int i4 = 0; i4 < i3.size(); i4++) {
                Path path2 = i3.get(i4).getPath();
                path2.transform(deVar2.o());
                this.qw.addPath(path2);
            }
        } else {
            this.qw.set(oVar2.getPath());
        }
        this.f3298de.op(this.qw, this.f3297ad, op);
    }

    public String getName() {
        return this.f3299fe;
    }

    public Path getPath() {
        this.f3298de.reset();
        if (this.f3301th.fe()) {
            return this.f3298de;
        }
        int i2 = qw.qw[this.f3301th.ad().ordinal()];
        if (i2 == 1) {
            qw();
        } else if (i2 == 2) {
            de(Path.Op.UNION);
        } else if (i2 == 3) {
            de(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            de(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            de(Path.Op.XOR);
        }
        return this.f3298de;
    }

    public final void qw() {
        for (int i2 = 0; i2 < this.f3300rg.size(); i2++) {
            this.f3298de.addPath(this.f3300rg.get(i2).getPath());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000d
            java.lang.Object r0 = r3.previous()
            if (r0 == r2) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r3.previous()
            com.airbnb.lottie.animation.content.Content r0 = (com.airbnb.lottie.animation.content.Content) r0
            boolean r1 = r0 instanceof fe.qw.qw.pf.ad.o
            if (r1 == 0) goto L_0x000d
            java.util.List<fe.qw.qw.pf.ad.o> r1 = r2.f3300rg
            fe.qw.qw.pf.ad.o r0 = (fe.qw.qw.pf.ad.o) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000d
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.pf.ad.i.th(java.util.ListIterator):void");
    }
}
