package lectures.part2_oop

object OopExercises extends App {

  val author = new Writer("Stephen", "King", 1947)
  val imposter = new Writer("Stephen", "King", 1947)
  val novel = new Novel("The Shining", 1977, author)

  val  counter = new Counter()
  counter.inc.print
  //counter.inc.inc.inc
  //counter.inc(10).print

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))
}

/*
Novel and Writer
Writer: firstname, surname, year
-method fullName

Novel: name, year of release, author
-method author age
-method isWrittenBy
-method copy(year of release
*/
class Writer(fName: String, sName: String, val yob: Int) {
  def fullName: String = fName + sName
}

class Novel(name: String, yor: Int, author: Writer) {
  def authorAge: Int = yor - author.yob
  def isWrittenBy(author: Writer) = author == this.author //this calls the class parameter
  def copy(newYor: Int): Novel = new Novel(name, newYor, author)
}

/*
counter class
-receives an int value
-method current count
-method to increment/decrement => new counter
-overload inc/dec to receive an ammount
*/

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1) //immutability, instances are fixed, always return new instances
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  //overloading implies compile time polymorphism
  //def inc(n: Int) = new Counter(count + n)
  //def dec(n: Int) = new Counter(count - n)

  def inc(n: Int): Counter = {
    if(n <= 0) this.inc
    else inc.inc(n + 1)
  }

  def dec(n: Int): Counter = {
    if(n <= 0) this.dec
    else dec.dec(n-1)
  }

  def print = println(count)

}
