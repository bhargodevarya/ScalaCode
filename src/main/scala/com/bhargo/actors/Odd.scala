package com.bhargo.actors

import akka.actor.{Props, Actor}
import com.bhargo.actors.Even
import com.bhargo.main.resource

/**
 * Created by barya on 4/26/16.
 */
class Odd extends Actor {
  def receive = {
    case resource(n) => {
      println(n)
     val e = context.actorOf(Props[Even])
      e ! resource(n +1)
      //sender ! resource(n+1)
    }

  }
}
