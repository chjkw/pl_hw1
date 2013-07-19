package hw1

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.Checkers

/**
 * Created with IntelliJ IDEA.
 * User: chjkw
 * Date: 13. 7. 18.
 * Time: 오후 8:04
 * To change this template use File | Settings | File Templates.
 */

class MyListTest extends FunSuite with Checkers with ShouldMatchers {
  implicit def list2mylist(l: List[Int]) : MyList = MyList(l:_*)
  // "check" is auto testcase generator
  test("list length test") {
    check{(x: List[Int]) => MyList.length(x) == x.length}
  }

  // _+1 is f:(x: Int): Int = x + 1
  test("list map test") {
    check{(x: List[Int]) => MyList.map(_+1)(x) == (x.map(_+1) : MyList)}
  }


  test("list fold_left test") {
    check{(x: List[Int]) => MyList.fold_left(_+_)(0)(x) == x.foldLeft(0)(_+_)}
  }

  test("list mem test") {
    val myList = MyList(1,2,3)

    MyList.mem(2, myList) should be (true)
    MyList.mem(6, myList) should be (false)
  }

  test("list for_all test") {
    val myList = MyList(1,2,3)

    MyList.for_all((x:Int) => x > 0)(Nil) should be (false)
    MyList.for_all((x:Int) => x > 0)(myList) should be (true)
    MyList.for_all((x:Int) => x > 2)(myList) should be (false)
    MyList.for_all((x:Int) => x > 3)(myList) should be (false)
    MyList.for_all((x:Int) => x < 4)(myList) should be (true)

  }
}
