package com.kawo.algorithm.launcher

import com.kawo.algorithm.code.weeka.impl.WeekAExec
import com.kawo.algorithm.common.WorkExector

/**
 * 程序入口类
 */
object Main {

    /**
     * 程序执行方法入口
     */
    @JvmStatic
    fun main(args: Array<String>) = WorkExector.create()
        .registerWork<WeekAExec>()
        .exec()

}