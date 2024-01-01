// 未完待续..
package adder

import  chisel3._

class lingadder(n:Int) extends Module{
  val io = IO(new Bundle {
    val a = Input(UInt(n.W))

  })
}
