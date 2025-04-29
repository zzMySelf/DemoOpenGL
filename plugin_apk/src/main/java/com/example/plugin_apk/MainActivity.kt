package com.example.plugin_apk

import android.content.Intent
import android.os.Bundle
import android.widget.Button


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_router)

        findViewById<Button>(R.id.jumpToEditText)?.setOnClickListener {
            val intent = Intent(this, TestEditTextActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
