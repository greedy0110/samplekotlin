package samplekotlin.composition

import samplekotlin.inheritied.Call
import samplekotlin.inheritied.Money
import java.time.Duration

// 기본정책과 부가정책을 포괄
interface RatePolicy {
  fun calculateFee(phone: Phone2): Money
}

// 기본정책 구현, 상속 버전의 Phone과 매우 비슷하다.
abstract class BaseRatePolicy : RatePolicy {
  override fun calculateFee(phone: Phone2): Money {
    val result = Money.ZERO
    for (call in phone.calls) {
      result + calculateCallFee(call)
    }
    return result
  }

  abstract fun calculateCallFee(call: Call): Money
}

class RegularPolicy(
  private val amount: Money,
  private val seconds: Duration,
) : BaseRatePolicy() {
  override fun calculateCallFee(call: Call): Money {
    return amount * (call.duration.seconds / seconds.seconds.toDouble())
  }
}

class NightlyDiscountPolicy(
  private val nightlyAmount: Money,
  private val regularAmount: Money,
  private val seconds: Duration,
) : BaseRatePolicy() {
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
