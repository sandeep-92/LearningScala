package lectures.part1_basics

object Recursion extends App {
  /*
   //factorial function
   def factorial (n: Int): Int =
     if (n <= 1) 1
     else {
       println("Computing factorial of " + n + " need factorial of" + (n - 1))
       val result = n * factorial(n-1)
       println("computed factorial of " + n)
       result
     }

   println(factorial(10))

   /*
   each call of recursive function uses a java stackframe. Jvm keeps all the call
   in it's stackframe which has a limited memory. so if we tried to print a factorial of
   a larger number we will get stack overflow error to avoid the situation we use tail recursive function
   instead of a regular functio  n
    */

   //tail recursive function calls itself as it's very last action
   def tailRecursiveFactorial(n: Int): BigInt = {
     @tailrec
     def factorialHelper(a: Int, accum: Int): Int =
       if (a <= 1) accum
       else factorialHelper(a - 1, a * accum) //tail-recursion use recursive call as last expression

     factorialHelper(n, 1)

     /*
     tailRecursiveFactorial(10) = factorialHelper(10, 1)
     =factHelper(9, 10 * 1) => accum is 10*1
     =factHelper(8, 9 * 10 * 1)
     =factHelper(7, 8 * 9 * 10 * 1
     =...
     =factHelper(2, 3 * 4 * ....10 * 1)
     =factHelper(1, here accum will be returned as 2 * 3 * 4 * 5 * ...10 * 1

      */
     tailRecursiveFactorial(50)
   }

   //concatenate a string n times
     @tailrec
     def nStringHelper(a: String, n: Int, acc: String): String =
       if(n <= 1) acc
       else nStringHelper(a, n-1, n + acc)

   println("hello", 3, "")

   //isPrimenumber tail recursive
   def isPrime(n: Int): Boolean = {
     @tailrec
     def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean =
       if(!isStillPrime) false
     else if (t <= 1) true
       else isPrimeHelper(t-1, n % t != 0 && isStillPrime)

     isPrimeHelper(n/2, true)

   }

   //tail recursive fibonacci number
   /*
   here fibohelper will take 3 parameters one the number and two accumulators
   since fibo of n is fibo n-1 + n-2
   fibo of n calls fibo of n-1 and fibo of n-2 in the same code path, so general rule is
   how ever many recursive calls you have to the same code path that's how many accumulators
   you need to have in tail recursive function
    */

   def fiboncci(n: Int): Int = {
     @tailrec
     def fiboHelper(i: Int, acc1: Int, acc2: Int): Int =
       if (i >=n) acc1
       else fiboHelper(i+1, acc1 + acc2, acc1)

     if (n <= 2)1
     else
       fiboHelper(3,1,1)
   }
  */
  val id = List(1,23,4,5)
  val b = id.foreach(x => x.toInt)
  val a = s"Hi iam a king/$id"
  println(b)


}




