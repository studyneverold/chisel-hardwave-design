import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class HelloTest1 extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "Hellopeak"
  it should "passok" in {
    test(new Hello).withAnnotations(Seq(WriteVcdAnnotation)) { c =>
      c.clock.setTimeout(0)
      var ledStatus = BigInt(-1)
      println("Start the blinking LED")
      for (_ <- 0 until 100) {
        c.clock.step(10000)
        val ledNow = c.io.led.peek().litValue
        val s = if (ledNow == 0) "o" else "*"
        if (ledStatus != ledNow) {
          System.out.println(s)
          ledStatus = ledNow
        }
      }
      println("\nEnd the blinking LED")
    }
  }
}
