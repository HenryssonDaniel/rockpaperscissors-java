package io.github.henryssondaniel.rockpaperscissors.v1._0;

/** Player implementation. Does not contain any logic, just setters and getters. */
class PlayerImpl implements Player {
  private final String name;
  private Hand hand;

  PlayerImpl(String name) {
    this.name = name;
  }

  @Override
  public Hand getHand() {
    return hand;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setHand(Hand hand) {
    this.hand = hand;
  }
}
