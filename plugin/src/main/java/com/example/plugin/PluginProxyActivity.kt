package com.example.plugin

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PluginProxyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plugin_proxy)
    }

    override fun getClassLoader(): ClassLoader {
        return PluginLoadManager.pluginClassLoader ?: super.getClassLoader()
    }

    override fun getResources(): Resources {
        return PluginLoadManager.pluginResources ?: super.getResources()
    }
}