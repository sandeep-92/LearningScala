package lectures.part2_oops

object AbstractDataTypes extends App {

  //there are scenarios where we need to leave fields and methods unimplemented: called abstracts
  //classes that contain unimplemented fields and methods are called abstract classes defined by kw abstract
  //abstract classes cannot be instantiated
  //abstract classes and traits can have abstract as well as non abstract members

  //example of abstract class
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal { //need to provide implementation for abstract fields and method
    override val creatureType: String = "k9"
    //override keyword in not mandatory for abstract fields and methods
    def eat: Unit = println("crunc crunch")

  }

  //traits by default have abstract fields and methods
  //we can mixin as many trait as we want
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal = "fresh meat"
  }

  trait ColdBlodded

  class Crocodile extends Animal with Carnivore with ColdBlodded {
    override val creatureType: String = "croc"
    def eat = println("nomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and i am eating ${animal.creatureType}")
  }
  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  /*
  difference between traits and abstract classes:
  1)traits cannot have constructor parameters
  2)you can only extend one class but mixin multiple traits
  3)traits are behavior, abstract class is a type of thing
   */
}
