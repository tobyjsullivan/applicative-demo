CREATE DATABASE IF NOT EXISTS `favourites-svc`;

CREATE USER 'favourites-svc'@'localhost' IDENTIFIED BY '1e0OZH5a9PCJ0Anj11ia0Wmy';

GRANT ALL ON `favourites-svc`.* TO 'favourites-svc'@'localhost';
