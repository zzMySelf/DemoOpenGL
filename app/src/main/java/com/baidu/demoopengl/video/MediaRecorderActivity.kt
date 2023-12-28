package com.baidu.demoopengl.video

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.SurfaceTexture
import android.hardware.Camera
import android.media.CamcorderProfile
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.SurfaceView
import android.view.TextureView
import android.view.TextureView.SurfaceTextureListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.baidu.demoopengl.R
import java.io.File
import java.util.*

/**
 * Camera 已废弃
 */
class MediaRecorderActivity : AppCompatActivity() {

    private val mediaRecorder by lazy {
        MediaRecorder()
    }
    private var camera: Camera? = null
    private var isRecord = false

    private val surfaceView by lazy { findViewById<SurfaceView>(R.id.surfaceview) }
    private val recordBtn by lazy { findViewById<Button>(R.id.record_btn) }
    private val playBtn by lazy { findViewById<Button>(R.id.play_btn) }

    companion object {
        private const val TAG = "MediaRecorderActivity"
        private val REQUEST_CAMERA_PERMISSION = 200

        fun start(context: Context) {
            val intent = Intent(context, MediaRecorderActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_recorder)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CAMERA_PERMISSION)
        } else {
            initView()
        }
    }

    private fun initView() {
        recordBtn.setOnClickListener {
            if (!isRecord) {
                prepareVideoRecorder()
                mediaRecorder.start()
                isRecord = true
                recordBtn.text = "stop"
            } else {
                mediaRecorder.stop()
                isRecord = false
                recordBtn.text = "record"
                release()
            }
        }
        playBtn.setOnClickListener {
            mediaRecorder.reset()

        }
    }

    private fun prepareVideoRecorder() {
        mediaRecorder.reset()
        camera = Camera.open(0)
        camera?.run {
            //设置旋转角度，顺时针方向，因为默认是逆向90度的，这样图像就是正常显示了
            setDisplayOrientation(90)
            unlock()
            mediaRecorder.setCamera(this)
        }
        mediaRecorder.run {
            setAudioSource(MediaRecorder.AudioSource.CAMCORDER)
            setVideoSource(MediaRecorder.VideoSource.CAMERA)
            setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH))
            setOutputFile(getOutputFile())
            setPreviewDisplay(surfaceView.holder.surface)
        }
        mediaRecorder.prepare()
    }

    private fun getOutputFile(): String? {
        var mediaFile: File? = null
        val OutputExist: Boolean = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)
        if (OutputExist) {
            mediaFile = Environment.getExternalStorageDirectory()
            return mediaFile.toString()
        }
        return null
    }

    private fun getDate(): String? {
        Log.d(TAG, "获取录制视频的日期 ")
        val ca: Calendar = Calendar.getInstance()
        val year: Int = ca.get(Calendar.YEAR) // 获取年份
        val month: Int = ca.get(Calendar.MONTH) // 获取月份
        val day: Int = ca.get(Calendar.DATE) // 获取日
        return "" + year + "_" + (month + 1) + "_" + day
    }

    private fun getOutputMediaFile(): String? {
        Log.d(TAG, "获取视频存储的位置 ")
        val mediaPath = getOutputFile()
        if (mediaPath != null) {
            val mediaFile = File("$mediaPath/recordVideo")
            if (!mediaFile.exists()) {
                mediaFile.mkdir()
            }
            return mediaFile.absolutePath + File.separator + getDate() + ".mp4"
        }
        return null
    }

    private fun release() {
        mediaRecorder.reset()
        mediaRecorder.release()

        camera?.lock()
        camera?.release()
    }
}