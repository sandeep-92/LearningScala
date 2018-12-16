package lectures.part2_oops

object CaseClass extends App{

  //case classes can be used as substitute for companion objects
  case class Person(name: String, age: Int)

  //1.class parameters are fields
  val person = new Person("Jim", 34)
  println(person.name)

  //2.sensible toString
  //println(instance) = println(instance.toString) //syntactic sugar
  println(person.toString)
  println(person)

  //3.equals and hascode implemented out of the box
  val jim = new Person("Jim", 34)
  println(person == jim)

  //4.cc are have copy method
  val jim2 = jim.copy(age = 45 )
  println(jim2)

  //5.case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  //6.cc are serializable => useful in akka

  //7.cc have extractor pattern = cc can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
  //case object has same properties as case classes except they cant be instantiated
}
