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

  def remove(userId: Int, studioId: Int) = Action {
    FavouriteStudio.delete(userId, studioId)

    Ok(Json.obj("result" -> Json.obj()))
  }

  def find(userId: Int, studioId: Int) = Action {
    val oFavourite = FavouriteStudio.find(userId, studioId)

    oFavourite match {
      case None => NotFound(Json.obj("error" -> "NOT_FOUND"))
      case Some(favourite) => Ok(Json.obj("result" -> favourite))
    }
  }

  def findAll(userId: Int) = Action {
    val allFavourites = FavouriteStudio.findAllByUser(userId)

    Ok(Json.obj("result" -> allFavourites))
  }
}
