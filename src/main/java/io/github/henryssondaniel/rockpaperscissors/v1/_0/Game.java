package io.github.henryssondaniel.rockpaperscissors.v1._0;

import java.util.UUID;

interface Game {
  String getName();

  State getState();

  UUID getUuid();
}
