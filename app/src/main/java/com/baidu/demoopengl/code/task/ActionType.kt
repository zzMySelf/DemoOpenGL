package com.baidu.demoopengl.code.task

/**
 * Day：2024/7/12 11:30
 * @author zhangyelei
 */
enum class ActionType(code:Int, message: String) {
    START(1, "开始"),
    STOP(2, "暂停"),
    ACHIEVE(3, "完成"),
    EXPIRE(4, "过期")
}