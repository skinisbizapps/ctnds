package org.mit

object ListUtil {

  def isEmpty[A](x: List[A]): Boolean =  x == null || x.isEmpty

  def isNotEmpty[A](x: List[A]): Boolean = (!isEmpty(x))
}
