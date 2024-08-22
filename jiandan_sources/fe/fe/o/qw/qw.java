package fe.fe.o.qw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

public class qw {
    public static String ad(ConcurrentHashMap concurrentHashMap, int i2, long j, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            sb.append("THREAD:" + ((Integer) entry.getKey()) + StringUtils.LF);
            sb.append("DATA:" + ((String) entry.getValue()) + StringUtils.LF);
        }
        sb.append("md:" + i2 + StringUtils.LF);
        sb.append("dft:" + j + StringUtils.LF);
        sb.append("expn:" + str + StringUtils.LF);
        sb.append("qid:" + str2 + StringUtils.LF);
        sb.append("buid task time:" + System.currentTimeMillis() + StringUtils.LF);
        return sb.toString();
    }

    public static String qw(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n retrytag: \n");
        sb.append("url:" + str + StringUtils.LF);
        sb.append("rs:" + str2 + StringUtils.LF);
        sb.append("h:" + str3 + StringUtils.LF);
        return sb.toString();
    }
}
