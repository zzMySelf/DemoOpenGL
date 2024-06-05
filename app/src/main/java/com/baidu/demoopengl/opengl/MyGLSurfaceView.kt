package com.baidu.demoopengl.opengl

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import com.baidu.demoopengl.R
import java.io.IOException
import java.nio.ByteBuffer
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
            it.native_SetRenderType(200)
        }
        setRenderer(mGLRender)
        renderMode = RENDERMODE_CONTINUOUSLY

        loadRGBAImage(R.drawable.dzzz)
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

    private fun loadRGBAImage(resId: Int) {
        val `is` = this.resources.openRawResource(resId)
        val bitmap: Bitmap?
        try {
            bitmap = BitmapFactory.decodeStream(`is`)
            if (bitmap != null) {
                val bytes = bitmap.byteCount
                val buf = ByteBuffer.allocate(bytes)
                bitmap.copyPixelsToBuffer(buf)
                val byteArray = buf.array()
                mNativeRender?.native_SetImageData(0x01, bitmap.width, bitmap.height, byteArray)
            }
        } finally {
            try {
                `is`.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}