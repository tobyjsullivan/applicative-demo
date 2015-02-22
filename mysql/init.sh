#!/bin/bash

mysql.server restart

MYSQL_HOST=127.0.0.1

mysql -h $MYSQL_HOST -u root < db_clean.sql

mysql -h $MYSQL_HOST -u root < db_init.sql

mysql -h $MYSQL_HOST -u favourites-svc -p1e0OZH5a9PCJ0Anj11ia0Wmy favourites-svc < db_schema.sql

mysql -h $MYSQL_HOST -u favourites-svc -p1e0OZH5a9PCJ0Anj11ia0Wmy favourites-svc -e 'show tables;'
