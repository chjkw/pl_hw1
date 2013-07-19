package hw1

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 19.
 * Time: 오전 2:16
 * To change this template use File | Settings | File Templates.
 */
abstract class Formula
  case object TRUE extends Formula
  case object FALSE extends Formula
  case class NOT(f: Formula) extends Formula
  case class ANDALSO(f1: Formula, f2: Formula) extends Formula
  case class ORELSE(f1: Formula, f2: Formula) extends Formula
  case class IMPLY(f1: Formula, f2: Formula) extends Formula
  case class LESS(e1: Expr, e2: Expr) extends Formula

abstract class Expr
  case class NUM(n: Int) extends Expr
  case class PLUS(e1: Expr, e2: Expr) extends Expr
  case class MINUS(e1: Expr, e2: Expr) extends Expr

object Formula {
  def eval (form: Formula): Boolean = {
    form match {
      case TRUE => true
      case FALSE => false
      case NOT(f) => if (eval(f)) false else true
      case ANDALSO(f1, f2) => if (eval(f1) && eval(f2)) true else false
      case ORELSE(f1, f2) => if (eval(f1) || eval(f2)) true else false
      case IMPLY(f1, f2) => if ((eval(f1) == true) && (eval(f2) == false)) false else true
      case LESS(e1, e2) => if(eval(e1) < eval(e2)) true else false
    }
  }
  def eval (expr: Expr): Int = {
    expr match {
      case NUM(n) => n
      case PLUS(e1, e2) => eval(e1) + eval(e2)
      case MINUS(e1, e2) => eval(e1) - eval(e2)
    }
  }
}
