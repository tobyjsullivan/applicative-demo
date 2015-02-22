package controllers

import models.FavouriteStudio
import models.FavouriteStudio._
import play.api.libs.json.Json
import play.api.mvc._

object FavouriteStudios extends Controller {
  def add(userId: Int, studioId: Int) = Action {
    val favourite = FavouriteStudio.addFavourite(userId, studioId)

    Ok(Json.obj("result" -> favourite))
  }
}
