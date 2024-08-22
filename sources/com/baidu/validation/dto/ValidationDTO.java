package com.baidu.validation.dto;

import com.baidu.validation.NoProguard;
import java.util.HashMap;

public class ValidationDTO implements NoProguard {
    public String ak;
    public boolean autoFinishPage = true;
    public HashMap<String, String> extraParams;
    public String scene;
    public String type;
}
