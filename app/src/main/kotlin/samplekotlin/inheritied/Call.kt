package samplekotlin.inheritied

import java.time.Duration
import java.time.LocalDateTime

class Call(
  val from: LocalDateTime,
  val to: LocalDateTime,
) {
  val duration: Duration get() = Duration.between(from, to)
}