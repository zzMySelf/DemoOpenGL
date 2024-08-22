package shark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import shark.HprofRecord;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "record", "Lshark/HprofRecord;", "onHprofRecord"}, k = 3, mv = {1, 4, 1})
/* compiled from: HprofDeobfuscator.kt */
final class HprofDeobfuscator$readHprofRecords$1 implements OnHprofRecordListener {
    final /* synthetic */ Map $classNames;
    final /* synthetic */ Map $hprofStringCache;
    final /* synthetic */ Ref.LongRef $maxId;

    HprofDeobfuscator$readHprofRecords$1(Ref.LongRef longRef, Map map, Map map2) {
        this.$maxId = longRef;
        this.$hprofStringCache = map;
        this.$classNames = map2;
    }

    public final void onHprofRecord(long $noName_0, HprofRecord record) {
        long j2;
        Intrinsics.checkParameterIsNotNull(record, "record");
        if (record instanceof HprofRecord.StringRecord) {
            Ref.LongRef longRef = this.$maxId;
            longRef.element = RangesKt.coerceAtLeast(longRef.element, ((HprofRecord.StringRecord) record).getId());
            this.$hprofStringCache.put(Long.valueOf(((HprofRecord.StringRecord) record).getId()), ((HprofRecord.StringRecord) record).getString());
        } else if (record instanceof HprofRecord.LoadClassRecord) {
            Ref.LongRef longRef2 = this.$maxId;
            longRef2.element = RangesKt.coerceAtLeast(longRef2.element, ((HprofRecord.LoadClassRecord) record).getId());
            this.$classNames.put(Long.valueOf(((HprofRecord.LoadClassRecord) record).getId()), Long.valueOf(((HprofRecord.LoadClassRecord) record).getClassNameStringId()));
        } else if (record instanceof HprofRecord.StackFrameRecord) {
            Ref.LongRef longRef3 = this.$maxId;
            longRef3.element = RangesKt.coerceAtLeast(longRef3.element, ((HprofRecord.StackFrameRecord) record).getId());
        } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord) {
            Ref.LongRef longRef4 = this.$maxId;
            if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) {
                j2 = RangesKt.coerceAtLeast(longRef4.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getId());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) {
                j2 = RangesKt.coerceAtLeast(longRef4.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) record).getId());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) {
                j2 = RangesKt.coerceAtLeast(longRef4.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) record).getId());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) {
                j2 = RangesKt.coerceAtLeast(longRef4.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) record).getId());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            longRef4.element = j2;
        }
    }
}
