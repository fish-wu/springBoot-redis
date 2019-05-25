#!/usr/bin/env bash
cd ..
./gradlew clean
./gradlew build
cp ./build/libs/*.jar ./deploy/app.jar
cd ./deploy
docker-compose build
docker-compose up
