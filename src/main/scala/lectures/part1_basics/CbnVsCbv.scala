package lectures.part1_basics

object CbnVsCbV extends App {

  def calledByValue(x: Long): Unit = {
    println("called by value " + x)
    println("called by value " + x)
  }

  //to call a parameter by name use =>
  def calledByName(x: => Long): Unit = {
    println("called by name " + x)
    println("called by name " + x)
  }

  //System.nanoTime to get the time of system in nanoseconds
  println(calledByValue(System.nanoTime()))
  println(calledByName(System.nanoTime()))

  /*
  time function in scala and jvm returns a long that's why we chose our method parameters
  to be long.
  In call by value the function is evaluated and it's value is passed so it stays
  the same throughout(value is computed before the function is called)
  In call by name the function is evaluated every time it is called hence producing
  new value in each call
   */

  //an infinite recursive function
  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x);

  //println(printFirst(infinite(), 34)) will cause stack overflow error

  println(printFirst(34, infinite()))
  /*
  this will not crash since the by name parameter delays the evaluation of y
  until it is used in the function since it is called by name
  */
}
