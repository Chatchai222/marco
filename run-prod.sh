#!/usr/bin/env bash
#
# Run the spring boot application with 
# the "prod" profile
script_dir=$(dirname "$0")
cd $script_dir
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod