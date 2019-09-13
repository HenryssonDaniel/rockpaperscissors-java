# Rock paper scissors game
[![Build Status](https://travis-ci.com/HenryssonDaniel/rockpaperscissors-java.svg?branch=master)](https://travis-ci.com/HenryssonDaniel/rockpaperscissors-java)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=HenryssonDaniel_rockpaperscissors-java&metric=coverage)](https://sonarcloud.io/dashboard?id=HenryssonDaniel_rockpaperscissors-java)
[![latest release](https://img.shields.io/badge/release%20notes-1.0.0-yellow.svg)](https://github.com/HenryssonDaniel/rockpaperscissors-java/blob/master/doc/release-notes/official.md)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.henryssondaniel/rockpaperscissors.svg)](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22io.github.henryssondaniel%22%20AND%20a%3A%22rockpaperscissors%22)
[![Javadocs](https://www.javadoc.io/badge/io.github.henryssondaniel/rockpaperscissors.svg)](https://www.javadoc.io/doc/io.github.henryssondaniel/rockpaperscissors)
## Start the application
The application requires Java 11 and Gradle.  

Run the application with the command: "gradle appRun", which will start a Jetty server and deploy the application there.
## API
GET /api/games/{id}  
POST /api/games  
POST /api/games/{id}/join  
POST /api/games/{id}/move
## Examples
### GET
http://localhost:8080/RockPaperScissors/api/games/49825edf-d5ae-4867-9406-2286a0b4e7b9
  
Possible output: Daniel: PAPER. Daniela: ROCK. The winner is: Daniel
### POST
http://localhost:8080/RockPaperScissors/api/games  
Request body: {"name": "Daniel"}

This will return an UUID to be used for this game. Possible 49825edf-d5ae-4867-9406-2286a0b4e7b9  

http://localhost:8080/RockPaperScissors/api/games/49825edf-d5ae-4867-9406-2286a0b4e7b9/join  
Request body: {"name": "Daniela"}  

This will return a response message, possible OK.  

http://localhost:8080/RockPaperScissors/api/games/49825edf-d5ae-4867-9406-2286a0b4e7b9/move  
Request body: {"move": "Paper", "name": "Daniel"}  

This will return a response message, possible OK.