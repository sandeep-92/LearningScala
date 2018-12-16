package lectures.part2_oops

import java.sql

import PlayGround.{Cindrella, PrinceCharming}
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  //bunch of definitions grouped under same name are called packages
  //package members are accessible by their simple name
  //val writer = new Writer("Sandeep", "The Unnamed", 2018)

  //to use cindrella class we have to import the cindrella from playground package
  val princess = new Cindrella

  //to avoid import statements use fully classified named
  val cindrella = new PlayGround.Cindrella //fully classified class name

  //packages are in hierarchy

  //package object are used to creating unversal constants, can only be one per package
  sayHello
  println(SPPED_OF_LIGHT)

  //imports
  val prince = new PrinceCharming

  //here compiler will assume that we are importing the java date even if we want sql date
  val date = new Date()
  val sqlDate = new SqlDate(2018,5,4)
  //use aliasing like above

  //default imports
  //java.lang - String, Object, Exception
  //scala - Int, Nothing, Function
  //scala.PreDef -println
}
