package models.dao

import anorm._
import models.FavouriteStudio
import play.api.db.DB
import play.api.Play.current

object FavouriteStudioDAO {
  def create(favourite: FavouriteStudio) = {
    DB.withConnection { implicit c =>
      SQL(
        """
          | INSERT IGNORE INTO `favouriteStudio` (`userId`, `studioId`)
          | VALUES
          |   ({userId}, {studioId});
        """.stripMargin).on(
          "userId" -> favourite.userId,
          "studioId" -> favourite.studioId
        ).executeInsert()
    }
  }
}
