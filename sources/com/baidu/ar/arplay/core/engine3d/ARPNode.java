package com.baidu.ar.arplay.core.engine3d;

import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ARPNode implements IARPNode {

    /* renamed from: a  reason: collision with root package name */
    protected long f9038a = -1;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, ARPNode> f9039b;

    /* renamed from: c  reason: collision with root package name */
    protected Lock f9040c;

    public ARPNode() {
        b();
    }

    private void b() {
        this.f9040c = new ReentrantLock();
        nativeInit();
        this.f9039b = new HashMap<>();
    }

    private native void nativeInit();

    /* renamed from: a */
    public ARPNode getParentARPNode() {
        long j2 = this.f9038a;
        ARPNode aRPNode = null;
        if (j2 == -1) {
            return null;
        }
        long nativeGetParentNodePtr = nativeGetParentNodePtr(j2);
        String nativeGetName = nativeGetName(nativeGetParentNodePtr);
        HashMap<String, ARPNode> hashMap = this.f9039b;
        if (hashMap != null) {
            aRPNode = hashMap.get(nativeGetName);
        }
        if (aRPNode == null && nativeGetParentNodePtr != -1) {
            aRPNode = new ARPNode();
            aRPNode.bindInternal(nativeGetParentNodePtr);
            HashMap<String, ARPNode> hashMap2 = this.f9039b;
            if (hashMap2 != null) {
                hashMap2.put(nativeGetName, aRPNode);
            }
        }
        return aRPNode;
    }

    /* renamed from: a */
    public ARPNode getChildARPNode(String str) {
        ARPNode aRPNode = null;
        if (this.f9038a == -1) {
            return null;
        }
        HashMap<String, ARPNode> hashMap = this.f9039b;
        if (hashMap != null) {
            aRPNode = hashMap.get(str);
        }
        if (aRPNode == null) {
            long nativeGetChildNodeByName = nativeGetChildNodeByName(this.f9038a, str);
            if (nativeGetChildNodeByName != -1) {
                aRPNode = new ARPNode();
                aRPNode.bindInternal(nativeGetChildNodeByName);
                HashMap<String, ARPNode> hashMap2 = this.f9039b;
                if (hashMap2 != null) {
                    hashMap2.put(str, aRPNode);
                }
            }
        }
        return aRPNode;
    }

    public void bindInternal(long j2) {
        this.f9038a = j2;
    }

    public Vector3f getEulerAnges() {
        if (this.f9038a == -1) {
            return null;
        }
        this.f9040c.lock();
        float[] nativeGetEulerAngles = nativeGetEulerAngles(this.f9038a);
        this.f9040c.unlock();
        if (nativeGetEulerAngles == null || nativeGetEulerAngles.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetEulerAngles[0], nativeGetEulerAngles[1], nativeGetEulerAngles[2]);
        return vector3f;
    }

    public Matrixf4x4 getInitialTransform() {
        if (this.f9038a == -1) {
            return null;
        }
        this.f9040c.lock();
        float[] nativeInitialTransform = nativeInitialTransform(this.f9038a);
        this.f9040c.unlock();
        if (nativeInitialTransform == null || nativeInitialTransform.length < 16) {
            return new Matrixf4x4();
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrix(nativeInitialTransform);
        return matrixf4x4;
    }

    public String getName() {
        return nativeGetName(this.f9038a);
    }

    public Vector3f getPosition() {
        if (this.f9038a == -1) {
            return null;
        }
        this.f9040c.lock();
        float[] nativeGetPosition = nativeGetPosition(this.f9038a);
        this.f9040c.unlock();
        if (nativeGetPosition == null || nativeGetPosition.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetPosition[0], nativeGetPosition[1], nativeGetPosition[2]);
        return vector3f;
    }

    public Vector3f getRotateWorldAxis() {
        if (this.f9038a == -1) {
            return null;
        }
        this.f9040c.lock();
        float[] nativeGetRotateWorldAxis = nativeGetRotateWorldAxis(this.f9038a);
        this.f9040c.unlock();
        if (nativeGetRotateWorldAxis == null || nativeGetRotateWorldAxis.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetRotateWorldAxis[0], nativeGetRotateWorldAxis[1], nativeGetRotateWorldAxis[2]);
        return vector3f;
    }

    public Vector4f getRotation() {
        if (this.f9038a == -1) {
            return null;
        }
        this.f9040c.lock();
        float[] nativeGetRotation = nativeGetRotation(this.f9038a);
        this.f9040c.unlock();
        if (nativeGetRotation == null || nativeGetRotation.length < 4) {
            return new Vector4f();
        }
        Vector4f vector4f = new Vector4f();
        vector4f.setXYZW(nativeGetRotation[0], nativeGetRotation[1], nativeGetRotation[2], nativeGetRotation[3]);
        return vector4f;
    }

    public Vector3f getScale() {
        if (this.f9038a == -1) {
            return null;
        }
        this.f9040c.lock();
        float[] nativeGetScale = nativeGetScale(this.f9038a);
        this.f9040c.unlock();
        if (nativeGetScale == null || nativeGetScale.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetScale[0], nativeGetScale[1], nativeGetScale[2]);
        return vector3f;
    }

    public Matrixf4x4 getTransform() {
        if (this.f9038a == -1) {
            return null;
        }
        this.f9040c.lock();
        float[] nativeGetTransform = nativeGetTransform(this.f9038a);
        this.f9040c.unlock();
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        if (nativeGetTransform != null) {
            matrixf4x4.setMatrix(nativeGetTransform);
        }
        return matrixf4x4;
    }

    public Vector3f getWorldPosition() {
        if (this.f9038a == -1) {
            return null;
        }
        this.f9040c.lock();
        float[] nativeGetWorldPosition = nativeGetWorldPosition(this.f9038a);
        this.f9040c.unlock();
        if (nativeGetWorldPosition == null || nativeGetWorldPosition.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetWorldPosition[0], nativeGetWorldPosition[1], nativeGetWorldPosition[2]);
        return vector3f;
    }

    /* access modifiers changed from: package-private */
    public native long nativeGetChildNodeByName(long j2, String str);

    /* access modifiers changed from: package-private */
    public native float[] nativeGetEulerAngles(long j2);

    /* access modifiers changed from: package-private */
    public native String nativeGetName(long j2);

    /* access modifiers changed from: package-private */
    public native long nativeGetParentNodePtr(long j2);

    /* access modifiers changed from: package-private */
    public native float[] nativeGetPosition(long j2);

    /* access modifiers changed from: package-private */
    public native float[] nativeGetRotateWorldAxis(long j2);

    /* access modifiers changed from: package-private */
    public native float[] nativeGetRotation(long j2);

    /* access modifiers changed from: package-private */
    public native float[] nativeGetScale(long j2);

    /* access modifiers changed from: package-private */
    public native float[] nativeGetTransform(long j2);

    /* access modifiers changed from: package-private */
    public native float[] nativeGetWorldPosition(long j2);

    /* access modifiers changed from: package-private */
    public native float[] nativeInitialTransform(long j2);

    /* access modifiers changed from: package-private */
    public native void nativeSetEulerAngles(long j2, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetName(long j2, String str);

    /* access modifiers changed from: package-private */
    public native void nativeSetPosition(long j2, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetRotateWorldAxis(long j2, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetRotation(long j2, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetTransform(long j2, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetWorldPosition(long j2, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeUpdateUniform(long j2, String str, Object obj);

    public void setEulerAnges(Vector3f vector3f) {
        if (this.f9038a != -1 && vector3f != null) {
            this.f9040c.lock();
            nativeSetEulerAngles(this.f9038a, vector3f.toArray());
            this.f9040c.unlock();
        }
    }

    public void setName(String str) {
        long j2 = this.f9038a;
        if (j2 != -1) {
            nativeSetName(j2, str);
        }
    }

    public void setPosition(Vector3f vector3f) {
        if (this.f9038a != -1 && vector3f != null) {
            this.f9040c.lock();
            nativeSetPosition(this.f9038a, vector3f.toArray());
            this.f9040c.unlock();
        }
    }

    public void setRotateWorldAxis(Vector3f vector3f) {
        if (this.f9038a != -1 && vector3f != null) {
            this.f9040c.lock();
            nativeSetRotateWorldAxis(this.f9038a, vector3f.toArray());
            this.f9040c.unlock();
        }
    }

    public void setRotation(Vector4f vector4f) {
        if (this.f9038a != -1 && vector4f != null) {
            this.f9040c.lock();
            nativeSetRotation(this.f9038a, vector4f.toArray());
            this.f9040c.unlock();
        }
    }

    public void setTransform(Matrixf4x4 matrixf4x4) {
        if (this.f9038a != -1 && matrixf4x4 != null) {
            this.f9040c.lock();
            nativeSetTransform(this.f9038a, matrixf4x4.getMatrix());
            this.f9040c.unlock();
        }
    }

    public void setWorldPosition(Vector3f vector3f) {
        if (this.f9038a != -1 && vector3f != null) {
            this.f9040c.lock();
            nativeSetWorldPosition(this.f9038a, vector3f.toArray());
            this.f9040c.unlock();
        }
    }

    public void updateUniform(String str, Object obj) {
        nativeUpdateUniform(this.f9038a, str, obj);
    }
}
