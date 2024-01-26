package com.baidu.demoopengl.opengl

/**
 * Day：2023/9/14 19:24
 * @author zhangyelei
 * @Description:
 */
class MyNativeRender {
    init {
        System.loadLibrary("demoopengl")
    }

    external fun native_OnInit()

    external fun native_OnUnInit()

    external fun native_SetImageData(format: Int, width: Int, height: Int, imageData: ByteArray?)

    external fun native_OnSurfaceCreated()

    external fun native_OnSurfaceChanged(width: Int, height: Int)

    external fun native_OnDrawFrame()
}