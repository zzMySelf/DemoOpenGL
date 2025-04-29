package com.example.plugin_apk

import android.os.Bundle
import android.widget.Toast

class TestEditTextActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_edit_text)
        Toast.makeText(this, "哈哈哈", Toast.LENGTH_SHORT).show()
    }
}