package adder
import chisel3._


object generate extends App {
    val n = 16
  //circt.stage.ChiselStage
    //.emitSystemVerilogFile(new CarryLookaheadAdder(166),Array("--target-dir","generated"))
  //println(chisel3.emitVerilog(new CarryLookaheadAdder(16),Array("--target-dir","generated")))
    chisel3.emitVerilog(new CarryLookaheadAdder(n),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new ManchesterCarryChain(n),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new half_adder(1),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new full_adder(1),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new C22(),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new C32(),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new C53(),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new rca(n),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new csa(n),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new ManchesterAdder(n),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new CarrySkipAdder(n),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new MixedAdder(n),Array("--target-dir","generated/adder"))
    chisel3.emitVerilog(new CarrySaveAdder(n),Array("--target-dir","generated/adder"))
}