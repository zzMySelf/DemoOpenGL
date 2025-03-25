package com.baidu.demoopengl.opencv

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.baidu.demoopengl.R
import com.baidu.demoopengl.opengl.MyNativeRender

class PictureFrameActivity : AppCompatActivity() {
    private var blurBg: ImageView? = null
    private var pictureView: ImageView? = null
    private val nativeRender by lazy { MyNativeRender() }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, PictureFrameActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_frame)
        blurBg = findViewById(R.id.blur_bg)
        pictureView = findViewById(R.id.picture_iv)
        loadImage()
    }

    private fun loadImage() {
        val path = "/sdcard/Pictures/BD_1695288856317.jpg"
        val originalBitmap = BitmapFactory.decodeFile(path);
        pictureView?.setImageBitmap(originalBitmap);

        val bgBitmap = BitmapFactory.decodeFile(path);
        nativeRender.native_blur_bitmap(bgBitmap);
        blurBg?.setImageBitmap(bgBitmap);
    }
}