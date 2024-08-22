package cn.com.mma.mobile.tracking.util.klog;

import android.util.Log;

public class BaseLog {
    private static final int MAX_LENGTH = 4000;

    public static void printDefault(int type, String tag, String msg) {
        int index = 0;
        int length = msg.length();
        int countOfSub = length / 4000;
        if (countOfSub > 0) {
            for (int i2 = 0; i2 < countOfSub; i2++) {
                printSub(type, tag, msg.substring(index, index + 4000));
                index += 4000;
            }
            printSub(type, tag, msg.substring(index, length));
            return;
        }
        printSub(type, tag, msg);
    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case 1:
                Log.v(tag, sub);
                return;
            case 2:
                Log.d(tag, sub);
                return;
            case 3:
                Log.i(tag, sub);
                return;
            case 4:
                Log.w(tag, sub);
                return;
            case 5:
                Log.e(tag, sub);
                return;
            case 6:
                Log.wtf(tag, sub);
                return;
            default:
                return;
        }
    }
}
