package hw1

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 19.
 * Time: 오전 3:14
 * To change this template use File | Settings | File Templates.
 */
class NaturalTest extends FunSuite with ShouldMatchers {
  val n1 = SUCC(SUCC(SUCC(SUCC(SUCC(ZERO)))))
  val n2 = SUCC(SUCC(SUCC(ZERO)))

  test("n2nat Test") {
    Natural.n2nat(5) should be (n1)
    Natural.n2nat(3) should be (n2)
  }

  val n3 = Natural.n2nat(8)
  val n4 = Natural.n2nat(15)

  test("nat2n Test") {
    Natural.nat2n(n1) should be (5)
    Natural.nat2n(n2) should be (3)
    Natural.nat2n(n3) should be (8)
    Natural.nat2n(n4) should be (15)
  }

  test("Natural natadd Test") {
    Natural.natadd(n1, n2) should be (n3)
  }

  test("Natural natmul Test") {
    Natural.natmul(n1, n2) should be (n4)
  }
}
