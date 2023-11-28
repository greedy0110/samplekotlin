package samplekotlin.inheritied

class Money(
  private val amount: Double,
) {

  operator fun plus(other: Money): Money {
    return Money(amount + other.amount)
  }

  operator fun times(other: Money): Money {
    return Money(amount * other.amount)
  }

  operator fun times(other: Double): Money {
    return Money(amount * other)
  }

  companion object {
    val EMPTY = Money(0.0)
  }
}