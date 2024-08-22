package com.yy.mediaframework.inteligence.dynamictexture;

public interface IDynamicTexture {
    int getDynamicTextureId();

    void onDoFrame();

    void onRelease();
}
