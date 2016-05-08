package com.bhargo.domain

import java.io._


/**
  * Created by hadoop on 8/5/16.
  */
class Person(firstName:String, lastName:String, age:Int, email:String) {

  println("any code outside a method goes inside  the default constructor " + Person.state)
  Person.setState("Punjab")

  def this(name:String) {
    this(name,"",18,"")
  }

  //IMPORTANT, this is a must if you want to create an anonymous inner class
  def this() {
    this("default")
  }

  def firstName_ = firstName

  def writeDetails(): Unit = {
    val file = new File("/home/hadoop/Documents/books/scala/file.txt")
    try {
      //if (!file.exists()) file.createNewFile()
      val writer = new FileWriter(file)
     // println(firstName + "" + lastName + "" + email + "" + age)
      writer write "name is " + firstName + " " + lastName + ", email is " + email + " age is " + age
      //writer.write("this is a test")
      writer.flush()
      writer.close()
    } catch {
      case e:FileNotFoundException => println("File was not found ")
      case e:Exception => println("some other exception has occured ")
    } finally {

    }

    var line:String= null
    val bufferedReader = new BufferedReader(new FileReader(file))
    do {
      line = bufferedReader.readLine()
      println(line)
    } while (line != null)

  }
}

class Student(firstName:String, lastName:String, age:Int, email:String) extends
  Person(firstName:String, lastName:String, age:Int, email:String) {

}
//this acts like static
object Person {
  private var state = "Karnataka"

  private def setState(state:String) {
    if(!this.state.equals(state)) {
      this.state = state
      println(state)
    }
    this.state = state
  }
}
