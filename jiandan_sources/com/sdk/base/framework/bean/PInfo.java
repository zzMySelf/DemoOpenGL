package com.sdk.base.framework.bean;

import com.sdk.l.a;
import java.util.ArrayList;

public class PInfo {
    public String c;
    public ArrayList<String> imei;
    public String mac;
    public String n;
    public String os;

    public String getC() {
        return this.c;
    }

    public ArrayList<String> getImei() {
        return this.imei;
    }

    public String getMac() {
        return this.mac;
    }

    public String getN() {
        return this.n;
    }

    public String getOs() {
        return this.os;
    }

    public void setC(String str) {
        this.c = str;
    }

    public void setImei(ArrayList<String> arrayList) {
        this.imei = arrayList;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setN(String str) {
        this.n = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public String toString() {
        return a.a(this);
    }
}
