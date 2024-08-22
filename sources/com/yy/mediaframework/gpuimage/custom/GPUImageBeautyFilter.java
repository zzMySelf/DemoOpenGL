package com.yy.mediaframework.gpuimage.custom;

import android.opengl.GLES20;
import android.util.Log;
import com.yy.mediaframework.gpuimage.GPUImageFilter;
import com.yy.mediaframework.gpuimage.IFilterParams;
import com.yy.mediaframework.gpuimage.util.GLShaderProgram;
import com.yy.mediaframework.stat.VideoDataStatUtil;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Map;

public class GPUImageBeautyFilter extends GPUImageFilter implements IFilterParams {
    private static final String TAG = "GPUImageBeautyFilter";
    public static String noeffectOes_fs = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTexCoord;\nuniform samplerExternalOES uTexture0;\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";
    public static String noeffect_fs = "precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture0;\n\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";
    public static final String noeffect_vs = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}";
    public static final String passthrouth_fs = "precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture0;\n\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";
    public static final String passthrouth_vs = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}";
    private String framentShader_2d = "precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture0;\n\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";
    private IGPUProcess mGPUImageProcess = null;
    private GPUImageBeautyControl mGpuImageBeautyControl = null;
    private GLShaderProgram mNoEffectShader = null;
    private FloatBuffer mTextureBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private YMFVideoFrame mYMFVideoFrame = new YMFVideoFrame();

    public GPUImageBeautyFilter(GPUImageBeautyControl gpuImageBeautyControl) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        YMFLog.info(this, "[Beauty  ]", "GPUImageBeautyFilter construct");
        this.mGpuImageBeautyControl = gpuImageBeautyControl;
        setGPUImageProcess();
    }

    public void checkTextureTypeUpdate(int target) {
        if (this.mTextureTarget != target && this.mNoEffectShader != null) {
            YMFLog.info(this, "[Beauty  ]", "checkTextureTypeUpdate " + this.mTextureTarget + ":" + target);
            this.mNoEffectShader.destory();
            this.mTextureTarget = target;
            GLShaderProgram gLShaderProgram = new GLShaderProgram();
            this.mNoEffectShader = gLShaderProgram;
            gLShaderProgram.setProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}", this.framentShader_2d);
        }
    }

    public void onInit() {
        YMFLog.info(this, "[Beauty  ]", "onInit");
        super.onInit();
    }

    public void onDestroy() {
        YMFLog.info(this, "[Beauty  ]", "onDestroy");
        super.onDestroy();
        this.mYMFVideoFrame.mYUVCaptureBuffer = null;
        IGPUProcess iGPUProcess = this.mGPUImageProcess;
        if (iGPUProcess != null) {
            iGPUProcess.onDestroy();
        } else {
            this.mNoEffectShader.destory();
        }
    }

    public void onInitExt(boolean isForExternalTextureInput) {
        YMFLog.info(this, "[Beauty  ]", "onInitExt isForExternalTextureInput:" + isForExternalTextureInput);
        this.mTextureTarget = 3553;
        if (isForExternalTextureInput) {
            this.mTextureTarget = 36197;
        }
        if (this.mGPUImageProcess != null) {
            this.mYMFVideoFrame.mTextureWidth = this.mOutputWidth;
            this.mYMFVideoFrame.mTextureHeight = this.mOutputHeight;
            this.mGPUImageProcess.onInit(this.mTextureTarget, this.mOutputWidth, this.mOutputHeight);
        } else {
            this.mNoEffectShader = new GLShaderProgram();
            if (this.mTextureTarget == 36197) {
                this.mNoEffectShader.setProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}", noeffectOes_fs);
            } else {
                this.mNoEffectShader.setProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}", noeffect_fs);
            }
        }
        this.mIsInitialized = true;
    }

    public void onDraw(int textureId, FloatBuffer cubeBuffer, FloatBuffer textureBuffer, int textureTarget, float[] texMatrix, boolean background, byte[] yuvCaptureBuffer, long index) {
        YMFLiveStatisticManager.getInstance().calcPureCap2PreProcessCallbackLatency();
        if (this.mGPUImageProcess != null) {
            FloatBuffer tmpGlTextureBuffer = positionTransform(textureBuffer, texMatrix);
            long mStartTime = System.currentTimeMillis();
            try {
                IGPUProcess iGPUProcess = this.mGPUImageProcess;
                if (iGPUProcess instanceof IYMFGpuProcess) {
                    this.mYMFVideoFrame.mTextureId = textureId;
                    this.mYMFVideoFrame.mTextureCoord = tmpGlTextureBuffer;
                    this.mYMFVideoFrame.mYUVCaptureBuffer = yuvCaptureBuffer;
                    this.mYMFVideoFrame.mIndex = index;
                    ((IYMFGpuProcess) this.mGPUImageProcess).onDraw(this.mYMFVideoFrame);
                } else {
                    iGPUProcess.onDraw(textureId, tmpGlTextureBuffer);
                }
            } catch (Exception e2) {
                YMFLog.error((Object) this, "[Procedur]", "of run exception:" + Log.getStackTraceString(e2));
                YMFLog.error((Object) this, "[Beauty  ]", " of code error " + e2.toString());
            }
            YMFLiveStatisticManager.getInstance().calcPurePreProcessCallbackLatency(mStartTime);
            VideoDataStatUtil.putBeautyTime(System.currentTimeMillis() - mStartTime);
            return;
        }
        FloatBuffer tmp = positionTransform(textureBuffer, texMatrix);
        this.mNoEffectShader.useProgram();
        this.mNoEffectShader.setUniformTexture("uTexture0", 0, textureId, this.mTextureTarget);
        drawQuad(this.mNoEffectShader, cubeBuffer, tmp);
        GLES20.glBindTexture(this.mTextureTarget, 0);
    }

    public void onOutputSizeChanged(int width, int height) {
        YMFLog.info(this, "[Beauty  ]", "onOutputSizeChanged width:" + width + " ,height:" + height);
        this.mOutputWidth = width;
        this.mOutputHeight = height;
        this.mYMFVideoFrame.mTextureWidth = width;
        this.mYMFVideoFrame.mTextureHeight = height;
        IGPUProcess iGPUProcess = this.mGPUImageProcess;
        if (iGPUProcess != null) {
            iGPUProcess.onOutputSizeChanged(width, height);
        }
    }

    private void xyTransform(float[] dstXY, int dstOffset, float[] srcXY, int srcOffset, float[] tr) {
        dstXY[dstOffset] = (tr[0] * srcXY[srcOffset]) + (tr[4] * srcXY[srcOffset + 1]) + tr[12];
        dstXY[dstOffset + 1] = (tr[1] * srcXY[srcOffset]) + (tr[5] * srcXY[srcOffset + 1]) + tr[13];
    }

    private FloatBuffer positionTransform(FloatBuffer src, float[] transform) {
        float[] res = new float[8];
        float[] tmp = new float[8];
        src.get(tmp);
        src.position(0);
        for (int i2 = 0; i2 < res.length; i2 += 2) {
            xyTransform(res, i2, tmp, i2, transform);
        }
        this.mTextureBuffer.put(res).position(0);
        return this.mTextureBuffer;
    }

    private void drawQuad(GLShaderProgram shader, FloatBuffer cubeBuffer, FloatBuffer textureBuffer) {
        cubeBuffer.position(0);
        GLShaderProgram gLShaderProgram = shader;
        gLShaderProgram.setVertexAttribPointer("aPosition", 2, 5126, false, 0, cubeBuffer);
        textureBuffer.position(0);
        gLShaderProgram.setVertexAttribPointer("aTextureCoord", 2, 5126, false, 0, textureBuffer);
        GLES20.glDrawArrays(5, 0, 4);
        shader.disableVertexAttribPointer("aPosition");
        shader.disableVertexAttribPointer("aTextureCoord");
    }

    public void onBeautyParamChanged() {
    }

    public void setFilterParams(Map<String, String> map) {
    }

    public void setGPUImageProcess() {
        this.mGPUImageProcess = this.mGpuImageBeautyControl.getGPUImageBeautyFilter();
    }
}
