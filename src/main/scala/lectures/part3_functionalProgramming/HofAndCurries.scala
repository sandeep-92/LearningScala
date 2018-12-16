package lectures.part3_functionalProgramming

object HofAndCurries extends App {

  //a function that takes another function as a parameter is called higher order function
  //examples are map, flatmap and filter

  //function that applies another function n times over x
  //nTimes(f, n, x)
  //nTimes => f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  //nTimes(f, n, x) => f(f(...f(x))) = nTimes(f, n-1, f(x))

  def nTimes(f : Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  val plusOne = (x: Int) => (x + 1)
  println(nTimes(plusOne, 5, 10))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimes(f, n-1, f(x))
  }

  val plusTen = nTimesBetter(plusOne, 10)
  println(plusTen(1))

  //curried function
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  //functions with multiple parameter list
  def curriedFormatter(c: String) (x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

}
