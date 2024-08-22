package com.tera.scan.flutter.plugin.caller;

import androidx.annotation.Keep;
import java.util.HashMap;

@Keep
public interface OfflineH5ApiGen {
    HashMap<String, Object> getOfflineH5Info(String str);
}
