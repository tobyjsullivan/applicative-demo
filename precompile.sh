#!/bin/sh

# Compile Chapter 0
pushd chapter0
./init_precompiled.sh
popd

# Compile Chapter 1
pushd chapter1
./init_precompiled.sh
popd

# Compile Chapter 2
pushd chapter2
./init_precompiled.sh
popd

# Compile Chapter 2.1
pushd chapter2.1
./init_precompiled.sh
popd

# Compile Chapter 3
pushd chapter3
./init_precompiled.sh
popd

# Compile Chapter 4
pushd chapter4
./init_precompiled.sh
popd

# Compile Chapter 5
pushd chapter5
./init_precompiled.sh
popd


