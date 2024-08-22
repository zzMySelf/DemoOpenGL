package com.tera.scan.partition;

import fe.mmm.qw.mmm.qw;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MediaStoreRFile$file$2 extends Lambda implements Function0<File> {
    public final /* synthetic */ qw this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaStoreRFile$file$2(qw qwVar) {
        super(0);
        this.this$0 = qwVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File invoke() {
        /*
            r9 = this;
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            fe.mmm.qw.mmm.qw r1 = r9.this$0
            r7 = 0
            android.content.Context r2 = r1.f8067ad     // Catch:{ all -> 0x002a }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x002a }
            java.lang.String r1 = r1.qw     // Catch:{ all -> 0x002a }
            android.net.Uri r4 = android.net.Uri.parse(r1)     // Catch:{ all -> 0x002a }
            r5 = 0
            r6 = 0
            r8 = 0
            r1 = r2
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x002a }
            com.mars.kotlin.extension.fp.Either$Right r1 = com.mars.kotlin.extension.ExpectKt.success(r1)     // Catch:{ all -> 0x002a }
            goto L_0x003b
        L_0x002a:
            r1 = move-exception
            r2 = 1
            com.mars.kotlin.extension.LoggerKt.e$default(r1, r7, r2, r7)
            com.mars.kotlin.extension.Logger r2 = com.mars.kotlin.extension.Logger.INSTANCE
            boolean r2 = r2.getEnable()
            if (r2 != 0) goto L_0x0069
            com.mars.kotlin.extension.fp.Either$Left r1 = com.mars.kotlin.extension.ExpectKt.failure(r1)
        L_0x003b:
            java.lang.Object r1 = com.mars.kotlin.extension.ExpectKt.successOrNull(r1)
            android.database.Cursor r1 = (android.database.Cursor) r1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0063
            boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x0055
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x005c }
            java.lang.String r0 = fe.mmm.qw.mmm.ad.qw(r1, r0, r2)     // Catch:{ all -> 0x005c }
            r3.<init>(r0)     // Catch:{ all -> 0x005c }
            goto L_0x0056
        L_0x0055:
            r3 = r7
        L_0x0056:
            kotlin.io.CloseableKt.closeFinally(r1, r7)
            if (r3 != 0) goto L_0x0068
            goto L_0x0063
        L_0x005c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005e }
        L_0x005e:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            throw r2
        L_0x0063:
            java.io.File r3 = new java.io.File
            r3.<init>(r2)
        L_0x0068:
            return r3
        L_0x0069:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.partition.MediaStoreRFile$file$2.invoke():java.io.File");
    }
}
