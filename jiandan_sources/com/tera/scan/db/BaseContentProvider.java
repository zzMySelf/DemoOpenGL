package com.tera.scan.db;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.mmm.qw.uk.de;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public abstract class BaseContentProvider extends ContentProvider implements IOpenable, OnNotifyListener {
    public static final String TAG = "BaseContentProvider";
    public static final int TRANSACTION_SIZE = 50;
    public static final int TYPE_DELETE = getConstantValue("TYPE_DELETE", 3);
    public static final int TYPE_INSERT = getConstantValue("TYPE_INSERT", 1);
    public static final int TYPE_UPDATE = getConstantValue("TYPE_UPDATE", 2);
    public final ThreadLocal<Boolean> mThreadInTransaction = new qw(this);
    @Nullable
    public de mWriters = null;

    public static final class ad {

        /* renamed from: ad  reason: collision with root package name */
        public final int f6868ad;

        /* renamed from: de  reason: collision with root package name */
        public final ContentValues f6869de;
        public final Uri qw;

        public ad(Uri uri, int i2, ContentValues contentValues) {
            this.qw = uri;
            this.f6868ad = i2;
            this.f6869de = contentValues;
        }

        public String toString() {
            return "[uri=" + this.qw + ",type=" + this.f6868ad + ",values=" + this.f6869de + "]";
        }
    }

    public class qw extends ThreadLocal<Boolean> {
        public qw(BaseContentProvider baseContentProvider) {
        }

        /* renamed from: qw */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    public static <T> T getCannotAccessibleFieldValue(Object obj, String str) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static int getConstantValue(String str, int i2) {
        try {
            return ((Integer) getCannotAccessibleFieldValue(ContentProviderOperation.class, str)).intValue();
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int getFieldValue(ContentProviderOperation contentProviderOperation, String str) {
        try {
            return ((Integer) getCannotAccessibleFieldValue(contentProviderOperation, str)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    private void notify(HashMap<Integer, ad> hashMap) {
        for (ad next : hashMap.values()) {
            int i2 = TYPE_INSERT;
            int i3 = next.f6868ad;
            if (i2 == i3) {
                onInsertNotify(next.qw, next.f6869de);
            } else if (TYPE_UPDATE == i3) {
                onUpdateNotify(next.qw, next.f6869de);
            } else if (TYPE_DELETE == i3) {
                onDeleteNotify(next.qw);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:54|61|62|63|64|65|(1:67)|68|69|(0)|(0)|74|75) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:55|76|77|78|79|80|(1:82)|83|84|(1:86)|(1:88)|89|90) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:56|91|92|93|94|95|(1:97)|98|99|(0)|(0)|104|105) */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:(1:12)|13|(1:15)(1:16)|17|18|(1:(10:20|21|(1:25)|26|27|28|29|(1:31)|32|(2:132|34)(2:(8:38|39|40|41|(2:43|44)(1:45)|46|47|133)|48))(0))|(3:49|50|(1:52))|(2:59|60)|117|118|(1:120)|121|122|(1:124)|(1:126)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:38|39|40|41|(2:43|44)(1:45)|46|47|133) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:53|106|107|(1:109)|110|111|(0)|(0)|116) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0152, code lost:
        r14.mWriters.de(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0159, code lost:
        r0.ad();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0175, code lost:
        r14.mWriters.de(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x017c, code lost:
        r0.ad();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01a2, code lost:
        return r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:110:0x0167 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x0189 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0065 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00a3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00b9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x00f0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x011a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x0144 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0152 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0159 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0175 A[Catch:{ all -> 0x00cd }, FINALLY_INSNS] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x017c A[Catch:{ all -> 0x00cd }, FINALLY_INSNS] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0197 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x019e A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0096 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080 A[Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097 A[ADDED_TO_REGION, Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2 A[SYNTHETIC, Splitter:B:43:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6 A[Catch:{ IllegalStateException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fe A[Catch:{ all -> 0x00cd }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0105 A[Catch:{ all -> 0x00cd }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0128 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x012f A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:68:0x00f0=Splitter:B:68:0x00f0, B:98:0x0144=Splitter:B:98:0x0144, B:110:0x0167=Splitter:B:110:0x0167, B:121:0x0189=Splitter:B:121:0x0189, B:83:0x011a=Splitter:B:83:0x011a} */
    @android.annotation.TargetApi(11)
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.ContentProviderResult[] applyBatch(@androidx.annotation.NonNull java.util.ArrayList<android.content.ContentProviderOperation> r15) throws android.content.OperationApplicationException {
        /*
            r14 = this;
            fe.mmm.qw.uk.de r0 = r14.mWriters
            r1 = 0
            if (r0 == 0) goto L_0x000b
            r2 = 5
            fe.mmm.qw.uk.ad r0 = r0.qw(r1, r2)
            goto L_0x000c
        L_0x000b:
            r0 = r1
        L_0x000c:
            monitor-enter(r14)
            fe.mmm.qw.uk.qw r2 = r14.getOpenHelper()     // Catch:{ all -> 0x01a3 }
            r3 = 0
            if (r2 != 0) goto L_0x0022
            java.lang.String r15 = "BaseContentProvider"
            java.lang.String r0 = "openHelper is null"
            fe.mmm.qw.i.qw.ad(r15, r0)     // Catch:{ all -> 0x01a3 }
            r14.onBeforeApply(r1, r1)     // Catch:{ all -> 0x01a3 }
            android.content.ContentProviderResult[] r15 = new android.content.ContentProviderResult[r3]     // Catch:{ all -> 0x01a3 }
            monitor-exit(r14)     // Catch:{ all -> 0x01a3 }
            return r15
        L_0x0022:
            if (r0 == 0) goto L_0x0027
            r0.qw()     // Catch:{ all -> 0x01a3 }
        L_0x0027:
            android.database.sqlite.SQLiteDatabase r4 = r2.getWritableDatabase()     // Catch:{ all -> 0x01a3 }
            boolean r2 = r2.qw(r4)     // Catch:{ all -> 0x01a3 }
            if (r2 == 0) goto L_0x0035
            r4.beginTransactionNonExclusive()     // Catch:{ all -> 0x01a3 }
            goto L_0x0038
        L_0x0035:
            r4.beginTransaction()     // Catch:{ all -> 0x01a3 }
        L_0x0038:
            int r5 = r15.size()     // Catch:{ all -> 0x01a3 }
            android.content.ContentProviderResult[] r6 = new android.content.ContentProviderResult[r5]     // Catch:{ all -> 0x01a3 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x01a3 }
            r7.<init>()     // Catch:{ all -> 0x01a3 }
            java.lang.ThreadLocal<java.lang.Boolean> r8 = r14.mThreadInTransaction     // Catch:{ all -> 0x01a3 }
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x01a3 }
            r8.set(r9)     // Catch:{ all -> 0x01a3 }
            r8 = 0
        L_0x004b:
            if (r8 >= r5) goto L_0x00c3
            java.lang.Object r9 = r15.get(r8)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            android.content.ContentProviderOperation r9 = (android.content.ContentProviderOperation) r9     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            android.net.Uri r10 = r9.getUri()     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            if (r0 == 0) goto L_0x0062
            android.net.Uri r11 = r0.th()     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            if (r11 != 0) goto L_0x0062
            r0.uk(r10)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
        L_0x0062:
            r14.onBeforeApply(r4, r10)     // Catch:{ IllegalStateException -> 0x0065 }
        L_0x0065:
            android.content.ContentProviderResult r11 = r9.apply(r14, r6, r8)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            r6[r8] = r11     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            java.lang.String r11 = "mType"
            int r11 = getFieldValue(r9, r11)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            int r12 = r10.hashCode()     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            int r12 = r12 + r11
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            boolean r13 = r7.containsKey(r13)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            if (r13 != 0) goto L_0x0090
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            com.tera.scan.db.BaseContentProvider$ad r13 = new com.tera.scan.db.BaseContentProvider$ad     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            android.content.ContentValues r9 = r9.resolveValueBackReferences(r1, r3)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            r13.<init>(r10, r11, r9)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            r7.put(r12, r13)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
        L_0x0090:
            boolean r9 = r14.onAfterApply(r4, r10)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            if (r9 != 0) goto L_0x0097
            goto L_0x00c3
        L_0x0097:
            if (r8 <= 0) goto L_0x00c0
            int r9 = r8 % 50
            if (r9 != 0) goto L_0x00c0
            r4.setTransactionSuccessful()     // Catch:{ IllegalStateException -> 0x00a3 }
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x00a3 }
        L_0x00a3:
            java.lang.ThreadLocal<java.lang.Boolean> r9 = r14.mThreadInTransaction     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            r9.set(r10)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            r14.notify(r7)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            r7.clear()     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            if (r2 == 0) goto L_0x00b6
            r4.beginTransactionNonExclusive()     // Catch:{ IllegalStateException -> 0x00b9 }
            goto L_0x00b9
        L_0x00b6:
            r4.beginTransaction()     // Catch:{ IllegalStateException -> 0x00b9 }
        L_0x00b9:
            java.lang.ThreadLocal<java.lang.Boolean> r9 = r14.mThreadInTransaction     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            r9.set(r10)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
        L_0x00c0:
            int r8 = r8 + 1
            goto L_0x004b
        L_0x00c3:
            boolean r15 = r4.inTransaction()     // Catch:{ IllegalStateException -> 0x00d6 }
            if (r15 == 0) goto L_0x00d7
            r4.setTransactionSuccessful()     // Catch:{ IllegalStateException -> 0x00d6 }
            goto L_0x00d7
        L_0x00cd:
            r15 = move-exception
            goto L_0x015e
        L_0x00d0:
            r15 = move-exception
            goto L_0x00e0
        L_0x00d2:
            r15 = move-exception
            goto L_0x010a
        L_0x00d4:
            r15 = move-exception
            goto L_0x0134
        L_0x00d6:
        L_0x00d7:
            if (r0 == 0) goto L_0x0180
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            r15.de(r0)     // Catch:{ SQLiteCantOpenDatabaseException -> 0x00d4, SQLiteFullException -> 0x00d2, SQLiteDiskIOException -> 0x00d0 }
            goto L_0x0180
        L_0x00e0:
            java.lang.String r1 = "BaseContentProvider"
            java.lang.String r2 = "applyBatch"
            fe.mmm.qw.i.qw.ggg(r1, r2, r15)     // Catch:{ all -> 0x00cd }
            boolean r15 = r4.inTransaction()     // Catch:{ IllegalStateException -> 0x00f0 }
            if (r15 == 0) goto L_0x00f0
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x00f0 }
        L_0x00f0:
            java.lang.ThreadLocal<java.lang.Boolean> r15 = r14.mThreadInTransaction     // Catch:{ all -> 0x01a3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01a3 }
            r15.set(r1)     // Catch:{ all -> 0x01a3 }
            r14.notify(r7)     // Catch:{ all -> 0x01a3 }
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            if (r15 == 0) goto L_0x0103
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            r15.de(r0)     // Catch:{ all -> 0x01a3 }
        L_0x0103:
            if (r0 == 0) goto L_0x0108
            r0.ad()     // Catch:{ all -> 0x01a3 }
        L_0x0108:
            monitor-exit(r14)     // Catch:{ all -> 0x01a3 }
            return r6
        L_0x010a:
            java.lang.String r1 = "BaseContentProvider"
            java.lang.String r2 = "applyBatch"
            fe.mmm.qw.i.qw.ggg(r1, r2, r15)     // Catch:{ all -> 0x00cd }
            boolean r15 = r4.inTransaction()     // Catch:{ IllegalStateException -> 0x011a }
            if (r15 == 0) goto L_0x011a
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x011a }
        L_0x011a:
            java.lang.ThreadLocal<java.lang.Boolean> r15 = r14.mThreadInTransaction     // Catch:{ all -> 0x01a3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01a3 }
            r15.set(r1)     // Catch:{ all -> 0x01a3 }
            r14.notify(r7)     // Catch:{ all -> 0x01a3 }
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            if (r15 == 0) goto L_0x012d
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            r15.de(r0)     // Catch:{ all -> 0x01a3 }
        L_0x012d:
            if (r0 == 0) goto L_0x0132
            r0.ad()     // Catch:{ all -> 0x01a3 }
        L_0x0132:
            monitor-exit(r14)     // Catch:{ all -> 0x01a3 }
            return r6
        L_0x0134:
            java.lang.String r1 = "BaseContentProvider"
            java.lang.String r2 = "applyBatch"
            fe.mmm.qw.i.qw.ggg(r1, r2, r15)     // Catch:{ all -> 0x00cd }
            boolean r15 = r4.inTransaction()     // Catch:{ IllegalStateException -> 0x0144 }
            if (r15 == 0) goto L_0x0144
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x0144 }
        L_0x0144:
            java.lang.ThreadLocal<java.lang.Boolean> r15 = r14.mThreadInTransaction     // Catch:{ all -> 0x01a3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01a3 }
            r15.set(r1)     // Catch:{ all -> 0x01a3 }
            r14.notify(r7)     // Catch:{ all -> 0x01a3 }
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            if (r15 == 0) goto L_0x0157
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            r15.de(r0)     // Catch:{ all -> 0x01a3 }
        L_0x0157:
            if (r0 == 0) goto L_0x015c
            r0.ad()     // Catch:{ all -> 0x01a3 }
        L_0x015c:
            monitor-exit(r14)     // Catch:{ all -> 0x01a3 }
            return r6
        L_0x015e:
            boolean r1 = r4.inTransaction()     // Catch:{ IllegalStateException -> 0x0167 }
            if (r1 == 0) goto L_0x0167
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x0167 }
        L_0x0167:
            java.lang.ThreadLocal<java.lang.Boolean> r1 = r14.mThreadInTransaction     // Catch:{ all -> 0x01a3 }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01a3 }
            r1.set(r2)     // Catch:{ all -> 0x01a3 }
            r14.notify(r7)     // Catch:{ all -> 0x01a3 }
            fe.mmm.qw.uk.de r1 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            if (r1 == 0) goto L_0x017a
            fe.mmm.qw.uk.de r1 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            r1.de(r0)     // Catch:{ all -> 0x01a3 }
        L_0x017a:
            if (r0 == 0) goto L_0x017f
            r0.ad()     // Catch:{ all -> 0x01a3 }
        L_0x017f:
            throw r15     // Catch:{ all -> 0x01a3 }
        L_0x0180:
            boolean r15 = r4.inTransaction()     // Catch:{ IllegalStateException -> 0x0189 }
            if (r15 == 0) goto L_0x0189
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x0189 }
        L_0x0189:
            java.lang.ThreadLocal<java.lang.Boolean> r15 = r14.mThreadInTransaction     // Catch:{ all -> 0x01a3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01a3 }
            r15.set(r1)     // Catch:{ all -> 0x01a3 }
            r14.notify(r7)     // Catch:{ all -> 0x01a3 }
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            if (r15 == 0) goto L_0x019c
            fe.mmm.qw.uk.de r15 = r14.mWriters     // Catch:{ all -> 0x01a3 }
            r15.de(r0)     // Catch:{ all -> 0x01a3 }
        L_0x019c:
            if (r0 == 0) goto L_0x01a1
            r0.ad()     // Catch:{ all -> 0x01a3 }
        L_0x01a1:
            monitor-exit(r14)     // Catch:{ all -> 0x01a3 }
            return r6
        L_0x01a3:
            r15 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x01a3 }
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.db.BaseContentProvider.applyBatch(java.util.ArrayList):android.content.ContentProviderResult[]");
    }

    public final int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] contentValuesArr) {
        int onBulkInsert;
        fe.mmm.qw.uk.ad adVar = null;
        try {
            if (this.mThreadInTransaction.get().booleanValue()) {
                return onBulkInsert(uri, contentValuesArr);
            }
            if (this.mWriters != null) {
                adVar = this.mWriters.qw(uri, 4);
            }
            synchronized (this) {
                if (adVar != null) {
                    adVar.qw();
                }
                onBulkInsert = onBulkInsert(uri, contentValuesArr);
                if (adVar != null) {
                    this.mWriters.de(adVar);
                }
            }
            if (adVar != null) {
                this.mWriters.de(adVar);
                adVar.ad();
            }
            return onBulkInsert;
        } catch (SQLiteException e) {
            fe.mmm.qw.i.qw.ggg(TAG, "bulkInsert", e);
            if (adVar != null) {
                this.mWriters.de(adVar);
                adVar.ad();
            }
            return -1;
        } catch (IllegalStateException e2) {
            try {
                fe.mmm.qw.i.qw.ggg(TAG, "bulkInsert", e2);
                return -1;
            } finally {
                if (adVar != null) {
                    this.mWriters.de(adVar);
                    adVar.ad();
                }
            }
        }
    }

    public final int delete(@NonNull Uri uri, String str, String[] strArr) {
        int onDelete;
        fe.mmm.qw.uk.ad adVar = null;
        try {
            if (this.mThreadInTransaction.get().booleanValue()) {
                return onDelete(uri, str, strArr);
            }
            if (this.mWriters != null) {
                adVar = this.mWriters.qw(uri, 3);
            }
            synchronized (this) {
                if (adVar != null) {
                    adVar.qw();
                }
                onDelete = onDelete(uri, str, strArr);
                if (adVar != null) {
                    this.mWriters.de(adVar);
                }
            }
            if (adVar != null) {
                this.mWriters.de(adVar);
                adVar.ad();
            }
            return onDelete;
        } catch (SQLiteException e) {
            fe.mmm.qw.i.qw.ggg(TAG, "delete", e);
            if (adVar != null) {
                this.mWriters.de(adVar);
                adVar.ad();
            }
            return -1;
        } catch (IllegalStateException e2) {
            try {
                fe.mmm.qw.i.qw.ggg(TAG, "delete", e2);
                return -1;
            } finally {
                if (adVar != null) {
                    this.mWriters.de(adVar);
                    adVar.ad();
                }
            }
        }
    }

    public abstract /* synthetic */ fe.mmm.qw.uk.qw getOpenHelper();

    public void initMonitors(@NotNull IWaitingWriteQueueMonitorable iWaitingWriteQueueMonitorable, @NotNull ISlowWriteMonitorable iSlowWriteMonitorable) {
        this.mWriters = new de(iWaitingWriteQueueMonitorable, iSlowWriteMonitorable);
    }

    public final Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        Uri onInsert;
        fe.mmm.qw.uk.ad adVar = null;
        try {
            if (this.mThreadInTransaction.get().booleanValue()) {
                return onInsert(uri, contentValues);
            }
            if (this.mWriters != null) {
                adVar = this.mWriters.qw(uri, 1);
            }
            synchronized (this) {
                if (adVar != null) {
                    adVar.qw();
                }
                onInsert = onInsert(uri, contentValues);
                if (adVar != null) {
                    this.mWriters.de(adVar);
                }
            }
            if (adVar != null) {
                this.mWriters.de(adVar);
                adVar.ad();
            }
            return onInsert;
        } catch (SQLiteException e) {
            fe.mmm.qw.i.qw.ggg(TAG, "insert", e);
            Uri withAppendedId = ContentUris.withAppendedId(uri, 0);
            if (adVar != null) {
                this.mWriters.de(adVar);
                adVar.ad();
            }
            return withAppendedId;
        } catch (IllegalStateException e2) {
            try {
                fe.mmm.qw.i.qw.ggg(TAG, "insert", e2);
                return ContentUris.withAppendedId(uri, 0);
            } finally {
                if (adVar != null) {
                    this.mWriters.de(adVar);
                    adVar.ad();
                }
            }
        }
    }

    public abstract boolean onAfterApply(SQLiteDatabase sQLiteDatabase, Uri uri);

    public abstract void onBeforeApply(@Nullable SQLiteDatabase sQLiteDatabase, @Nullable Uri uri) throws OperationApplicationException;

    public int onBulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    public abstract int onDelete(Uri uri, String str, String[] strArr);

    public abstract /* synthetic */ void onDeleteNotify(Uri uri);

    public abstract Uri onInsert(Uri uri, ContentValues contentValues);

    public abstract /* synthetic */ void onInsertNotify(Uri uri, ContentValues contentValues);

    @Nullable
    public abstract Cursor onQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public abstract int onUpdate(Uri uri, ContentValues contentValues, String str, String[] strArr);

    public abstract /* synthetic */ void onUpdateNotify(Uri uri, ContentValues contentValues);

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0028  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri r4, java.lang.String[] r5, java.lang.String r6, java.lang.String[] r7, java.lang.String r8) {
        /*
            r3 = this;
            java.lang.String r0 = "query"
            java.lang.String r1 = "BaseContentProvider"
            r2 = 0
            android.database.Cursor r4 = r3.onQuery(r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x002c, IllegalStateException -> 0x0021, Exception -> 0x0016 }
            if (r4 == 0) goto L_0x0015
            r4.getCount()     // Catch:{ SQLiteException -> 0x0013, IllegalStateException -> 0x0011, Exception -> 0x000f }
            goto L_0x0015
        L_0x000f:
            r5 = move-exception
            goto L_0x0018
        L_0x0011:
            r5 = move-exception
            goto L_0x0023
        L_0x0013:
            r5 = move-exception
            goto L_0x002e
        L_0x0015:
            return r4
        L_0x0016:
            r5 = move-exception
            r4 = r2
        L_0x0018:
            fe.mmm.qw.i.qw.ggg(r1, r0, r5)
            if (r4 == 0) goto L_0x0020
            r4.close()
        L_0x0020:
            return r2
        L_0x0021:
            r5 = move-exception
            r4 = r2
        L_0x0023:
            fe.mmm.qw.i.qw.ggg(r1, r0, r5)
            if (r4 == 0) goto L_0x002b
            r4.close()
        L_0x002b:
            return r2
        L_0x002c:
            r5 = move-exception
            r4 = r2
        L_0x002e:
            fe.mmm.qw.i.qw.ggg(r1, r0, r5)
            if (r4 == 0) goto L_0x0036
            r4.close()
        L_0x0036:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.db.BaseContentProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public final int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int onUpdate;
        fe.mmm.qw.uk.ad adVar = null;
        try {
            if (this.mThreadInTransaction.get().booleanValue()) {
                return onUpdate(uri, contentValues, str, strArr);
            }
            if (this.mWriters != null) {
                adVar = this.mWriters.qw(uri, 2);
            }
            synchronized (this) {
                if (adVar != null) {
                    adVar.qw();
                }
                onUpdate = onUpdate(uri, contentValues, str, strArr);
                if (adVar != null) {
                    this.mWriters.de(adVar);
                }
            }
            if (adVar != null) {
                this.mWriters.de(adVar);
                adVar.ad();
            }
            return onUpdate;
        } catch (SQLiteException e) {
            fe.mmm.qw.i.qw.ggg(TAG, "update", e);
            if (adVar != null) {
                this.mWriters.de(adVar);
                adVar.ad();
            }
            return -1;
        } catch (IllegalStateException e2) {
            try {
                fe.mmm.qw.i.qw.ggg(TAG, "update", e2);
                return -1;
            } finally {
                if (adVar != null) {
                    this.mWriters.de(adVar);
                    adVar.ad();
                }
            }
        }
    }
}
