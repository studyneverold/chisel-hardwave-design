package adder

import chisel3._
import chisel3.util._

class half_adder(n:Int) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(n.W))
    val b = Input(UInt(n.W))
    val s = Output(UInt(n.W))
    val c = Output(UInt(n.W))
  })
  io.s := io.a ^ io.b
  io.c := io.a & io.b
}

class full_adder(n:Int) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(n.W))
    val b = Input(UInt(n.W))
    val cin = Input(UInt(n.W))
    val s = Output(UInt(n.W))
    val c = Output(UInt(n.W))
  })
  io.s :=  io.a ^ io.b ^ io.cin
  io.c := (io.a & io.b) | (io.a & io.cin) | (io.b & io.cin)
}

class pfull_adder(n:Int) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(n.W))
    val b = Input(UInt(n.W))
    val cin = Input(UInt(n.W))
    val s = Output(UInt(n.W))
    val c = Output(UInt(n.W))
  })
  io.s :=  io.a ^ io.b ^ io.cin
  io.c := (io.a & io.b) | (io.a & io.cin) | (io.b & io.cin)
}