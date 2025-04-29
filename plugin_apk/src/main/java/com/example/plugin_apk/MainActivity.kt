package com.example.plugin_apk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_router)
    }

    fun jumpToEditText(view: View) {
        val intent = Intent(this, TestEditTextActivity::class.java)
        startActivity(intent)
    }
}
