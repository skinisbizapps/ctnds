package org.mit

class ListUtilSpec extends UnitSpec {
  /*
    def isEmpty[A](x: List[A]) = { x == null || x.isEmpty }

  def isSameSize(x: List[Double], y: List[Int], z: List[String]) = if(!isEmpty(x) && !isEmpty(y) && !isEmpty(z)) {
    if(x.size - y.size + z.size != x.size) throw new ArrayIndexOutOfBoundsException(s"The sizes of lists x: $x.size, y: $y.size, and z: $z.size do not match")
  }

   */
  "isEmpty function" must "return true if the list parameter is null or empty" in {
    assertResult(true) { ListUtil.isEmpty(null) }
    assertResult(true) {ListUtil.isEmpty(List[Int]())}
    assertResult(false){ListUtil.isEmpty(List(1,2,3))}
    assertResult(false) {ListUtil.isNotEmpty(null)}
    assertResult(true) {ListUtil.isNotEmpty(List(1,2,3))}
    assertResult(false) {ListUtil.isNotEmpty(List[Int]())}
  }
}
