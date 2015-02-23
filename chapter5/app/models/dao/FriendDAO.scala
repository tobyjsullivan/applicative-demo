package models.dao

import models.Friend
import play.api.Play
import play.api.Play.current
import play.api.libs.ws._

import scala.concurrent._

object FriendDAO {
  val friendsServiceUrl = Play.current.configuration.getString("service.backend.url").get + "/friends"

  /**
   * Fetches a list of friends associated with the given user ID
   * @param userId The ID of the user to find friends of
   * @return A list of friends associated with the specified user
   */
  def index(userId: Int)(implicit ec: ExecutionContext): Future[List[Friend]] = {
    val holder: WSRequestHolder = WS.url(friendsServiceUrl)
      .withQueryString("userId" -> userId.toString)

    // Execute the web service request and get back a future of a response
    val fResponse = holder.get()

    fResponse.map { response =>
      // The response will be JSON so parse out the list of friends' IDs
      val friendIds: List[Int] = (response.json \ "result" \\ "friendId").map(_.as[Int]).toList

      // Map the list of IDs to a list of friends
      friendIds.map(Friend.apply)
    }
  }
}
