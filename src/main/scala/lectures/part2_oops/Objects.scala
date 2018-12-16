package lectures.part2_oops

object Objects extends App {
  //scala does not have class level functionality, it doesn't know static
  //to define class level functionality in scala use objects

  object Person { //static -class level functionality
    //objects can have values and vars and method definitions

    /*
    objects can be defined in the same way classes can in scala
    only difference is that objects cannot take class parameters
     */
    val N_Eyes = 2

    def canFly: Boolean = false

    //factory method used to build new person from person
    def apply(father: Person, mother: Person): Person = new Person("Bobbie")
  }

  println(Person.N_Eyes)
  println(Person.canFly)

  /*
  Scala objects are singleton instance, when we defined the object person we basically defined it's type
  and it is it's only instance so if we create two vals pointing to the same object and compare them
  the output will be true
   */

  val mary = Person
  val john = Person

  println(mary == john)

  class Person (val name: String){
    //instance level-functionality
    //pattern of writing class and object with same name in same scope is called COMPANIONS
    //when we define companions

    val mary2 = new Person("Mary")
    val john2 = new Person("John")
    println(mary2 == john2)  //false since both point to different objects

    val person1 = Person
    val person2 = Person
    println(person1 == person2) // true since both point to same object

    //accessing factory method apply
    val bobbie = Person.apply(mary2, john2)
    //or with apply method can be accessed directly
    val bobi = Person(mary2, john2)

    //scala application = Scala object with def main(args: Array[String]): Unit

  }
}
