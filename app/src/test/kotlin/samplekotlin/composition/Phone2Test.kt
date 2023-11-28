package samplekotlin.composition

import samplekotlin.inheritied.Money
import java.time.Duration
import kotlin.test.Test

class Phone2Test {
  @Test
  fun test() {
    // 일반정책 phone 만들기
    Phone2(
      ratePolicy = RegularPolicy(Money.wons(5.0), Duration.ofSeconds(10))
    )

    // 심야할인 phone 만들기
    Phone2(
      ratePolicy = NightlyDiscountPolicy(Money.wons(5.0), Money.wons(10.0), Duration.ofSeconds(10))
    )

    // 일반정책에 세금 추가
    val regularPolicy = RegularPolicy(Money.wons(5.0), Duration.ofSeconds(10))
    val taxPolicy = TaxablePolicy(
      next = regularPolicy,
      taxRatio = 0.05
    )
    Phone2(taxPolicy)
  }
}