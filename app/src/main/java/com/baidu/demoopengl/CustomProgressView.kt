package com.baidu.demoopengl

import android.content.Context
import android.graphics.*
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import kotlin.math.min

class CustomProgressView : View {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    companion object {
        private const val MAX_PROGRESS = 360f
        private const val UNIT_PROGRESS = 3.6f
        private const val UPDATE_INTERVAL = 20L
    }

    // 边框和进度条的宽度 (3.5px 转换为 dp)
    private val borderWidth = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 3.5f, resources.displayMetrics
    )

    // 圆角矩形的圆角半径 (38dp)
    private val cornerRadius = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 38f, resources.displayMetrics
    )

    private val progressColor = Color.parseColor("#0095ff") // 进度条颜色
    private val backgroundColor = Color.parseColor("#ffffff") // 背景颜色

    // 用于绘制矩形背景的画笔
    private val backgroundPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = backgroundColor
            style = Paint.Style.FILL // 填充背景色
        }
    }

    // 用于绘制进度条的画笔
    private val progressPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = progressColor
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
            strokeCap = Paint.Cap.ROUND
        }
    }

    /**
     * 背景绘制
     */
    private val rectF by lazy { RectF() }
    private val rectPath by lazy { Path() }

    /**
     * 进度条绘制
     */
    private val progressPath by lazy { Path() }

    /**
     * 计算进度条长度
     */
    private val progressPathMeasure by lazy { PathMeasure(rectPath, true) }
    private val progressHandler = Handler(Looper.getMainLooper())

    /**
     * 当前进度，以 360 为满
     */
    private var currentProgress = 0f

    init {
        // 使用 Handler 实现每 2 秒钟旋转一圈
        startProgress()
    }

    private fun startProgress() {
        progressHandler.post(object : Runnable {
            override fun run() {
                currentProgress += UNIT_PROGRESS
                if (currentProgress >= MAX_PROGRESS) {
                    currentProgress = 0f
                }
                invalidate() // 重绘视图
                progressHandler.postDelayed(this, UPDATE_INTERVAL)
            }
        })
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 获取可绘制区域的宽度和高度
        val realWidth = width - paddingLeft - paddingRight
        val realHeight = height - paddingTop - paddingBottom
        val size = min(realWidth, realHeight) // 保持矩形为正方形

        // 考虑边框宽度，设置矩形区域
        val halfBorderWidth = borderWidth / 2
        rectF.set(
            paddingLeft + halfBorderWidth,
            paddingTop + halfBorderWidth,
            paddingLeft + size - halfBorderWidth,
            paddingTop + size - halfBorderWidth
        )

        canvas?.drawRoundRect(rectF, cornerRadius, cornerRadius, backgroundPaint)
        // 绘制进度条
        drawProgress(canvas)
    }

    private fun drawProgress(canvas: Canvas?) {
        // 重置path
        rectPath.reset()
        rectPath.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
        progressPathMeasure.setPath(rectPath, false)

        // 获取路径的总长度
        val totalLength = progressPathMeasure.length

        // 计算四边和四个圆角的长度 4个圆角的总长度 除圆角以外的边长 从而找到进度条起点偏移量
        val rectWidth = rectF.width()
        val cornerLength = (Math.PI * cornerRadius / 2f).toFloat()
        val lineLength = rectWidth - 2 * cornerRadius
        val topEdgeStart = cornerLength + lineLength
        val topEdgeMiddleOffset = topEdgeStart + lineLength / 2f

        // 计算当前进度对应的路径片段长度
        val segmentLength = (currentProgress / MAX_PROGRESS) * totalLength

        // 计算新的起点和终点，从上边的中点开始
        val startOffset = topEdgeMiddleOffset
        val end = startOffset + segmentLength

        //  绘制路径
        progressPath.reset()

        // 绘制偏移量前后
        if (end <= totalLength) {
            // 进度在路径范围内，不需要分段
            progressPathMeasure.getSegment(startOffset, end, progressPath, true)
        } else {
            // 进度超过路径长度，需要分两段绘制
            val firstSegmentEnd = totalLength
            val secondSegmentEnd = end - totalLength

            // 第一段：从 startOffset 到路径的末尾
            progressPathMeasure.getSegment(startOffset, firstSegmentEnd, progressPath, true)

            // 第二段：从路径的开头到剩余部分
            progressPathMeasure.getSegment(0f, secondSegmentEnd, progressPath, true)
        }

        canvas?.drawPath(progressPath, progressPaint)
    }

    fun release() {
        progressHandler.removeCallbacksAndMessages(null)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        progressHandler.removeCallbacksAndMessages(null)
    }
}



