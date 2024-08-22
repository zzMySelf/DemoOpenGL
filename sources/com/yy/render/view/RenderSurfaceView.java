package com.yy.render.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.yy.render.IRemoteRender;
import com.yy.render.RenderEngine;
import com.yy.render.util.RLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0017J\u0012\u0010\"\u001a\u00020 2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\fJ\u000e\u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020\fJ\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0017J\u0010\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u0017R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/yy/render/view/RenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isKeyEvent", "", "isSendAddContentView", "isSendSurfaceChange", "isSendSurfaceCreate", "isSetRemoteSend", "isTouch", "mHandler", "Landroid/os/Handler;", "mHolder", "Landroid/view/SurfaceHolder;", "mRenderViewFullName", "", "mSurface", "Landroid/view/Surface;", "mSurfaceFormat", "mSurfaceHeight", "mSurfaceWidth", "remote", "Lcom/yy/render/IRemoteRender;", "clearRemote", "", "getChannelId", "init", "isConsumeKeyEvent", "flag", "isConsumeTouchEvent", "sendDataToView", "data", "setRemote", "remoteTmp", "setRenderViewFullName", "name", "render_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RenderSurfaceView.kt */
public final class RenderSurfaceView extends SurfaceView {
    private boolean isKeyEvent = true;
    private volatile boolean isSendAddContentView;
    /* access modifiers changed from: private */
    public volatile boolean isSendSurfaceChange;
    /* access modifiers changed from: private */
    public volatile boolean isSendSurfaceCreate;
    /* access modifiers changed from: private */
    public volatile boolean isSetRemoteSend;
    private boolean isTouch = true;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public SurfaceHolder mHolder;
    /* access modifiers changed from: private */
    public String mRenderViewFullName;
    /* access modifiers changed from: private */
    public Surface mSurface;
    /* access modifiers changed from: private */
    public int mSurfaceFormat;
    /* access modifiers changed from: private */
    public int mSurfaceHeight;
    /* access modifiers changed from: private */
    public int mSurfaceWidth;
    /* access modifiers changed from: private */
    public IRemoteRender remote;

    public static final /* synthetic */ Handler access$getMHandler$p(RenderSurfaceView $this) {
        Handler handler = $this.mHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        }
        return handler;
    }

    public RenderSurfaceView(Context context) {
        super(context);
        init(context);
    }

    public RenderSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RenderSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private final void init(Context context) {
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mHandler = new Handler(Looper.getMainLooper());
        SurfaceHolder holder = getHolder();
        if (holder != null) {
            holder.addCallback(new RenderSurfaceView$init$1(this));
        }
    }

    public final void isConsumeTouchEvent(boolean flag) {
        this.isTouch = flag;
    }

    public final void isConsumeKeyEvent(boolean flag) {
        this.isKeyEvent = flag;
    }

    public final void setRemote(IRemoteRender remoteTmp) {
        this.remote = remoteTmp;
        RLog.Companion.i("(setRemote) isSetRemoteSend: " + this.isSetRemoteSend + ", " + "isSendSurfaceCreate: " + this.isSendSurfaceCreate + ", surface: " + this.mSurface + ", channelId: " + getChannelId() + "remote: " + this.remote + ", isSendSurfaceChange: " + this.isSendSurfaceChange);
        if (this.mSurface != null) {
            if (!this.isSendSurfaceCreate) {
                try {
                    IRemoteRender iRemoteRender = this.remote;
                    if (iRemoteRender != null) {
                        iRemoteRender.surfaceCreated(getChannelId(), this.mSurface, this.mRenderViewFullName);
                    }
                } catch (Exception e2) {
                    RLog.Companion.e("setRemote surfaceCreated ex: " + e2.getMessage());
                }
            }
            if (!this.isSendSurfaceChange) {
                try {
                    IRemoteRender iRemoteRender2 = this.remote;
                    if (iRemoteRender2 != null) {
                        iRemoteRender2.surfaceChanged(getChannelId(), this.mSurface, this.mRenderViewFullName, this.mSurfaceFormat, this.mSurfaceWidth, this.mSurfaceHeight);
                    }
                } catch (Exception e3) {
                    RLog.Companion.e("setRemote surfaceChanged ex: " + e3.getMessage());
                }
            }
        }
        if (!this.isSendAddContentView) {
            try {
                RLog.Companion.e("addContentView send data to remote " + getChannelId());
                IRemoteRender iRemoteRender3 = this.remote;
                if (iRemoteRender3 != null) {
                    iRemoteRender3.addContentView(getChannelId(), this.mRenderViewFullName);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.isSendAddContentView = true;
        }
    }

    public final void clearRemote() {
        this.isSendSurfaceChange = false;
        this.isSendSurfaceCreate = false;
        this.isSendAddContentView = false;
        IRemoteRender iRemoteRender = null;
        this.remote = null;
    }

    public final String getChannelId() {
        return String.valueOf(hashCode());
    }

    public final void sendDataToView(String data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        RenderEngine.Companion.getInstance().sendData2View(getChannelId(), data);
    }

    public final void setRenderViewFullName(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.mRenderViewFullName = name;
    }
}
