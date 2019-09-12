package io.github.henryssondaniel.rockpaperscissors.v1._0;

import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;

class GameImpl implements Game {
  private final Collection<Player> players = new HashSet<>(2);
  private final UUID uuid = UUID.randomUUID();

  GameImpl(String name) {
    players.add(new PlayerImpl(name));
  }

  @Override
  public String getState() {
    String message;

    if (players.size() == 1) message = "Waiting for the second player to join the game.";
    else {
      var iterator = players.iterator();
      var player1 = iterator.next();
      var player2 = iterator.next();

      var hand1 = player1.getHand();
      var hand2 = player2.getHand();

      message =
          hand1 == null || hand2 == null
              ? getState(player1, player2)
              : player1.getName()
                  + ": "
                  + hand1
                  + ". "
                  + player2.getName()
                  + ": "
                  + hand2
                  + ". "
                  + getWinner(player1, player2, hand1, hand2);
    }

    return message;
  }

  @Override
  public UUID getUuid() {
    return uuid;
  }

  @Override
  public String join(String name) {
    String message;

    if (players.stream().anyMatch(player -> player.getName().equals(name)))
      message = "The name is already taken. Please choose another name and join the game again.";
    else {
      players.add(new PlayerImpl(name));
      message = "OK";
    }

    return message;
  }

  @Override
  public String move(String move, String name) {
    String message;

    var player =
        players.stream().filter(player1 -> player1.getName().equals(name)).findFirst().orElse(null);

    if (player == null) message = "The name does not exist in this game.";
    else if (player.getHand() == null)
      try {
        player.setHand(Hand.valueOf(move.toUpperCase(Locale.getDefault())));
        message = "OK";
      } catch (IllegalArgumentException ignored) {
        message = "The move is not valid.";
      }
    else message = "A move is already done for this player.";

    return message;
  }

  private static Player getPlayer(Player player1, Player player2) {
    return player1.getHand() == null ? player1 : player2;
  }

  private static String getState(Player player1, Player player2) {
    return player1.getHand() == null && player2.getHand() == null
        ? "None of the player has done a move yet."
        : "Waiting for " + getPlayer(player1, player2).getName() + " to make a move.";
  }

  private static String getWinner(Player player1, Player player2, Hand hand1, Hand hand2) {
    return hand1 == hand2
        ? "It's a tie!"
        : "The winner is: " + getWinningPlayer(player1, player2, hand1, hand2).getName();
  }

  private static Player getWinningPlayer(Player player1, Player player2, Hand hand1, Hand hand2) {
    return hand1 == Hand.PAPER && hand2 == Hand.ROCK || isBeatRockOrPaper(hand1, hand2)
        ? player1
        : player2;
  }

  private static boolean isBeatPaper(Hand hand1, Hand hand2) {
    return hand1 == Hand.SCISSORS && hand2 == Hand.PAPER;
  }

  private static boolean isBeatRockOrPaper(Hand hand1, Hand hand2) {
    return hand1 == Hand.ROCK && hand2 == Hand.SCISSORS || isBeatPaper(hand1, hand2);
  }
}
