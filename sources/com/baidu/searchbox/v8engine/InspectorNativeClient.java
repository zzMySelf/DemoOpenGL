package com.baidu.searchbox.v8engine;

public class InspectorNativeClient {
    private InspectorNativeChannel mChannel;
    private long mNativePtr;

    public InspectorNativeClient(long j2, InspectorNativeChannel inspectorNativeChannel) {
        this.mChannel = inspectorNativeChannel;
        this.mNativePtr = nativeInitInspector(j2, inspectorNativeChannel);
    }

    private native void nativeDestroyInspector(long j2);

    private native void nativeDispatchProtocolMessage(long j2, String str);

    private native long nativeInitInspector(long j2, InspectorNativeChannel inspectorNativeChannel);

    private native void nativeScheduleBreak(long j2);

    public void destroy() {
        nativeDestroyInspector(this.mNativePtr);
    }

    public void dispatchProtocolMessage(String str) {
        nativeDispatchProtocolMessage(this.mNativePtr, str);
    }

    public void scheduleBreak() {
        nativeScheduleBreak(this.mNativePtr);
    }
}
