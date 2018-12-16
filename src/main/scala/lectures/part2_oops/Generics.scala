package lectures.part2_oops

object Generics extends App {

  class MyList2[A] { //generic class
    //to define a generic class use type [A]
  }
  //covarinat my list
  class MyList[+A] {
    /*
    if to a list of A we add another supertype B of A then list will
    return list of B e.g.
    A = Cat
    B = Dog == Animal
    if we add animal to a list of cat it will turn list into list of animal
     */
    def add[B >: A](element: B): MyList[B] = ???
  }

  //generics also work for traits
  trait MyTrait[A]

  //generics allow us to make mylist in any type we want e.g. list[String], list[Int]
  class MyMap[Key, Value] //creates a generic class of map
  val intList = new MyList[Int]
  val stringList = new MyList[String]

  //generic methods
  object MyList { //objects cannot be type parametrized
    def empty[A]: MyList[A] = ???
  }
  //using a generic method
  val emptyIntList = MyList.empty[Int]

  //variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal


  //if class cat extends Animal does list of cat also extends list of Animal:

  //1.yes, list of cat extends list of animal and is called COVARIANCE
  class CovariantList[+A] //covariant is defined by +A
  val animal: Animal = new Cat //polymorphic substitution
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) ??? => return list of animal
  //adding a list of dog to a list of animal will turn list into even more generic

  //2.No: INVARIANCE
  class InvariantList[A] //define invariant list without any sign
  //val invariantList: InvariantList[Animal] = new InvariantList[Cat] is not possible here
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  //3.Hell, no: CONTRAVARIANCEC
  class Contravariant[-A]
  val contravariant: Contravariant[Cat] = new Contravariant[Animal] //nonintutive doesnot make sense

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal] //trainer of cat can be trainer of animals makes sense

  //bounded types: UPPER
  //class cage only excepts subclasses of class animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  /*
  class Car
  val car = new Cage(new Car)
  is wrong since class car doesnot extends class animal and is not a subclass of animal
   */

  //bounded tyoes: LOWER
  //CAGE ONLY EXCEPTS SOMETHINS THAT IS UPERTYPR OF ANIMAL
  class CageLower[A >: Animal]

  //bounded types solve covariance problem in generics
}
