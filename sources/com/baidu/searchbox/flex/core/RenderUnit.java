package com.baidu.searchbox.flex.core;

import android.content.Context;

public abstract class RenderUnit<MOUNT_CONTENT> {
    private final RenderType mRenderType;

    public enum RenderType {
        DRAWABLE,
        VIEW
    }

    public abstract MOUNT_CONTENT createContent(Context context);

    public abstract long getId();

    public RenderUnit(RenderType renderType) {
        this.mRenderType = renderType;
    }
}
