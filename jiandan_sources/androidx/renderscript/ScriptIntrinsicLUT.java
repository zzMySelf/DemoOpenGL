package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

public class ScriptIntrinsicLUT extends ScriptIntrinsic {
    public static final int INTRINSIC_API_LEVEL = 19;
    public final byte[] mCache = new byte[1024];
    public boolean mDirty = true;
    public final Matrix4f mMatrix = new Matrix4f();
    public Allocation mTables;

    public ScriptIntrinsicLUT(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static ScriptIntrinsicLUT create(RenderScript renderScript, Element element) {
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 19;
        ScriptIntrinsicLUT scriptIntrinsicLUT = new ScriptIntrinsicLUT(renderScript.nScriptIntrinsicCreate(3, element.getID(renderScript), z), renderScript);
        scriptIntrinsicLUT.setIncSupp(z);
        scriptIntrinsicLUT.mTables = Allocation.createSized(renderScript, Element.U8(renderScript), 1024);
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr = scriptIntrinsicLUT.mCache;
            byte b = (byte) i2;
            bArr[i2] = b;
            bArr[i2 + 256] = b;
            bArr[i2 + 512] = b;
            bArr[i2 + 768] = b;
        }
        scriptIntrinsicLUT.setVar(0, (BaseObj) scriptIntrinsicLUT.mTables);
        return scriptIntrinsicLUT;
    }

    private void validate(int i2, int i3) {
        if (i2 < 0 || i2 > 255) {
            throw new RSIllegalArgumentException("Index out of range (0-255).");
        } else if (i3 < 0 || i3 > 255) {
            throw new RSIllegalArgumentException("Value out of range (0-255).");
        }
    }

    public void forEach(Allocation allocation, Allocation allocation2) {
        if (this.mDirty) {
            this.mDirty = false;
            this.mTables.copyFromUnchecked(this.mCache);
        }
        forEach(0, allocation, allocation2, (FieldPacker) null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 3, (Element) null, (Element) null);
    }

    public void setAlpha(int i2, int i3) {
        validate(i2, i3);
        this.mCache[i2 + 768] = (byte) i3;
        this.mDirty = true;
    }

    public void setBlue(int i2, int i3) {
        validate(i2, i3);
        this.mCache[i2 + 512] = (byte) i3;
        this.mDirty = true;
    }

    public void setGreen(int i2, int i3) {
        validate(i2, i3);
        this.mCache[i2 + 256] = (byte) i3;
        this.mDirty = true;
    }

    public void setRed(int i2, int i3) {
        validate(i2, i3);
        this.mCache[i2] = (byte) i3;
        this.mDirty = true;
    }
}
