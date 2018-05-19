package com.algorithm.zhw

import java.math.BigDecimal

/**
 * Created by sfghjtj on 2018/5/19.
 */
object PartitionHash {

    /**
     * 数据集进行虚拟逻辑分区，方便以后物理机节点横向扩展。这里的partition_key利用一致性hash进行模拟，返回尽量平均的数据区域
     * e.g.
     * 虚拟分片：10,物理机数：4，结果每个物理的分片为[3,2,3,2]->[0..2,3..4,5..7,8..9]
     */
    fun consHashPartion(resultList: ArrayList<Int>, partitionKey: Int, machineNum: Int) {

        ensure(partitionKey >= machineNum, "虚拟分片必须大于物理机的数目！")
        //递归recursion计算结束
        if (machineNum <= 0) return
        val cal = partitionKey % machineNum
        if (cal == 0) {
            repeat(machineNum){
                resultList.add(partitionKey/machineNum)
            }
            return
        }else{
            val roundCal = BigDecimal((partitionKey.toDouble() / machineNum).toString()).setScale(0, BigDecimal.ROUND_HALF_UP).toInt()
            resultList.add(roundCal)
            consHashPartion(resultList, partitionKey - roundCal, machineNum - 1)
        }
    }

    /**
     * 结果每个物理的分片为[3,2,3,2]->[0..2,3..4,5..7,8..9]
     */
    fun conHashPartionToArea(partitionKey: Int, machineNum: Int): List<IntRange> {
        val listPartion = ArrayList<Int>(machineNum)
        consHashPartion(listPartion, partitionKey, machineNum)
        return listPartion.mapIndexed { index, i ->
            if (index == 0) {
                IntRange(index,i-1)
            }else{
                val start = (0..(index-1)).sumBy { listPartion[it] }
                IntRange(start,i+start-1)
            }
        }
    }
}