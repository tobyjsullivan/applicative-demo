package models

import play.api.libs.functional.syntax._
import play.api.libs.json._

object FavouriteStudio {
  implicit val favouriteStudioWrites: Writes[FavouriteStudio] = (
    (JsPath \ "userId").write[Int] and
      (JsPath \ "studioId").write[Int]
    )(unlift(FavouriteStudio.unapply))
}

case class FavouriteStudio(userId: Int, studioId: Int)
