package samplekotlin.inheritied

import java.time.Duration

// 세금을 처리하고 요금할인
class TaxableAndRateDiscountableRegularPhone(
  private val amount: Money,
  private val seconds: Duration,
  private val taxRate: Double,
  private val discountAmount: Money,
) : TaxableRegularPhone2( amount, seconds, taxRate ) {
  override fun afterCalculated(fee: Money): Money {
    //FIXME: 미안하지만, 다시 부모 클래스 구현에 의존한다.
    return super.afterCalculated(fee) - discountAmount
  }
}

// 요금을 할인하고 세금을 처리
class RateDiscountableAndTaxableRegularPhone(
  amount: Money,
  seconds: Duration,
  discountAmount: Money,
  private val taxRate: Double,
) : RateDiscountableRegularPhone( amount, seconds, discountAmount ) {
  override fun afterCalculated(fee: Money): Money {
    return super.afterCalculated(fee) + (fee * taxRate)
  }
}
