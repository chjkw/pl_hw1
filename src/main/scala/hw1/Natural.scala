package hw1

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 19.
 * Time: 오전 3:05
 * To change this template use File | Settings | File Templates.
 */

abstract class Natural
case object ZERO extends Natural
case class SUCC(n: Natural) extends Natural

object Natural {
  @tailrec
  def natadd (n1: Natural, n2: Natural): Natural = {
    n1 match {
      case ZERO => n2
      case SUCC(nat1) => {
        n2 match {
          case ZERO => n1
          case SUCC(nat2) => natadd(nat1, SUCC(n2))
        }
      }
    }
  }

  @tailrec
  def natmul (n1: Natural, n2: Natural, result: Natural = ZERO): Natural = {
    n1 match {
      case ZERO => result
      case SUCC(nat1) => {
        n2 match {
          case ZERO => result
          case SUCC(nat2) => natmul(nat1, n2, natadd(result, n2))
        }
      }
    }
  }

  @tailrec
  def nat2n(nat: Natural, result: Int = 0): Int = {
    nat match {
      case ZERO => result
      case SUCC(n) => nat2n(n, result+1)
    }
  }

  @tailrec
  def n2nat(n: Int, nat: Natural = ZERO): Natural = {
    if (n <= 0) nat
    else n2nat(n-1, SUCC(nat))
  }
}

