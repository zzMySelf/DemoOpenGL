package com.baidu.wallet.core.utils.contacts;

public class ContractInfo {
    public String a = "";
    public String b = "";
    public int c = -1;

    public ContractInfo() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContractInfo.class != obj.getClass()) {
            return false;
        }
        ContractInfo contractInfo = (ContractInfo) obj;
        String str = this.b;
        if (str == null) {
            if (contractInfo.b != null) {
                return false;
            }
        } else if (!str.equals(contractInfo.b)) {
            return false;
        }
        String str2 = this.a;
        if (str2 == null) {
            if (contractInfo.a != null) {
                return false;
            }
        } else if (!str2.equals(contractInfo.a)) {
            return false;
        }
        return true;
    }

    public int getErrordigit() {
        return this.c;
    }

    public String getMobile() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    public int hashCode() {
        String str = this.b;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.a;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public void setErrordigit(int i2) {
        this.c = i2;
    }

    public void setMobile(String str) {
        this.b = str;
    }

    public void setName(String str) {
        this.a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.a + ", mobile=" + this.b + "]";
    }

    public ContractInfo(String str) {
        this.b = str;
        this.a = "";
    }

    public ContractInfo(String str, String str2) {
        this.b = str;
        this.a = str2;
    }
}
