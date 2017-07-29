package org.mit

import scala.collection.mutable.ListBuffer


object Algorithm {

  val isEmpty = ListUtil.isEmpty _


  //TODO - pass in a sort function to the greedy method to allow flexibiltiy to change what's best for greedy algorithm.
  def greedy(items: Option[List[Food]], maxCost: Option[Double], fn:(Food, Food) => Boolean): (List[Food], Double) = {
    val invalidValues = List(Some(null), Some(Nil), Some(List.empty[Food]))

    val returnTuple:(List[Food], Double) = (items, maxCost) match {
      case (_, Some(0.0))  =>  {
        println("f2")
        (List.empty[Food], 0.0)

      }
      case (f1, _ ) if !f1.contains(Some(null)) => {
        //steps to implement the greedy algorithm here
        //sort the input list
        val inputList = items.getOrElse(List.empty[Food]).sortWith(fn)
        println(s"${inputList.length} is the length of input list")

        var itemsPicked:ListBuffer[Food] = ListBuffer()
        var maxValue = 0.0
        val maxWeight = maxCost.getOrElse(0.0)
        println(s"$maxWeight <- this is")
        val totalWeight = inputList.foldLeft(0.0) {
          (totalWeight: Double, next: Food) =>
            println(s"starting totalWeight is $totalWeight and food is ${next.name}")
            if (totalWeight + next.calories < maxWeight) {

              itemsPicked += (next)
              println(s"adding $next to itemPicked. New value of itempicked is $itemsPicked")
              val ttlWt = totalWeight + next.calories
              println(s"total weight is $ttlWt")
              maxValue += next.value
              ttlWt
            } else {
              println(s"totalWeight final is $totalWeight")
              totalWeight
            }

        }

        println(s"$itemsPicked and total value is $maxValue")

        (itemsPicked.toList, maxValue)
      }
    }

    returnTuple
  }

}
