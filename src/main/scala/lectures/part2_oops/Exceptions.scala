package lectures.part2_oops

object Exceptions extends App {

  //1.throwing exceptions
  val x: String = null
  //println(x.length) //will throw null pointer exception

  //val anException: String = throw new NullPointerException
  //exceptions are instances of classes
  //throwable extends Throwable
  //exception and error are major Throwable
  //both exception and error crashes the jvm
  //exception means something wrong with program
  //error means something is wrong with the system(stackoverflow error)

  //2.catch exceptions
  def getInt(withException: Boolean): Int = if (withException) throw new RuntimeException("No Int")
  else 21

  /*
  here throw new runtime tries to throw a runtime exception
  but it is caught in the try block
   */
  val potentialFail = try {
    //code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught runtime exception")
  } finally {
    //code will be executed no matter what
    //optional, does not influence return types
    println("finally")
  }

  //3.define own exceptions
  class MyException extends Exception {
    val exception = new MyException

    throw exception
  }
}
