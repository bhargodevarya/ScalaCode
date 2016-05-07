package com.bhargo.domain

/**
 * Created by barya on 4/6/16.
 */
class Employee private(name:String, age:Int, email:String) {

}

object Employee {

  var location:String = "Bangalore"
  var team:Team = new Team("Diamond")

   def apply(name:String, age:Int, email:String) =  {
     new Employee(name,age,email)
   }
}
