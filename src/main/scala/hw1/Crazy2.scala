package hw1.crazy

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 19.
 * Time: 오전 9:17
 * To change this template use File | Settings | File Templates.
 */
abstract class Crazy2
case object NIL extends Crazy2
case class ZERO (c: Crazy2) extends Crazy2
case class ONE (c: Crazy2) extends Crazy2
case class MONE (c: Crazy2) extends Crazy2

object Crazy2 {
  // Exercise 8
  def crazy2val(c: Crazy2): Int = {
    c match {
      case NIL => 0
      case ZERO(c1) => 0 + 2*crazy2val(c1)
      case ONE(c1) => 1 + 2*crazy2val(c1)
      case MONE(c1) => -1 + 2*crazy2val(c1)
    }
  }

  // Exercise 9
  // crazy2add case by case
  def crazy2add(c1: Crazy2, c2: Crazy2): Crazy2 = {
    c1 match {
      case NIL => c2
      case ZERO(crazy1) => {
        c2 match {
          case NIL => c1
          case ZERO(crazy2) => ZERO(crazy2add(crazy1, crazy2))
          case ONE(crazy2) => ONE(crazy2add(crazy1, crazy2))
          case MONE(crazy2) => MONE(crazy2add(crazy1, crazy2))
        }
      }
      case ONE(crazy1) => {
        c2 match {
          case NIL => c1
          case ZERO(crazy2) => ONE(crazy2add(crazy1, crazy2))
          case ONE(crazy2) => ZERO(crazy2add(ONE(NIL), crazy2add(crazy1, crazy2)))
          case MONE(crazy2) => ZERO(crazy2add(crazy1, crazy2))
        }
      }
      case MONE(crazy1) => {
        c2 match {
          case NIL => c1
          case ZERO(crazy2) => MONE(crazy2add(crazy1, crazy2))
          case ONE(crazy2) => ZERO(crazy2add(crazy1, crazy2))
          case MONE(crazy2) => ZERO(crazy2add(MONE(NIL), crazy2add(crazy1, crazy2)))
        }
      }
    }
  }
}


