package io.github.henryssondaniel.rockpaperscissors.v1._0;

import java.util.UUID;

/**
 * The interface for the game. This is the interface that the GameResource will use to interact with
 * the game.
 */
interface Game {
  /**
   * Returns the state.
   *
   * @return the state
   */
  String getState();

  /**
   * Returns the UUID.
   *
   * @return the UUID
   */
  UUID getUuid();

  /**
   * Join the game with a name. The same name can not be used multiple times in the same game.
   *
   * @param name the name
   * @return the response message
   */
  String join(String name);

  /**
   * Make a move. If the name or ove does not exist, an error message will be returned. The same
   * player can only perform one move each game.
   *
   * @param move the move
   * @param name the name
   * @return the response message
   */
  String move(String move, String name);
}
