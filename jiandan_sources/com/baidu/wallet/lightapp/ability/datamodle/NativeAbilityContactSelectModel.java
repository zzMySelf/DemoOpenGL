package com.baidu.wallet.lightapp.ability.datamodle;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
import java.util.List;

public class NativeAbilityContactSelectModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class AllContact implements NoProguard {
        public List<PhoneNumberUnit> list;
        public String name;

        public List<PhoneNumberUnit> getList() {
            return this.list;
        }

        public String getName() {
            return this.name;
        }

        public void setList(List<PhoneNumberUnit> list2) {
            this.list = list2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String toString() {
            return "AllContact [name=" + this.name + ", list=" + this.list + "]";
        }
    }

    public static class Data implements NoProguard {
        public String abc;
        public String aesall;
        public String aeskey;
        public List<AllContact> all;
        public String allCount;
        public String des = "";
        public String errCode = "";
        public SelectedContact selected = new SelectedContact();
    }

    public static class PhoneNumberUnit implements NoProguard {
        public String num = "";
    }

    public static class SelectedContact implements NoProguard {
        public String name = "";
        public String phone = "";
    }

    public NativeAbilityContactSelectModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public NativeAbilityContactSelectModel(int i2) {
        this();
        this.result = i2;
    }
}
