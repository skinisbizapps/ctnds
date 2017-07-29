package org.mit

/**
  * Created by skinibizapps on 7/22/17.
  */
class FoodBuilderSpec extends UnitSpec {
  "buildMenuFunctional when passed 3 lists of same size for value, name and calories" must "return a list of Food" in {
    val actualResult = FoodBuilder.buildMenuFunctional(List(1.0, 2.0, 3.0), List(300,250,70), List("pizza","donut","juice"))
    val expectedResult = List(new Food("pizza",1.0, 300), new Food("donut", 2.0, 250), new Food("juice", 3.0, 70))
    assertResult(expectedResult){actualResult}
  }

  "buildMenuFunctional when passed 3 empty lists for value, name and calories" must "return an list " in {
    val menu:List[Food] = FoodBuilder.buildMenuFunctional(null, null, null)
    assert (menu.isEmpty)
    val menuEmpty:List[Food] = FoodBuilder.buildMenuFunctional(List.empty[Double], List.empty[Int], List.empty[String])
    assert (menuEmpty.isEmpty)
  }

  "buildMenuFunctional when passed 3 lists of different sizes for value, name and calories, " must "return an Exception " in {
    assertThrows[ArrayIndexOutOfBoundsException]{FoodBuilder.buildMenuFunctional(List(1.0, 2.0, 3.0,4.0), List(300,250,70), List("pizza","donut"))}
  }
}
