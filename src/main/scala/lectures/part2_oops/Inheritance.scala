package lectures.part2_oops

object Inheritance extends App {

  //Scala has single class inheritance(only extend one class at a time)
  class Animal{ //super-class of cat

    def eat = println("nomnom")

    val creatureType = "Wild"

    //private methods are inaccessible from outside, method sleep is inaccessible to other subclasses
    private def sleep = println("Sleeping")

    //protected marks the field or method only accessible to current and subclasses
    protected def status = println("Roaming")

    //no modifier makes it public
  }

  class Cat extends Animal { //cat is subclass of animal

    //protected method is accessible here- inside subclass but not out of it
    def currentStatus = {
      status
      println("Not found")
    }

  }

  val cat = new Cat
  //extending a class means extending all it's non private fields and methods od superclass
  cat.eat
  cat.currentStatus

  //constructors
  class Person(name: String, age: Int){

    //this allows us to create a class without the age parameter
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding-works for method as well as vars and vals
  //all instances of derived classes will use the overriden things whenever possible
  class Dog extends Animal {

    //write different implementation of protected status method
    override def status = println("Sneezing")

    override def eat = {
      //to use the eat implementation of Animal class instead of overriden one use super.eat
      super.eat
      println("crunch crunch")
    }

    //overriding val
    override val creatureType: String = "Domestic"

  }
  val dog = new Dog
  dog.status
  dog.eat
  println(dog.creatureType)

  //fields can be overriden in the constructors directly
  class Monkey(override val creatureType: String) extends Animal {
    override def eat: Unit = println("banana")

  }

  val monkey = new Monkey("Ape")
  println(monkey.creatureType)

  //type substitution -Polymorphism
  /*
  we can create an unknown val of type animal and assign a dog class to it
   */

  val unknown: Animal = new Monkey("k9") //polymorphism
  unknown.eat

  //overriding: supplying different implementation in derived classes
  //overloading: multiple methods with different signature but with same name in same class

  /*
  preventing overrides:
  1) use final keyword before method or fields
  2) classes can also be defined as final which will prevent them from being extended
  3) seal the class: can extend classes in this file, prevents extension in other files
   */
}
