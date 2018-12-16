package lectures.part1_basics

object Functions extends App {

  //defining a function in scala
  def aFunction(a: String, b: Int): String =
    a + " "+ b

  //calling a function
  println(aFunction("hello", 3))

  //parameter less functions can be called without the paranthesis
  def aParameterlessFunction(): Int = 32
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  //a recursive function: function that call itself
  def recursiveFunc(a: String, n: Int): String = {

    if (n ==1)a
    else
      a + recursiveFunc(a, n-1)

  }

  println(recursiveFunc("hello ", 4))

  //when you need loops use recursion
  //recursive function needs a result type

  //a function with side effects
  def sideEffectFunc(a: String): Unit = println(a)

  def innerSum(n: Int): Int = {
    def smallSum(a: Int, b: Int): Int = a + b

    smallSum(n, n-1)
  }

  // a greeting function
  def greeting(name: String, age: Int) = s"Hi my name is $name and i am $age years old"

  //factorial function
  def factorial(n: Int): Int = {
    if (n <= 1)n else n * factorial(n-1)
  }

  //fibonacci function
  def fibonacci(n : Int): Int = {
    if (n <= 2)1 else fibonacci(n-1) + fibonacci(n - 2)
  }

  //prime number function
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n/2)
  }

  println(factorial(14))
  println(fibonacci(13))
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(2*2))

}

