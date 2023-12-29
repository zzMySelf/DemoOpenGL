package com.baidu.demoopengl.video

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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
import android.view.Display
import android.view.Surface
import android.view.TextureView
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.baidu.demoopengl.AutoRatioTextureView
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

    private var backgroundHandler: Handler? = null

    private val textureView by lazy { findViewById<AutoRatioTextureView>(R.id.textureView) }
    private val recordBtn by lazy { findViewById<Button>(R.id.record_btn) }
    private val playBtn by lazy { findViewById<Button>(R.id.play_btn) }
    private val switchBtn by lazy { findViewById<Button>(R.id.switch_btn) }

    private val isFrontCamera = MutableLiveData<Boolean>()

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

        initObserver()
    }

    private fun initObserver() {
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
        textureView.surfaceTextureListener = object : TextureView.SurfaceTextureListener {
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
        switchBtn.setOnClickListener {
            releaseCamera()
            val value = isFrontCamera.value ?: false
            isFrontCamera.value = !value
        }
    }

    private fun initCamera() {
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as? CameraManager
        val backgroundThread = HandlerThread("mine-camera2")
        backgroundThread.start()
        backgroundHandler = Handler(backgroundThread.looper)
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

    private fun startPreview() {
        try {
            val surfaceTexture = textureView.surfaceTexture
            previewSize?.let {
                surfaceTexture?.setDefaultBufferSize(it.width, it.height)

                getCurrentCameraCcs()?.let { ccs ->
                    textureView?.setAspectRatio(it.width, it.height, computeRelativeRotation(ccs))
                }
            }
            val previewSurface = Surface(surfaceTexture)
            // 创建预览请求 TEMPLATE_PREVIEW
            val captureRequest = cameraDevice?.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
            captureRequest?.addTarget(previewSurface)

            cameraDevice?.createCaptureSession(listOf(previewSurface), object : CameraCaptureSession.StateCallback() {
                override fun onConfigured(session: CameraCaptureSession) {
                    captureSession = session
                    try {
//                        previewRequestBuilder?.set(CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE)
                        val captureRequest = captureRequest?.build()
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

    /**
     * 获取当前设备屏幕的旋转角度
     */
    private fun getDeviceScreenRotation(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display? = windowManager.defaultDisplay

        if (display != null) {
            return when (display.rotation) {
                Surface.ROTATION_0 -> 0
                Surface.ROTATION_90 -> 90
                Surface.ROTATION_180 -> 180
                Surface.ROTATION_270 -> 270
                else -> 0
            }
        }

        return 0
    }

    private fun computeRelativeRotation(characteristics: CameraCharacteristics): Int {
        val sensorOrientationDegrees =
            characteristics.get(CameraCharacteristics.SENSOR_ORIENTATION) ?: return 0
        val surfaceRotationDegrees = getDeviceScreenRotation(this)

        // Reverse device orientation for back-facing cameras.
        val sign = if (characteristics.get(CameraCharacteristics.LENS_FACING) ==
            CameraCharacteristics.LENS_FACING_FRONT
        ) 1 else -1

        // Calculate desired orientation relative to camera orientation to make
        // the image upright relative to the device orientation.
        return (sensorOrientationDegrees - surfaceRotationDegrees * sign + 360) % 360
    }


    private fun releaseCamera() {
        // 释放 Camera 相关资源
        captureSession?.close()
        cameraDevice?.close()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseCamera()
        backgroundHandler?.removeCallbacksAndMessages(null)
        backgroundHandler = null
    }
}