package lectures.part2_oops

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //instantiating an abstract class with on the spot implementation
  //normally abstract class cannot be instantiated
  //this is called an Anonymous class
  val funnyAnimal: Animal = new Animal{
    override def eat = println("haha")
  }
  /*
  explanation of above
  class AnonymousClasses$$anon$1 extends Animal {
  override def eat = println(hahah)
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  //anonymous class work for both abstract and non abstract field and methods

  class Person(name: String){
    def sayHi: Unit = println(s"Hi I am $name")
    /*
    provide all the implementation of abstract fields and methods
    we instantiate otherwise compiler would not be able to create anonymous class
     */
  }

  //using anonymous class for person class
  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi I am Jim and I am a rock star")
  }
  println(jim.sayHi)

  println(funnyAnimal.getClass)

}
