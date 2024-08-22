package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.Nullable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ClientCertChallenge extends URLAuthenticationChallenge {
    @Nullable
    public String[] keyTypes;
    @Nullable
    public Principal[] principals;

    public ClientCertChallenge(URLProtectionSpace uRLProtectionSpace, @Nullable Principal[] principalArr, @Nullable String[] strArr) {
        super(uRLProtectionSpace);
        this.principals = principalArr;
        this.keyTypes = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClientCertChallenge.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        ClientCertChallenge clientCertChallenge = (ClientCertChallenge) obj;
        if (!Arrays.equals(this.principals, clientCertChallenge.principals)) {
            return false;
        }
        return Arrays.equals(this.keyTypes, clientCertChallenge.keyTypes);
    }

    @Nullable
    public String[] getKeyTypes() {
        return this.keyTypes;
    }

    @Nullable
    public Principal[] getPrincipals() {
        return this.principals;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + Arrays.hashCode(this.principals)) * 31) + Arrays.hashCode(this.keyTypes);
    }

    public void setKeyTypes(@Nullable String[] strArr) {
        this.keyTypes = strArr;
    }

    public void setPrincipals(@Nullable Principal[] principalArr) {
        this.principals = principalArr;
    }

    public Map<String, Object> toMap() {
        ArrayList arrayList;
        List list = null;
        if (this.principals != null) {
            arrayList = new ArrayList();
            for (Principal name : this.principals) {
                arrayList.add(name.getName());
            }
        } else {
            arrayList = null;
        }
        Map<String, Object> map = super.toMap();
        map.put("androidPrincipals", arrayList);
        String[] strArr = this.keyTypes;
        if (strArr != null) {
            list = Arrays.asList(strArr);
        }
        map.put("androidKeyTypes", list);
        return map;
    }

    public String toString() {
        return "ClientCertChallenge{principals=" + Arrays.toString(this.principals) + ", keyTypes=" + Arrays.toString(this.keyTypes) + "} " + super.toString();
    }
}
