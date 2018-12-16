package exercises

//covariant generic list

abstract class MyGenericList[+A] {

  def head: A
  def tail: MyGenericList[A]
  def isEmpty: Boolean
  def add[B >:A](element: B): MyGenericList[B]
  def printElement: String
  override def toString: String = "[" + printElement + "]"
  def map[B](transformer: MyTransformer[A,B]): MyGenericList[B]
  def flatMap[B](transformer: MyTransformer[A,MyGenericList[B]]): MyGenericList[B]
  def filter(predicate: MyPredicate[A]): MyGenericList[A]
  def ++[B >: A](list: MyGenericList[B]): MyGenericList[B]

}
 case object Empty extends MyGenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyGenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyGenericList[B] = new Cons(element, Empty )
  def printElement: String = ""

  def map[B](transformer: MyTransformer[Nothing,B]): MyGenericList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing,MyGenericList[B]]): MyGenericList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyGenericList[Nothing] = Empty
  def ++[B >: Nothing](list: MyGenericList[B]): MyGenericList[B] = list

}

 case class Cons[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
  def head: A = h
  def tail: MyGenericList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyGenericList[B] = new Cons(element, this)
  def printElement: String =
    if (t.isEmpty)"" + h
    else h + " " + t.printElement

  /*
  [1,2,3].filter(n % 2 == 0)
    = [2,3].filter(n % 2 == 0)
    = new Cons(2, [3].filter(n % 2 == 0))
    = new Cons(2, Empty.filter(n % 2 == 0))
    = new Cons(2, Empty)
   */
  def filter(predicate: MyPredicate[A]): MyGenericList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /*
  [1,2,3].map(n * 2)
    = new Cons(2, [2,3].map(n * 2))
    = new Cons(2, new Cons(4, [3].map(n * 2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  def map[B](transformer: MyTransformer[A, B]) = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  /*
  [1,2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons (1, new Cons(2, Empty ++ [3,4,5])
    = new Cons (1, new Cons(2, new Cons(3, new Cons(4, new Cons(5))))))
   */
  def ++[B >: A](list: MyGenericList[B]): MyGenericList[B] = new Cons(h, t ++ list)

  /*
  [1,2].flatMap(n => [n, n + 1])
    = [1,2] ++ (2).flatMap(n => [n, n + 1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n + 1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */
  def flatMap[B](transformer: MyTransformer[A,MyGenericList[B]]): MyGenericList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}
object ListTest extends App {
  val listOfInt: MyGenericList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val clonedlistOfInt: MyGenericList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherlistOfInt: MyGenericList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfString: MyGenericList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfInt.toString)
  println(listOfString.toString)
  println(listOfInt.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int) = elem * 2
  }))
  println(listOfInt.filter(new MyPredicate[Int]{
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)
  println((listOfInt ++ anotherlistOfInt)).toString
  println(listOfInt.flatMap(new MyTransformer[Int, MyGenericList[Int]] {
    override def transform(elem: Int): MyGenericList[Int] = new Cons(elem, new Cons(elem+1, Empty))
  }))
  println(listOfInt == clonedlistOfInt)
}



