package samplekotlin

class Stack<E> {
  private val elements = mutableListOf<E>()

  fun push(item: E): E {
    elements.add(item)
    return item
  }

  fun pop(): E {
    check(elements.isNotEmpty())
    return elements.removeLast()
  }
}
