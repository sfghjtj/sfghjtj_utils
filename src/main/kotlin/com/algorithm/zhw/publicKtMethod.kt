package com.algorithm.zhw

/**
 * Created by sfghjtj on 2018/5/19.
 */
fun ensure(expression: Boolean, vararg args: String) {
    if (!expression) throw BussinessBlockingException(*args)
}