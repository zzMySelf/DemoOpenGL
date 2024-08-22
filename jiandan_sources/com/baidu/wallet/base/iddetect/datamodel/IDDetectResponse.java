package com.baidu.wallet.base.iddetect.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;

public class IDDetectResponse implements IBeanResponse {
    public String address;
    public String birth;
    public String id_card;
    public String name;
    public String nation;
    public String sex;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }

    public String toString() {
        return "name:" + this.name + "number" + this.id_card;
    }
}
