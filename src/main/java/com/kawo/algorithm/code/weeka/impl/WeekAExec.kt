package com.kawo.algorithm.code.weeka.impl

import com.kawo.algorithm.code.weeka.agreement.WeekAExecAgreement
import com.kawo.algorithm.code.weeka.vo.Node
import com.kawo.algorithm.common.LOGGER
import com.kawo.algorithm.common.SpeedTimeStatistics
import com.kawo.algorithm.common.speed

class WeekAExec : WeekAExecAgreement {

    private val engine = WeekAHomeWork()

    override fun maxArea() = speed {
        LOGGER.info("11. 盛最多水的容器 执行完毕","预期结果 49 实际结果:${engine.maxArea(arrayOf(1,8,6,2,5,4,8,3,7))}");
    }

    override fun moveZeroes() = speed {
        var array = arrayOf(0,1,0,3,12)
        engine.moveZeroes(array)
        var string = ""
        for (i in array) {
            string += " $i"
        }
        LOGGER.info("283. 移动零 执行完毕","预期结果 [1,3,12,0,0] 实际结果:$string");
    }

    override fun climbStairs() = speed {
        LOGGER.info("70. 爬楼梯 执行完毕","预期结果 89 实际结果:${engine.climbStairs(10)}");
    }

    override fun threeSum() = speed {
        LOGGER.info("15. 三数之和"," 预期结果:[[-1, 2, -1], [-1, 1, 0]] 实际结果:${engine.threeSum(arrayOf(-1, 0, 1, 2, -1, -4))}");
    }

    override fun reverseKGroup() = speed {
        var start = Node(1)
        var temp : Node = start
        for (i in 2 .. 100){
            temp.next = Node(i)
            temp.next?.apply {
                temp = this
            }
        }
        LOGGER.debug("25. K 个一组翻转链表","orginData 原始数据：${nodeToString(start)}")
        LOGGER.debug("25. K 个一组翻转链表","orginData 反转后数据：${nodeToString(engine.reverseKGroup(start,5))}")
    }

    private fun nodeToString(node :Node):String{
        var orginData = ""
        var fortemp : Node? = node
        while (fortemp != null){
            orginData += " ${fortemp.data}"
            fortemp = fortemp.next
        }
        return orginData
    }

    override fun detectCycle() = speed {

    }

    override fun hasCycle() = speed {

    }

    override fun swapPairs() = speed {

    }

    override fun reverseList() = speed {

    }

    override fun plusOne() = speed {

    }

    override fun twoSum() = speed {

    }

    override fun merge() = speed {

    }

    override fun mergeTwoLists() = speed {

    }

    override fun rotate() = speed {

    }

    override fun removeDuplicates() = speed {

    }

    override fun trap() = speed {

    }

    override fun dequeTest() = speed {

    }

    override fun maxSlidingWindow() = speed {

    }

    override fun largestRectangleArea() = speed {

    }

    override fun minStack() = speed {

    }

    override fun isValid() = speed {

    }


    override fun exec() {
        maxArea()
        moveZeroes()
        climbStairs()
        threeSum()
        reverseKGroup()
        SpeedTimeStatistics.printSpeedCount()
    }

}