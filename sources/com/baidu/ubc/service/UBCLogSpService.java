package com.baidu.ubc.service;

import com.baidu.ubc.impl.UBCLogSpUtil;
import com.baidu.ubc.inter.IUBCLogSpService;
import java.util.Map;

public class UBCLogSpService implements IUBCLogSpService {
    public void putString(String key, String value) {
        UBCLogSpUtil.getInstance().putString(key, value);
    }

    public String getString(String key, String defValue) {
        return UBCLogSpUtil.getInstance().getString(key, defValue);
    }

    public Map<String, ?> getAll() {
        return UBCLogSpUtil.getInstance().getAll();
    }

    public void remove(String key) {
        UBCLogSpUtil.getInstance().remove(key);
    }

    public void clean() {
        UBCLogSpUtil.getInstance().clean();
    }
}
