package samplekotlin

import java.util.*

class Properties {
  // properties를 필드로 가지면서 불필요한 인터페이스 상속 문제 해결
  private val properties = Hashtable<String, String>()

  fun setProperty(key: String, value: String) {
    properties[key] = value
  }

  fun getProperty(key: String): String? {
    return properties[key]
  }
}
