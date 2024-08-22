package fe.nn.qw.th;

import com.tekartik.sqflite.operation.Operation;
import fe.nn.qw.fe;
import java.util.HashMap;
import java.util.Map;

public class th {
    public static Map<String, Object> qw(Operation operation) {
        fe de2 = operation.de();
        if (de2 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sql", de2.rg());
        hashMap.put("arguments", de2.fe());
        return hashMap;
    }
}
