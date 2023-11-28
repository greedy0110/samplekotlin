package samplekotlin.composition

import samplekotlin.inheritied.Money
import java.time.Duration

fun RegularPhone(amount: Money, seconds: Duration) =
  Phone2(RegularPolicy(amount, seconds))

fun NightlyDiscountPhone(
  nightlyAmount: Money,
  regularAmount: Money,
  seconds: Duration,
) = Phone2(NightlyDiscountPolicy(nightlyAmount, regularAmount, seconds))
