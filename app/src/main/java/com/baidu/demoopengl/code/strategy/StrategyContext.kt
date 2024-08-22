package com.baidu.demo.strategy

/**
 * Day：2024/7/12 10:59
 * @author zhangyelei
 */
object StrategyContext {

    fun getStrategy(type: String): Strategy? {

        return when(type) {
            "JiuDian"-> {
                JiuDian()
            }

            "WaiMai" -> {
                Waimai()
            }

            else -> null
        }
    }
}