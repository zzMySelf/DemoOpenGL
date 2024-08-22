package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lshark/PrimitiveType;", "", "hprofType", "", "byteSize", "(Ljava/lang/String;III)V", "getByteSize", "()I", "getHprofType", "BOOLEAN", "CHAR", "FLOAT", "DOUBLE", "BYTE", "SHORT", "INT", "LONG", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
/* compiled from: PrimitiveType.kt */
public enum PrimitiveType {
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);
    
    public static final Companion Companion = null;
    public static final int REFERENCE_HPROF_TYPE = 2;
    /* access modifiers changed from: private */
    public static final Map<Integer, Integer> byteSizeByHprofType = null;
    /* access modifiers changed from: private */
    public static final Map<Integer, PrimitiveType> primitiveTypeByHprofType = null;
    private final int byteSize;
    private final int hprofType;

    private PrimitiveType(int hprofType2, int byteSize2) {
        this.hprofType = hprofType2;
        this.byteSize = byteSize2;
    }

    public final int getHprofType() {
        return this.hprofType;
    }

    public final int getByteSize() {
        return this.byteSize;
    }

    static {
        int i2;
        Companion = new Companion((DefaultConstructorMarker) null);
        PrimitiveType[] values = values();
        Collection destination$iv$iv = new ArrayList(values.length);
        for (PrimitiveType it : values) {
            destination$iv$iv.add(TuplesKt.to(Integer.valueOf(it.hprofType), Integer.valueOf(it.byteSize)));
        }
        byteSizeByHprofType = MapsKt.toMap((List) destination$iv$iv);
        PrimitiveType[] values2 = values();
        Collection destination$iv$iv2 = new ArrayList(values2.length);
        for (PrimitiveType it2 : values2) {
            destination$iv$iv2.add(TuplesKt.to(Integer.valueOf(it2.hprofType), it2));
        }
        primitiveTypeByHprofType = MapsKt.toMap((List) destination$iv$iv2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lshark/PrimitiveType$Companion;", "", "()V", "REFERENCE_HPROF_TYPE", "", "byteSizeByHprofType", "", "getByteSizeByHprofType", "()Ljava/util/Map;", "primitiveTypeByHprofType", "Lshark/PrimitiveType;", "getPrimitiveTypeByHprofType", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* compiled from: PrimitiveType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Map<Integer, Integer> getByteSizeByHprofType() {
            return PrimitiveType.byteSizeByHprofType;
        }

        public final Map<Integer, PrimitiveType> getPrimitiveTypeByHprofType() {
            return PrimitiveType.primitiveTypeByHprofType;
        }
    }
}
