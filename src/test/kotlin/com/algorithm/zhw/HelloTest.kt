package com.algorithm.zhw

import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {


    @Test //测试数据分区
    fun partionHash() {
        val PARTITION_KEY: Int = 8
        val MACHINE_NUMBER: Int = 3
        val result = ArrayList<Int>(MACHINE_NUMBER)
        PartitionHash.consHashPartion(result, PARTITION_KEY, MACHINE_NUMBER)
        println(result)
        println(PartitionHash.conHashPartionToArea(PARTITION_KEY,MACHINE_NUMBER))
    }
}
