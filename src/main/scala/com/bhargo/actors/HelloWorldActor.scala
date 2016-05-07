package com.bhargo.actors

import akka.actor.Actor
//import com.bhargo.main.message

/**
 * Created by barya on 4/13/16.
 */

case class Name(name:String)

class HelloWorldActor extends Actor{
  def receive = {
      case Name(n) => println("Received "+ n)

   // sender ! message("from the receiver")
  }
}

