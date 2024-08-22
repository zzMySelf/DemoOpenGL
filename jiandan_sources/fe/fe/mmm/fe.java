package fe.fe.mmm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import java.io.File;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f2025ad = tt.vvv();

    /* renamed from: de  reason: collision with root package name */
    public static final String f2026de = (tt.i() + "ubcdir");
    public Context qw;

    public fe(Context context) {
        this.qw = context;
    }

    public final File ad(String str, boolean z) {
        File file = new File(this.qw.getFilesDir(), f2026de);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!TextUtils.isEmpty(str)) {
            File file2 = new File(file, "proc");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            return new File(file2, str);
        }
        return new File(file, z ? "filereal" : "filedata");
    }

    public void de(boolean z) {
        File file = new File(this.qw.getFilesDir(), f2026de);
        if (file.exists()) {
            File file2 = new File(file, z ? "filereal" : "filedata");
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(file, "proc");
            int i2 = 0;
            if (file3.exists() && file3.isDirectory()) {
                File[] listFiles = file3.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int length = listFiles.length;
                    int i3 = 0;
                    while (i2 < length) {
                        File file4 = listFiles[i2];
                        if (file4.isFile() && file4.delete()) {
                            i3++;
                        }
                        i2++;
                    }
                    i2 = i3;
                } else {
                    return;
                }
            }
            if (z && i2 > 0) {
                c.de().ggg(i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0139 A[Catch:{ all -> 0x0132 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013e A[SYNTHETIC, Splitter:B:63:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0165 A[SYNTHETIC, Splitter:B:73:0x0165] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fe(fe.fe.mmm.vvv r6, java.io.File r7) {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "id"
            java.lang.String r2 = r6.ppp()     // Catch:{ JSONException -> 0x00ca }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r1 = "timestamp"
            long r2 = r6.mmm()     // Catch:{ JSONException -> 0x00ca }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r1 = "type"
            java.lang.String r2 = "0"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r1 = r6.i()     // Catch:{ JSONException -> 0x00ca }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r2 = "content"
            if (r1 != 0) goto L_0x0032
            java.lang.String r1 = r6.i()     // Catch:{ JSONException -> 0x00ca }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00ca }
            goto L_0x0043
        L_0x0032:
            org.json.JSONObject r1 = r6.ggg()     // Catch:{ JSONException -> 0x00ca }
            if (r1 == 0) goto L_0x0043
            org.json.JSONObject r1 = r6.ggg()     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x00ca }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00ca }
        L_0x0043:
            java.lang.String r1 = r6.aaa()     // Catch:{ JSONException -> 0x00ca }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00ca }
            if (r1 != 0) goto L_0x0056
            java.lang.String r1 = "uuid"
            java.lang.String r2 = r6.aaa()     // Catch:{ JSONException -> 0x00ca }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
        L_0x0056:
            java.lang.String r1 = r6.fe()     // Catch:{ JSONException -> 0x00ca }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00ca }
            if (r1 != 0) goto L_0x0069
            java.lang.String r1 = "appv"
            java.lang.String r2 = r6.fe()     // Catch:{ JSONException -> 0x00ca }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
        L_0x0069:
            java.lang.String r1 = r6.pf()     // Catch:{ JSONException -> 0x00ca }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00ca }
            if (r1 != 0) goto L_0x007c
            java.lang.String r1 = "abtest"
            java.lang.String r2 = r6.pf()     // Catch:{ JSONException -> 0x00ca }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
        L_0x007c:
            java.lang.String r1 = r6.uk()     // Catch:{ JSONException -> 0x00ca }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00ca }
            if (r1 != 0) goto L_0x008f
            java.lang.String r1 = "c"
            java.lang.String r2 = r6.uk()     // Catch:{ JSONException -> 0x00ca }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
        L_0x008f:
            boolean r1 = r6.qqq()     // Catch:{ JSONException -> 0x00ca }
            if (r1 == 0) goto L_0x009c
            java.lang.String r1 = "of"
            java.lang.String r2 = "1"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
        L_0x009c:
            java.lang.String r1 = "idtype"
            fe.fe.mmm.i r2 = fe.fe.mmm.i.vvv()     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r3 = r6.ppp()     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r2 = r2.b(r3)     // Catch:{ JSONException -> 0x00ca }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00ca }
            org.json.JSONObject r1 = r6.yj()     // Catch:{ JSONException -> 0x00ca }
            if (r1 == 0) goto L_0x00be
            int r2 = r1.length()     // Catch:{ JSONException -> 0x00ca }
            if (r2 <= 0) goto L_0x00be
            java.lang.String r2 = "bizparam"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00ca }
        L_0x00be:
            org.json.JSONObject r1 = r6.th()     // Catch:{ JSONException -> 0x00ca }
            if (r1 == 0) goto L_0x00d2
            java.lang.String r2 = "bizInfo"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00ca }
            goto L_0x00d2
        L_0x00ca:
            r1 = move-exception
            boolean r2 = f2025ad
            if (r2 == 0) goto L_0x00d2
            r1.getMessage()
        L_0x00d2:
            boolean r1 = f2025ad
            if (r1 == 0) goto L_0x00ea
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "saveEvent:"
            r1.append(r2)
            java.lang.String r2 = r0.toString()
            r1.append(r2)
            r1.toString()
        L_0x00ea:
            java.lang.String r0 = r0.toString()
            byte[] r0 = r0.getBytes()
            r1 = 2
            byte[] r0 = android.util.Base64.encode(r0, r1)
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0134 }
            r4 = 1
            r3.<init>(r7, r4)     // Catch:{ Exception -> 0x0134 }
            r3.write(r0)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            java.lang.String r7 = "\n"
            byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r3.write(r7)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r3.flush()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r3.close()     // Catch:{ Exception -> 0x0112 }
            goto L_0x011a
        L_0x0112:
            r7 = move-exception
            boolean r0 = f2025ad
            if (r0 == 0) goto L_0x011a
            r7.printStackTrace()
        L_0x011a:
            fe.fe.mmm.aaa r7 = fe.fe.mmm.aaa.o()
            java.lang.String r0 = r6.ppp()
            java.lang.String r1 = r6.vvv()
            r7.ad(r0, r2, r1)
            com.baidu.ubc.bypass.BypassConstants$Funnel r7 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_SUCCESS_EVENT
            goto L_0x015b
        L_0x012c:
            r7 = move-exception
            r1 = r3
            goto L_0x0163
        L_0x012f:
            r7 = move-exception
            r1 = r3
            goto L_0x0135
        L_0x0132:
            r7 = move-exception
            goto L_0x0163
        L_0x0134:
            r7 = move-exception
        L_0x0135:
            boolean r0 = f2025ad     // Catch:{ all -> 0x0132 }
            if (r0 == 0) goto L_0x013c
            r7.printStackTrace()     // Catch:{ all -> 0x0132 }
        L_0x013c:
            if (r1 == 0) goto L_0x014a
            r1.close()     // Catch:{ Exception -> 0x0142 }
            goto L_0x014a
        L_0x0142:
            r7 = move-exception
            boolean r0 = f2025ad
            if (r0 == 0) goto L_0x014a
            r7.printStackTrace()
        L_0x014a:
            fe.fe.mmm.aaa r7 = fe.fe.mmm.aaa.o()
            java.lang.String r0 = r6.ppp()
            java.lang.String r1 = r6.vvv()
            r7.ad(r0, r2, r1)
            com.baidu.ubc.bypass.BypassConstants$Funnel r7 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_ERROR_EVENT
        L_0x015b:
            long r0 = r6.mmm()
            fe.fe.mmm.n.qw.fe(r7, r0)
            return
        L_0x0163:
            if (r1 == 0) goto L_0x0171
            r1.close()     // Catch:{ Exception -> 0x0169 }
            goto L_0x0171
        L_0x0169:
            r0 = move-exception
            boolean r1 = f2025ad
            if (r1 == 0) goto L_0x0171
            r0.printStackTrace()
        L_0x0171:
            fe.fe.mmm.aaa r0 = fe.fe.mmm.aaa.o()
            java.lang.String r1 = r6.ppp()
            java.lang.String r3 = r6.vvv()
            r0.ad(r1, r2, r3)
            com.baidu.ubc.bypass.BypassConstants$Funnel r0 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_ERROR_EVENT
            long r1 = r6.mmm()
            fe.fe.mmm.n.qw.fe(r0, r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.fe.fe(fe.fe.mmm.vvv, java.io.File):void");
    }

    public void i(vvv vvv) {
        File file = new File(this.qw.getFilesDir(), f2026de);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "filequality");
        if (file2.length() > ((long) i.vvv().xxx())) {
            if (file2.delete()) {
                file2 = new File(file, "filequality");
            } else {
                return;
            }
        }
        fe(vvv, file2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e2 A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e7 A[SYNTHETIC, Splitter:B:55:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f9 A[SYNTHETIC, Splitter:B:62:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean qw(fe.fe.mmm.l r19) {
        /*
            r18 = this;
            r1 = r19
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = r18
            android.content.Context r4 = r3.qw
            java.io.File r4 = r4.getFilesDir()
            r2.append(r4)
            java.lang.String r4 = java.io.File.separator
            r2.append(r4)
            java.lang.String r4 = f2026de
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "proc"
            r0.<init>(r2, r4)
            boolean r2 = r0.exists()
            r4 = 0
            if (r2 != 0) goto L_0x002f
            return r4
        L_0x002f:
            java.io.File[] r2 = r0.listFiles()
            if (r2 == 0) goto L_0x0109
            int r0 = r2.length
            if (r0 != 0) goto L_0x003a
            goto L_0x0109
        L_0x003a:
            int r5 = r2.length
            r6 = 0
        L_0x003c:
            if (r6 >= r5) goto L_0x0107
            r0 = r2[r6]
            r7 = 0
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00dd }
            java.io.FileReader r9 = new java.io.FileReader     // Catch:{ Exception -> 0x00dd }
            r9.<init>(r0)     // Catch:{ Exception -> 0x00dd }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00dd }
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r0 = 0
            r13 = 0
        L_0x0053:
            java.lang.String r7 = r8.readLine()     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            if (r7 == 0) goto L_0x00a9
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r11 = 2
            byte[] r7 = android.util.Base64.decode(r7, r11)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r15.<init>(r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            java.lang.String r4 = "abtest"
            boolean r4 = r15.has(r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            if (r4 == 0) goto L_0x0079
            java.lang.String r4 = "1"
            r1.x(r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
        L_0x0079:
            java.lang.String r4 = "timestamp"
            long r11 = r15.getLong(r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r16 = 0
            int r4 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r4 <= 0) goto L_0x008f
            int r4 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x008a
            r9 = r11
        L_0x008a:
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x008f
            r13 = r11
        L_0x008f:
            boolean r4 = f2025ad     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            if (r4 == 0) goto L_0x0096
            r15.toString()     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
        L_0x0096:
            r1.ad(r15)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            int r0 = r0 + 1
            r4 = 10
            if (r0 < r4) goto L_0x00a7
            fe.fe.mmm.c r7 = fe.fe.mmm.c.de()     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r7.vvv(r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            goto L_0x00a9
        L_0x00a7:
            r4 = 0
            goto L_0x0053
        L_0x00a9:
            r1.w(r9, r13)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            boolean r4 = f2025ad     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            if (r4 == 0) goto L_0x00c5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r4.<init>()     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            java.lang.String r7 = "line num "
            r4.append(r7)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r4.append(r0)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            java.lang.String r0 = " delete file "
            r4.append(r0)     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
            r4.toString()     // Catch:{ Exception -> 0x00d7, all -> 0x00d3 }
        L_0x00c5:
            r8.close()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00f2
        L_0x00c9:
            r0 = move-exception
            r4 = r0
            boolean r0 = f2025ad
            if (r0 == 0) goto L_0x00f2
        L_0x00cf:
            r4.printStackTrace()
            goto L_0x00f2
        L_0x00d3:
            r0 = move-exception
            r1 = r0
            r7 = r8
            goto L_0x00f7
        L_0x00d7:
            r0 = move-exception
            r7 = r8
            goto L_0x00de
        L_0x00da:
            r0 = move-exception
            r1 = r0
            goto L_0x00f7
        L_0x00dd:
            r0 = move-exception
        L_0x00de:
            boolean r4 = f2025ad     // Catch:{ all -> 0x00da }
            if (r4 == 0) goto L_0x00e5
            r0.printStackTrace()     // Catch:{ all -> 0x00da }
        L_0x00e5:
            if (r7 == 0) goto L_0x00f2
            r7.close()     // Catch:{ Exception -> 0x00eb }
            goto L_0x00f2
        L_0x00eb:
            r0 = move-exception
            r4 = r0
            boolean r0 = f2025ad
            if (r0 == 0) goto L_0x00f2
            goto L_0x00cf
        L_0x00f2:
            int r6 = r6 + 1
            r4 = 0
            goto L_0x003c
        L_0x00f7:
            if (r7 == 0) goto L_0x0106
            r7.close()     // Catch:{ Exception -> 0x00fd }
            goto L_0x0106
        L_0x00fd:
            r0 = move-exception
            r2 = r0
            boolean r0 = f2025ad
            if (r0 == 0) goto L_0x0106
            r2.printStackTrace()
        L_0x0106:
            throw r1
        L_0x0107:
            r0 = 1
            return r0
        L_0x0109:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.fe.qw(fe.fe.mmm.l):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:37|36|39|40|(2:42|43)|(1:47)|49) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a6, code lost:
        if (r3.exists() != false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        r3.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c3, code lost:
        if (r3.exists() != false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cd, code lost:
        r1 = f2025ad;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00b3 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b7 A[SYNTHETIC, Splitter:B:42:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c9 A[SYNTHETIC, Splitter:B:51:0x00c9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean rg(fe.fe.mmm.l r16) {
        /*
            r15 = this;
            r0 = r16
            java.io.File r1 = new java.io.File
            r2 = r15
            android.content.Context r3 = r2.qw
            java.io.File r3 = r3.getFilesDir()
            java.lang.String r4 = f2026de
            r1.<init>(r3, r4)
            boolean r3 = r1.exists()
            if (r3 != 0) goto L_0x0019
            r1.mkdirs()
        L_0x0019:
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "filequality"
            r3.<init>(r1, r4)
            boolean r1 = r3.exists()
            r4 = 0
            if (r1 != 0) goto L_0x0028
            return r4
        L_0x0028:
            com.baidu.ubc.bypass.BypassConstants$Funnel r1 = com.baidu.ubc.bypass.BypassConstants$Funnel.PACKAGE_QUERY
            long r5 = r16.eee()
            fe.fe.mmm.n.qw.th(r1, r5)
            r1 = 0
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b3 }
            java.io.FileReader r6 = new java.io.FileReader     // Catch:{ Exception -> 0x00b3 }
            r6.<init>(r3)     // Catch:{ Exception -> 0x00b3 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00b3 }
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r8 = 0
            r10 = r8
        L_0x0044:
            java.lang.String r1 = r5.readLine()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            if (r1 == 0) goto L_0x0097
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r13 = new java.lang.String     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r14 = 2
            byte[] r1 = android.util.Base64.decode(r1, r14)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r13.<init>(r1)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r12.<init>(r13)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r1 = "abtest"
            boolean r1 = r12.has(r1)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            if (r1 == 0) goto L_0x006a
            java.lang.String r1 = "1"
            r0.x(r1)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
        L_0x006a:
            java.lang.String r1 = "timestamp"
            long r13 = r12.getLong(r1)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            int r1 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x007e
            int r1 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x0079
            r6 = r13
        L_0x0079:
            int r1 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x007e
            r10 = r13
        L_0x007e:
            com.baidu.ubc.bypass.BypassConstants$Funnel r1 = com.baidu.ubc.bypass.BypassConstants$Funnel.PACKAGE_QUERY_EVENT     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            long r8 = r16.eee()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            fe.fe.mmm.n.qw.rg(r1, r13, r8)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r0.ad(r12)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            com.baidu.ubc.bypass.BypassConstants$Funnel r1 = com.baidu.ubc.bypass.BypassConstants$Funnel.PACKAGE_TO_FILE_EVENT     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            long r8 = r16.eee()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            fe.fe.mmm.n.qw.rg(r1, r13, r8)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r4 = 1
            r8 = 0
            goto L_0x0044
        L_0x0097:
            r0.w(r6, r10)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r5.close()     // Catch:{ Exception -> 0x009e }
            goto L_0x00a0
        L_0x009e:
            boolean r0 = f2025ad
        L_0x00a0:
            if (r4 == 0) goto L_0x00c6
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x00c6
        L_0x00a8:
            r3.delete()
            goto L_0x00c6
        L_0x00ac:
            r0 = move-exception
            r1 = r5
            goto L_0x00c7
        L_0x00af:
            r1 = r5
            goto L_0x00b3
        L_0x00b1:
            r0 = move-exception
            goto L_0x00c7
        L_0x00b3:
            boolean r0 = f2025ad     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x00bd
            r1.close()     // Catch:{ Exception -> 0x00bb }
            goto L_0x00bd
        L_0x00bb:
            boolean r0 = f2025ad
        L_0x00bd:
            if (r4 == 0) goto L_0x00c6
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x00c6
            goto L_0x00a8
        L_0x00c6:
            return r4
        L_0x00c7:
            if (r1 == 0) goto L_0x00cf
            r1.close()     // Catch:{ Exception -> 0x00cd }
            goto L_0x00cf
        L_0x00cd:
            boolean r1 = f2025ad
        L_0x00cf:
            if (r4 == 0) goto L_0x00da
            boolean r1 = r3.exists()
            if (r1 == 0) goto L_0x00da
            r3.delete()
        L_0x00da:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.fe.rg(fe.fe.mmm.l):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0092 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096 A[SYNTHETIC, Splitter:B:37:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c A[SYNTHETIC, Splitter:B:40:0x009c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean th(fe.fe.mmm.l r14, boolean r15) {
        /*
            r13 = this;
            if (r15 != 0) goto L_0x0007
            boolean r0 = r13.qw(r14)
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            java.lang.String r1 = ""
            java.io.File r15 = r13.ad(r1, r15)
            boolean r1 = r15.exists()
            if (r1 == 0) goto L_0x00a3
            com.baidu.ubc.bypass.BypassConstants$Funnel r1 = com.baidu.ubc.bypass.BypassConstants$Funnel.PACKAGE_QUERY
            long r2 = r14.eee()
            fe.fe.mmm.n.qw.th(r1, r2)
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0092 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0092 }
            r3.<init>(r15)     // Catch:{ Exception -> 0x0092 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0092 }
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = 0
            r7 = r5
        L_0x0030:
            java.lang.String r15 = r2.readLine()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            if (r15 == 0) goto L_0x0081
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r9 = new java.lang.String     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            byte[] r15 = r15.getBytes()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r10 = 2
            byte[] r15 = android.util.Base64.decode(r15, r10)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r9.<init>(r15)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r1.<init>(r9)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r15 = "abtest"
            boolean r15 = r1.has(r15)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            if (r15 == 0) goto L_0x0056
            java.lang.String r15 = "1"
            r14.x(r15)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
        L_0x0056:
            java.lang.String r15 = "timestamp"
            long r9 = r1.getLong(r15)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            int r15 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r15 <= 0) goto L_0x006a
            int r15 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r15 >= 0) goto L_0x0065
            r3 = r9
        L_0x0065:
            int r15 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r15 <= 0) goto L_0x006a
            r7 = r9
        L_0x006a:
            com.baidu.ubc.bypass.BypassConstants$Funnel r15 = com.baidu.ubc.bypass.BypassConstants$Funnel.PACKAGE_QUERY_EVENT     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            long r11 = r14.eee()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            fe.fe.mmm.n.qw.rg(r15, r9, r11)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r14.ad(r1)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            com.baidu.ubc.bypass.BypassConstants$Funnel r15 = com.baidu.ubc.bypass.BypassConstants$Funnel.PACKAGE_TO_FILE_EVENT     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            long r11 = r14.eee()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            fe.fe.mmm.n.qw.rg(r15, r9, r11)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r0 = 1
            goto L_0x0030
        L_0x0081:
            r14.w(r3, r7)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r2.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x00a3
        L_0x0088:
            boolean r14 = f2025ad
            goto L_0x00a3
        L_0x008b:
            r14 = move-exception
            r1 = r2
            goto L_0x009a
        L_0x008e:
            r1 = r2
            goto L_0x0092
        L_0x0090:
            r14 = move-exception
            goto L_0x009a
        L_0x0092:
            boolean r14 = f2025ad     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x00a3
            r1.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x00a3
        L_0x009a:
            if (r1 == 0) goto L_0x00a2
            r1.close()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a2
        L_0x00a0:
            boolean r15 = f2025ad
        L_0x00a2:
            throw r14
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.fe.th(fe.fe.mmm.l, boolean):boolean");
    }

    public void uk(Exception exc, String str, String str2) {
        if (f2025ad) {
            exc.printStackTrace();
        }
        String stackTraceString = Log.getStackTraceString(exc);
        c.de().mmm(stackTraceString, str, str2);
        m.m128switch("type:" + str + ";from:" + str2 + ";ex:" + stackTraceString, EnumConstants$RunTime.DB_SQL_ERROR);
    }

    public void yj(vvv vvv, boolean z) {
        fe(vvv, ad(vvv.m144if(), z));
    }
}
