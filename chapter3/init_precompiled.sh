#!/bin/sh

# Clean out dist
rm -rf target/universal/*

# Compile distributable
sbt dist

# Unzip components
pushd target/universal
unzip chapter3-demo-1.0.zip
popd
