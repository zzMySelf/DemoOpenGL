package com.example.plugin

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.res.Resources
import android.os.Build
import android.os.Handler
import android.os.Message
import android.os.Process
import android.util.ArrayMap
import android.util.Log
import java.io.File
import java.lang.ref.WeakReference
import java.lang.reflect.Field
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
                        if (args[i] is String && args[i] == PLUGIN_PKG) {
                            args[i] = "com.baidu.demoopengl"
                        }
                    }
                    if (raw?.component?.packageName == PLUGIN_PKG) {
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
    private fun replaceAfter9(msg: Message) {
        try {
            val mActivityCallbacksField = msg.obj.javaClass.getDeclaredField("mActivityCallbacks")
            mActivityCallbacksField.isAccessible = true

            val mActivityCallbacks = mActivityCallbacksField.get(msg.obj) as List<*>
            for (i in mActivityCallbacks.indices) {
                if (mActivityCallbacks[i]?.javaClass?.name.equals("android.app.servertransaction.LaunchActivityItem")) {
                    val launchActivityItem = mActivityCallbacks[i]

                    // 替换loadedApk中的classloader
                    Log.e("zyl", "开始替换loadedApk中的classloader")
                    val apkPath = File(App.baseContext()?.getExternalFilesDir(null), PLUGIN_NAME).absolutePath
                    val launchActivityItemClass = Class.forName("android.app.servertransaction.LaunchActivityItem")
                    if (launchActivityItem != null) {
                        replaceClassloader(apkPath, launchActivityItemClass, launchActivityItem)
                    }
                    Log.e("zyl", "完成替换loadedApk中的classloader")

                    val mIntentField = launchActivityItem?.javaClass?.getDeclaredField("mIntent")
                    mIntentField?.isAccessible = true

                    val proxyIntent = mIntentField?.get(launchActivityItem) as Intent
                    val intent = proxyIntent.getParcelableExtra<Intent>(TARGET_INTENT)
                    intent?.let {
                        Log.w("zyl", "hook replaceAfter9 替换成功")
                        mIntentField.set(launchActivityItem, intent)
                    }
                }
            }
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

    private fun getApplicationInfoByPackageArchiveInfo(pluginPath: String): ApplicationInfo? {
        // 根据插件apk路径生成对应的PackageInfo对象
        val packageManager = App.baseContext()?.packageManager
        if (packageManager == null) {
            Log.i("zyl", "get PackageManager failed")
            return null
        }

        val packageInfo = packageManager.getPackageArchiveInfo(pluginPath, 0)
        if (packageInfo == null) {
            Log.i("zyl", "get packageInfo failed")
            return null
        }
        return packageInfo.applicationInfo
    }

    private fun generateApplicationInfo(pluginPath: String): ApplicationInfo? {
        return try {
            val applicationInfo = getApplicationInfoByPackageArchiveInfo(pluginPath)
            if (applicationInfo == null) {
                Log.i("zyl", "get applicationInfo failed")
                return null
            }
            // 设置资源加载路径
            applicationInfo.sourceDir = pluginPath
            applicationInfo.publicSourceDir = pluginPath
            // 设置隶属于哪一个 uid
            applicationInfo.uid = Process.myUid()
            applicationInfo
        } catch (e: Exception) {
            Log.i("zyl", "generateApplicationInfo failed: ${e.message}")
            null
        }
    }

    @SuppressLint("PrivateApi")
    private fun replaceClassloader(pluginPath: String, mLaunchActivityItemCls: Class<*>, obj: Any) {
        // 获取到 ActivityThread 对象
        val activityThreadClass = Class.forName("android.app.ActivityThread")
        val sCurrentActivityThreadField = activityThreadClass.getDeclaredField("sCurrentActivityThread")
        sCurrentActivityThreadField.isAccessible = true
        val sCurrentActivityThread = sCurrentActivityThreadField.get(null)

        // 获取 mPackages
        val mPackagesField = activityThreadClass.getDeclaredField("mPackages")
        mPackagesField.isAccessible = true
        val mPackages = mPackagesField.get(sCurrentActivityThread) as? ArrayMap<*, *>
        if (mPackages == null) {
            Log.i(TAG, "can not get mPackages")
            return
        }

        // 获取插件 ApplicationInfo
        val applicationInfo = generateApplicationInfo(pluginPath)
        if (applicationInfo != null) {
            // 获取 CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO
            val compatibilityInfoClass = Class.forName("android.content.res.CompatibilityInfo")
            val defaultCompatibilityInfoField = compatibilityInfoClass.getDeclaredField("DEFAULT_COMPATIBILITY_INFO")
            defaultCompatibilityInfoField.isAccessible = true
            val defaultCompatibilityInfo = defaultCompatibilityInfoField.get(null)

            // 调用 getPackageInfo 方法
            val getPackageInfoMethod = activityThreadClass.getDeclaredMethod(
                "getPackageInfo",
                ApplicationInfo::class.java,
                compatibilityInfoClass,
                Int::class.javaPrimitiveType
            )
            getPackageInfoMethod.isAccessible = true
            val loadedApk = getPackageInfoMethod.invoke(
                sCurrentActivityThread, applicationInfo, defaultCompatibilityInfo, Context.CONTEXT_INCLUDE_CODE
            )

            val pluginPkgName = applicationInfo.packageName
            if (!pluginPkgName.isNullOrEmpty()) {
                Log.i(TAG, "plugin pkg name is $pluginPkgName")
                // 替换 ActivityInfo 中包名
                replacePkgName(mLaunchActivityItemCls, obj, pluginPkgName)
                // 设置 ClassLoader
                setLoadedApkClassloader(loadedApk!!)
            } else {
                Log.i(TAG, "get plugin pkg name failed")
            }
        } else {
            Log.i(TAG, "can not get application info")
        }
    }

    @Throws(Exception::class)
    private fun replacePkgName(mLaunchActivityItemCls: Class<*>, obj: Any, pkgName: String) {
        val mInfoField = mLaunchActivityItemCls.getDeclaredField("mInfo")
        mInfoField.isAccessible = true
        val activityInfo = mInfoField.get(obj) as ActivityInfo
        activityInfo.applicationInfo.packageName = pkgName
    }

    @Throws(Exception::class)
    private fun setLoadedApkClassloader(loadedApk: Any) {
        val dexClassLoader = PluginLoadManager.pluginClassLoader
        val mClassLoaderField = loadedApk.javaClass.getDeclaredField("mClassLoader")
        mClassLoaderField.isAccessible = true
        mClassLoaderField.set(loadedApk, dexClassLoader)
    }

    @SuppressLint("PrivateApi")
    fun hookPackageManager() {
        try {
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            val currentActivityThreadField = activityThreadClass.getDeclaredField("sCurrentActivityThread")
            currentActivityThreadField.isAccessible = true
            val currentActivityThread = currentActivityThreadField.get(null)

            val packageManagerField = activityThreadClass.getDeclaredField("sPackageManager")
            packageManagerField.isAccessible = true
            val sPackageManager = packageManagerField.get(currentActivityThread)

            val iPackageManagerInterface = Class.forName("android.content.pm.IPackageManager")

            val proxy = Proxy.newProxyInstance(
                iPackageManagerInterface.classLoader,
                arrayOf(iPackageManagerInterface)
            ) { proxy, method, args ->
                if (method.name == "getPackageInfo") {
                    val packageName = args?.get(0) as? String
                    if (packageName == PLUGIN_PKG) {
                        // 是插件的包名，返回一个假的 PackageInfo
                        val packageInfo = PackageInfo()
                        packageInfo.packageName = PLUGIN_PKG
                        return@newProxyInstance packageInfo
                    }
                }
                // 其他方法，正常转发
                method.invoke(sPackageManager, *(args ?: arrayOfNulls<Any>(0)))
            }

            // 把代理对象设置回去
            packageManagerField.set(currentActivityThread, proxy)

        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    @SuppressLint("PrivateApi")
    private fun getPackageInfo(context: Context): Any? {
        // 实现获取 LoadedApk 的方法
        val packageInfoField: Field = context.javaClass.getDeclaredField("mPackageInfo")
        packageInfoField.isAccessible = true
        return packageInfoField.get(context)
    }

    @SuppressLint("PrivateApi")
    private fun getActivityThread(context: Context): Any? {
        val activityThreadClass = Class.forName("android.app.ActivityThread")
        val currentActivityThreadField: Field = activityThreadClass.getDeclaredField("sCurrentActivityThread")
        currentActivityThreadField.isAccessible = true
        return currentActivityThreadField.get(null)
    }
}