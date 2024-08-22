package com.baidu.demoopengl.code.task

/**
 * Day：2024/7/12 11:20
 * @author zhangyelei
 */
enum class TaskState(message: String) {
    INIT("初始化"),
    ONGOING("进行中"),
    PAUSED("暂停中"),
    FINISHED("已完成"),
    EXPIRED("已过期")
}