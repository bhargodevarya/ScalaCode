package com.bhargo.traits

/**
 * Created by barya on 4/7/16.
 */
trait eat extends BaseTrait{
  def feed(food:String) = {
    println(super.makeSound("bark"))
    println("eating " + food)
  }

   override def makeSound(sound:String) = {
    super.makeSound(sound)
    print("from eat trait ")
    for ( i <- 0 to 2) {
      print(sound + " ")
    }
    println()
  }
}
