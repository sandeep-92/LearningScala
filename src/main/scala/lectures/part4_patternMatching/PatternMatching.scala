package lectures.part4_patternMatching

import scala.util.Random

object PatternMatching extends App{

  val ranNum = new Random()
  val x = ranNum.nextInt(10) //any number from 0 to 10

  //a pattern matching tries to match a value against multiple patterns
  //each pattern is written in a case statement = case pattern => result

  val description = x match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "third time is charm"
    case _ => "something else" //_ is called a wildcard and it will match anything
  }
  println(x)
  println(description)

  //use cases of pattern matching
  //1. can deconstructs values when used in with case classes
  case class Person(name: String, age: Int)
  val mal = Person("mal", 17)
  //if mal is a person this pattern match expression will deconstruct its components to name and age
  val greeting = mal match {
    case Person(n, a) => s"hi my name is $n and i am $a years old"
    case _ => "not sure about the identity"
  }
  println(greeting)
  //we can pattern match against a case class pattern and extract its values and use it in return type

  //2. we can run guards against pattern match
  val mary = Person("mary", 14)
  val newGreeting = mary match {
    case Person(n, a) if (a > 18) => s"my name is $n and i'm not a teenager"
    case _ => "not sure"
  }
  println(newGreeting)
  //2.a cases are matched in order
  //2.b if no match is there and wildcard is not specified we will get match scala.Match.Error
  //2.c type of pattern match expression: unification of all the expressions returned by cases

  //3. pattern matching on sealed heirarchies

/*  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"matched a dog of $someBreed breed")
  }
  this above will throw error because not all cases of sealed class animal is covered
  */

  /*
  exercises
  1. write function that uses pattern matching takes an Expr and returns readable form of it
    e.g. Sum(Number(2), Number(3)) => 2 + 3
         Sum(Number(2), Number(3), Number(4)) = 2 + 3 + 4
         Prod(Sum(Number(1), Number(2), Number(3)), Number(3)) => (1 + 2) * 3
   */
  trait Expr
  case class Number(n: Int)extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Product(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) =>  show(e1) + "+" + show(e2)
    case Product(e1, e2) => {
      def maybeShowParanthesis(exp: Expr) = exp match{
        case Product(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "{" + show(exp) + "}"

      }

      maybeShowParanthesis(e1) + "*" + maybeShowParanthesis(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))

}
