package com.baidu.demoopengl.image

/**
 * Day：2024/8/23 14:47
 * @author zhangyelei
 */
enum class MimeType(val type: String) {
    // Image types
    JPG("image/jpg"),
    JPEG("image/jpeg"),
    GIF("image/gif"),
    PNG("image/png"),
    WEBP("image/webp"),

    // Video types
    MP4("video/mp4"),
    MOV("video/mov");

    companion object {
        // 通过扩展函数获取 MIME 类型
        fun fromExtension(extension: String): MimeType? {
            return values().find { it.name.equals(extension, ignoreCase = true) }
        }
    }

    // 是否为图片类型
    fun isImage(): Boolean {
        return this.type.startsWith("image/")
    }

    // 是否为视频类型
    fun isVideo(): Boolean {
        return this.type.startsWith("video/")
    }
}