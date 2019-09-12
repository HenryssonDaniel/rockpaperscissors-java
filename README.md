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