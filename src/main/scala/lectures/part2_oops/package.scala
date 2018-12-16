package lectures

package object part2_oops {

  //package object are used to creating universal constants, can only be one per package
  //methods and constants can be defined here and used merely by their simple name throughout the code

  def sayHello: Unit = println("Hi")
  val SPPED_OF_LIGHT = 29978965
}
