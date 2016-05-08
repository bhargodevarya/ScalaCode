package com.bhargo.main

import com.bhargo.enums.Fruit
import com.bhargo.domain._
import com.bhargo.traits.{eat, BaseTrait, Speak}
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import com.bhargo.actors._
import com.bhargo.actors.Name

/**
 * Created by barya on 4/4/16.
 */

case class resource(msg:Int)

object ScalaApp {

  def main(args: Array[String]) {
    println(add(2, 3))
    println(partialAdd2(5))
    println(callCurriedAdd(9))
    println(curriedAdd(5)(5))
    println(uncurriedAdd(7, 7))
    //varArgs("This","is","a","variable","args","example")

    //Random.nextInt(5) returns a random num till 4,Seq.fill(25) creates a list of 25
    //val numList = Seq.fill(25)(Random.nextInt(5))
    //println(numList)

    listToMap(createList())
    createAndTraverseArray()
    createAndTraverseSet()

    val vendingMachine:VendingMachine[SoftDrink] = new VendingMachine[SoftDrink]()
    val soda:Soda = new Soda()
    //var drinkList:List[SoftDrink] = List()
    //drinkList = (vendingMachine.add(new SoftDrink()) ++ vendingMachine.add(soda))
    //println("size of the list is " + drinkList.size)

    vendingMachine.addDrink(soda,5)
    vendingMachine.addDrink(new SoftDrink(), 7)
    println("The current count is " + vendingMachine.getInverntoryCount())

    val list:List[Soda] = List(new Soda())

    //fix this
    patternMatch(list)
    //fix this
    /*funcReturningOption("Demo")*/

    //createList().sortBy(x => x.toString).foreach(println)

    val emrld:Team = new Team("Emerald")
    val dmnd:Team = new Team("Diamond")
    val perl:Team = new Team("Pearl")

    val emp1 = Employee("Bhargo",27,"bhargo@orbitz.com")
    val emp2 = Employee("Khandekar",27,"khandekar@orbitz.com")
    val emp3 = Employee("Money",27,"money@orbitz.com")
    val emp4 = Employee("Sukalyan",27,"sukalyan@orbitz.com")

    println(Employee.team)

    val pet = new Pet// with Speak
   // pet.feed("food")
    pet.makeSound("sound")

  println(++(6))

    //actorsDemo

    /*val evenOdd = new ProdConsumer
    evenOdd.start*/

    val func = funcForStructuralTyping
    println(func.apply(() => 7))
    func(() => {println("Hii...");1 > 2})

    var counter =5

    whileLoop2(counter>0)({println("testing");counter -=1})

    //func2().apply(println("calling"))

    func3().apply(() => {
      println("calling func3");
      3
    })

    println(func4()(777))

    //println(returnFuncExp()(println(34)))

    /*println("Hello world")
    val fraction: Fraction = new Fraction(2, 3)
    val fraction2: Fraction = new Fraction(2, 3)
    println(fraction * fraction2 / fraction2)

    //implicit conversion, these have to be present in the context for use
    implicit def imp(n: Int): Fraction = new Fraction(n, 1)
    println(2 * fraction)
    import java.util.{HashMap => hashmapfrmojava}

    implicit val x1 = 7
    //since an implicit value is present, the following func doesnot need a param to be passed
    implicitParamDemo
//    passAFunc(2, x => println(x))

    //func is a function
    val func = returnAFunc(10)
    //call apply to invoke the returned function
    println(func(20)) // same as func.apply(20)

    val test = new Test[Int]()
    println(test.func2[Int](7,y => {
      println(y)
      y
    }
    ))*/

    println("done>>>>")

    val person = new Person("amar","dev",27,"amar_9909@yaho.com")
    val person2 = new Person("me!!!")


    passAlcohol(new Alcohol {
    println("this is anonymous inner class")
    })

    passPerson(new Person() {
    })

    person writeDetails
  }

  def printOddEven() {
    val system = ActorSystem("evenOdd")
    val act = system.actorOf(Props[Odd], name = "odd")
    Thread.sleep(1000)
    act ! resource(1)
  }

  def passAlcohol(alcohol: Alcohol): Unit = {
    println(alcohol)
  }

  def passPerson(person: Person) {

  }

  def  actorsDemo() {
        val system = ActorSystem("Demo")
        val a = system.actorOf(Props[HelloWorldActor], name ="helloWorld")
        a ! Name("Bhargo")
        Thread.sleep(5000)
        system.shutdown()
  }

  //function for Option Demo
  /*def funcReturningOption(x:String):Option[Int]= {
    if(x != null) {
        x.length

    } else {

    }
  }*/

  //val pattern1:List[VendingMachine[Water]] = List()


