package addition.prefixadder.common

import addition.prefixadder.PrefixAdder
import chisel3.Bool

/** [[RippleCarrySum]]: N-1 area, N-1 depth
  * not need to explain
  */
object RippleCarrySum extends CommonPrefixSum {
  def apply(summands: Seq[(Bool, Bool)]): Vector[(Bool, Bool)] = {

    /**
      * generate prefix tree layer by layer.
      * offset is the mark of layers'end(It should generate next layer)
      * offset是层结束的标记（它应该生成下一层）
      */
    def helper(offset: Int, x: Vector[(Bool, Bool)]): Vector[(Bool, Bool)] = {
      if (offset >= x.size) {
Z
        /**
          * if `offset >= x.size`, return the apply function,
          * Since type T = (Bool, Bool), It return the refering to these P, G pairs
          * which will be used to generate carry signal.
          */
        /**
        * 如果 `offset >= x.size`，则返回 apply 函数，
        * 由于类型 T = (Bool, Bool)，它返回引用这些 P, G 对
        * 这些对将用于生成进位信号。
        */  
        logger.trace(s"offset: $offset >= x.size: ${x.size}, will return:")
        x
      } else {

        /**
          * if `offset < x.size` means we still didn't reach the end of adder,
          * that the last bits signal is not embbed to the pg generation pair.
          * [[layer]] means the current layer of reference.
          */
        /**
          * 如果 `offset < x.size`，意味着我们还没有到达加法器的末尾，
          * 最后的位信号还没有嵌入到 pg 生成对中。
          * [[layer]] 表示当前的参考层。
          */          
        logger.trace(s"offset: $offset < x.size: ${x.size}:")
        val layer: Vector[(Bool, Bool)] = Vector.tabulate(x.size) { i =>
          if (i != offset) {

            /**
              * if `i != offset`,
              * return last layer's reference.
              */
            /**
              * 如果 `i != offset`，
              * 返回上一层的引用。
              */

            logger.trace(s"i: $i != offset: $offset, will not associate")
            x(i)
          } else {

            /**
              * if `i == offset`
              * this will call [[associativeOp]] to prefix multi bits in the prefix adder into current bit,
              * and return the reference to it.
              */
            /**
              * 如果 `i == offset`
              * 这将调用 [[associativeOp]] 将前缀加法器中的多个位前缀到当前位，
              * 并返回对它的引用。
              */              
            logger.trace(s"i: $i == offset: $offset, will associate ${i - 1} and $i")
            associativeOp(Seq(x(i - 1), x(i)))
          }
        }

        /**
          * RippleCarrySum, add offset by 1.
          * 
          */
        helper(offset + 1, layer)
      }
    }

    /**
      * Start from `offset = 1`,
      * and all prefix from layer 0.
      */
    helper(1, summands.toVector)
  }
}

class RippleCarryAdder(width: Int) extends PrefixAdder(width, RippleCarrySum)
