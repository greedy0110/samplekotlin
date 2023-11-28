package samplekotlin.composition

import samplekotlin.inheritied.Money

// 부가정책을 표현함
abstract class AdditionalRatePolicy(
  private val next: RatePolicy,
) : RatePolicy {
  override fun calculateFee(phone: Phone2): Money {
    val fee = next.calculateFee(phone)
    return afterCalculated(fee)
  }

  protected abstract fun afterCalculated(fee: Money): Money
}

// 세금 정책
class TaxablePolicy(
  next: RatePolicy,
  private val taxRatio: Double,
) : AdditionalRatePolicy(next) {
  override fun afterCalculated(fee: Money): Money {
    return fee + fee * taxRatio
  }
}

// 세금 정책
class RateDiscountablePolicy(
  next: RatePolicy,
  private val discountAmount: Money,
) : AdditionalRatePolicy(next) {
  override fun afterCalculated(fee: Money): Money {
    return fee - discountAmount
  }
}