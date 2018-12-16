package exercises

abstract class MyList {
  /*
  implementation of linked list, methods:
  1.head: head of list
  2.tail: remainder of list
  3.isEmpty: is this list empty
  4.add: receives int and returns new list with element added
  5.toString: a string representation of the list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElement: String
  override def toString: String = "[" + printElement + "]"

}

object Empty2 extends MyList { //objects can extend classes

  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons2(element, Empty2)
  def printElement: String = ""
}

class Cons2(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons2(element, this)
  def printElement: String = {
    if (t.isEmpty)"" + h
    else h + " " + t.printElement
  }
}

object ListTest2 extends App {
  val list = new Cons2(1, Empty2)
  val linkedList = new Cons2(1, new Cons2(2, Empty2))
  println(list.head)
  println(linkedList.head)
  println(linkedList.tail.head)
  println(linkedList.add(5).head)
  println(linkedList.isEmpty)
  println(linkedList.toString)

}


