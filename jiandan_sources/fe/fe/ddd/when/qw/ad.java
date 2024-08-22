package fe.fe.ddd.when.qw;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogType;
import fe.fe.ddd.when.fe.th;
import fe.fe.ddd.when.yj.de;
import fe.fe.vvv.ad.qw.qw;
import java.io.File;

public class ad {
    public static void ad(@NonNull Context context) {
        try {
            Intent intent = new Intent();
            intent.setClass(context, LokiService.class);
            intent.putExtra("logtype", LogType.NONE);
            context.startService(intent);
        } catch (Exception e) {
            if (fe.fe.ddd.when.yj.ad.qw) {
                Log.getStackTraceString(e);
            }
        }
    }

    public static void de(@NonNull Context context, @NonNull LogType logType, @NonNull File file, @Nullable File file2, @Nullable LogExtra logExtra) {
        try {
            if (logType != LogType.NONE) {
                if (file.exists()) {
                    if (file.isFile()) {
                        rg(context, logType, (String) null, file, file2, logExtra);
                        return;
                    }
                }
                if (fe.fe.ddd.when.yj.ad.qw) {
                    throw new RuntimeException("basicDataFile should exist and be a file.");
                }
            } else if (fe.fe.ddd.when.yj.ad.qw) {
                throw new RuntimeException("logType should not be LogType.NONE");
            }
        } catch (Exception e) {
            if (fe.fe.ddd.when.yj.ad.qw) {
                Log.getStackTraceString(e);
            }
        }
    }

    public static void fe(@NonNull Context context, @NonNull LogType logType, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        try {
            if (logType == LogType.NONE) {
                if (fe.fe.ddd.when.yj.ad.qw) {
                    throw new RuntimeException("logType should not be LogType.NONE");
                }
            } else if (TextUtils.isEmpty(str)) {
                if (fe.fe.ddd.when.yj.ad.qw) {
                    throw new RuntimeException("basicData should no be null or length = 0");
                }
            } else if (str.length() > 25600) {
                boolean z = fe.fe.ddd.when.yj.ad.qw;
                th(context, logType, str, file, logExtra);
            } else {
                rg(context, logType, str, (File) null, file, logExtra);
            }
        } catch (Exception e) {
            if (fe.fe.ddd.when.yj.ad.qw) {
                Log.getStackTraceString(e);
            }
        }
    }

    public static void qw() {
    }

    public static void rg(@NonNull Context context, @NonNull LogType logType, @Nullable String str, @Nullable File file, @Nullable File file2, @Nullable LogExtra logExtra) {
        if (str != null || file != null) {
            Intent intent = new Intent();
            intent.setClass(context, LokiService.class);
            intent.putExtra("processname", qw.ad());
            intent.putExtra("logtype", logType);
            if (str != null) {
                intent.putExtra("logbasicdata", str);
            }
            if (file != null) {
                intent.putExtra("logbasicdatafile", file.getAbsolutePath());
            }
            if (logExtra != null) {
                intent.putExtra("logExtra", logExtra);
            }
            if (file2 != null) {
                String absolutePath = file2.getAbsolutePath();
                if (!TextUtils.isEmpty(absolutePath)) {
                    intent.putExtra("logextrapathnamekeeper", absolutePath);
                }
            }
            intent.putExtra("crash_TAG", fe.fe.ddd.when.fe.qw.qw());
            context.startService(intent);
        }
    }

    public static void th(@NonNull Context context, @NonNull LogType logType, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        File o2 = th.o(qw.ad());
        if (!o2.exists()) {
            o2.mkdirs();
        }
        File file2 = new File(o2, "pre_p_log_basicdata");
        if (de.qw(file2)) {
            de.mmm(file2, str);
            if (fe.fe.ddd.when.yj.ad.qw) {
                "basicData" + str;
                "logBasicFile = " + file2;
            }
            de(context, logType, file2, file, logExtra);
        }
    }
}
