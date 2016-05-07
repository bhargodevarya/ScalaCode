package com.bhargo.domain

/**
 * Created by barya on 3/31/16.
 */
class DrinkInventory[+B] {

  private var map:Map[Any, Int] = Map()


  def addDrink[b >:B](drink:b,count:Int) = {
    if(map.contains(drink)) {
      map += (drink -> (map(drink) + 1))
    } else {
      map += (drink -> count)
    }
  }

  def getMap():Map[Any,Int]={
    map
  }
}
