package lectures.part2_oop

object MethodNotations extends App {

  val mary = new Person("Mary", "Inception")
  val tom = new Person("TOm", "Fight Club")
  //prefix notation: they are all about unary operators(+, -, * etc)
  //unary operators are also methods


  println(mary.likes("Inception"))

  //infix notation

  //methods with single parameters can be used as infix notations also called syntactic sugar

  //all operators are methods e.g. +,-,*,/


  println(mary likes "Inception") //above and this both statements are valid
  println(mary hangOutWith (tom))
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  val x = -1
  val y = 1.unary_- //both are equivalent

  class Person(val name: String, val favMovie: String) {

    //infix notation
    def likes(movie: String) = movie == favMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    //methods can have identifier like +, &, #, $ - etc

    //infix notation
    def +(person: Person): String = {
      if (this.favMovie == person.favMovie) "They have similar taste"
      else "taste don't match"
    }

    //prefix notation
    def unary_! : String = s"$name, what the heck!!"

    //postfix notation
    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and i like $favMovie"
  }

  //unary_ prefix only work with -, +, ~ and ! operator
  println(!mary)
  println(mary.unary_!) // both are same


  //postfix notation
  //functions that do not receive any parameters can be used as post fix notation
  println(mary isAlive)

  //apply
  println(mary.apply())
  //mary can be called as if it was a function that is because an apply method was defined in
  //the class
  println(mary())

  /*
  1.overload the + operator
  mary + "the rockstar" =>  new Person "Mary(the rockstar")

  2.add age to person class
  add unary + operator  => new person with age + 1
  3.add learns method mary learns "input"
  4.learn scala method () => calls learns method as scala as a parameter

   */
}

