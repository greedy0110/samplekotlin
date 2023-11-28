package samplekotlin.inheritied

import java.time.Duration

open class RateDiscountableRegularPhone(
  amount: Money,
  seconds: Duration,
  private val discountAmount: Money,
) : RegularPhone(amount, seconds) {
  override fun afterCalculated(fee: Money): Money {
    return fee - discountAmount
  }
}

open class RateDiscountableNightlyDiscountPhone(
  nightlyAmount: Money,
  regularAmount: Money,
  seconds: Duration,
  private val discountAmount: Money,
) : NightlyDiscountPhone(nightlyAmount, regularAmount, seconds) {
  override fun afterCalculated(fee: Money): Money {
    return fee - discountAmount
  }
}