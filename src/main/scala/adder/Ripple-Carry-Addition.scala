package  adder
import chisel3._
import chisel3.util.Cat
class rca(n:Int) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(n.W))
    val b = Input(UInt(n.W))
    val cin = Input(UInt(n.W))
    val sum = Output(UInt(n.W))
    val cout = Output(UInt(n.W))
  })

  io.sum := io.a ^ io.b ^ io.cin
  io.cout := io.a & io.b | io.a & io.cin | io.b & io.cin
}
