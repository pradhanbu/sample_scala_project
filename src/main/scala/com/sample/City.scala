package com.sample

import argonaut.DecodeJson

case class City(
  name: String,
  id: Int
)

object City {
  implicit val decoder: DecodeJson[City] = DecodeJson(
    c => for {
      name <- (c --\ "city_name").as[String]
      id <- (c --\ "city_id").as[Int]
    } yield City(name, id)
  )
}