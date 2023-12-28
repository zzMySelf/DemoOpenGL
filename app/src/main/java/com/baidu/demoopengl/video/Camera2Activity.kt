package com.baidu.demoopengl.video

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Rect
import android.graphics.SurfaceTexture
import android.hardware.camera2.*
import android.media.ImageReader
import android.media.MediaCodec
import android.media.MediaFormat
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.util.Size
import android.view.Surface
import android.view.TextureView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.baidu.demoopengl.R
import java.io.File
import java.io.IOException

class Camera2Activity : AppCompatActivity() {
    companion object {
        private const val TAG = "Camera2Activity"

        private const val REQUEST_CAMERA_PERMISSION = 200

        fun start(context: Context) {
            val intent = Intent(context, Camera2Activity::class.java)
            context.startActivity(intent)
        }
    }

    private var cameraManager: CameraManager? = null
    private var cameraDevice: CameraDevice? = null
    private var captureSession: CameraCaptureSession? = null
    private var previewSize: Size? = null

    /**
     * 后置摄像头
     */
    private var backCameraCs: CameraCharacteristics? = null
    private var backCameraId: String? = null

    /**
     * 前置摄像头
     */
    private var frontCameraCs: CameraCharacteristics? = null
    private var frontCameraId: String? = null

    private  var mediaCodec: MediaCodec? = null
    private  var codecInputSurface: Surface? = null

    private var isRecording = false
    private  var outputFile: File? = null

    private var backgroundHandler: Handler? = null

    private var imageReader: ImageReader? = null

