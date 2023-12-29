package com.baidu.demoopengl

import android.content.Context
import android.util.AttributeSet
import android.view.TextureView
import java.lang.Math.min

/**
 * Day：2023/12/29 15:58
 * @author zhanglei
 */
class AutoRatioTextureView: TextureView {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var previewWidth = 0
    private var previewHeight = 0
    private var relativeRotation = 0

    fun setAspectRatio(width: Int, height: Int, rotation: Int) {
        previewWidth = width
        previewHeight = height
        relativeRotation = rotation
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)

        if (previewWidth > 0f && previewHeight > 0f) {
            /* Scale factor required to scale the preview to its original size on the x-axis. */
            val scaleX =
                if (relativeRotation % 180 == 0) {
                    width.toFloat() / previewWidth
                } else {
                    width.toFloat() / previewHeight
                }
            /* Scale factor required to scale the preview to its original size on the y-axis. */
            val scaleY =
                if (relativeRotation % 180 == 0) {
                    height.toFloat() / previewHeight
                } else {
                    height.toFloat() / previewWidth
                }

            /* Scale factor required to fit the preview to the SurfaceView size. */
            val finalScale = min(scaleX, scaleY)

            setScaleX(1 / scaleX * finalScale)
            setScaleY(1 / scaleY * finalScale)
        }
        setMeasuredDimension(width, height)
    }
}