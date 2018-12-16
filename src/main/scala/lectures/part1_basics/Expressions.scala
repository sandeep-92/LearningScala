package lectures.part1_basics

object Expressions extends App{

  val x = 1 + 2 //Expression
  print(x)

  //maths expressions are all supported e,g, +,-,/,%,|
  println(12 + 33 * 45)

  //test for equality
  println(x == 5)

  //negation operation
  println(!(1 == x))

  var aVariable = 7
  aVariable += 3 //also works with -=, *=, /=
  println(aVariable)

  //instructions (tell the computer to do) vs expressions (has a value or type)
  val aCondition = true
  val aStatement = if (aCondition) 5 else 8
  println(aStatement)

  //if in scala is an expression
  println(if (aCondition) "hello" else "Bye")

  //loops in scala are discouraged and are only useful for executing side effects
  //while loop in scala
  var i = 0
  val aUnit = while(i > 10) {
    println(i)
    i += 1
  }

  //never use while loop in scala

  //almost everything in scala is an expression

  //UNIT type in scala
  val aValue = (aVariable = 3)
  println(aValue) //output will be ()

  //side effects in scala are expressions returning Unit
  //while loop returns unit
  //side effects: println(), whiles, reassignment

  //code blocks, they are also an expressions
  //value of a block is the value of it's last expression
  val aCodeBlock = {
    val y = 8
    val z = y + 1
    if (z > 2)"nice" else "nope"
  }



}

