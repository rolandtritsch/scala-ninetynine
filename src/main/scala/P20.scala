package org.tritsch.scala.ninetynine

/**
 * P20 - Remove the Kth element from a list (index on 0)
 */

object P20 {
  final def removeAt(n: Int, l: List[Any]): (List[Any], Any) = {
    assert(l.size == l.distinct.size, "This only works with no dublicates")
    (l.filterNot(l(n) == _), l(n))
  }

  final def removeAt2(n: Int, l: List[Any]): (List[Any], Any) = {
    (l.take(n) ::: l.drop(n+1), l(n))  
  }

  final def removeAt3(n: Int, l: List[Any]): (List[Any], Any) = {
    ((for(i <- l.indices; if(i != n)) yield l(i)).toList, l(n))
  }

  final def removeAt4(n: Int, l: List[Any]): (List[Any], Any) = {
    assert(l.size == l.distinct.size, "This only works with no dublicates")
    (l.diff(List(l(n))), l(n))
  }

  final def removeAt5(n: Int, l: List[Any]): (List[Any], Any) = {
    assert(l.size == l.distinct.size, "This only works with no dublicates")
    (l.map(e => if(l(n) != e) e), l(n))
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 1, "Need at least 2 parameters - Usage: P20 <nth> <list of numbers>")
    val nth = args(0).toInt; val list = args.drop(1).toList
    assert(nth >= 0 && nth <= list.size-1, "Nth needs to be in range of 0 .. list.size-1")
    assert(!list.isEmpty, "List needs to have at least 1 element")
    println(nth + ": " + list.mkString(",") + " -> " + removeAt(nth, list).toString)
    println(nth + ": " + list.mkString(",") + " -> " + removeAt2(nth, list).toString)
    println(nth + ": " + list.mkString(",") + " -> " + removeAt3(nth, list).toString)
    println(nth + ": " + list.mkString(",") + " -> " + removeAt4(nth, list).toString)
    println(nth + ": " + list.mkString(",") + " -> " + removeAt5(nth, list).toString)
  } 
}
