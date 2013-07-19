package hw1

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 18.
 * Time: 오후 9:53
 * To change this template use File | Settings | File Templates.
 */

object Iterator {
  def iter(n: Int, f: (Int => Int), init: Int = 0): (Int => Int) = {
    if (n <= 0) identity
    else {
      f compose iter(n-1, f)
    }
  }
}