package actors

import akka.actor.{Props, Actor}
import models.FavouriteStudio

object NotificationActor {
  def props: Props = Props(new NotificationActor)
}

class NotificationActor extends Actor {
  def receive = {
    case favourite: FavouriteStudio =>
      notifyFriendsOfFavourite(favourite)
  }

  private def notifyFriendsOfFavourite(favourite: FavouriteStudio): Unit = {
    // TODO: Lookup friends

    // TODO: Send a push notification to each friend
  }

}
