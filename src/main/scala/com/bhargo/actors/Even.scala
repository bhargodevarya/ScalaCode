package com.bhargo.actors

import akka.actor.Actor
import com.bhargo.main.resource

/**
 * Created by barya on 4/26/16.
 */
class Even extends  Actor{
  def receive = {
    case resource(n) => println(n)
      Thread.sleep(1000)
      sender ! resource(n+1)
  }
}
