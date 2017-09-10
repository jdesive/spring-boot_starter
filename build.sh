#/bin/sh

mvn install
docker build -t starter .
