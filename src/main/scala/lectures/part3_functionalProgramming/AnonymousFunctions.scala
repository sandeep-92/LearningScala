package lectures.part3_functionalProgramming

object AnonymousFunctions extends App {

  //this instantiate trait function1 with override def apply
  //this is called anonymous functions (Lambda)
  val doubler = (x: Int) => x * 2
  //another way to write above is
  val tripler: Int => Int = (x) => x * 3

  //multiple parameters
  val adder: (Int, Int) => Int = (a: Int, b:Int) => a + b

  //no parameters
  val empty = () => 3
  //call lambdas with paranthesis
  println(empty)
  println(empty())

  //curly braces
  val stringToInt = { (s: String) =>
    s.toInt
  }

  val increment: Int => Int = _ + 1 // equivalent to x => x + 1
  val adder2: (Int, Int) => Int = _ + _ //equivalent to (a, b) => a + b

  /*
  Exercises
  1.
   */
}
