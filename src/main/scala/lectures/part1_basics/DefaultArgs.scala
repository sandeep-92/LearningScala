package lectures.part1_basics

import scala.annotation.tailrec

//default and named arguments
object DefaultArgs extends App {

  @tailrec
  def trfact(x: Int, acc: Int): Int =
    if(x <= 1)acc
    else trfact(x-1, x * acc)

  //the factorial of 10 you have to call the method with value of x as 10 and acc as 1 eg.
  println(trfact(10, 1))

  //some times we create functions which will be called with same parameters most of the time

  def factDefault(x: Int, acc: Int = 1): Int =
    if (x <= 1)acc
    else
      factDefault(x-1, x * acc)
  //scala allows us to pass default values to parameters, and they can be overwritten during
  //function call
  println(factDefault(10, 2)) //overwriding default parameter value

  /*
  challenges with default value of arguments
   */

  //lets write a picture saving function
  def saveImage(format: String = "jpeg", width: Int, height: Int): Unit = println("saving picture")

  //saveImage(  800, 600) //if format is not specified here compiler will be complain

  //to solve above either pass in every leading argument or
  //name the arguments

  saveImage(width = 800, height = 600)

  //named arguments can be passed in different order
  saveImage(height =900, width = 1600)
}
