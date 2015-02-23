package models

import models.dao.FriendDAO

import scala.concurrent._

object Friend {
  def findAllFriends(userId: Int)(implicit ec: ExecutionContext): Future[Set[Friend]] =
    FriendDAO.index(userId).map(_.toSet)
}

case class Friend(friendId: Int)
