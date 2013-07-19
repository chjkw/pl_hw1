package hw1

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 18.
 * Time: 오후 12:10
 * To change this template use File | Settings | File Templates.
 */

abstract class MyList
case object Nil extends MyList
case class Cons(n: Int, list: MyList) extends MyList

object MyList {
  val empty : MyList = Nil
  def apply(xs: Int*) : MyList = xs.foldRight(empty)(Cons)

  @tailrec
  def length(list: MyList, len: Int = 0): Int = {
    list match  {
      case Nil => len
      case Cons(head, tail) => length(tail, len + 1)
    }
  }

  def map(f: Int => Int)(list: MyList): MyList = {
    list match {
      case Nil => Nil
      case Cons(head, tail) => Cons(f(head), map(f)(tail))
    }
  }

  @tailrec
  def fold_left(f: (Int,Int) => Int)(init: Int)(list: MyList): Int = {
    list match {
      case Nil => init
      case Cons(head, tail) => fold_left(f)(f(init, head))(tail)
    }
  }

  @tailrec
  def mem(elem: Int, list: MyList): Boolean = {
    list match {
      case Nil => false
      case Cons(head, tail) => if(elem == head) true else mem(elem, tail)
    }
  }

  def for_all(f: Int => Boolean)(list: MyList): Boolean = {
    @tailrec
    def _for_all(f:Int => Boolean)(list: MyList): Boolean = {
      list match {
        case Nil => true
        case Cons(head, tail) => if(f(head)) _for_all(f)(tail) else false
      }
    }

    if(list == Nil) false else _for_all(f)(list)
  }
}