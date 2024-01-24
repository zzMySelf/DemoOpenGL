package com.baidu.demoopengl.video

import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaFormat
import android.media.MediaMuxer
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.Surface
import java.io.File
import java.lang.ref.WeakReference
import java.nio.ByteBuffer
import java.util.Base64.Encoder

/**
 * Day：2024/1/12 16:41
 * @author zhangyelei
 */
object MediaCodecHelper  {
    private const val TAG = "MediaCodecHelper"

    private const val WIDTH = 1920
    private const val HEIGHT = 1080
    private const val FRAME_RATE = 30
    private const val I_FRAME_INTERVAL = 5

    private var mediaCodec: MediaCodec? = null
    private var surface: Surface? = null

    private var encoderThread: EncoderThread? = null

    fun createMediaCodec() {
        mediaCodec = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_AVC)
        val mediaFormat = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC, WIDTH, HEIGHT).apply {
            setInteger(MediaFormat.KEY_BIT_RATE, 6000000)
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

        initEncoderThread()
    }

    private fun initEncoderThread() {
        mediaCodec?.let {
            val filePath = "/storage/emulated/0/Android/data/com.baidu.demoopengl/files/encoded.mp4"
            val file = File(filePath)
            if (!file.exists()) {
                file.createNewFile()
            }
            encoderThread = EncoderThread(it, file, 90)
        }
    }

    fun getSurface() = surface

    fun startEncoder() {
        mediaCodec?.start()
        encoderThread?.start()
        encoderThread?.waitUntilReady()
    }

    fun frameAvailable() {
        encoderThread?.frameAvailable()
    }

    fun stop() {
        mediaCodec?.stop()
        mediaCodec?.release()
        mediaCodec = null
        surface = null

        encoderThread?.shutdown()
        encoderThread = null
    }

    class EncoderThread(
        private val mediaCodec: MediaCodec,
        private val outputFile: File,
        private val orientationHint: Int
    ) : Thread() {
        companion object {
            private const val TIMEOUT_USEC: Long = 10 * 1000
        }

        var encoderFormat: MediaFormat? = null
        private val bufferInfo by lazy { MediaCodec.BufferInfo() }
        private val muxer by lazy { MediaMuxer(outputFile.path, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4) }

        var videoTrack: Int = -1

        var hander: EncoderHandler? = null
        var frameNum: Int = 0

        private val _lock by lazy { Object() }

        @Volatile
        var isReady: Boolean = false

        override fun run() {
            super.run()
            Looper.prepare()
            hander = EncoderHandler(this)
            Log.d(TAG, "encoder thread ready")

            synchronized(_lock) {
                isReady = true
                _lock.notify()    // signal waitUntilReady()
            }

            Looper.loop()

            synchronized(_lock) {
                isReady = false
                hander = null    // signal waitUntilReady()
            }
            Log.d(TAG, "looper quit")
        }

        fun waitUntilReady() {
            synchronized(_lock) {
                while (!isReady) {
                    try {
                        _lock.wait()
                    } catch (ie: InterruptedException) { /* not expected */
                    }
                }
            }
        }

        fun waitForFirstFrame() {
            synchronized(_lock) {
                while (frameNum < 1) {
                    try {
                        _lock.wait()
                    } catch (ie: InterruptedException) {
                        ie.printStackTrace()
                    }
                }
            }
            Log.d(TAG, "Waited for first frame");
        }

        fun getHandler(): EncoderHandler? {
            synchronized(_lock) {
                // Confirm ready state.
                if (!isReady) {
                    throw RuntimeException("not ready")
                }
            }
            return hander
        }

        fun frameAvailable() {
            Log.d(TAG, "frameAvailable")
            if (drainEncoder()) {
                synchronized(_lock) {
                    frameNum++
                    _lock.notify()
                }
            }
        }

        /**
         * Tells the Looper to quit.
         */
        fun shutdown() {
            Log.d(TAG, "shutdown")
            encoderThread?.getHandler()?.let {
                it.sendMessage(it.obtainMessage(EncoderHandler.MSG_SHUTDOWN))
                it.looper.quit()
            }
            try {
                muxer.stop()
                muxer.release()
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }

        private fun drainEncoder(): Boolean {
            var encodedFrame = false

            while (true) {
                val encoderStatus = mediaCodec.dequeueOutputBuffer(bufferInfo, TIMEOUT_USEC)
                Log.d(TAG, "encoder encoderStatus: $encoderStatus  ")
                when {
                    encoderStatus == MediaCodec.INFO_TRY_AGAIN_LATER -> break
                    encoderStatus == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED -> {
                        encoderFormat = mediaCodec.outputFormat
                        Log.d(TAG, "encoder output format changed: $encoderFormat")
                    }
                    encoderStatus < 0 -> {
                        Log.w(TAG, "unexpected result from encoder.dequeueOutputBuffer: $encoderStatus")
                    }
                    else -> {
                        val encodedData: ByteBuffer? = mediaCodec.getOutputBuffer(encoderStatus)
                        if (encodedData == null) {
                            Log.e(TAG, "encoderOutputBuffer $encoderStatus was null")
                            break
                        }

                        if ((bufferInfo.flags and MediaCodec.BUFFER_FLAG_CODEC_CONFIG) != 0) {
                            // The codec config data was pulled out when we got the
                            // INFO_OUTPUT_FORMAT_CHANGED status.  The MediaMuxer won't accept
                            // a single big blob -- it wants separate csd-0/csd-1 chunks --
                            // so simply saving this off won't work.
                            Log.d(TAG, "ignoring BUFFER_FLAG_CODEC_CONFIG")
                            bufferInfo.size = 0
                        }

                        if (bufferInfo.size != 0 && encoderFormat != null) {
                            // adjust the ByteBuffer values to match BufferInfo (not needed?)
                            encodedData.position(bufferInfo.offset)
                            encodedData.limit(bufferInfo.offset + bufferInfo.size)

                            if (videoTrack == -1) {
                                videoTrack = muxer.addTrack(encoderFormat!!)
                                muxer.setOrientationHint(orientationHint)
                                muxer.start()
                                Log.d(TAG, "Started media muxer")
                            }

                            // mEncBuffer.add(encodedData, mBufferInfo.flags,
                            //         mBufferInfo.presentationTimeUs)
                            muxer.writeSampleData(videoTrack, encodedData, bufferInfo)
                            encodedFrame = true

                            Log.d(TAG, "sent " + bufferInfo.size + " bytes to muxer, ts=" + bufferInfo.presentationTimeUs)
                        }

                        mediaCodec.releaseOutputBuffer(encoderStatus, false)

                        if ((bufferInfo.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) {
                            Log.w(TAG, "reached end of stream unexpectedly")
                            break      // out of while
                        }
                    }

                }
            }

            return encodedFrame
        }
    }

    class EncoderHandler(et: EncoderThread) : Handler() {
        companion object {
            val MSG_FRAME_AVAILABLE: Int = 0
            val MSG_SHUTDOWN: Int = 1
        }

        private val mWeakEncoderThread = WeakReference(et)

        override fun handleMessage(msg: Message) {
            val what: Int = msg.what
            Log.v(TAG, "EncoderHandler: what=$what")

            val encoderThread: EncoderThread? = mWeakEncoderThread.get()
            if (encoderThread == null) {
                Log.w(TAG, "EncoderHandler.handleMessage: weak ref is null")
                return
            }

            when (what) {
                MSG_FRAME_AVAILABLE -> encoderThread.frameAvailable()
                MSG_SHUTDOWN -> encoderThread.shutdown()
                else -> throw RuntimeException("unknown message $what")
            }
        }
    }
}