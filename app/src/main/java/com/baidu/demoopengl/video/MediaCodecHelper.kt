package com.baidu.demoopengl.video

import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaFormat
import android.os.Environment
import android.util.Log
import android.view.Surface
import java.nio.ByteBuffer

/**
 * Day：2024/1/12 16:41
 * @author zhangyelei
 */
object MediaCodecHelper: MediaCodec.Callback() {
    private const val TAG = "MediaCodecHelper"

    private const val WIDTH = 640
    private const val HEIGHT = 480
    private const val FRAME_RATE = 30
    private const val I_FRAME_INTERVAL = 5
    private val OUTPUT_FILE_PATH = "${Environment.getExternalStorageDirectory()}/encoded.mp4"

    private var mediaCodec: MediaCodec? = null
    private var surface: Surface? = null

    fun createMediaCodec() {
        mediaCodec = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_AVC)
        val mediaFormat = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC, WIDTH, HEIGHT).apply {
            setInteger(MediaFormat.KEY_BIT_RATE, WIDTH * HEIGHT)
            setInteger(MediaFormat.KEY_FRAME_RATE, FRAME_RATE)
            setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface)
            setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, I_FRAME_INTERVAL)
            setInteger(MediaFormat.KEY_BITRATE_MODE, MediaCodecInfo.EncoderCapabilities.BITRATE_MODE_VBR)
        }
        try {
            mediaCodec?.configure(mediaFormat, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        surface = mediaCodec?.createInputSurface()
//        mediaCodec?.setCallback(this)

    }

    fun getSurface() = surface


    fun startEncoder() {
        mediaCodec?.start()
    }

    fun dequeueInputBuffer(timeoutUs: Long): Int? {
        return mediaCodec?.dequeueInputBuffer(timeoutUs)
    }

    fun getInputBuffer(inputBufferIndex: Int): ByteBuffer? {
        return mediaCodec?.getInputBuffer(inputBufferIndex)
    }

    fun queueInputBuffer(index: Int, offset: Int, size: Int, presentationTimeUs: Long, flags: Int) {
        mediaCodec?.queueInputBuffer(index, offset, size, presentationTimeUs, flags)
    }

    override fun onInputBufferAvailable(codec: MediaCodec, index: Int) {
        Log.e(TAG, "=====> onInputBufferAvailable")
    }

    override fun onOutputBufferAvailable(codec: MediaCodec, index: Int, info: MediaCodec.BufferInfo) {
        Log.e(TAG, "=====> onOutputBufferAvailable")
    }

    override fun onError(codec: MediaCodec, e: MediaCodec.CodecException) {
        Log.e(TAG, "=====> onError :${e.message}")
    }

    override fun onOutputFormatChanged(codec: MediaCodec, format: MediaFormat) {
        Log.e(TAG, "=====> onOutputFormatChanged")
    }

    fun stop() {
        mediaCodec?.setCallback(null)
        mediaCodec?.stop()
        mediaCodec?.release()
        mediaCodec = null
        surface = null
    }
}