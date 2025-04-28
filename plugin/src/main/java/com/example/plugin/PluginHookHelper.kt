package com.example.plugin

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Message
import android.util.Log
import java.lang.reflect.Field
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * Day：2025/4/27 17:27
 * @author zhangyelei
 */

object PluginHookHelper {
    private const val TARGET_INTENT = "target_intent"

    fun hookAmsBinderProxy() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
            hookIActivityTaskManager()
        } else {
            hookIActivityManager()
        }
    }

    @SuppressLint("PrivateApi")
    private fun hookIActivityTaskManager() {
        try {
            var singletonFiled: Field? = null;
            val activityManager = Class.forName("android.app.ActivityTaskManager")
            singletonFiled = activityManager.getDeclaredField("IActivityTaskManagerSingleton");
            singletonFiled.isAccessible = true

            val singleton: Any? = singletonFiled.get(null)
            val singletonClass = Class.forName("android.util.Singleton")
            val mInstanceField = singletonClass.getDeclaredField("mInstance")
            mInstanceField.isAccessible = true
            val IActivityTaskManager = mInstanceField.get(singleton)

            if (IActivityTaskManager == null) {
                Log.e("zyl", "hookIActivityTaskManager IActivityTaskManager is null")
                return
            }

            val proxy = Proxy.newProxyInstance(
                Thread.currentThread().contextClassLoader,
                arrayOf(Class.forName("android.app.IActivityTaskManager"))
            ) { proxy, method, args ->
                var raw: Intent? = null
                var index = -1
                if ("startActivity" == method.name) {
                    for (i in args.indices) {
                        if (args[i] is Intent) {
                            raw = args[i] as Intent
                            index = i
                        }
                    }
                    if (raw?.component?.packageName == "com.example.minedemo") {
                        val newIntent = Intent();
                        newIntent.component = ComponentName(
                            "com.baidu.demoopengl",
                            "com.example.plugin.PluginProxyActivity"
                        )
                        newIntent.putExtra(TARGET_INTENT, raw)
                        args[index] = newIntent

                        Log.w("zyl", "hook startActivity replace target intent")
                    }
                }
                return@newProxyInstance method.invoke(IActivityTaskManager, *args)
            }

            mInstanceField.set(singleton, proxy)
            Log.e("zyl", "hookIActivityTaskManager hook success!!!")
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }



    @SuppressLint("PrivateApi")
    private fun hookIActivityManager() {
        try {
            var singletonFiled: Field? = null;
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                val clazz = Class.forName("android.app.ActivityManagerNative")
                singletonFiled = clazz.getDeclaredField("gDefault")
            } else {
                val clazz = Class.forName("android.app.ActivityManager")
                singletonFiled = clazz.getDeclaredField("IActivityManagerSingleton")
            }

            val activityManager = Class.forName("android.app.ActivityManager")
            singletonFiled = activityManager.getDeclaredField("IActivityTaskManagerSingleton");
            singletonFiled.isAccessible = true

            val singleton: Any? = singletonFiled.get(null)
            val singletonClass = Class.forName("android.util.Singleton")
            val mInstanceField = singletonClass.getDeclaredField("mInstance")
            mInstanceField.isAccessible = true

            val mInstance = mInstanceField.get(singleton)
            val iActivityManagerClass = Class.forName("android.app.IActivityManager")

            val proxy = Proxy.newProxyInstance(
                Thread.currentThread().contextClassLoader,
                arrayOf(iActivityManagerClass)
            ) { proxy, method, args ->
                if ("startActivity" == method.name) {
                    var index = -1
                    for (i in args.indices) {
                        if (args[i] is Intent) {
                            index = i
                            break;
                        }
                    }
                    val intent = args[index] as Intent

                    val proxyIntent = Intent();
                    proxyIntent.setComponent(
                        ComponentName(
                            "com.baidu.demoopengl",
                            "com.example.plugin.PluginProxyActivity"
                        )
                    )
                    proxyIntent.putExtra(TARGET_INTENT, intent)
                    args[index] = proxyIntent
                }

                return@newProxyInstance method.invoke(mInstance, args)
            }

            mInstanceField.set(singleton, proxy)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    @SuppressLint("PrivateApi")
    fun hookHandler() {
        try {
            val clazz = Class.forName("android.app.ActivityThread")
            val activityThreadField = clazz.getDeclaredField("sCurrentActivityThread")
            activityThreadField.isAccessible = true

            val activityThread = activityThreadField.get(null)
            val mHField = clazz.getDeclaredField("mH");
            mHField.isAccessible = true
            val mH = mHField.get(activityThread) as Handler

            val mCallbackField = Handler::class.java.getDeclaredField("mCallback")
            mCallbackField.isAccessible = true

            val callback = Handler.Callback { msg ->
                when (msg.what) {
                    100 -> {
                        replaceBelow9(msg)
                    }

                    159 -> {
                        replaceAfter9(msg)
                    }
                }
                false
            }
            mCallbackField.set(mH, callback)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    private fun replaceBelow9(msg: Message) {
        try {
            val intentField = msg.obj.javaClass.getDeclaredField("intent")
            intentField.isAccessible = true

            val proxyIntent = intentField.get(msg.obj) as Intent
            val intent = proxyIntent.getParcelableExtra<Intent>(TARGET_INTENT)
            intent?.let {
                intentField.set(msg.obj, intent)
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    private fun replaceAfter9(msg: Message) {
        try {
            val mActivityCallbacksField = msg.obj.javaClass.getDeclaredField("mActivityCallbacks")
            mActivityCallbacksField.isAccessible = true

            val mActivityCallbacks = mActivityCallbacksField.get(msg.obj) as List<*>
            for (i in mActivityCallbacks.indices) {
                if (mActivityCallbacks[i]?.javaClass?.name.equals("android.app.servertransaction.LaunchActivityItem")) {
                    val launchActivityItem = mActivityCallbacks[i]
                    val mIntentField = launchActivityItem?.javaClass?.getDeclaredField("mIntent")
                    mIntentField?.isAccessible = true

                    val proxyIntent = mIntentField?.get(launchActivityItem) as Intent
                    val intent = proxyIntent.getParcelableExtra<Intent>(TARGET_INTENT)
                    intent?.let {
                        mIntentField.set(launchActivityItem, intent)
                    }
                }
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }
}