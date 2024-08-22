package fe.vvv.qw.ggg;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import fe.vvv.qw.yj.fe.fe;

@RequiresApi(21)
public class rg extends th {
    public Integer ddd;
    public final ActionHolder ggg;
    public final Action ppp;
    public final boolean vvv;
    public Integer xxx;

    public class ad extends fe.vvv.qw.yj.fe.de {
        public ad(rg rgVar) {
        }

        public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            super.ad(actionHolder, captureRequest, totalCaptureResult);
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
            if (num == null) {
                yj.f8993uk.i("FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
                ppp(Integer.MAX_VALUE);
            } else if (num.intValue() == 3) {
                yj.f8993uk.de("FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
                ppp(Integer.MAX_VALUE);
            } else {
                yj.f8993uk.de("FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
            }
        }

        /* renamed from: switch  reason: not valid java name */
        public void m1033switch(@NonNull ActionHolder actionHolder) {
            super.m1047switch(actionHolder);
            yj.f8993uk.de("FlashAction:", "Parameters locked, opening torch.");
            actionHolder.rg(this).set(CaptureRequest.FLASH_MODE, 2);
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_MODE, 1);
            actionHolder.pf(this);
        }

        public /* synthetic */ ad(rg rgVar, qw qwVar) {
            this(rgVar);
        }
    }

    public class de extends fe.vvv.qw.yj.fe.de {
        public de() {
        }

        /* renamed from: switch  reason: not valid java name */
        public void m1034switch(@NonNull ActionHolder actionHolder) {
            super.m1047switch(actionHolder);
            try {
                yj.f8993uk.de("ResetFlashAction:", "Reverting the flash changes.");
                CaptureRequest.Builder rg2 = actionHolder.rg(this);
                rg2.set(CaptureRequest.CONTROL_AE_MODE, 1);
                rg2.set(CaptureRequest.FLASH_MODE, 0);
                actionHolder.o(this, rg2);
                rg2.set(CaptureRequest.CONTROL_AE_MODE, rg.this.xxx);
                rg2.set(CaptureRequest.FLASH_MODE, rg.this.ddd);
                actionHolder.pf(this);
            } catch (CameraAccessException unused) {
            }
        }

        public /* synthetic */ de(rg rgVar, qw qwVar) {
            this();
        }
    }

    public class qw extends fe {
        public qw() {
        }

        public void ad(@NonNull Action action) {
            yj.f8993uk.de("Taking picture with super.take().");
            rg.super.de();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rg(@androidx.annotation.NonNull fe.vvv.qw.fe.qw r7, @androidx.annotation.NonNull fe.vvv.qw.yj.ad r8, @androidx.annotation.NonNull com.otaliastudios.cameraview.preview.RendererCameraPreview r9, @androidx.annotation.NonNull fe.vvv.qw.xxx.qw r10) {
        /*
            r6 = this;
            com.otaliastudios.cameraview.overlay.Overlay r5 = r8.l1()
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            r6.ggg = r8
            r7 = 2
            fe.vvv.qw.yj.fe.de[] r9 = new fe.vvv.qw.yj.fe.de[r7]
            fe.vvv.qw.yj.rg.fe r10 = new fe.vvv.qw.yj.rg.fe
            r10.<init>()
            r0 = 2500(0x9c4, double:1.235E-320)
            fe.vvv.qw.yj.fe.de r10 = fe.vvv.qw.yj.fe.ad.ad(r0, r10)
            r0 = 0
            r9[r0] = r10
            fe.vvv.qw.ggg.rg$ad r10 = new fe.vvv.qw.ggg.rg$ad
            r1 = 0
            r10.<init>(r6, r1)
            r2 = 1
            r9[r2] = r10
            fe.vvv.qw.yj.fe.de r9 = fe.vvv.qw.yj.fe.ad.qw(r9)
            r6.ppp = r9
            fe.vvv.qw.ggg.rg$qw r10 = new fe.vvv.qw.ggg.rg$qw
            r10.<init>()
            r9.fe(r10)
            com.otaliastudios.cameraview.engine.action.ActionHolder r9 = r6.ggg
            com.otaliastudios.cameraview.engine.action.Action r10 = r6.ppp
            android.hardware.camera2.TotalCaptureResult r9 = r9.m714if(r10)
            if (r9 != 0) goto L_0x004f
            com.otaliastudios.cameraview.CameraLogger r10 = fe.vvv.qw.ggg.yj.f8993uk
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r3 = "Picture snapshot requested very early, before the first preview frame."
            r7[r0] = r3
            java.lang.String r3 = "Metering might not work as intended."
            r7[r2] = r3
            r10.i(r7)
        L_0x004f:
            if (r9 != 0) goto L_0x0052
            goto L_0x005b
        L_0x0052:
            android.hardware.camera2.CaptureResult$Key r7 = android.hardware.camera2.CaptureResult.CONTROL_AE_STATE
            java.lang.Object r7 = r9.get(r7)
            r1 = r7
            java.lang.Integer r1 = (java.lang.Integer) r1
        L_0x005b:
            boolean r7 = r8.u()
            if (r7 == 0) goto L_0x006b
            if (r1 == 0) goto L_0x006b
            int r7 = r1.intValue()
            r8 = 4
            if (r7 != r8) goto L_0x006b
            r0 = 1
        L_0x006b:
            r6.vvv = r0
            com.otaliastudios.cameraview.engine.action.ActionHolder r7 = r6.ggg
            com.otaliastudios.cameraview.engine.action.Action r8 = r6.ppp
            android.hardware.camera2.CaptureRequest$Builder r7 = r7.rg(r8)
            android.hardware.camera2.CaptureRequest$Key r8 = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE
            java.lang.Object r7 = r7.get(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            r6.xxx = r7
            com.otaliastudios.cameraview.engine.action.ActionHolder r7 = r6.ggg
            com.otaliastudios.cameraview.engine.action.Action r8 = r6.ppp
            android.hardware.camera2.CaptureRequest$Builder r7 = r7.rg(r8)
            android.hardware.camera2.CaptureRequest$Key r8 = android.hardware.camera2.CaptureRequest.FLASH_MODE
            java.lang.Object r7 = r7.get(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            r6.ddd = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.ggg.rg.<init>(fe.vvv.qw.fe$qw, fe.vvv.qw.yj.ad, com.otaliastudios.cameraview.preview.RendererCameraPreview, fe.vvv.qw.xxx.qw):void");
    }

    public void ad() {
        new de(this, (qw) null).yj(this.ggg);
        super.ad();
    }

    public void de() {
        if (!this.vvv) {
            yj.f8993uk.de("take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.de();
            return;
        }
        yj.f8993uk.de("take:", "Engine needs flash. Starting action");
        this.ppp.yj(this.ggg);
    }
}
