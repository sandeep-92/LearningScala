package lectures.part4_patternMatching

object AllPatterns extends App {

  //constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllPatterns => "A Singleton Object"
  }

  //match anything
  val matchAnything = x match {
    case _ => "Whatever"
  }

  //matching variable
  val matchVariable = x match {
    case something => s"I found $something"
  }

  //tuples
  val aTuple = (1, 2)
  val matchTuple = aTuple match {
    case (1, 1) => "1 to 1"
    case (something, 2) => s"I found $something"
  }

  val nestedtuple = (1, (2, 3))
  val matchNested = nestedtuple match {
    case (_, (2, v)) => s"extracted $v"
  }

  //list patterns
  val aList = List(1, 2, 3, 42)
  val listMatch = aList match {
    case List(1,_,_,_) => "extractor"
    case List(1, _*) => "match list of arbitrary length"
    case 1 :: List(_) => "infix pattern"
    case List(1,2,3) :+ 42 => "infix pattern"
  }

  //type specifier
  val unknown: Any = 2
  val unMatch = unknown match {
    case list: List[Int] => "explicit type specifier"
  }

  //name binding
  val nameBindmatch = aList match {
    case nonEmpty @ List(_,_,_,_) => s"use the name later or here $nonEmpty"
    case List(1, secondValue @ 2, _, _) => s"name binding can be used in nested as well $secondValue"
  }

  //if guards
  val multiPattern = aList match {
    case List(1, value,_,_) if value % 2 == 0 => "even list"
  }

  val numbers = List(1,2,3)
  val numMatch = numbers match {
    case stringList: List[String] => "a list of strings"
    case intList: List[Int] => "a list of integers"
  }

  println(numMatch)

  /*
 above the answer will be list of strings instead of list of int
  it's called erasure issue and is there because of jvm's support for generics
   */


}
