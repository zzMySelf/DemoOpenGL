package fe.fe.ddd.fe.qw;

import com.baidu.searchbox.config.AppConfig;

public class fe {
    public static final boolean qw = AppConfig.rg();

    public static String qw() {
        return qw ? "http://10.104.73.35:8098/fetchlog/getbostoken" : "https://mbd.baidu.com/fetchlog/getbostoken";
    }
}
