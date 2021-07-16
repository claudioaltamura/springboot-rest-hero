[![Build Status](https://travis-ci.com/claudioaltamura/springboot-rest-hero.svg?branch=master)](https://travis-ci.com/claudioaltamura/springboot-rest-hero)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# spring-rest-hero
Spring Boot REST Hero application example

## Get

find all
    curl -i http://localhost:8080/api/v1/heroes

get one
    curl -i http://localhost:8080/api/v1/heroes/1

## Post
    curl -i -X POST -H "Accept:application" http://localhost:8080/api/v1/heroes
