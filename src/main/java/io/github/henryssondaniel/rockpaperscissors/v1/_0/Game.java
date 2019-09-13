package io.github.henryssondaniel.rockpaperscissors.v1._0;

import java.util.UUID;

interface Game {
  String getState();

  UUID getUuid();

  String join(String name);

  String move(String move, String name);
}
