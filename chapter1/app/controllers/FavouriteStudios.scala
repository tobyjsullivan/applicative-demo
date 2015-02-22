package controllers

import models.FavouriteStudio
import models.FavouriteStudio._
import play.api.libs.json.Json
import play.api.mvc._

object FavouriteStudios extends Controller {
  def add(userId: Int, studioId: Int) = Action {
    // TODO: Add favourite

    Ok(Json.obj("result" -> FavouriteStudio(userId, studioId)))
  }
}
