package com.otaliastudios.cameraview.engine.orchestrator;

import androidx.annotation.NonNull;

public enum CameraState {
    OFF(0),
    ENGINE(1),
    BIND(2),
    PREVIEW(3);
    
    public int mState;

    /* access modifiers changed from: public */
    CameraState(int i2) {
        this.mState = i2;
    }

    public boolean isAtLeast(@NonNull CameraState cameraState) {
        return this.mState >= cameraState.mState;
    }
}
