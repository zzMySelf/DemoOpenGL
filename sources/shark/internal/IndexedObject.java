package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.PrimitiveType;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lshark/internal/IndexedObject;", "", "()V", "position", "", "getPosition", "()J", "recordSize", "getRecordSize", "IndexedClass", "IndexedInstance", "IndexedObjectArray", "IndexedPrimitiveArray", "Lshark/internal/IndexedObject$IndexedClass;", "Lshark/internal/IndexedObject$IndexedInstance;", "Lshark/internal/IndexedObject$IndexedObjectArray;", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "shark-graph"}, k = 1, mv = {1, 4, 1})
/* compiled from: IndexedObject.kt */
public abstract class IndexedObject {
    public abstract long getPosition();

    public abstract long getRecordSize();

    private IndexedObject() {
    }

    public /* synthetic */ IndexedObject(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lshark/internal/IndexedObject$IndexedClass;", "Lshark/internal/IndexedObject;", "position", "", "superclassId", "instanceSize", "", "recordSize", "fieldsIndex", "(JJIJI)V", "getFieldsIndex", "()I", "getInstanceSize", "getPosition", "()J", "getRecordSize", "getSuperclassId", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* compiled from: IndexedObject.kt */
    public static final class IndexedClass extends IndexedObject {
        private final int fieldsIndex;
        private final int instanceSize;
        private final long position;
        private final long recordSize;
        private final long superclassId;

        public IndexedClass(long position2, long superclassId2, int instanceSize2, long recordSize2, int fieldsIndex2) {
            super((DefaultConstructorMarker) null);
            this.position = position2;
            this.superclassId = superclassId2;
            this.instanceSize = instanceSize2;
            this.recordSize = recordSize2;
            this.fieldsIndex = fieldsIndex2;
        }

        public long getPosition() {
            return this.position;
        }

        public final long getSuperclassId() {
            return this.superclassId;
        }

        public final int getInstanceSize() {
            return this.instanceSize;
        }

        public long getRecordSize() {
            return this.recordSize;
        }

        public final int getFieldsIndex() {
            return this.fieldsIndex;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lshark/internal/IndexedObject$IndexedInstance;", "Lshark/internal/IndexedObject;", "position", "", "classId", "recordSize", "(JJJ)V", "getClassId", "()J", "getPosition", "getRecordSize", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* compiled from: IndexedObject.kt */
    public static final class IndexedInstance extends IndexedObject {
        private final long classId;
        private final long position;
        private final long recordSize;

        public IndexedInstance(long position2, long classId2, long recordSize2) {
            super((DefaultConstructorMarker) null);
            this.position = position2;
            this.classId = classId2;
            this.recordSize = recordSize2;
        }

        public long getPosition() {
            return this.position;
        }

        public final long getClassId() {
            return this.classId;
        }

        public long getRecordSize() {
            return this.recordSize;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lshark/internal/IndexedObject$IndexedObjectArray;", "Lshark/internal/IndexedObject;", "position", "", "arrayClassId", "recordSize", "(JJJ)V", "getArrayClassId", "()J", "getPosition", "getRecordSize", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* compiled from: IndexedObject.kt */
    public static final class IndexedObjectArray extends IndexedObject {
        private final long arrayClassId;
        private final long position;
        private final long recordSize;

        public IndexedObjectArray(long position2, long arrayClassId2, long recordSize2) {
            super((DefaultConstructorMarker) null);
            this.position = position2;
            this.arrayClassId = arrayClassId2;
            this.recordSize = recordSize2;
        }

        public long getPosition() {
            return this.position;
        }

        public final long getArrayClassId() {
            return this.arrayClassId;
        }

        public long getRecordSize() {
            return this.recordSize;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u000f"}, d2 = {"Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "Lshark/internal/IndexedObject;", "position", "", "primitiveType", "Lshark/PrimitiveType;", "recordSize", "(JLshark/PrimitiveType;J)V", "getPosition", "()J", "getPrimitiveType", "()Lshark/PrimitiveType;", "primitiveTypeOrdinal", "", "getRecordSize", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* compiled from: IndexedObject.kt */
    public static final class IndexedPrimitiveArray extends IndexedObject {
        private final long position;
        private final byte primitiveTypeOrdinal;
        private final long recordSize;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IndexedPrimitiveArray(long position2, PrimitiveType primitiveType, long recordSize2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(primitiveType, "primitiveType");
            this.position = position2;
            this.recordSize = recordSize2;
            this.primitiveTypeOrdinal = (byte) primitiveType.ordinal();
        }

        public long getPosition() {
            return this.position;
        }

        public long getRecordSize() {
            return this.recordSize;
        }

        public final PrimitiveType getPrimitiveType() {
            return PrimitiveType.values()[this.primitiveTypeOrdinal];
        }
    }
}
