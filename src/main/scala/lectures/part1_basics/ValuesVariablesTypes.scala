object ValuesVariablesTypes extends App {

  //creating a value, val can't be reassigned they are immutable
  val x: Int = 21

  //prints to the console
  print(x)

  //types of val are optional, compiler can infer the types of vals and vars
  val y = 39

  //semi-colons are not necessary in scala unless you are writing multiple statements in a line
  val aString = "hello world!"; val newString = "Woah buddy"

  //types in scala
  val aBoolean: Boolean = true //can be true or false
  val aChar: Char = 'z' //single character
  val anInt: Int = 12
  val aShort: Short = 12345
  val aLong: Long = 1234567854L
  val aFloat: Float = 21.5f //f is necessary for defining float
  val aDouble: Double =2.34

  //variables in scala
  var aVariable: Int = 4
  //variables can be reassigned
  aVariable = 6

  /*
  variables are for side effects
  reassignment, printing something to the console etc are called side effects
   */



}
