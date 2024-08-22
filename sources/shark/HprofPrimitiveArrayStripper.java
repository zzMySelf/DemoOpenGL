package shark;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.BufferedSink;
import okio.Okio;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lshark/HprofPrimitiveArrayStripper;", "", "()V", "stripPrimitiveArrays", "Ljava/io/File;", "inputHprofFile", "outputHprofFile", "", "hprofSourceProvider", "Lshark/StreamingSourceProvider;", "hprofSink", "Lokio/BufferedSink;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
/* compiled from: HprofPrimitiveArrayStripper.kt */
public final class HprofPrimitiveArrayStripper {
    public static /* synthetic */ File stripPrimitiveArrays$default(HprofPrimitiveArrayStripper hprofPrimitiveArrayStripper, File file, File file2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            String parent = file.getParent();
            String name = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "inputHprofFile.name");
            String it = StringsKt.replace$default(name, ".hprof", "-stripped.hprof", false, 4, (Object) null);
            if (!(!Intrinsics.areEqual((Object) it, (Object) file.getName()))) {
                it = file.getName() + "-stripped";
            }
            file2 = new File(parent, it);
        }
        return hprofPrimitiveArrayStripper.stripPrimitiveArrays(file, file2);
    }

    public final File stripPrimitiveArrays(File inputHprofFile, File outputHprofFile) {
        Intrinsics.checkParameterIsNotNull(inputHprofFile, "inputHprofFile");
        Intrinsics.checkParameterIsNotNull(outputHprofFile, "outputHprofFile");
        BufferedSink buffer = Okio.buffer(Okio.sink((OutputStream) new FileOutputStream(outputHprofFile)));
        Intrinsics.checkExpressionValueIsNotNull(buffer, "Okio.buffer(Okio.sink(ou…profFile.outputStream()))");
        stripPrimitiveArrays((StreamingSourceProvider) new FileSourceProvider(inputHprofFile), buffer);
        return outputHprofFile;
    }

    /* Debug info: failed to restart local var, previous not found, register: 12 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006c, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006f, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0072, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void stripPrimitiveArrays(shark.StreamingSourceProvider r13, okio.BufferedSink r14) {
        /*
            r12 = this;
            java.lang.String r0 = "hprofSourceProvider"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
            java.lang.String r0 = "hprofSink"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            okio.BufferedSource r0 = r13.openStreamingSource()
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r2 = r0
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ all -> 0x0070 }
            r3 = 0
            shark.HprofHeader$Companion r4 = shark.HprofHeader.Companion     // Catch:{ all -> 0x0070 }
            shark.HprofHeader r4 = r4.parseHeaderOf((okio.BufferedSource) r2)     // Catch:{ all -> 0x0070 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            r0 = r4
            shark.StreamingRecordReaderAdapter$Companion r2 = shark.StreamingRecordReaderAdapter.Companion
            shark.StreamingHprofReader$Companion r3 = shark.StreamingHprofReader.Companion
            shark.StreamingHprofReader r3 = r3.readerFor((shark.StreamingSourceProvider) r13, (shark.HprofHeader) r0)
            shark.StreamingRecordReaderAdapter r2 = r2.asStreamingRecordReader(r3)
            shark.HprofWriter$Companion r3 = shark.HprofWriter.Companion
            shark.HprofHeader r11 = new shark.HprofHeader
            r5 = 0
            int r8 = r0.getIdentifierByteSize()
            shark.HprofVersion r7 = r0.getVersion()
            r9 = 1
            r10 = 0
            r4 = r11
            r4.<init>(r5, r7, r8, r9, r10)
            shark.HprofWriter r3 = r3.openWriterFor((okio.BufferedSink) r14, (shark.HprofHeader) r11)
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = r3
            shark.HprofWriter r4 = (shark.HprofWriter) r4     // Catch:{ all -> 0x0069 }
            r5 = 0
            java.lang.Class<shark.HprofRecord> r6 = shark.HprofRecord.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)     // Catch:{ all -> 0x0069 }
            java.util.Set r6 = kotlin.collections.SetsKt.setOf(r6)     // Catch:{ all -> 0x0069 }
            shark.HprofPrimitiveArrayStripper$stripPrimitiveArrays$2$1 r7 = new shark.HprofPrimitiveArrayStripper$stripPrimitiveArrays$2$1     // Catch:{ all -> 0x0069 }
            r7.<init>(r4)     // Catch:{ all -> 0x0069 }
            shark.OnHprofRecordListener r7 = (shark.OnHprofRecordListener) r7     // Catch:{ all -> 0x0069 }
            r2.readRecords(r6, r7)     // Catch:{ all -> 0x0069 }
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            return
        L_0x0069:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x006b }
        L_0x006b:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            throw r4
        L_0x0070:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: shark.HprofPrimitiveArrayStripper.stripPrimitiveArrays(shark.StreamingSourceProvider, okio.BufferedSink):void");
    }
}
