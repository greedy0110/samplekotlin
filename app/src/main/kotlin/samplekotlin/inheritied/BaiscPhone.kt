package samplekotlin.inheritied

import java.time.Duration

abstract class Phone {
  private val calls = mutableListOf<Call>()

  fun calculateFee(): Money {
    var result = Money.EMPTY

    for (call in calls) {
      result += calculateCallFee(call)
    }

    return result
  }

  open fun afterCalculated(fee: Money): Money {
    return fee
  }

  protected abstract fun calculateCallFee(call: Call): Money
}

// 부가정책은 적용하지 않고 기본 정책만을 요금계산하는 경우
open class RegularPhone(
  private val amount: Money,
  private val seconds: Duration,
) : Phone() {

  override fun calculateCallFee(call: Call): Money {
    return amount * (call.duration.seconds / seconds.seconds.toDouble())
  }
}

// 부가정책은 적용하지 않고 기본 정책만을 요금계산하는 경우
open class NightlyDiscountPhone(
  private val nightlyAmount: Money,
  private val regularAmount: Money,
  private val seconds: Duration,
) : Phone() {
  override fun calculateCallFee(call: Call): Money {
    if (call.from.hour >= LATE_NIGHT_HOUR) {
      return nightlyAmount * (call.duration.seconds / seconds.seconds.toDouble())
    }

    return regularAmount * (call.duration.seconds / seconds.seconds.toDouble())
  }

  companion object {
    private const val LATE_NIGHT_HOUR = 22
  }
}
