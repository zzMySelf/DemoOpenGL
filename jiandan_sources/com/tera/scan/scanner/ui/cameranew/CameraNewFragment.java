package com.tera.scan.scanner.ui.cameranew;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.frame.FrameProcessor;
import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import com.tera.scan.framework.kernel.architecture.ui.BaseFragment;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.tt.rg.ad.de;
import fe.mmm.qw.tt.rg.ad.i;
import fe.mmm.qw.tt.rg.ad.rg;
import fe.vvv.qw.fe;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002DEB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0015J\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\"J\b\u0010#\u001a\u00020$H\u0002J&\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020$H\u0016J\b\u0010-\u001a\u00020$H\u0016J\u001a\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0016J\u0006\u00103\u001a\u00020\u0015J\u0012\u00104\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u0015J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020 J\u000e\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\u0015J\u0006\u0010A\u001a\u00020$J\u0006\u0010B\u001a\u00020$J\u000e\u0010C\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/tera/scan/scanner/ui/cameranew/CameraNewFragment;", "Lcom/tera/scan/framework/kernel/architecture/ui/BaseFragment;", "Lcom/otaliastudios/cameraview/frame/FrameProcessor;", "()V", "cameraListener", "Lcom/tera/scan/scanner/ui/cameranew/CameraNewFragment$CameraEventListener;", "cameraView", "Lcom/otaliastudios/cameraview/CameraView;", "focusIndicatorView", "Lcom/tera/scan/scanner/ui/cameranew/FocusIndicatorView;", "from", "", "pictureListener", "Lcom/tera/scan/scanner/ui/cameranew/CameraNewFragment$IPictureListener;", "getPictureListener", "()Lcom/tera/scan/scanner/ui/cameranew/CameraNewFragment$IPictureListener;", "setPictureListener", "(Lcom/tera/scan/scanner/ui/cameranew/CameraNewFragment$IPictureListener;)V", "rootView", "Landroid/view/View;", "showFocusIndicator", "", "getShowFocusIndicator", "()Z", "setShowFocusIndicator", "(Z)V", "sizeSelector", "Lcom/tera/scan/scanner/ui/cameranew/CameraSizeSelector;", "takePicFg", "getCameraSizeSelector", "getFlash", "getPictureSize", "Lcom/otaliastudios/cameraview/size/Size;", "getSupportPictureSizes", "", "initData", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onViewCreated", "view", "process", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "restoreDefaultPictureSize", "setCameraListener", "setFlash", "on", "setHeightParams", "layoutWHParams", "", "setPictureSize", "size", "setPreviewZoom", "zoom", "", "showGrid", "show", "takePicture", "takePictureSnapshot", "updateCurrentFrom", "CameraEventListener", "IPictureListener", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("CameraNewFragment")
public final class CameraNewFragment extends BaseFragment implements FrameProcessor {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final qw cameraListener = new qw();
    @Nullable
    public CameraView cameraView;
    @Nullable
    public FocusIndicatorView focusIndicatorView;
    @NotNull
    public String from = "";
    @Nullable
    public IPictureListener pictureListener;
    @Nullable
    public View rootView;
    public boolean showFocusIndicator = true;
    @NotNull
    public final i sizeSelector = new i((fe.vvv.qw.xxx.ad) null, 1, (DefaultConstructorMarker) null);
    @Nullable
    public View takePicFg;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/tera/scan/scanner/ui/cameranew/CameraNewFragment$IPictureListener;", "", "onCameraOpened", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "onPicturePreview", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "width", "", "height", "onPictureTaken", "result", "Lcom/otaliastudios/cameraview/PictureResult;", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IPictureListener {
        void ad(@NotNull fe.vvv.qw.ad adVar);

        void de(@NotNull fe feVar);

