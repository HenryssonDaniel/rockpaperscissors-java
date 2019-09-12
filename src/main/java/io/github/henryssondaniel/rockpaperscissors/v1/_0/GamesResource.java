package io.github.henryssondaniel.rockpaperscissors.v1._0;

interface GamesResource {
  String checkState(String id);

  String join(String data, String id);

  String move(String data, String id);

  String newGame(String data);
}
