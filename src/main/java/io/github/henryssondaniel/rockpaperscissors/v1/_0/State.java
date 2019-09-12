package io.github.henryssondaniel.rockpaperscissors.v1._0;

enum State {
  DONE("{0}: {1}. {2}: {3}. The winner is: {4}."),
  WAITING_BOTH("None of the player has done a move yet."),
  WAITING_JOIN("Waiting for the second player to join the game."),
  WAITING_PLAYER_1("Waiting for {0} to make a move."),
  WAITING_PLAYER_2("Waiting for {0} to make a move.");

  private final String message;

  State(String message) {
    this.message = message;
  }

  String getMessage() {
    return message;
  }
}
