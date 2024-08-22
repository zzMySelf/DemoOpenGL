package com.baidu.ubc.inter;

import java.util.Map;

public interface IUBCLogIdSpService {
    boolean clean();

    Map<String, ?> getAll();

    void putLong(String str, long j);
}
