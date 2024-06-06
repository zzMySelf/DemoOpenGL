package com.baidu.demoopengl

import java.io.*
import java.nio.channels.FileChannel

/**
 * Day：2024/6/6 16:26
 * @author zhangyelei
 */
object FileUtils {

    @Throws(IOException::class)
    fun copyFile(srcFile: File?, destFile: File?): Boolean {
        return if (srcFile == null) {
            false
        } else if (destFile == null) {
            false
        } else if (!srcFile.exists()) {
            false
        } else if (srcFile.isDirectory) {
            false
        } else if (srcFile.canonicalPath == destFile.canonicalPath) {
            false
        } else {
            val parentFile = destFile.parentFile
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory) {
                false
            } else if (destFile.exists() && !destFile.canWrite()) {
                false
            } else {
                doCopyFile(srcFile, destFile)
            }
        }
    }

    @Throws(IOException::class)
    private fun doCopyFile(srcFile: File, destFile: File): Boolean {
        return if (destFile.exists() && destFile.isDirectory) {
            false
        } else {
            var fis: FileInputStream? = null
            var fos: FileOutputStream? = null
            var input: FileChannel? = null
            var output: FileChannel? = null
            try {
                fis = FileInputStream(srcFile)
                fos = FileOutputStream(destFile)
                input = fis.channel
                output = fos.channel
                val size = input.size()
                var pos = 0L
                var count = 0L
                while (pos < size) {
                    count = if (size - pos > 31457280L) 31457280L else size - pos
                    pos += output.transferFrom(input, pos, count)
                }
                true
            } catch (e: Exception) {
                e.printStackTrace()
                false
            } finally {
                closeStream(output)
                closeStream(fos)
                closeStream(input)
                closeStream(fis)
            }
        }
    }


    private fun closeStream(stream: Closeable?) {
        if (stream != null) {
            try {
                stream.close()
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}