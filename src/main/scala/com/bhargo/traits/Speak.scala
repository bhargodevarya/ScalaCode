package com.bhargo.traits

/**
 * Created by barya on 4/7/16.
 */
trait Speak extends  BaseTrait{

  override def makeSound(sound:String) = {
    for ( i <- 0 to 2) {
      print(sound + " ")
    }
    println()
  }
}
