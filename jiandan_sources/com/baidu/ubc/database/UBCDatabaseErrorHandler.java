package com.baidu.ubc.database;

import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.alipay.sdk.m.u.i;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import fe.fe.mmm.c;
import fe.fe.mmm.m;
import fe.fe.mmm.tt;
import java.io.File;

public class UBCDatabaseErrorHandler {

    /* renamed from: rg  reason: collision with root package name */
    public static final boolean f1127rg = tt.vvv();

    /* renamed from: ad  reason: collision with root package name */
    public int f1128ad;

    /* renamed from: de  reason: collision with root package name */
    public RepairStatus f1129de;

    /* renamed from: fe  reason: collision with root package name */
    public DefaultDatabaseErrorHandler f1130fe;
    public long qw;

    public enum RepairStatus {
        DEFAULT,
        FIRST_REPAIR,
        REPAIRED,
        REPAIR_FAIL
    }

    public static final class ad {
        public static final UBCDatabaseErrorHandler qw = new UBCDatabaseErrorHandler();
    }

    public static UBCDatabaseErrorHandler qw() {
        return ad.qw;
    }

    public void ad(SQLiteDatabase sQLiteDatabase) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f1128ad > 5) {
            boolean z = f1127rg;
        } else if (currentTimeMillis - this.qw < 60000) {
            boolean z2 = f1127rg;
        } else {
            boolean z3 = f1127rg;
            if (this.f1130fe == null) {
                this.f1130fe = new DefaultDatabaseErrorHandler();
            }
            String path = sQLiteDatabase.getPath();
            this.f1130fe.onCorruption(sQLiteDatabase);
            File file = new File(path);
            File file2 = new File(path + "-journal");
            File file3 = new File(path + "-shm");
            File file4 = new File(path + "-wal");
            StringBuilder sb = new StringBuilder();
            if (!file.exists() && !file2.exists() && !file3.exists() && !file4.exists()) {
                sb.append("delete all db file success");
            } else {
                sb.append("delete db file fail;");
                sb.append("delete db : ");
                sb.append(!file.exists());
                sb.append(i.b);
                sb.append("delete db-journal : ");
                sb.append(!file2.exists());
                sb.append(i.b);
                sb.append("delete db-shm : ");
                sb.append(!file3.exists());
                sb.append(i.b);
                sb.append("delete db-wal : ");
                sb.append(!file4.exists());
                sb.append(i.b);
            }
            this.qw = currentTimeMillis;
            this.f1128ad++;
            if (this.f1129de == RepairStatus.DEFAULT) {
                this.f1129de = RepairStatus.FIRST_REPAIR;
            } else {
                this.f1129de = RepairStatus.REPAIR_FAIL;
            }
            if (f1127rg) {
                sb.toString();
            }
            c.de().th(this.f1128ad, sb.toString());
            m.m128switch("times : " + this.f1128ad + "; msg : " + sb.toString(), EnumConstants$RunTime.DB_CORRUPT_REPAIRED);
        }
    }

    public void de(boolean z) {
        EnumConstants$RunTime enumConstants$RunTime;
        RepairStatus repairStatus = this.f1129de;
        if (repairStatus != RepairStatus.DEFAULT) {
            if (repairStatus == RepairStatus.FIRST_REPAIR) {
                this.f1129de = RepairStatus.REPAIRED;
                return;
            }
            if (f1127rg) {
                "db repair result : " + z;
            }
            c.de().yj(this.f1128ad - 1, z);
            String str = "times : " + this.f1128ad;
            if (z) {
                enumConstants$RunTime = EnumConstants$RunTime.DB_CORRUPT_REPAIRED_SUCCESS;
            } else {
                enumConstants$RunTime = EnumConstants$RunTime.DB_CORRUPT_REPAIRED_FAIL;
            }
            m.m128switch(str, enumConstants$RunTime);
            if (this.f1129de == RepairStatus.REPAIR_FAIL) {
                this.f1129de = RepairStatus.REPAIRED;
            } else {
                this.f1129de = RepairStatus.DEFAULT;
            }
        }
    }

    public UBCDatabaseErrorHandler() {
        this.qw = 0;
        this.f1128ad = 0;
        this.f1129de = RepairStatus.DEFAULT;
    }
}
