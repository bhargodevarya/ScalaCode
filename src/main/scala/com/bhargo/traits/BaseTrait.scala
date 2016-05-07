package com.bhargo.traits

/**
 * Created by barya on 4/7/16.
 */
abstract trait BaseTrait {

  def makeSound(sound:String) = {
    print("from base trait")
    for ( i <- 0 to 2) {
      print(sound + " ")
    }
    //println("\n")
  }
}
