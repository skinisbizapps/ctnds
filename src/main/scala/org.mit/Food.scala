package org.mit

/**
  * Created by skinibizapps on 7/20/17.
  */

case class Food( name:String,  value: Double,  calories: Int) {

  def getValue(): Double = value
  def getCost(): Int = calories
  def getDensity(): Double = getValue() / getCost()

}

object FoodBuilder {

  val isEmpty = ListUtil.isEmpty _

  def isSameSize(x: List[Double], y: List[Int], z: List[String]) = if(!isEmpty(x) && !isEmpty(y) && !isEmpty(z)) {
    if(x.size - y.size + z.size != x.size) throw new ArrayIndexOutOfBoundsException(s"The sizes of lists x: $x.size, y: $y.size, and z: $z.size do not match")
  }

  def buildMenuFunctional(values: List[Double], calories: List[Int], names: List[String]): List[Food] = {
    val menu: List[Food] = if(isEmpty(values) || isEmpty(calories) || isEmpty(names) ) {
      List.empty[Food]
    } else {
      isSameSize(values, calories, names)
      val totalItems = values.size - 1
      val myMenu: List[Food] = (for( item <- 0 to totalItems) yield {new Food(names(item), values(item), calories(item))}).toList
      myMenu
    }
    menu
  }


  def buildMenuFunctionalWithZip(values: List[Double], calories: List[Int], names: List[String]): List[Food] = {
    val menu: List[Food] = if(isEmpty(values) || isEmpty(calories) || isEmpty(names) ) {
      List.empty[Food]
    } else {
      isSameSize(values, calories, names)
      val myMenu: List[Food] = (names,values,calories).zipped.map(Food(_,_,_))
      myMenu
    }
    menu
  }
}






