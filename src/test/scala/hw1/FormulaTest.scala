package hw1

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 19.
 * Time: 오전 2:49
 * To change this template use File | Settings | File Templates.
 */
class FormulaTest extends FunSuite with ShouldMatchers {
  val T = TRUE
  val F = FALSE

  val e10 = NUM(10)
  val e100 = NUM(100)

  val complex = ANDALSO(ORELSE(LESS(e10, e100), NOT(TRUE)), IMPLY(FALSE,TRUE))

  test ("Formula TRUE Test") {
    Formula.eval(T) should be (true)
  }

  test ("Formula FALSE Test") {
    Formula.eval(F) should be (false)
  }

  test ("Formula NOT Test") {
    Formula.eval(NOT(T)) should be (false)
    Formula.eval(NOT(F)) should be (true)
  }

  test ("Formula ANDALSO Test") {
    Formula.eval(ANDALSO(T, T)) should be (true)
    Formula.eval(ANDALSO(T, F)) should be (false)
    Formula.eval(ANDALSO(F, T)) should be (false)
    Formula.eval(ANDALSO(F, F)) should be (false)
  }

  test ("Formula ORELSE Test") {
    Formula.eval(ORELSE(T, T)) should be (true)
    Formula.eval(ORELSE(T, F)) should be (true)
    Formula.eval(ORELSE(F, T)) should be (true)
    Formula.eval(ORELSE(F, F)) should be (false)
  }

  test ("Formula IMPLY Test") {
    Formula.eval(IMPLY(T, T)) should be (true)
    Formula.eval(IMPLY(T, F)) should be (false)
    Formula.eval(IMPLY(F, T)) should be (true)
    Formula.eval(IMPLY(F, F)) should be (true)
  }

  test ("Formula LESS Test") {
    Formula.eval(LESS(e10, e100)) should be (true)
    Formula.eval(LESS(e100, e10)) should be (false)
  }

  test ("Complex Formula Test") {
    Formula.eval(complex) should be (true)
  }
}
