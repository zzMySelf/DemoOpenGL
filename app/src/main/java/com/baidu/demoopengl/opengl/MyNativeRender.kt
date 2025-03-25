package com.baidu.demoopengl.opengl

import android.graphics.Bitmap

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

    external fun native_Set2ImageData(format0: Int, width0: Int, height0: Int, imageData0: ByteArray?,
                                      format1: Int, width1: Int, height1: Int, imageData1: ByteArray?)

    external fun native_OnSurfaceCreated()

    external fun native_OnSurfaceChanged(width: Int, height: Int)

    external fun native_OnDrawFrame()

    external fun native_SetRenderType(type: Int)

    external fun native_addRoundedCorners(bitmap: Bitmap, shadowSize: Int, cornerRadius: Int)

    external fun native_blurBitmap(bitmap: Bitmap)
}