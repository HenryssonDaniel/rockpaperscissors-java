package io.github.henryssondaniel.rockpaperscissors.v1._0;

import java.util.UUID;

class GameImpl implements Game {
  private final String name;
  private final UUID uuid = UUID.randomUUID();

  private State state = State.WAITING_JOIN;

  GameImpl(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof String && uuid.toString().equals(obj);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public State getState() {
    return state;
  }

  @Override
  public UUID getUuid() {
    return uuid;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
