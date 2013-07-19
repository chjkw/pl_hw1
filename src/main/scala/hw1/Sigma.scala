package hw1

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 18.
 * Time: 오후 9:14
 * To change this template use File | Settings | File Templates.
 */

object Sigma {
  @tailrec
  def sigma(init: Int, target: Int, result:Int=0 )(f:(Int) => Int): Int = {
    if (init > target) result
    else {
      sigma(init+1, target, result+f(init))(f)
    }
  }
}
