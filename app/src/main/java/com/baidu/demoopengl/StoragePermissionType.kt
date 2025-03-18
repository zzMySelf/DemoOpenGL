package com.baidu.demoopengl

/**
 * Day：2023/6/7 10:34
 *
 * @author zhanglei
 */
enum class StoragePermissionType {
    /**
     * 读取图片
     */
    IMAGES,

    /**
     * 读取视频
     */
    VIDEO,

    /**
     * 读取音频
     */
    AUDIO,

    /**
     * 读取图片和视频
     */
    IMAGES_AND_VIDEO,

    /**
     * 读取图片和音频
     */
    IMAGES_AND_AUDIO,

    /**
     * 读取视频和音频
     */
    VIDEO_AND_AUDIO,

    /**
     * 全部读取，图片、视频、音频
     */
    ALL
}
