import chisel3._
import chiseltest._
/*
class ManchesterCarryChainTester1 extends App with ChiselScalatestTester {
  "ManchesterCarryChain should generate correct results" in {
    test(new ManchesterCarryChain(4)) { dut =>
      // 输入测试值
      dut.io.cin.poke("b1010".U)

      // 等待几个时钟周期
      dut.clock.step(1)

      // 打印输出
      println(s"Generate (g): ${dut.io.g.peek().toString(2)}")
      println(s"Propagate (p): ${dut.io.p.peek().toString(2)}")
      println(s"Carry-out (cout): ${dut.io.cout.peek().toString(2)}")
    }
  }
}

object ManchesterCarryChainTesterMain extends App {
  new ManchesterCarryChainTester
}
*/