package com.bhargo.domain

/**
 * Created by barya on 3/31/16.
 */


/**
 * Because the class is covariant, none of the methods can have B as a return type.
 * Methods should be lower bounded for it to work.
 *
 */
class VendingMachine[+B] {

  //var list:List[B] = List()

  val stock:DrinkInventory[B]=new DrinkInventory[B]()

  // <: doesnot compile
  def add[b >: B](drink:b) ={
    List(drink)
    //list ::= drink
  }

  def addDrink[b >: B](drink:b,count:Int):Unit={
    stock.addDrink(drink,count)
  }

  def getInverntoryCount():Int= {
    var count =0
    stock.getMap().values.foreach(n => count += n)
    count
  }
}
