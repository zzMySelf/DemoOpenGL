package com.baidu.demoopengl.image

import android.net.Uri
import android.provider.MediaStore
import java.util.Arrays

/**
 * Day：2024/8/23 14:30
 * @author zhangyelei
 */
object MediaConfig {

    /** 查询uri  */
    val QUERY_URI: Uri by lazy { MediaStore.Files.getContentUri("external") }

    /** 查询图片类型和视频类型  */
    val SELECTION_ARGS = arrayOf(
        MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE.toString(),
        MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO.toString()
    )

    /** 排序方式  */
    val ORDER_BY = MediaStore.Video.Media.DATE_ADDED + " DESC"

    /** 查询媒体类型  */
    val SELECTION = (MediaStore.Files.FileColumns.MEDIA_TYPE + " = ? or " + MediaStore.Files.FileColumns.MEDIA_TYPE + " = ? "
            + " AND " + MediaStore.MediaColumns.SIZE + " > 0")

    /** 列：相册id  */
    private val COLUMN_BUCKET_ID = "bucket_id"

    /** 列：相册名称  */
    private val COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name"

    /**
     * 查询列
     */
    val PROJECTION by lazy {
        arrayOf(
            COLUMN_BUCKET_ID,
            COLUMN_BUCKET_DISPLAY_NAME,
            MediaStore.MediaColumns.ORIENTATION,
            MediaStore.MediaColumns.DURATION,
            MediaStore.MediaColumns.DATA,
            MediaStore.MediaColumns.SIZE,
            MediaStore.MediaColumns.WIDTH,
            MediaStore.MediaColumns.HEIGHT,
            MediaStore.MediaColumns.DATE_ADDED,
            MediaStore.MediaColumns._ID,
            MediaStore.MediaColumns.MIME_TYPE
        )
    }

    /** 图片格式  */
    private val mImageSuffixList = ArrayList<String>(
        listOf<String>(
            MimeType.PNG.type,
            MimeType.JPG.type,
            MimeType.JPEG.type,
            MimeType.GIF.type,
            MimeType.WEBP.type,
        )
    )

    /** 视频格式  */
    private val mVideoSuffixList = ArrayList<String>(
        listOf<String>(
            MimeType.MP4.type,
            MimeType.MOV.type
        )
    )
}