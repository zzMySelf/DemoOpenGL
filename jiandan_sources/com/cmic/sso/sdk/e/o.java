package com.cmic.sso.sdk.e;

import java.text.SimpleDateFormat;
import java.util.Date;

public class o {
    public static String a() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    }
}
