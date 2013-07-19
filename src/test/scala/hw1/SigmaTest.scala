package hw1

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 18.
 * Time: 오후 9:20
 * To change this template use File | Settings | File Templates.
 */
class SigmaTest extends FunSuite with ShouldMatchers {
  test("sigma test") {
    Sigma.sigma(1, 10)(identity) should be (55)
    Sigma.sigma(1, 10)(_ + 1) should be (65)
  }
}
