package lectures.part3_functionalProgramming

object WhatsaFunction extends App {
  /*
  use functions as first class elements like we work with values
  to use function execute we have to instantiate the class anon or nonanon way
  all scala functions are objects or instances of classes being derived from function1 to function 22
  higher order functions receives another function as a parameter or give another
  function as a output e.g. map, flatmap and filter
   */

  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  //function types supported by scala: Function1..Function22.
  //function1 means one input and one output
  //function2 means two input and one output
  //...and so on till function22
  val stringToInt = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToInt("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  //Function types Function2[A,B,R] === (A, B) => R

  /*
Exercises
1. a function which takes 2 strings and concatenates them
2. transform the my predicate and my transformer into function types
3. function takes int and returns another functions which takes int and returns int

 */
  def concat: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concat("Hello", "Scala"))

  val func: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = func(3)
  println(adder3(4))
  println(func(3) (4)) //curried function
  //curried function can be called with multiple parameter list
}

trait MyFunction[A,B] {
  def apply(element: A): B
}


