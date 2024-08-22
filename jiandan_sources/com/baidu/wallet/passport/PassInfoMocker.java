package com.baidu.wallet.passport;

import android.os.Bundle;
import com.baidu.wallet.core.NoProguard;

public class PassInfoMocker implements NoProguard {
    public String mMockedBduss;
    public String mMockedOpenBduss;
    public String mMockedStoken;

    public static class a {
        public static PassInfoMocker a = new PassInfoMocker();
    }

    public static PassInfoMocker getInstance() {
        return a.a;
    }

    public String getMockedBduss() {
        return null;
    }

    public String getMockedOpenBduss() {
        return null;
    }

    public String getMockedStoken() {
        return null;
    }

    public void setMockedPassInfo(Bundle bundle) {
    }

    public PassInfoMocker() {
    }
}
