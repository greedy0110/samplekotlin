package samplekotlin.composition

import samplekotlin.inheritied.Call
import samplekotlin.inheritied.Money

class Phone2(
  private val ratePolicy: RatePolicy, // 합성한다.
) {
  val calls = mutableListOf<Call>()
  fun calculateFee(): Money = ratePolicy.calculateFee(this)
}
