package com.sample

import argonaut._, Argonaut._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{ FunSpec, Matchers }

class CitySpec extends FunSpec with Matchers with PropertyChecks {
  import City._

  describe("""decoding from JSON""") {
    it("""decodes city info json""") {
      val input =
        """
          | {
          |   "city_name": "SF",
          |   "city_id": 1
          | }
        """.stripMargin

      val expected = City("SF",1)

      input.decodeOption[City] should be (Some(expected))
    }

    it("""fails to decode if the city name key is invalid""") {
      val input =
        """
          | {
          |   "city_name-invalid": "SF",
          |   "city_id": 1
          | }
        """.stripMargin

      input.decodeOption[City] should be (None)
    }

    it("""fails to decode if the city id is invalid""") {
      val input =
        """
          | {
          |   "city_name": "SF",
          |   "city_id-invalid": 1
          | }
        """.stripMargin

      input.decodeOption[City] should be (None)
    }
  }
}
