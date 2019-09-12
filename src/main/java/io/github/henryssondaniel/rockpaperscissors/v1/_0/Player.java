package io.github.henryssondaniel.rockpaperscissors.v1._0;

/** Contains player data. */
interface Player {
  /**
   * Returns the hand, if no hand is yet set, null is returned.
   *
   * @return the hand
   */
  Hand getHand();

  /**
   * Returns the name.
   *
   * @return the name
   */
  String getName();

  /**
   * Sets the hand.
   *
   * @param hand the hand
   */
  void setHand(Hand hand);
}
