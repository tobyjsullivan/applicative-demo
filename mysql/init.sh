#!/bin/bash

mysql.server start

mysql -h 127.0.0.1 -u root < db_clean.sql

mysql -h 127.0.0.1 -u root < db_init.sql

mysql -h 127.0.0.1 -u favourites-svc -p1e0OZH5a9PCJ0Anj11ia0Wmy favourites-svc < db_schema.sql

mysql -h 127.0.0.1 -u favourites-svc -p1e0OZH5a9PCJ0Anj11ia0Wmy favourites-svc -e 'show tables;'
