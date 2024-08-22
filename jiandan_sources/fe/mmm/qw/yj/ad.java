package fe.mmm.qw.yj;

import com.baidu.android.common.others.lang.StringUtil;
import com.tera.scan.config.IAccountChecker;
import com.tera.scan.config.IParameter;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public IParameter f8716ad;

    /* renamed from: de  reason: collision with root package name */
    public Properties f8717de = new Properties();
    public IAccountChecker qw;

    public ad(IAccountChecker iAccountChecker, IParameter iParameter) {
        this.qw = iAccountChecker;
        this.f8716ad = iParameter;
    }

    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v17, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x00f2 A[Catch:{ IOException -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0103 A[SYNTHETIC, Splitter:B:110:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x010b A[Catch:{ IOException -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0116 A[SYNTHETIC, Splitter:B:120:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x011e A[Catch:{ IOException -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b8 A[SYNTHETIC, Splitter:B:68:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00c0 A[Catch:{ IOException -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00d1 A[SYNTHETIC, Splitter:B:82:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00d9 A[Catch:{ IOException -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00ea A[SYNTHETIC, Splitter:B:96:0x00ea] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:93:0x00e5=Splitter:B:93:0x00e5, B:79:0x00cc=Splitter:B:79:0x00cc, B:107:0x00fe=Splitter:B:107:0x00fe} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean ad() {
        /*
            r7 = this;
            com.tera.scan.config.IParameter r0 = r7.f8716ad
            if (r0 == 0) goto L_0x0126
            com.tera.scan.config.IAccountChecker r0 = r7.qw
            r1 = 0
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.ad()
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            java.util.Properties r0 = r7.f8717de
            r2 = 1
            if (r0 == 0) goto L_0x001d
            int r0 = r0.size()
            if (r0 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            return r2
        L_0x001d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "配置文件读取！ 文件内容：["
            r0.append(r3)
            com.tera.scan.config.IAccountChecker r3 = r7.qw
            r0.append(r3)
            java.lang.String r3 = "]"
            r0.append(r3)
            r0.toString()
            r0 = 0
            java.io.File r3 = r7.qw()     // Catch:{ FileNotFoundException -> 0x00fa, IOException -> 0x00e1, IllegalArgumentException -> 0x00c8, ExceptionInInitializerError -> 0x00b5, all -> 0x00af }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00fa, IOException -> 0x00e1, IllegalArgumentException -> 0x00c8, ExceptionInInitializerError -> 0x00b5, all -> 0x00af }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00fa, IOException -> 0x00e1, IllegalArgumentException -> 0x00c8, ExceptionInInitializerError -> 0x00b5, all -> 0x00af }
            com.tera.scan.config.IParameter r3 = r7.f8716ad     // Catch:{ FileNotFoundException -> 0x00ab, IOException -> 0x00a8, IllegalArgumentException -> 0x00a5, ExceptionInInitializerError -> 0x00a2, all -> 0x009f }
            boolean r3 = r3.fe()     // Catch:{ FileNotFoundException -> 0x00ab, IOException -> 0x00a8, IllegalArgumentException -> 0x00a5, ExceptionInInitializerError -> 0x00a2, all -> 0x009f }
            if (r3 == 0) goto L_0x0088
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x00ab, IOException -> 0x00a8, IllegalArgumentException -> 0x00a5, ExceptionInInitializerError -> 0x00a2, all -> 0x009f }
            r5 = 1024(0x400, float:1.435E-42)
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00ab, IOException -> 0x00a8, IllegalArgumentException -> 0x00a5, ExceptionInInitializerError -> 0x00a2, all -> 0x009f }
            byte[] r0 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
        L_0x004f:
            int r5 = r4.read(r0)     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
            r6 = -1
            if (r5 == r6) goto L_0x005a
            r3.write(r0, r1, r5)     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
            goto L_0x004f
        L_0x005a:
            byte[] r0 = r3.toByteArray()     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
            if (r0 != 0) goto L_0x006c
            r4.close()     // Catch:{ IOException -> 0x0067 }
            r3.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r0 = move-exception
            r0.getMessage()
        L_0x006b:
            return r1
        L_0x006c:
            java.util.Properties r5 = r7.f8717de     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
            if (r5 == 0) goto L_0x007e
            java.util.Properties r5 = r7.f8717de     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
            byte[] r0 = fe.mmm.qw.j.vvv.fe.qw(r0)     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
            r6.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
            r5.load(r6)     // Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x0082, IllegalArgumentException -> 0x0080, ExceptionInInitializerError -> 0x00a3 }
        L_0x007e:
            r0 = r3
            goto L_0x0091
        L_0x0080:
            r0 = move-exception
            goto L_0x00cc
        L_0x0082:
            r0 = move-exception
            goto L_0x00e5
        L_0x0085:
            r0 = move-exception
            goto L_0x00fe
        L_0x0088:
            java.util.Properties r3 = r7.f8717de     // Catch:{ FileNotFoundException -> 0x00ab, IOException -> 0x00a8, IllegalArgumentException -> 0x00a5, ExceptionInInitializerError -> 0x00a2, all -> 0x009f }
            if (r3 == 0) goto L_0x0091
            java.util.Properties r3 = r7.f8717de     // Catch:{ FileNotFoundException -> 0x00ab, IOException -> 0x00a8, IllegalArgumentException -> 0x00a5, ExceptionInInitializerError -> 0x00a2, all -> 0x009f }
            r3.load(r4)     // Catch:{ FileNotFoundException -> 0x00ab, IOException -> 0x00a8, IllegalArgumentException -> 0x00a5, ExceptionInInitializerError -> 0x00a2, all -> 0x009f }
        L_0x0091:
            r4.close()     // Catch:{ IOException -> 0x009a }
            if (r0 == 0) goto L_0x009e
            r0.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r0 = move-exception
            r0.getMessage()
        L_0x009e:
            return r2
        L_0x009f:
            r1 = move-exception
            r3 = r0
            goto L_0x00b2
        L_0x00a2:
            r3 = r0
        L_0x00a3:
            r0 = r4
            goto L_0x00b6
        L_0x00a5:
            r2 = move-exception
            r3 = r0
            goto L_0x00cb
        L_0x00a8:
            r2 = move-exception
            r3 = r0
            goto L_0x00e4
        L_0x00ab:
            r2 = move-exception
            r3 = r0
            goto L_0x00fd
        L_0x00af:
            r1 = move-exception
            r3 = r0
            r4 = r3
        L_0x00b2:
            r0 = r1
            goto L_0x0114
        L_0x00b5:
            r3 = r0
        L_0x00b6:
            if (r0 == 0) goto L_0x00be
            r0.close()     // Catch:{ IOException -> 0x00bc }
            goto L_0x00be
        L_0x00bc:
            r0 = move-exception
            goto L_0x00c4
        L_0x00be:
            if (r3 == 0) goto L_0x00c7
            r3.close()     // Catch:{ IOException -> 0x00bc }
            goto L_0x00c7
        L_0x00c4:
            r0.getMessage()
        L_0x00c7:
            return r1
        L_0x00c8:
            r2 = move-exception
            r3 = r0
            r4 = r3
        L_0x00cb:
            r0 = r2
        L_0x00cc:
            r0.getMessage()     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x00d7
            r4.close()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00d7
        L_0x00d5:
            r0 = move-exception
            goto L_0x00dd
        L_0x00d7:
            if (r3 == 0) goto L_0x00e0
            r3.close()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00e0
        L_0x00dd:
            r0.getMessage()
        L_0x00e0:
            return r1
        L_0x00e1:
            r2 = move-exception
            r3 = r0
            r4 = r3
        L_0x00e4:
            r0 = r2
        L_0x00e5:
            r0.getMessage()     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x00f0
            r4.close()     // Catch:{ IOException -> 0x00ee }
            goto L_0x00f0
        L_0x00ee:
            r0 = move-exception
            goto L_0x00f6
        L_0x00f0:
            if (r3 == 0) goto L_0x00f9
            r3.close()     // Catch:{ IOException -> 0x00ee }
            goto L_0x00f9
        L_0x00f6:
            r0.getMessage()
        L_0x00f9:
            return r1
        L_0x00fa:
            r2 = move-exception
            r3 = r0
            r4 = r3
        L_0x00fd:
            r0 = r2
        L_0x00fe:
            r0.getMessage()     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x0109
            r4.close()     // Catch:{ IOException -> 0x0107 }
            goto L_0x0109
        L_0x0107:
            r0 = move-exception
            goto L_0x010f
        L_0x0109:
            if (r3 == 0) goto L_0x0112
            r3.close()     // Catch:{ IOException -> 0x0107 }
            goto L_0x0112
        L_0x010f:
            r0.getMessage()
        L_0x0112:
            return r1
        L_0x0113:
            r0 = move-exception
        L_0x0114:
            if (r4 == 0) goto L_0x011c
            r4.close()     // Catch:{ IOException -> 0x011a }
            goto L_0x011c
        L_0x011a:
            r1 = move-exception
            goto L_0x0122
        L_0x011c:
            if (r3 == 0) goto L_0x0125
            r3.close()     // Catch:{ IOException -> 0x011a }
            goto L_0x0125
        L_0x0122:
            r1.getMessage()
        L_0x0125:
            throw r0
        L_0x0126:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "mParameter 用来描述配置文件信息，不可为空"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.yj.ad.ad():boolean");
    }

    public File qw() throws IOException {
        File file = new File(this.f8716ad.de());
        file.mkdirs();
        File file2 = new File(file, this.f8716ad.qw());
        "config file=" + file2.getAbsolutePath() + "[" + file2.exists() + "]";
        if (!file2.exists()) {
            file2.createNewFile();
        }
        return file2;
    }

    public String toString() {
        IParameter iParameter = this.f8716ad;
        return iParameter == null ? StringUtil.NULL_STRING : iParameter.qw();
    }
}
