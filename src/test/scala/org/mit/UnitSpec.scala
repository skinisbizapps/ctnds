package org.mit

/**
  * Created by skinibizapps on 7/22/17.
  */
import org.scalatest._
import org.scalatest.Assertions._

abstract class UnitSpec extends FlatSpec with Matchers with
  OptionValues with Inside with Inspectors
