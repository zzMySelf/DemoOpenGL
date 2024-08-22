package com.baidu.cyberplayer.sdk.filter;

import android.opengl.GLES20;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.DuMediaPlayConstants;

public class GaussBlurFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = "uniform sampler2D inputImageTexture;\n\nconst lowp int GAUSSIAN_SAMPLES = 9;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tlowp vec3 sum = vec3(0.0);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n\t\n    sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.05;\n    sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.09;\n    sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.12;\n    sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.15;\n    sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.18;\n    sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.15;\n    sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.12;\n    sum += texture2D(inputImageTexture, blurCoordinates[7]).rgb * 0.09;\n    sum += texture2D(inputImageTexture, blurCoordinates[8]).rgb * 0.05;\n\n\tgl_FragColor = vec4(sum,fragColor.a);\n}";
    public static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tgl_Position = position;\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\t\n\t// Calculate the positions for the blur\n\tint multiplier = 0;\n\tvec2 blurStep;\n   vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n    \n\tfor (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n   {\n\t\tmultiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n       // Blur in x (horizontal)\n       blurStep = float(multiplier) * singleStepOffset;\n\t\tblurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n\t}\n}\n";
    private String TAG;
    private boolean isHorizontal;
    private float offsetValue;
    private int texelHeightOffsetHandle;
    private int texelWidthOffsetHandle;
    private final DuMediaPlayConstants.DuMediaEffectFilter type;

    public GaussBlurFilter(String tagPrefix, boolean isHorizontal2, VideoGaussBlurConfig config) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        this.TAG = "GaussBlurFilter";
        this.type = DuMediaPlayConstants.DuMediaEffectFilter.VIDEO_GAUSS_BLUR;
        this.offsetValue = 0.00390625f;
        this.isHorizontal = false;
        this.TAG = tagPrefix + "#" + this.TAG;
        this.isHorizontal = isHorizontal2;
        if (config != null) {
            super.setEnable(config.isEnable());
            CyberLog.d(this.TAG, "enable=" + config.isEnable() + " config=" + config.content());
        }
    }

    public GaussBlurFilter(String tagPrefix, boolean isHorizontal2) {
        this(tagPrefix, isHorizontal2, (VideoGaussBlurConfig) null);
    }

    /* access modifiers changed from: protected */
    public void onDrawArraysPre() {
        super.onDrawArraysPre();
        if (this.isHorizontal) {
            GLES20.glUniform1f(this.texelWidthOffsetHandle, this.offsetValue);
            GLES20.glUniform1f(this.texelHeightOffsetHandle, 0.0f);
            return;
        }
        GLES20.glUniform1f(this.texelWidthOffsetHandle, 0.0f);
        GLES20.glUniform1f(this.texelHeightOffsetHandle, this.offsetValue);
    }

    public void init() {
        super.init();
        this.texelWidthOffsetHandle = GLES20.glGetUniformLocation(getProgram(), "texelWidthOffset");
        this.texelHeightOffsetHandle = GLES20.glGetUniformLocation(getProgram(), "texelHeightOffset");
    }

    public boolean setEnable(DuMediaPlayConstants.DuMediaEffectFilter type2, boolean val) {
        return type2 == this.type && super.setEnable(val);
    }

    public boolean updateConfig(FilterConfig config) {
        if (config == null || !(config instanceof VideoGaussBlurConfig)) {
            return false;
        }
        return setEnable(((VideoGaussBlurConfig) config).isEnable());
    }
}
