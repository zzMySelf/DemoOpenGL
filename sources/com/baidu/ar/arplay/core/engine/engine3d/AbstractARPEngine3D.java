package com.baidu.ar.arplay.core.engine.engine3d;

public abstract class AbstractARPEngine3D implements IARPEngine3D {
    protected boolean mIsActiveByARPlayVersionCase = false;

    public abstract /* synthetic */ void destroy();

    public abstract /* synthetic */ void pause();

    public abstract /* synthetic */ void resume();

    public void setIsActiveByARPlayVersionCase(boolean z) {
        this.mIsActiveByARPlayVersionCase = z;
    }
}
