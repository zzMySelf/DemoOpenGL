package com.baidu.ar.arplay.core.engine3d;

import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import java.util.HashMap;

public class ARPScene implements IARPScene {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, ARPNode> f9041a;

    /* renamed from: b  reason: collision with root package name */
    private long f9042b = -1;

    public ARPScene() {
        a();
    }

    private IARPNode a(long j2) {
        String nativeGetNodeName = nativeGetNodeName(j2);
        ARPNode aRPNode = this.f9041a.get(nativeGetNodeName);
        if (aRPNode != null) {
            return aRPNode;
        }
        ARPNode aRPNode2 = new ARPNode();
        aRPNode2.bindInternal(j2);
        this.f9041a.put(nativeGetNodeName, aRPNode2);
        return aRPNode2;
    }

    private void a() {
        this.f9041a = new HashMap<>();
    }

    public IARPCamera getActiveCamera() {
        long nativeGetActiveCamera = nativeGetActiveCamera(this.f9042b);
        ARPCamera aRPCamera = new ARPCamera();
        aRPCamera.bindInternal(nativeGetActiveCamera);
        return aRPCamera;
    }

    public String getName(long j2) {
        return nativeGetName(j2);
    }

    public IARPNode getNodeByName(String str) {
        long j2 = this.f9042b;
        if (j2 == -1) {
            return null;
        }
        return a(nativeGetNodeByName(j2, str));
    }

    public IARPNode getRootNode() {
        long j2 = this.f9042b;
        if (j2 == -1) {
            return null;
        }
        return a(nativeGetRootNode(j2));
    }

    /* access modifiers changed from: package-private */
    public native long nativeGetActiveCamera(long j2);

    /* access modifiers changed from: package-private */
    public native String nativeGetName(long j2);

    /* access modifiers changed from: package-private */
    public native long nativeGetNodeByName(long j2, String str);

    /* access modifiers changed from: package-private */
    public native String nativeGetNodeName(long j2);

    /* access modifiers changed from: package-private */
    public native long nativeGetRootNode(long j2);

    /* access modifiers changed from: package-private */
    public native void nativeRelocate(long j2);

    /* access modifiers changed from: package-private */
    public native float[] nativeSceneProject(long j2, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetOffScreenGuideWork(long j2, boolean z);

    /* access modifiers changed from: package-private */
    public native void nativeSetVisible(long j2, boolean z);

    public void relocate() {
        long j2 = this.f9042b;
        if (j2 != -1) {
            nativeRelocate(j2);
        }
    }

    public float[] sceneProject(float[] fArr) {
        long j2 = this.f9042b;
        if (j2 == -1) {
            return null;
        }
        return nativeSceneProject(j2, fArr);
    }

    public void setInternal(long j2) {
        this.f9042b = j2;
    }

    public void setOffScreenGuideWork(boolean z) {
        long j2 = this.f9042b;
        if (j2 != -1) {
            nativeSetOffScreenGuideWork(j2, z);
        }
    }

    public boolean setVisible(boolean z) {
        long j2 = this.f9042b;
        if (j2 == -1) {
            return false;
        }
        nativeSetVisible(j2, z);
        return true;
    }
}
