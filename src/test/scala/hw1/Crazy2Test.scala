package hw1.crazy

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 19.
 * Time: 오전 9:24
 * To change this template use File | Settings | File Templates.
 */
class Crazy2Test extends FunSuite with ShouldMatchers {
  val c0 = ZERO(NIL)     // 0
  val c1 = ONE(NIL)      // 1
  val c_1 = MONE(NIL)    // -1
  val c01 = ZERO(ONE(NIL))     // 01
  val c0_1 = ZERO(MONE(NIL))     // 0-1

  val c001 = ZERO(ZERO(ONE(NIL)))
  val c00_1 = ZERO(ZERO(MONE(NIL)))

  val c000 = ZERO(ZERO(ZERO(NIL)))
  val c01_1 = ZERO(ONE(MONE(NIL)))
  val c111 = ONE(ONE(ONE(NIL)))
  val c_1_1_1 = MONE(MONE(MONE(NIL)))
  val c_101 = MONE(ZERO(ONE(NIL)))

  test("crazy2val Test") {
    Crazy2.crazy2val(c01_1) should be (-2)
    Crazy2.crazy2val(c111) should be (7)
    Crazy2.crazy2val(c_1_1_1) should be (-7)
    Crazy2.crazy2val(c_101) should be (3)
  }

  test("crazy2add Test") {
    Crazy2.crazy2add(c0, c0) should be (c0)
    Crazy2.crazy2add(c0, c1) should be (c1)
    Crazy2.crazy2add(c0, c_1) should be (c_1)
    Crazy2.crazy2add(c1, c0) should be (c1)
    Crazy2.crazy2add(c1, c1) should be (c01)
    Crazy2.crazy2add(c1, c_1) should be (c0)
    Crazy2.crazy2add(c_1, c0) should be (c_1)
    Crazy2.crazy2add(c_1, c1) should be (c0)
    Crazy2.crazy2add(c_1, c_1) should be (c0_1)

    Crazy2.crazy2add(c01_1, c01_1) should be (ZERO(ZERO(ONE(MONE(NIL)))))
    Crazy2.crazy2add(c01_1, c111) should be (ONE(ZERO(ONE(NIL))))

    val x = Crazy2.crazy2val(c01_1)
    val z = Crazy2.crazy2val(Crazy2.crazy2add(c01_1, c01_1))

    x+x should be (z)

  }
}
