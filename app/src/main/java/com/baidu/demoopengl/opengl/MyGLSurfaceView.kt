package com.baidu.demoopengl.opengl

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Day：2023/9/14 17:54
 * @author zhangyelei
 * @Description:
 */
class MyGLSurfaceView : GLSurfaceView {
    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private var mGLRender: MyGlRender? = null
    private var mNativeRender: MyNativeRender? = null

    init {
        setEGLContextClientVersion(3)
        mNativeRender = MyNativeRender()
        mNativeRender?.let {
            mGLRender = MyGlRender(it)
        }
        setRenderer(mGLRender)
        renderMode = RENDERMODE_CONTINUOUSLY
    }

    inner class MyGlRender(private val mNativeRender: MyNativeRender) : Renderer {

        override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
            mNativeRender.native_OnSurfaceCreated()
        }

        override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
            mNativeRender.native_OnSurfaceChanged(width, height)
        }

        override fun onDrawFrame(gl: GL10?) {
            mNativeRender.native_OnDrawFrame()
        }

    }
}