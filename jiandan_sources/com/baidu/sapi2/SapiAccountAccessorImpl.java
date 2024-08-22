package com.baidu.sapi2;

public final class SapiAccountAccessorImpl extends ShareAccountAccessor {
    public String getExtra(SapiAccount sapiAccount) {
        return sapiAccount.extra;
    }

    public String getPtoken(SapiAccount sapiAccount) {
        return sapiAccount.ptoken;
    }

    public String getStoken(SapiAccount sapiAccount) {
        return sapiAccount.stoken;
    }

    public void setAccountPkg(SapiAccount sapiAccount, String str) {
        sapiAccount.setAccountPkg(str);
    }

    public void setExtra(SapiAccount sapiAccount, String str) {
        sapiAccount.extra = str;
    }

    public void setPtoken(SapiAccount sapiAccount, String str) {
        sapiAccount.ptoken = str;
    }

    public void setStoken(SapiAccount sapiAccount, String str) {
        sapiAccount.stoken = str;
    }

    public void updatePtoken(SapiAccount sapiAccount) {
        sapiAccount.updatePtoken();
    }

    public void updateSession(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        sapiAccount.updateSession(sapiAccount2);
    }
}
