package lectures.part2_oops


object OOBasics extends App {

  //instantiating the person class
  //instantiating means reserving actual memory for the objects created
  val person = new Person
  println(person)

  //creating person2 using constructor
  val person2 = new Person2("Sandeep", 28)

  //creating class with fields and accessing it
  val person3 = new Person3("Amrita", 24)

  println(person3.age)

  val person4 = new Person4("John", 43)
  println(person4.x)
  println(person4.greet("Jane"))

  /*
  in other languages to get the age of the person2 object you will write (person.age)
  but it wont work in scala because age is a class parameter and not a class member that we can access
  with . operator

  to convert class parameter to class fields add val before the identifier
   */
}
//class definitions can sit on the top level of code
//a class organizes the data and behavior
//defining a class
class Person
//passing parameters to the class
class Person2(name: String, age: Int) //it's called a constructor
/*
constructor says that every single instance of class person
needs to have these fields defined
 */
class Person3(val name: String, val age: Int)

class Person4(val name: String, val age: Int = 0) { //default parameter
  //body of the class and defines implementation of the class
  //includes functions, expressions, vars, vals
  val x = 2
  println(1 + 2)

  //defining functions inside class
  //functions defined inside class are called methods
  def greet(name: String) = s"$name says Hi ${this.name}"
  //to access the name of the instantiated object use this

  //oveloading
  def greet : Unit = println(s" Hi I am $name") //it is actually this.name since its parameterless function
  //overloading means method with same name but different signatures
  //different signature means different number of parameters or parameters of different types with different return type

  //multiple constructors: auxiliary constructors
  def this(name: String) = this(name, 0 )
  //auxuliary are mainly used for default parameters

  //value of code block is ignored since it's only the implementation of the class
  //for every instantiation of the class whole body will be first executed
}