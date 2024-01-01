package adder

import chisel3._

class ManchesterCarryChain(n: Int) extends Module {
  val io = IO(new Bundle {
    val cin = Input(UInt(n.W))
    val g = Output(UInt(n.W))
    val p = Output(UInt(n.W))
    val cout = Output(UInt(n.W))
  })

  val g = Wire(Vec(n, UInt(1.W)))
  val p = Wire(Vec(n, UInt(1.W)))
  g(0) := io.cin(0)
  p(0) := ~io.cin(0)
  for (i <- 1 until n) {
    g(i) := io.cin(i) | (g(i - 1) & io.cin(i - 1))
    p(i) := ~io.cin(i) & (p(i - 1) | io.cin(i - 1))
  }
  io.g := g.asUInt
  io.p := p.asUInt
  io.cout := g(n - 1) | (p(n - 1) & io.cin(n - 1))
}

class ManchesterAdder(n: Int) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(n.W))
    val b = Input(UInt(n.W))
    val cin = Input(UInt(1.W))
    val sum = Output(UInt(n.W))
    val cout = Output(UInt(1.W))
  })

  val chain = Module(new ManchesterCarryChain(n))
  chain.io.cin := io.a ^ io.b
  val sumReg = RegInit(0.U(n.W))
  val coutReg = RegInit(0.U(1.W))
  sumReg := chain.io.g(n - 1) ^ chain.io.p(n - 1)
  coutReg := chain.io.cout
  io.sum := sumReg
  io.cout := coutReg
}