  //find a valid example of patten matching
  def patternMatch(list:List[SoftDrink]):Unit = list match {
    case List() => println("a list of VendingMachine")
      val soda = new Soda()
    case List(soda) => println("Soda")
    case _ => println("default")
  }



  def createAndTraverseSet() {
    var set: Set[Int] = Set()
    //adding to the set
    set += 3
    println(set.size)

    //deletion while traversal
    set.foreach(
       n => if (n == 3)
         //removing from the set
         set -= n
       )

    println(set.size)
  }

  def createAndTraverseArray() {
    val intArr: Array[Int] = new Array[Int](5)
    //adding to the array
    intArr(0) = 55
    intArr(1) = 86
    intArr(2) = 77
    intArr(3) = 7
    intArr(4) = 37
    var temp: Int = 0

    //bubble sort
    for (i <- 0 until intArr.length) {
      for (j <- (i + 1) until intArr.length) {
        if (intArr(i) > intArr(j)) {
          temp = intArr(i)
          intArr(i) = intArr(j)
          intArr(j) = temp
        }
      }
    }
    for (i <- 0 until intArr.length) {
      print(intArr(i) + " ")
    }
    println()

  }

  def createList(): List[Fruit.fruit] = {
    //an empty list
    //var fruitList = List[Fruit.fruit]()
    var fruitList: List[Fruit.fruit] = List()

    //adding to a list
    for (i <- 0 until 10000) {
      if (i % 4 == 0) {
        //adding to a list
        fruitList ::= Fruit.MANGO
      } else if (i % 3 == 0) {
        fruitList ::= Fruit.BANANA
      } else if (i % 2 == 0) {
        fruitList ::= Fruit.APPLE
      } else {
        fruitList ::= Fruit.KIWI
      }
    }
    println(fruitList.length)
    fruitList
  }

  def listToMap(list: List[Fruit.fruit]) = {
    //Map((Fruit.APPLE,1),(Fruit.BANANA,1)) for population at creation
    var finalMap: Map[Fruit.fruit, Int] = Map()
    var index = -1
    list.foreach(
      i => {
        index += 1
        if (i.eq(Fruit.APPLE)) {
          //removing from a list
          list.drop(index)
        }
        else if (finalMap.contains(key = i)) {
          //adding to a map
          finalMap += (i -> (finalMap(i) + 1))
        } else {
          finalMap += (i -> 1)
        }
      }
    )
    finalMap.keySet.foreach(n => println("Count for fruit " + n + " is " + finalMap(n)))

    //deletion from the map while traversing, like using itr.remove in java
    finalMap.keySet.foreach(n => if (n.eq(Fruit.APPLE)) {
      //removing from the map
      finalMap -= n
    })

    println("Size after deletion is " + finalMap.size)
  }

  def add(a: Int, b: Int): Int = a + b

  //This is a partial function
  def partialAdd2 = add(2, _: Int)

  //currying an uncurried function, also as def curriedAdd = (add _).curried
  def curriedAdd: (Int) => (Int) => Int = (add _).curried

  //a curried function
  def curriedAdd2(a: Int)(b: Int) = a + b

  //uncurring a curried function
  val uncurriedAdd = Function.uncurried(curriedAdd2 _)

  def callCurriedAdd: (Int) => Int = curriedAdd(2)

  //variable arguments
  def varArgs(args: String*): Unit = args.foreach(println)
  def ++ = (x:Int) => x+1

  //as the param is implicit, this method can be called without any param, if an implicit variable is present
  def implicitParamDemo(implicit x:Int) = {
    println(x)
  }

  //pass a function to an existing function
  def passAFunc(x:Int, f: Int => Unit): Unit = {
    f(x)
  }

  //returning a function from another function
  def returnAFunc(x:Int) = (s:Int) => { x+s+2  }

  def funcForStructuralTyping() = new {
    def apply[R](y: () => R): R = y()
  }

  def func(cond: => Boolean):Boolean = {
    print(cond)
    true
  }

  //explore further start
  def returnFuncExp(): (=>Unit) => Int = {
    body =>
      body
      77
  }

  def func3():(=> Unit) => Unit = {
    body =>
      //body
      println("func3")
  }

  def func2():(=> Unit) => Unit=
    bodyx =>
      println("hellooo")

  def whileLoop2 (cond: => Boolean): (=> Unit) => Unit = {
    body =>
      if (cond) {
        body
        whileLoop2(cond)(body)
      }
  }
  //explore further end

  /* different invocations give different results
  func4() - func4
  func4()(7) - func4 func4 again
  println(func4()(7)) func4 func4 again 77
   */
  def func4():(=> Int) => Int = {
    println("func4")
    anyNameWouldBeFine =>
      println("func4 again")
      77
  }

}

//class linearization Pet -> eat -> Speak -> baseTrait ->AnyRef ->Any
class Pet extends Speak with eat{

}

