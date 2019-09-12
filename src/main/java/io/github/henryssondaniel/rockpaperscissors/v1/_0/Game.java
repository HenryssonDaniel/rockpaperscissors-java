package io.github.henryssondaniel.rockpaperscissors.v1._0;

import java.util.UUID;

// The interface for the game. This is the interface that the GameResource will use to interact with
// the game.
interface Game {
  String getState();

  UUID getUuid();

  String join(String name);

  String move(String move, String name);
}
