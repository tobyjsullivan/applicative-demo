package controllers

import models.FavouriteStudio
import models.FavouriteStudio._
import play.api.cache.{Cached, Cache}
import play.api.libs.json.Json
import play.api.mvc._
import play.api.Play.current

object FavouriteStudios extends Controller {
  private def clearCaches(userId: Int, studioId: Int) =
    List(
      "find_"+userId+"_"+studioId,
      "findAll_"+userId
    ).map { key =>
      Cache.remove(key)
    }

  def add(userId: Int, studioId: Int) = Action {
    val favourite = FavouriteStudio.addFavourite(userId, studioId)

    clearCaches(userId, studioId)

    Ok(Json.obj("result" -> favourite))
  }

  def remove(userId: Int, studioId: Int) = Action {
    FavouriteStudio.delete(userId, studioId)

    clearCaches(userId, studioId)

    Ok(Json.obj("result" -> Json.obj()))
  }

  def find(userId: Int, studioId: Int) = Cached("find_"+userId+"_"+studioId) {
    Action {
      val oFavourite = FavouriteStudio.find(userId, studioId)

      oFavourite match {
        case None => NotFound(Json.obj("error" -> "NOT_FOUND"))
        case Some(favourite) => Ok(Json.obj("result" -> favourite))
      }
    }
  }

  def findAll(userId: Int) = Cached("findAll_"+userId) {
    Action {
      val allFavourites = FavouriteStudio.findAllByUser(userId)

      Ok(Json.obj("result" -> allFavourites))
    }
  }
}
