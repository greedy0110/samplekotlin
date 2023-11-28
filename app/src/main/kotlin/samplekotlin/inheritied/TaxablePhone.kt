package samplekotlin.inheritied

import java.time.Duration

class TaxableRegularPhone1(
  private val amount: Money,
  private val seconds: Duration,
  private val taxRate: Double,
) : RegularPhone(amount, seconds) {
  override fun calculateCallFee(call: Call): Money {
    //FIXME: 부모클래스의 계산 값에 의존해서 자식 코드를 작성했다.
    // 이 경우 자식->부모로의 의존성이 생기며 부모 수정이 어려워질 수 있다.
    // 추상화에 의존하도록 수정하는게 좋겠다.
    val fee = super.calculateCallFee(call)
    return fee + (fee * taxRate)
  }
}

class TaxableRegularPhone2(
  private val amount: Money,
  private val seconds: Duration,
  private val taxRate: Double,
) : RegularPhone(amount, seconds) {
  override fun afterCalculated(fee: Money): Money {
    return fee + (fee * taxRate)
  }
}

class TaxableNightlyDiscountPhone(
  private val nightlyAmount: Money,
  private val regularAmount: Money,
  private val seconds: Duration,
  private val taxRate: Double,
) : NightlyDiscountPhone(nightlyAmount, regularAmount, seconds) {
  override fun afterCalculated(fee: Money): Money {
    return fee + (fee * taxRate)
  }
}