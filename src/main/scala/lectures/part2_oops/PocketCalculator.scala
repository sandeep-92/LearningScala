package lectures.part2_oops

class OverflowException extends RuntimeException
class UnderflowException extends RuntimeException
class MathCalculationException extends RuntimeException("Division by 0 not allowed")
class PocketCalculator {

  def add(x: Int, y: Int): Int = {
    val addition = x + y
    if (x > 0 && y > 0 && addition < 0) throw new OverflowException
    else if (x < 0 && y < 0 && addition > 0) throw new UnderflowException
    else addition
  }

  def subtract(x: Int, y: Int): Int = {
    val subtraction = x - y
    if (x > 0 && y < 0 && subtraction > 0) throw new OverflowException
    else if (x < 0 && y > 0 && subtraction > 0) throw new UnderflowException
    else subtraction
  }

  def multiply(x: Int, y: Int): Int = {
    val multiplication = x * y
    if (x > 0 && y > 0 && multiplication < 0) throw new OverflowException
    else if (x < 0 && y > 0 && multiplication > 0) throw new UnderflowException
    else if(x > 0 && y < 0 && multiplication > 0) throw new UnderflowException
    else multiplication
  }

  def devide(x: Int, y: Int): Int = {

    if (y == 0) throw new MathCalculationException
    else (x / y)
  }

}
object PocketCalculator extends App {
  val calci = new PocketCalculator
  println(calci.add(Int.MaxValue, 10))
  println(calci.subtract(Int.MinValue, -5))
}
