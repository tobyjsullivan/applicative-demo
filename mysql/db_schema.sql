CREATE TABLE `favouriteStudio` (
    `userId` INT(7) NOT NULL,
    `studioId` INT(7) NOT NULL,
    PRIMARY KEY `idx_user_studio` (`userId`, `studioId`),
    INDEX `idx_user` (`userId`)
);
