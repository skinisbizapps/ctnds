package org.mit

class AlgorithmSpec extends UnitSpec {

  val inputList = List(
    Food("Wine", 89.0, 123),
    Food("Beer", 90.0, 154),
    Food("Pizza", 30.0, 258),
    Food("Burger", 50.0, 354),
    Food("Fries", 90.0, 365),
    Food("Coke", 79.0, 150),
    Food("Apple", 90.0, 95),
    Food("Donut", 10.0, 195),
    Food("Bagel", 40.0, 254),
    Food("candy",10.0,10)
  )

  val funCal: (Food, Food) => Boolean = ( food1: Food, food2: Food) => food1.calories.compareTo(food2.calories) < 0
    //154+365+95+123+150+354+254+258
  import org.mit.Algorithm._
  "greedy method " must "return an empty List and 0.0 for value for least calories" in {

    assertResult((List.empty[Food],0.0)) {greedy(Some(null), Some(0.0), funCal)}
    assertResult((List.empty[Food],0.0)) {greedy(Some(Nil), Some(0.0), funCal)}
    assertResult((List.empty[Food],0.0)) {greedy(Some(List.empty[Food]), Some(0.0), funCal)}
    //TODO fix negative test cases
//    assertResult((List.empty[Food],0.0)) {greedy(Some(null), Some(10.0))}
//    assertResult((List.empty[Food],0.0)) {greedy(Some(Nil), Some(10.0))}
//    assertResult((List.empty[Food],0.0)) {greedy(Some(List.empty[Food]), Some(10.0))}

  }


  "greedy method when given a list of food items and a total weight of 1500 " must "return an a list containing Food items with least calories and the total value of 365 " in {

    assertResult((List(Food("candy",10.0,10),
                      Food("Apple", 90.0, 95),
                      Food("Wine", 89.0, 123),
                      Food("Coke",79.0,150),
                      Food("Beer",90.0,154),
                      Food("Donut",10.0,195)), 368.0)) {greedy(Some(inputList), Some(780.0),funCal)}


  }


  val funCost: (Food, Food) => Boolean = ( food1: Food, food2: Food) => food1.getCost().compareTo(food2.getCost()) > 0

  "greedy method " must "return an empty List and 0.0 for value for most cost" in {

    assertResult((List.empty[Food],0.0)) {greedy(Some(null), Some(0.0), funCost)}
    assertResult((List.empty[Food],0.0)) {greedy(Some(Nil), Some(0.0), funCost)}
    assertResult((List.empty[Food],0.0)) {greedy(Some(List.empty[Food]), Some(0.0), funCost)}
    //TODO fix negative test cases
    //    assertResult((List.empty[Food],0.0)) {greedy(Some(null), Some(10.0))}
    //    assertResult((List.empty[Food],0.0)) {greedy(Some(Nil), Some(10.0))}
    //    assertResult((List.empty[Food],0.0)) {greedy(Some(List.empty[Food]), Some(10.0))}

  }


  "greedy method when given a list of food items and a total weight of 1500 " must "return an a list containing Food items with most cost and the total value of 368 " in {

    assertResult((List(
        Food("Fries",90.0,365),
        Food("Burger",50.0,354),
        Food("candy",10.0,10)),150.0)) {greedy(Some(inputList), Some(780.0),funCost)}


  }


  val funDensity: (Food, Food) => Boolean = ( food1: Food, food2: Food) => food1.getDensity().compareTo(food2.getDensity()) > 0

  "greedy method " must "return an empty List and 0.0 for value for most desity" in {

    assertResult((List.empty[Food],0.0)) {greedy(Some(null), Some(0.0), funDensity)}
    assertResult((List.empty[Food],0.0)) {greedy(Some(Nil), Some(0.0), funDensity)}
    assertResult((List.empty[Food],0.0)) {greedy(Some(List.empty[Food]), Some(0.0), funDensity)}
    //TODO fix negative test cases
    //    assertResult((List.empty[Food],0.0)) {greedy(Some(null), Some(10.0))}
    //    assertResult((List.empty[Food],0.0)) {greedy(Some(Nil), Some(10.0))}
    //    assertResult((List.empty[Food],0.0)) {greedy(Some(List.empty[Food]), Some(10.0))}

  }


  "greedy method when given a list of food items and a total weight of 1500 " must "return an a list containing Food items with most density and the total value of 368 " in {

    assertResult((List(
        Food("candy",10.0,10),
        Food("Apple",90.0,95),
        Food("Wine",89.0,123),
        Food("Beer",90.0,154),
        Food("Coke",79.0,150),
        Food("Donut",10.0,195)),368.0)) {greedy(Some(inputList), Some(780.0),funDensity)}


  }

}