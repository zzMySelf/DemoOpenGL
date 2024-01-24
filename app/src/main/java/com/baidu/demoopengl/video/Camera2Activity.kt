package com.baidu.demoopengl.video

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.SurfaceTexture
import android.hardware.camera2.*
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
import androidx.lifecycle.MutableLiveData
import com.baidu.demoopengl.R
import java.nio.ByteBuffer

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

    private var backgroundHandler: Handler? = null

    private val textureView by lazy { findViewById<TextureView>(R.id.textureView) }
    private val recordBtn by lazy { findViewById<Button>(R.id.record_btn) }
    private val playBtn by lazy { findViewById<Button>(R.id.play_btn) }
    private val switchBtn by lazy { findViewById<Button>(R.id.switch_btn) }

    private val isFrontCamera = MutableLiveData<Boolean>()

    private val surfaceTextureListener = object : TextureView.SurfaceTextureListener {
        override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
            Log.w(TAG, "=====> onSurfaceTextureAvailable width:$width height:$height")
            startPreview()
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

    private val captureCallback = object : CameraCaptureSession.CaptureCallback() {
        override fun onCaptureStarted(session: CameraCaptureSession, request: CaptureRequest, timestamp: Long, frameNumber: Long) {
            super.onCaptureStarted(session, request, timestamp, frameNumber)
            Log.w(TAG, "=====> onCaptureStarted timestamp:$timestamp frameNumber:$frameNumber")
        }

        override fun onCaptureCompleted(session: CameraCaptureSession, request: CaptureRequest, result: TotalCaptureResult) {
            super.onCaptureCompleted(session, request, result)
            Log.w(TAG, "=====> onCaptureCompleted ")
//            val inputBufferIndex = MediaCodecHelper.dequeueInputBuffer(10000) ?: return
//            if (inputBufferIndex > 0) {
//                val inputBuffer = MediaCodecHelper.getInputBuffer(inputBufferIndex) ?: return
//                val jpegData = getJpegData(result)
//                inputBuffer.put(jpegData)
//                MediaCodecHelper.queueInputBuffer(inputBufferIndex, 0, jpegData.size, )
//
//            }
            MediaCodecHelper.frameAvailable()

        }
    }

    // 获取相机捕获的 JPEG 数据的示例方法
    private fun getJpegData(result: TotalCaptureResult): ByteArray {
        // 假设 JPEG 数据存储在 CaptureResult.JPEG_DATA 中
        val jpegBuffer = ByteBuffer.allocate(0)

        // 将 JPEG 数据复制到字节数组中
        val jpegData = ByteArray(jpegBuffer.remaining())
        jpegBuffer.get(jpegData)

        return jpegData
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CAMERA_PERMISSION
            )
        } else {
            initView()
            initCamera()
            openCamera()
        }

        initObserver()

        MediaCodecHelper.createMediaCodec()
    }

    private fun initObserver() {
        // 切换摄像头
        isFrontCamera.observe(this) {
            if (it) {
                switchBtn.text = "switch front"
            } else {
                switchBtn.text = "switch back"
            }
            initCamera()
            openCamera(isPreview = true)
        }
    }

    private fun initView() {
        // 设置
        textureView.surfaceTextureListener = surfaceTextureListener
        // 切换摄像头
        switchBtn.setOnClickListener {
            releaseCamera()
            val value = isFrontCamera.value ?: false
            isFrontCamera.value = !value
        }
    }

    private fun initCamera() {
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as? CameraManager
        if (backgroundHandler == null) {
            val backgroundThread = HandlerThread("mine-camera2")
            backgroundThread.start()
            backgroundHandler = Handler(backgroundThread.looper)
        }
    }

    private fun openCamera(isPreview: Boolean = false) {
        try {
            findCameraId()
            val cameraId = getCurrentCameraId()
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
                    if (isPreview) {
                        startPreview()
                    }
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
                    /**
                     *  通过id获取对应相机信息结构
                     *  相机信息提供类，类内部有很多相机信息常量，
                     *  其中有代表相机方向的 LENS_FACING；
                     *  判断闪光灯是否可用的 FLASH_INFO_AVAILABLE；
                     *  获取所有可用 AE 模式的 CONTROL_AE_AVAILABLE_MODES
                     */
                    val characteristics = it.getCameraCharacteristics(cameraId)
                    //获取前置/后置摄像头
                    val facing = characteristics.get(CameraCharacteristics.LENS_FACING)
                    if (facing == CameraCharacteristics.LENS_FACING_BACK) {
                        // 手机摄像头有多个后置 获取第一个
                        if (!backCameraId.isNullOrEmpty()) {
                            continue
                        }
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

    private fun startPreview() {
        try {
            var surfaceTexture: SurfaceTexture? = null
            getCurrentCameraCcs()?.let { ccs ->
                surfaceTexture = CameraUtils.buildTargetTexture(textureView, ccs, 0)
            }

            // 创建预览请求 TEMPLATE_PREVIEW
            val captureRequest = cameraDevice?.createCaptureRequest(CameraDevice.TEMPLATE_RECORD)
            val previewSurface = Surface(surfaceTexture)
            captureRequest?.addTarget(previewSurface)
            MediaCodecHelper.getSurface()?.let {
                captureRequest?.addTarget(it)
            }
            val surfaceList = mutableListOf<Surface >().apply {
                add(previewSurface)
                MediaCodecHelper.getSurface()?.let {
                    add(it)
                }
            }

            cameraDevice?.createCaptureSession(surfaceList, object : CameraCaptureSession.StateCallback() {
                override fun onConfigured(session: CameraCaptureSession) {
                    captureSession = session
                    try {
//                        previewRequestBuilder?.set(CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE)
                        val request = captureRequest?.build()
                        if (request != null) {
                            session.setRepeatingRequest(request, captureCallback, backgroundHandler)
                            MediaCodecHelper.startEncoder()
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

    private fun getCurrentCameraId(): String? {
        return if (isFrontCamera.value == true) {
            frontCameraId
        } else {
            backCameraId
        }
    }

    private fun getCurrentCameraCcs(): CameraCharacteristics? {
        return if (isFrontCamera.value == true) {
            frontCameraCs
        } else {
            backCameraCs
        }
    }

    private fun releaseCamera() {
        // 释放 Camera 相关资源
        captureSession?.stopRepeating()
        captureSession?.close()
        cameraDevice?.close()

        MediaCodecHelper.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseCamera()
        backgroundHandler?.removeCallbacksAndMessages(null)
        backgroundHandler = null
    }
}