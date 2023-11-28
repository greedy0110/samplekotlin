package samplekotlin

// 코틀린에서는 손쉽게 위임을 처리할 수 있다.
class InstrumentedHashSet<E>(
  private val set: MutableSet<E>,
) : MutableSet<E> by set {
  private var addCount = 0

  override fun add(element: E): Boolean {
    addCount++
    return set.add(element)
  }

  override fun addAll(elements: Collection<E>): Boolean {
    addCount += elements.size
    return set.addAll(elements)
  }
}
