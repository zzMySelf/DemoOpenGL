package com.baidu.wallet.lightapp.business;

import java.io.Serializable;

public class LangbridgeBarParams implements Serializable {
    public int fullScreenActionBarColor = -1;
    public int fullScreenTitleColor = 0;
    public boolean isFullScreen = false;
    public boolean isHideHost = false;
    public boolean isHideTitle = false;
    public boolean isIconIsolate = false;
    public boolean isIconWhite = false;

    public boolean equals(LangbridgeBarParams langbridgeBarParams) {
        return langbridgeBarParams != null && langbridgeBarParams.isHideHost == this.isHideHost && langbridgeBarParams.fullScreenActionBarColor == this.fullScreenActionBarColor && langbridgeBarParams.isFullScreen == this.isFullScreen && langbridgeBarParams.isHideTitle == this.isHideTitle && langbridgeBarParams.fullScreenTitleColor == this.fullScreenTitleColor && langbridgeBarParams.isIconIsolate == this.isIconIsolate && langbridgeBarParams.isIconWhite == this.isIconWhite;
    }

    public void setFullScreen(boolean z) {
        this.isFullScreen = z;
    }

    public void setFullScreenActionBarColor(int i2) {
        this.fullScreenActionBarColor = i2;
    }

    public void setFullScreenTitleColor(int i2) {
        this.fullScreenTitleColor = i2;
    }

    public void setHideTitle(boolean z) {
        this.isHideTitle = z;
    }

    public void setIconIsolate(boolean z) {
        this.isIconIsolate = z;
    }

    public void setIconWhite(boolean z) {
        this.isIconWhite = z;
    }

    public void setValues(boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.isFullScreen = z;
        this.isHideTitle = z2;
        this.isIconWhite = z3;
        this.fullScreenActionBarColor = i2;
        this.fullScreenTitleColor = i3;
        this.isHideHost = z4;
    }
}
