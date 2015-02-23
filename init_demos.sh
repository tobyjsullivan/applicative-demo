#!/bin/sh

pushd mysql
./init.sh
popd
pushd friend-service
sbt "run 9001"
