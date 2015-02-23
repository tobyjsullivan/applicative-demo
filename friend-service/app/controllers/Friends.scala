package controllers

import play.api.libs.json.{JsArray, Json}
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Friends extends Controller {
  def index(userId: Int) = Action.async {
    val friendIds = Seq(
      userId + 319380,
      userId - 24389,
      userId + 13502,
      userId + 19374,
      userId - 51093
    )

    val jsFriendIds = friendIds.map(friendId => Json.obj("friendId" -> friendId))
    Future {
      // Artificial latency for demo purposes
      Thread.sleep(3000L)

      Ok(Json.obj(
        "result" -> JsArray(jsFriendIds)
      ))
    }
  }
}