    private val textureView by lazy { findViewById<TextureView>(R.id.textureView) }
    private val recordBtn by lazy { findViewById<Button>(R.id.record_btn) }
    private val playBtn by lazy { findViewById<Button>(R.id.play_btn) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_CAMERA_PERMISSION
            )
        } else {
            initView()
            initCamera()
            openCamera()
        }
    }

    private fun initView() {
        textureView.surfaceTextureListener = object : TextureView.SurfaceTextureListener {
            override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
                Log.w(TAG, "=====> onSurfaceTextureAvailable width:$width height:$height")
                startPreview(width, height)
            }

            override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {
                Log.w(TAG, "=====> onSurfaceTextureSizeChanged width:$width height:$height")
            }

            override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
                Log.w(TAG, "=====> onSurfaceTextureDestroyed")
                return true
            }

            override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {
            }
        }
    }

    private fun initCamera() {
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as? CameraManager
        val backgroundThread = HandlerThread("mine-camera2")
        backgroundThread.start()
        backgroundHandler = Handler(backgroundThread.looper)
    }

    private fun openCamera() {
        try {
            findCameraId()
            val cameraId = backCameraId
            if (cameraId.isNullOrEmpty()) {
                return
            }
            // 判断是前置or后置拿到对应的相机信息
            val characteristics = cameraManager?.getCameraCharacteristics(cameraId)
            val map = characteristics?.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP) ?: return
            // Size[]
            previewSize = map.getOutputSizes(SurfaceTexture::class.java)[0]
            Log.w(TAG, "=====> previewSize width:${previewSize?.width} height:${previewSize?.height}")

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                return
            }
            cameraManager?.openCamera(cameraId, object : CameraDevice.StateCallback() {
                override fun onOpened(camera: CameraDevice) {
                    cameraDevice = camera
                }

                override fun onDisconnected(camera: CameraDevice) {
                    camera.close()
                    cameraDevice = null
                }

                override fun onError(camera: CameraDevice, error: Int) {
                    camera.close()
                    cameraDevice = null
                    Toast.makeText(this@Camera2Activity, "Error opening camera", Toast.LENGTH_SHORT).show()
                }
            }, backgroundHandler)
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    private fun findCameraId() {
        try {
            cameraManager?.let {
                // 获取当前手机的所有摄像头id
                for (cameraId in it.cameraIdList) {
                    // 通过id获取对应相机信息结构
                    // 相机信息提供类，类内部有很多相机信息常量，
                    // 其中有代表相机方向的 LENS_FACING；
                    // 判断闪光灯是否可用的 FLASH_INFO_AVAILABLE；
                    // 获取所有可用 AE 模式的 CONTROL_AE_AVAILABLE_MODES
                    val characteristics = it.getCameraCharacteristics(cameraId)
                    //获取前置/后置摄像头
                    val facing = characteristics.get(CameraCharacteristics.LENS_FACING)
                    if (facing == CameraCharacteristics.LENS_FACING_BACK) {
                        backCameraCs = characteristics
                        backCameraId = cameraId
                    } else if (facing == CameraCharacteristics.LENS_FACING_FRONT) {
                        frontCameraCs = characteristics
                        frontCameraId = cameraId
                    }
                }
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    private fun startPreview(textureWidth: Int, textureHeight: Int) {
        try {
            val surfaceTexture = textureView.surfaceTexture
            previewSize?.let {
                surfaceTexture?.setDefaultBufferSize(it.width, it.height)
            }
            val previewSurface = Surface(surfaceTexture)
            // 创建预览请求 TEMPLATE_PREVIEW
            val previewRequestBuilder = cameraDevice?.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
            previewRequestBuilder?.addTarget(previewSurface)
            previewSize?.let {
                previewRequestBuilder?.set(CaptureRequest.SCALER_CROP_REGION, calculateCropRegion(it, Size(textureWidth, textureHeight)))
            }

            cameraDevice?.createCaptureSession(listOf(previewSurface), object : CameraCaptureSession.StateCallback() {
                override fun onConfigured(session: CameraCaptureSession) {
                    captureSession = session
                    try {
                        previewRequestBuilder?.set(CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE)
                        val captureRequest = previewRequestBuilder?.build()
                        if (captureRequest != null) {
                            session.setRepeatingRequest(captureRequest, null, backgroundHandler)
                        }
                    } catch (e: CameraAccessException) {
                        e.printStackTrace()
                    }
                }

                override fun onConfigureFailed(session: CameraCaptureSession) {
                    Toast.makeText(this@Camera2Activity, "Failed to configure camera preview", Toast.LENGTH_SHORT).show()
                }
            }, backgroundHandler)
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    private fun calculateCropRegion(previewSize: Size, textureViewSize: Size): Rect {
        val previewRatio = previewSize.width.toFloat() / previewSize.height
        val viewRatio = textureViewSize.width.toFloat() / textureViewSize.height
        val cropWidth: Int
        val cropHeight: Int
        if (previewRatio > viewRatio) {
            cropWidth = previewSize.width
            cropHeight = (previewSize.width / viewRatio).toInt()
        } else {
            cropWidth = (previewSize.height * viewRatio).toInt()
            cropHeight = previewSize.height
        }
        val x = (previewSize.width - cropWidth) / 2
        val y = (previewSize.height - cropHeight) / 2
        return Rect(x, y, x + cropWidth, y + cropHeight)
    }

    private fun createMediaCodec() {
        try {
            // 创建 MediaCodec 实例
            mediaCodec = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_AVC)

            // 创建视频格式
            val format = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC, 1920, 1080)
            mediaCodec?.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)

            // 获取用于输入数据的 Surface
            codecInputSurface = mediaCodec?.createInputSurface()

            // 其他初始化和设置 MediaCodec 的步骤...
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun startRecording() {
        // 启动录制视频的逻辑，包括启动 MediaCodec、处理输入数据等
        // 具体步骤可以参考 MediaCodec 的使用文档
    }

    private fun stopRecording() {
        // 停止录制视频的逻辑，释放资源等
        // 具体步骤可以参考 MediaCodec 的使用文档
    }

    private fun releaseCamera() {
        // 释放 Camera 相关资源
        captureSession?.close()
        cameraDevice?.close()
    }

    private fun releaseMediaCodec() {
        // 释放 MediaCodec 相关资源
        mediaCodec?.stop()
        mediaCodec?.release()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseCamera()
        releaseMediaCodec()
    }
}