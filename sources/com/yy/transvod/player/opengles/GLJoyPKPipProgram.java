package com.yy.transvod.player.opengles;

import android.opengl.GLES20;
import com.yy.transvod.player.common.JoyPkPipParameter;

public class GLJoyPKPipProgram extends GLProgram {
    protected int mPipFronetAreaUniform = -1;
    protected JoyPkPipParameter mPipParam = new JoyPkPipParameter(0.7f, 0.9f, 0.95f, 0.75f);

    public GLJoyPKPipProgram(OpenGLUserContext context) {
        super(context);
    }

    public void create(String vs, String fs, int frameType, int samplerFilter) {
        super.create(vs, fs, frameType, samplerFilter, true);
        GLES20.glUseProgram(this.mProgramId);
        this.mPipFronetAreaUniform = GLES20.glGetUniformLocation(this.mProgramId, "u_frontArea");
        OpenGLUtils.checkGlError("PipUniform", this.mUserContext);
        GLES20.glUniform4f(this.mPipFronetAreaUniform, this.mPipParam.bottomLeftX, this.mPipParam.bottomLeftY, this.mPipParam.upperRightX, this.mPipParam.upperRightY);
        GLES20.glUseProgram(0);
    }

    public void setupParameter(Object param) {
        if (param != null && this.mPipFronetAreaUniform != -1) {
            JoyPkPipParameter pipParam = (JoyPkPipParameter) param;
            if (!pipParam.equals(this.mPipParam)) {
                GLES20.glUniform4f(this.mPipFronetAreaUniform, pipParam.bottomLeftX, pipParam.upperRightX, pipParam.bottomLeftY, pipParam.upperRightY);
                this.mPipParam = pipParam;
            }
        }
    }
}