        void qw(@NotNull fe.vvv.qw.o.qw qwVar, int i2, int i3);
    }

    public static final class ad extends fe.vvv.qw.qw {
        public final /* synthetic */ CameraNewFragment qw;

        public ad(CameraNewFragment cameraNewFragment) {
            this.qw = cameraNewFragment;
        }

        /* renamed from: switch  reason: not valid java name */
        public static final void m913switch(View view) {
            Intrinsics.checkNotNullParameter(view, "$it");
            view.setVisibility(8);
        }

        public void rg(@NotNull fe.vvv.qw.ad adVar) {
            Intrinsics.checkNotNullParameter(adVar, "options");
            super.rg(adVar);
            IPictureListener pictureListener = this.qw.getPictureListener();
            if (pictureListener != null) {
                pictureListener.ad(adVar);
            }
        }

        public void uk(@NotNull fe feVar) {
            Intrinsics.checkNotNullParameter(feVar, "result");
            View access$getTakePicFg$p = this.qw.takePicFg;
            if (access$getTakePicFg$p != null) {
                access$getTakePicFg$p.setVisibility(0);
                access$getTakePicFg$p.postDelayed(new fe.mmm.qw.tt.rg.ad.qw(access$getTakePicFg$p), 180);
            }
            IPictureListener pictureListener = this.qw.getPictureListener();
            if (pictureListener != null) {
                pictureListener.de(feVar);
            }
        }
    }

    public final class qw extends fe.vvv.qw.qw {
        @Nullable

        /* renamed from: ad  reason: collision with root package name */
        public Boolean f7329ad;

        /* renamed from: de  reason: collision with root package name */
        public float f7330de;
        public long qw;

        public qw() {
        }

        /* renamed from: switch  reason: not valid java name */
        public static final void m914switch(CameraNewFragment cameraNewFragment, PointF pointF) {
            FocusIndicatorView access$getFocusIndicatorView$p;
            Intrinsics.checkNotNullParameter(cameraNewFragment, "this$0");
            Intrinsics.checkNotNullParameter(pointF, "$point");
            if (cameraNewFragment.getShowFocusIndicator() && (access$getFocusIndicatorView$p = cameraNewFragment.focusIndicatorView) != null) {
                access$getFocusIndicatorView$p.show(pointF, cameraNewFragment.rootView);
            }
        }

        public void ad(@NotNull PointF pointF) {
            Intrinsics.checkNotNullParameter(pointF, "point");
            super.ad(pointF);
            FragmentActivity activity = CameraNewFragment.this.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new rg(CameraNewFragment.this, pointF));
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m915if(float f, @NotNull float[] fArr, @Nullable PointF[] pointFArr) {
            Intrinsics.checkNotNullParameter(fArr, "bounds");
            super.m1039if(f, fArr, pointFArr);
            boolean z = true;
            LoggerKt.v$default("Zoom changed: " + f, (Object) null, 1, (Object) null);
            if (f <= this.f7330de) {
                z = false;
            }
            this.f7330de = f;
            if (!Intrinsics.areEqual((Object) this.f7329ad, (Object) Boolean.valueOf(z)) && fe.mmm.qw.j.i.ad() - this.qw >= 1000) {
                this.f7329ad = Boolean.valueOf(z);
                this.qw = fe.mmm.qw.j.i.ad();
            }
        }
    }

    private final void initData() {
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            if (fe.mmm.qw.i.qw.o()) {
                CameraLogger.th(3);
                CameraLogger.rg(de.qw);
            }
            cameraView2.setUseDeviceOrientation(false);
            cameraView2.setPictureSize(this.sizeSelector);
            cameraView2.addCameraListener(new ad(this));
            cameraView2.setUseDeviceOrientation(false);
            cameraView2.setFrameProcessingFormat(35);
            cameraView2.addFrameProcessor(this);
            LoggerKt.d$default("initData", (Object) null, 1, (Object) null);
        }
    }

    /* renamed from: initData$lambda-1  reason: not valid java name */
    public static final void m912initData$lambda1(int i2, String str, String str2, Throwable th2) {
        Intrinsics.checkNotNullParameter(str, CustomListAdapter.VIEW_TAG);
        Intrinsics.checkNotNullParameter(str2, "message");
        LoggerKt.d$default("CameraLogger " + str2, (Object) null, 1, (Object) null);
    }

    private final void setCameraListener(CameraView cameraView2) {
        if (cameraView2 != null) {
            cameraView2.addCameraListener(this.cameraListener);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @NotNull
    public final i getCameraSizeSelector() {
        return this.sizeSelector;
    }

    public final boolean getFlash() {
        CameraView cameraView2 = this.cameraView;
        return (cameraView2 != null ? cameraView2.getFlash() : null) == Flash.TORCH;
    }

    @Nullable
    public final IPictureListener getPictureListener() {
        return this.pictureListener;
    }

    @Nullable
    public final fe.vvv.qw.xxx.ad getPictureSize() {
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            return cameraView2.getPictureSize();
        }
        return null;
    }

    public final boolean getShowFocusIndicator() {
        return this.showFocusIndicator;
    }

    @Nullable
    public final Collection<fe.vvv.qw.xxx.ad> getSupportPictureSizes() {
        fe.vvv.qw.ad cameraOptions;
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null || (cameraOptions = cameraView2.getCameraOptions()) == null) {
            return null;
        }
        return cameraOptions.o();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.bd_ocr_fragment_camera_new, viewGroup, false);
        this.rootView = inflate;
        return inflate;
    }

    public void onDestroy() {
        LoggerKt.d$default("onDestroy", (Object) null, 1, (Object) null);
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            cameraView2.removeFrameProcessor(this);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            cameraView2.removeCameraListener(this.cameraListener);
        }
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.cameraView = (CameraView) view.findViewById(R.id.camera_view);
        this.takePicFg = view.findViewById(R.id.take_pic_fg);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.focusIndicatorView = new FocusIndicatorView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            cameraView2.setLifecycleOwner(this);
        }
        Bundle arguments = getArguments();
        boolean z = false;
        showGrid(arguments != null ? arguments.getBoolean("show_grid") : false);
        Bundle arguments2 = getArguments();
        if (arguments2 != null && arguments2.getBoolean("is_fit_camera_size")) {
            z = true;
        }
        if (z) {
            setHeightParams(-2);
        }
        setCameraListener(this.cameraView);
        initData();
    }

    public void process(@NotNull fe.vvv.qw.o.qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "frame");
        CameraView cameraView2 = this.cameraView;
        int i2 = 0;
        int measuredWidth = cameraView2 != null ? cameraView2.getMeasuredWidth() : 0;
        CameraView cameraView3 = this.cameraView;
        if (cameraView3 != null) {
            i2 = cameraView3.getMeasuredHeight();
        }
        IPictureListener iPictureListener = this.pictureListener;
        if (iPictureListener != null) {
            iPictureListener.qw(qwVar, measuredWidth, i2);
        }
    }

    public final boolean restoreDefaultPictureSize() {
        if (this.sizeSelector.de()) {
            return false;
        }
        this.sizeSelector.fe();
        try {
            CameraView cameraView2 = this.cameraView;
            if (cameraView2 == null) {
                return true;
            }
            cameraView2.close();
            cameraView2.open();
            return true;
        } catch (Exception unused) {
            o.rg(R.string.zxing_camera_failed);
            return false;
        }
    }

    public final void setFlash(boolean z) {
        CameraView cameraView2;
        CameraView cameraView3;
        LoggerKt.d$default("setFlash " + z, (Object) null, 1, (Object) null);
        if (z && (cameraView3 = this.cameraView) != null) {
            cameraView3.setFlash(Flash.TORCH);
        }
        if (!z && (cameraView2 = this.cameraView) != null) {
            cameraView2.setFlash(Flash.OFF);
        }
    }

    public final void setHeightParams(int i2) {
        CameraView cameraView2 = this.cameraView;
        ViewGroup.LayoutParams layoutParams = cameraView2 != null ? cameraView2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = i2;
        }
        CameraView cameraView3 = this.cameraView;
        if (cameraView3 != null) {
            cameraView3.setLayoutParams(layoutParams);
        }
    }

    public final void setPictureListener(@Nullable IPictureListener iPictureListener) {
        this.pictureListener = iPictureListener;
    }

    public final boolean setPictureSize(@NotNull fe.vvv.qw.xxx.ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "size");
        fe.vvv.qw.xxx.ad pictureSize = getPictureSize();
        if ((pictureSize != null && pictureSize.rg() == adVar.rg()) && pictureSize.fe() == adVar.fe()) {
            return false;
        }
        this.sizeSelector.th(adVar);
        try {
            CameraView cameraView2 = this.cameraView;
            if (cameraView2 != null) {
                cameraView2.close();
                cameraView2.open();
            }
            return true;
        } catch (Exception unused) {
            o.rg(R.string.zxing_camera_failed);
            return false;
        }
    }

    public final void setPreviewZoom(float f) {
        CameraView cameraView2;
        Float f2 = null;
        LoggerKt.d$default("setPreviewZoom zoom== " + f, (Object) null, 1, (Object) null);
        if (f >= 0.0f && f <= 1.0f) {
            CameraView cameraView3 = this.cameraView;
            if (cameraView3 != null) {
                f2 = Float.valueOf(cameraView3.getZoom());
            }
            if (!Intrinsics.areEqual(f2, f) && (cameraView2 = this.cameraView) != null) {
                cameraView2.setZoom(f);
            }
        }
    }

    public final void setShowFocusIndicator(boolean z) {
        this.showFocusIndicator = z;
    }

    public final void showGrid(boolean z) {
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            cameraView2.setGrid(z ? Grid.DRAW_3X3 : Grid.OFF);
        }
    }

    public final void takePicture() {
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            cameraView2.takePicture();
        }
    }

    public final void takePictureSnapshot() {
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            cameraView2.takePictureSnapshot();
        }
    }

    public final void updateCurrentFrom(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "from");
        this.from = str;
    }
}
