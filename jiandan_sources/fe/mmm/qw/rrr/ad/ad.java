package fe.mmm.qw.rrr.ad;

import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import com.tera.scan.record.model.FileUploadStatus;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.record.model.ScanRecordFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull
    public static final Map<String, Object> ad(@NotNull ScanRecordExportFile scanRecordExportFile) {
        Intrinsics.checkNotNullParameter(scanRecordExportFile, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("record_id", scanRecordExportFile.getRecordId()), TuplesKt.to("filename", scanRecordExportFile.getFileName()), TuplesKt.to("server_path", scanRecordExportFile.getServerPath()), TuplesKt.to("fsid", scanRecordExportFile.getFsid()), TuplesKt.to("size", Integer.valueOf(scanRecordExportFile.getSize())), TuplesKt.to("server_ctime", Long.valueOf(scanRecordExportFile.getServerCtime())), TuplesKt.to("local_path", scanRecordExportFile.getLocalPath()), TuplesKt.to("status", Integer.valueOf(scanRecordExportFile.getStatus().ordinal())));
    }

    @NotNull
    public static final Map<String, Object> de(@NotNull ScanRecordFile scanRecordFile) {
        Intrinsics.checkNotNullParameter(scanRecordFile, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("position", Integer.valueOf(scanRecordFile.getOrder())), TuplesKt.to("record_id", scanRecordFile.getRecordId()), TuplesKt.to("fsid", scanRecordFile.getFsid()), TuplesKt.to("size", Integer.valueOf(scanRecordFile.getSize())), TuplesKt.to("status", Integer.valueOf(scanRecordFile.getStatus().ordinal())), TuplesKt.to("local_path", scanRecordFile.getLocalPath()), TuplesKt.to("server_path", scanRecordFile.getRemotePath()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0022 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x006b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007e  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.tera.scan.record.model.ScanRecord fe(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ? extends java.lang.Object> r25) {
        /*
            r0 = r25
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "picture_list"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.util.List
            r3 = 0
            if (r2 == 0) goto L_0x0015
            java.util.List r1 = (java.util.List) r1
            goto L_0x0016
        L_0x0015:
            r1 = r3
        L_0x0016:
            r2 = 0
            if (r1 == 0) goto L_0x0082
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0022:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0087
            java.lang.Object r5 = r1.next()
            boolean r6 = r5 instanceof java.util.Map
            if (r6 == 0) goto L_0x0033
            java.util.Map r5 = (java.util.Map) r5
            goto L_0x0034
        L_0x0033:
            r5 = r3
        L_0x0034:
            if (r5 == 0) goto L_0x007b
            boolean r6 = r5.isEmpty()
            r7 = 1
            if (r6 == 0) goto L_0x003e
            goto L_0x006c
        L_0x003e:
            java.util.Set r6 = r5.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0046:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x006c
            java.lang.Object r8 = r6.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r9 = r8.getKey()
            boolean r9 = r9 instanceof java.lang.String
            if (r9 == 0) goto L_0x0068
            java.lang.Object r8 = r8.getValue()
            if (r8 == 0) goto L_0x0063
            boolean r8 = r8 instanceof java.lang.Object
            goto L_0x0064
        L_0x0063:
            r8 = 1
        L_0x0064:
            if (r8 == 0) goto L_0x0068
            r8 = 1
            goto L_0x0069
        L_0x0068:
            r8 = 0
        L_0x0069:
            if (r8 != 0) goto L_0x0046
            r7 = 0
        L_0x006c:
            if (r7 == 0) goto L_0x0073
            boolean r6 = r5 instanceof java.util.Map
            if (r6 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r5 = r3
        L_0x0074:
            if (r5 == 0) goto L_0x007b
            com.tera.scan.record.model.ScanRecordFile r5 = yj(r5)
            goto L_0x007c
        L_0x007b:
            r5 = r3
        L_0x007c:
            if (r5 == 0) goto L_0x0022
            r4.add(r5)
            goto L_0x0022
        L_0x0082:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x0087:
            java.lang.String r1 = "m_time"
            java.lang.Object r1 = r0.get(r1)
            boolean r5 = r1 instanceof java.lang.Long
            if (r5 == 0) goto L_0x0095
            r5 = r1
            java.lang.Long r5 = (java.lang.Long) r5
            goto L_0x0096
        L_0x0095:
            r5 = r3
        L_0x0096:
            if (r5 != 0) goto L_0x00a7
            boolean r5 = r1 instanceof java.lang.Integer
            if (r5 == 0) goto L_0x00a0
            java.lang.Integer r1 = (java.lang.Integer) r1
            r5 = r1
            goto L_0x00a1
        L_0x00a0:
            r5 = r3
        L_0x00a1:
            if (r5 != 0) goto L_0x00a7
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
        L_0x00a7:
            java.lang.String r1 = "c_time"
            java.lang.Object r1 = r0.get(r1)
            boolean r6 = r1 instanceof java.lang.Long
            if (r6 == 0) goto L_0x00b5
            r6 = r1
            java.lang.Long r6 = (java.lang.Long) r6
            goto L_0x00b6
        L_0x00b5:
            r6 = r3
        L_0x00b6:
            if (r6 != 0) goto L_0x00c4
            boolean r6 = r1 instanceof java.lang.Integer
            if (r6 == 0) goto L_0x00c0
            java.lang.Integer r1 = (java.lang.Integer) r1
            r6 = r1
            goto L_0x00c1
        L_0x00c0:
            r6 = r3
        L_0x00c1:
            if (r6 != 0) goto L_0x00c4
            r6 = r5
        L_0x00c4:
            java.lang.String r1 = "open_time"
            java.lang.Object r1 = r0.get(r1)
            boolean r7 = r1 instanceof java.lang.Long
            if (r7 == 0) goto L_0x00d2
            r7 = r1
            java.lang.Long r7 = (java.lang.Long) r7
            goto L_0x00d3
        L_0x00d2:
            r7 = r3
        L_0x00d3:
            if (r7 != 0) goto L_0x00e1
            boolean r7 = r1 instanceof java.lang.Integer
            if (r7 == 0) goto L_0x00dd
            java.lang.Integer r1 = (java.lang.Integer) r1
            r7 = r1
            goto L_0x00de
        L_0x00dd:
            r7 = r3
        L_0x00de:
            if (r7 != 0) goto L_0x00e1
            r7 = r6
        L_0x00e1:
            com.tera.scan.record.model.ScanRecord r1 = new com.tera.scan.record.model.ScanRecord
            java.lang.String r8 = "name"
            java.lang.Object r8 = r0.get(r8)
            boolean r9 = r8 instanceof java.lang.String
            if (r9 == 0) goto L_0x00f0
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00f1
        L_0x00f0:
            r8 = r3
        L_0x00f1:
            java.lang.String r9 = ""
            if (r8 != 0) goto L_0x00f7
            r10 = r9
            goto L_0x00f8
        L_0x00f7:
            r10 = r8
        L_0x00f8:
            java.lang.String r8 = "display_name"
            java.lang.Object r8 = r0.get(r8)
            boolean r11 = r8 instanceof java.lang.String
            if (r11 == 0) goto L_0x0106
            java.lang.String r8 = (java.lang.String) r8
            r11 = r8
            goto L_0x0107
        L_0x0106:
            r11 = r3
        L_0x0107:
            java.lang.String r8 = "record_id"
            java.lang.Object r8 = r0.get(r8)
            boolean r12 = r8 instanceof java.lang.String
            if (r12 == 0) goto L_0x0114
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0115
        L_0x0114:
            r8 = r3
        L_0x0115:
            if (r8 != 0) goto L_0x0119
            r12 = r9
            goto L_0x011a
        L_0x0119:
            r12 = r8
        L_0x011a:
            long r13 = r5.longValue()
            java.lang.String r5 = "category"
            java.lang.Object r5 = r0.get(r5)
            boolean r8 = r5 instanceof java.lang.Integer
            if (r8 == 0) goto L_0x012b
            java.lang.Integer r5 = (java.lang.Integer) r5
            goto L_0x012c
        L_0x012b:
            r5 = r3
        L_0x012c:
            if (r5 == 0) goto L_0x0132
            int r2 = r5.intValue()
        L_0x0132:
            java.lang.String r5 = "save_path"
            java.lang.Object r0 = r0.get(r5)
            boolean r5 = r0 instanceof java.lang.String
            if (r5 == 0) goto L_0x013f
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
        L_0x013f:
            r15 = r3
            long r16 = r6.longValue()
            long r18 = r7.longValue()
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1792(0x700, float:2.511E-42)
            r24 = 0
            r8 = r1
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r14 = r2
            r8.<init>(r9, r10, r11, r12, r14, r15, r16, r18, r20, r21, r22, r23, r24)
            java.util.List r0 = r1.getPictureList()
            r0.addAll(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.rrr.ad.ad.fe(java.util.Map):com.tera.scan.record.model.ScanRecord");
    }

    @NotNull
    public static final List<ScanRecord> i(@NotNull List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Map fe2 : list) {
            arrayList.add(fe(fe2));
        }
        return arrayList;
    }

    @NotNull
    public static final Map<String, Object> qw(@NotNull ScanRecord scanRecord) {
        Intrinsics.checkNotNullParameter(scanRecord, "<this>");
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("name", scanRecord.getName());
        pairArr[1] = TuplesKt.to("record_id", scanRecord.getRecordId());
        pairArr[2] = TuplesKt.to("m_time", Long.valueOf(scanRecord.getModifyTime()));
        pairArr[3] = TuplesKt.to("category", Integer.valueOf(scanRecord.getCategory()));
        pairArr[4] = TuplesKt.to("display_name", scanRecord.getDisplayName());
        pairArr[5] = TuplesKt.to("c_time", Long.valueOf(scanRecord.getCreateTime()));
        pairArr[6] = TuplesKt.to("open_time", Long.valueOf(scanRecord.getOpenTime()));
        pairArr[7] = TuplesKt.to(OCRRectifyActivity.EXTRA_SAVE_PATH, scanRecord.getSavePath());
        List<ScanRecordFile> pictureList = scanRecord.getPictureList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(pictureList, 10));
        for (ScanRecordFile de2 : pictureList) {
            arrayList.add(de(de2));
        }
        pairArr[8] = TuplesKt.to("picture_list", arrayList);
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public static final ScanRecordExportFile rg(@NotNull Map<String, ? extends Object> map) {
        long longValue;
        String str;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Object obj = map.get("server_ctime");
        Integer num = null;
        if (obj instanceof Integer) {
            longValue = (long) ((Number) obj).intValue();
        } else {
            Long l = obj instanceof Long ? (Long) obj : null;
            longValue = l != null ? l.longValue() : 0;
        }
        long j = longValue;
        Object obj2 = map.get("record_id");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        String str3 = str2 == null ? "" : str2;
        Object obj3 = map.get("filename");
        String str4 = obj3 instanceof String ? (String) obj3 : null;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        Object obj4 = map.get("server_path");
        String str5 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = map.get("fsid");
        String str6 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = map.get("size");
        Integer num2 = obj6 instanceof Integer ? (Integer) obj6 : null;
        int i2 = 0;
        int intValue = num2 != null ? num2.intValue() : 0;
        Object obj7 = map.get("local_path");
        String str7 = obj7 instanceof String ? (String) obj7 : null;
        FileUploadStatus[] values = FileUploadStatus.values();
        Object obj8 = map.get("status");
        if (obj8 instanceof Integer) {
            num = (Integer) obj8;
        }
        if (num != null) {
            i2 = num.intValue();
        }
        return new ScanRecordExportFile(str3, str, str5, str6, intValue, j, str7, values[i2]);
    }

    @NotNull
    public static final List<ScanRecordExportFile> th(@NotNull List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Map rg2 : list) {
            arrayList.add(rg(rg2));
        }
        return arrayList;
    }

    @NotNull
    public static final List<ScanRecordFile> uk(@NotNull List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Map yj2 : list) {
            arrayList.add(yj(yj2));
        }
        return arrayList;
    }

    @NotNull
    public static final ScanRecordFile yj(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Object obj = map.get("record_id");
        Integer num = null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Object obj2 = map.get("position");
        Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
        int i2 = 0;
        int intValue = num2 != null ? num2.intValue() : 0;
        Object obj3 = map.get("fsid");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("server_path");
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = map.get("local_path");
        String str5 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = map.get("size");
        Integer num3 = obj6 instanceof Integer ? (Integer) obj6 : null;
        int intValue2 = num3 != null ? num3.intValue() : 0;
        FileUploadStatus[] values = FileUploadStatus.values();
        Object obj7 = map.get("status");
        if (obj7 instanceof Integer) {
            num = (Integer) obj7;
        }
        if (num != null) {
            i2 = num.intValue();
        }
        return new ScanRecordFile(str2, intValue, str3, str4, str5, intValue2, values[i2]);
    }
}
