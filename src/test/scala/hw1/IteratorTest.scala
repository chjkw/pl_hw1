package hw1

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 19.
 * Time: 오전 12:49
 * To change this template use File | Settings | File Templates.
 */
class IteratorTest extends FunSuite with ShouldMatchers {
  test("iterator test") {
    val mul = hw1.Iterator.iter(3, (x:Int) => 2+x)
    mul(0) should be (6)
  }
}