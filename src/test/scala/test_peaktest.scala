import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import chisel3._
import chisel3.util.Cat
class BoothMultiplierTest extends AnyFlatSpec with ChiselScalatestTester {
    behavior of "peakadd"

    it should "multiply two numbers correctly" in {
        test(new BoothMultiplier).withAnnotations(Seq(WriteVcdAnnotation)) { c =>
            c.clock.setTimeout(0)
            
            // Set input values
            c.io.a.poke(5.U)
            c.io.b.poke(3.U)
            
            // Wait for a few clock cycles
            c.clock.step(5)
            
            // Check the output value
            c.io.result.expect(15.U)
        }
    }
}